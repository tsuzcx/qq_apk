import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public final class abch
  implements Runnable
{
  public abch(String[] paramArrayOfString) {}
  
  public void run()
  {
    if (this.a == null) {}
    for (int i = 0;; i = this.a.length)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("preloadFileCount", String.valueOf(i));
      StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "ARMAP_OFFLINE_ENTER", true, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abch
 * JD-Core Version:    0.7.0.1
 */