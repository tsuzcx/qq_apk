import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class akhm
{
  private static akhm jdField_a_of_type_Akhm;
  private int jdField_a_of_type_Int = -2;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public static akhm a()
  {
    try
    {
      if (jdField_a_of_type_Akhm == null) {
        jdField_a_of_type_Akhm = new akhm();
      }
      akhm localakhm = jdField_a_of_type_Akhm;
      return localakhm;
    }
    finally {}
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    int i = 0;
    Object localObject2 = DeviceProfileManager.a();
    Object localObject1 = ((DeviceProfileManager)localObject2).a(DeviceProfileManager.DpcNames.qq_thread_config.name());
    if (QLog.isColorLevel()) {
      QLog.d("ThreadManager.Optimizer", 2, "config = " + (String)localObject1);
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      return;
      try
      {
        localObject1 = ((String)localObject1).split("\\|");
        if (localObject1.length >= 5)
        {
          float f = Float.parseFloat(localObject1[1]);
          if (((DeviceProfileManager)localObject2).jdField_a_of_type_Int * 1.0F / 10000.0F < f)
          {
            this.jdField_a_of_type_Int = Integer.valueOf(localObject1[0]).intValue();
            this.jdField_a_of_type_Boolean = "1".equals(localObject1[2]);
            this.b = "1".equals(localObject1[3]);
            this.c = "1".equals(localObject1[4]);
            if (localObject1.length > 5)
            {
              localObject2 = new File(BaseApplicationImpl.getContext().getFilesDir(), "disableSmallLock");
              if (!"1".equals(localObject1[5])) {
                break label507;
              }
              if (((File)localObject2).exists()) {
                ((File)localObject2).delete();
              }
            }
            label204:
            if (localObject1.length > 6)
            {
              if (!"1".equals(localObject1[6])) {
                break label516;
              }
              com.tencent.common.config.AppSetting.f = true;
            }
            label229:
            boolean bool1;
            boolean bool2;
            if (localObject1.length > 7)
            {
              localObject2 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
              bool1 = ((SharedPreferences)localObject2).getBoolean("enableUpdateIconStep", false);
              bool2 = "1".equals(localObject1[7]);
              if (bool1 != bool2) {
                ((SharedPreferences)localObject2).edit().putBoolean("enableUpdateIconStep", bool2).commit();
              }
            }
            if (localObject1.length > 8)
            {
              localObject2 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
              bool1 = ((SharedPreferences)localObject2).getBoolean("serializePreDownload", true);
              bool2 = "1".equals(localObject1[8]);
              if (bool1 != bool2) {
                ((SharedPreferences)localObject2).edit().putBoolean("serializePreDownload", bool2).commit();
              }
            }
            label373:
            if (!this.b) {
              if (!this.c) {
                continue;
              }
            }
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = Thread.currentThread().getThreadGroup();
          localObject2 = new Thread[((ThreadGroup)localObject1).activeCount()];
          ((ThreadGroup)localObject1).enumerate((Thread[])localObject2);
          int j = localObject2.length;
          label417:
          if (i < j)
          {
            Object localObject3 = localObject2[i];
            if (localObject3 != null)
            {
              if (localObject3.getName() == null) {
                break label523;
              }
              localObject1 = localObject3.getName();
              label448:
              if ((!this.b) || (!"MSF-Receiver".equals(localObject1))) {
                break label530;
              }
              localObject3.setPriority(1);
            }
            for (;;)
            {
              i += 1;
              break label417;
              this.jdField_a_of_type_Int = 0;
              break;
              localException1 = localException1;
              if (!QLog.isColorLevel()) {
                break label373;
              }
              QLog.d("ThreadManager.Optimizer", 2, "", localException1);
              break label373;
              label507:
              ((File)localObject2).createNewFile();
              break label204;
              com.tencent.common.config.AppSetting.f = false;
              break label229;
              String str = "";
              break label448;
              if ((this.c) && (("logWriteThread".equals(str)) || (str.startsWith("GlobalPool")) || (str.startsWith("Face")) || (str.startsWith("um-stack")) || (str.startsWith("QQ_FTS")) || (str.startsWith("httpcomm")))) {
                localObject3.setPriority(1);
              }
            }
          }
          label516:
          label523:
          label530:
          if (!this.c) {}
        }
        catch (Exception localException2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThreadManager.Optimizer", 2, "", localException2);
          }
        }
      }
    }
    ThreadManager.getSubThread().setPriority(1);
    ThreadManager.getFileThread().setPriority(1);
    ThreadManager.getRecentThreadLooper().getThread().setPriority(1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akhm
 * JD-Core Version:    0.7.0.1
 */