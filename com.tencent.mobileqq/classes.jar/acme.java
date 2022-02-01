import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class acme
{
  private static Map<String, acjs> a;
  
  public static Map<String, acjs> a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(acmd.a());
        localHashMap.put("config", new acjs("config", 3, 0, aclz.class));
        localHashMap.put("setShareInfo", new acjs("setShareInfo", 25, 0, acma.class));
        localHashMap.put("closeWebview", new acjs("closeWebview", 2, 0, acma.class));
        localHashMap.put("refreshTitle", new acjs("refreshTitle", 22, 0, acma.class));
        localHashMap.put("setShareListener", new acjs("setShareListener", 26, 0, acma.class));
        localHashMap.put("lightappGetSDKVersion", new acjs("lightappGetSDKVersion", 13, 0, aowx.class));
        localHashMap.put("lightappShareCallback", new acjs("lightappShareCallback", 15, 0, aowx.class));
        localHashMap.put("lightappShareMessage", new acjs("lightappShareMessage", 16, 0, aowx.class));
        localHashMap.put("lightappOpenApp", new acjs("lightappOpenApp", 14, 0, aowx.class));
        localHashMap.put("lightappDisableLongPress", new acjs("lightappDisableLongPress", 11, 0, aowx.class));
        localHashMap.put("lightappDisableWebViewLongPress", new acjs("lightappDisableWebViewLongPress", 12, 0, aowx.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acme
 * JD-Core Version:    0.7.0.1
 */