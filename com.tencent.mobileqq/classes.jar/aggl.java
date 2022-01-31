import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.activity.ScanBaseActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class aggl
  implements Runnable
{
  public aggl(ScanBaseActivity paramScanBaseActivity) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(-1003));
    StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "ocr_entrance", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aggl
 * JD-Core Version:    0.7.0.1
 */