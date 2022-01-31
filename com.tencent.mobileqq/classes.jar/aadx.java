import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aadx
  implements Runnable
{
  public aadx(ScanEntranceReport paramScanEntranceReport, int paramInt, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("neon_opened", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.a(BaseApplication.getContext()).a("", "scanner_ar_cloud_first_success", true, this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aadx
 * JD-Core Version:    0.7.0.1
 */