import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.1;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.2;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.3;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.4;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.5;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.6;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class alor
  implements INetInfoHandler
{
  alor(alop paramalop) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetMobile2None mLastNetType=" + alop.b(this.a));
    }
    ArkAppCenter.a().post(alop.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.6(this));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetMobile2Wifi mLastNetType=" + alop.b(this.a));
    }
    ArkAppCenter.a().post(alop.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.5(this));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetNone2Mobile mLastNetType=" + alop.b(this.a));
    }
    ArkAppCenter.a().post(alop.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.4(this));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetNone2Wifi mLastNetType=" + alop.b(this.a));
    }
    ArkAppCenter.a().post(alop.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.3(this));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetWifi2Mobile mLastNetType=" + alop.b(this.a));
    }
    ArkAppCenter.a().post(alop.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.2(this));
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetWifi2None mLastNetType=" + alop.b(this.a));
    }
    ArkAppCenter.a().post(alop.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alor
 * JD-Core Version:    0.7.0.1
 */