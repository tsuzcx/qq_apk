import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class abbh
  implements Runnable
{
  public abbh(ARMapActivity paramARMapActivity, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8) {}
  
  public void run()
  {
    if ((ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.jdField_a_of_type_Long)) && (ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.b)) && (ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.c)) && (ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.d)) && (ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.e)) && (ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.f)) && (ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.g)) && (ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity, this.h))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        QLog.d("ARMapActivity", 1, String.format("reportLoadTime mTimeStamp={%s}", new Object[] { ARMapActivity.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity) }));
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("loadingTime", String.valueOf(this.jdField_a_of_type_Long));
      localHashMap.put("locationTime", String.valueOf(this.b));
      localHashMap.put("requestInfoTime", String.valueOf(this.c));
      localHashMap.put("resCheckTime", String.valueOf(this.d));
      localHashMap.put("soCheckTime", String.valueOf(this.e));
      localHashMap.put("startThreadTime", String.valueOf(this.f));
      localHashMap.put("launchARMapTime", String.valueOf(this.g));
      localHashMap.put("loadMapTime", String.valueOf(this.h));
      StatisticCollector.a(BaseApplication.getContext()).a("", "REPORT_TAG_LOADING_TIME", bool, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbh
 * JD-Core Version:    0.7.0.1
 */