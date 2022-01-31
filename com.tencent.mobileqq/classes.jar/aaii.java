import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aaii
  implements Runnable
{
  public aaii(ARReport paramARReport, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (ARReport.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARReport, this.jdField_a_of_type_Long)) {
      localHashMap.put("local_load_feature_time", String.valueOf(this.jdField_a_of_type_Long));
    }
    if (this.b > 0L) {
      localHashMap.put("local_load_feature_count", String.valueOf(this.b));
    }
    if (ARReport.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARReport, this.c)) {
      localHashMap.put("local_recognize_time", String.valueOf(this.c));
    }
    if (this.d > 0L) {
      localHashMap.put("local_recognize_times", String.valueOf(this.d));
    }
    if (this.e > 0L) {
      localHashMap.put("local_recognize_quality", String.valueOf(this.e));
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      localHashMap.put("local_recognize_featureid", this.jdField_a_of_type_JavaLangString);
    }
    StatisticCollector.a(BaseApplication.getContext()).a("", "AndroidactARLocal", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaii
 * JD-Core Version:    0.7.0.1
 */