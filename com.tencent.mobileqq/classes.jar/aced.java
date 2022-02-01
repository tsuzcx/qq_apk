import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aced
  implements INetEventHandler
{
  public static int a;
  private static aced jdField_a_of_type_Aced;
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public static boolean a;
  public static boolean b;
  boolean c = false;
  boolean d = false;
  
  static
  {
    jdField_a_of_type_Int = 100;
  }
  
  public static void a()
  {
    bize.c("GameCenterBroadcastReceiver", "registerReceiver");
    if (jdField_a_of_type_Aced == null) {
      jdField_a_of_type_Aced = new aced();
    }
    if (jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      jdField_a_of_type_AndroidContentBroadcastReceiver = new acee();
    }
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      AppNetConnInfo.registerNetChangeReceiver(BaseApplicationImpl.getApplication(), jdField_a_of_type_Aced);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      BaseApplicationImpl.getContext().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      bize.a("GameCenterBroadcastReceiver", "registerReceiver exception", localThrowable);
    }
  }
  
  public static void b()
  {
    bize.c("GameCenterBroadcastReceiver", "unRegisterReceiver");
    try
    {
      if (jdField_a_of_type_Aced != null)
      {
        AppNetConnInfo.unregisterNetEventHandler(jdField_a_of_type_Aced);
        jdField_a_of_type_Aced = null;
      }
      if (jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver);
        jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        bize.a("GameCenterBroadcastReceiver", "unRegisterReceiver exception", localThrowable);
        jdField_a_of_type_Aced = null;
        jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
    }
    finally
    {
      jdField_a_of_type_Aced = null;
      jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    jdField_a_of_type_Boolean = false;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.i("GameCenterBroadcastReceiver", 2, "no net");
      }
    }
    do
    {
      return;
      if (!AppNetConnInfo.isMobileConn()) {
        break;
      }
    } while (this.d);
    if (QLog.isColorLevel()) {
      QLog.i("GameCenterBroadcastReceiver", 2, "mobile connect");
    }
    for (;;)
    {
      this.c = false;
      return;
      if (AppNetConnInfo.isWifiConn())
      {
        if (this.c) {
          break;
        }
        this.c = true;
        if (QLog.isColorLevel()) {
          QLog.i("GameCenterBroadcastReceiver", 2, "wifi connect");
        }
        GameCenterCheck.a();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameCenterBroadcastReceiver", 2, "no connect");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aced
 * JD-Core Version:    0.7.0.1
 */