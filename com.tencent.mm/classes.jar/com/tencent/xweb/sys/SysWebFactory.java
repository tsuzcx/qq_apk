package com.tencent.xweb.sys;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.b.a;
import com.tencent.xweb.c.b.b;
import com.tencent.xweb.c.g;
import com.tencent.xweb.c.h;
import com.tencent.xweb.c.i;
import com.tencent.xweb.c.l.a;
import com.tencent.xweb.k.a;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

public class SysWebFactory
  implements l.a
{
  static SysWebFactory sInstance;
  
  public static SysWebFactory getInstance()
  {
    AppMethodBeat.i(84662);
    if (sInstance == null) {
      sInstance = new SysWebFactory();
    }
    SysWebFactory localSysWebFactory = sInstance;
    AppMethodBeat.o(84662);
    return localSysWebFactory;
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(84668);
    try
    {
      android.webkit.WebView localWebView = new android.webkit.WebView(paramContext);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        localWebView.removeJavascriptInterface("accessibility");
        localWebView.removeJavascriptInterface("accessibilityTraversal");
      }
      localWebView.clearCache(true);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      WebViewDatabase.getInstance(paramContext).clearUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearHttpAuthUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearFormData();
      WebStorage.getInstance().deleteAllData();
      WebIconDatabase.getInstance().removeAllIcons();
      AppMethodBeat.o(84668);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("SysWebFactory", "clearAllWebViewCache failed " + paramContext.getMessage());
      AppMethodBeat.o(84668);
    }
  }
  
  public i createWebView(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(84664);
    paramWebView = new e(paramWebView);
    AppMethodBeat.o(84664);
    return paramWebView;
  }
  
  public h createWebviewStorage()
  {
    return null;
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(84663);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(84663);
      return null;
    }
    if ((!paramString.equals("STR_CMD_GET_DEBUG_VIEW")) && (paramString.equals("STR_CMD_GET_UPDATER")))
    {
      AppMethodBeat.o(84663);
      return null;
    }
    AppMethodBeat.o(84663);
    return null;
  }
  
  public b.a getCookieManager()
  {
    AppMethodBeat.i(84669);
    a locala = new a();
    AppMethodBeat.o(84669);
    return locala;
  }
  
  public b.b getCookieSyncManager()
  {
    AppMethodBeat.i(84670);
    b localb = new b();
    AppMethodBeat.o(84670);
    return localb;
  }
  
  public g getJsCore(k.a parama, Context paramContext)
  {
    return null;
  }
  
  public boolean hasInited()
  {
    return true;
  }
  
  public boolean hasInitedCallback()
  {
    AppMethodBeat.i(84667);
    boolean bool = SysWebFactory.a.hasInitedCallback();
    AppMethodBeat.o(84667);
    return bool;
  }
  
  public void initCallback(WebViewExtensionListener paramWebViewExtensionListener)
  {
    AppMethodBeat.i(84666);
    SysWebFactory.a.dYY();
    AppMethodBeat.o(84666);
  }
  
  public void initEnviroment(Context paramContext) {}
  
  public void initInterface() {}
  
  public boolean initWebviewCore(Context paramContext, WebView.c paramc)
  {
    AppMethodBeat.i(84665);
    if (paramc != null) {
      paramc.onCoreInitFinished();
    }
    AppMethodBeat.o(84665);
    return true;
  }
  
  public boolean isCoreReady()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebFactory
 * JD-Core Version:    0.7.0.1
 */