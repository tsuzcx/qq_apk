import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class aadv
{
  private static Map<String, aabj> a;
  
  public static Map<String, aabj> a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(aadu.a());
        localHashMap.put("config", new aabj("config", 3, 0, aadq.class));
        localHashMap.put("setShareInfo", new aabj("setShareInfo", 25, 0, aadr.class));
        localHashMap.put("closeWebview", new aabj("closeWebview", 2, 0, aadr.class));
        localHashMap.put("refreshTitle", new aabj("refreshTitle", 22, 0, aadr.class));
        localHashMap.put("setShareListener", new aabj("setShareListener", 26, 0, aadr.class));
        localHashMap.put("lightappGetSDKVersion", new aabj("lightappGetSDKVersion", 13, 0, aluo.class));
        localHashMap.put("lightappShareCallback", new aabj("lightappShareCallback", 15, 0, aluo.class));
        localHashMap.put("lightappShareMessage", new aabj("lightappShareMessage", 16, 0, aluo.class));
        localHashMap.put("lightappOpenApp", new aabj("lightappOpenApp", 14, 0, aluo.class));
        localHashMap.put("lightappDisableLongPress", new aabj("lightappDisableLongPress", 11, 0, aluo.class));
        localHashMap.put("lightappDisableWebViewLongPress", new aabj("lightappDisableWebViewLongPress", 12, 0, aluo.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadv
 * JD-Core Version:    0.7.0.1
 */