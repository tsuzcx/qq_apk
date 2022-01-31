import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.app.ProcessStats;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.ServerConfigManager.ConfigType;

public final class akdo
  implements Runnable
{
  public akdo(int paramInt, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject = QQUtils.a(ServerConfigManager.ConfigType.common, PerformanceReportUtils.b());
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportUISwitch openStr ：" + (String)localObject);
    }
    if ((localObject == null) || (!"1".equals(localObject))) {
      return;
    }
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_Int == 10))
        {
          if (QQAppInterface.b)
          {
            i = 0;
            localHashMap.put("actloginTypt", String.valueOf(i));
            localHashMap.put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
            if ((!QQAppInterface.b) && (this.jdField_a_of_type_Int != 10))
            {
              QQAppInterface.b = true;
              localHashMap.put("aio_preloaded", String.valueOf(AIOPreLoadEngine.jdField_a_of_type_Int));
            }
            localObject = BaseApplicationImpl.getApplication().getRuntime();
            if ((localObject != null) && ((localObject instanceof QQAppInterface)))
            {
              if (((QQAppInterface)localObject).a.jdField_a_of_type_Long == 0L) {
                break label799;
              }
              bool = true;
              localHashMap.put("param_is_logining", String.valueOf(bool));
              if (((QQAppInterface)localObject).a.c()) {
                break label804;
              }
              bool = true;
              localHashMap.put("param_syncing_msg", String.valueOf(bool));
              localHashMap.put("inActionLoginB", String.valueOf(((QQAppInterface)localObject).a.a()));
            }
            localHashMap.put("param_cpu_core_num", String.valueOf(ProcessStats.a()));
            localHashMap.put("param_ram", String.valueOf(DeviceInfoUtil.e()));
          }
        }
        else
        {
          localObject = null;
          SharedPreferences localSharedPreferences;
          long l2;
          long l1;
          String str;
          switch (this.jdField_a_of_type_Int)
          {
          case 0: 
            localSharedPreferences = PerformanceReportUtils.a();
            if ((localObject == null) || (this.jdField_a_of_type_Long <= 0L)) {
              break;
            }
            l2 = localSharedPreferences.getLong((String)localObject, 0L);
            l1 = PerformanceReportUtils.a();
            str = QQUtils.a(ServerConfigManager.ConfigType.common, PerformanceReportUtils.n());
            if (str != null) {
              if (QLog.isDevelopLevel()) {
                QLog.d("PerformanceReportUtils", 4, "reportUISwitch  server time：" + str);
              }
            }
          case 1: 
          case 3000: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
            try
            {
              l1 = Long.valueOf(str).longValue();
              l1 *= 1000L;
            }
            catch (Exception localException2)
            {
              l1 = PerformanceReportUtils.a();
              continue;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("PerformanceReportUtils", 4, "reportUISwitch report_time ：" + l1 + ",lastRp" + l2 + ",aioBusiness=" + PerformanceReportUtils.a());
            }
            if ((l2 != 0L) && (SystemClock.uptimeMillis() >= l2) && (SystemClock.uptimeMillis() - l2 < l1)) {
              break;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("PerformanceReportUtils", 4, "reportUISwitch timeConsumed ：" + this.jdField_a_of_type_Long + ",aioBusiness=" + PerformanceReportUtils.a());
            }
            localHashMap.put("aioBusiness", PerformanceReportUtils.a());
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_JavaLangString, (String)localObject, true, this.jdField_a_of_type_Long, 0L, localHashMap, PerformanceReportUtils.o());
            localSharedPreferences.edit().putLong((String)localObject, SystemClock.uptimeMillis()).commit();
            return;
            localObject = PerformanceReportUtils.c();
            continue;
            localObject = PerformanceReportUtils.d();
            continue;
            localObject = PerformanceReportUtils.e();
            continue;
            localObject = PerformanceReportUtils.f();
            continue;
            localObject = PerformanceReportUtils.g();
            continue;
            localObject = PerformanceReportUtils.h();
            continue;
            localObject = PerformanceReportUtils.i();
            continue;
            localObject = PerformanceReportUtils.j();
            continue;
            localObject = PerformanceReportUtils.k();
            continue;
            localObject = PerformanceReportUtils.l();
            continue;
            localObject = PerformanceReportUtils.m();
            break;
          }
        }
        int i = 1;
      }
      catch (Exception localException1)
      {
        return;
      }
      continue;
      label799:
      boolean bool = false;
      continue;
      label804:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akdo
 * JD-Core Version:    0.7.0.1
 */