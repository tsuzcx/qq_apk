import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.qapmsdk.qqbattery.QQBatteryMonitor;
import com.tencent.qapmsdk.qqbattery.monitor.HookMethodCallback;
import com.tencent.qphone.base.util.QLog;

class acyo
  extends acyk
{
  public HookMethodCallback a()
  {
    return QQBatteryMonitor.getInstance().getWifiHook();
  }
  
  public void a()
  {
    try
    {
      JavaHookBridge.findAndHookMethod(WifiManager.class, "startScan", new Object[] { this });
      JavaHookBridge.findAndHookMethod(WifiManager.class, "createWifiLock", new Object[] { Integer.TYPE, String.class, this });
      JavaHookBridge.findAndHookMethod(WifiManager.class, "createWifiLock", new Object[] { String.class, this });
      JavaHookBridge.findAndHookMethod(WifiManager.WifiLock.class, "acquire", new Object[] { this });
      JavaHookBridge.findAndHookMethod(WifiManager.WifiLock.class, "release", new Object[] { this });
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MagnifierSDK.QAPM.QAPMBatteryWrapper", 2, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyo
 * JD-Core Version:    0.7.0.1
 */