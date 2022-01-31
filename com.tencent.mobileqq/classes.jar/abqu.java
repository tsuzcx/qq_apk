import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.QAPM.ABType;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class abqu
{
  public static Class<? extends QAPM.ABType>[] a = { abqt.class, abqv.class };
  
  public static int a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramString != null)
    {
      if ("actSceneMem".equals(paramString)) {
        return PluginCombination.leakPlugin.plugin;
      }
      if ("actScenePerf".equals(paramString)) {
        return PluginCombination.resourcePlugin.plugin;
      }
      if (!"unifiedMonitor".equals(paramString)) {}
    }
    switch (Integer.parseInt((String)paramHashMap.get("family")))
    {
    default: 
      return -1;
    case 9: 
    case 10: 
      return PluginCombination.dropFramePlugin.plugin;
    case 0: 
      return PluginCombination.loopStackPlugin.plugin;
    case 20: 
      return PluginCombination.resourcePlugin.plugin;
    }
    return PluginCombination.batteryPlugin.plugin;
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {}
    do
    {
      return;
      paramHashMap.put("deviceLv", String.valueOf(bdcb.f()));
      paramString = QAPM.getABFactorByQAPMPlugin(a(paramString, paramHashMap));
    } while ((paramString == null) || (paramString.length() <= 0));
    paramHashMap.put("abfactor", paramString);
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("newplugin"))
        {
          i = paramJSONObject.getInt("newplugin");
          String str = QAPM.getABFactorByQAPMPlugin(i);
          if ((str == null) || (str.length() <= 0)) {
            break;
          }
          paramJSONObject.put("abfactor", str);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("MagnifierSDK_QAPM.AbFactorManger", 2, "", paramJSONObject);
        return;
      }
      int i = paramJSONObject.getInt("plugin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqu
 * JD-Core Version:    0.7.0.1
 */