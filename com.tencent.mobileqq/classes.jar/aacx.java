import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aacx
  implements Runnable
{
  public aacx(ARReport paramARReport, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("alltime", String.valueOf(this.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_Boolean) {
      localHashMap.put("result", "0");
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).a("", "ARNativeBridgeSo", true, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("result", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aacx
 * JD-Core Version:    0.7.0.1
 */