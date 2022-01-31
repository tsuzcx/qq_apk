import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class abur
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
        localHashMap.put("getLocation", new absg("getLocation", 7, 1, abtj.class));
        localHashMap.put("getCity", new absg("getCity", 6, 1, abtj.class));
        localHashMap.put("login", new absg("login", 17, 0, abtp.class));
        localHashMap.put("loginSilent", new absg("loginSilent", 18, 0, abtp.class));
        localHashMap.put("getUserInfo", new absg("getUserInfo", 10, 2, abtp.class));
        localHashMap.put("getAppFriends", new absg("getAppFriends", 5, 2, abtp.class));
        localHashMap.put("getRankingList", new absg("getRankingList", 8, 2, abtg.class));
        localHashMap.put("reportScore", new absg("reportScore", 24, 2, abtg.class));
        localHashMap.put("showShareMenu", new absg("showShareMenu", 30, 0, abtn.class));
        localHashMap.put("shareMessage", new absg("shareMessage", 27, 0, abtn.class));
        localHashMap.put("showActionSheet", new absg("showActionSheet", 28, 0, abtz.class));
        localHashMap.put("showDialog", new absg("showDialog", 29, 0, abtz.class));
        localHashMap.put("getSkey", new absg("getSkey", 9, 0, abue.class));
        localHashMap.put("openWebView", new absg("openWebView", 21, 0, abuf.class));
        localHashMap.put("openPlatoView", new absg("openPlatoView", 20, 0, abuf.class));
        localHashMap.put("openNativeView", new absg("openNativeView", 19, 0, abuf.class));
        localHashMap.put("addEventListener", new absg("addEventListener", 1, 0, abuc.class));
        localHashMap.put("removeEventListener", new absg("removeEventListener", 23, 0, abuc.class));
        localHashMap.put("dispatchEvent", new absg("dispatchEvent", 4, 0, abuc.class));
        localHashMap.put("sdk_dynamic_avatar_edit", new absg("sdk_dynamic_avatar_edit", 31, 0, abug.class));
        localHashMap.put("sdk_face_collection", new absg("sdk_face_collection", 32, 0, abug.class));
        localHashMap.put("sdk_avatar_edit", new absg("sdk_avatar_edit", 33, 0, abug.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abur
 * JD-Core Version:    0.7.0.1
 */