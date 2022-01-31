import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import java.util.HashMap;

public class aiem
  implements Runnable
{
  public aiem(StartupDirector paramStartupDirector, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {}
  
  public void run()
  {
    Object localObject;
    QQAppInterface localQQAppInterface;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (this.jdField_a_of_type_Long > 0L) {
        StatisticCollector.a(BaseApplicationImpl.sApplication).a(null, "actLoginA", true, this.jdField_a_of_type_Long, 0L, null, null);
      }
      if (this.b > 0L)
      {
        localObject = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject != null) && ((localObject instanceof QQAppInterface)))
        {
          localQQAppInterface = (QQAppInterface)localObject;
          if (this.b != 2201L) {
            break label368;
          }
          localObject = "1";
          ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80064F6", "0X80064F6", 0, 0, (String)localObject, "", "", "");
        }
      }
      if (this.c > 0L)
      {
        Log.i("AutoMonitor", "ActionLoginM, cost=" + this.d);
        localObject = new HashMap();
        ((HashMap)localObject).put("cost", this.d + "");
        StatisticCollector.a(BaseApplicationImpl.sApplication).a(null, "actLoginM", true, this.d, 0L, (HashMap)localObject, null);
      }
      if ((this.e > 0L) && (this.f < 30000L))
      {
        Log.i("AutoMonitor", "ActionLoginS, cost=" + this.f);
        localObject = new HashMap();
        ((HashMap)localObject).put("cost", this.f + "");
        StatisticCollector.a(BaseApplicationImpl.sApplication).a(null, "actLoginS", true, this.f, 0L, (HashMap)localObject, null);
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localQQAppInterface != null) {
        break label391;
      }
      localObject = "0";
    }
    for (;;)
    {
      ReportController.a(localQQAppInterface, "P_CliOper", "Vip_login_upload", "", "upload", "report", 0, 0, AppSetting.a(BaseApplicationImpl.sApplication, (String)localObject), "", "", "");
      if ("Success".equals(BaseApplicationImpl.sInjectResult)) {
        UnifiedMonitor.a().a();
      }
      return;
      label368:
      if (this.b == 2200L)
      {
        localObject = "3";
        break;
      }
      localObject = "2";
      break;
      label391:
      localObject = localQQAppInterface.getAccount();
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        localObject = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aiem
 * JD-Core Version:    0.7.0.1
 */