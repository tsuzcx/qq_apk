import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class adpl
{
  private static Map<String, admz> a;
  
  public static Map<String, admz> a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(adpk.a());
        localHashMap.put("config", new admz("config", 3, 0, adpg.class));
        localHashMap.put("setShareInfo", new admz("setShareInfo", 25, 0, adph.class));
        localHashMap.put("closeWebview", new admz("closeWebview", 2, 0, adph.class));
        localHashMap.put("refreshTitle", new admz("refreshTitle", 22, 0, adph.class));
        localHashMap.put("setShareListener", new admz("setShareListener", 26, 0, adph.class));
        localHashMap.put("lightappGetSDKVersion", new admz("lightappGetSDKVersion", 13, 0, aqdm.class));
        localHashMap.put("lightappShareCallback", new admz("lightappShareCallback", 15, 0, aqdm.class));
        localHashMap.put("lightappShareMessage", new admz("lightappShareMessage", 16, 0, aqdm.class));
        localHashMap.put("lightappOpenApp", new admz("lightappOpenApp", 14, 0, aqdm.class));
        localHashMap.put("lightappDisableLongPress", new admz("lightappDisableLongPress", 11, 0, aqdm.class));
        localHashMap.put("lightappDisableWebViewLongPress", new admz("lightappDisableWebViewLongPress", 12, 0, aqdm.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpl
 * JD-Core Version:    0.7.0.1
 */