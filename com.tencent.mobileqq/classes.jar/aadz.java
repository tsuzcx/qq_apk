import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class aadz
{
  private static Map<String, aabn> a;
  
  public static Map<String, aabn> a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(aady.a());
        localHashMap.put("config", new aabn("config", 3, 0, aadu.class));
        localHashMap.put("setShareInfo", new aabn("setShareInfo", 25, 0, aadv.class));
        localHashMap.put("closeWebview", new aabn("closeWebview", 2, 0, aadv.class));
        localHashMap.put("refreshTitle", new aabn("refreshTitle", 22, 0, aadv.class));
        localHashMap.put("setShareListener", new aabn("setShareListener", 26, 0, aadv.class));
        localHashMap.put("lightappGetSDKVersion", new aabn("lightappGetSDKVersion", 13, 0, alup.class));
        localHashMap.put("lightappShareCallback", new aabn("lightappShareCallback", 15, 0, alup.class));
        localHashMap.put("lightappShareMessage", new aabn("lightappShareMessage", 16, 0, alup.class));
        localHashMap.put("lightappOpenApp", new aabn("lightappOpenApp", 14, 0, alup.class));
        localHashMap.put("lightappDisableLongPress", new aabn("lightappDisableLongPress", 11, 0, alup.class));
        localHashMap.put("lightappDisableWebViewLongPress", new aabn("lightappDisableWebViewLongPress", 12, 0, alup.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadz
 * JD-Core Version:    0.7.0.1
 */