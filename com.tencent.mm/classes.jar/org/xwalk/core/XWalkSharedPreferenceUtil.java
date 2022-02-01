package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ISharedPreferenceProvider;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.util.l;
import java.lang.reflect.Method;

public class XWalkSharedPreferenceUtil
{
  public static final String SP_KEY_FILE_READER_POSTFIX_COUNT = "_count";
  public static final String SP_KEY_FILE_READER_POSTFIX_REPORT_UV_DATE = "_report_uv_date";
  public static final String SP_KEY_FILE_READER_POSTFIX_TIME = "_time";
  public static final String SP_KEY_PLUGIN_AVAILABLE_VERSION = "availableVersion";
  public static final String SP_KEY_PLUGIN_LAST_ENV_INFO = "lastEnvInfo";
  public static final String SP_KEY_PLUGIN_LAST_REPORT_DATE = "lastReportDate";
  public static final String SP_KEY_PLUGIN_LAST_REPORT_VERSION = "lastReportVersion";
  public static final String SP_KEY_PLUGIN_PATCH_DOWNLOAD_COUNT_PREFIX = "patchDownloadCount_";
  public static final String SP_KEY_PLUGIN_SUPPORT_FORMATS = "supportFormats";
  public static final String SP_KEY_PLUGIN_UPDATE_CONFIG_LAST_FETCH_TIME = "nLastFetchPluginConfigTime";
  public static final String SP_KEY_PLUGIN_UPDATE_PROCESS_ID = "nUpdatingProcessId";
  public static final String SP_NAME_FILE_READER_RECORD = "xwalk_reader_record";
  private static final String SP_NAME_FREQUENT_LIMITER = "FREQUENT_LIMITER";
  private static final String SP_NAME_PLUGIN_UPDATE_INFO = "xwalk_plugin_update_info";
  private static final String SP_NAME_PLUGIN_VERSION_INFO_PREFIX = "xwalk_plugin_version_info_";
  private static final String SP_NAME_REPORT_DAILY = "REPORT_DAILY";
  private static final String SP_NAME_TEST_XWEB = "TESTXWEB";
  private static final String SP_NAME_UPDATE_CONFIG = "UPDATEINFOTAG";
  private static final String SP_NAME_UPDATE_LOG = "UPDATELOG";
  public static final String SP_NAME_VERSION_INFO = "XWALKINFOS";
  private static final String SP_NAME_WCWEBVIEW = "wcwebview";
  private static final String SP_NAME_XWALK_CORE = "libxwalkcore";
  private static final String SP_NAME_XWEB_CMDCFG = "XWEB.CMDCFG";
  private static final String SP_NAME_XWEB_CMDCFG_LATEST = "XWEB.CMDCFG.LATEST";
  private static final String SP_NAME_XWEB_CMDCFG_PLUGIN = "XWEB.CMDCFG.PLUGIN";
  private static final String SP_NAME_XWEB_CMDCFG_PLUGIN_LATEST = "XWEB.CMDCFG.PLUGIN.LATEST";
  private static final String SP_NAME_XWEB_DEBUG = "xweb_debug";
  private static final String SP_NAME_XWEB_UPDATER = "XWEB_UPDATER";
  private static final String SP_NAME_XWEB_UPDATING_TAG = "XWEB_UPDATING_TAG";
  private static final String SP_NAME_XWEB_USER_INFO = "XWEB_USER_INFO";
  private static final String SP_NAME_XWEB_VALUE_CHANGED = "xweb_value_changed";
  public static final String TAG = "XWalkSharedPreferenceUtil";
  private static boolean sHasInitedMMKVMethod = false;
  private static Method sMMKVMethod;
  private static ISharedPreferenceProvider sSPProvider = null;
  
