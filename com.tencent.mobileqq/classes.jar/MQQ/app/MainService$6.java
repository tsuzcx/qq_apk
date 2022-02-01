package mqq.app;

import com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

class MainService$6
  implements IRegisterUinHandler
{
  MainService$6(MainService paramMainService) {}
  
  public void onCheckQuickRegisterResp(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onGetQuickRegisterResp(int paramInt, String paramString1, String paramString2, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onRegQueryAccountResp(int paramInt, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onRegisterCommitMobileResp(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onRegisterCommitPassResp(int paramInt, String paramString, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onRegisterCommitSmsCodeResp(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onRegisterQuerySmsStatResp(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onRegisterSendResendSmsreqResp(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.MainService.6
 * JD-Core Version:    0.7.0.1
 */