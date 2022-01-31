import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.huayang.HuayangCrashReport;
import com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.HuayangPluginLauncherListener;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.huayang.MonitorConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aecp
  implements Handler.Callback
{
  public aecp(HuayangPluginLauncher paramHuayangPluginLauncher) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = HuayangPluginLauncher.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HuayangPluginLauncher.HuayangPluginLauncherListener)((Iterator)localObject).next()).a(paramMessage.arg1);
      }
      localObject = HuayangPluginLauncher.a(this.a).iterator();
      if (((Iterator)localObject).hasNext())
      {
        HuayangPluginLauncher.HuayangPluginLauncherListener localHuayangPluginLauncherListener = (HuayangPluginLauncher.HuayangPluginLauncherListener)((Iterator)localObject).next();
        if (paramMessage.arg1 == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localHuayangPluginLauncherListener.a(bool, (Throwable)paramMessage.obj);
          break;
        }
      }
      localObject = new Intent(HuayangJsPlugin.a(HuayangPluginLauncher.a(this.a).c));
      if (paramMessage.arg1 == 0)
      {
        if (HuayangJsPlugin.a(HuayangPluginLauncher.a(this.a).c)) {}
        for (int i = 9;; i = 8)
        {
          ((Intent)localObject).putExtra("key_state", i);
          HuayangPluginLauncher.a(this.a).sendBroadcast((Intent)localObject);
          if (MonitorConfig.a.get(HuayangPluginLauncher.a(this.a)) == null) {
            break;
          }
          Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.a.get(HuayangPluginLauncher.a(this.a))).f));
          return false;
        }
      }
      if (HuayangJsPlugin.a(HuayangPluginLauncher.a(this.a).c)) {
        Monitor.a("2691708");
      }
      for (;;)
      {
        HuayangCrashReport.a((Throwable)paramMessage.obj);
        ((Intent)localObject).putExtra("key_state", 7);
        HuayangPluginLauncher.a(this.a).sendBroadcast((Intent)localObject);
        return false;
        if (HuayangJsPlugin.b(HuayangPluginLauncher.a(this.a).c)) {
          Monitor.a("2597726");
        } else if (MonitorConfig.a.get(HuayangPluginLauncher.a(this.a)) != null) {
          Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.a.get(HuayangPluginLauncher.a(this.a))).e));
        }
      }
      paramMessage = new Intent(HuayangJsPlugin.a(HuayangPluginLauncher.a(this.a).c));
      paramMessage.putExtra("key_state", 6);
      HuayangPluginLauncher.a(this.a).sendBroadcast(paramMessage);
    } while (MonitorConfig.a.get(HuayangPluginLauncher.a(this.a)) == null);
    Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.a.get(HuayangPluginLauncher.a(this.a))).d));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecp
 * JD-Core Version:    0.7.0.1
 */