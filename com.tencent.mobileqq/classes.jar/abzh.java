import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class abzh
{
  private static Map<String, abwv> a;
  
  public static Map<String, abwv> a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(abzg.a());
        localHashMap.put("config", new abwv("config", 3, 0, abzc.class));
        localHashMap.put("setShareInfo", new abwv("setShareInfo", 25, 0, abzd.class));
        localHashMap.put("closeWebview", new abwv("closeWebview", 2, 0, abzd.class));
        localHashMap.put("refreshTitle", new abwv("refreshTitle", 22, 0, abzd.class));
        localHashMap.put("setShareListener", new abwv("setShareListener", 26, 0, abzd.class));
        localHashMap.put("lightappGetSDKVersion", new abwv("lightappGetSDKVersion", 13, 0, anpq.class));
        localHashMap.put("lightappShareCallback", new abwv("lightappShareCallback", 15, 0, anpq.class));
        localHashMap.put("lightappShareMessage", new abwv("lightappShareMessage", 16, 0, anpq.class));
        localHashMap.put("lightappOpenApp", new abwv("lightappOpenApp", 14, 0, anpq.class));
        localHashMap.put("lightappDisableLongPress", new abwv("lightappDisableLongPress", 11, 0, anpq.class));
        localHashMap.put("lightappDisableWebViewLongPress", new abwv("lightappDisableWebViewLongPress", 12, 0, anpq.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzh
 * JD-Core Version:    0.7.0.1
 */