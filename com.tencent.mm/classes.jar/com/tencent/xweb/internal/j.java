package com.tencent.xweb.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.util.f;
import com.tencent.xweb.util.g;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class j
{
  static a MQN;
  static a MQO;
  static a MQP;
  
  public static IWebView a(WebView.c paramc, WebView paramWebView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(156982);
    Log.i("WebViewWrapperFactory", "try to create webview  = ".concat(String.valueOf(paramc)));
    b localb = b.c("CREATE_WEBVIEW", paramc);
    localb.ggi();
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (g(paramc) == null)
        {
          localObject1 = localObject2;
          Log.e("WebViewWrapperFactory", "the kind of " + paramc + " this provider does not exist!");
          AppMethodBeat.o(156982);
          return null;
        }
        localObject1 = localObject2;
        paramWebView = g(paramc).createWebView(paramWebView);
        if (paramWebView == null) {
          continue;
        }
        localObject1 = paramWebView;
        localb.ggj();
      }
      catch (Exception paramWebView)
      {
        XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview with exception  type = " + paramc + ", error msg:" + paramWebView.getMessage());
        g.l(paramc);
        paramWebView = (WebView)localObject1;
        continue;
      }
      AppMethodBeat.o(156982);
      return paramWebView;
      localObject1 = paramWebView;
      XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview failed type = ".concat(String.valueOf(paramc)));
    }
  }
  
  public static a g(WebView.c paramc)
  {
    AppMethodBeat.i(156981);
    if (paramc == WebView.c.MNy)
    {
      if (MQN == null)
      {
        paramc = f.no("com.tencent.xweb.xwalk.XWalkWebFactory", "getInstance");
        if ((paramc == null) || (!(paramc instanceof a)))
        {
          Log.e("WebViewWrapperFactory", "find com.tencent.xweb.XWalkWebFactory failed");
          AppMethodBeat.o(156981);
          return null;
        }
        MQN = (a)paramc;
      }
      paramc = MQN;
      AppMethodBeat.o(156981);
      return paramc;
    }
    if (paramc == WebView.c.MNz)
    {
      if (MQO == null)
      {
        paramc = f.no("com.tencent.xweb.x5.X5WebFactory", "getInstance");
        if ((paramc == null) || (!(paramc instanceof a)))
        {
          Log.e("WebViewWrapperFactory", "find X5WebFactory failed");
          AppMethodBeat.o(156981);
          return null;
        }
        MQO = (a)paramc;
      }
      paramc = MQO;
      AppMethodBeat.o(156981);
      return paramc;
    }
    if (paramc == WebView.c.MNA)
    {
      if (MQP == null)
      {
        paramc = f.no("com.tencent.xweb.sys.SysWebFactory", "getInstance");
        if ((paramc == null) || (!(paramc instanceof a)))
        {
          Log.e("WebViewWrapperFactory", "find SysWebFactory failed");
          AppMethodBeat.o(156981);
          return null;
        }
        MQP = (a)paramc;
      }
      paramc = MQP;
      AppMethodBeat.o(156981);
      return paramc;
    }
    AppMethodBeat.o(156981);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void clearAllWebViewCache(Context paramContext, boolean paramBoolean);
    
    public abstract IWebView createWebView(WebView paramWebView);
    
    public abstract IWebStorage createWebviewStorage();
    
    public abstract Object excute(String paramString, Object[] paramArrayOfObject);
    
    public abstract CookieInternal.ICookieManagerInternal getCookieManager();
    
    public abstract CookieInternal.ICookieSyncManagerInternal getCookieSyncManager();
    
    public abstract IWebViewDatabase getWebViewDatabase();
    
    public abstract boolean hasInited();
    
    public abstract void initCallback(WebViewExtensionListener paramWebViewExtensionListener);
    
    public abstract void initEnviroment(Context paramContext);
    
    public abstract void initInterface();
    
    public abstract boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.j
 * JD-Core Version:    0.7.0.1
 */