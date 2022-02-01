import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.utils.ReportUtils.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class akxd
{
  static
  {
    UserAction.registerTunnel(new TunnelInfo("000004B5DU3Q3LD1"));
  }
  
  private static final String a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return "";
    }
    return paramAppRuntime.getAccount();
  }
  
  public static Map<String, String> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null) {
      return localHashMap;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramJSONObject.optString(str));
    }
    return localHashMap;
  }
  
  public static void a()
  {
    ThreadManagerV2.executeOnFileThread(new ReportUtils.1());
  }
  
  public static void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if ((!paramMap.containsKey("A8")) && (BaseApplicationImpl.getApplication() != null)) {
        paramMap.put("A8", a(BaseApplicationImpl.getApplication().peekAppRuntime()));
      }
      if (!paramMap.containsKey("plat")) {
        paramMap.put("plat", "android");
      }
      if (!paramMap.containsKey("version")) {
        paramMap.put("version", "8.4.1");
      }
    }
    UserAction.onUserActionToTunnel(paramString1, paramString2, true, -1L, -1L, paramMap, true, true);
  }
  
  public static void a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    a(paramString1, paramString2, a(paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxd
 * JD-Core Version:    0.7.0.1
 */