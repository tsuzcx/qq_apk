package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XWalkUpdateConfigUtil
{
  private static final String DOWNLOAD_CONFIG_URL = "https://dldir1v6.qq.com/weixin/android/wxweb/updateConfig.xml";
  private static final String DOWNLOAD_CONFIG_URL_THIRD_PARD = "https://dldir1v6.qq.com/weixin/android/wxweb/updateConfig_public.xml";
  private static final String DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL = "https://dldir1v6.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
  private static final String DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL_THIRD_PARD = "https://dldir1v6.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_public.xml";
  public static final String DOWNLOAD_PLUGIN_UPDATE_TEST_CONFIG_DEFAULT_URL = "https://dldir1v6.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml";
  private static final String DOWNLOAD_X86_CONFIG_URL = "https://dldir1v6.qq.com/weixin/android/wxweb/updateConfig_x86.xml";
  private static final String SP_KEY_PLUGIN_TEST_CONFIG_URL = "XWEB_PLUGIN_TEST_CONFIG_URL";
  private static final String SP_KEY_TEST_CONFIG_URL = "XWEB_TEST_CONFIG_URL";
  public static final String TAG = "XWalkUpdateConfigUtil";
  public static final int XWALK_PLUGIN_UPDATE_PERIOD_DEFAULT = 90000000;
  private static long sConfigUpdatePeriod = 0L;
  private static String sStrBaseConfigUrl;
  private static String sStrTempBaseConfigUrl;
  private static String sStrTempPluginConfigUrl;
  private static int sTempPluginConfigUpdatePeriod = -1;
  
  public static long getBaseConfigUpdatePeriod()
  {
    return sConfigUpdatePeriod;
  }
  
  public static String getBaseConfigUrl()
  {
    AppMethodBeat.i(187719);
    String str = getTestBaseConfigUrl(XWalkEnvironment.getApplicationContext());
    sStrBaseConfigUrl = str;
    if (isValidConfigHost(str)) {
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdateConfigUtil", "use test config url : " + sStrBaseConfigUrl);
    }
    for (;;)
    {
      str = sStrBaseConfigUrl;
      AppMethodBeat.o(187719);
      return str;
      str = getTempBaseConfigUrl();
      sStrBaseConfigUrl = str;
      if (isValidConfigHost(str))
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdateConfigUtil", "use temp config url : " + sStrBaseConfigUrl);
      }
      else if (com.tencent.xweb.util.b.khu())
      {
        sStrBaseConfigUrl = "https://dldir1v6.qq.com/weixin/android/wxweb/updateConfig_x86.xml";
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdateConfigUtil", "use x86 config url : " + sStrBaseConfigUrl);
      }
      else
      {
        sStrBaseConfigUrl = "https://dldir1v6.qq.com/weixin/android/wxweb/updateConfig.xml";
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdateConfigUtil", "use release config url = " + sStrBaseConfigUrl);
      }
    }
  }
  
  public static String getPluginConfigUrl()
  {
    AppMethodBeat.i(187727);
    String str = getTestPluginConfigUrl();
    if (isValidConfigHost(str))
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdateConfigUtil", "plugin use test config url: ".concat(String.valueOf(str)));
      AppMethodBeat.o(187727);
      return str;
    }
    str = getTempPluginConfigUrl();
    if (isValidConfigHost(str))
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdateConfigUtil", "plugin use temp config url: ".concat(String.valueOf(str)));
      AppMethodBeat.o(187727);
      return str;
    }
    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdateConfigUtil", "plugin use release config url: ".concat(String.valueOf("https://dldir1v6.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml")));
    AppMethodBeat.o(187727);
    return "https://dldir1v6.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
  }
  
  public static int getPluginUpdatePeriod()
  {
    AppMethodBeat.i(187737);
    int i = getTempPluginConfigUpdatePeriod();
    if (i > 0)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdateConfigUtil", "getPluginUpdatePeriod, use temp period:".concat(String.valueOf(i)));
      AppMethodBeat.o(187737);
      return i;
    }
    i = com.tencent.xweb.b.kfi().kfk();
    if (i > 0)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdateConfigUtil", "getPluginUpdatePeriod, use cmd period:".concat(String.valueOf(i)));
      AppMethodBeat.o(187737);
      return i;
    }
    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdateConfigUtil", "getPluginUpdatePeriod, use default period:90000000");
    AppMethodBeat.o(187737);
    return 90000000;
  }
  
  public static String getTempBaseConfigUrl()
  {
    try
    {
      String str = sStrTempBaseConfigUrl;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int getTempPluginConfigUpdatePeriod()
  {
    try
    {
      int i = sTempPluginConfigUpdatePeriod;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getTempPluginConfigUrl()
  {
    try
    {
      String str = sStrTempPluginConfigUrl;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getTestBaseConfigUrl(Context paramContext)
  {
    AppMethodBeat.i(187753);
    paramContext = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForTestXWeb().getString("XWEB_TEST_CONFIG_URL", "");
    AppMethodBeat.o(187753);
    return paramContext;
  }
  
  public static String getTestPluginConfigUrl()
  {
    AppMethodBeat.i(187783);
    Object localObject = XWalkSharedPreferenceUtil.getSharedPreferencesForTestXWeb();
    if (localObject == null)
    {
      Log.e("XWalkUpdateConfigUtil", "getTestPluginConfigUrl, sp is null");
      AppMethodBeat.o(187783);
      return "";
    }
    localObject = ((SharedPreferences)localObject).getString("XWEB_PLUGIN_TEST_CONFIG_URL", "");
    if ((localObject == null) || (((String)localObject).trim().isEmpty()))
    {
      AppMethodBeat.o(187783);
      return "";
    }
    AppMethodBeat.o(187783);
    return localObject;
  }
  
  public static boolean isValidConfigHost(String paramString)
  {
    AppMethodBeat.i(187800);
    if ((paramString == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramString.trim())))
    {
      AppMethodBeat.o(187800);
      return false;
    }
    Log.i("XWalkUpdateConfigUtil", "isValidConfigHost, url:".concat(String.valueOf(paramString)));
    try
    {
      paramString = new URI(paramString.trim());
      boolean bool = paramString.getScheme().equals("https");
      if (!bool)
      {
        AppMethodBeat.o(187800);
        return false;
      }
      if (!paramString.getHost().equals("dldir1.qq.com"))
      {
        bool = paramString.getHost().equals("dldir1v6.qq.com");
        if (!bool)
        {
          AppMethodBeat.o(187800);
          return false;
        }
      }
      AppMethodBeat.o(187800);
      return true;
    }
    finally
    {
      Log.e("XWalkUpdateConfigUtil", "isValidConfigHost error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(187800);
    }
    return false;
  }
  
  @Deprecated
  public static void setBaseConfigUpdatePeriod(long paramLong)
  {
    sConfigUpdatePeriod = paramLong;
  }
  
  @Deprecated
  public static void setTempBaseConfigUrl(String paramString)
  {
    try
    {
      sStrTempBaseConfigUrl = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @Deprecated
  public static boolean setTempBaseConfigUrl(String paramString1, String paramString2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(187758);
        if (!TextUtils.isEmpty(paramString2))
        {
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
          try
          {
            paramString2 = localSimpleDateFormat.parse(paramString2);
            if (!new Date().after(paramString2)) {
              break label94;
            }
            Log.w("XWalkUpdateConfigUtil", "today is after end date, set temp update config failed");
            AppMethodBeat.o(187758);
          }
          finally
          {
            paramString1 = finally;
            Log.e("XWalkUpdateConfigUtil", "setTempUpdateConfigUrl, error:".concat(String.valueOf(paramString1)));
            AppMethodBeat.o(187758);
            continue;
          }
          return bool;
        }
      }
      finally {}
      label94:
      sStrTempBaseConfigUrl = paramString1;
      bool = true;
      AppMethodBeat.o(187758);
    }
  }
  
  @Deprecated
  public static void setTempPluginConfigUpdatePeriod(int paramInt)
  {
    try
    {
      sTempPluginConfigUpdatePeriod = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public static void setTempPluginConfigUrl(String paramString)
  {
    try
    {
      sStrTempPluginConfigUrl = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @Deprecated
  public static void setTempPluginConfigUrl(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(187767);
        if (!TextUtils.isEmpty(paramString2))
        {
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
          try
          {
            paramString2 = localSimpleDateFormat.parse(paramString2);
            if (!new Date().after(paramString2)) {
              break label95;
            }
            Log.w("XWalkUpdateConfigUtil", "today is after end date, set temp plugin update config failed");
            AppMethodBeat.o(187767);
          }
          finally
          {
            paramString1 = finally;
            Log.e("XWalkUpdateConfigUtil", "setTempPluginConfigUrl, error:".concat(String.valueOf(paramString1)));
            AppMethodBeat.o(187767);
            continue;
          }
          return;
        }
      }
      finally {}
      label95:
      sStrTempPluginConfigUrl = paramString1;
      AppMethodBeat.o(187767);
    }
  }
  
  @Deprecated
  public static void setTestBaseConfigUrl(String paramString)
  {
    AppMethodBeat.i(187752);
    sStrBaseConfigUrl = null;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForTestXWeb().edit().putString("XWEB_TEST_CONFIG_URL", "").commit();
      getBaseConfigUrl();
      AppMethodBeat.o(187752);
      return;
    }
    XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForTestXWeb().edit().putString("XWEB_TEST_CONFIG_URL", paramString).commit();
    getBaseConfigUrl();
    AppMethodBeat.o(187752);
  }
  
  public static boolean setTestPluginConfigUrl(String paramString)
  {
    AppMethodBeat.i(187775);
    Object localObject = XWalkSharedPreferenceUtil.getSharedPreferencesForTestXWeb();
    if (localObject == null)
    {
      Log.e("XWalkUpdateConfigUtil", "setTestPluginConfigUrl, sp is null");
      AppMethodBeat.o(187775);
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if ((paramString == null) || (paramString.trim().isEmpty())) {
      ((SharedPreferences.Editor)localObject).remove("XWEB_PLUGIN_TEST_CONFIG_URL");
    }
    for (;;)
    {
      boolean bool = ((SharedPreferences.Editor)localObject).commit();
      AppMethodBeat.o(187775);
      return bool;
      ((SharedPreferences.Editor)localObject).putString("XWEB_PLUGIN_TEST_CONFIG_URL", paramString.trim());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdateConfigUtil
 * JD-Core Version:    0.7.0.1
 */