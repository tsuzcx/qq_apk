package mqq.bean;

import com.tencent.qphone.base.remote.ToServiceMsg;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class OnLoginByGatewayParam
{
  public ErrMsg errMsg;
  public DevlockInfo info;
  public int seq;
  public ToServiceMsg to;
  public String uin;
  public WUserSigInfo userSigInfo;
  
  public OnLoginByGatewayParam(int paramInt, DevlockInfo paramDevlockInfo, ToServiceMsg paramToServiceMsg, WUserSigInfo paramWUserSigInfo, String paramString, ErrMsg paramErrMsg)
  {
    this.seq = paramInt;
    this.info = paramDevlockInfo;
    this.to = paramToServiceMsg;
    this.userSigInfo = paramWUserSigInfo;
    this.uin = paramString;
    this.errMsg = paramErrMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.bean.OnLoginByGatewayParam
 * JD-Core Version:    0.7.0.1
 */