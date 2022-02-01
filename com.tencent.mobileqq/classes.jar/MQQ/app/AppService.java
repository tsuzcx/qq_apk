package mqq.app;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class AppService
  extends Service
{
  protected static final int CONFIG_NEED_RUNTIME = 0;
  protected static final int CONFIG_NO_NEED_RUNTIME = 1;
  protected AppRuntime app;
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 2);
    return super.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public String getModuleId()
  {
    return null;
  }
  
  public void onAccountChanged() {}
  
  public void onAccoutChangeFailed() {}
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  protected int onConfigRuntime()
  {
    return 0;
  }
  
  public void onConfigStartMode(Intent paramIntent) {}
  
  public void onCreate()
  {
    super.onCreate();
    Intent localIntent = new Intent();
    onConfigStartMode(localIntent);
    MobileQQ.sMobileQQ.onActivityCreate(this, localIntent);
    if (onConfigRuntime() == 0) {
      this.app = MobileQQ.getMobileQQ().waitAppRuntime(null).getAppRuntime(getModuleId());
    }
    MobileQQ.sMobileQQ.appServices.add(new WeakReference(this));
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void sendBroadcast(Intent paramIntent)
  {
    super.sendBroadcast(paramIntent);
    MobileQQ.sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    super.sendBroadcast(paramIntent, paramString);
    MobileQQ.sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    super.sendOrderedBroadcast(paramIntent, paramString);
    MobileQQ.sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    super.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
    MobileQQ.sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void setAppRuntime(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime.getAppRuntime(getModuleId());
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      FileProvider7Helper.intentCompatForN(this, paramIntent);
    }
    catch (Exception localException)
    {
      QLog.e("AppService", 1, "startActivity", localException);
    }
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 0);
    super.startActivity(paramIntent);
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 1);
    return super.startService(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.AppService
 * JD-Core Version:    0.7.0.1
 */