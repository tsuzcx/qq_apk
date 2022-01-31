package com.tencent.xweb.sys;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.b.a;
import com.tencent.xweb.c.b.b;
import com.tencent.xweb.c.g;
import com.tencent.xweb.c.h;
import com.tencent.xweb.c.j.a;
import com.tencent.xweb.g.a;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

public class SysWebFactory
  implements j.a
{
  static SysWebFactory sInstance;
  
  public static SysWebFactory getInstance()
  {
    if (sInstance == null) {
      sInstance = new SysWebFactory();
    }
    return sInstance;
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
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
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("SysWebFactory", "clearAllWebViewCache failed " + paramContext.getMessage());
    }
  }
  
  public h createWebView(com.tencent.xweb.WebView paramWebView)
  {
    return new e(paramWebView);
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    if ((paramString == null) || (paramString.isEmpty())) {}
    while ((paramString.equals("STR_CMD_GET_DEBUG_VIEW")) || (!paramString.equals("STR_CMD_GET_UPDATER"))) {
      return null;
    }
    return null;
  }
  
  public b.a getCookieManager()
  {
    return new a();
  }
  
  public b.b getCookieSyncManager()
  {
    return new b();
  }
  
  public g getJsCore(g.a parama, Context paramContext)
  {
    return null;
  }
  
  public boolean hasInited()
  {
    return true;
  }
  
  public boolean hasInitedCallback()
  {
    return SysWebFactory.a.hasInitedCallback();
  }
  
  public void initCallback(WebViewExtensionListener paramWebViewExtensionListener) {}
  
  public void initEnviroment(Context paramContext) {}
  
  public void initInterface() {}
  
  public boolean initWebviewCore(Context paramContext, WebView.c paramc)
  {
    if (paramc != null) {
      paramc.onCoreInitFinished();
    }
    return true;
  }
  
  public boolean isCoreReady()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebFactory
 * JD-Core Version:    0.7.0.1
 */