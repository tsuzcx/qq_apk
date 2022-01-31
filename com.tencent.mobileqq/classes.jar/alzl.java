import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import java.util.HashMap;

public class alzl
  implements Runnable
{
  public alzl(ProfilePerformanceReport paramProfilePerformanceReport, String paramString, long paramLong, HashMap paramHashMap) {}
  
  public void run()
  {
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_JavaLangString, ProfilePerformanceReport.a(this.jdField_a_of_type_ComTencentUtilProfilePerformanceReport), true, this.jdField_a_of_type_Long, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    if (QLog.isDevelopLevel()) {
      QLog.i("ProfilePerformanceReport", 4, "end of report");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alzl
 * JD-Core Version:    0.7.0.1
 */