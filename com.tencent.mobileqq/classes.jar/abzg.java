import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class abzg
{
  private static Map<String, abwv> a;
  
  public static Map<String, abwv> a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("getLocation", new abwv("getLocation", 7, 1, abxy.class));
        localHashMap.put("getCity", new abwv("getCity", 6, 1, abxy.class));
        localHashMap.put("login", new abwv("login", 17, 0, abye.class));
        localHashMap.put("loginSilent", new abwv("loginSilent", 18, 0, abye.class));
        localHashMap.put("getUserInfo", new abwv("getUserInfo", 10, 2, abye.class));
        localHashMap.put("getAppFriends", new abwv("getAppFriends", 5, 2, abye.class));
        localHashMap.put("getRankingList", new abwv("getRankingList", 8, 2, abxv.class));
        localHashMap.put("reportScore", new abwv("reportScore", 24, 2, abxv.class));
        localHashMap.put("showShareMenu", new abwv("showShareMenu", 30, 0, abyc.class));
        localHashMap.put("shareMessage", new abwv("shareMessage", 27, 0, abyc.class));
        localHashMap.put("showActionSheet", new abwv("showActionSheet", 28, 0, abyo.class));
        localHashMap.put("showDialog", new abwv("showDialog", 29, 0, abyo.class));
        localHashMap.put("getSkey", new abwv("getSkey", 9, 0, abyt.class));
        localHashMap.put("openWebView", new abwv("openWebView", 21, 0, abyu.class));
        localHashMap.put("openPlatoView", new abwv("openPlatoView", 20, 0, abyu.class));
        localHashMap.put("openNativeView", new abwv("openNativeView", 19, 0, abyu.class));
        localHashMap.put("addEventListener", new abwv("addEventListener", 1, 0, abyr.class));
        localHashMap.put("removeEventListener", new abwv("removeEventListener", 23, 0, abyr.class));
        localHashMap.put("dispatchEvent", new abwv("dispatchEvent", 4, 0, abyr.class));
        localHashMap.put("sdk_dynamic_avatar_edit", new abwv("sdk_dynamic_avatar_edit", 31, 0, abyv.class));
        localHashMap.put("sdk_face_collection", new abwv("sdk_face_collection", 32, 0, abyv.class));
        localHashMap.put("sdk_avatar_edit", new abwv("sdk_avatar_edit", 33, 0, abyv.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzg
 * JD-Core Version:    0.7.0.1
 */