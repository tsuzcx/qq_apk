package org.xwalk.core;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ISharedPreferenceProvider;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ag;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import com.tencent.xweb.util.c;
import com.tencent.xweb.x;
import java.io.Closeable;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class XWalkEnvironment
{
  private static final String APK_DIR = "apk";
  public static final String DOWNLOAD_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig.xml";
  public static final String DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
  public static final String DOWNLOAD_PLUGIN_UPDATE_TEST_CONFIG_DEFAULT_URL = "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml";
  public static final String DOWNLOAD_X86_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86.xml";
  public static final String LOCAL_TEST_ZIP_NAME = "runtime_package.zip";
  public static final String[] MANDATORY_RESOURCES;
  private static final String META_XWALK_DOWNCONFIG_URL = "xwalk_downconfig_url";
  public static final String MM_PACKAGE_NAME = "com.tencent.mm";
  private static final String OPTIMIZED_DEX_DIR = "dex";
  private static final String PACKAGE_RE = "[a-z]+\\.[a-z0-9]+\\.[a-z0-9]+.*";
  private static final String PATCH_ZIP_TEMP_DECOMPRESS_DIR = "patch_temp_decompress";
  public static final String RUNTIME_ABI_ARM32_STR = "armeabi-v7a";
  public static final String RUNTIME_ABI_ARM64_STR = "arm64-v8a";
  public static final int SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION = 153;
  public static final int SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION = 255;
  public static final int SDK_SUPPORT_MIN_APKVERSION = 49;
  public static final int SDK_VERSION = 200502;
  private static final int SPECIAL_TEST_USER_ID = 10001;
  private static final String SP_KEY_DEVICE_RD = "sNDeviceRd";
  public static final String SP_KEY_FILE_READER_POSTFIX_COUNT = "_count";
  public static final String SP_KEY_FILE_READER_POSTFIX_REPORT_UV_DATE = "_report_uv_date";
  public static final String SP_KEY_FILE_READER_POSTFIX_TIME = "_time";
  private static final String SP_KEY_GRAY_VALUE = "GRAY_VALUE";
  private static final String SP_KEY_GRAY_VALUE_TEST = "TEST_GRAY_VALUE";
  private static final String SP_KEY_IP_TYPE = "IP_TYPE";
  public static final String SP_KEY_PLUGIN_AVAILABLE_VERSION = "availableVersion";
  public static final String SP_KEY_PLUGIN_LAST_REPORT_DATE = "lastReportDate";
  public static final String SP_KEY_PLUGIN_LAST_REPORT_VERSION = "lastReportVersion";
  public static final String SP_KEY_PLUGIN_PATCH_DOWNLOAD_COUNT = "patchDownloadCount";
  public static final String SP_KEY_PLUGIN_SUPPORT_FORMATS = "supportFormats";
  private static final String SP_KEY_PLUGIN_TEST_CONFIG_URL = "XWEB_PLUGIN_TEST_CONFIG_URL";
  public static final String SP_KEY_PLUGIN_UPDATE_CONFIG_LAST_FETCH_TIME = "nLastFetchPluginConfigTime";
  public static final String SP_KEY_PLUGIN_UPDATE_PROCESS_ID = "nUpdatingProcessId";
  public static final String SP_NAME_FILE_READER_RECORD = "xwalk_reader_record";
  private static final String SP_NAME_PLUGIN_UPDATE_INFO = "xwalk_plugin_update_info";
  private static final String SP_NAME_PLUGIN_VERSION_INFO_PREFIX = "xwalk_plugin_version_info_";
  public static final String SP_NAME_VERSION_INFO = "XWALKINFOS";
  private static final String TAG = "XWalkEnvironment";
  public static final int TEST_APK_START_VERSION = 100000000;
  public static String UPDATEINFOTAG;
  public static final String XWALK_CORE_APK_NAME = "base.apk";
  public static final String XWALK_CORE_CLASSES_DEX = "classes.dex";
  private static final String XWALK_CORE_EXTRACTED_DIR = "extracted_xwalkcore";
  public static final String XWALK_CORE_FILELIST_CONFIG_NAME = "filelist.config";
  private static final String XWALK_CORE_NAME_PREFIX = "xwalk_";
  private static final String XWALK_CORE_PATCH_CONFIG_NAME = "patch.config";
  private static final String XWALK_CORE_PATCH_NAME = "patch.zip";
  public static final String[] XWALK_CORE_PROVIDER_LIST;
  private static final String XWALK_CORE_RES_FILELIST_CONFIG_NAME = "reslist.config";
  private static final String XWALK_CORE_ZIP_NAME = "base.zip";
  public static final String XWALK_ENV_MAP_KEY_ISGPVERSION = "isgpversion";
  public static final String XWALK_ENV_MAP_KEY_PROCESSNAME = "processname";
  public static final int XWALK_GET_FROM_PROVIDER_MAX_COUNT = 2;
  private static final String XWALK_PLUGIN_BASE_DIR = "xwalkplugin";
  public static final String XWALK_PLUGIN_NAME_EXCEL = "XFilesExcelReader";
  public static final String XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO = "FullScreenVideo";
  public static final String XWALK_PLUGIN_NAME_PDF = "XFilesPDFReader";
  public static final String XWALK_PLUGIN_NAME_PPT = "XFilesPPTReader";
  public static final String XWALK_PLUGIN_NAME_WORD = "XFilesWordReader";
  private static final String XWALK_PLUGIN_UPDATE_CONFIG_NAME = "pluginUpdateConfig.xml";
  public static final int XWALK_PLUGIN_UPDATE_PERIOD_DEFAULT = 90000000;
  private static final String XWALK_UPDATE_CONFIG_DIR = "xwalkconfig";
  private static final String ZIP_DIR = "zip";
  private static boolean isTurnOnKVLog;
  private static int sAppClientVersion;
  private static Set<String> sAppInfos;
  private static Context sApplicationContext;
  private static String sApplicationName;
  static boolean sBHasInitedSafePsProvider;
  static boolean sBIsIpTypeChanged;
  static long sConfigPerios;
  private static String sDeviceAbi;
  private static int sForceDarkBehavior;
  private static Boolean sIsDownloadMode;
  private static Boolean sIsDownloadModeUpdate;
  private static boolean sIsForceDarkMode;
  private static boolean sIsPluginInited;
  private static Boolean sIsXWalkVerify;
  static Method sMMKVMethod;
  static int sNChromiuVersion;
  static int sNDeviceRd;
  static int sPid;
  private static String sRuntimeAbi;
  static ISharedPreferenceProvider sSPProvider;
  static String sStrCurentProcessName;
  static String sStrDeviceId;
  private static String sStrTempPluginUpdateConfigUrl;
  private static String sStrTempUpdateConfigUrl;
  private static int sTempPluginUpdatePeriod;
  private static boolean sUsingCustomContext;
  private static String sXWalkApkUrl;
  private static String sXWalkDownConfigUrl;
  static HashMap<String, Object> sXWebArgs;
  private static XWebCoreInfo sXWebCoreInfo;
  static int s_grayValue;
  
  static
  {
    AppMethodBeat.i(157334);
    UPDATEINFOTAG = "xwalk_update_info";
    XWALK_CORE_PROVIDER_LIST = new String[] { "com.tencent.mm" };
    sIsPluginInited = false;
    sIsDownloadMode = Boolean.TRUE;
    sIsDownloadModeUpdate = Boolean.TRUE;
    sTempPluginUpdatePeriod = -1;
    sUsingCustomContext = false;
    sIsForceDarkMode = false;
    sForceDarkBehavior = 2;
    isTurnOnKVLog = false;
    sBHasInitedSafePsProvider = false;
    sSPProvider = null;
    sPid = Process.myPid();
    s_grayValue = 0;
    sNChromiuVersion = -1;
    sNDeviceRd = 0;
    sBIsIpTypeChanged = false;
    sStrDeviceId = null;
    MANDATORY_RESOURCES = new String[] { "classes.dex", "icudtl.dat", "xwalk.pak", "xwalk_100_percent.pak", "xweb_fullscreen_video.js" };
    sConfigPerios = 0L;
    sAppInfos = new HashSet();
    sAppClientVersion = 0;
    AppMethodBeat.o(157334);
  }
  
  static int _getChromiunVersion()
  {
    AppMethodBeat.i(157284);
    Object localObject = getApplicationContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.webview", 0);
      if (localObject != null)
      {
        i = getVerFromVersionName(((PackageInfo)localObject).versionName);
        if (i > 0)
        {
          AppMethodBeat.o(157284);
          return i;
        }
      }
    }
    catch (Exception localException1)
    {
      int i;
      Log.e("XWalkEnvironment", "Android System WebView is not found");
      try
      {
        String str = new WebView(getApplicationContext()).getSettings().getUserAgentString();
        if (str != null)
        {
          String[] arrayOfString = str.split("Chrome/");
          if ((arrayOfString != null) && (arrayOfString.length != 0))
          {
            if (arrayOfString.length == 1)
            {
              i = arrayOfString[0].length();
              int j = str.length();
              if (i != j) {}
            }
          }
          else
          {
            AppMethodBeat.o(157284);
            return 0;
          }
          i = getVerFromVersionName(arrayOfString[1]);
          AppMethodBeat.o(157284);
          return i;
        }
      }
      catch (Exception localException2)
      {
        Log.e("XWalkEnvironment", "Android System WebView is not found");
        AppMethodBeat.o(157284);
      }
    }
    return 0;
  }
  
  public static Activity activityFromContext(Context paramContext)
  {
    AppMethodBeat.i(157333);
    for (;;)
    {
      if ((paramContext instanceof Activity))
      {
        paramContext = (Activity)paramContext;
        AppMethodBeat.o(157333);
        return paramContext;
      }
      if (!(paramContext instanceof ContextWrapper)) {
        break label59;
      }
      Context localContext = ((ContextWrapper)paramContext).getBaseContext();
      if (localContext == paramContext) {
        break;
      }
      paramContext = localContext;
    }
    AppMethodBeat.o(157333);
    return null;
    label59:
    AppMethodBeat.o(157333);
    return null;
  }
  
  public static void addXWalkInitializeLog(String paramString)
  {
    AppMethodBeat.i(157262);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(157262);
      return;
    }
    Log.i("XWalkUpdater", paramString);
    if (!isTurnOnKVLog)
    {
      AppMethodBeat.o(157262);
      return;
    }
    String str = new SimpleDateFormat("MM-dd hh:mm:ss").format(new Date());
    paramString = sPid + getModuleName() + ":" + str + " : " + paramString;
    SharedPreferences localSharedPreferences = getSharedPreferencesForLog();
    str = localSharedPreferences.getString("log", "");
    str = paramString + "\n" + str;
    paramString = str;
    if (str.length() > 10240) {
      paramString = str.substring(0, 5120);
    }
    localSharedPreferences.edit().putString("log", paramString).apply();
    AppMethodBeat.o(157262);
  }
  
  public static void addXWalkInitializeLog(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157261);
    addXWalkInitializeLog(paramString1 + ": " + paramString2);
    AppMethodBeat.o(157261);
  }
  
  public static void appendAppInfo(String paramString)
  {
    try
    {
      AppMethodBeat.i(195196);
      if (!sAppInfos.contains(paramString)) {
        sAppInfos.add(paramString);
      }
      AppMethodBeat.o(195196);
      return;
    }
    finally {}
  }
  
  public static boolean checkApiVersionAllFileExist(int paramInt)
  {
    AppMethodBeat.i(157314);
    if ((checkApiVersionExtractResourceExist(paramInt)) && (checkApiVersionBaseApkExist(paramInt)))
    {
      AppMethodBeat.o(157314);
      return true;
    }
    AppMethodBeat.o(157314);
    return false;
  }
  
  /* Error */
  public static boolean checkApiVersionAvailable(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 497
    //   3: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_0
    //   7: invokestatic 501	org/xwalk/core/XWalkEnvironment:getExtractedCoreDir	(I)Ljava/lang/String;
    //   10: astore_3
    //   11: iload_0
    //   12: invokestatic 504	org/xwalk/core/XWalkEnvironment:getClassDexFilePath	(I)Ljava/lang/String;
    //   15: astore 4
    //   17: new 506	java/io/File
    //   20: dup
    //   21: aload 4
    //   23: invokespecial 507	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokevirtual 510	java/io/File:exists	()Z
    //   29: istore_2
    //   30: iload_2
    //   31: ifne +11 -> 42
    //   34: ldc_w 497
    //   37: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_0
    //   41: ireturn
    //   42: aload 4
    //   44: iload_0
    //   45: invokestatic 513	org/xwalk/core/XWalkEnvironment:getOptimizedDexDir	(I)Ljava/lang/String;
    //   48: aload_3
    //   49: invokestatic 519	com/tencent/xweb/util/h:ba	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   52: astore_3
    //   53: aload_3
    //   54: ldc_w 521
    //   57: invokevirtual 527	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   60: astore 5
    //   62: ldc_w 443
    //   65: astore_3
    //   66: new 529	org/xwalk/core/ReflectField
    //   69: dup
    //   70: aload 5
    //   72: ldc_w 531
    //   75: invokespecial 534	org/xwalk/core/ReflectField:<init>	(Ljava/lang/Class;Ljava/lang/String;)V
    //   78: invokevirtual 538	org/xwalk/core/ReflectField:get	()Ljava/lang/Object;
    //   81: checkcast 247	java/lang/String
    //   84: astore 4
    //   86: aload 4
    //   88: astore_3
    //   89: new 529	org/xwalk/core/ReflectField
    //   92: dup
    //   93: aload 5
    //   95: ldc_w 540
    //   98: invokespecial 534	org/xwalk/core/ReflectField:<init>	(Ljava/lang/Class;Ljava/lang/String;)V
    //   101: invokevirtual 538	org/xwalk/core/ReflectField:get	()Ljava/lang/Object;
    //   104: checkcast 542	java/lang/Integer
    //   107: invokevirtual 545	java/lang/Integer:intValue	()I
    //   110: istore_0
    //   111: new 529	org/xwalk/core/ReflectField
    //   114: dup
    //   115: aload 5
    //   117: ldc_w 547
    //   120: invokespecial 534	org/xwalk/core/ReflectField:<init>	(Ljava/lang/Class;Ljava/lang/String;)V
    //   123: invokevirtual 538	org/xwalk/core/ReflectField:get	()Ljava/lang/Object;
    //   126: checkcast 542	java/lang/Integer
    //   129: invokevirtual 545	java/lang/Integer:intValue	()I
    //   132: istore_1
    //   133: ldc 122
    //   135: new 417	java/lang/StringBuilder
    //   138: dup
    //   139: ldc_w 549
    //   142: invokespecial 550	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   145: aload_3
    //   146: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 552
    //   152: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: iload_0
    //   156: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: ldc_w 554
    //   162: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: iload_1
    //   166: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 557	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: ldc_w 497
    //   178: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: iconst_1
    //   182: ireturn
    //   183: astore_3
    //   184: ldc_w 497
    //   187: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: iconst_0
    //   191: ireturn
    //   192: astore_3
    //   193: ldc_w 497
    //   196: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: iconst_0
    //   200: ireturn
    //   201: astore 4
    //   203: goto -114 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramInt	int
    //   132	34	1	i	int
    //   29	2	2	bool	boolean
    //   10	136	3	localObject	Object
    //   183	1	3	localException1	Exception
    //   192	1	3	localException2	Exception
    //   15	72	4	str	String
    //   201	1	4	localRuntimeException	java.lang.RuntimeException
    //   60	56	5	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   53	62	183	java/lang/Exception
    //   66	86	183	java/lang/Exception
    //   89	175	183	java/lang/Exception
    //   6	30	192	java/lang/Exception
    //   42	53	192	java/lang/Exception
    //   66	86	201	java/lang/RuntimeException
  }
  
  public static boolean checkApiVersionBaseApkExist(int paramInt)
  {
    AppMethodBeat.i(157315);
    if (new File(getDownloadApkPath(paramInt)).exists())
    {
      AppMethodBeat.o(157315);
      return true;
    }
    AppMethodBeat.o(157315);
    return false;
  }
  
  private static boolean checkApiVersionExtractResourceExist(int paramInt)
  {
    AppMethodBeat.i(157316);
    String[] arrayOfString = MANDATORY_RESOURCES;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (!str.equals("xweb_fullscreen_video.js"))
      {
        File localFile = new File(getExtractedCoreDir(paramInt) + str);
        if (!localFile.exists())
        {
          Log.i("XWalkEnvironment", "XWalkEnvironment checkApiVersionExtractResourceExist not exist Version:" + paramInt + ", resource name:" + str + ", Path:" + localFile.getAbsolutePath());
          AppMethodBeat.o(157316);
          return false;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(157316);
    return true;
  }
  
  public static void clearAllVersion(Context paramContext)
  {
    AppMethodBeat.i(157260);
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null) || (paramContext.getApplicationInfo().dataDir == null))
    {
      AppMethodBeat.o(157260);
      return;
    }
    paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
    if (paramContext == null)
    {
      AppMethodBeat.o(157260);
      return;
    }
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContext[i];
      if ((localObject.getName().startsWith("app_xwalk_")) && (localObject.isDirectory())) {
        c.aPq(localObject.getAbsolutePath());
      }
      i += 1;
    }
    setAvailableVersion(-1, "", "armeabi-v7a");
    setAvailableVersion(-1, "", "arm64-v8a");
    AppMethodBeat.o(157260);
  }
  
  public static boolean containsAppInfo(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(195198);
        paramString = paramString.split("&");
        if ((paramString == null) || (paramString.length == 0))
        {
          AppMethodBeat.o(195198);
          bool = true;
          return bool;
        }
        int j = paramString.length;
        int i = 0;
        if (i >= j) {
          break label102;
        }
        CharSequence localCharSequence = paramString[i];
        if ((!TextUtils.isEmpty(localCharSequence)) && (!sAppInfos.contains(localCharSequence.trim())))
        {
          AppMethodBeat.o(195198);
          continue;
        }
        i += 1;
      }
      finally {}
      continue;
      label102:
      AppMethodBeat.o(195198);
      bool = true;
    }
  }
  
  public static boolean delApiVersion(int paramInt)
  {
    AppMethodBeat.i(157317);
    boolean bool = c.aPq(getVesionDir(paramInt));
    AppMethodBeat.o(157317);
    return bool;
  }
  
  public static String dumpAppInfo()
  {
    AppMethodBeat.i(195197);
    Iterator localIterator = sAppInfos.iterator();
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + ";") {
      str2 = (String)localIterator.next();
    }
    AppMethodBeat.o(195197);
    return str1;
  }
  
  public static int getAppClientVersion()
  {
    try
    {
      int i = sAppClientVersion;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static Context getApplicationContext()
  {
    return sApplicationContext;
  }
  
  private static String getApplicationMetaData(String paramString)
  {
    AppMethodBeat.i(157312);
    try
    {
      paramString = sApplicationContext.getPackageManager().getApplicationInfo(sApplicationContext.getPackageName(), 128).metaData.get(paramString).toString();
      AppMethodBeat.o(157312);
      return paramString;
    }
    catch (NullPointerException paramString)
    {
      AppMethodBeat.o(157312);
      return null;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label44:
      break label44;
    }
  }
  
  public static String getApplicationName()
  {
    AppMethodBeat.i(157295);
    if (sApplicationName == null) {}
    try
    {
      Object localObject = sApplicationContext.getPackageManager();
      sApplicationName = (String)((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(sApplicationContext.getPackageName(), 0));
      label40:
      if ((sApplicationName == null) || (sApplicationName.isEmpty()) || (sApplicationName.matches("[a-z]+\\.[a-z0-9]+\\.[a-z0-9]+.*"))) {
        sApplicationName = "this application";
      }
      Log.d("XWalkEnvironment", "Crosswalk application name: " + sApplicationName);
      localObject = sApplicationName;
      AppMethodBeat.o(157295);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label40;
    }
  }
  
  public static int getAvailableVersion()
  {
    if (sXWebCoreInfo == null) {
      return -1;
    }
    return sXWebCoreInfo.ver;
  }
  
  public static String getAvailableVersionDetail()
  {
    if (sXWebCoreInfo != null) {
      return sXWebCoreInfo.verDetail;
    }
    return "";
  }
  
  public static int getChromiunVersion()
  {
    AppMethodBeat.i(157282);
    if (sNChromiuVersion < 0) {
      sNChromiuVersion = _getChromiunVersion();
    }
    int i = sNChromiuVersion;
    AppMethodBeat.o(157282);
    return i;
  }
  
  public static String getClassDexFilePath(int paramInt)
  {
    AppMethodBeat.i(157280);
    String str = getExtractedCoreDir(paramInt) + File.separator + "classes.dex";
    AppMethodBeat.o(157280);
    return str;
  }
  
  public static long getConfigFetchPeriod()
  {
    return sConfigPerios;
  }
  
  public static ContentResolver getContentResolver()
  {
    AppMethodBeat.i(157320);
    if (sApplicationContext == null)
    {
      Log.e("XWalkEnvironment", "getContentResolver sApplicationContext is null");
      AppMethodBeat.o(157320);
      return null;
    }
    ContentResolver localContentResolver = sApplicationContext.getContentResolver();
    AppMethodBeat.o(157320);
    return localContentResolver;
  }
  
  /* Error */
  public static String getDeviceAbi()
  {
    // Byte code:
    //   0: ldc_w 717
    //   3: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 719	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   9: ifnonnull +103 -> 112
    //   12: getstatic 724	android/os/Build$VERSION:SDK_INT	I
    //   15: bipush 21
    //   17: if_icmplt +14 -> 31
    //   20: getstatic 729	android/os/Build:SUPPORTED_ABIS	[Ljava/lang/String;
    //   23: iconst_0
    //   24: aaload
    //   25: invokevirtual 732	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   28: putstatic 719	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   31: getstatic 719	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   34: ifnonnull +54 -> 88
    //   37: new 734	java/io/InputStreamReader
    //   40: dup
    //   41: invokestatic 740	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   44: ldc_w 742
    //   47: invokevirtual 746	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   50: invokevirtual 752	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   53: invokespecial 755	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   56: astore_1
    //   57: new 757	java/io/BufferedReader
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 760	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   65: astore_0
    //   66: aload_0
    //   67: astore_3
    //   68: aload_1
    //   69: astore_2
    //   70: aload_0
    //   71: invokevirtual 763	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: invokevirtual 732	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   77: putstatic 719	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   80: aload_1
    //   81: invokestatic 767	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   84: aload_0
    //   85: invokestatic 767	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   88: ldc 122
    //   90: new 417	java/lang/StringBuilder
    //   93: dup
    //   94: ldc_w 769
    //   97: invokespecial 550	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: getstatic 719	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   103: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 557	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: getstatic 719	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   115: ifnonnull +139 -> 254
    //   118: ldc_w 717
    //   121: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: ldc_w 443
    //   127: areturn
    //   128: astore_0
    //   129: ldc 122
    //   131: new 417	java/lang/StringBuilder
    //   134: dup
    //   135: ldc_w 771
    //   138: invokespecial 550	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: invokevirtual 774	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   145: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 357	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: goto -123 -> 31
    //   157: astore_0
    //   158: ldc 122
    //   160: new 417	java/lang/StringBuilder
    //   163: dup
    //   164: ldc_w 776
    //   167: invokespecial 550	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: invokevirtual 777	java/lang/NoSuchFieldError:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 357	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: goto -152 -> 31
    //   186: astore 4
    //   188: aconst_null
    //   189: astore_0
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_0
    //   193: astore_3
    //   194: aload_1
    //   195: astore_2
    //   196: ldc 122
    //   198: new 417	java/lang/StringBuilder
    //   201: dup
    //   202: ldc_w 769
    //   205: invokespecial 550	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: aload 4
    //   210: invokevirtual 774	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   213: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 357	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_1
    //   223: invokestatic 767	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   226: aload_0
    //   227: invokestatic 767	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   230: goto -142 -> 88
    //   233: astore_0
    //   234: aconst_null
    //   235: astore_3
    //   236: aconst_null
    //   237: astore_1
    //   238: aload_1
    //   239: invokestatic 767	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   242: aload_3
    //   243: invokestatic 767	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   246: ldc_w 717
    //   249: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_0
    //   253: athrow
    //   254: getstatic 719	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   257: astore_0
    //   258: ldc_w 717
    //   261: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_0
    //   265: areturn
    //   266: astore_0
    //   267: aconst_null
    //   268: astore_3
    //   269: goto -31 -> 238
    //   272: astore_0
    //   273: aload_2
    //   274: astore_1
    //   275: goto -37 -> 238
    //   278: astore 4
    //   280: aconst_null
    //   281: astore_0
    //   282: goto -90 -> 192
    //   285: astore 4
    //   287: goto -95 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   65	20	0	localBufferedReader	java.io.BufferedReader
    //   128	14	0	localException1	Exception
    //   157	14	0	localNoSuchFieldError	NoSuchFieldError
    //   189	38	0	localCloseable	Closeable
    //   233	20	0	localObject1	Object
    //   257	8	0	str	String
    //   266	1	0	localObject2	Object
    //   272	1	0	localObject3	Object
    //   281	1	0	localObject4	Object
    //   56	219	1	localObject5	Object
    //   69	205	2	localObject6	Object
    //   67	202	3	localObject7	Object
    //   186	23	4	localException2	Exception
    //   278	1	4	localException3	Exception
    //   285	1	4	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   12	31	128	java/lang/Exception
    //   12	31	157	java/lang/NoSuchFieldError
    //   37	57	186	java/lang/Exception
    //   37	57	233	finally
    //   57	66	266	finally
    //   70	80	272	finally
    //   196	222	272	finally
    //   57	66	278	java/lang/Exception
    //   70	80	285	java/lang/Exception
  }
  
  public static String getDeviceId()
  {
    AppMethodBeat.i(157309);
    if (sStrDeviceId == null) {}
    for (;;)
    {
      try
      {
        localObject = (TelephonyManager)getApplicationContext().getSystemService("phone");
        if (localObject != null) {
          continue;
        }
        sStrDeviceId = "";
      }
      catch (Exception localException)
      {
        Object localObject;
        sStrDeviceId = "";
        Log.e("XWalkEnvironment", "getDeviceId failed " + localException.getMessage());
        continue;
      }
      localObject = sStrDeviceId;
      AppMethodBeat.o(157309);
      return localObject;
      sStrDeviceId = ((TelephonyManager)localObject).getDeviceId();
    }
  }
  
  public static int getDeviceRd()
  {
    AppMethodBeat.i(157303);
    if (sNDeviceRd <= 0)
    {
      i = getSharedPreferences().getInt("sNDeviceRd", -1);
      sNDeviceRd = i;
      if (i <= 0)
      {
        sNDeviceRd = new Random().nextInt(10000000) + 1;
        getSharedPreferences().edit().putInt("sNDeviceRd", sNDeviceRd).apply();
      }
    }
    int i = sNDeviceRd;
    AppMethodBeat.o(157303);
    return i % 10000 + 1;
  }
  
  public static String getDownloadApkDir(int paramInt)
  {
    AppMethodBeat.i(157277);
    String str = getVesionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(157277);
    return str;
  }
  
  public static String getDownloadApkPath(int paramInt)
  {
    AppMethodBeat.i(157278);
    String str = getVesionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    str = str + File.separator + "base.apk";
    AppMethodBeat.o(157278);
    return str;
  }
  
  public static String getDownloadApkPath(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(157326);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getDownloadApkPath with context, context is null");
      AppMethodBeat.o(157326);
      return "";
    }
    paramContext = getVesionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkEnvironment", "getDownloadApkPath with context, versionDir is empty");
      AppMethodBeat.o(157326);
      return "";
    }
    paramContext = paramContext + File.separator + "apk" + File.separator + "base.apk";
    AppMethodBeat.o(157326);
    return paramContext;
  }
  
  public static String getDownloadPatchPath(int paramInt)
  {
    AppMethodBeat.i(157279);
    String str = getVesionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    str = str + File.separator + "patch.zip";
    AppMethodBeat.o(157279);
    return str;
  }
  
  public static String getDownloadResFileListConfig(int paramInt)
  {
    AppMethodBeat.i(157274);
    String str = getExtractedCoreFile(paramInt, "reslist.config");
    AppMethodBeat.o(157274);
    return str;
  }
  
  public static String getDownloadZipDir(int paramInt)
  {
    AppMethodBeat.i(157270);
    String str = getVesionDir(paramInt) + File.separator + "zip";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    str = str + File.separator + "base.zip";
    AppMethodBeat.o(157270);
    return str;
  }
  
  public static String getDownloadZipFileListConfig(int paramInt)
  {
    AppMethodBeat.i(157273);
    String str = getExtractedCoreFile(paramInt, "filelist.config");
    AppMethodBeat.o(157273);
    return str;
  }
  
  public static String getDownloadZipFileListConfig(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(157329);
    paramContext = getExtractedCoreFile(paramContext, paramInt, "filelist.config");
    AppMethodBeat.o(157329);
    return paramContext;
  }
  
  public static String getExtractedCoreDir(int paramInt)
  {
    AppMethodBeat.i(157267);
    String str = getVesionDir(paramInt) + File.separator + "extracted_xwalkcore";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(157267);
    return str;
  }
  
  public static String getExtractedCoreFile(int paramInt, String paramString)
  {
    AppMethodBeat.i(157268);
    String str = getVesionDir(paramInt) + File.separator + "extracted_xwalkcore";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = str + File.separator + paramString;
    AppMethodBeat.o(157268);
    return paramString;
  }
  
  public static String getExtractedCoreFile(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(157327);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getExtractedCoreFile with context, context is null");
      AppMethodBeat.o(157327);
      return "";
    }
    paramContext = getVesionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkEnvironment", "getExtractedCoreFile with context, versionDir is empty");
      AppMethodBeat.o(157327);
      return "";
    }
    paramContext = paramContext + File.separator + "extracted_xwalkcore" + File.separator + paramString;
    AppMethodBeat.o(157327);
    return paramContext;
  }
  
  private static boolean getFeatureSupport(int paramInt)
  {
    AppMethodBeat.i(157253);
    boolean bool = ((Boolean)j.g(WebView.c.INC).excute("STR_CMD_FEATURE_SUPPORT", new Object[] { Integer.valueOf(paramInt) })).booleanValue();
    AppMethodBeat.o(157253);
    return bool;
  }
  
  public static int getForceDarkBehavior()
  {
    return sForceDarkBehavior;
  }
  
  public static boolean getForceDarkMode()
  {
    return sIsForceDarkMode;
  }
  
  public static int getGrayValue()
  {
    AppMethodBeat.i(157263);
    if (s_grayValue != 0)
    {
      i = s_grayValue;
      AppMethodBeat.o(157263);
      return i;
    }
    try
    {
      i = getSharedPreferences().getInt("TEST_GRAY_VALUE", -1);
      s_grayValue = i;
      if (i <= 0) {
        s_grayValue = getSharedPreferences().getInt("GRAY_VALUE", -1);
      }
      if (s_grayValue <= 0) {
        s_grayValue = getDeviceRd();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("XWalkEnvironment", "match gray rate exception: " + localException.getMessage());
      }
    }
    int i = s_grayValue;
    AppMethodBeat.o(157263);
    return i;
  }
  
  public static int getInstalledNewstVersion(Context paramContext)
  {
    AppMethodBeat.i(157257);
    if (paramContext == null)
    {
      AppMethodBeat.o(157257);
      return 0;
    }
    int i = XWebCoreInfo.getCurAbiInstalledNewestVersion(paramContext);
    AppMethodBeat.o(157257);
    return i;
  }
  
  public static int getInstalledNewstVersion(String paramString)
  {
    AppMethodBeat.i(157255);
    int i = XWebCoreInfo.getBackupCoreInfo(paramString).ver;
    AppMethodBeat.o(157255);
    return i;
  }
  
  public static int getInstalledNewstVersionForCurAbi()
  {
    AppMethodBeat.i(157256);
    int i = getInstalledNewstVersion(getRuntimeAbi());
    AppMethodBeat.o(157256);
    return i;
  }
  
  public static int getInstalledPluginVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(157240);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getInstalledPluginVersion, context is null");
      AppMethodBeat.o(157240);
      return -2;
    }
    paramContext = paramContext.getSharedPreferences("xwalk_plugin_version_info_".concat(String.valueOf(paramString)), 4);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getInstalledPluginVersion, sp is null");
      AppMethodBeat.o(157240);
      return -3;
    }
    int i = paramContext.getInt("availableVersion", -1);
    AppMethodBeat.o(157240);
    return i;
  }
  
  public static int getIpType()
  {
    AppMethodBeat.i(157306);
    int i = getSharedPreferences().getInt("IP_TYPE", -2);
    AppMethodBeat.o(157306);
    return i;
  }
  
  public static SharedPreferences getMMKVSharedPreferences(String paramString)
  {
    AppMethodBeat.i(157232);
    paramString = getMMKVSharedPreferencesEx(paramString, 4, false);
    AppMethodBeat.o(157232);
    return paramString;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesEx(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157234);
    if (sSPProvider != null) {
      try
      {
        Object localObject1 = sSPProvider;
        getApplicationContext();
        localObject1 = ((ISharedPreferenceProvider)localObject1).z(paramString, paramInt, paramBoolean);
        if (localObject1 != null)
        {
          AppMethodBeat.o(157234);
          return localObject1;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Log.e("XWalkEnvironment", "got sp from mmkv callback failed " + localException1.getMessage());
          localObject2 = null;
        }
        com.tencent.xweb.util.g.xs(176L);
      }
    }
    for (;;)
    {
      initSafePsProvider();
      if (sMMKVMethod != null) {
        break;
      }
      paramString = sApplicationContext.getSharedPreferences(paramString, paramInt);
      AppMethodBeat.o(157234);
      return paramString;
      com.tencent.xweb.util.g.xs(177L);
    }
    try
    {
      localObject2 = sMMKVMethod.invoke(null, new Object[] { getApplicationContext(), paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      if ((localObject2 != null) && ((localObject2 instanceof SharedPreferences))) {
        break label192;
      }
      Log.e("XWalkEnvironment", "get mmmkv from reflection failed");
    }
    catch (Exception localException2)
    {
      label169:
      break label169;
    }
    com.tencent.xweb.util.g.xs(179L);
    paramString = sApplicationContext.getSharedPreferences(paramString, paramInt);
    AppMethodBeat.o(157234);
    return paramString;
    label192:
    Object localObject2 = (SharedPreferences)localObject2;
    AppMethodBeat.o(157234);
    return localObject2;
  }
  
  public static SharedPreferences getMMKVSharedTransportOld(String paramString)
  {
    AppMethodBeat.i(157233);
    paramString = getMMKVSharedPreferencesEx(paramString, 4, true);
    AppMethodBeat.o(157233);
    return paramString;
  }
  
  public static String getModuleName()
  {
    AppMethodBeat.i(157318);
    String str = getProcessName();
    if (str == null)
    {
      AppMethodBeat.o(157318);
      return "";
    }
    if (str.contains(":"))
    {
      str = str.substring(str.lastIndexOf(":") + 1).toLowerCase();
      AppMethodBeat.o(157318);
      return str;
    }
    if (str.contains("."))
    {
      str = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
      AppMethodBeat.o(157318);
      return str;
    }
    AppMethodBeat.o(157318);
    return str;
  }
  
  public static String getOptimizedDexDir(int paramInt)
  {
    AppMethodBeat.i(157269);
    String str = getVesionDir(paramInt) + File.separator + "dex";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(157269);
    return str;
  }
  
  public static Context getPackageContext(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(157321);
    if (sApplicationContext == null)
    {
      Log.e("XWalkEnvironment", "getTargetPackageContext sApplicationContext is null");
      AppMethodBeat.o(157321);
      return null;
    }
    try
    {
      paramString = sApplicationContext.createPackageContext(paramString, 2);
      AppMethodBeat.o(157321);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("XWalkEnvironment", paramString.getMessage());
        paramString = localObject;
      }
    }
  }
  
  public static String getPackageName()
  {
    AppMethodBeat.i(157324);
    if (sApplicationContext == null)
    {
      Log.e("XWalkEnvironment", "getPackageName sApplicationContext is null");
      AppMethodBeat.o(157324);
      return "";
    }
    String str = sApplicationContext.getPackageName();
    AppMethodBeat.o(157324);
    return str;
  }
  
  public static String getPatchConfig(int paramInt)
  {
    AppMethodBeat.i(157276);
    String str = getPatchZipTempDecompressFilePath(paramInt, "patch.config");
    AppMethodBeat.o(157276);
    return str;
  }
  
  public static String getPatchFileListConfig(int paramInt)
  {
    AppMethodBeat.i(157275);
    String str = getPatchZipTempDecompressFilePath(paramInt, "filelist.config");
    AppMethodBeat.o(157275);
    return str;
  }
  
  public static String getPatchFileListConfig(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(157330);
    paramContext = getPatchZipTempDecompressFilePath(paramContext, paramInt, "filelist.config");
    AppMethodBeat.o(157330);
    return paramContext;
  }
  
  public static String getPatchZipTempDecompressFilePath(int paramInt, String paramString)
  {
    AppMethodBeat.i(157272);
    String str = getVesionDir(paramInt) + File.separator + "patch_temp_decompress";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = str + File.separator + paramString;
    AppMethodBeat.o(157272);
    return paramString;
  }
  
  public static String getPatchZipTempDecompressFilePath(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(157328);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getPatchZipTempDecompressFilePath with context, context is null");
      AppMethodBeat.o(157328);
      return "";
    }
    paramContext = getVesionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkEnvironment", "getPatchZipTempDecompressFilePath with context, versionDir is empty");
      AppMethodBeat.o(157328);
      return "";
    }
    paramContext = paramContext + File.separator + "patch_temp_decompress" + File.separator + paramString;
    AppMethodBeat.o(157328);
    return paramContext;
  }
  
  public static String getPatchZipTempDecompressPath(int paramInt)
  {
    AppMethodBeat.i(157271);
    String str = getVesionDir(paramInt) + File.separator + "patch_temp_decompress";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(157271);
    return str;
  }
  
  public static String getPluginBaseDir()
  {
    AppMethodBeat.i(157243);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(157243);
      return "";
    }
    String str = sApplicationContext.getDir("xwalkplugin", 0).getAbsolutePath();
    AppMethodBeat.o(157243);
    return str;
  }
  
  public static String getPluginConfigUrl()
  {
    AppMethodBeat.i(157292);
    String str = getPluginTestConfigUrl();
    if (isValidConfigHost(str))
    {
      addXWalkInitializeLog("plugin use test config url: ".concat(String.valueOf(str)));
      AppMethodBeat.o(157292);
      return str;
    }
    str = getTempPluginUpdateConfigUrl();
    if (isValidConfigHost(str))
    {
      addXWalkInitializeLog("plugin use temp config url: ".concat(String.valueOf(str)));
      AppMethodBeat.o(157292);
      return str;
    }
    addXWalkInitializeLog("plugin use release config url: https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml");
    AppMethodBeat.o(157292);
    return "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
  }
  
  public static String getPluginTestConfigUrl()
  {
    AppMethodBeat.i(157293);
    Object localObject = getSharedPreferencesForTestXWeb();
    if (localObject == null)
    {
      Log.e("XWalkEnvironment", "hasPluginTestConfigUrl sp is null");
      AppMethodBeat.o(157293);
      return "";
    }
    localObject = ((SharedPreferences)localObject).getString("XWEB_PLUGIN_TEST_CONFIG_URL", "");
    if (localObject == null)
    {
      AppMethodBeat.o(157293);
      return "";
    }
    localObject = ((String)localObject).trim();
    if (((String)localObject).isEmpty())
    {
      AppMethodBeat.o(157293);
      return "";
    }
    AppMethodBeat.o(157293);
    return localObject;
  }
  
  public static String getPluginUpdateConfigFilePath()
  {
    AppMethodBeat.i(157242);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(157242);
      return "";
    }
    String str = getUpdateConfigDir() + File.separator + "pluginUpdateConfig.xml";
    AppMethodBeat.o(157242);
    return str;
  }
  
  public static int getPluginUpdatePeriod()
  {
    AppMethodBeat.i(157291);
    int i = getTempPluginUpdatePeriod();
    if (i > 0)
    {
      addXWalkInitializeLog("getPluginUpdatePeriod use tempPeriod");
      AppMethodBeat.o(157291);
      return i;
    }
    addXWalkInitializeLog("getPluginUpdatePeriod use defaultPeriod");
    AppMethodBeat.o(157291);
    return 90000000;
  }
  
  public static String getProcessName()
  {
    AppMethodBeat.i(157319);
    if (sStrCurentProcessName != null)
    {
      localObject = sStrCurentProcessName;
      AppMethodBeat.o(157319);
      return localObject;
    }
    Object localObject = getXWebInitArgs("processname");
    if (localObject != null)
    {
      localObject = localObject.toString();
      sStrCurentProcessName = (String)localObject;
      AppMethodBeat.o(157319);
      return localObject;
    }
    localObject = getApplicationContext();
    int i = Process.myPid();
    if (localObject == null)
    {
      AppMethodBeat.o(157319);
      return null;
    }
    localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
    if (localObject != null)
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (localRunningAppProcessInfo.pid == i) {
            sStrCurentProcessName = localRunningAppProcessInfo.processName;
          }
        }
      }
    }
    localObject = sStrCurentProcessName;
    AppMethodBeat.o(157319);
    return localObject;
  }
  
  public static SharedPreferences getProcessSafePreferences(String paramString, int paramInt)
  {
    AppMethodBeat.i(157231);
    paramString = sApplicationContext.getSharedPreferences(paramString, paramInt);
    AppMethodBeat.o(157231);
    return paramString;
  }
  
  public static String getRuntimeAbi()
  {
    AppMethodBeat.i(157302);
    if (sRuntimeAbi == null) {}
    try
    {
      String str = Build.CPU_ABI.toLowerCase();
      switch (str.hashCode())
      {
      case -738963905: 
      case 145444210: 
      case 1431565292: 
      case 117110: 
      case -806050265: 
        for (sRuntimeAbi = str;; sRuntimeAbi = "armeabi-v7a")
        {
          if (TextUtils.isEmpty(sRuntimeAbi)) {}
          try
          {
            str = System.getProperty("os.arch").toLowerCase();
            switch (str.hashCode())
            {
            case 117110: 
              sRuntimeAbi = "arch:".concat(String.valueOf(str));
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Log.e("XWalkEnvironment", "get abi from os.arch failed , err = " + localException2.getMessage());
              continue;
              if (is64bitDevice())
              {
                sRuntimeAbi = "x86_64";
              }
              else
              {
                sRuntimeAbi = "x86";
                continue;
                sRuntimeAbi = "armeabi-v7a";
                continue;
                if (is64bitDevice())
                {
                  sRuntimeAbi = "arm64-v8a";
                }
                else
                {
                  sRuntimeAbi = "armeabi-v7a";
                  continue;
                  if ((sRuntimeAbi.equals("arm64-v8a")) && (isIaDevice())) {
                    sRuntimeAbi = "x86_64";
                  }
                }
              }
            }
            i = -1;
            switch (i)
            {
            }
          }
          if (!sRuntimeAbi.equals("armeabi-v7a")) {
            break label689;
          }
          if (isIaDevice()) {
            sRuntimeAbi = "x86";
          }
          Log.i("XWalkEnvironment", "Runtime ABI: " + sRuntimeAbi);
          str = sRuntimeAbi;
          AppMethodBeat.o(157302);
          return str;
          if (!str.equals("armeabi")) {
            break label715;
          }
          i = 0;
          break label717;
          if (!str.equals("armeabi-v7a")) {
            break label715;
          }
          i = 1;
          break label717;
          if (!str.equals("arm64-v8a")) {
            break label715;
          }
          i = 2;
          break label717;
          if (!str.equals("x86")) {
            break label715;
          }
          i = 3;
          break label717;
          if (!str.equals("x86_64")) {
            break label715;
          }
          i = 4;
          break label717;
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Log.e("XWalkEnvironment", "get abi from cpu_abi failed , err = " + localException1.getMessage());
        continue;
        sRuntimeAbi = "arm64-v8a";
        continue;
        sRuntimeAbi = "x86";
        continue;
        sRuntimeAbi = "x86_64";
        continue;
        if (localException1.equals("x86"))
        {
          i = 0;
          break label757;
          if (localException1.equals("i686"))
          {
            i = 1;
            break label757;
            if (localException1.equals("i386"))
            {
              i = 2;
              break label757;
              if (localException1.equals("ia32"))
              {
                i = 3;
                break label757;
                if (localException1.equals("x64"))
                {
                  i = 4;
                  break label757;
                  if (localException1.equals("x86_64"))
                  {
                    i = 5;
                    break label757;
                    if (localException1.equals("armv7l"))
                    {
                      i = 6;
                      break label757;
                      if (localException1.equals("armeabi"))
                      {
                        i = 7;
                        break label757;
                        if (localException1.equals("armeabi-v7a"))
                        {
                          i = 8;
                          break label757;
                          if (localException1.equals("aarch64"))
                          {
                            i = 9;
                            break label757;
                            if (localException1.equals("armv8"))
                            {
                              i = 10;
                              break label757;
                              if (localException1.equals("arm64"))
                              {
                                i = 11;
                                break label757;
                                sRuntimeAbi = "x86";
                                continue;
                                label689:
                                label715:
                                label717:
                                continue;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        int i = -1;
        label757:
        switch (i)
        {
        }
      }
    }
  }
  
  public static SharedPreferences getSharedPreferences()
  {
    AppMethodBeat.i(157244);
    SharedPreferences localSharedPreferences = sApplicationContext.getSharedPreferences("libxwalkcore", 4);
    AppMethodBeat.o(157244);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForFileReaderRecord()
  {
    AppMethodBeat.i(157241);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(157241);
      return null;
    }
    SharedPreferences localSharedPreferences = getProcessSafePreferences("xwalk_reader_record", 4);
    AppMethodBeat.o(157241);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForLog()
  {
    AppMethodBeat.i(157237);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(157237);
      return null;
    }
    SharedPreferences localSharedPreferences = getMMKVSharedPreferencesEx("UPDATELOG", 4, true);
    AppMethodBeat.o(157237);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForPluginUpdateInfo()
  {
    AppMethodBeat.i(157238);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(157238);
      return null;
    }
    SharedPreferences localSharedPreferences = getProcessSafePreferences("xwalk_plugin_update_info", 4);
    AppMethodBeat.o(157238);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForPluginVersionInfo(String paramString)
  {
    AppMethodBeat.i(157239);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(157239);
      return null;
    }
    paramString = getProcessSafePreferences("xwalk_plugin_version_info_".concat(String.valueOf(paramString)), 4);
    AppMethodBeat.o(157239);
    return paramString;
  }
  
  public static SharedPreferences getSharedPreferencesForTestXWeb()
  {
    AppMethodBeat.i(157290);
    if (sApplicationContext == null)
    {
      Log.e("XWalkEnvironment", "getSharedPreferencesForTestXWeb context is null");
      AppMethodBeat.o(157290);
      return null;
    }
    SharedPreferences localSharedPreferences = sApplicationContext.getSharedPreferences("TESTXWEB", 4);
    AppMethodBeat.o(157290);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForUpdateConfig()
  {
    AppMethodBeat.i(157235);
    SharedPreferences localSharedPreferences = getProcessSafePreferences("UPDATEINFOTAG", 4);
    AppMethodBeat.o(157235);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForVersionInfo()
  {
    AppMethodBeat.i(157236);
    SharedPreferences localSharedPreferences = sApplicationContext.getSharedPreferences("XWALKINFOS", 4);
    AppMethodBeat.o(157236);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForXWEBUpdater()
  {
    AppMethodBeat.i(157332);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferencesEx("XWEB_UPDATER", 4, false);
    AppMethodBeat.o(157332);
    return localSharedPreferences;
  }
  
  public static String getTempPluginUpdateConfigUrl()
  {
    try
    {
      String str = sStrTempPluginUpdateConfigUrl;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int getTempPluginUpdatePeriod()
  {
    try
    {
      int i = sTempPluginUpdatePeriod;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getTempUpdateConfigUrl()
  {
    try
    {
      String str = sStrTempUpdateConfigUrl;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getTestDownLoadUrl(Context paramContext)
  {
    AppMethodBeat.i(157286);
    paramContext = paramContext.getSharedPreferences("TESTXWEB", 4).getString("XWEB_TEST_CONFIG_URL", "");
    AppMethodBeat.o(157286);
    return paramContext;
  }
  
  public static String getUpdateConfigDir()
  {
    AppMethodBeat.i(157265);
    String str = sApplicationContext.getDir("xwalkconfig", 0).getAbsolutePath();
    AppMethodBeat.o(157265);
    return str;
  }
  
  public static String getUpdateConfigFullPath()
  {
    AppMethodBeat.i(157266);
    String str = getUpdateConfigDir() + File.separator + "updateConfg.xml";
    AppMethodBeat.o(157266);
    return str;
  }
  
  public static int getUserType()
  {
    AppMethodBeat.i(157307);
    int i = getIpType();
    AppMethodBeat.o(157307);
    return i;
  }
  
  public static boolean getUsingCustomContext()
  {
    return sUsingCustomContext;
  }
  
  static int getVerFromVersionName(String paramString)
  {
    AppMethodBeat.i(157285);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(157285);
      return 0;
    }
    String[] arrayOfString = paramString.split("\\.");
    try
    {
      int i = Integer.parseInt(arrayOfString[0]);
      AppMethodBeat.o(157285);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("XWalkEnvironment", "parse to int error str is :".concat(String.valueOf(paramString)));
      AppMethodBeat.o(157285);
    }
    return 0;
  }
  
  public static String getVesionDir(int paramInt)
  {
    AppMethodBeat.i(157259);
    String str = sApplicationContext.getDir("xwalk_".concat(String.valueOf(paramInt)), 0).getAbsolutePath();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(157259);
    return str;
  }
  
  public static String getVesionDir(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(157325);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getVersionDir with context, context is null");
      AppMethodBeat.o(157325);
      return "";
    }
    paramContext = paramContext.getDir("xwalk_".concat(String.valueOf(paramInt)), 0).getAbsolutePath();
    AppMethodBeat.o(157325);
    return paramContext;
  }
  
  public static String getXWalkInitializeLog()
  {
    AppMethodBeat.i(157264);
    Object localObject = getSharedPreferencesForLog();
    if (localObject == null)
    {
      AppMethodBeat.o(157264);
      return "";
    }
    localObject = ((SharedPreferences)localObject).getString("log", "");
    AppMethodBeat.o(157264);
    return localObject;
  }
  
  public static String getXWalkUpdateConfigUrl()
  {
    AppMethodBeat.i(157289);
    String str = getTestDownLoadUrl(getApplicationContext());
    sXWalkDownConfigUrl = str;
    if (isValidConfigHost(str)) {
      addXWalkInitializeLog("use test config url : " + sXWalkDownConfigUrl);
    }
    for (;;)
    {
      Log.i("XWalkEnvironment", "use update config url = " + sXWalkDownConfigUrl);
      str = sXWalkDownConfigUrl;
      AppMethodBeat.o(157289);
      return str;
      str = getTempUpdateConfigUrl();
      sXWalkDownConfigUrl = str;
      if (isValidConfigHost(str)) {
        addXWalkInitializeLog("use temp config url : " + sXWalkDownConfigUrl);
      } else if (isIaDevice()) {
        sXWalkDownConfigUrl = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86.xml";
      } else {
        sXWalkDownConfigUrl = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig.xml";
      }
    }
  }
  
  /* Error */
  public static Object getXWebInitArgs(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 1212
    //   6: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 1214	org/xwalk/core/XWalkEnvironment:sXWebArgs	Ljava/util/HashMap;
    //   12: ifnull +13 -> 25
    //   15: getstatic 1214	org/xwalk/core/XWalkEnvironment:sXWebArgs	Ljava/util/HashMap;
    //   18: aload_0
    //   19: invokevirtual 1219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   22: ifne +16 -> 38
    //   25: aconst_null
    //   26: astore_0
    //   27: ldc_w 1212
    //   30: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: areturn
    //   38: getstatic 1214	org/xwalk/core/XWalkEnvironment:sXWebArgs	Ljava/util/HashMap;
    //   41: aload_0
    //   42: invokevirtual 1222	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: astore_0
    //   46: ldc_w 1212
    //   49: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -19 -> 33
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	25	55	finally
    //   27	33	55	finally
    //   38	52	55	finally
  }
  
  /* Error */
  public static String getXWebInitArgs(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 1223
    //   6: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 1059	org/xwalk/core/XWalkEnvironment:getXWebInitArgs	(Ljava/lang/String;)Ljava/lang/Object;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnull +10 -> 25
    //   18: aload_0
    //   19: instanceof 247
    //   22: ifne +14 -> 36
    //   25: ldc_w 1223
    //   28: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: aload_0
    //   37: checkcast 247	java/lang/String
    //   40: astore_1
    //   41: ldc_w 1223
    //   44: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -16 -> 31
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramString1	String
    //   0	56	1	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   3	14	50	finally
    //   18	25	50	finally
    //   25	31	50	finally
    //   36	47	50	finally
  }
  
  public static boolean getXWebInitArgs(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(157230);
        paramString = getXWebInitArgs(paramString);
        if (paramString != null) {
          continue;
        }
        AppMethodBeat.o(157230);
      }
      finally
      {
        try
        {
          boolean bool = Boolean.valueOf(paramString.toString()).booleanValue();
          paramBoolean = bool;
          AppMethodBeat.o(157230);
        }
        catch (Exception paramString)
        {
          Log.e("XWalkEnvironment", "getXWebInitArgs boolean parse failed");
          AppMethodBeat.o(157230);
        }
        paramString = finally;
      }
      return paramBoolean;
    }
  }
  
  public static boolean hasAvailableVersion()
  {
    AppMethodBeat.i(157254);
    if (49 > getAvailableVersion())
    {
      AppMethodBeat.o(157254);
      return false;
    }
    AppMethodBeat.o(157254);
    return true;
  }
  
  public static boolean hasInstalledAvailableVersion()
  {
    AppMethodBeat.i(195194);
    if (49 > getInstalledNewstVersionForCurAbi())
    {
      AppMethodBeat.o(195194);
      return false;
    }
    AppMethodBeat.o(195194);
    return true;
  }
  
  /* Error */
  public static void init(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 1240
    //   6: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +9 -> 19
    //   13: getstatic 646	org/xwalk/core/XWalkEnvironment:sApplicationContext	Landroid/content/Context;
    //   16: ifnull +13 -> 29
    //   19: ldc_w 1240
    //   22: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: invokevirtual 1241	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   33: putstatic 646	org/xwalk/core/XWalkEnvironment:sApplicationContext	Landroid/content/Context;
    //   36: invokestatic 901	org/xwalk/core/XWalkEnvironment:getRuntimeAbi	()Ljava/lang/String;
    //   39: astore_2
    //   40: ldc 122
    //   42: ldc_w 1243
    //   45: aload_2
    //   46: invokestatic 911	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   49: invokevirtual 914	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   52: invokestatic 402	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_2
    //   56: invokestatic 896	org/xwalk/core/XWebCoreInfo:getBackupCoreInfo	(Ljava/lang/String;)Lorg/xwalk/core/XWebCoreInfo;
    //   59: astore_3
    //   60: aload_3
    //   61: getfield 692	org/xwalk/core/XWebCoreInfo:ver	I
    //   64: ifgt +92 -> 156
    //   67: invokestatic 1245	org/xwalk/core/XWalkEnvironment:getSharedPreferencesForVersionInfo	()Landroid/content/SharedPreferences;
    //   70: ldc_w 1247
    //   73: iconst_0
    //   74: invokeinterface 1250 3 0
    //   79: ifne +47 -> 126
    //   82: invokestatic 1245	org/xwalk/core/XWalkEnvironment:getSharedPreferencesForVersionInfo	()Landroid/content/SharedPreferences;
    //   85: ldc 86
    //   87: iconst_m1
    //   88: invokeinterface 799 3 0
    //   93: istore_1
    //   94: invokestatic 1245	org/xwalk/core/XWalkEnvironment:getSharedPreferencesForVersionInfo	()Landroid/content/SharedPreferences;
    //   97: ldc_w 1252
    //   100: ldc_w 443
    //   103: invokeinterface 449 3 0
    //   108: astore 4
    //   110: aload_3
    //   111: aload_2
    //   112: putfield 1255	org/xwalk/core/XWebCoreInfo:strAbi	Ljava/lang/String;
    //   115: aload_3
    //   116: iload_1
    //   117: putfield 692	org/xwalk/core/XWebCoreInfo:ver	I
    //   120: aload_3
    //   121: aload 4
    //   123: putfield 696	org/xwalk/core/XWebCoreInfo:verDetail	Ljava/lang/String;
    //   126: aload_3
    //   127: invokestatic 1259	org/xwalk/core/XWebCoreInfo:setVersionForAbi	(Lorg/xwalk/core/XWebCoreInfo;)Z
    //   130: ifeq +26 -> 156
    //   133: invokestatic 1245	org/xwalk/core/XWalkEnvironment:getSharedPreferencesForVersionInfo	()Landroid/content/SharedPreferences;
    //   136: invokeinterface 459 1 0
    //   141: ldc_w 1247
    //   144: iconst_1
    //   145: invokeinterface 1263 3 0
    //   150: invokeinterface 1266 1 0
    //   155: pop
    //   156: aload_3
    //   157: putstatic 687	org/xwalk/core/XWalkEnvironment:sXWebCoreInfo	Lorg/xwalk/core/XWebCoreInfo;
    //   160: getstatic 251	org/xwalk/core/XWalkEnvironment:sIsPluginInited	Z
    //   163: ifne +9 -> 172
    //   166: invokestatic 1269	org/xwalk/core/XWalkEnvironment:initXWalkPlugins	()Z
    //   169: putstatic 251	org/xwalk/core/XWalkEnvironment:sIsPluginInited	Z
    //   172: aload_0
    //   173: invokestatic 1274	com/tencent/xweb/x:kW	(Landroid/content/Context;)V
    //   176: invokestatic 1277	org/xwalk/core/XWalkEnvironment:initTurnOnKVLog	()V
    //   179: ldc_w 1240
    //   182: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: goto -160 -> 25
    //   188: astore_0
    //   189: ldc 2
    //   191: monitorexit
    //   192: aload_0
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramContext	Context
    //   93	24	1	i	int
    //   39	73	2	str1	String
    //   59	98	3	localXWebCoreInfo	XWebCoreInfo
    //   108	14	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	9	188	finally
    //   13	19	188	finally
    //   19	25	188	finally
    //   29	126	188	finally
    //   126	156	188	finally
    //   156	172	188	finally
    //   172	185	188	finally
  }
  
  static void initSafePsProvider()
  {
    AppMethodBeat.i(157228);
    if (sBHasInitedSafePsProvider)
    {
      AppMethodBeat.o(157228);
      return;
    }
    try
    {
      sMMKVMethod = Class.forName("com.tencent.mm.cr.c").getMethod("getMMKV", new Class[] { Context.class, String.class, Integer.TYPE, Boolean.TYPE });
      label61:
      if (sMMKVMethod == null)
      {
        com.tencent.xweb.util.g.xs(178L);
        Log.e("XWalkEnvironment", "initSafePsProvider failed");
      }
      for (;;)
      {
        sBHasInitedSafePsProvider = true;
        AppMethodBeat.o(157228);
        return;
        Log.i("XWalkEnvironment", "initSafePsProvider suscsess");
      }
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
  
  public static void initTurnOnKVLog()
  {
    AppMethodBeat.i(157225);
    try
    {
      isTurnOnKVLog = x.fqR().fqV();
      AppMethodBeat.o(157225);
      return;
    }
    catch (Exception localException)
    {
      Log.e("XWalkEnvironment", "init log failed");
      AppMethodBeat.o(157225);
    }
  }
  
  private static boolean initXWalkPlugins()
  {
    AppMethodBeat.i(157226);
    boolean bool = com.tencent.xweb.xwalk.a.g.ftj();
    AppMethodBeat.o(157226);
    return bool;
  }
  
  public static boolean is64BitRuntime()
  {
    AppMethodBeat.i(157301);
    String str = getRuntimeAbi();
    if (("arm64-v8a".equalsIgnoreCase(str)) || ("x86_64".equalsIgnoreCase(str)) || ("mips64".equalsIgnoreCase(str)))
    {
      AppMethodBeat.o(157301);
      return true;
    }
    AppMethodBeat.o(157301);
    return false;
  }
  
  public static boolean is64bitApp()
  {
    AppMethodBeat.i(157300);
    String str = getRuntimeAbi();
    if ((str.equals("arm64-v8a")) || (str.equals("x86_64")))
    {
      AppMethodBeat.o(157300);
      return true;
    }
    AppMethodBeat.o(157300);
    return false;
  }
  
  public static boolean is64bitDevice()
  {
    AppMethodBeat.i(157299);
    String str = getDeviceAbi();
    if ((str.equals("arm64-v8a")) || (str.equals("x86_64")))
    {
      AppMethodBeat.o(157299);
      return true;
    }
    AppMethodBeat.o(157299);
    return false;
  }
  
  public static boolean isCurrentVersionSupportCustomContext()
  {
    AppMethodBeat.i(157247);
    if ((hasAvailableVersion()) && (getFeatureSupport(1020)))
    {
      AppMethodBeat.o(157247);
      return true;
    }
    AppMethodBeat.o(157247);
    return false;
  }
  
  public static boolean isCurrentVersionSupportCustomTextAreaForAppbrand()
  {
    AppMethodBeat.i(157248);
    if ((hasAvailableVersion()) && (getFeatureSupport(1012)))
    {
      AppMethodBeat.o(157248);
      return true;
    }
    AppMethodBeat.o(157248);
    return false;
  }
  
  public static boolean isCurrentVersionSupportExtendPluginForAppbrand()
  {
    AppMethodBeat.i(157245);
    if ((hasAvailableVersion()) && (getAvailableVersion() >= 300))
    {
      AppMethodBeat.o(157245);
      return true;
    }
    AppMethodBeat.o(157245);
    return false;
  }
  
  public static boolean isCurrentVersionSupportForceDarkMode()
  {
    AppMethodBeat.i(157249);
    if ((hasAvailableVersion()) && (getFeatureSupport(1021)))
    {
      AppMethodBeat.o(157249);
      return true;
    }
    AppMethodBeat.o(157249);
    return false;
  }
  
  public static boolean isCurrentVersionSupportMapExtendPluginForAppbrand()
  {
    AppMethodBeat.i(157246);
    if ((hasAvailableVersion()) && (getFeatureSupport(1011)))
    {
      AppMethodBeat.o(157246);
      return true;
    }
    AppMethodBeat.o(157246);
    return false;
  }
  
  public static boolean isCurrentVersionSupportNativeView()
  {
    AppMethodBeat.i(183534);
    if ((hasAvailableVersion()) && (getFeatureSupport(1013)))
    {
      AppMethodBeat.o(183534);
      return true;
    }
    AppMethodBeat.o(183534);
    return false;
  }
  
  public static boolean isCurrentVersionSupportScreenshotForSameLayer()
  {
    AppMethodBeat.i(183535);
    if ((hasAvailableVersion()) && (getFeatureSupport(2010)))
    {
      AppMethodBeat.o(183535);
      return true;
    }
    AppMethodBeat.o(183535);
    return false;
  }
  
  public static boolean isDownloadMode()
  {
    AppMethodBeat.i(157296);
    boolean bool = sIsDownloadMode.booleanValue();
    AppMethodBeat.o(157296);
    return bool;
  }
  
  public static boolean isDownloadModeUpdate()
  {
    AppMethodBeat.i(157297);
    boolean bool = sIsDownloadModeUpdate.booleanValue();
    AppMethodBeat.o(157297);
    return bool;
  }
  
  public static boolean isForbidDownloadCode()
  {
    AppMethodBeat.i(195192);
    boolean bool = ag.frt();
    AppMethodBeat.o(195192);
    return bool;
  }
  
  public static boolean isIaDevice()
  {
    AppMethodBeat.i(157298);
    String str = getDeviceAbi();
    if ((str.equals("x86")) || (str.equals("x86_64")))
    {
      AppMethodBeat.o(157298);
      return true;
    }
    AppMethodBeat.o(157298);
    return false;
  }
  
  public static boolean isInTestMode()
  {
    AppMethodBeat.i(157281);
    String str = getTestDownLoadUrl(getApplicationContext());
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(157281);
      return false;
    }
    AppMethodBeat.o(157281);
    return true;
  }
  
  public static boolean isProvider(String paramString)
  {
    AppMethodBeat.i(157323);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XWalkEnvironment", "isProvider packageName is null or empty");
      AppMethodBeat.o(157323);
      return false;
    }
    String[] arrayOfString = XWALK_CORE_PROVIDER_LIST;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString))
      {
        AppMethodBeat.o(157323);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(157323);
    return false;
  }
  
  public static boolean isSelfProvider()
  {
    AppMethodBeat.i(157322);
    if (sApplicationContext == null)
    {
      Log.e("XWalkEnvironment", "isSelfProvider sApplicationContext is null");
      AppMethodBeat.o(157322);
      return true;
    }
    boolean bool = isProvider(sApplicationContext.getPackageName());
    AppMethodBeat.o(157322);
    return bool;
  }
  
  public static boolean isTestVersion(int paramInt)
  {
    return paramInt >= 100000000;
  }
  
  public static boolean isValidConfigHost(String paramString)
  {
    AppMethodBeat.i(157288);
    if ((paramString == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramString.trim())))
    {
      AppMethodBeat.o(157288);
      return false;
    }
    try
    {
      paramString = new URI(paramString.trim());
      boolean bool = paramString.getScheme().equals("https");
      if (!bool)
      {
        AppMethodBeat.o(157288);
        return false;
      }
      bool = paramString.getHost().equals("dldir1.qq.com");
      if (!bool)
      {
        AppMethodBeat.o(157288);
        return false;
      }
      AppMethodBeat.o(157288);
      return true;
    }
    catch (Exception paramString)
    {
      Log.e("XWalkEnvironment", "java.net.URI new crashed ");
      AppMethodBeat.o(157288);
    }
    return false;
  }
  
  public static int readAvailableVersionFromSP(Context paramContext)
  {
    AppMethodBeat.i(157331);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "readAvailableVersionFromSP context is null");
      AppMethodBeat.o(157331);
      return -1;
    }
    int i = XWebCoreInfo.getCurAbiInstalledNewestVersion(paramContext);
    AppMethodBeat.o(157331);
    return i;
  }
  
  public static void refreshAvailableVersion()
  {
    AppMethodBeat.i(195195);
    XWebCoreInfo localXWebCoreInfo = XWebCoreInfo.getBackupCoreInfo(getRuntimeAbi());
    sXWebCoreInfo = localXWebCoreInfo;
    if (localXWebCoreInfo.ver != -1) {
      getSharedPreferences().edit().putString("XWALK_CORE_EXTRACTED_DIR", getExtractedCoreDir(sXWebCoreInfo.ver)).commit();
    }
    AppMethodBeat.o(195195);
  }
  
  public static void refreshVerInfo()
  {
    AppMethodBeat.i(185177);
    sXWebCoreInfo = XWebCoreInfo.getBackupCoreInfo(getRuntimeAbi());
    AppMethodBeat.o(185177);
  }
  
  public static void resetForDebug()
  {
    sApplicationContext = null;
    sXWebCoreInfo = null;
    sIsPluginInited = false;
  }
  
  public static int safeGetChromiunVersion()
  {
    AppMethodBeat.i(157283);
    if (sNChromiuVersion < 0) {
      try
      {
        PackageInfo localPackageInfo = getApplicationContext().getPackageManager().getPackageInfo("com.google.android.webview", 0);
        if (localPackageInfo != null)
        {
          i = getVerFromVersionName(localPackageInfo.versionName);
          if (i > 0)
          {
            sNChromiuVersion = i;
            AppMethodBeat.o(157283);
            return i;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("XWalkEnvironment", "Android System WebView is not found");
      }
    }
    int i = sNChromiuVersion;
    AppMethodBeat.o(157283);
    return i;
  }
  
  public static void setAppClientVersion(int paramInt)
  {
    try
    {
      sAppClientVersion = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean setAvailableVersion(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(157258);
    boolean bool = XWebCoreInfo.setVersionForAbi(paramInt, paramString1, paramString2);
    AppMethodBeat.o(157258);
    return bool;
  }
  
  public static void setConfigFetchPeriod(long paramLong)
  {
    sConfigPerios = paramLong;
  }
  
  public static void setForceDarkBehavior(ForceDarkBehavior paramForceDarkBehavior)
  {
    AppMethodBeat.i(157251);
    switch (1.$SwitchMap$org$xwalk$core$XWalkEnvironment$ForceDarkBehavior[paramForceDarkBehavior.ordinal()])
    {
    }
    for (;;)
    {
      Log.i("XWalkEnvironment", "setForceDarkMode forceDarkBehavior:".concat(String.valueOf(paramForceDarkBehavior)));
      j.g(WebView.c.INC).excute("STR_CMD_FORCE_DARK_MODE_BEHAVIOR_COMMAND", new Object[] { Integer.valueOf(sForceDarkBehavior) });
      AppMethodBeat.o(157251);
      return;
      sForceDarkBehavior = 0;
      continue;
      sForceDarkBehavior = 1;
      continue;
      sForceDarkBehavior = 2;
    }
  }
  
  public static void setForceDarkMode(boolean paramBoolean)
  {
    AppMethodBeat.i(157250);
    sIsForceDarkMode = paramBoolean;
    Log.i("XWalkEnvironment", "setForceDarkMode forceDarkMode:".concat(String.valueOf(paramBoolean)));
    j.g(WebView.c.INC).excute("STR_CMD_FORCE_DARK_MODE_COMMAND", new Object[] { Boolean.valueOf(sIsForceDarkMode) });
    AppMethodBeat.o(157250);
  }
  
  public static void setGrayValueByUserId(int paramInt)
  {
    AppMethodBeat.i(157308);
    if (paramInt == 0)
    {
      AppMethodBeat.o(157308);
      return;
    }
    Object localObject = "xweb_gray_value".concat(String.valueOf(0xFFFFFFFF & paramInt));
    try
    {
      localObject = MessageDigest.getInstance("MD5").digest(((String)localObject).getBytes());
      if (localObject != null)
      {
        paramInt = localObject.length;
        if (paramInt > 3) {}
      }
      else
      {
        AppMethodBeat.o(157308);
        return;
      }
      paramInt = localObject[3];
      int i = localObject[2];
      int j = localObject[1];
      paramInt = (localObject[0] & 0x7F) << 24 | paramInt & 0xFF | (i & 0xFF) << 8 | (j & 0xFF) << 16;
      if (paramInt == 0)
      {
        AppMethodBeat.o(157308);
        return;
      }
      s_grayValue = paramInt % 10000 + 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        s_grayValue = 0;
      }
    }
    paramInt = getSharedPreferences().getInt("GRAY_VALUE", -1);
    getSharedPreferences().edit().putInt("GRAY_VALUE", s_grayValue).commit();
    if (paramInt != s_grayValue)
    {
      Log.i("XWalkEnvironment", "gray value changed to " + s_grayValue);
      j.g(WebView.c.INC).excute("STR_CMD_SET_RECHECK_COMMAND", null);
    }
    AppMethodBeat.o(157308);
  }
  
  public static void setGrayValueForTest(int paramInt)
  {
    AppMethodBeat.i(157304);
    if (paramInt != 10001) {
      s_grayValue = paramInt % 10000;
    }
    getSharedPreferences().edit().putInt("TEST_GRAY_VALUE", s_grayValue).commit();
    AppMethodBeat.o(157304);
  }
  
  public static void setIpType(int paramInt)
  {
    AppMethodBeat.i(157305);
    int i = getIpType();
    if (paramInt != i)
    {
      getSharedPreferences().edit().putInt("IP_TYPE", paramInt).commit();
      addXWalkInitializeLog("setIpType", " to  ".concat(String.valueOf(paramInt)));
      if ((i != 0) || (paramInt != 1)) {
        break label103;
      }
      com.tencent.xweb.util.g.xs(197L);
    }
    for (;;)
    {
      if ((i > 0) || (paramInt > 0))
      {
        sBIsIpTypeChanged = true;
        j.g(WebView.c.INC).excute("STR_CMD_SET_RECHECK_COMMAND", null);
      }
      AppMethodBeat.o(157305);
      return;
      label103:
      if ((i == 1) && (paramInt == 0)) {
        com.tencent.xweb.util.g.xs(198L);
      }
    }
  }
  
  public static void setIsForbidDownloadCode(boolean paramBoolean)
  {
    AppMethodBeat.i(157227);
    ag.xE(paramBoolean);
    AppMethodBeat.o(157227);
  }
  
  public static boolean setPluginTestConfigUrl(String paramString)
  {
    AppMethodBeat.i(157294);
    Object localObject = getSharedPreferencesForTestXWeb();
    if (localObject == null)
    {
      Log.e("XWalkEnvironment", "setPluginTestConfigUrl sp is null");
      AppMethodBeat.o(157294);
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if ((paramString == null) || (paramString.trim().isEmpty())) {
      ((SharedPreferences.Editor)localObject).remove("XWEB_PLUGIN_TEST_CONFIG_URL");
    }
    for (;;)
    {
      boolean bool = ((SharedPreferences.Editor)localObject).commit();
      AppMethodBeat.o(157294);
      return bool;
      ((SharedPreferences.Editor)localObject).putString("XWEB_PLUGIN_TEST_CONFIG_URL", paramString.trim());
    }
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
  
  public static void setTempPluginUpdateConfigUrl(String paramString)
  {
    try
    {
      sStrTempPluginUpdateConfigUrl = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void setTempPluginUpdatePeriod(int paramInt)
  {
    try
    {
      sTempPluginUpdatePeriod = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setTempUpdateConfigUrl(String paramString)
  {
    try
    {
      sStrTempUpdateConfigUrl = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void setTestDownLoadUrl(Context paramContext, String paramString)
  {
    AppMethodBeat.i(157287);
    sXWalkDownConfigUrl = null;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramContext.getSharedPreferences("TESTXWEB", 4).edit().putString("XWEB_TEST_CONFIG_URL", "").commit();
      getXWalkUpdateConfigUrl();
      AppMethodBeat.o(157287);
      return;
    }
    paramContext.getSharedPreferences("TESTXWEB", 4).edit().putString("XWEB_TEST_CONFIG_URL", paramString).commit();
    getXWalkUpdateConfigUrl();
    AppMethodBeat.o(157287);
  }
  
  public static void setUsingCustomContext(boolean paramBoolean)
  {
    AppMethodBeat.i(157252);
    sUsingCustomContext = paramBoolean;
    Log.i("XWalkEnvironment", "setUsingCustomContext usingCustomContext:".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(157252);
  }
  
  public static void setXWebInitArgs(HashMap paramHashMap)
  {
    try
    {
      sXWebArgs = paramHashMap;
      return;
    }
    finally
    {
      paramHashMap = finally;
      throw paramHashMap;
    }
  }
  
  static void tryClose(Closeable paramCloseable)
  {
    AppMethodBeat.i(157310);
    if (paramCloseable == null)
    {
      AppMethodBeat.o(157310);
      return;
    }
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(157310);
      return;
    }
    catch (Exception paramCloseable)
    {
      Log.e("XWalkEnvironment", "closeable close  failed " + paramCloseable.getMessage());
      AppMethodBeat.o(157310);
    }
  }
  
  public static enum ForceDarkBehavior
  {
    static
    {
      AppMethodBeat.i(157223);
      FORCE_DARK_ONLY = new ForceDarkBehavior("FORCE_DARK_ONLY", 0);
      MEDIA_QUERY_ONLY = new ForceDarkBehavior("MEDIA_QUERY_ONLY", 1);
      PREFER_MEDIA_QUERY_OVER_FORCE_DARK = new ForceDarkBehavior("PREFER_MEDIA_QUERY_OVER_FORCE_DARK", 2);
      $VALUES = new ForceDarkBehavior[] { FORCE_DARK_ONLY, MEDIA_QUERY_ONLY, PREFER_MEDIA_QUERY_OVER_FORCE_DARK };
      AppMethodBeat.o(157223);
    }
    
    private ForceDarkBehavior() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkEnvironment
 * JD-Core Version:    0.7.0.1
 */