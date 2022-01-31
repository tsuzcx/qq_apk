import com.tencent.mobileqq.ar.ARRecord.ARRecordReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aaej
  implements Runnable
{
  public aaej(ARRecordReport paramARRecordReport) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.a(BaseApplication.getContext()).a("", "ar_record_pre_record_start", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaej
 * JD-Core Version:    0.7.0.1
 */