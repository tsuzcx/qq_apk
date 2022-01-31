package org.xwalk.core;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.xweb.k;
import com.tencent.xweb.util.a;
import com.tencent.xweb.util.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
  public static final String DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL = "http://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
  public static final String DOWNLOAD_PLUGIN_UPDATE_TEST_CONFIG_DEFAULT_URL = "http://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml";
  public static final String DOWNLOAD_X86_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86.xml";
  public static final int LOCAL_TEST_VERSION = 999;
  public static final String LOCAL_TEST_ZIP_NAME = "runtime_package.zip";
  public static final String[] MANDATORY_RESOURCES = { "classes.dex", "icudtl.dat", "xwalk.pak", "xwalk_100_percent.pak", "xweb_fullscreen_video.js" };
  private static final String META_XWALK_DOWNCONFIG_URL = "xwalk_downconfig_url";
  public static final String MM_PACKAGE_NAME = "com.tencent.mm";
  private static final String OPTIMIZED_DEX_DIR = "dex";
  private static final String PACKAGE_RE = "[a-z]+\\.[a-z0-9]+\\.[a-z0-9]+.*";
  private static final String PATCH_ZIP_TEMP_DECOMPRESS_DIR = "patch_temp_decompress";
  public static final int SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION = 153;
  public static final int SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION = 255;
  public static final int SDK_SUPPORT_MIN_APKVERSION = 49;
  public static final int SDK_VERSION = 180801;
  private static final int SPECIAL_TEST_USER_ID = 10001;
  private static final String SP_KEY_DEVICE_RD = "sNDeviceRd";
  private static final String SP_KEY_GRAY_VALUE = "GRAY_VALUE";
  private static final String SP_KEY_GRAY_VALUE_TEST = "TEST_GRAY_VALUE";
  public static final String SP_KEY_PLUGIN_AVAILABLE_VERSION = "availableVersion";
  private static final String SP_KEY_PLUGIN_TEST_CONFIG_URL = "XWEB_PLUGIN_TEST_CONFIG_URL";
  public static final String SP_KEY_PLUGIN_UPDATE_CONFIG_LAST_FETCH_TIME = "nLastFetchPluginConfigTime";
  public static final String SP_KEY_PLUGIN_UPDATE_PROCESS_ID = "nUpdatingProcessId";
  private static final String SP_NAME_PLUGIN_UPDATE_INFO = "xwalk_plugin_update_info";
  private static final String SP_NAME_PLUGIN_VERSION_INFO_PREFIX = "xwalk_plugin_version_info_";
  private static final String SP_NAME_VERSION_INFO = "XWALKINFOS";
  private static final String TAG = "XWalkLib";
  public static String UPDATEINFOTAG = "xwalk_update_info";
  public static final String XWALK_CORE_APK_NAME = "base.apk";
  private static final String XWALK_CORE_CLASSES_DEX = "classes.dex";
  private static final String XWALK_CORE_EXTRACTED_DIR = "extracted_xwalkcore";
  public static final String XWALK_CORE_FILELIST_CONFIG_NAME = "filelist.config";
  private static final String XWALK_CORE_NAME_PREFIX = "xwalk_";
  private static final String XWALK_CORE_PATCH_CONFIG_NAME = "patch.config";
  private static final String XWALK_CORE_PATCH_NAME = "patch.zip";
  public static final String[] XWALK_CORE_PROVIDER_LIST = { "com.tencent.mm" };
  private static final String XWALK_CORE_RES_FILELIST_CONFIG_NAME = "reslist.config";
  private static final String XWALK_CORE_ZIP_NAME = "base.zip";
  public static final String XWALK_ENV_MAP_KEY_ISGPVERSION = "isgpversion";
  public static final String XWALK_ENV_MAP_KEY_PROCESSNAME = "processname";
  public static final int XWALK_GET_FROM_PROVIDER_MAX_COUNT = 2;
  private static final String XWALK_PLUGIN_BASE_DIR = "xwalkplugin";
  public static final String XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO = "FullScreenVideo";
  private static final String XWALK_PLUGIN_UPDATE_CONFIG_NAME = "pluginUpdateConfig.xml";
  private static final String XWALK_UPDATE_CONFIG_DIR = "xwalkconfig";
  private static final String ZIP_DIR = "zip";
  private static Context sApplicationContext;
  private static String sApplicationName;
  private static int sAvailableVersion;
  static boolean sBHasInitedSafePsProvider;
  private static String sDeviceAbi;
  private static Boolean sIsDownloadMode;
  private static Boolean sIsDownloadModeUpdate;
  private static boolean sIsForbidDownloadCode;
  private static boolean sIsPluginInited = false;
  private static Boolean sIsXWalkVerify;
  static int sNChromiuVersion;
  static int sNDeviceRd;
  static int sPid;
  private static String sRuntimeAbi;
  static Method sSafePSProvider;
  static String sStrCurentProcessName;
  static String sStrDeviceId;
  private static String sStrTempUpdateConfigUrl;
  private static String sStrVersionDetail;
  private static String sXWalkApkUrl;
  private static String sXWalkDownConfigUrl;
  static HashMap<String, Object> sXWebArgs;
  static int s_grayValue;
  
  static
  {
    sIsForbidDownloadCode = false;
    sIsDownloadMode = Boolean.valueOf(true);
    sIsDownloadModeUpdate = Boolean.valueOf(true);
    sAvailableVersion = -1;
    sBHasInitedSafePsProvider = false;
    sPid = android.os.Process.myPid();
    s_grayValue = 0;
    sNChromiuVersion = -1;
    sNDeviceRd = 0;
    sStrDeviceId = null;
  }
  
  static int _getChromiunVersion()
  {
    Object localObject = getApplicationContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.webview", 0);
      if (localObject != null)
      {
        i = getVerFromVersionName(((PackageInfo)localObject).versionName);
        if (i > 0) {
          return i;
        }
      }
    }
    catch (Exception localException1)
    {
      int i;
      Log.e("XWalkLib", "Android System WebView is not found");
      try
      {
        String str = new WebView(getApplicationContext()).getSettings().getUserAgentString();
        if (str != null)
        {
          String[] arrayOfString = str.split("Chrome/");
          if ((arrayOfString == null) || (arrayOfString.length == 0) || ((arrayOfString.length == 1) && (arrayOfString[0].length() == str.length()))) {
            break label122;
          }
          i = getVerFromVersionName(arrayOfString[1]);
          return i;
        }
      }
      catch (Exception localException2)
      {
        Log.e("XWalkLib", "Android System WebView is not found");
      }
      return 0;
    }
    label122:
    return 0;
  }
  
  public static void addXWalkInitializeLog(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
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
  }
  
  public static void addXWalkInitializeLog(String paramString1, String paramString2)
  {
    addXWalkInitializeLog(paramString1 + ": " + paramString2);
  }
  
  public static boolean checkApiVersionAllFileExist(int paramInt)
  {
    return (checkApiVersionExtractResourceExist(paramInt)) && (checkApiVersionBaseApkExist(paramInt));
  }
  
  /* Error */
  public static boolean checkApiVersionAvailable(int paramInt)
  {
    // Byte code:
    //   0: iload_0
    //   1: invokestatic 379	org/xwalk/core/XWalkEnvironment:getExtractedCoreDir	(I)Ljava/lang/String;
    //   4: astore_2
    //   5: iload_0
    //   6: invokestatic 382	org/xwalk/core/XWalkEnvironment:getClassDexFilePath	(I)Ljava/lang/String;
    //   9: astore_3
    //   10: new 384	java/io/File
    //   13: dup
    //   14: aload_3
    //   15: invokespecial 385	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 388	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: new 390	dalvik/system/DexClassLoader
    //   29: dup
    //   30: aload_3
    //   31: iload_0
    //   32: invokestatic 393	org/xwalk/core/XWalkEnvironment:getOptimizedDexDir	(I)Ljava/lang/String;
    //   35: aload_2
    //   36: invokestatic 399	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   39: invokespecial 402	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   42: astore_2
    //   43: aload_2
    //   44: ldc_w 404
    //   47: invokevirtual 408	dalvik/system/DexClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   50: astore 4
    //   52: ldc_w 335
    //   55: astore_2
    //   56: new 410	org/xwalk/core/ReflectField
    //   59: dup
    //   60: aload 4
    //   62: ldc_w 412
    //   65: invokespecial 415	org/xwalk/core/ReflectField:<init>	(Ljava/lang/Class;Ljava/lang/String;)V
    //   68: invokevirtual 419	org/xwalk/core/ReflectField:get	()Ljava/lang/Object;
    //   71: checkcast 174	java/lang/String
    //   74: astore_3
    //   75: aload_3
    //   76: astore_2
    //   77: new 410	org/xwalk/core/ReflectField
    //   80: dup
    //   81: aload 4
    //   83: ldc_w 421
    //   86: invokespecial 415	org/xwalk/core/ReflectField:<init>	(Ljava/lang/Class;Ljava/lang/String;)V
    //   89: invokevirtual 419	org/xwalk/core/ReflectField:get	()Ljava/lang/Object;
    //   92: checkcast 423	java/lang/Integer
    //   95: invokevirtual 426	java/lang/Integer:intValue	()I
    //   98: istore_0
    //   99: new 410	org/xwalk/core/ReflectField
    //   102: dup
    //   103: aload 4
    //   105: ldc_w 428
    //   108: invokespecial 415	org/xwalk/core/ReflectField:<init>	(Ljava/lang/Class;Ljava/lang/String;)V
    //   111: invokevirtual 419	org/xwalk/core/ReflectField:get	()Ljava/lang/Object;
    //   114: checkcast 423	java/lang/Integer
    //   117: invokevirtual 426	java/lang/Integer:intValue	()I
    //   120: istore_1
    //   121: ldc 86
    //   123: new 312	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 430
    //   130: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_2
    //   134: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 433
    //   140: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: iload_0
    //   144: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: ldc_w 435
    //   150: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload_1
    //   154: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: invokevirtual 327	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 438	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: iconst_1
    //   164: ireturn
    //   165: astore_2
    //   166: iconst_0
    //   167: ireturn
    //   168: astore_2
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_3
    //   172: goto -95 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramInt	int
    //   120	34	1	i	int
    //   4	130	2	localObject	Object
    //   165	1	2	localException1	Exception
    //   168	1	2	localException2	Exception
    //   9	67	3	str	String
    //   171	1	3	localRuntimeException	RuntimeException
    //   50	54	4	localClass	java.lang.Class
    // Exception table:
    //   from	to	target	type
    //   43	52	165	java/lang/Exception
    //   56	75	165	java/lang/Exception
    //   77	163	165	java/lang/Exception
    //   0	24	168	java/lang/Exception
    //   26	43	168	java/lang/Exception
    //   56	75	171	java/lang/RuntimeException
  }
  
  public static boolean checkApiVersionBaseApkExist(int paramInt)
  {
    return new File(getDownloadApkPath(paramInt)).exists();
  }
  
  private static boolean checkApiVersionExtractResourceExist(int paramInt)
  {
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
          Log.i("XWalkLib", "XWalkEnvironment checkApiVersionExtractResourceExist not exist Version:" + paramInt + ", resource name:" + str + ", Path:" + localFile.getAbsolutePath());
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  public static void clearAllVersion(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null) || (paramContext.getApplicationInfo().dataDir == null)) {}
    do
    {
      return;
      paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
    } while (paramContext == null);
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContext[i];
      if ((localObject.getName().startsWith("app_xwalk_")) && (localObject.isDirectory())) {
        a.agX(localObject.getAbsolutePath());
      }
      i += 1;
    }
    setAvailableVersion(-1, "");
  }
  
  public static boolean delApiVersion(int paramInt)
  {
    return a.agX(getVesionDir(paramInt));
  }
  
  public static Context getApplicationContext()
  {
    return sApplicationContext;
  }
  
  private static String getApplicationMetaData(String paramString)
  {
    try
    {
      paramString = sApplicationContext.getPackageManager().getApplicationInfo(sApplicationContext.getPackageName(), 128).metaData.get(paramString).toString();
      return paramString;
    }
    catch (NullPointerException paramString)
    {
      return null;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label32:
      break label32;
    }
  }
  
  public static String getApplicationName()
  {
    if (sApplicationName == null) {}
    try
    {
      PackageManager localPackageManager = sApplicationContext.getPackageManager();
      sApplicationName = (String)localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(sApplicationContext.getPackageName(), 0));
      label34:
      if ((sApplicationName == null) || (sApplicationName.isEmpty()) || (sApplicationName.matches("[a-z]+\\.[a-z0-9]+\\.[a-z0-9]+.*"))) {
        sApplicationName = "this application";
      }
      Log.d("XWalkLib", "Crosswalk application name: " + sApplicationName);
      return sApplicationName;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label34;
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
    if (sNChromiuVersion < 0) {
      sNChromiuVersion = _getChromiunVersion();
    }
    return sNChromiuVersion;
  }
  
  public static String getClassDexFilePath(int paramInt)
  {
    return getExtractedCoreDir(paramInt) + File.separator + "classes.dex";
  }
  
  public static ContentResolver getContentResolver()
  {
    if (sApplicationContext == null)
    {
      Log.e("XWalkLib", "getContentResolver sApplicationContext is null");
      return null;
    }
    return sApplicationContext.getContentResolver();
  }
  
  public static String getDeviceAbi()
  {
    if (sDeviceAbi == null) {}
    try
    {
      sDeviceAbi = Build.SUPPORTED_ABIS[0].toLowerCase();
      Log.d("XWalkLib", "Device ABI: " + sDeviceAbi);
      return sDeviceAbi;
    }
    catch (NoSuchFieldError localNoSuchFieldError)
    {
      try
      {
        InputStreamReader localInputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
        BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
        sDeviceAbi = localBufferedReader.readLine().toLowerCase();
        localBufferedReader.close();
        localInputStreamReader.close();
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Can not detect device's ABI");
      }
    }
  }
  
  public static String getDeviceId()
  {
    if (sStrDeviceId == null) {}
    for (;;)
    {
      try
      {
        localTelephonyManager = (TelephonyManager)getApplicationContext().getSystemService("phone");
        if (localTelephonyManager != null) {
          continue;
        }
        sStrDeviceId = "";
      }
      catch (Exception localException)
      {
        TelephonyManager localTelephonyManager;
        sStrDeviceId = "";
        Log.e("XWalkEnvironment", "getDeviceId failed " + localException.getMessage());
        continue;
      }
      return sStrDeviceId;
      sStrDeviceId = localTelephonyManager.getDeviceId();
    }
  }
  
  public static int getDeviceRd()
  {
    if (sNDeviceRd <= 0)
    {
      int i = getSharedPreferences().getInt("sNDeviceRd", -1);
      sNDeviceRd = i;
      if (i <= 0)
      {
        sNDeviceRd = new Random().nextInt(10000000) + 1;
        getSharedPreferences().edit().putInt("sNDeviceRd", sNDeviceRd).apply();
      }
    }
    return sNDeviceRd % 10000 + 1;
  }
  
  public static String getDownloadApkDir(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static String getDownloadApkPath(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str + File.separator + "base.apk";
  }
  
  public static String getDownloadApkPath(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      Log.e("XWalkLib", "getDownloadApkPath with context, context is null");
      return "";
    }
    paramContext = getVesionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkLib", "getDownloadApkPath with context, versionDir is empty");
      return "";
    }
    return paramContext + File.separator + "apk" + File.separator + "base.apk";
  }
  
  public static String getDownloadPatchPath(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "apk";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str + File.separator + "patch.zip";
  }
  
  public static String getDownloadResFileListConfig(int paramInt)
  {
    return getExtractedCoreFile(paramInt, "reslist.config");
  }
  
  public static String getDownloadZipDir(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "zip";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str + File.separator + "base.zip";
  }
  
  public static String getDownloadZipFileListConfig(int paramInt)
  {
    return getExtractedCoreFile(paramInt, "filelist.config");
  }
  
  public static String getDownloadZipFileListConfig(Context paramContext, int paramInt)
  {
    return getExtractedCoreFile(paramContext, paramInt, "filelist.config");
  }
  
  public static String getExtractedCoreDir(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "extracted_xwalkcore";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static String getExtractedCoreFile(int paramInt, String paramString)
  {
    String str = getVesionDir(paramInt) + File.separator + "extracted_xwalkcore";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString;
  }
  
  public static String getExtractedCoreFile(Context paramContext, int paramInt, String paramString)
  {
    if (paramContext == null)
    {
      Log.e("XWalkLib", "getExtractedCoreFile with context, context is null");
      return "";
    }
    paramContext = getVesionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkLib", "getExtractedCoreFile with context, versionDir is empty");
      return "";
    }
    return paramContext + File.separator + "extracted_xwalkcore" + File.separator + paramString;
  }
  
  public static int getGrayValue()
  {
    if (s_grayValue != 0) {
      return s_grayValue;
    }
    try
    {
      int i = getSharedPreferences().getInt("TEST_GRAY_VALUE", -1);
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
    return s_grayValue;
  }
  
  public static int getInstalledNewstVersion()
  {
    return getSharedPreferencesForVersionInfo().getInt("availableVersion", -1);
  }
  
  public static String getOptimizedDexDir(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "dex";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static Context getPackageContext(String paramString)
  {
    if (sApplicationContext == null)
    {
      Log.e("XWalkLib", "getTargetPackageContext sApplicationContext is null");
      return null;
    }
    try
    {
      paramString = sApplicationContext.createPackageContext(paramString, 2);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("XWalkLib", paramString.getMessage());
    }
    return null;
  }
  
  public static String getPackageName()
  {
    if (sApplicationContext == null)
    {
      Log.e("XWalkLib", "getPackageName sApplicationContext is null");
      return "";
    }
    return sApplicationContext.getPackageName();
  }
  
  public static String getPatchConfig(int paramInt)
  {
    return getPatchZipTempDecompressFilePath(paramInt, "patch.config");
  }
  
  public static String getPatchFileListConfig(int paramInt)
  {
    return getPatchZipTempDecompressFilePath(paramInt, "filelist.config");
  }
  
  public static String getPatchFileListConfig(Context paramContext, int paramInt)
  {
    return getPatchZipTempDecompressFilePath(paramContext, paramInt, "filelist.config");
  }
  
  public static String getPatchZipTempDecompressFilePath(int paramInt, String paramString)
  {
    String str = getVesionDir(paramInt) + File.separator + "patch_temp_decompress";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString;
  }
  
  public static String getPatchZipTempDecompressFilePath(Context paramContext, int paramInt, String paramString)
  {
    if (paramContext == null)
    {
      Log.e("XWalkLib", "getPatchZipTempDecompressFilePath with context, context is null");
      return "";
    }
    paramContext = getVesionDir(paramContext, paramInt);
    if (paramContext.isEmpty())
    {
      Log.e("XWalkLib", "getPatchZipTempDecompressFilePath with context, versionDir is empty");
      return "";
    }
    return paramContext + File.separator + "patch_temp_decompress" + File.separator + paramString;
  }
  
  public static String getPatchZipTempDecompressPath(int paramInt)
  {
    String str = getVesionDir(paramInt) + File.separator + "patch_temp_decompress";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static String getPluginBaseDir()
  {
    if (sApplicationContext == null) {
      return "";
    }
    return sApplicationContext.getDir("xwalkplugin", 0).getAbsolutePath();
  }
  
  public static String getPluginConfigUrl()
  {
    Object localObject = getSharedPreferencesForTestXWeb();
    if (localObject == null)
    {
      Log.e("XWalkLib", "getPluginConfigUrl sp is null, use default");
      return "http://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
    }
    localObject = ((SharedPreferences)localObject).getString("XWEB_PLUGIN_TEST_CONFIG_URL", "");
    if (!((String)localObject).trim().isEmpty())
    {
      addXWalkInitializeLog("plugin use test config url");
      Log.i("XWalkLib", "plugin use test config url: " + (String)localObject);
      return localObject;
    }
    addXWalkInitializeLog("plugin use release config url");
    Log.i("XWalkLib", "plugin use release config url: http://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml");
    return "http://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
  }
  
  public static String getPluginUpdateConfigFilePath()
  {
    if (sApplicationContext == null) {
      return "";
    }
    return getUpdateConfigDir() + File.separator + "pluginUpdateConfig.xml";
  }
  
  public static String getProcessName()
  {
    if (sStrCurentProcessName != null) {
      return sStrCurentProcessName;
    }
    Object localObject = getXWebInitArgs("processname");
    if (localObject != null)
    {
      localObject = localObject.toString();
      sStrCurentProcessName = (String)localObject;
      return localObject;
    }
    localObject = getApplicationContext();
    int i = android.os.Process.myPid();
    if (localObject == null) {
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
    return sStrCurentProcessName;
  }
  
  public static SharedPreferences getProcessSafePreferences(String paramString, int paramInt)
  {
    
    if (sSafePSProvider == null) {
      return sApplicationContext.getSharedPreferences(paramString, paramInt);
    }
    try
    {
      localObject = sSafePSProvider.invoke(null, new Object[] { sApplicationContext, paramString, Integer.valueOf(paramInt) });
      if ((localObject != null) && ((localObject instanceof SharedPreferences))) {
        break label71;
      }
      sSafePSProvider = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        label71:
        sSafePSProvider = null;
      }
    }
    return sApplicationContext.getSharedPreferences(paramString, paramInt);
    localObject = (SharedPreferences)localObject;
    return localObject;
  }
  
  public static String getRuntimeAbi()
  {
    int j = 0;
    String str;
    int i;
    if (sRuntimeAbi == null)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label233;
        }
        throw new NoSuchFieldError();
      }
      catch (NoSuchFieldError localNoSuchFieldError)
      {
        str = System.getProperty("os.arch").toLowerCase();
        switch (str.hashCode())
        {
        }
      }
      i = -1;
      switch (i)
      {
      default: 
        label146:
        throw new RuntimeException("Unexpected os.arch: " + str);
        label233:
        str = Build.CPU_ABI.toLowerCase();
        switch (str.hashCode())
        {
        }
        break;
      }
    }
    for (;;)
    {
      throw new RuntimeException("Unexpected CPU_ABI: " + str);
      if (str.equals("armeabi"))
      {
        i = 0;
        break label762;
        if (str.equals("armeabi-v7a"))
        {
          i = 1;
          break label762;
          if (str.equals("arm64-v8a"))
          {
            i = 2;
            break label762;
            if (str.equals("x86"))
            {
              i = 3;
              break label762;
              if (str.equals("x86_64"))
              {
                i = 4;
                break label762;
                sRuntimeAbi = "armeabi-v7a";
                label402:
                if (sRuntimeAbi.equals("armeabi-v7a")) {
                  if (!isIaDevice()) {}
                }
                for (sRuntimeAbi = "x86";; sRuntimeAbi = "x86_64") {
                  do
                  {
                    Log.d("XWalkLib", "Runtime ABI: " + sRuntimeAbi);
                    return sRuntimeAbi;
                    sRuntimeAbi = "arm64-v8a";
                    break label402;
                    sRuntimeAbi = "x86";
                    break label402;
                    sRuntimeAbi = "x86_64";
                    break label402;
                    if (!str.equals("x86")) {
                      break;
                    }
                    i = j;
                    break label146;
                    if (!str.equals("i686")) {
                      break;
                    }
                    i = 1;
                    break label146;
                    if (!str.equals("i386")) {
                      break;
                    }
                    i = 2;
                    break label146;
                    if (!str.equals("ia32")) {
                      break;
                    }
                    i = 3;
                    break label146;
                    if (!str.equals("x64")) {
                      break;
                    }
                    i = 4;
                    break label146;
                    if (!str.equals("x86_64")) {
                      break;
                    }
                    i = 5;
                    break label146;
                    if (!str.equals("armv7l")) {
                      break;
                    }
                    i = 6;
                    break label146;
                    if (!str.equals("armeabi")) {
                      break;
                    }
                    i = 7;
                    break label146;
                    if (!str.equals("armeabi-v7a")) {
                      break;
                    }
                    i = 8;
                    break label146;
                    if (!str.equals("aarch64")) {
                      break;
                    }
                    i = 9;
                    break label146;
                    if (!str.equals("armv8")) {
                      break;
                    }
                    i = 10;
                    break label146;
                    if (!str.equals("arm64")) {
                      break;
                    }
                    i = 11;
                    break label146;
                    sRuntimeAbi = "x86";
                    break label402;
                    if (is64bitDevice())
                    {
                      sRuntimeAbi = "x86_64";
                      break label402;
                    }
                    sRuntimeAbi = "x86";
                    break label402;
                    sRuntimeAbi = "armeabi-v7a";
                    break label402;
                    if (is64bitDevice())
                    {
                      sRuntimeAbi = "arm64-v8a";
                      break label402;
                    }
                    sRuntimeAbi = "armeabi-v7a";
                    break label402;
                  } while ((!sRuntimeAbi.equals("arm64-v8a")) || (!isIaDevice()));
                }
              }
            }
          }
        }
      }
      i = -1;
      label762:
      switch (i)
      {
      }
    }
  }
  
  public static SharedPreferences getSharedPreferences()
  {
    return sApplicationContext.getSharedPreferences("libxwalkcore", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForLog()
  {
    if (sApplicationContext == null) {
      return null;
    }
    return getProcessSafePreferences("UPDATELOG", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForPluginUpdateInfo()
  {
    if (sApplicationContext == null) {
      return null;
    }
    return getProcessSafePreferences("xwalk_plugin_update_info", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForPluginVersionInfo(String paramString)
  {
    if (sApplicationContext == null) {
      return null;
    }
    return getProcessSafePreferences("xwalk_plugin_version_info_" + paramString, 4);
  }
  
  public static SharedPreferences getSharedPreferencesForTestXWeb()
  {
    if (sApplicationContext == null)
    {
      Log.e("XWalkLib", "getSharedPreferencesForTestXWeb context is null");
      return null;
    }
    return sApplicationContext.getSharedPreferences("TESTXWEB", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForUpdateConfig()
  {
    return getProcessSafePreferences("UPDATEINFOTAG", 4);
  }
  
  public static SharedPreferences getSharedPreferencesForVersionInfo()
  {
    return sApplicationContext.getSharedPreferences("XWALKINFOS", 4);
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
    return paramContext.getSharedPreferences("TESTXWEB", 4).getString("XWEB_TEST_CONFIG_URL", "");
  }
  
  public static String getUpdateConfigDir()
  {
    return sApplicationContext.getDir("xwalkconfig", 0).getAbsolutePath();
  }
  
  static int getVerFromVersionName(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return 0;
    }
    String[] arrayOfString = paramString.split("\\.");
    try
    {
      int i = Integer.parseInt(arrayOfString[0]);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("XWalkLib", "parse to int error str is :" + paramString);
    }
    return 0;
  }
  
  public static String getVesionDir(int paramInt)
  {
    String str = sApplicationContext.getDir("xwalk_" + paramInt, 0).getAbsolutePath();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public static String getVesionDir(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      Log.e("XWalkLib", "getVersionDir with context, context is null");
      return "";
    }
    return paramContext.getDir("xwalk_" + paramInt, 0).getAbsolutePath();
  }
  
  public static String getXWalkInitializeLog()
  {
    SharedPreferences localSharedPreferences = getSharedPreferencesForLog();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("log", "");
  }
  
  public static String getXWalkUpdateConfigUrl()
  {
    String str;
    if (sXWalkDownConfigUrl == null)
    {
      str = getTestDownLoadUrl(getApplicationContext());
      sXWalkDownConfigUrl = str;
      if ((str == null) || (sXWalkDownConfigUrl.trim().isEmpty())) {
        break label59;
      }
      addXWalkInitializeLog("use test config url : " + sXWalkDownConfigUrl);
    }
    for (;;)
    {
      return sXWalkDownConfigUrl;
      label59:
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
    //   3: getstatic 882	org/xwalk/core/XWalkEnvironment:sXWebArgs	Ljava/util/HashMap;
    //   6: ifnull +15 -> 21
    //   9: getstatic 882	org/xwalk/core/XWalkEnvironment:sXWebArgs	Ljava/util/HashMap;
    //   12: aload_0
    //   13: invokevirtual 887	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +10 -> 28
    //   21: aconst_null
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: getstatic 882	org/xwalk/core/XWalkEnvironment:sXWebArgs	Ljava/util/HashMap;
    //   31: aload_0
    //   32: invokevirtual 890	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: astore_0
    //   36: goto -13 -> 23
    //   39: astore_0
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	paramString	String
    //   16	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	17	39	finally
    //   28	36	39	finally
  }
  
  /* Error */
  public static boolean getXWebInitArgs(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 728	org/xwalk/core/XWalkEnvironment:getXWebInitArgs	(Ljava/lang/String;)Ljava/lang/Object;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnonnull +8 -> 17
    //   12: ldc 2
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: invokevirtual 517	java/lang/Object:toString	()Ljava/lang/String;
    //   21: invokestatic 894	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   24: invokevirtual 897	java/lang/Boolean:booleanValue	()Z
    //   27: istore_2
    //   28: iload_2
    //   29: istore_1
    //   30: goto -18 -> 12
    //   33: astore_0
    //   34: ldc 86
    //   36: ldc_w 899
    //   39: invokestatic 262	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: goto -30 -> 12
    //   45: astore_0
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_0
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	paramString	String
    //   0	51	1	paramBoolean	boolean
    //   27	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   17	28	33	java/lang/Exception
    //   3	8	45	finally
    //   17	28	45	finally
    //   34	42	45	finally
  }
  
  public static boolean hasAvailableVersion()
  {
    return 49 <= getAvailableVersion();
  }
  
  public static boolean hasPluginTestConfigUrl()
  {
    SharedPreferences localSharedPreferences = getSharedPreferencesForTestXWeb();
    if (localSharedPreferences == null) {
      Log.e("XWalkLib", "hasPluginTestConfigUrl sp is null");
    }
    while (localSharedPreferences.getString("XWEB_PLUGIN_TEST_CONFIG_URL", "").trim().isEmpty()) {
      return false;
    }
    return true;
  }
  
  public static void init(Context paramContext)
  {
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
    k.im(paramContext);
  }
  
  static void initSafePsProvider()
  {
    if (sBHasInitedSafePsProvider) {
      return;
    }
    sBHasInitedSafePsProvider = true;
  }
  
  private static boolean initXWalkPlugins()
  {
    Boolean localBoolean = (Boolean)d.gS("com.tencent.xweb.xwalk.plugin.XWalkPluginManager", "initPlugins");
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return true;
    }
    addXWalkInitializeLog("XWalkLib", "initXWalkPlugins failed");
    return false;
  }
  
  public static boolean is64bitApp()
  {
    String str = getRuntimeAbi();
    return (str.equals("arm64-v8a")) || (str.equals("x86_64"));
  }
  
  public static boolean is64bitDevice()
  {
    String str = getDeviceAbi();
    return (str.equals("arm64-v8a")) || (str.equals("x86_64"));
  }
  
  public static boolean isCurrentVersionSupportExtendPluginForAppbrand()
  {
    return (hasAvailableVersion()) && (getAvailableVersion() >= 300);
  }
  
  public static boolean isDownloadMode()
  {
    return sIsDownloadMode.booleanValue();
  }
  
  public static boolean isDownloadModeUpdate()
  {
    return sIsDownloadModeUpdate.booleanValue();
  }
  
  public static boolean isForbidDownloadCode()
  {
    return sIsForbidDownloadCode;
  }
  
  public static boolean isIaDevice()
  {
    String str = getDeviceAbi();
    return (str.equals("x86")) || (str.equals("x86_64"));
  }
  
  public static boolean isInTestMode()
  {
    String str = getTestDownLoadUrl(getApplicationContext());
    return (str != null) && (!str.isEmpty());
  }
  
  public static boolean isProvider(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      Log.e("XWalkLib", "isProvider packageName is null or empty");
    }
    for (;;)
    {
      return false;
      String[] arrayOfString = XWALK_CORE_PROVIDER_LIST;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean isSelfProvider()
  {
    if (sApplicationContext == null)
    {
      Log.e("XWalkLib", "isSelfProvider sApplicationContext is null");
      return true;
    }
    return isProvider(sApplicationContext.getPackageName());
  }
  
  public static int readAvailableVersionFromSP(Context paramContext)
  {
    if (paramContext == null)
    {
      Log.e("XWalkLib", "readAvailableVersionFromSP context is null");
      return -1;
    }
    paramContext = paramContext.getSharedPreferences("XWALKINFOS", 4);
    if (paramContext == null)
    {
      Log.e("XWalkLib", "readAvailableVersionFromSP sp is null");
      return -1;
    }
    return paramContext.getInt("availableVersion", -1);
  }
  
  public static boolean setAvailableVersion(int paramInt, String paramString)
  {
    Log.i("XWalkLib", "setAvailableVersion:" + paramInt);
    SharedPreferences.Editor localEditor = getSharedPreferencesForVersionInfo().edit();
    localEditor.putInt("availableVersion", paramInt);
    localEditor.putString("versionDetail", paramString);
    boolean bool = localEditor.commit();
    addXWalkInitializeLog("XWalkLib", "set xwalk version to " + paramInt + " suc = " + bool);
    return bool;
  }
  
  public static void setGrayValueByUserId(int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      long l = paramInt;
      Object localObject = "xweb_gray_value" + (0xFFFFFFFF & l);
      try
      {
        localObject = MessageDigest.getInstance("MD5").digest(((String)localObject).getBytes());
        if ((localObject != null) && (localObject.length > 3))
        {
          paramInt = localObject[3];
          int i = localObject[2];
          int j = localObject[1];
          paramInt = (localObject[0] & 0x7F) << 24 | paramInt & 0xFF | (i & 0xFF) << 8 | (j & 0xFF) << 16;
          if (paramInt != 0) {
            s_grayValue = paramInt % 10000 + 1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          s_grayValue = 0;
        }
      }
    }
    getSharedPreferences().edit().putInt("GRAY_VALUE", s_grayValue).commit();
  }
  
  public static void setGrayValueForTest(int paramInt)
  {
    if (paramInt != 10001) {
      s_grayValue = paramInt % 10000;
    }
    getSharedPreferences().edit().putInt("TEST_GRAY_VALUE", s_grayValue).commit();
  }
  
  public static void setIsForbidDownloadCode(boolean paramBoolean)
  {
    sIsForbidDownloadCode = paramBoolean;
    addXWalkInitializeLog("XWalkLib", "setIsForbidDownloadCode: " + sIsForbidDownloadCode);
  }
  
  public static boolean setPluginTestConfigUrl(String paramString)
  {
    Object localObject = getSharedPreferencesForTestXWeb();
    if (localObject == null)
    {
      Log.e("XWalkLib", "setPluginTestConfigUrl sp is null");
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if ((paramString == null) || (paramString.trim().isEmpty())) {
      ((SharedPreferences.Editor)localObject).remove("XWEB_PLUGIN_TEST_CONFIG_URL");
    }
    for (;;)
    {
      return ((SharedPreferences.Editor)localObject).commit();
      ((SharedPreferences.Editor)localObject).putString("XWEB_PLUGIN_TEST_CONFIG_URL", paramString);
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
    sXWalkDownConfigUrl = null;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramContext.getSharedPreferences("TESTXWEB", 4).edit().putString("XWEB_TEST_CONFIG_URL", "").commit();
      getXWalkUpdateConfigUrl();
      return;
    }
    paramContext.getSharedPreferences("TESTXWEB", 4).edit().putString("XWEB_TEST_CONFIG_URL", paramString).commit();
    getXWalkUpdateConfigUrl();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.xwalk.core.XWalkEnvironment
 * JD-Core Version:    0.7.0.1
 */