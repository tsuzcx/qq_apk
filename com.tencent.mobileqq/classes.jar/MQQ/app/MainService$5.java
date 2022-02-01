package mqq.app;

import com.tencent.mobileqq.msf.sdk.handler.INotifyHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

class MainService$5
  implements INotifyHandler
{
  MainService$5(MainService paramMainService) {}
  
  public void onRecvNotify(long paramLong, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, null, paramFromServiceMsg);
  }
  
  public void onRegisterNotifyResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void onUnRegisterNotifyResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.MainService.5
 * JD-Core Version:    0.7.0.1
 */