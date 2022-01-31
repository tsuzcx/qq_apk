import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aadw
  implements Runnable
{
  public aadw(ScanEntranceReport paramScanEntranceReport, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.a(BaseApplication.getContext()).a("", "scanner_ar_cloud_first_result", this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aadw
 * JD-Core Version:    0.7.0.1
 */