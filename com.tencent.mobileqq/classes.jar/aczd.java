import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.config.APMModuleConfig;
import com.tencent.mobileqq.startup.step.HackVm;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qapmsdk.memory.MemoryCeilingMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class aczd
  extends acyf
  implements acxy
{
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  
  static void c()
  {
    if (QLog.getUIN_REPORTLOG_LEVEL() < 2) {
      QLog.setUIN_REPORTLOG_LEVEL(2);
    }
  }
  
  public DumpResult a(String paramString, acyb paramacyb)
  {
    return MemoryCeilingMonitor.dumpHprof(paramString, new acze(this, paramacyb));
  }
  
  public String a()
  {
    return "ceilinghprof";
  }
  
  public void a()
  {
    QAPM.setProperty(111, new aczj());
  }
  
  public void a(acxw paramacxw)
  {
    aczc.a().a(paramacxw);
  }
  
  public void a(DumpResult paramDumpResult)
  {
    MemoryCeilingMonitor.reportHprofFile(paramDumpResult);
  }
  
  public String b()
  {
    return a().getOldStrategy("0|1;15|1|0|1|1|0.00001|0.1|1;4;85,5,0.7,0.2;80,15,0.9,0.4;75,30,1,0.7_0|1;15|2|0|0.5|1|0.00001|0.1|1;4;85,5,0.7,0.2;80,15,0.9,0.4;75,30,1,0.7_0|1;15|3|0|0.25|0|0.00001|0.1|3;4;85,5,0.7,0.2;80,15,0.9,0.4;75,30,1,0.7_0|1;15|4|0|0.5|0|0.00001|0.1|4;4;85,5,0.7,0.2;80,15,0.9,0.4;75,30,1,0.7");
  }
  
  public void b()
  {
    super.b();
    aczc.a().a();
  }
  
  public void b(acxw paramacxw)
  {
    aczc.a().b(paramacxw);
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder("RAM Info:all=");
    Object localObject = new DecimalFormat();
    ((DecimalFormat)localObject).applyPattern("0.0");
    try
    {
      long l1 = DeviceInfoUtil.getSystemTotalMemory() / 1024L / 1024L;
      long l2 = DeviceInfoUtil.getSystemAvaialbeMemory() / 1024L / 1024L;
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
      float f2 = -1.0F;
      float f1 = f2;
      if (arrayOfMemoryInfo != null)
      {
        f1 = f2;
        if (arrayOfMemoryInfo.length > 0) {
          f1 = arrayOfMemoryInfo[0].getTotalPss() / 1024.0F;
        }
      }
      f2 = (float)Runtime.getRuntime().freeMemory() / 1024.0F / 1024.0F;
      float f3 = (float)Runtime.getRuntime().totalMemory() / 1024.0F / 1024.0F;
      float f4 = (float)Runtime.getRuntime().maxMemory() / 1024.0F / 1024.0F;
      long l3 = HackVm.jdField_a_of_type_Long / 1024L / 1024L;
      localStringBuilder.append(l1).append("M,avaiable:").append(l2).append("M used:").append(((DecimalFormat)localObject).format(f1)).append("M freeMemory:").append(f2).append("M,appTotalMemory:").append(f3).append("M,orgMaxMemory:").append(l3).append("M,maxMemory:").append(f4).append("M, ImgCache:").append(BaseApplicationImpl.sImageCache.size() / 1024 / 1024).append("M,SkinCache:").append(SkinEngine.dumpDrawableCacheMemSize() / 1024L / 1024L).append("M,LeakMonitor=").append(MagnifierSDK.a().a().c());
      localObject = (ArrayList)aczc.jdField_a_of_type_JavaUtilArrayList.clone();
      if (((ArrayList)localObject).size() > 0)
      {
        localStringBuilder.append(",Leaked=[");
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localStringBuilder.append((String)((Iterator)localObject).next());
          localStringBuilder.append(",");
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable) {}
    for (;;)
    {
      localStringBuilder.append("]");
    }
  }
  
  public boolean c()
  {
    return aczc.a().jdField_a_of_type_Boolean;
  }
  
  public boolean d()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("memory_reporter_" + BaseApplicationImpl.sProcessId, 0);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_key_last_shot_time", 0L);
    if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) >= 86400000L)
    {
      if (a().canOpenPlugin())
      {
        c();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_key_last_shot_time", this.jdField_a_of_type_Long).putBoolean("key_need_report", true).commit();
        return true;
      }
    }
    else
    {
      c();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczd
 * JD-Core Version:    0.7.0.1
 */