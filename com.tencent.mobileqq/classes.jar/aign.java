import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.battery.BatteryLog;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class aign
  extends Handler
{
  public aign(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject3;
    Object localObject4;
    Object localObject2;
    if (paramMessage.what == 0)
    {
      if (BatteryLog.a() == null) {
        BatteryLog.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + "com.tencent.mobileqq".replace(".", File.separator) + "/battery/");
      }
      BatteryLog.b(BatteryLog.a() + BatteryLog.b() + "_" + BatteryLog.a() + ".log");
      BatteryLog.c(BatteryLog.a() + BatteryLog.b() + "_" + BatteryLog.a() + ".rpt");
      paramMessage = new File(BatteryLog.a());
      Object localObject1 = new File(BatteryLog.c());
      localObject3 = new File(BatteryLog.d());
      try
      {
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        if (((File)localObject3).exists()) {
          ((File)localObject3).delete();
        }
        if (!paramMessage.exists()) {
          paramMessage.mkdirs();
        }
        ((File)localObject1).createNewFile();
        BatteryLog.a(new BufferedWriter(new FileWriter((File)localObject1), 8192));
        ((File)localObject3).createNewFile();
        BatteryLog.b(new BufferedWriter(new FileWriter((File)localObject3), 8192));
        localObject1 = null;
        paramMessage = (Message)localObject1;
        try
        {
          localObject3 = BaseApplicationImpl.getApplication().getPackageManager();
          paramMessage = (Message)localObject1;
          localObject4 = ((PackageManager)localObject3).getPackageInfo("com.tencent.mobileqq", 128);
          paramMessage = (Message)localObject1;
          localObject1 = ((PackageInfo)localObject4).versionName + "." + ((PackageInfo)localObject4).versionCode;
          paramMessage = (Message)localObject1;
          localObject3 = ((PackageManager)localObject3).getApplicationInfo("com.tencent.mobileqq", 128).metaData.get("com.tencent.rdm.uuid").toString();
          paramMessage = (Message)localObject3;
          localObject3 = localObject1;
          localObject1 = paramMessage;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BatteryStats.Log", 2, "", localThrowable1);
            }
            localObject2 = null;
            localObject3 = paramMessage;
          }
        }
        BatteryLog.b(new Object[] { "header", localObject3, "351230", "pub", localObject1, Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT), Long.valueOf(BatteryLog.a()), "1.3" });
        return;
      }
      catch (Throwable paramMessage)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("BatteryStats.Log", 2, "", paramMessage);
    }
    else
    {
      int k;
      int i;
      int j;
      if (paramMessage.what == 2)
      {
        if (paramMessage.arg1 == 0)
        {
          localObject2 = BatteryLog.a();
          if (localObject2 != null)
          {
            localObject3 = BatteryLog.a();
            paramMessage = (Object[])paramMessage.obj;
            k = paramMessage.length;
            i = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (i >= k) {
              break label636;
            }
            localObject4 = paramMessage[i];
            int m;
            if (((localObject4 instanceof Object[])) || ((localObject4 instanceof String[])))
            {
              localObject4 = (Object[])localObject4;
              m = localObject4.length;
              j = 0;
            }
            for (;;)
            {
              if (j < m)
              {
                ((StringBuilder)localObject3).append(localObject4[j]);
                j += 1;
                continue;
                localObject2 = BatteryLog.b();
                break;
                ((StringBuilder)localObject3).append(localObject4).append("|");
              }
            }
            i += 1;
          }
          label636:
          ((StringBuilder)localObject3).append("\r\n");
          try
          {
            ((BufferedWriter)localObject2).write(((StringBuilder)localObject3).toString());
            ((BufferedWriter)localObject2).flush();
            return;
          }
          catch (Throwable paramMessage)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.d("BatteryStats.Log", 2, "", paramMessage);
        }
      }
      else if (paramMessage.what == 1)
      {
        if (BatteryLog.a() == null) {
          BatteryLog.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/mobileqq/battery/");
        }
        label822:
        for (;;)
        {
          try
          {
            localObject2 = new File(BatteryLog.a()).listFiles();
            k = localObject2.length;
            i = 0;
            if (i >= k) {
              break;
            }
            localObject3 = localObject2[i];
            try
            {
              long l = BatteryLog.a((File)localObject3);
              if ((l == -1L) || (l <= ((Long)paramMessage.obj).longValue())) {
                break label822;
              }
              j = 0;
              if (j != 0) {
                ((File)localObject3).delete();
              }
            }
            catch (Throwable localThrowable3)
            {
              try
              {
                ((File)localObject3).delete();
              }
              catch (Throwable localThrowable2) {}
              continue;
            }
            i += 1;
            continue;
            j = 1;
          }
          catch (Throwable paramMessage)
          {
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aign
 * JD-Core Version:    0.7.0.1
 */