import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class abus
{
  private static Map<String, absg> a;
  
  public static Map<String, absg> a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(abur.a());
        localHashMap.put("config", new absg("config", 3, 0, abun.class));
        localHashMap.put("setShareInfo", new absg("setShareInfo", 25, 0, abuo.class));
        localHashMap.put("closeWebview", new absg("closeWebview", 2, 0, abuo.class));
        localHashMap.put("refreshTitle", new absg("refreshTitle", 22, 0, abuo.class));
        localHashMap.put("setShareListener", new absg("setShareListener", 26, 0, abuo.class));
        localHashMap.put("lightappGetSDKVersion", new absg("lightappGetSDKVersion", 13, 0, anlh.class));
        localHashMap.put("lightappShareCallback", new absg("lightappShareCallback", 15, 0, anlh.class));
        localHashMap.put("lightappShareMessage", new absg("lightappShareMessage", 16, 0, anlh.class));
        localHashMap.put("lightappOpenApp", new absg("lightappOpenApp", 14, 0, anlh.class));
        localHashMap.put("lightappDisableLongPress", new absg("lightappDisableLongPress", 11, 0, anlh.class));
        localHashMap.put("lightappDisableWebViewLongPress", new absg("lightappDisableWebViewLongPress", 12, 0, anlh.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abus
 * JD-Core Version:    0.7.0.1
 */