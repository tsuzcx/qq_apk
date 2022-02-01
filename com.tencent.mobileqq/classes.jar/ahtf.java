import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ahtf
{
  public static void a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("issuccess", String.valueOf(paramInt1));
    localHashMap.put("errorcode", String.valueOf(paramInt2));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pttSliceToText", true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    bcef.b(null, "dc00898", "", "", paramString, paramString, paramInt1, paramInt2, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtf
 * JD-Core Version:    0.7.0.1
 */