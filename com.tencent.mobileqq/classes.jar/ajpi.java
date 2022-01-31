import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.ServerConfigManager.ConfigType;

public final class ajpi
  extends AsyncTask
{
  public ajpi(String paramString1, int paramInt, String paramString2) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = QQUtils.a(ServerConfigManager.ConfigType.common, PerformanceReportUtils.p());
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportFPS openStr ：" + paramVarArgs);
    }
    if ((paramVarArgs == null) || (!"1".equals(paramVarArgs))) {
      return null;
    }
    int i;
    for (;;)
    {
      try
      {
        localSharedPreferences = PerformanceReportUtils.a();
        if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_Int <= 0)) {
          break label620;
        }
        if ((this.jdField_a_of_type_Int >= 60) && (QLog.isDevelopLevel())) {
          QLog.e("PerformanceReportUtils", 4, "reportFPS  fps error fpsvalue :" + this.jdField_a_of_type_Int);
        }
        l2 = localSharedPreferences.getLong(this.jdField_a_of_type_JavaLangString, 0L);
        l1 = PerformanceReportUtils.a();
        paramVarArgs = QQUtils.a(ServerConfigManager.ConfigType.common, PerformanceReportUtils.q());
        if (paramVarArgs == null) {}
      }
      catch (Exception paramVarArgs)
      {
        SharedPreferences localSharedPreferences;
        long l2;
        long l1;
        HashMap localHashMap;
        BaseApplicationImpl localBaseApplicationImpl;
        break label620;
        i = 1;
        continue;
      }
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PerformanceReportUtils", 4, "reportFPS  server time：" + paramVarArgs);
        }
        l1 = Long.valueOf(paramVarArgs).longValue();
        l1 *= 1000L;
      }
      catch (Exception paramVarArgs)
      {
        l1 = PerformanceReportUtils.a();
        continue;
        paramVarArgs = this.jdField_a_of_type_JavaLangString + "_new";
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportFPS report_time ：" + l1 + ",lastRp" + l2 + ",reportFPS fpsvalue：" + this.jdField_a_of_type_Int);
    }
    if ((l2 != 0L) && (SystemClock.uptimeMillis() >= l2))
    {
      if (SystemClock.uptimeMillis() - l2 < l1) {
        break label622;
      }
      break label615;
      bool = UnifiedMonitor.a().whetherReportThisTime(12, false);
      if ((i == 0) && (!bool)) {
        break label620;
      }
      localHashMap = new HashMap();
      localHashMap.put("param_FPS", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("aioBusiness", this.b);
      localHashMap.put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
      if (QLog.isDevelopLevel()) {
        QLog.d("PerformanceReportUtils", 4, "reportFPS real report  fpsvalue：" + this.jdField_a_of_type_Int);
      }
      localHashMap.put("param_DeviceType", String.valueOf(StatisticConstants.a()));
      paramVarArgs = null;
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if (localBaseApplicationImpl != null) {
        paramVarArgs = localBaseApplicationImpl.getRuntime();
      }
      if ((paramVarArgs != null) && ((paramVarArgs instanceof QQAppInterface)))
      {
        if (((QQAppInterface)paramVarArgs).a.a == 0L) {
          break label627;
        }
        bool = true;
        label446:
        localHashMap.put("param_is_logining", String.valueOf(bool));
        if (((QQAppInterface)paramVarArgs).a.c()) {
          break label633;
        }
      }
    }
    label615:
    label620:
    label622:
    label627:
    label633:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("param_syncing_msg", String.valueOf(bool));
      localHashMap.put("param_NetType", String.valueOf(NetworkUtil.a(BaseApplication.getContext())));
      if (i != 0)
      {
        paramVarArgs = this.jdField_a_of_type_JavaLangString;
        StatisticCollector.a(BaseApplication.getContext()).a(QQUtils.a(), paramVarArgs, PerformanceReportUtils.a(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int, 0L, localHashMap, PerformanceReportUtils.o());
        if (i == 0) {
          break label620;
        }
        localSharedPreferences.edit().putLong(this.jdField_a_of_type_JavaLangString, SystemClock.uptimeMillis()).commit();
      }
      return null;
      i = 0;
      break;
      bool = false;
      break label446;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ajpi
 * JD-Core Version:    0.7.0.1
 */