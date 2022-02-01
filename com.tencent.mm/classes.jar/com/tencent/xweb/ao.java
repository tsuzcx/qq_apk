package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;
import com.tencent.xweb.downloader.a;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.WebViewWrapperFactory;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.util.l;
import java.util.HashMap;
import java.util.Locale;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkEnvironment.ForceDarkBehavior;
import org.xwalk.core.XWalkGrayValueUtil;
import org.xwalk.core.XWalkSharedPreferenceUtil;
import org.xwalk.core.XWalkUpdateConfigUtil;

public final class ao
  extends ap
{
  public static void OT(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(212576);
      ak.OT(paramBoolean);
      AppMethodBeat.o(212576);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void OU(boolean paramBoolean)
  {
    AppMethodBeat.i(212711);
    try
    {
      Context localContext = XWalkEnvironment.getApplicationContext();
      if (localContext == null)
      {
        Log.w("XWebSdkInternal", "clearAllWebViewCache, invalid context");
        AppMethodBeat.o(212711);
        return;
      }
      WebViewWrapperFactory.IWebViewProvider localIWebViewProvider = WebViewWrapperFactory.e(WebView.getCurWebType());
      if (localIWebViewProvider != null) {
        localIWebViewProvider.clearAllWebViewCache(localContext, paramBoolean);
      }
      AppMethodBeat.o(212711);
      return;
    }
    finally
    {
      Log.e("XWebSdkInternal", "clearAllWebViewCache, error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(212711);
    }
  }
  
  public static void a(Context paramContext, IXWebLogClient paramIXWebLogClient)
  {
    try
    {
      AppMethodBeat.i(212445);
      b(paramContext, paramIXWebLogClient);
      AppMethodBeat.o(212445);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(Context paramContext, String paramString, WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(212702);
    b(paramContext, paramString, paramWebViewKind);
    AppMethodBeat.o(212702);
  }
  
  public static void a(Context paramContext, Locale paramLocale, IXWebLogClient paramIXWebLogClient, ISharedPreferenceProvider paramISharedPreferenceProvider, aj paramaj, WebViewExtensionListener paramWebViewExtensionListener)
  {
    try
    {
      AppMethodBeat.i(212460);
      b(paramContext, paramLocale, paramIXWebLogClient, paramISharedPreferenceProvider, paramaj, paramWebViewExtensionListener);
      AppMethodBeat.o(212460);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(212656);
    WXFileDownloaderBridge.a(parama);
    AppMethodBeat.o(212656);
  }
  
  public static void a(r.a parama)
  {
    r.aieT = parama;
  }
  
  public static void a(com.tencent.xweb.xwalk.c paramc)
  {
    AppMethodBeat.i(212727);
    b(paramc);
    AppMethodBeat.o(212727);
  }
  
  public static boolean aJA(int paramInt)
  {
    AppMethodBeat.i(212504);
    int i = ap.kgt();
    if (paramInt != i)
    {
      XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().edit().putInt("IP_TYPE", paramInt).commit();
      Log.i("XWebSdkInternal", "setIpType, ip type changed from " + i + " to " + paramInt);
      if ((i == 0) && (paramInt == 1)) {
        l.Br(197L);
      }
      while ((i > 0) || (paramInt > 0))
      {
        l.y(1749L, 28L, 1L);
        AppMethodBeat.o(212504);
        return true;
        if ((i == 1) && (paramInt == 0)) {
          l.Br(198L);
        }
      }
    }
    AppMethodBeat.o(212504);
    return false;
  }
  
  public static boolean aJB(int paramInt)
  {
    AppMethodBeat.i(212707);
    boolean bool = aJC(paramInt);
    AppMethodBeat.o(212707);
    return bool;
  }
  
  public static void appendAppInfo(String paramString)
  {
    AppMethodBeat.i(212509);
    XWalkEnvironment.appendAppInfo(paramString);
    AppMethodBeat.o(212509);
  }
  
  private static void b(Context paramContext, IXWebLogClient paramIXWebLogClient)
  {
    try
    {
      AppMethodBeat.i(212450);
      c(paramContext, paramIXWebLogClient);
      AppMethodBeat.o(212450);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(212570);
    y.b(paramContext, paramHashMap);
    AppMethodBeat.o(212570);
  }
  
  public static boolean bHC(String paramString)
  {
    AppMethodBeat.i(212687);
    boolean bool = v.bHC(paramString);
    AppMethodBeat.o(212687);
    return bool;
  }
  
  public static boolean bHD(String paramString)
  {
    AppMethodBeat.i(212690);
    boolean bool = v.bHD(paramString);
    AppMethodBeat.o(212690);
    return bool;
  }
  
  public static void bHM(String paramString)
  {
    AppMethodBeat.i(212705);
    if (!WebView.isXWalk())
    {
      Log.w("XWebSdkInternal", "setAppBrandId, not xweb now");
      AppMethodBeat.o(212705);
      return;
    }
    try
    {
      WebViewWrapperFactory.IWebViewProvider localIWebViewProvider = WebViewWrapperFactory.e(WebView.getCurWebType());
      if (localIWebViewProvider != null) {
        localIWebViewProvider.excute("STR_CMD_INVOKE_TO_RUNTIME", new Object[] { Integer.valueOf(90001), { paramString } });
      }
      AppMethodBeat.o(212705);
      return;
    }
    finally
    {
      Log.e("XWebSdkInternal", "setAppBrandId, error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(212705);
    }
  }
  
  public static void bindNativeTrans(long paramLong)
  {
    AppMethodBeat.i(212715);
    if (!WebView.isXWalk())
    {
      Log.w("XWebSdkInternal", "bindNativeTrans, not xweb now");
      AppMethodBeat.o(212715);
      return;
    }
    try
    {
      WebViewWrapperFactory.IWebViewProvider localIWebViewProvider = WebViewWrapperFactory.e(WebView.getCurWebType());
      if (localIWebViewProvider != null) {
        localIWebViewProvider.excute("STR_CMD_NATIVE_TRANS_INIT", new Object[] { Long.valueOf(paramLong) });
      }
      AppMethodBeat.o(212715);
      return;
    }
    finally
    {
      Log.e("XWebSdkInternal", "bindNativeTrans, error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(212715);
    }
  }
  
  private static void c(Context paramContext, IXWebLogClient paramIXWebLogClient)
  {
    try
    {
      AppMethodBeat.i(212456);
      a(paramContext, null, paramIXWebLogClient, null, null, null);
      AppMethodBeat.o(212456);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(212684);
    ae.kfW().deleteOrigin(paramString);
    AppMethodBeat.o(212684);
  }
  
  public static void g(WebView paramWebView)
  {
    AppMethodBeat.i(212672);
    c.kfo().g(paramWebView);
    AppMethodBeat.o(212672);
  }
  
  public static int getAvailableVersion()
  {
    AppMethodBeat.i(212480);
    int i = XWalkEnvironment.getAvailableVersion();
    AppMethodBeat.o(212480);
    return i;
  }
  
  public static boolean getCanReboot()
  {
    AppMethodBeat.i(212615);
    boolean bool = WebView.getCanReboot();
    AppMethodBeat.o(212615);
    return bool;
  }
  
  public static String getCookie(String paramString)
  {
    AppMethodBeat.i(212662);
    c localc = c.kfo();
    if (localc.aien != null)
    {
      paramString = localc.aien.getCookie(paramString);
      AppMethodBeat.o(212662);
      return paramString;
    }
    AppMethodBeat.o(212662);
    return null;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    AppMethodBeat.i(212628);
    paramContext = WebView.getCrashExtraMessage(paramContext);
    AppMethodBeat.o(212628);
    return paramContext;
  }
  
  public static int getInstalledNewstVersion(Context paramContext)
  {
    AppMethodBeat.i(212472);
    int i = XWalkEnvironment.getInstalledNewstVersion(paramContext);
    AppMethodBeat.o(212472);
    return i;
  }
  
  public static int getInstalledTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(212641);
    int i = WebView.getInstalledTbsCoreVersion(paramContext);
    AppMethodBeat.o(212641);
    return i;
  }
  
  public static SharedPreferences getSharedPreferencesForUpdateConfig()
  {
    AppMethodBeat.i(212551);
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForUpdateConfig();
    AppMethodBeat.o(212551);
    return localSharedPreferences;
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    AppMethodBeat.i(212631);
    int i = WebView.getTbsSDKVersion(paramContext);
    AppMethodBeat.o(212631);
    return i;
  }
  
  public static boolean getUsingCustomContext()
  {
    AppMethodBeat.i(212536);
    boolean bool = XWalkEnvironment.getUsingCustomContext();
    AppMethodBeat.o(212536);
    return bool;
  }
  
  public static int getUsingTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(212637);
    int i = WebView.getUsingTbsCoreVersion(paramContext);
    AppMethodBeat.o(212637);
    return i;
  }
  
  public static void initWebviewCore(Context paramContext, WebView.WebViewKind paramWebViewKind, String paramString, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(212609);
    WebView.initWebviewCore(paramContext, paramWebViewKind, paramString, paramPreInitCallback);
    AppMethodBeat.o(212609);
  }
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(212574);
    boolean bool = y.isBusy();
    AppMethodBeat.o(212574);
    return bool;
  }
  
  public static boolean isCurrentSupportCustomContext()
  {
    AppMethodBeat.i(212539);
    boolean bool = XWalkEnvironment.isCurrentSupportCustomContext();
    AppMethodBeat.o(212539);
    return bool;
  }
  
  public static boolean isCurrentVersionSupportCustomTextAreaForAppbrand()
  {
    AppMethodBeat.i(212495);
    boolean bool = XWalkEnvironment.isCurrentVersionSupportCustomTextAreaForAppbrand();
    AppMethodBeat.o(212495);
    return bool;
  }
  
  public static boolean isCurrentVersionSupportExtendPluginForAppbrand()
  {
    AppMethodBeat.i(212485);
    boolean bool = XWalkEnvironment.isCurrentVersionSupportExtendPluginForAppbrand();
    AppMethodBeat.o(212485);
    return bool;
  }
  
  public static boolean isCurrentVersionSupportMapExtendPluginForAppbrand()
  {
    AppMethodBeat.i(212490);
    boolean bool = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    AppMethodBeat.o(212490);
    return bool;
  }
  
  public static boolean isCurrentVersionSupportNativeView()
  {
    AppMethodBeat.i(212500);
    boolean bool = XWalkEnvironment.isCurrentVersionSupportNativeView();
    AppMethodBeat.o(212500);
    return bool;
  }
  
  public static boolean isXWebCoreInited()
  {
    AppMethodBeat.i(212653);
    boolean bool = WebView.isXWebCoreInited();
    AppMethodBeat.o(212653);
    return bool;
  }
  
  public static void jQC()
  {
    AppMethodBeat.i(212739);
    XWalkEnvironment.setMultiProcessType(1);
    AppMethodBeat.o(212739);
  }
  
  public static boolean kfA()
  {
    AppMethodBeat.i(212566);
    boolean bool = y.kfA();
    AppMethodBeat.o(212566);
    return bool;
  }
  
  public static void kfp()
  {
    AppMethodBeat.i(212670);
    c.kfo().kfp();
    AppMethodBeat.o(212670);
  }
  
  public static void kfy()
  {
    AppMethodBeat.i(212563);
    y.kfy();
    AppMethodBeat.o(212563);
  }
  
  public static void kfz()
  {
    AppMethodBeat.i(212564);
    y.kfz();
    AppMethodBeat.o(212564);
  }
  
  public static int kge()
  {
    return 20220105;
  }
  
  public static void kgf()
  {
    AppMethodBeat.i(212531);
    XWalkEnvironment.setUsingCustomContext(true);
    AppMethodBeat.o(212531);
  }
  
  public static int kgg()
  {
    AppMethodBeat.i(212544);
    int i = com.tencent.xweb.util.d.kgg();
    AppMethodBeat.o(212544);
    return i;
  }
  
  public static boolean kgh()
  {
    AppMethodBeat.i(212547);
    if (XWalkEnvironment.getApplicationContext() != null)
    {
      AppMethodBeat.o(212547);
      return true;
    }
    AppMethodBeat.o(212547);
    return false;
  }
  
  public static void kgi()
  {
    AppMethodBeat.i(212578);
    XWalkUpdateConfigUtil.setBaseConfigUpdatePeriod(3600000L);
    AppMethodBeat.o(212578);
  }
  
  public static void kgj()
  {
    AppMethodBeat.i(212604);
    XWalkUpdateConfigUtil.setTempPluginConfigUpdatePeriod(3600000);
    AppMethodBeat.o(212604);
  }
  
  public static boolean kgk()
  {
    AppMethodBeat.i(212622);
    boolean bool = WebView.hasInited();
    AppMethodBeat.o(212622);
    return bool;
  }
  
  public static boolean kgl()
  {
    AppMethodBeat.i(212643);
    boolean bool = WebView.isSys();
    AppMethodBeat.o(212643);
    return bool;
  }
  
  public static boolean kgm()
  {
    AppMethodBeat.i(212645);
    boolean bool = WebView.isX5();
    AppMethodBeat.o(212645);
    return bool;
  }
  
  public static boolean kgn()
  {
    AppMethodBeat.i(212650);
    boolean bool = WebView.isXWalk();
    AppMethodBeat.o(212650);
    return bool;
  }
  
  public static void kgo()
  {
    AppMethodBeat.i(212677);
    d locald = d.kfq();
    if (locald.aiep != null) {
      locald.aiep.sync();
    }
    AppMethodBeat.o(212677);
  }
  
  public static boolean kgp()
  {
    AppMethodBeat.i(212679);
    boolean bool = am.getBooleanValue("remote-debugging");
    AppMethodBeat.o(212679);
    return bool;
  }
  
  public static void kgq()
  {
    AppMethodBeat.i(212682);
    am.setValue("remote-debugging", true);
    AppMethodBeat.o(212682);
  }
  
  public static void kgr()
  {
    AppMethodBeat.i(185176);
    kgv();
    AppMethodBeat.o(185176);
  }
  
  public static void kgs()
  {
    AppMethodBeat.i(156941);
    kgx();
    AppMethodBeat.o(156941);
  }
  
  public static void oQ(Context paramContext)
  {
    AppMethodBeat.i(212675);
    d.kfq().init(paramContext);
    AppMethodBeat.o(212675);
  }
  
  public static void oR(Context paramContext)
  {
    AppMethodBeat.i(212697);
    oU(paramContext);
    AppMethodBeat.o(212697);
  }
  
  public static void oS(Context paramContext)
  {
    AppMethodBeat.i(212700);
    oV(paramContext);
    AppMethodBeat.o(212700);
  }
  
  public static void qV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212589);
    XWalkUpdateConfigUtil.setTempBaseConfigUrl(paramString1, paramString2);
    AppMethodBeat.o(212589);
  }
  
  public static void removeAllCookie()
  {
    AppMethodBeat.i(212659);
    c localc = c.kfo();
    if (localc.aien != null) {
      localc.aien.removeAllCookie();
    }
    AppMethodBeat.o(212659);
  }
  
  public static void removeSessionCookie()
  {
    AppMethodBeat.i(212668);
    c localc = c.kfo();
    if (localc.aien != null) {
      localc.aien.removeSessionCookie();
    }
    AppMethodBeat.o(212668);
  }
  
  public static void setAppClientVersion(int paramInt)
  {
    AppMethodBeat.i(212541);
    XWalkEnvironment.setAppClientVersion(paramInt);
    AppMethodBeat.o(212541);
  }
  
  public static void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212665);
    c.kfo().setCookie(paramString1, paramString2);
    AppMethodBeat.o(212665);
  }
  
  public static void setForceDarkBehavior(XWalkEnvironment.ForceDarkBehavior paramForceDarkBehavior)
  {
    AppMethodBeat.i(212526);
    XWalkEnvironment.setForceDarkBehavior(paramForceDarkBehavior);
    AppMethodBeat.o(212526);
  }
  
  public static void setForceDarkMode(boolean paramBoolean)
  {
    AppMethodBeat.i(212518);
    XWalkEnvironment.setForceDarkMode(paramBoolean);
    AppMethodBeat.o(212518);
  }
  
  public static boolean setGrayValueByUserId(int paramInt)
  {
    AppMethodBeat.i(212553);
    boolean bool = XWalkGrayValueUtil.setGrayValueByUserId(paramInt);
    AppMethodBeat.o(212553);
    return bool;
  }
  
  public static void setGrayValueForTest(int paramInt)
  {
    AppMethodBeat.i(212557);
    XWalkGrayValueUtil.setGrayValueForTest(paramInt);
    AppMethodBeat.o(212557);
  }
  
  public static void setSandBoxProcessCrashDumpPath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212743);
    XWalkEnvironment.setSandBoxProcessCrashDumpPath(paramString1, paramString2);
    AppMethodBeat.o(212743);
  }
  
  public static void setTempBaseConfigUrl(String paramString)
  {
    AppMethodBeat.i(212587);
    XWalkUpdateConfigUtil.setTempBaseConfigUrl(paramString);
    AppMethodBeat.o(212587);
  }
  
  public static void setTempPluginConfigUrl(String paramString)
  {
    AppMethodBeat.i(212594);
    XWalkUpdateConfigUtil.setTempPluginConfigUrl(paramString);
    AppMethodBeat.o(212594);
  }
  
  public static void setTempPluginConfigUrl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212597);
    XWalkUpdateConfigUtil.setTempPluginConfigUrl(paramString1, paramString2);
    AppMethodBeat.o(212597);
  }
  
  public static void setTestBaseConfigUrl(String paramString)
  {
    AppMethodBeat.i(212582);
    XWalkUpdateConfigUtil.setTestBaseConfigUrl(paramString);
    AppMethodBeat.o(212582);
  }
  
  public static void setXWebInitArgs(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(212513);
    XWalkEnvironment.setXWebInitArgs(paramHashMap);
    AppMethodBeat.o(212513);
  }
  
  public static void updateResourceLocale(Locale paramLocale)
  {
    AppMethodBeat.i(212720);
    if (!WebView.isXWalk())
    {
      Log.w("XWebSdkInternal", "updateResourceLocale, not xweb now");
      AppMethodBeat.o(212720);
      return;
    }
    try
    {
      WebViewWrapperFactory.IWebViewProvider localIWebViewProvider = WebViewWrapperFactory.e(WebView.getCurWebType());
      if (localIWebViewProvider != null) {
        localIWebViewProvider.excute("STR_CMD_UPDATE_RESOURCE_LOCALE", new Object[] { paramLocale });
      }
      AppMethodBeat.o(212720);
      return;
    }
    finally
    {
      Log.e("XWebSdkInternal", "updateResourceLocale, error:".concat(String.valueOf(paramLocale)));
      AppMethodBeat.o(212720);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.ao
 * JD-Core Version:    0.7.0.1
 */