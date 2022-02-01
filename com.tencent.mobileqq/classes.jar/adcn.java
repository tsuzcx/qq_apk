import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class adcn
{
  private static Map<String, adab> a;
  
  public static Map<String, adab> a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(adcm.a());
        localHashMap.put("config", new adab("config", 3, 0, adci.class));
        localHashMap.put("setShareInfo", new adab("setShareInfo", 25, 0, adcj.class));
        localHashMap.put("closeWebview", new adab("closeWebview", 2, 0, adcj.class));
        localHashMap.put("refreshTitle", new adab("refreshTitle", 22, 0, adcj.class));
        localHashMap.put("setShareListener", new adab("setShareListener", 26, 0, adcj.class));
        localHashMap.put("lightappGetSDKVersion", new adab("lightappGetSDKVersion", 13, 0, aqab.class));
        localHashMap.put("lightappShareCallback", new adab("lightappShareCallback", 15, 0, aqab.class));
        localHashMap.put("lightappShareMessage", new adab("lightappShareMessage", 16, 0, aqab.class));
        localHashMap.put("lightappOpenApp", new adab("lightappOpenApp", 14, 0, aqab.class));
        localHashMap.put("lightappDisableLongPress", new adab("lightappDisableLongPress", 11, 0, aqab.class));
        localHashMap.put("lightappDisableWebViewLongPress", new adab("lightappDisableWebViewLongPress", 12, 0, aqab.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcn
 * JD-Core Version:    0.7.0.1
 */