import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aaij
  implements Runnable
{
  public aaij(ARReport paramARReport, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("loadingtime", String.valueOf(this.jdField_a_of_type_Long));
    StatisticCollector.a(BaseApplication.getContext()).a("", "AndroidactARWebView", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaij
 * JD-Core Version:    0.7.0.1
 */