import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class aady
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
        localHashMap.put("getLocation", new aabn("getLocation", 7, 1, aacq.class));
        localHashMap.put("getCity", new aabn("getCity", 6, 1, aacq.class));
        localHashMap.put("login", new aabn("login", 17, 0, aacw.class));
        localHashMap.put("loginSilent", new aabn("loginSilent", 18, 0, aacw.class));
        localHashMap.put("getUserInfo", new aabn("getUserInfo", 10, 2, aacw.class));
        localHashMap.put("getAppFriends", new aabn("getAppFriends", 5, 2, aacw.class));
        localHashMap.put("getRankingList", new aabn("getRankingList", 8, 2, aacn.class));
        localHashMap.put("reportScore", new aabn("reportScore", 24, 2, aacn.class));
        localHashMap.put("showShareMenu", new aabn("showShareMenu", 30, 0, aacu.class));
        localHashMap.put("shareMessage", new aabn("shareMessage", 27, 0, aacu.class));
        localHashMap.put("showActionSheet", new aabn("showActionSheet", 28, 0, aadg.class));
        localHashMap.put("showDialog", new aabn("showDialog", 29, 0, aadg.class));
        localHashMap.put("getSkey", new aabn("getSkey", 9, 0, aadl.class));
        localHashMap.put("openWebView", new aabn("openWebView", 21, 0, aadm.class));
        localHashMap.put("openPlatoView", new aabn("openPlatoView", 20, 0, aadm.class));
        localHashMap.put("openNativeView", new aabn("openNativeView", 19, 0, aadm.class));
        localHashMap.put("addEventListener", new aabn("addEventListener", 1, 0, aadj.class));
        localHashMap.put("removeEventListener", new aabn("removeEventListener", 23, 0, aadj.class));
        localHashMap.put("dispatchEvent", new aabn("dispatchEvent", 4, 0, aadj.class));
        localHashMap.put("sdk_dynamic_avatar_edit", new aabn("sdk_dynamic_avatar_edit", 31, 0, aadn.class));
        localHashMap.put("sdk_face_collection", new aabn("sdk_face_collection", 32, 0, aadn.class));
        localHashMap.put("sdk_avatar_edit", new aabn("sdk_avatar_edit", 33, 0, aadn.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aady
 * JD-Core Version:    0.7.0.1
 */