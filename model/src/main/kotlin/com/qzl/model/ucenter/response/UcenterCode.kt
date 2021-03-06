package com.qzl.model.ucenter.response

import com.google.common.collect.ImmutableMap
import com.qzl.common.model.response.ResultCode
import io.swagger.annotations.ApiModelProperty


/**
 * Created by admin on 2018/3/5.
 */
enum class UcenterCode private constructor(//操作代码
        @field:ApiModelProperty(value = "操作是否成功", example = "true", required = true)
        internal var success: Boolean, //操作代码
        @field:ApiModelProperty(value = "操作代码", example = "22001", required = true)
        internal var code: Int, //提示信息
        @field:ApiModelProperty(value = "操作提示", example = "操作过于频繁！", required = true)
        internal var message: String) : ResultCode {
    UCENTER_USERNAME_NONE(false, 23001, "请输入账号！"),
    UCENTER_PASSWORD_NONE(false, 23002, "请输入密码！"),
    UCENTER_VERIFYCODE_NONE(false, 23003, "请输入验证码！"),
    UCENTER_ACCOUNT_NOTEXISTS(false, 23004, "账号不存在！"),
    UCENTER_CREDENTIAL_ERROR(false, 23005, "账号或密码错误！"),
    UCENTER_LOGIN_ERROR(false, 23006, "登陆过程出现异常请尝试重新操作！");

    override fun success(): Boolean {
        return success
    }

    override fun code(): Int {
        return code
    }

    override fun message(): String {
        return message
    }

    companion object {
        private val CACHE: ImmutableMap<Int, UcenterCode>

        init {
            val builder = ImmutableMap.builder<Int, UcenterCode>()
            for (commonCode in values()) {
                builder.put(commonCode.code(), commonCode)
            }
            CACHE = builder.build()
        }
    }
}
