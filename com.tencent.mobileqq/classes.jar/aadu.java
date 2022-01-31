import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class aadu
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
        localHashMap.put("getLocation", new aabj("getLocation", 7, 1, aacm.class));
        localHashMap.put("getCity", new aabj("getCity", 6, 1, aacm.class));
        localHashMap.put("login", new aabj("login", 17, 0, aacs.class));
        localHashMap.put("loginSilent", new aabj("loginSilent", 18, 0, aacs.class));
        localHashMap.put("getUserInfo", new aabj("getUserInfo", 10, 2, aacs.class));
        localHashMap.put("getAppFriends", new aabj("getAppFriends", 5, 2, aacs.class));
        localHashMap.put("getRankingList", new aabj("getRankingList", 8, 2, aacj.class));
        localHashMap.put("reportScore", new aabj("reportScore", 24, 2, aacj.class));
        localHashMap.put("showShareMenu", new aabj("showShareMenu", 30, 0, aacq.class));
        localHashMap.put("shareMessage", new aabj("shareMessage", 27, 0, aacq.class));
        localHashMap.put("showActionSheet", new aabj("showActionSheet", 28, 0, aadc.class));
        localHashMap.put("showDialog", new aabj("showDialog", 29, 0, aadc.class));
        localHashMap.put("getSkey", new aabj("getSkey", 9, 0, aadh.class));
        localHashMap.put("openWebView", new aabj("openWebView", 21, 0, aadi.class));
        localHashMap.put("openPlatoView", new aabj("openPlatoView", 20, 0, aadi.class));
        localHashMap.put("openNativeView", new aabj("openNativeView", 19, 0, aadi.class));
        localHashMap.put("addEventListener", new aabj("addEventListener", 1, 0, aadf.class));
        localHashMap.put("removeEventListener", new aabj("removeEventListener", 23, 0, aadf.class));
        localHashMap.put("dispatchEvent", new aabj("dispatchEvent", 4, 0, aadf.class));
        localHashMap.put("sdk_dynamic_avatar_edit", new aabj("sdk_dynamic_avatar_edit", 31, 0, aadj.class));
        localHashMap.put("sdk_face_collection", new aabj("sdk_face_collection", 32, 0, aadj.class));
        localHashMap.put("sdk_avatar_edit", new aabj("sdk_avatar_edit", 33, 0, aadj.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadu
 * JD-Core Version:    0.7.0.1
 */