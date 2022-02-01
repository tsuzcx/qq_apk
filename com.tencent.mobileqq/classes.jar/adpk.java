import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class adpk
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
        localHashMap.put("getLocation", new admz("getLocation", 7, 1, adoc.class));
        localHashMap.put("getCity", new admz("getCity", 6, 1, adoc.class));
        localHashMap.put("login", new admz("login", 17, 0, adoi.class));
        localHashMap.put("loginSilent", new admz("loginSilent", 18, 0, adoi.class));
        localHashMap.put("getUserInfo", new admz("getUserInfo", 10, 2, adoi.class));
        localHashMap.put("getAppFriends", new admz("getAppFriends", 5, 2, adoi.class));
        localHashMap.put("getRankingList", new admz("getRankingList", 8, 2, adnz.class));
        localHashMap.put("reportScore", new admz("reportScore", 24, 2, adnz.class));
        localHashMap.put("showShareMenu", new admz("showShareMenu", 30, 0, adog.class));
        localHashMap.put("shareMessage", new admz("shareMessage", 27, 0, adog.class));
        localHashMap.put("showActionSheet", new admz("showActionSheet", 28, 0, ados.class));
        localHashMap.put("showDialog", new admz("showDialog", 29, 0, ados.class));
        localHashMap.put("getSkey", new admz("getSkey", 9, 0, adox.class));
        localHashMap.put("openWebView", new admz("openWebView", 21, 0, adoy.class));
        localHashMap.put("openPlatoView", new admz("openPlatoView", 20, 0, adoy.class));
        localHashMap.put("openNativeView", new admz("openNativeView", 19, 0, adoy.class));
        localHashMap.put("addEventListener", new admz("addEventListener", 1, 0, adov.class));
        localHashMap.put("removeEventListener", new admz("removeEventListener", 23, 0, adov.class));
        localHashMap.put("dispatchEvent", new admz("dispatchEvent", 4, 0, adov.class));
        localHashMap.put("sdk_dynamic_avatar_edit", new admz("sdk_dynamic_avatar_edit", 31, 0, adoz.class));
        localHashMap.put("sdk_face_collection", new admz("sdk_face_collection", 32, 0, adoz.class));
        localHashMap.put("sdk_avatar_edit", new admz("sdk_avatar_edit", 33, 0, adoz.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpk
 * JD-Core Version:    0.7.0.1
 */