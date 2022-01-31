import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;

public class aifz
  implements Runnable
{
  public aifz(StatisticCollector paramStatisticCollector) {}
  
  public void run()
  {
    int i = StatisticCollector.a();
    Object localObject1;
    if (i > 0)
    {
      localObject1 = BaseApplicationImpl.sApplication;
      if (localObject1 == null) {}
    }
    try
    {
      localObject1 = ((Context)localObject1).getPackageManager().getPackageInfo(((Context)localObject1).getPackageName(), 0);
      if ((localObject1 != null) && (((PackageInfo)localObject1).versionName != null))
      {
        localObject1 = ((PackageInfo)localObject1).versionName + "." + (((PackageInfo)localObject1).versionCode + i);
        CrashReport.setProductVersion(BaseApplicationImpl.getApplication(), (String)localObject1);
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        QLog.w("StatisticCollector", 1, "", localNameNotFoundException);
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aifz
 * JD-Core Version:    0.7.0.1
 */