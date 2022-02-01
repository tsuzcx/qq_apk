import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class adcm
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
        localHashMap.put("getLocation", new adab("getLocation", 7, 1, adbe.class));
        localHashMap.put("getCity", new adab("getCity", 6, 1, adbe.class));
        localHashMap.put("login", new adab("login", 17, 0, adbk.class));
        localHashMap.put("loginSilent", new adab("loginSilent", 18, 0, adbk.class));
        localHashMap.put("getUserInfo", new adab("getUserInfo", 10, 2, adbk.class));
        localHashMap.put("getAppFriends", new adab("getAppFriends", 5, 2, adbk.class));
        localHashMap.put("getRankingList", new adab("getRankingList", 8, 2, adbb.class));
        localHashMap.put("reportScore", new adab("reportScore", 24, 2, adbb.class));
        localHashMap.put("showShareMenu", new adab("showShareMenu", 30, 0, adbi.class));
        localHashMap.put("shareMessage", new adab("shareMessage", 27, 0, adbi.class));
        localHashMap.put("showActionSheet", new adab("showActionSheet", 28, 0, adbu.class));
        localHashMap.put("showDialog", new adab("showDialog", 29, 0, adbu.class));
        localHashMap.put("getSkey", new adab("getSkey", 9, 0, adbz.class));
        localHashMap.put("openWebView", new adab("openWebView", 21, 0, adca.class));
        localHashMap.put("openPlatoView", new adab("openPlatoView", 20, 0, adca.class));
        localHashMap.put("openNativeView", new adab("openNativeView", 19, 0, adca.class));
        localHashMap.put("addEventListener", new adab("addEventListener", 1, 0, adbx.class));
        localHashMap.put("removeEventListener", new adab("removeEventListener", 23, 0, adbx.class));
        localHashMap.put("dispatchEvent", new adab("dispatchEvent", 4, 0, adbx.class));
        localHashMap.put("sdk_dynamic_avatar_edit", new adab("sdk_dynamic_avatar_edit", 31, 0, adcb.class));
        localHashMap.put("sdk_face_collection", new adab("sdk_face_collection", 32, 0, adcb.class));
        localHashMap.put("sdk_avatar_edit", new adab("sdk_avatar_edit", 33, 0, adcb.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcm
 * JD-Core Version:    0.7.0.1
 */