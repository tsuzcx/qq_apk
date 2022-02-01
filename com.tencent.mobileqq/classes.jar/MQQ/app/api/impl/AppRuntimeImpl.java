package mqq.app.api.impl;

import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IAppRuntime;
import mqq.app.api.SSORequest;
import mqq.app.api.SSOResultCallback;

public class AppRuntimeImpl
  implements IAppRuntime
{
  public String getAccount()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
  }
  
  public void sendReq(SSORequest paramSSORequest, SSOResultCallback paramSSOResultCallback)
  {
    new SSOChannel().doSendRequest(paramSSORequest, paramSSOResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.api.impl.AppRuntimeImpl
 * JD-Core Version:    0.7.0.1
 */