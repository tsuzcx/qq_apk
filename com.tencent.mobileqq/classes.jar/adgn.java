import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class adgn
{
  private static Map<String, adeb> a;
  
  public static Map<String, adeb> a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(adgm.a());
        localHashMap.put("config", new adeb("config", 3, 0, adgi.class));
        localHashMap.put("setShareInfo", new adeb("setShareInfo", 25, 0, adgj.class));
        localHashMap.put("closeWebview", new adeb("closeWebview", 2, 0, adgj.class));
        localHashMap.put("refreshTitle", new adeb("refreshTitle", 22, 0, adgj.class));
        localHashMap.put("setShareListener", new adeb("setShareListener", 26, 0, adgj.class));
        localHashMap.put("lightappGetSDKVersion", new adeb("lightappGetSDKVersion", 13, 0, appw.class));
        localHashMap.put("lightappShareCallback", new adeb("lightappShareCallback", 15, 0, appw.class));
        localHashMap.put("lightappShareMessage", new adeb("lightappShareMessage", 16, 0, appw.class));
        localHashMap.put("lightappOpenApp", new adeb("lightappOpenApp", 14, 0, appw.class));
        localHashMap.put("lightappDisableLongPress", new adeb("lightappDisableLongPress", 11, 0, appw.class));
        localHashMap.put("lightappDisableWebViewLongPress", new adeb("lightappDisableWebViewLongPress", 12, 0, appw.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgn
 * JD-Core Version:    0.7.0.1
 */