  public static SharedPreferences getMMKVSharedPreferenceForWebViewKind()
  {
    AppMethodBeat.i(187694);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferences("xweb_debug");
    AppMethodBeat.o(187694);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getMMKVSharedPreferences(String paramString)
  {
    AppMethodBeat.i(187690);
    paramString = getMMKVSharedPreferences(paramString, false);
    AppMethodBeat.o(187690);
    return paramString;
  }
  
  private static SharedPreferences getMMKVSharedPreferences(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(187657);
    Object localObject3;
    if (sSPProvider != null) {
      try
      {
        Object localObject1 = sSPProvider;
        XWalkEnvironment.getApplicationContext();
        localObject1 = ((ISharedPreferenceProvider)localObject1).H(paramString, 4, paramBoolean);
        if (localObject1 != null)
        {
          AppMethodBeat.o(187657);
          return localObject1;
        }
      }
      finally
      {
        for (;;)
        {
          Log.e("XWalkSharedPreferenceUtil", "getMMKVSharedPreferences, SPProvider get sp error:".concat(String.valueOf(localObject2)));
          localObject3 = null;
        }
        Log.w("XWalkSharedPreferenceUtil", "getMMKVSharedPreferences, get null from SPProvider");
        l.Br(176L);
      }
    }
    for (;;)
    {
      initMMKVMethod();
      if (sMMKVMethod != null) {}
      try
      {
        localObject3 = sMMKVMethod.invoke(null, new Object[] { XWalkEnvironment.getApplicationContext(), paramString, Integer.valueOf(4), Boolean.valueOf(paramBoolean) });
        if (!(localObject3 instanceof SharedPreferences))
        {
          Log.w("XWalkSharedPreferenceUtil", "getMMKVSharedPreferences, get non sp from MMKVMethod");
          l.Br(179L);
          paramString = safeGetProcessSharedPreferences(paramString);
          AppMethodBeat.o(187657);
          return paramString;
          l.Br(177L);
          continue;
        }
        localObject3 = (SharedPreferences)localObject3;
        AppMethodBeat.o(187657);
        return localObject3;
      }
      finally
      {
        for (;;)
        {
          Log.e("XWalkSharedPreferenceUtil", "getMMKVSharedPreferences, invoke MMKVMethod error:".concat(String.valueOf(localObject4)));
        }
      }
    }
  }
  
  public static SharedPreferences getMMKVSharedPreferencesForCommandCfgPlugin()
  {
    AppMethodBeat.i(187728);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferences("XWEB.CMDCFG.PLUGIN");
    AppMethodBeat.o(187728);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesForCommandCfgPluginLatest()
  {
    AppMethodBeat.i(187735);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferences("XWEB.CMDCFG.PLUGIN.LATEST");
    AppMethodBeat.o(187735);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesForEmbedInstall(String paramString)
  {
    AppMethodBeat.i(187747);
    paramString = getMMKVSharedPreferences("XWEB_EMBED_INSTALL_".concat(String.valueOf(paramString)));
    AppMethodBeat.o(187747);
    return paramString;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesForFrequentLimiter()
  {
    AppMethodBeat.i(187714);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferences("FREQUENT_LIMITER");
    AppMethodBeat.o(187714);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesForLog()
  {
    AppMethodBeat.i(187688);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferencesTransportOld("UPDATELOG");
    AppMethodBeat.o(187688);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesForSchduler(String paramString)
  {
    AppMethodBeat.i(187742);
    paramString = getMMKVSharedPreferences("xweb_scheduler_".concat(String.valueOf(paramString)));
    AppMethodBeat.o(187742);
    return paramString;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesForTestXWeb()
  {
    AppMethodBeat.i(187669);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferencesTransportOld("TESTXWEB");
    AppMethodBeat.o(187669);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesForUpdatingTag()
  {
    AppMethodBeat.i(187704);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferences("XWEB_UPDATING_TAG");
    AppMethodBeat.o(187704);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesForXWEBUpdater()
  {
    AppMethodBeat.i(187699);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferences("XWEB_UPDATER");
    AppMethodBeat.o(187699);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesForXWebUserInfo()
  {
    AppMethodBeat.i(187708);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferences("XWEB_USER_INFO");
    AppMethodBeat.o(187708);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesForXWebValueChanged()
  {
    AppMethodBeat.i(187723);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferences("xweb_value_changed");
    AppMethodBeat.o(187723);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesTransportOld(String paramString)
  {
    AppMethodBeat.i(187664);
    paramString = getMMKVSharedPreferences(paramString, true);
    AppMethodBeat.o(187664);
    return paramString;
  }
  
  public static SharedPreferences getSharedPreferencesForCommandCfg()
  {
    AppMethodBeat.i(187672);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferencesTransportOld("XWEB.CMDCFG");
    AppMethodBeat.o(187672);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForCommandCfgLatest()
  {
    AppMethodBeat.i(187677);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferencesTransportOld("XWEB.CMDCFG.LATEST");
    AppMethodBeat.o(187677);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForFileReaderRecord()
  {
    AppMethodBeat.i(187637);
    SharedPreferences localSharedPreferences = safeGetProcessSharedPreferences("xwalk_reader_record");
    AppMethodBeat.o(187637);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForInitLog(WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(187644);
    paramWebViewKind = safeGetProcessSharedPreferences(XWalkEnvironment.getProcessName() + "_LOAD_URL_" + paramWebViewKind);
    AppMethodBeat.o(187644);
    return paramWebViewKind;
  }
  
  public static SharedPreferences getSharedPreferencesForPluginUpdateInfo()
  {
    AppMethodBeat.i(187632);
    SharedPreferences localSharedPreferences = safeGetProcessSharedPreferences("xwalk_plugin_update_info");
    AppMethodBeat.o(187632);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForPluginVersionInfo(String paramString)
  {
    AppMethodBeat.i(187634);
    paramString = safeGetProcessSharedPreferences("xwalk_plugin_version_info_".concat(String.valueOf(paramString)));
    AppMethodBeat.o(187634);
    return paramString;
  }
  
  public static SharedPreferences getSharedPreferencesForReportDaily()
  {
    AppMethodBeat.i(187682);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferencesTransportOld("REPORT_DAILY");
    AppMethodBeat.o(187682);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForTestXWeb()
  {
    AppMethodBeat.i(187622);
    SharedPreferences localSharedPreferences = safeGetProcessSharedPreferences("TESTXWEB");
    AppMethodBeat.o(187622);
    return localSharedPreferences;
  }
  
  @Deprecated
  public static SharedPreferences getSharedPreferencesForUpdateConfig()
  {
    AppMethodBeat.i(187626);
    SharedPreferences localSharedPreferences = safeGetProcessSharedPreferences("UPDATEINFOTAG");
    AppMethodBeat.o(187626);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForVersionInfo()
  {
    AppMethodBeat.i(187628);
    SharedPreferences localSharedPreferences = safeGetProcessSharedPreferences("XWALKINFOS");
    AppMethodBeat.o(187628);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForWebDebug()
  {
    AppMethodBeat.i(187618);
    SharedPreferences localSharedPreferences = safeGetProcessSharedPreferences("wcwebview");
    AppMethodBeat.o(187618);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForXWalkCore()
  {
    AppMethodBeat.i(187640);
    SharedPreferences localSharedPreferences = safeGetProcessSharedPreferences("libxwalkcore");
    AppMethodBeat.o(187640);
    return localSharedPreferences;
  }
  
  private static void initMMKVMethod()
  {
    AppMethodBeat.i(187650);
    if (sHasInitedMMKVMethod)
    {
      AppMethodBeat.o(187650);
      return;
    }
    try
    {
      sMMKVMethod = Class.forName("com.tencent.mm.xwebutil.XWebMMkvWrapper").getMethod("getMMKV", new Class[] { Context.class, String.class, Integer.TYPE, Boolean.TYPE });
      if (sMMKVMethod == null)
      {
        l.Br(178L);
        Log.w("XWalkSharedPreferenceUtil", "initMMKVMethod, mmkv method is null");
        sHasInitedMMKVMethod = true;
        AppMethodBeat.o(187650);
        return;
      }
    }
    finally
    {
      for (;;)
      {
        Log.w("XWalkSharedPreferenceUtil", "initMMKVMethod, error:".concat(String.valueOf(localObject)));
        continue;
        Log.i("XWalkSharedPreferenceUtil", "initMMKVMethod, success");
      }
    }
  }
  
  private static SharedPreferences safeGetProcessSharedPreferences(String paramString)
  {
    AppMethodBeat.i(187615);
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.w("XWalkSharedPreferenceUtil", "safeGetProcessSharedPreferences, application context is null");
      AppMethodBeat.o(187615);
      return null;
    }
    paramString = XWalkEnvironment.getApplicationContext().getSharedPreferences(paramString, 4);
    AppMethodBeat.o(187615);
    return paramString;
  }
  
  public static void setSharedPreferenceProvider(ISharedPreferenceProvider paramISharedPreferenceProvider)
  {
    if (paramISharedPreferenceProvider != null) {}
    try
    {
      sSPProvider = paramISharedPreferenceProvider;
      return;
    }
    finally
    {
      paramISharedPreferenceProvider = finally;
      throw paramISharedPreferenceProvider;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkSharedPreferenceUtil
 * JD-Core Version:    0.7.0.1
 */