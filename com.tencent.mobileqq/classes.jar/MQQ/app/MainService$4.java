package mqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.IPushHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;
import mqq.observer.TicketObserver;

class MainService$4
  implements IPushHandler
{
  MainService$4(MainService paramMainService) {}
  
  public void onOverloadPushNotify(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("overload push notify, msg: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("mqq", 1, ((StringBuilder)localObject).toString());
    if (MainService.access$000(this.this$0) != null)
    {
      localObject = MainService.access$000(this.this$0).waitAppRuntime(null);
      if (localObject != null)
      {
        ((AppRuntime)localObject).runOnUiThread(new MainService.4.1(this, paramString));
        return;
      }
      QLog.d("mqq", 1, "overload push notify fail, app is null");
    }
  }
  
  public void onProxyIpChanged(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("proxy ip changed, uin: ");
    ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramString));
    QLog.d("mqq", 1, ((StringBuilder)localObject).toString());
    if (MainService.access$000(this.this$0) != null)
    {
      localObject = MainService.access$000(this.this$0).waitAppRuntime(null);
      if (localObject != null) {
        ((ProxyIpManager)((AppRuntime)localObject).getManager(3)).reloadCache(paramString, false);
      }
    }
  }
  
  public void onRecvCmdPush(FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, null, paramFromServiceMsg);
  }
  
  public void onRegisterCmdPushResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onRegisterPushResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onResetCmdPushResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void onTicketChanged(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    if (paramFromServiceMsg != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ticket changed by uin: ");
      ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
      QLog.d("mqq", 1, ((StringBuilder)localObject).toString());
    }
    if (MainService.access$000(this.this$0) != null)
    {
      localObject = MainService.access$000(this.this$0).waitAppRuntime(null);
      if (localObject != null)
      {
        ((TicketManager)((AppRuntime)localObject).getManager(2)).reloadCache(MainService.access$000(this.this$0));
        if (paramFromServiceMsg != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("uin", paramFromServiceMsg.getUin());
          ((AppRuntime)localObject).notifyObservers(TicketObserver.class, 0, true, localBundle);
        }
      }
    }
  }
  
  public void onUnRegisterPushResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.MainService.4
 * JD-Core Version:    0.7.0.1
 */