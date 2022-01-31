import android.os.Build;
import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aahx
  implements Runnable
{
  public aahx(ARReport paramARReport, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (ARReport.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARReport, this.jdField_a_of_type_Long)) {
      localHashMap.put("total_render_all_time", String.valueOf(this.jdField_a_of_type_Long));
    }
    if (ARReport.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARReport, this.b)) {
      localHashMap.put("total_render_success_time", String.valueOf(this.b));
    }
    localHashMap.put("buildmodel", Build.MODEL);
    localHashMap.put("cpuNumber", String.valueOf(ARReport.a()));
    localHashMap.put("totalram", ARReport.a(BaseApplication.getContext()));
    localHashMap.put("cpuname", this.jdField_a_of_type_ComTencentMobileqqArArengineARReport.a());
    StatisticCollector.a(BaseApplication.getContext()).a("", "AndroidactARTotal", true, this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahx
 * JD-Core Version:    0.7.0.1
 */