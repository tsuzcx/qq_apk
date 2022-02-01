import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class adgm
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
        localHashMap.put("getLocation", new adeb("getLocation", 7, 1, adfe.class));
        localHashMap.put("getCity", new adeb("getCity", 6, 1, adfe.class));
        localHashMap.put("login", new adeb("login", 17, 0, adfk.class));
        localHashMap.put("loginSilent", new adeb("loginSilent", 18, 0, adfk.class));
        localHashMap.put("getUserInfo", new adeb("getUserInfo", 10, 2, adfk.class));
        localHashMap.put("getAppFriends", new adeb("getAppFriends", 5, 2, adfk.class));
        localHashMap.put("getRankingList", new adeb("getRankingList", 8, 2, adfb.class));
        localHashMap.put("reportScore", new adeb("reportScore", 24, 2, adfb.class));
        localHashMap.put("showShareMenu", new adeb("showShareMenu", 30, 0, adfi.class));
        localHashMap.put("shareMessage", new adeb("shareMessage", 27, 0, adfi.class));
        localHashMap.put("showActionSheet", new adeb("showActionSheet", 28, 0, adfu.class));
        localHashMap.put("showDialog", new adeb("showDialog", 29, 0, adfu.class));
        localHashMap.put("getSkey", new adeb("getSkey", 9, 0, adfz.class));
        localHashMap.put("openWebView", new adeb("openWebView", 21, 0, adga.class));
        localHashMap.put("openPlatoView", new adeb("openPlatoView", 20, 0, adga.class));
        localHashMap.put("openNativeView", new adeb("openNativeView", 19, 0, adga.class));
        localHashMap.put("addEventListener", new adeb("addEventListener", 1, 0, adfx.class));
        localHashMap.put("removeEventListener", new adeb("removeEventListener", 23, 0, adfx.class));
        localHashMap.put("dispatchEvent", new adeb("dispatchEvent", 4, 0, adfx.class));
        localHashMap.put("sdk_dynamic_avatar_edit", new adeb("sdk_dynamic_avatar_edit", 31, 0, adgb.class));
        localHashMap.put("sdk_face_collection", new adeb("sdk_face_collection", 32, 0, adgb.class));
        localHashMap.put("sdk_avatar_edit", new adeb("sdk_avatar_edit", 33, 0, adgb.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgm
 * JD-Core Version:    0.7.0.1
 */