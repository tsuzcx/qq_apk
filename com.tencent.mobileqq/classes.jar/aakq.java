import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aakq
  implements Runnable
{
  public aakq(ScanEntranceReport paramScanEntranceReport, int paramInt1, int paramInt2, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("upload_count", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("zoom_count", String.valueOf(this.b));
    StatisticCollector.a(BaseApplication.getContext()).a("", "scanner_qr_success", true, this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakq
 * JD-Core Version:    0.7.0.1
 */