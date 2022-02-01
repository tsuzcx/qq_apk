package mqq.app;

import com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;

class MainService$9
  implements IServerMsgPushHandler
{
  MainService$9(MainService paramMainService) {}
  
  public void onConnClose(FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, null, paramFromServiceMsg);
  }
  
  public void onConnOpened(FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, null, paramFromServiceMsg);
  }
  
  public void onOpenConnAllFailed(FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, null, paramFromServiceMsg);
  }
  
  public void onReceFirstResp(FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, null, paramFromServiceMsg);
  }
  
  public void onRecvServerConfigPush(FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, null, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.MainService.9
 * JD-Core Version:    0.7.0.1
 */