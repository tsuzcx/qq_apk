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
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.l;
import com.tencent.xweb.c.l.a;
import com.tencent.xweb.h;
import com.tencent.xweb.q;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.f;
import com.tencent.xweb.xwalk.a.e;
import java.io.Closeable;
import java.io.File;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class XWalkEnvironment
{
  private static final String APK_DIR = "apk";
  public static final String DOWNLOAD_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig.xml";
  public static final String DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
  public static final String DOWNLOAD_PLUGIN_UPDATE_TEST_CONFIG_DEFAULT_URL = "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml";
  public static final String DOWNLOAD_X86_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86.xml";
  public static final int LOCAL_TEST_VERSION = 100000;
  public static final String LOCAL_TEST_ZIP_NAME = "runtime_package.zip";
  public static final String[] MANDATORY_RESOURCES;
  private static final String META_XWALK_DOWNCONFIG_URL = "xwalk_downconfig_url";
  public static final String MM_PACKAGE_NAME = "com.tencent.mm";
  private static final String OPTIMIZED_DEX_DIR = "dex";
  private static final String PACKAGE_RE = "[a-z]+\\.[a-z0-9]+\\.[a-z0-9]+.*";
  private static final String PATCH_ZIP_TEMP_DECOMPRESS_DIR = "patch_temp_decompress";
  public static final int SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION = 153;
  public static final int SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION = 255;
  public static final int SDK_SUPPORT_MIN_APKVERSION = 49;
  public static final int SDK_VERSION = 190503;
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
  private static final String SP_NAME_VERSION_INFO = "XWALKINFOS";
  private static final String TAG = "XWalkEnvironment";
  public static final int TEST_APK_START_VERSION = 100000;
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
  public static final String XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO = "FullScreenVideo";
  public static final String XWALK_PLUGIN_NAME_PPT_READER = "XFilesPPTReader";
  private static final String XWALK_PLUGIN_UPDATE_CONFIG_NAME = "pluginUpdateConfig.xml";
  public static final int XWALK_PLUGIN_UPDATE_PERIOD_DEFAULT = 90000000;
  private static final String XWALK_UPDATE_CONFIG_DIR = "xwalkconfig";
  private static final String ZIP_DIR = "zip";
  private static Context sApplicationContext;
  private static String sApplicationName;
  private static int sAvailableVersion;
  static boolean sBHasInitedSafePsProvider;
  static boolean sBIsIpTypeChanged;
  private static String sDeviceAbi;
  private static Boolean sIsDownloadMode;
  private static Boolean sIsDownloadModeUpdate;
  private static boolean sIsForbidDownloadCode;
  private static boolean sIsPluginInited;
  private static Boolean sIsXWalkVerify;
  static Method sMMKVMethod;
  static int sNChromiuVersion;
  static int sNDeviceRd;
  static int sPid;
  private static String sRuntimeAbi;
  static h sSPProvider;
  static String sStrCurentProcessName;
  static String sStrDeviceId;
  private static String sStrTempPluginUpdateConfigUrl;
  private static String sStrTempUpdateConfigUrl;
  private static String sStrVersionDetail;
  private static int sTempPluginUpdatePeriod;
  private static boolean sUsingCustomContext;
  private static String sXWalkApkUrl;
  private static String sXWalkDownConfigUrl;
  static HashMap<String, Object> sXWebArgs;
  static int s_grayValue;
  
  static
  {
    AppMethodBeat.i(4296);
    UPDATEINFOTAG = "xwalk_update_info";
    XWALK_CORE_PROVIDER_LIST = new String[] { "com.tencent.mm" };
    sIsPluginInited = false;
    sIsForbidDownloadCode = false;
    sIsDownloadMode = Boolean.TRUE;
    sIsDownloadModeUpdate = Boolean.TRUE;
    sAvailableVersion = -1;
    sTempPluginUpdatePeriod = -1;
    sUsingCustomContext = false;
    sBHasInitedSafePsProvider = false;
    sSPProvider = null;
    sPid = Process.myPid();
    s_grayValue = 0;
    sNChromiuVersion = -1;
    sNDeviceRd = 0;
    sBIsIpTypeChanged = false;
    sStrDeviceId = null;
    MANDATORY_RESOURCES = new String[] { "classes.dex", "icudtl.dat", "xwalk.pak", "xwalk_100_percent.pak", "xweb_fullscreen_video.js" };
    AppMethodBeat.o(4296);
  }
  
  static int _getChromiunVersion()
  {
    AppMethodBeat.i(4252);
    Object localObject = getApplicationContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.webview", 0);
      if (localObject != null)
      {
        i = getVerFromVersionName(((PackageInfo)localObject).versionName);
        if (i > 0)
        {
          AppMethodBeat.o(4252);
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
            AppMethodBeat.o(4252);
            return 0;
          }
          i = getVerFromVersionName(arrayOfString[1]);
          AppMethodBeat.o(4252);
          return i;
        }
      }
      catch (Exception localException2)
      {
        Log.e("XWalkEnvironment", "Android System WebView is not found");
        AppMethodBeat.o(4252);
      }
    }
    return 0;
  }
  
  public static Activity activityFromContext(Context paramContext)
  {
    AppMethodBeat.i(154715);
    for (;;)
    {
      if ((paramContext instanceof Activity))
      {
        paramContext = (Activity)paramContext;
        AppMethodBeat.o(154715);
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
    AppMethodBeat.o(154715);
    return null;
    label59:
    AppMethodBeat.o(154715);
    return null;
  }
  
  public static void addXWalkInitializeLog(String paramString)
  {
    AppMethodBeat.i(4230);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(4230);
      return;
    }
    Log.i("XWalkUpdater", paramString);
    String str1 = new SimpleDateFormat("MM-dd hh:mm:ss").format(new Date());
    String str2 = sPid + ":" + str1 + " : " + paramString;
    SharedPreferences localSharedPreferences = getSharedPreferencesForLog();
    str1 = localSharedPreferences.getString("log", "");
    paramString = str1;
    if (str1.length() > 10240) {
      paramString = str1.substring(0, 5120);
    }
    paramString = str2 + "\n" + paramString;
    localSharedPreferences.edit().putString("log", paramString).apply();
    AppMethodBeat.o(4230);
  }
  
  public static void addXWalkInitializeLog(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4229);
    addXWalkInitializeLog(paramString1 + ": " + paramString2);
    AppMethodBeat.o(4229);
  }
  
  public static boolean checkApiVersionAllFileExist(int paramInt)
  {
    AppMethodBeat.i(4279);
    if ((checkApiVersionExtractResourceExist(paramInt)) && (checkApiVersionBaseApkExist(paramInt)))
    {
      AppMethodBeat.o(4279);
      return true;
    }
    AppMethodBeat.o(4279);
    return false;
  }
  
  /* Error */
  public static boolean checkApiVersionAvailable(int paramInt)
  {
    // Byte code:
    //   0: sipush 4278
    //   3: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_0
    //   7: invokestatic 443	org/xwalk/core/XWalkEnvironment:getExtractedCoreDir	(I)Ljava/lang/String;
    //   10: astore_3
    //   11: iload_0
    //   12: invokestatic 446	org/xwalk/core/XWalkEnvironment:getClassDexFilePath	(I)Ljava/lang/String;
    //   15: astore 4
    //   17: new 448	java/io/File
    //   20: dup
    //   21: aload 4
    //   23: invokespecial 449	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokevirtual 452	java/io/File:exists	()Z
    //   29: istore_2
    //   30: iload_2
    //   31: ifne +11 -> 42
    //   34: sipush 4278
    //   37: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_0
    //   41: ireturn
    //   42: new 454	dalvik/system/DexClassLoader
    //   45: dup
    //   46: aload 4
    //   48: iload_0
    //   49: invokestatic 457	org/xwalk/core/XWalkEnvironment:getOptimizedDexDir	(I)Ljava/lang/String;
    //   52: aload_3
    //   53: invokestatic 463	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   56: invokespecial 466	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   59: astore_3
    //   60: aload_3
    //   61: ldc_w 468
    //   64: invokevirtual 472	dalvik/system/DexClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   67: astore 5
    //   69: ldc_w 399
    //   72: astore_3
    //   73: new 474	org/xwalk/core/ReflectField
    //   76: dup
    //   77: aload 5
    //   79: ldc_w 476
    //   82: invokespecial 479	org/xwalk/core/ReflectField:<init>	(Ljava/lang/Class;Ljava/lang/String;)V
    //   85: invokevirtual 483	org/xwalk/core/ReflectField:get	()Ljava/lang/Object;
    //   88: checkcast 219	java/lang/String
    //   91: astore 4
    //   93: aload 4
    //   95: astore_3
    //   96: new 474	org/xwalk/core/ReflectField
    //   99: dup
    //   100: aload 5
    //   102: ldc_w 485
    //   105: invokespecial 479	org/xwalk/core/ReflectField:<init>	(Ljava/lang/Class;Ljava/lang/String;)V
    //   108: invokevirtual 483	org/xwalk/core/ReflectField:get	()Ljava/lang/Object;
    //   111: checkcast 487	java/lang/Integer
    //   114: invokevirtual 490	java/lang/Integer:intValue	()I
    //   117: istore_0
    //   118: new 474	org/xwalk/core/ReflectField
    //   121: dup
    //   122: aload 5
    //   124: ldc_w 492
    //   127: invokespecial 479	org/xwalk/core/ReflectField:<init>	(Ljava/lang/Class;Ljava/lang/String;)V
    //   130: invokevirtual 483	org/xwalk/core/ReflectField:get	()Ljava/lang/Object;
    //   133: checkcast 487	java/lang/Integer
    //   136: invokevirtual 490	java/lang/Integer:intValue	()I
    //   139: istore_1
    //   140: ldc 113
    //   142: new 376	java/lang/StringBuilder
    //   145: dup
    //   146: ldc_w 494
    //   149: invokespecial 495	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_3
    //   153: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 497
    //   159: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload_0
    //   163: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: ldc_w 499
    //   169: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: iload_1
    //   173: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 502	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: sipush 4278
    //   185: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: iconst_1
    //   189: ireturn
    //   190: astore_3
    //   191: sipush 4278
    //   194: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: iconst_0
    //   198: ireturn
    //   199: astore_3
    //   200: sipush 4278
    //   203: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: iconst_0
    //   207: ireturn
    //   208: astore 4
    //   210: goto -114 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramInt	int
    //   139	34	1	i	int
    //   29	2	2	bool	boolean
    //   10	143	3	localObject	Object
    //   190	1	3	localException1	Exception
    //   199	1	3	localException2	Exception
    //   15	79	4	str	String
    //   208	1	4	localRuntimeException	java.lang.RuntimeException
    //   67	56	5	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   60	69	190	java/lang/Exception
    //   73	93	190	java/lang/Exception
    //   96	182	190	java/lang/Exception
    //   6	30	199	java/lang/Exception
    //   42	60	199	java/lang/Exception
    //   73	93	208	java/lang/RuntimeException
  }
  
  public static boolean checkApiVersionBaseApkExist(int paramInt)
  {
    AppMethodBeat.i(4280);
    if (new File(getDownloadApkPath(paramInt)).exists())
    {
      AppMethodBeat.o(4280);
      return true;
    }
    AppMethodBeat.o(4280);
    return false;
  }
  
  private static boolean checkApiVersionExtractResourceExist(int paramInt)
  {
    AppMethodBeat.i(4281);
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
          AppMethodBeat.o(4281);
          return false;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(4281);
    return true;
  }
  
  public static void clearAllVersion(Context paramContext)
  {
    AppMethodBeat.i(4228);
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null) || (paramContext.getApplicationInfo().dataDir == null))
    {
      AppMethodBeat.o(4228);
      return;
    }
    paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
    if (paramContext == null)
    {
      AppMethodBeat.o(4228);
      return;
    }
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContext[i];
      if ((localObject.getName().startsWith("app_xwalk_")) && (localObject.isDirectory())) {
        b.ayf(localObject.getAbsolutePath());
      }
      i += 1;
    }
    setAvailableVersion(-1, "");
    AppMethodBeat.o(4228);
  }
  
  public static boolean delApiVersion(int paramInt)
  {
    AppMethodBeat.i(4282);
    boolean bool = b.ayf(getVesionDir(paramInt));
    AppMethodBeat.o(4282);
    return bool;
  }
  
  public static Context getApplicationContext()
  {
    return sApplicationContext;
  }
  
  private static String getApplicationMetaData(String paramString)
  {
    AppMethodBeat.i(4277);
    try
    {
      paramString = sApplicationContext.getPackageManager().getApplicationInfo(sApplicationContext.getPackageName(), 128).metaData.get(paramString).toString();
      AppMethodBeat.o(4277);
      return paramString;
    }
    catch (NullPointerException paramString)
    {
      AppMethodBeat.o(4277);
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
    AppMethodBeat.i(4261);
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
      AppMethodBeat.o(4261);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label40;
    }
  }
  
  public static int getAvailableVersion()
  {
    return sAvailableVersion;
  }
  
  public static String getAvailableVersionDetail()
  {
    return sStrVersionDetail;
  }
  
  public static int getChromiunVersion()
  {
    AppMethodBeat.i(4250);
    if (sNChromiuVersion < 0) {
      sNChromiuVersion = _getChromiunVersion();
    }
    int i = sNChromiuVersion;
    AppMethodBeat.o(4250);
    return i;
  }
  
  public static String getClassDexFilePath(int paramInt)
  {
    AppMethodBeat.i(4248);
    String str = getExtractedCoreDir(paramInt) + File.separator + "classes.dex";
    AppMethodBeat.o(4248);
    return str;
  }
  
  public static ContentResolver getContentResolver()
  {
    AppMethodBeat.i(4284);
    if (sApplicationContext == null)
    {
      Log.e("XWalkEnvironment", "getContentResolver sApplicationContext is null");
      AppMethodBeat.o(4284);
      return null;
    }
    ContentResolver localContentResolver = sApplicationContext.getContentResolver();
    AppMethodBeat.o(4284);
    return localContentResolver;
  }
  
  /* Error */
  public static String getDeviceAbi()
  {
    // Byte code:
    //   0: sipush 4276
    //   3: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 616	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   9: ifnonnull +103 -> 112
    //   12: getstatic 621	android/os/Build$VERSION:SDK_INT	I
    //   15: bipush 21
    //   17: if_icmplt +14 -> 31
    //   20: getstatic 626	android/os/Build:SUPPORTED_ABIS	[Ljava/lang/String;
    //   23: iconst_0
    //   24: aaload
    //   25: invokevirtual 629	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   28: putstatic 616	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   31: getstatic 616	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   34: ifnonnull +54 -> 88
    //   37: new 631	java/io/InputStreamReader
    //   40: dup
    //   41: invokestatic 637	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   44: ldc_w 639
    //   47: invokevirtual 643	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   50: invokevirtual 649	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   53: invokespecial 652	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   56: astore_1
    //   57: new 654	java/io/BufferedReader
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 657	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   65: astore_0
    //   66: aload_0
    //   67: astore_3
    //   68: aload_1
    //   69: astore_2
    //   70: aload_0
    //   71: invokevirtual 660	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: invokevirtual 629	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   77: putstatic 616	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   80: aload_1
    //   81: invokestatic 664	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   84: aload_0
    //   85: invokestatic 664	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   88: ldc 113
    //   90: new 376	java/lang/StringBuilder
    //   93: dup
    //   94: ldc_w 666
    //   97: invokespecial 495	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: getstatic 616	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   103: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 502	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: getstatic 616	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   115: ifnonnull +139 -> 254
    //   118: sipush 4276
    //   121: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: ldc_w 399
    //   127: areturn
    //   128: astore_0
    //   129: ldc 113
    //   131: new 376	java/lang/StringBuilder
    //   134: dup
    //   135: ldc_w 668
    //   138: invokespecial 495	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: invokevirtual 671	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   145: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 317	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: goto -123 -> 31
    //   157: astore_0
    //   158: ldc 113
    //   160: new 376	java/lang/StringBuilder
    //   163: dup
    //   164: ldc_w 673
    //   167: invokespecial 495	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: invokevirtual 674	java/lang/NoSuchFieldError:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 317	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   196: ldc 113
    //   198: new 376	java/lang/StringBuilder
    //   201: dup
    //   202: ldc_w 666
    //   205: invokespecial 495	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: aload 4
    //   210: invokevirtual 671	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   213: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 317	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_1
    //   223: invokestatic 664	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   226: aload_0
    //   227: invokestatic 664	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   230: goto -142 -> 88
    //   233: astore_0
    //   234: aconst_null
    //   235: astore_3
    //   236: aconst_null
    //   237: astore_1
    //   238: aload_1
    //   239: invokestatic 664	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   242: aload_3
    //   243: invokestatic 664	org/xwalk/core/XWalkEnvironment:tryClose	(Ljava/io/Closeable;)V
    //   246: sipush 4276
    //   249: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_0
    //   253: athrow
    //   254: getstatic 616	org/xwalk/core/XWalkEnvironment:sDeviceAbi	Ljava/lang/String;
    //   257: astore_0
    //   258: sipush 4276
    //   261: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   157	14	0	localNoSuchFieldError	java.lang.NoSuchFieldError
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
    AppMethodBeat.i(4274);
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
      AppMethodBeat.o(4274);
      return localObject;
      sStrDeviceId = ((TelephonyManager)localObject).getDeviceId();
    }
  }
  
  public static int getDeviceRd()
  {
    AppMethodBeat.i(4268);
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
    AppMethodBeat.o(4268);
    return i % 10000 + 1;
  }
  
  public static String getDownloadApkDir(int paramInt)
  {
    AppMethodBeat.i(4245);
    String str = getVesionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(4245);
    return str;
  }
  
  public static String getDownloadApkPath(int paramInt)
  {
    AppMethodBeat.i(4246);
    String str = getVesionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    str = str + File.separator + "base.apk";
    AppMethodBeat.o(4246);
    return str;
  }
  
  public static String getDownloadApkPath(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4290);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getDownloadApkPath with context, context is null");
      AppMethodBeat.o(4290);
      return "";
    }
    paramContext = getVesionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkEnvironment", "getDownloadApkPath with context, versionDir is empty");
      AppMethodBeat.o(4290);
      return "";
    }
    paramContext = paramContext + File.separator + "apk" + File.separator + "base.apk";
    AppMethodBeat.o(4290);
    return paramContext;
  }
  
  public static String getDownloadPatchPath(int paramInt)
  {
    AppMethodBeat.i(4247);
    String str = getVesionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    str = str + File.separator + "patch.zip";
    AppMethodBeat.o(4247);
    return str;
  }
  
  public static String getDownloadResFileListConfig(int paramInt)
  {
    AppMethodBeat.i(4242);
    String str = getExtractedCoreFile(paramInt, "reslist.config");
    AppMethodBeat.o(4242);
    return str;
  }
  
  public static String getDownloadZipDir(int paramInt)
  {
    AppMethodBeat.i(4238);
    String str = getVesionDir(paramInt) + File.separator + "zip";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    str = str + File.separator + "base.zip";
    AppMethodBeat.o(4238);
    return str;
  }
  
  public static String getDownloadZipFileListConfig(int paramInt)
  {
    AppMethodBeat.i(4241);
    String str = getExtractedCoreFile(paramInt, "filelist.config");
    AppMethodBeat.o(4241);
    return str;
  }
  
  public static String getDownloadZipFileListConfig(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4293);
    paramContext = getExtractedCoreFile(paramContext, paramInt, "filelist.config");
    AppMethodBeat.o(4293);
    return paramContext;
  }
  
  public static String getExtractedCoreDir(int paramInt)
  {
    AppMethodBeat.i(4235);
    String str = getVesionDir(paramInt) + File.separator + "extracted_xwalkcore";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(4235);
    return str;
  }
  
  public static String getExtractedCoreFile(int paramInt, String paramString)
  {
    AppMethodBeat.i(4236);
    String str = getVesionDir(paramInt) + File.separator + "extracted_xwalkcore";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = str + File.separator + paramString;
    AppMethodBeat.o(4236);
    return paramString;
  }
  
  public static String getExtractedCoreFile(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(4291);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getExtractedCoreFile with context, context is null");
      AppMethodBeat.o(4291);
      return "";
    }
    paramContext = getVesionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkEnvironment", "getExtractedCoreFile with context, versionDir is empty");
      AppMethodBeat.o(4291);
      return "";
    }
    paramContext = paramContext + File.separator + "extracted_xwalkcore" + File.separator + paramString;
    AppMethodBeat.o(4291);
    return paramContext;
  }
  
  private static boolean getFeatureSupport(int paramInt)
  {
    AppMethodBeat.i(4222);
    boolean bool = ((Boolean)l.e(WebView.d.BEq).excute("STR_CMD_FEATURE_SUPPORT", new Object[] { Integer.valueOf(paramInt) })).booleanValue();
    AppMethodBeat.o(4222);
    return bool;
  }
  
  public static int getGrayValue()
  {
    AppMethodBeat.i(4231);
    if (s_grayValue != 0)
    {
      i = s_grayValue;
      AppMethodBeat.o(4231);
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
    AppMethodBeat.o(4231);
    return i;
  }
  
  public static int getInstalledNewstVersion()
  {
    AppMethodBeat.i(4224);
    int i = getSharedPreferencesForVersionInfo().getInt("availableVersion", -1);
    AppMethodBeat.o(4224);
    return i;
  }
  
  public static int getInstalledNewstVersion(Context paramContext)
  {
    AppMethodBeat.i(4225);
    if (paramContext == null)
    {
      AppMethodBeat.o(4225);
      return 0;
    }
    int i = paramContext.getSharedPreferences("XWALKINFOS", 4).getInt("availableVersion", -1);
    AppMethodBeat.o(4225);
    return i;
  }
  
  public static int getIpType()
  {
    AppMethodBeat.i(4271);
    int i = getSharedPreferences().getInt("IP_TYPE", -2);
    AppMethodBeat.o(4271);
    return i;
  }
  
  public static SharedPreferences getMMKVSharedPreferences(String paramString)
  {
    AppMethodBeat.i(4206);
    paramString = getMMKVSharedPreferencesEx(paramString, 4, false);
    AppMethodBeat.o(4206);
    return paramString;
  }
  
  public static SharedPreferences getMMKVSharedPreferencesEx(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(4208);
    if (sSPProvider != null) {
      try
      {
        Object localObject1 = sSPProvider;
        getApplicationContext();
        localObject1 = ((h)localObject1).x(paramString, paramInt, paramBoolean);
        if (localObject1 != null)
        {
          AppMethodBeat.o(4208);
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
        f.pf(176L);
      }
    }
    for (;;)
    {
      initSafePsProvider();
      if (sMMKVMethod != null) {
        break;
      }
      paramString = sApplicationContext.getSharedPreferences(paramString, paramInt);
      AppMethodBeat.o(4208);
      return paramString;
      f.pf(177L);
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
    f.pf(179L);
    paramString = sApplicationContext.getSharedPreferences(paramString, paramInt);
    AppMethodBeat.o(4208);
    return paramString;
    label192:
    Object localObject2 = (SharedPreferences)localObject2;
    AppMethodBeat.o(4208);
    return localObject2;
  }
  
  public static SharedPreferences getMMKVSharedTransportOld(String paramString)
  {
    AppMethodBeat.i(4207);
    paramString = getMMKVSharedPreferencesEx(paramString, 4, true);
    AppMethodBeat.o(4207);
    return paramString;
  }
  
  public static String getOptimizedDexDir(int paramInt)
  {
    AppMethodBeat.i(4237);
    String str = getVesionDir(paramInt) + File.separator + "dex";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(4237);
    return str;
  }
  
  public static Context getPackageContext(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(4285);
    if (sApplicationContext == null)
    {
      Log.e("XWalkEnvironment", "getTargetPackageContext sApplicationContext is null");
      AppMethodBeat.o(4285);
      return null;
    }
    try
    {
      paramString = sApplicationContext.createPackageContext(paramString, 2);
      AppMethodBeat.o(4285);
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
    AppMethodBeat.i(4288);
    if (sApplicationContext == null)
    {
      Log.e("XWalkEnvironment", "getPackageName sApplicationContext is null");
      AppMethodBeat.o(4288);
      return "";
    }
    String str = sApplicationContext.getPackageName();
    AppMethodBeat.o(4288);
    return str;
  }
  
  public static String getPatchConfig(int paramInt)
  {
    AppMethodBeat.i(4244);
    String str = getPatchZipTempDecompressFilePath(paramInt, "patch.config");
    AppMethodBeat.o(4244);
    return str;
  }
  
  public static String getPatchFileListConfig(int paramInt)
  {
    AppMethodBeat.i(4243);
    String str = getPatchZipTempDecompressFilePath(paramInt, "filelist.config");
    AppMethodBeat.o(4243);
    return str;
  }
  
  public static String getPatchFileListConfig(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4294);
    paramContext = getPatchZipTempDecompressFilePath(paramContext, paramInt, "filelist.config");
    AppMethodBeat.o(4294);
    return paramContext;
  }
  
  public static String getPatchZipTempDecompressFilePath(int paramInt, String paramString)
  {
    AppMethodBeat.i(4240);
    String str = getVesionDir(paramInt) + File.separator + "patch_temp_decompress";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = str + File.separator + paramString;
    AppMethodBeat.o(4240);
    return paramString;
  }
  
  public static String getPatchZipTempDecompressFilePath(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(4292);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getPatchZipTempDecompressFilePath with context, context is null");
      AppMethodBeat.o(4292);
      return "";
    }
    paramContext = getVesionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkEnvironment", "getPatchZipTempDecompressFilePath with context, versionDir is empty");
      AppMethodBeat.o(4292);
      return "";
    }
    paramContext = paramContext + File.separator + "patch_temp_decompress" + File.separator + paramString;
    AppMethodBeat.o(4292);
    return paramContext;
  }
  
  public static String getPatchZipTempDecompressPath(int paramInt)
  {
    AppMethodBeat.i(4239);
    String str = getVesionDir(paramInt) + File.separator + "patch_temp_decompress";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(4239);
    return str;
  }
  
  public static String getPluginBaseDir()
  {
    AppMethodBeat.i(4216);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(4216);
      return "";
    }
    String str = sApplicationContext.getDir("xwalkplugin", 0).getAbsolutePath();
    AppMethodBeat.o(4216);
    return str;
  }
  
  public static String getPluginConfigUrl()
  {
    AppMethodBeat.i(4258);
    String str = getPluginTestConfigUrl();
    if ((str != null) && (!str.isEmpty()))
    {
      addXWalkInitializeLog("plugin use test config url: ".concat(String.valueOf(str)));
      AppMethodBeat.o(4258);
      return str;
    }
    str = getTempPluginUpdateConfigUrl();
    if ((str != null) && (!str.isEmpty()))
    {
      addXWalkInitializeLog("plugin use temp config url: ".concat(String.valueOf(str)));
      AppMethodBeat.o(4258);
      return str;
    }
    addXWalkInitializeLog("plugin use release config url: https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml");
    AppMethodBeat.o(4258);
    return "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
  }
  
  public static String getPluginTestConfigUrl()
  {
    AppMethodBeat.i(151465);
    Object localObject = getSharedPreferencesForTestXWeb();
    if (localObject == null)
    {
      Log.e("XWalkEnvironment", "hasPluginTestConfigUrl sp is null");
      AppMethodBeat.o(151465);
      return "";
    }
    localObject = ((SharedPreferences)localObject).getString("XWEB_PLUGIN_TEST_CONFIG_URL", "");
    if (localObject == null)
    {
      AppMethodBeat.o(151465);
      return "";
    }
    localObject = ((String)localObject).trim();
    if (((String)localObject).isEmpty())
    {
      AppMethodBeat.o(151465);
      return "";
    }
    AppMethodBeat.o(151465);
    return localObject;
  }
  
  public static String getPluginUpdateConfigFilePath()
  {
    AppMethodBeat.i(4215);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(4215);
      return "";
    }
    String str = getUpdateConfigDir() + File.separator + "pluginUpdateConfig.xml";
    AppMethodBeat.o(4215);
    return str;
  }
  
  public static int getPluginUpdatePeriod()
  {
    AppMethodBeat.i(151464);
    int i = getTempPluginUpdatePeriod();
    if (i > 0)
    {
      addXWalkInitializeLog("getPluginUpdatePeriod use tempPeriod");
      AppMethodBeat.o(151464);
      return i;
    }
    addXWalkInitializeLog("getPluginUpdatePeriod use defaultPeriod");
    AppMethodBeat.o(151464);
    return 90000000;
  }
  
  public static String getProcessName()
  {
    AppMethodBeat.i(4283);
    if (sStrCurentProcessName != null)
    {
      localObject = sStrCurentProcessName;
      AppMethodBeat.o(4283);
      return localObject;
    }
    Object localObject = getXWebInitArgs("processname");
    if (localObject != null)
    {
      localObject = localObject.toString();
      sStrCurentProcessName = (String)localObject;
      AppMethodBeat.o(4283);
      return localObject;
    }
    localObject = getApplicationContext();
    int i = Process.myPid();
    if (localObject == null)
    {
      AppMethodBeat.o(4283);
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
    AppMethodBeat.o(4283);
    return localObject;
  }
  
  public static SharedPreferences getProcessSafePreferences(String paramString, int paramInt)
  {
    AppMethodBeat.i(4205);
    paramString = sApplicationContext.getSharedPreferences(paramString, paramInt);
    AppMethodBeat.o(4205);
    return paramString;
  }
  
  public static String getRuntimeAbi()
  {
    AppMethodBeat.i(4267);
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
            break label698;
          }
          if (isIaDevice()) {
            sRuntimeAbi = "x86";
          }
          Log.i("XWalkEnvironment", "Runtime ABI: " + sRuntimeAbi);
          str = sRuntimeAbi;
          AppMethodBeat.o(4267);
          return str;
          if (!str.equals("armeabi")) {
            break label725;
          }
          i = 0;
          break label727;
          if (!str.equals("armeabi-v7a")) {
            break label725;
          }
          i = 1;
          break label727;
          if (!str.equals("arm64-v8a")) {
            break label725;
          }
          i = 2;
          break label727;
          if (!str.equals("x86")) {
            break label725;
          }
          i = 3;
          break label727;
          if (!str.equals("x86_64")) {
            break label725;
          }
          i = 4;
          break label727;
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
          break label769;
          if (localException1.equals("i686"))
          {
            i = 1;
            break label769;
            if (localException1.equals("i386"))
            {
              i = 2;
              break label769;
              if (localException1.equals("ia32"))
              {
                i = 3;
                break label769;
                if (localException1.equals("x64"))
                {
                  i = 4;
                  break label769;
                  if (localException1.equals("x86_64"))
                  {
                    i = 5;
                    break label769;
                    if (localException1.equals("armv7l"))
                    {
                      i = 6;
                      break label769;
                      if (localException1.equals("armeabi"))
                      {
                        i = 7;
                        break label769;
                        if (localException1.equals("armeabi-v7a"))
                        {
                          i = 8;
                          break label769;
                          if (localException1.equals("aarch64"))
                          {
                            i = 9;
                            break label769;
                            if (localException1.equals("armv8"))
                            {
                              i = 10;
                              break label769;
                              if (localException1.equals("arm64"))
                              {
                                i = 11;
                                break label769;
                                sRuntimeAbi = "x86";
                                continue;
                                label698:
                                label725:
                                label727:
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
        label769:
        switch (i)
        {
        }
      }
    }
  }
  
  public static SharedPreferences getSharedPreferences()
  {
    AppMethodBeat.i(4217);
    SharedPreferences localSharedPreferences = sApplicationContext.getSharedPreferences("libxwalkcore", 4);
    AppMethodBeat.o(4217);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForFileReaderRecord()
  {
    AppMethodBeat.i(4214);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(4214);
      return null;
    }
    SharedPreferences localSharedPreferences = getProcessSafePreferences("xwalk_reader_record", 4);
    AppMethodBeat.o(4214);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForLog()
  {
    AppMethodBeat.i(4211);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(4211);
      return null;
    }
    SharedPreferences localSharedPreferences = getMMKVSharedPreferencesEx("UPDATELOG", 4, true);
    AppMethodBeat.o(4211);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForPluginUpdateInfo()
  {
    AppMethodBeat.i(4212);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(4212);
      return null;
    }
    SharedPreferences localSharedPreferences = getProcessSafePreferences("xwalk_plugin_update_info", 4);
    AppMethodBeat.o(4212);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForPluginVersionInfo(String paramString)
  {
    AppMethodBeat.i(4213);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(4213);
      return null;
    }
    paramString = getProcessSafePreferences("xwalk_plugin_version_info_".concat(String.valueOf(paramString)), 4);
    AppMethodBeat.o(4213);
    return paramString;
  }
  
  public static SharedPreferences getSharedPreferencesForTestXWeb()
  {
    AppMethodBeat.i(4257);
    if (sApplicationContext == null)
    {
      Log.e("XWalkEnvironment", "getSharedPreferencesForTestXWeb context is null");
      AppMethodBeat.o(4257);
      return null;
    }
    SharedPreferences localSharedPreferences = sApplicationContext.getSharedPreferences("TESTXWEB", 4);
    AppMethodBeat.o(4257);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForUpdateConfig()
  {
    AppMethodBeat.i(4209);
    SharedPreferences localSharedPreferences = getProcessSafePreferences("UPDATEINFOTAG", 4);
    AppMethodBeat.o(4209);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForVersionInfo()
  {
    AppMethodBeat.i(4210);
    SharedPreferences localSharedPreferences = sApplicationContext.getSharedPreferences("XWALKINFOS", 4);
    AppMethodBeat.o(4210);
    return localSharedPreferences;
  }
  
  public static SharedPreferences getSharedPreferencesForXWEBUpdater()
  {
    AppMethodBeat.i(151466);
    SharedPreferences localSharedPreferences = getMMKVSharedPreferencesEx("XWEB_UPDATER", 4, false);
    AppMethodBeat.o(151466);
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
    AppMethodBeat.i(4254);
    paramContext = paramContext.getSharedPreferences("TESTXWEB", 4).getString("XWEB_TEST_CONFIG_URL", "");
    AppMethodBeat.o(4254);
    return paramContext;
  }
  
  public static String getUpdateConfigDir()
  {
    AppMethodBeat.i(4233);
    String str = sApplicationContext.getDir("xwalkconfig", 0).getAbsolutePath();
    AppMethodBeat.o(4233);
    return str;
  }
  
  public static String getUpdateConfigFullPath()
  {
    AppMethodBeat.i(4234);
    String str = getUpdateConfigDir() + File.separator + "updateConfg.xml";
    AppMethodBeat.o(4234);
    return str;
  }
  
  public static int getUserType()
  {
    AppMethodBeat.i(4272);
    int i = getIpType();
    AppMethodBeat.o(4272);
    return i;
  }
  
  public static boolean getUsingCustomContext()
  {
    return sUsingCustomContext;
  }
  
  static int getVerFromVersionName(String paramString)
  {
    AppMethodBeat.i(4253);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(4253);
      return 0;
    }
    String[] arrayOfString = paramString.split("\\.");
    try
    {
      int i = Integer.parseInt(arrayOfString[0]);
      AppMethodBeat.o(4253);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("XWalkEnvironment", "parse to int error str is :".concat(String.valueOf(paramString)));
      AppMethodBeat.o(4253);
    }
    return 0;
  }
  
  public static String getVesionDir(int paramInt)
  {
    AppMethodBeat.i(4227);
    String str = sApplicationContext.getDir("xwalk_".concat(String.valueOf(paramInt)), 0).getAbsolutePath();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(4227);
    return str;
  }
  
  public static String getVesionDir(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4289);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "getVersionDir with context, context is null");
      AppMethodBeat.o(4289);
      return "";
    }
    paramContext = paramContext.getDir("xwalk_".concat(String.valueOf(paramInt)), 0).getAbsolutePath();
    AppMethodBeat.o(4289);
    return paramContext;
  }
  
  public static String getXWalkInitializeLog()
  {
    AppMethodBeat.i(4232);
    Object localObject = getSharedPreferencesForLog();
    if (localObject == null)
    {
      AppMethodBeat.o(4232);
      return "";
    }
    localObject = ((SharedPreferences)localObject).getString("log", "");
    AppMethodBeat.o(4232);
    return localObject;
  }
  
  public static String getXWalkUpdateConfigUrl()
  {
    AppMethodBeat.i(4256);
    String str = getTestDownLoadUrl(getApplicationContext());
    sXWalkDownConfigUrl = str;
    if ((str != null) && (!sXWalkDownConfigUrl.trim().isEmpty())) {
      addXWalkInitializeLog("use test config url : " + sXWalkDownConfigUrl);
    }
    for (;;)
    {
      Log.i("XWalkEnvironment", "use update config url = " + sXWalkDownConfigUrl);
      str = sXWalkDownConfigUrl;
      AppMethodBeat.o(4256);
      return str;
      str = getTempUpdateConfigUrl();
      sXWalkDownConfigUrl = str;
      if ((str != null) && (!sXWalkDownConfigUrl.trim().isEmpty())) {
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
    //   3: sipush 4203
    //   6: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 1044	org/xwalk/core/XWalkEnvironment:sXWebArgs	Ljava/util/HashMap;
    //   12: ifnull +13 -> 25
    //   15: getstatic 1044	org/xwalk/core/XWalkEnvironment:sXWebArgs	Ljava/util/HashMap;
    //   18: aload_0
    //   19: invokevirtual 1049	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   22: ifne +16 -> 38
    //   25: aconst_null
    //   26: astore_0
    //   27: sipush 4203
    //   30: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: areturn
    //   38: getstatic 1044	org/xwalk/core/XWalkEnvironment:sXWebArgs	Ljava/util/HashMap;
    //   41: aload_0
    //   42: invokevirtual 1052	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: astore_0
    //   46: sipush 4203
    //   49: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean getXWebInitArgs(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(4204);
        paramString = getXWebInitArgs(paramString);
        if (paramString != null) {
          continue;
        }
        AppMethodBeat.o(4204);
      }
      finally
      {
        try
        {
          boolean bool = Boolean.valueOf(paramString.toString()).booleanValue();
          paramBoolean = bool;
          AppMethodBeat.o(4204);
        }
        catch (Exception paramString)
        {
          Log.e("XWalkEnvironment", "getXWebInitArgs boolean parse failed");
          AppMethodBeat.o(4204);
        }
        paramString = finally;
      }
      return paramBoolean;
    }
  }
  
  public static boolean hasAvailableVersion()
  {
    AppMethodBeat.i(4223);
    if (49 > getAvailableVersion())
    {
      AppMethodBeat.o(4223);
      return false;
    }
    AppMethodBeat.o(4223);
    return true;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(4199);
    if ((paramContext == null) || (sApplicationContext != null))
    {
      AppMethodBeat.o(4199);
      return;
    }
    sApplicationContext = paramContext.getApplicationContext();
    if (sAvailableVersion == -1)
    {
      sAvailableVersion = getSharedPreferencesForVersionInfo().getInt("availableVersion", -1);
      sStrVersionDetail = getSharedPreferencesForVersionInfo().getString("versionDetail", "");
      if (sAvailableVersion != -1) {
        getSharedPreferences().edit().putString("XWALK_CORE_EXTRACTED_DIR", getExtractedCoreDir(sAvailableVersion)).commit();
      }
    }
    if (!sIsPluginInited) {
      sIsPluginInited = initXWalkPlugins();
    }
    q.jS(paramContext);
    AppMethodBeat.o(4199);
  }
  
  static void initSafePsProvider()
  {
    AppMethodBeat.i(4202);
    if (sBHasInitedSafePsProvider)
    {
      AppMethodBeat.o(4202);
      return;
    }
    try
    {
      sMMKVMethod = Class.forName("com.tencent.mm.cn.c").getMethod("getMMKV", new Class[] { Context.class, String.class, Integer.TYPE, Boolean.TYPE });
      label61:
      if (sMMKVMethod == null)
      {
        f.pf(178L);
        Log.e("XWalkEnvironment", "initSafePsProvider failed");
      }
      for (;;)
      {
        sBHasInitedSafePsProvider = true;
        AppMethodBeat.o(4202);
        return;
        Log.i("XWalkEnvironment", "initSafePsProvider suscsess");
      }
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
  
  private static boolean initXWalkPlugins()
  {
    AppMethodBeat.i(4200);
    boolean bool = e.eao();
    AppMethodBeat.o(4200);
    return bool;
  }
  
  public static boolean is64bitApp()
  {
    AppMethodBeat.i(4266);
    String str = getRuntimeAbi();
    if ((str.equals("arm64-v8a")) || (str.equals("x86_64")))
    {
      AppMethodBeat.o(4266);
      return true;
    }
    AppMethodBeat.o(4266);
    return false;
  }
  
  public static boolean is64bitDevice()
  {
    AppMethodBeat.i(4265);
    String str = getDeviceAbi();
    if ((str.equals("arm64-v8a")) || (str.equals("x86_64")))
    {
      AppMethodBeat.o(4265);
      return true;
    }
    AppMethodBeat.o(4265);
    return false;
  }
  
  public static boolean isCurrentVersionSupportCustomContext()
  {
    AppMethodBeat.i(4220);
    if ((hasAvailableVersion()) && (getFeatureSupport(1020)))
    {
      AppMethodBeat.o(4220);
      return true;
    }
    AppMethodBeat.o(4220);
    return false;
  }
  
  public static boolean isCurrentVersionSupportExtendPluginForAppbrand()
  {
    AppMethodBeat.i(4218);
    if ((hasAvailableVersion()) && (getAvailableVersion() >= 300))
    {
      AppMethodBeat.o(4218);
      return true;
    }
    AppMethodBeat.o(4218);
    return false;
  }
  
  public static boolean isCurrentVersionSupportMapExtendPluginForAppbrand()
  {
    AppMethodBeat.i(4219);
    if ((hasAvailableVersion()) && (getFeatureSupport(1011)))
    {
      AppMethodBeat.o(4219);
      return true;
    }
    AppMethodBeat.o(4219);
    return false;
  }
  
  public static boolean isDownloadMode()
  {
    AppMethodBeat.i(4262);
    boolean bool = sIsDownloadMode.booleanValue();
    AppMethodBeat.o(4262);
    return bool;
  }
  
  public static boolean isDownloadModeUpdate()
  {
    AppMethodBeat.i(4263);
    boolean bool = sIsDownloadModeUpdate.booleanValue();
    AppMethodBeat.o(4263);
    return bool;
  }
  
  public static boolean isForbidDownloadCode()
  {
    return sIsForbidDownloadCode;
  }
  
  public static boolean isIaDevice()
  {
    AppMethodBeat.i(4264);
    String str = getDeviceAbi();
    if ((str.equals("x86")) || (str.equals("x86_64")))
    {
      AppMethodBeat.o(4264);
      return true;
    }
    AppMethodBeat.o(4264);
    return false;
  }
  
  public static boolean isInTestMode()
  {
    AppMethodBeat.i(4249);
    String str = getTestDownLoadUrl(getApplicationContext());
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(4249);
      return false;
    }
    AppMethodBeat.o(4249);
    return true;
  }
  
  public static boolean isProvider(String paramString)
  {
    AppMethodBeat.i(4287);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XWalkEnvironment", "isProvider packageName is null or empty");
      AppMethodBeat.o(4287);
      return false;
    }
    String[] arrayOfString = XWALK_CORE_PROVIDER_LIST;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString))
      {
        AppMethodBeat.o(4287);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(4287);
    return false;
  }
  
  public static boolean isSelfProvider()
  {
    AppMethodBeat.i(4286);
    if (sApplicationContext == null)
    {
      Log.e("XWalkEnvironment", "isSelfProvider sApplicationContext is null");
      AppMethodBeat.o(4286);
      return true;
    }
    boolean bool = isProvider(sApplicationContext.getPackageName());
    AppMethodBeat.o(4286);
    return bool;
  }
  
  public static boolean isTestVersion(int paramInt)
  {
    return paramInt >= 100000;
  }
  
  public static int readAvailableVersionFromSP(Context paramContext)
  {
    AppMethodBeat.i(4295);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "readAvailableVersionFromSP context is null");
      AppMethodBeat.o(4295);
      return -1;
    }
    paramContext = paramContext.getSharedPreferences("XWALKINFOS", 4);
    if (paramContext == null)
    {
      Log.e("XWalkEnvironment", "readAvailableVersionFromSP sp is null");
      AppMethodBeat.o(4295);
      return -1;
    }
    int i = paramContext.getInt("availableVersion", -1);
    AppMethodBeat.o(4295);
    return i;
  }
  
  public static void resetForDebug()
  {
    sApplicationContext = null;
    sAvailableVersion = -1;
    sIsPluginInited = false;
  }
  
  public static int safeGetChromiunVersion()
  {
    AppMethodBeat.i(4251);
    if (sNChromiuVersion < 0)
    {
      Object localObject = getApplicationContext().getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.webview", 0);
        if (localObject != null)
        {
          i = getVerFromVersionName(((PackageInfo)localObject).versionName);
          if (i > 0)
          {
            sNChromiuVersion = i;
            AppMethodBeat.o(4251);
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
    AppMethodBeat.o(4251);
    return i;
  }
  
  public static boolean setAvailableVersion(int paramInt, String paramString)
  {
    AppMethodBeat.i(4226);
    Log.i("XWalkEnvironment", "setAvailableVersion:".concat(String.valueOf(paramInt)));
    SharedPreferences.Editor localEditor = getSharedPreferencesForVersionInfo().edit();
    localEditor.putInt("availableVersion", paramInt);
    localEditor.putString("versionDetail", paramString);
    boolean bool = localEditor.commit();
    addXWalkInitializeLog("XWalkEnvironment", "set xwalk version to " + paramInt + " suc = " + bool);
    AppMethodBeat.o(4226);
    return bool;
  }
  
  public static void setGrayValueByUserId(int paramInt)
  {
    AppMethodBeat.i(4273);
    if (paramInt == 0)
    {
      AppMethodBeat.o(4273);
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
        AppMethodBeat.o(4273);
        return;
      }
      paramInt = localObject[3];
      int i = localObject[2];
      int j = localObject[1];
      paramInt = (localObject[0] & 0x7F) << 24 | paramInt & 0xFF | (i & 0xFF) << 8 | (j & 0xFF) << 16;
      if (paramInt == 0)
      {
        AppMethodBeat.o(4273);
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
      l.e(WebView.d.BEq).excute("STR_CMD_SET_RECHECK_COMMAND", null);
    }
    AppMethodBeat.o(4273);
  }
  
  public static void setGrayValueForTest(int paramInt)
  {
    AppMethodBeat.i(4269);
    if (paramInt != 10001) {
      s_grayValue = paramInt % 10000;
    }
    getSharedPreferences().edit().putInt("TEST_GRAY_VALUE", s_grayValue).commit();
    AppMethodBeat.o(4269);
  }
  
  public static void setIpType(int paramInt)
  {
    AppMethodBeat.i(4270);
    int i = getIpType();
    if (paramInt != i)
    {
      getSharedPreferences().edit().putInt("IP_TYPE", paramInt).commit();
      addXWalkInitializeLog("setIpType", " to  ".concat(String.valueOf(paramInt)));
      if ((i != 0) || (paramInt != 1)) {
        break label103;
      }
      f.pf(197L);
    }
    for (;;)
    {
      if ((i > 0) || (paramInt > 0))
      {
        sBIsIpTypeChanged = true;
        l.e(WebView.d.BEq).excute("STR_CMD_SET_RECHECK_COMMAND", null);
      }
      AppMethodBeat.o(4270);
      return;
      label103:
      if ((i == 1) && (paramInt == 0)) {
        f.pf(198L);
      }
    }
  }
  
  public static void setIsForbidDownloadCode(boolean paramBoolean)
  {
    AppMethodBeat.i(4201);
    sIsForbidDownloadCode = paramBoolean;
    addXWalkInitializeLog("XWalkEnvironment", "setIsForbidDownloadCode: " + sIsForbidDownloadCode);
    AppMethodBeat.o(4201);
  }
  
  public static boolean setPluginTestConfigUrl(String paramString)
  {
    AppMethodBeat.i(4260);
    Object localObject = getSharedPreferencesForTestXWeb();
    if (localObject == null)
    {
      Log.e("XWalkEnvironment", "setPluginTestConfigUrl sp is null");
      AppMethodBeat.o(4260);
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if ((paramString == null) || (paramString.trim().isEmpty())) {
      ((SharedPreferences.Editor)localObject).remove("XWEB_PLUGIN_TEST_CONFIG_URL");
    }
    for (;;)
    {
      boolean bool = ((SharedPreferences.Editor)localObject).commit();
      AppMethodBeat.o(4260);
      return bool;
      ((SharedPreferences.Editor)localObject).putString("XWEB_PLUGIN_TEST_CONFIG_URL", paramString.trim());
    }
  }
  
  public static void setSharedPreferenceProvider(h paramh)
  {
    if (paramh != null) {}
    try
    {
      sSPProvider = paramh;
      return;
    }
    finally
    {
      paramh = finally;
      throw paramh;
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
    AppMethodBeat.i(4255);
    sXWalkDownConfigUrl = null;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramContext.getSharedPreferences("TESTXWEB", 4).edit().putString("XWEB_TEST_CONFIG_URL", "").commit();
      getXWalkUpdateConfigUrl();
      AppMethodBeat.o(4255);
      return;
    }
    paramContext.getSharedPreferences("TESTXWEB", 4).edit().putString("XWEB_TEST_CONFIG_URL", paramString).commit();
    getXWalkUpdateConfigUrl();
    AppMethodBeat.o(4255);
  }
  
  public static void setUsingCustomContext(boolean paramBoolean)
  {
    AppMethodBeat.i(4221);
    sUsingCustomContext = paramBoolean;
    Log.i("XWalkEnvironment", "setUsingCustomContext usingCustomContext:".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(4221);
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
    AppMethodBeat.i(4275);
    if (paramCloseable == null)
    {
      AppMethodBeat.o(4275);
      return;
    }
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(4275);
      return;
    }
    catch (Exception paramCloseable)
    {
      Log.e("XWalkEnvironment", "closeable close  failed " + paramCloseable.getMessage());
      AppMethodBeat.o(4275);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkEnvironment
 * JD-Core Version:    0.7.0.1
 */