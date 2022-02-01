package org.xwalk.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.aa;
import com.tencent.xweb.internal.WebViewWrapperFactory;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.j;
import com.tencent.xweb.xwalk.a.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class XWalkEnvironment
{
  public static final String LOCAL_TEST_ZIP_NAME = "runtime_package.zip";
  public static final int MULTI_PROCESS_TYPE_DISABLE = 0;
  public static final int MULTI_PROCESS_TYPE_RENDERER = 1;
  public static final int MULTI_PROCESS_TYPE_RENDERER_AND_GPU = 2;
  public static final String PINUS_SO_NAME = "libxwebcore.so";
  public static final String RUNTIME_ABI_ARM32_STR = "armeabi-v7a";
  public static final String RUNTIME_ABI_ARM64_STR = "arm64-v8a";
  public static final int SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION = 153;
  public static final int SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION = 255;
  public static final int SDK_SUPPORT_MIN_APKVERSION = 2000;
  public static final int SDK_VERSION = 20220105;
  public static final String SP_KEY_TEST_MUTI_PROCESS = "sMultiProcess";
  private static final String TAG = "XWalkEnvironment";
  public static final int TEST_APK_START_VERSION = 100000000;
  public static final String XWALK_ENV_MAP_KEY_DEVICE_MODEL = "deviceModel";
  public static final String XWALK_ENV_MAP_KEY_IS64ABI = "is64bitabi";
  public static final String XWALK_ENV_MAP_KEY_ISGPVERSION = "isgpversion";
  public static final String XWALK_ENV_MAP_KEY_PACKAGE_NAME = "packageName";
  public static final String XWALK_ENV_MAP_KEY_PROCESSNAME = "processname";
  public static final String XWALK_SO_NAME = "libxwalkcore.so";
  public static boolean isTurnOnKVLog;
  public static String java_crash_dump_path;
  private static int multiProcessType;
  public static String native_crash_dump_path;
  private static int sAppClientVersion;
  private static final Set<String> sAppInfos;
  private static Context sApplicationContext;
  private static int sForceDarkBehavior;
  private static boolean sHasInitedInterface;
  private static boolean sIsForceDarkMode;
  private static boolean sIsInited;
  private static boolean sIsPluginInited;
  private static String sLocaleString;
  private static String sPrivilegedServicesName;
  private static String sSandboxedServicesName;
  private static String sStrCurrentProcessName;
  private static boolean sUsingCustomContext;
  private static XWebCoreInfo sXWebCoreVersionInfo;
  private static ConcurrentMap<String, Object> sXWebInitArgs;
  
  static
  {
    AppMethodBeat.i(157334);
    sIsPluginInited = false;
    sIsInited = false;
    sAppClientVersion = 0;
    sUsingCustomContext = false;
    sIsForceDarkMode = false;
    sForceDarkBehavior = 2;
    isTurnOnKVLog = false;
    sHasInitedInterface = false;
    sAppInfos = new HashSet();
    multiProcessType = 0;
    AppMethodBeat.o(157334);
  }
  
  public static void addXWalkInitializeLog(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157261);
    XWalkInitializeLog.addXWalkInitializeLog(paramString1, paramString2);
    AppMethodBeat.o(157261);
  }
  
  @Deprecated
  public static void appendAppInfo(String paramString)
  {
    try
    {
      AppMethodBeat.i(187712);
      sAppInfos.add(paramString);
      AppMethodBeat.o(187712);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean containsAppInfo(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(187731);
        paramString = paramString.split("&");
        if ((paramString == null) || (paramString.length == 0))
        {
          AppMethodBeat.o(187731);
          bool = true;
          return bool;
        }
        int j = paramString.length;
        int i = 0;
        if (i >= j) {
          break label98;
        }
        CharSequence localCharSequence = paramString[i];
        if ((!TextUtils.isEmpty(localCharSequence)) && (!sAppInfos.contains(localCharSequence.trim())))
        {
          AppMethodBeat.o(187731);
          continue;
        }
        i += 1;
      }
      finally {}
      continue;
      label98:
      AppMethodBeat.o(187731);
      bool = true;
    }
  }
  
  public static String dumpAppInfo()
  {
    AppMethodBeat.i(187721);
    String str = TextUtils.join(";", sAppInfos);
    AppMethodBeat.o(187721);
    return str;
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
  
  @Deprecated
  public static Context getApplicationContext()
  {
    return sApplicationContext;
  }
  
  @Deprecated
  public static int getAvailableVersion()
  {
    if (sXWebCoreVersionInfo == null) {
      return -1;
    }
    return sXWebCoreVersionInfo.ver;
  }
  
  public static String getAvailableVersionDetail()
  {
    if (sXWebCoreVersionInfo != null) {
      return sXWebCoreVersionInfo.verDetail;
    }
    return "";
  }
  
  @Deprecated
  public static ContentResolver getContentResolver()
  {
    AppMethodBeat.i(157320);
    if (sApplicationContext == null)
    {
      Log.e("XWalkEnvironment", "getContentResolver, sApplicationContext is null");
      AppMethodBeat.o(157320);
      return null;
    }
    ContentResolver localContentResolver = sApplicationContext.getContentResolver();
    AppMethodBeat.o(157320);
    return localContentResolver;
  }
  
  private static boolean getFeatureSupport(int paramInt)
  {
    AppMethodBeat.i(157253);
    WebViewWrapperFactory.IWebViewProvider localIWebViewProvider = getWebViewProvider();
    if (localIWebViewProvider != null)
    {
      boolean bool = ((Boolean)localIWebViewProvider.excute("STR_CMD_FEATURE_SUPPORT", new Object[] { Integer.valueOf(paramInt) })).booleanValue();
      AppMethodBeat.o(157253);
      return bool;
    }
    AppMethodBeat.o(157253);
    return false;
  }
  
  public static int getForceDarkBehavior()
  {
    return sForceDarkBehavior;
  }
  
  public static boolean getForceDarkMode()
  {
    return sIsForceDarkMode;
  }
  
  @Deprecated
  public static int getInstalledNewstVersion(Context paramContext)
  {
    AppMethodBeat.i(157257);
    int i = XWebCoreInfo.getInstalledNewestVersionForCurAbi(paramContext);
    AppMethodBeat.o(157257);
    return i;
  }
  
  public static int getInstalledNewstVersion(String paramString)
  {
    AppMethodBeat.i(157255);
    int i = XWebCoreInfo.getVersionInfoForAbi(paramString).ver;
    AppMethodBeat.o(157255);
    return i;
  }
  
  public static int getInstalledNewstVersionForCurAbi()
  {
    AppMethodBeat.i(157256);
    int i = getInstalledNewstVersion(b.khw());
    AppMethodBeat.o(157256);
    return i;
  }
  
  public static int getInstalledNewstVersionForPredownAbi()
  {
    AppMethodBeat.i(187684);
    String str2 = b.khw();
    String str1 = "armeabi-v7a";
    if ("armeabi-v7a".equalsIgnoreCase(str2)) {
      str1 = "arm64-v8a";
    }
    int i = getInstalledNewstVersion(str1);
    AppMethodBeat.o(187684);
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
    paramContext = XWalkSharedPreferenceUtil.getSharedPreferencesForPluginVersionInfo(paramString);
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
  
  public static Locale getLocale()
  {
    AppMethodBeat.i(187804);
    if ((sLocaleString != null) && (!sLocaleString.isEmpty()))
    {
      Locale localLocale = Locale.forLanguageTag(sLocaleString);
      AppMethodBeat.o(187804);
      return localLocale;
    }
    AppMethodBeat.o(187804);
    return null;
  }
  
  public static String getLocaleString()
  {
    return sLocaleString;
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
  
  public static int getMultiProcessType()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(187993);
        if (Build.VERSION.SDK_INT < 26)
        {
          Log.i("XWalkEnvironment", "getMultiProcessType, disable because android version below Build.VERSION_CODES.O");
          AppMethodBeat.o(187993);
          return i;
        }
        int j = XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().getInt("sMultiProcess", -1);
        if ((j >= 0) && (j <= 2))
        {
          Log.i("XWalkEnvironment", "getMultiProcessType, testType:".concat(String.valueOf(j)));
          AppMethodBeat.o(187993);
          i = j;
          continue;
        }
        if ((multiProcessType >= 0) && (multiProcessType <= 2))
        {
          Log.i("XWalkEnvironment", "getMultiProcessType, multiProcessType:" + multiProcessType);
          i = multiProcessType;
          AppMethodBeat.o(187993);
          continue;
        }
        Log.w("XWalkEnvironment", "getMultiProcessType, MULTI_PROCESS_TYPE_DISABLE");
      }
      finally {}
      AppMethodBeat.o(187993);
    }
  }
  
  public static String getPackageName()
  {
    AppMethodBeat.i(157324);
    if (sApplicationContext == null)
    {
      Log.e("XWalkEnvironment", "getPackageName, sApplicationContext is null");
      AppMethodBeat.o(157324);
      return "";
    }
    String str = sApplicationContext.getPackageName();
    AppMethodBeat.o(157324);
    return str;
  }
  
  public static String getPrivilegedServicesName()
  {
    return sPrivilegedServicesName;
  }
  
  public static String getProcessName()
  {
    AppMethodBeat.i(157319);
    if (!TextUtils.isEmpty(sStrCurrentProcessName))
    {
      localObject = sStrCurrentProcessName;
      AppMethodBeat.o(157319);
      return localObject;
    }
    Object localObject = getXWebInitArgs("processname");
    if (localObject != null)
    {
      localObject = localObject.toString();
      sStrCurrentProcessName = (String)localObject;
      AppMethodBeat.o(157319);
      return localObject;
    }
    getApplicationContext();
    localObject = j.khD();
    sStrCurrentProcessName = (String)localObject;
    AppMethodBeat.o(157319);
    return localObject;
  }
  
  public static String getSafeModuleName(String paramString)
  {
    AppMethodBeat.i(187891);
    try
    {
      String str = getModuleName();
      if (("tools".equalsIgnoreCase(str)) || ("toolsmp".equalsIgnoreCase(str)) || ("mm".equalsIgnoreCase(str)) || ("support".equalsIgnoreCase(str)))
      {
        Log.i("XWalkEnvironment", "getSafeModuleName, module = ".concat(String.valueOf(str)));
        AppMethodBeat.o(187891);
        return str;
      }
      if (str.startsWith("appbrand"))
      {
        Log.i("XWalkEnvironment", "getSafeModuleName, module = appbrand");
        AppMethodBeat.o(187891);
        return "appbrand";
      }
      return paramString;
    }
    finally
    {
      Log.e("XWalkEnvironment", "getSafeModuleName, use defaultVal:" + paramString + ", error:" + localObject);
      AppMethodBeat.o(187891);
    }
    return paramString;
  }
  
  public static String getSandboxedServicesName()
  {
    return sSandboxedServicesName;
  }
  
  @Deprecated
  public static boolean getUsingCustomContext()
  {
    AppMethodBeat.i(187766);
    if (isCurrentSupportCustomContext())
    {
      boolean bool = getUsingCustomContextInternal();
      AppMethodBeat.o(187766);
      return bool;
    }
    AppMethodBeat.o(187766);
    return false;
  }
  
  public static boolean getUsingCustomContextInternal()
  {
    return sUsingCustomContext;
  }
  
  public static WebView.WebViewKind getWebViewKindFromAvailableVersion()
  {
    AppMethodBeat.i(187916);
    WebView.WebViewKind localWebViewKind = getWebViewKindFromVersion(getAvailableVersion());
    AppMethodBeat.o(187916);
    return localWebViewKind;
  }
  
  public static WebView.WebViewKind getWebViewKindFromVersion(int paramInt)
  {
    AppMethodBeat.i(187928);
    if (!sIsInited)
    {
      Log.w("XWalkEnvironment", "getWebViewKindFromVersion, not init yet, version:".concat(String.valueOf(paramInt)));
      localWebViewKind = WebView.WebViewKind.aifH;
      AppMethodBeat.o(187928);
      return localWebViewKind;
    }
    if (XWalkFileUtil.isExtractedCoreDirFileExist(paramInt, "libxwebcore.so"))
    {
      Log.w("XWalkEnvironment", "getWebViewKindFromVersion, pinus webview core version:".concat(String.valueOf(paramInt)));
      localWebViewKind = WebView.WebViewKind.aifL;
      AppMethodBeat.o(187928);
      return localWebViewKind;
    }
    if (XWalkFileUtil.isExtractedCoreDirFileExist(paramInt, "libxwalkcore.so"))
    {
      Log.w("XWalkEnvironment", "getWebViewKindFromVersion, xwalk webview core version:".concat(String.valueOf(paramInt)));
      localWebViewKind = WebView.WebViewKind.aifI;
      AppMethodBeat.o(187928);
      return localWebViewKind;
    }
    Log.w("XWalkEnvironment", "getWebViewKindFromVersion, version:" + paramInt + ", no xwalk or pinus so file exist");
    WebView.WebViewKind localWebViewKind = WebView.WebViewKind.aifH;
    AppMethodBeat.o(187928);
    return localWebViewKind;
  }
  
  private static WebViewWrapperFactory.IWebViewProvider getWebViewProvider()
  {
    AppMethodBeat.i(187938);
    WebViewWrapperFactory.IWebViewProvider localIWebViewProvider = WebViewWrapperFactory.e(getWebViewKindFromAvailableVersion());
    AppMethodBeat.o(187938);
    return localIWebViewProvider;
  }
  
  public static Object getXWebInitArgs(String paramString)
  {
    AppMethodBeat.i(157229);
    if ((sXWebInitArgs == null) || (!sXWebInitArgs.containsKey(paramString)))
    {
      AppMethodBeat.o(157229);
      return null;
    }
    paramString = sXWebInitArgs.get(paramString);
    AppMethodBeat.o(157229);
    return paramString;
  }
  
  public static boolean getXWebInitArgs(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(157230);
    Object localObject1 = getXWebInitArgs(paramString);
    if (localObject1 == null)
    {
      AppMethodBeat.o(157230);
      return paramBoolean;
    }
    try
    {
      boolean bool = Boolean.parseBoolean(localObject1.toString());
      AppMethodBeat.o(157230);
      return bool;
    }
    finally
    {
      Log.e("XWalkEnvironment", "getXWebInitArgs, key:" + paramString + ", defaultValue:" + paramBoolean + " error:" + localObject2);
      AppMethodBeat.o(157230);
    }
    return paramBoolean;
  }
  
  public static boolean hasAvailableVersion()
  {
    AppMethodBeat.i(157254);
    if (2000 <= getAvailableVersion())
    {
      AppMethodBeat.o(157254);
      return true;
    }
    AppMethodBeat.o(157254);
    return false;
  }
  
  public static boolean hasInstalledAvailableVersion()
  {
    AppMethodBeat.i(187675);
    if (2000 <= getInstalledNewstVersionForCurAbi())
    {
      AppMethodBeat.o(187675);
      return true;
    }
    AppMethodBeat.o(187675);
    return false;
  }
  
  public static void init(Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(157224);
        if (paramContext == null)
        {
          Log.w("XWalkEnvironment", "init, invalid context");
          AppMethodBeat.o(157224);
          return;
        }
        if (sApplicationContext != null)
        {
          Log.w("XWalkEnvironment", "init, already init");
          AppMethodBeat.o(157224);
          continue;
        }
        Log.w("XWalkEnvironment", "init start, sdkVersion:20220105, stack:" + android.util.Log.getStackTraceString(new Exception("please ignore this exception")));
      }
      finally {}
      sIsInited = true;
      sApplicationContext = paramContext.getApplicationContext();
      sXWebCoreVersionInfo = initCoreVersionInfo();
      Log.i("XWalkEnvironment", "init, coreInfo:" + sXWebCoreVersionInfo);
      if (!sIsPluginInited) {
        sIsPluginInited = i.kjB();
      }
      aa.oP(paramContext);
      isTurnOnKVLog();
      initProcessServices();
      Log.w("XWalkEnvironment", "init end");
      AppMethodBeat.o(157224);
    }
  }
  
  private static XWebCoreInfo initCoreVersionInfo()
  {
    AppMethodBeat.i(187605);
    String str = b.khw();
    Object localObject2 = XWebCoreInfo.getVersionInfoForAbi(str);
    Object localObject1 = localObject2;
    if (((XWebCoreInfo)localObject2).ver > 0)
    {
      localObject1 = localObject2;
      if (!XWalkFileUtil.isDownloadApkFileExist(((XWebCoreInfo)localObject2).ver))
      {
        Log.i("XWalkEnvironment", "initCoreVersionInfo, no apk in version(" + ((XWebCoreInfo)localObject2).ver + ") dir");
        localObject1 = new XWebCoreInfo(-1, null, str);
        XWebCoreInfo.setVersionInfo((XWebCoreInfo)localObject1);
      }
    }
    if (((XWebCoreInfo)localObject1).ver <= 0)
    {
      if (!XWalkSharedPreferenceUtil.getSharedPreferencesForVersionInfo().getBoolean("transported_version", false))
      {
        int i = XWalkSharedPreferenceUtil.getSharedPreferencesForVersionInfo().getInt("availableVersion", -1);
        localObject2 = XWalkSharedPreferenceUtil.getSharedPreferencesForVersionInfo().getString("versionDetail", "");
        Log.i("XWalkEnvironment", "initCoreVersionInfo, transport version:" + i + ", versionDetail:" + (String)localObject2);
        ((XWebCoreInfo)localObject1).strAbi = str;
        ((XWebCoreInfo)localObject1).ver = i;
        ((XWebCoreInfo)localObject1).verDetail = ((String)localObject2);
      }
      if (XWebCoreInfo.setVersionInfo((XWebCoreInfo)localObject1)) {
        XWalkSharedPreferenceUtil.getSharedPreferencesForVersionInfo().edit().putBoolean("transported_version", true).commit();
      }
    }
    AppMethodBeat.o(187605);
    return localObject1;
  }
  
  /* Error */
  public static void initInterface()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 610
    //   6: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 114	org/xwalk/core/XWalkEnvironment:sHasInitedInterface	Z
    //   12: ifeq +13 -> 25
    //   15: ldc_w 610
    //   18: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: ldc 43
    //   27: ldc_w 611
    //   30: invokestatic 334	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: getstatic 471	com/tencent/xweb/WebView$WebViewKind:aifI	Lcom/tencent/xweb/WebView$WebViewKind;
    //   36: invokestatic 483	com/tencent/xweb/internal/WebViewWrapperFactory:e	(Lcom/tencent/xweb/WebView$WebViewKind;)Lcom/tencent/xweb/internal/WebViewWrapperFactory$IWebViewProvider;
    //   39: astore_0
    //   40: aload_0
    //   41: ifnull +9 -> 50
    //   44: aload_0
    //   45: invokeinterface 613 1 0
    //   50: getstatic 466	com/tencent/xweb/WebView$WebViewKind:aifL	Lcom/tencent/xweb/WebView$WebViewKind;
    //   53: invokestatic 483	com/tencent/xweb/internal/WebViewWrapperFactory:e	(Lcom/tencent/xweb/WebView$WebViewKind;)Lcom/tencent/xweb/internal/WebViewWrapperFactory$IWebViewProvider;
    //   56: astore_0
    //   57: aload_0
    //   58: ifnull +9 -> 67
    //   61: aload_0
    //   62: invokeinterface 613 1 0
    //   67: getstatic 616	com/tencent/xweb/WebView$WebViewKind:aifJ	Lcom/tencent/xweb/WebView$WebViewKind;
    //   70: invokestatic 483	com/tencent/xweb/internal/WebViewWrapperFactory:e	(Lcom/tencent/xweb/WebView$WebViewKind;)Lcom/tencent/xweb/internal/WebViewWrapperFactory$IWebViewProvider;
    //   73: astore_0
    //   74: aload_0
    //   75: ifnull +9 -> 84
    //   78: aload_0
    //   79: invokeinterface 613 1 0
    //   84: iconst_1
    //   85: putstatic 114	org/xwalk/core/XWalkEnvironment:sHasInitedInterface	Z
    //   88: ldc_w 610
    //   91: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: goto -73 -> 21
    //   97: astore_0
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_0
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	40	0	localIWebViewProvider	WebViewWrapperFactory.IWebViewProvider
    //   97	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	21	97	finally
    //   25	40	97	finally
    //   44	50	97	finally
    //   50	57	97	finally
    //   61	67	97	finally
    //   67	74	97	finally
    //   78	84	97	finally
    //   84	94	97	finally
  }
  
  private static void initProcessServices()
  {
    AppMethodBeat.i(187906);
    setServicesName("com.tencent.xweb.pinus.sdk.process.PrivilegedProcessService", "com.tencent.xweb.pinus.sdk.process.SandboxedProcessService");
    AppMethodBeat.o(187906);
  }
  
  @Deprecated
  public static boolean isCurrentSupportCustomContext()
  {
    AppMethodBeat.i(187770);
    if ((WebView.getCurWebType() == WebView.WebViewKind.aifI) || (WebView.getCurWebType() == WebView.WebViewKind.aifL))
    {
      boolean bool = isCurrentVersionSupportCustomContext();
      AppMethodBeat.o(187770);
      return bool;
    }
    AppMethodBeat.o(187770);
    return false;
  }
  
  public static boolean isCurrentVersionSupportContentHeightChange()
  {
    AppMethodBeat.i(187658);
    if ((hasAvailableVersion()) && (getFeatureSupport(2014)))
    {
      AppMethodBeat.o(187658);
      return true;
    }
    AppMethodBeat.o(187658);
    return false;
  }
  
  @Deprecated
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
  
  public static boolean isCurrentVersionSupportCustomInputForAppbrand()
  {
    AppMethodBeat.i(187645);
    if ((hasAvailableVersion()) && (getFeatureSupport(1041)))
    {
      AppMethodBeat.o(187645);
      return true;
    }
    AppMethodBeat.o(187645);
    return false;
  }
  
  @Deprecated
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
  
  @Deprecated
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
  
  @Deprecated
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
  
  @Deprecated
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
  
  public static boolean isCurrentVersionSupportSetWebContentsSize()
  {
    AppMethodBeat.i(187649);
    if ((hasAvailableVersion()) && (getFeatureSupport(1042)))
    {
      AppMethodBeat.o(187649);
      return true;
    }
    AppMethodBeat.o(187649);
    return false;
  }
  
  public static boolean isInTestMode()
  {
    AppMethodBeat.i(157281);
    String str = XWalkUpdateConfigUtil.getTestBaseConfigUrl(getApplicationContext());
    if ((str != null) && (!str.isEmpty()))
    {
      AppMethodBeat.o(157281);
      return true;
    }
    AppMethodBeat.o(157281);
    return false;
  }
  
  public static boolean isPinusWebViewCoreFromAvailableVersion()
  {
    AppMethodBeat.i(187946);
    if (getWebViewKindFromAvailableVersion() == WebView.WebViewKind.aifL)
    {
      AppMethodBeat.o(187946);
      return true;
    }
    AppMethodBeat.o(187946);
    return false;
  }
  
  public static boolean isTestVersion(int paramInt)
  {
    return paramInt >= 100000000;
  }
  
  public static void isTurnOnKVLog()
  {
    AppMethodBeat.i(187613);
    try
    {
      aa.kfE();
      isTurnOnKVLog = aa.kfI();
      AppMethodBeat.o(187613);
      return;
    }
    finally
    {
      Log.e("XWalkEnvironment", "isTurnOnKVLog error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(187613);
    }
  }
  
  public static void refreshVersionInfo()
  {
    AppMethodBeat.i(187706);
    sXWebCoreVersionInfo = XWebCoreInfo.getVersionInfoForAbi(b.khw());
    AppMethodBeat.o(187706);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(187610);
    Log.i("XWalkEnvironment", "reset");
    sApplicationContext = null;
    sXWebCoreVersionInfo = null;
    sIsPluginInited = false;
    sIsInited = false;
    AppMethodBeat.o(187610);
  }
  
  @Deprecated
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
  
  public static boolean setCoreVersionInfo(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(187702);
    boolean bool = XWebCoreInfo.setVersionInfo(paramInt, paramString1, paramString2);
    AppMethodBeat.o(187702);
    return bool;
  }
  
  @Deprecated
  public static void setForceDarkBehavior(ForceDarkBehavior paramForceDarkBehavior)
  {
    AppMethodBeat.i(157251);
    switch (1.$SwitchMap$org$xwalk$core$XWalkEnvironment$ForceDarkBehavior[paramForceDarkBehavior.ordinal()])
    {
    }
    for (;;)
    {
      Log.i("XWalkEnvironment", "setForceDarkBehavior, forceDarkBehavior:".concat(String.valueOf(paramForceDarkBehavior)));
      paramForceDarkBehavior = getWebViewProvider();
      if (paramForceDarkBehavior != null) {
        paramForceDarkBehavior.excute("STR_CMD_FORCE_DARK_MODE_BEHAVIOR_COMMAND", new Object[] { Integer.valueOf(sForceDarkBehavior) });
      }
      AppMethodBeat.o(157251);
      return;
      sForceDarkBehavior = 0;
      continue;
      sForceDarkBehavior = 1;
      continue;
      sForceDarkBehavior = 2;
    }
  }
  
  @Deprecated
  public static void setForceDarkMode(boolean paramBoolean)
  {
    AppMethodBeat.i(157250);
    sIsForceDarkMode = paramBoolean;
    Log.i("XWalkEnvironment", "setForceDarkMode, forceDarkMode:".concat(String.valueOf(paramBoolean)));
    WebViewWrapperFactory.IWebViewProvider localIWebViewProvider = getWebViewProvider();
    if (localIWebViewProvider != null) {
      localIWebViewProvider.excute("STR_CMD_FORCE_DARK_MODE_COMMAND", new Object[] { Boolean.valueOf(sIsForceDarkMode) });
    }
    AppMethodBeat.o(157250);
  }
  
  public static void setLocale(Locale paramLocale)
  {
    AppMethodBeat.i(187821);
    if (paramLocale != null)
    {
      Log.i("XWalkEnvironment", "setLocale, customize locale:" + paramLocale.toLanguageTag());
      setLocaleString(paramLocale.toLanguageTag());
      AppMethodBeat.o(187821);
      return;
    }
    Log.w("XWalkEnvironment", "setLocale, customize locale not set");
    AppMethodBeat.o(187821);
  }
  
  private static void setLocaleString(String paramString)
  {
    sLocaleString = paramString;
  }
  
  @Deprecated
  public static void setMultiProcessType(int paramInt)
  {
    try
    {
      AppMethodBeat.i(187982);
      Log.w("XWalkEnvironment", "setMultiProcessType, multiProcessType:".concat(String.valueOf(paramInt)));
      multiProcessType = paramInt;
      AppMethodBeat.o(187982);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public static void setSandBoxProcessCrashDumpPath(String paramString1, String paramString2)
  {
    java_crash_dump_path = paramString1;
    native_crash_dump_path = paramString2;
  }
  
  private static void setServicesName(String paramString1, String paramString2)
  {
    sPrivilegedServicesName = paramString1;
    sSandboxedServicesName = paramString2;
  }
  
  public static void setTestMultiProcessType(int paramInt)
  {
    try
    {
      AppMethodBeat.i(187971);
      XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().edit().putInt("sMultiProcess", paramInt).commit();
      AppMethodBeat.o(187971);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public static void setUsingCustomContext(boolean paramBoolean)
  {
    AppMethodBeat.i(157252);
    sUsingCustomContext = paramBoolean;
    Log.i("XWalkEnvironment", "setUsingCustomContext, usingCustomContext:".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(157252);
  }
  
  @Deprecated
  public static void setXWebInitArgs(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(187739);
    if (sXWebInitArgs == null) {
      sXWebInitArgs = new ConcurrentHashMap();
    }
    for (;;)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        sXWebInitArgs.put((String)localEntry.getKey(), localEntry.getValue());
      }
      sXWebInitArgs.clear();
    }
    AppMethodBeat.o(187739);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkEnvironment
 * JD-Core Version:    0.7.0.1
 */