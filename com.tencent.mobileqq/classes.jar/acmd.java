import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class acmd
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
        localHashMap.put("getLocation", new acjs("getLocation", 7, 1, ackv.class));
        localHashMap.put("getCity", new acjs("getCity", 6, 1, ackv.class));
        localHashMap.put("login", new acjs("login", 17, 0, aclb.class));
        localHashMap.put("loginSilent", new acjs("loginSilent", 18, 0, aclb.class));
        localHashMap.put("getUserInfo", new acjs("getUserInfo", 10, 2, aclb.class));
        localHashMap.put("getAppFriends", new acjs("getAppFriends", 5, 2, aclb.class));
        localHashMap.put("getRankingList", new acjs("getRankingList", 8, 2, acks.class));
        localHashMap.put("reportScore", new acjs("reportScore", 24, 2, acks.class));
        localHashMap.put("showShareMenu", new acjs("showShareMenu", 30, 0, ackz.class));
        localHashMap.put("shareMessage", new acjs("shareMessage", 27, 0, ackz.class));
        localHashMap.put("showActionSheet", new acjs("showActionSheet", 28, 0, acll.class));
        localHashMap.put("showDialog", new acjs("showDialog", 29, 0, acll.class));
        localHashMap.put("getSkey", new acjs("getSkey", 9, 0, aclq.class));
        localHashMap.put("openWebView", new acjs("openWebView", 21, 0, aclr.class));
        localHashMap.put("openPlatoView", new acjs("openPlatoView", 20, 0, aclr.class));
        localHashMap.put("openNativeView", new acjs("openNativeView", 19, 0, aclr.class));
        localHashMap.put("addEventListener", new acjs("addEventListener", 1, 0, aclo.class));
        localHashMap.put("removeEventListener", new acjs("removeEventListener", 23, 0, aclo.class));
        localHashMap.put("dispatchEvent", new acjs("dispatchEvent", 4, 0, aclo.class));
        localHashMap.put("sdk_dynamic_avatar_edit", new acjs("sdk_dynamic_avatar_edit", 31, 0, acls.class));
        localHashMap.put("sdk_face_collection", new acjs("sdk_face_collection", 32, 0, acls.class));
        localHashMap.put("sdk_avatar_edit", new acjs("sdk_avatar_edit", 33, 0, acls.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmd
 * JD-Core Version:    0.7.0.1
 */