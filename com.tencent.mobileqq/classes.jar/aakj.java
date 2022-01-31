import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aakj
  implements Runnable
{
  public aakj(ScanEntranceReport paramScanEntranceReport, long paramLong1, int paramInt, String paramString, long paramLong2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("last_total_time", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("upload_count", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("session_ids", this.jdField_a_of_type_JavaLangString);
    StatisticCollector.a(BaseApplication.getContext()).a("", "scanner_first_ar_recog", true, this.b, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakj
 * JD-Core Version:    0.7.0.1
 */