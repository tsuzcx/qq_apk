import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aadu
  implements Runnable
{
  public aadu(ScanEntranceReport paramScanEntranceReport, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("first_init", String.valueOf(this.jdField_a_of_type_Boolean));
    localHashMap.put("bind_time", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("got_config_time", String.valueOf(this.b));
    localHashMap.put("resource_check_time", String.valueOf(this.c));
    localHashMap.put("dependence_wait_time", String.valueOf(this.d));
    StatisticCollector.a(BaseApplication.getContext()).a("", "scanner_ar_init_pre", true, this.e, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aadu
 * JD-Core Version:    0.7.0.1
 */