import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aakp
  implements Runnable
{
  public aakp(ScanEntranceReport paramScanEntranceReport, long paramLong, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("select_image_avg_time", String.valueOf(this.jdField_a_of_type_Long));
    StatisticCollector.a(BaseApplication.getContext()).a("", "scanner_ar_cloud_upload_count", true, this.jdField_a_of_type_Int, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakp
 * JD-Core Version:    0.7.0.1
 */