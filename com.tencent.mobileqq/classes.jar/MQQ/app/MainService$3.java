package mqq.app;

import com.tencent.mobileqq.msf.sdk.handler.IMsfMsgHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

class MainService$3
  implements IMsfMsgHandler
{
  MainService$3(MainService paramMainService) {}
  
  public void onRecvResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.MainService.3
 * JD-Core Version:    0.7.0.1
 */