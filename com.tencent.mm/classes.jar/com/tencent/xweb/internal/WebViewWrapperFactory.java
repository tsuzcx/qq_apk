package com.tencent.xweb.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.util.k;
import com.tencent.xweb.util.l;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class WebViewWrapperFactory
{
  private static IWebViewProvider aikl;
  private static IWebViewProvider aikm;
  private static IWebViewProvider aikn;
  private static IWebViewProvider aiko;
  private static IWebViewProvider aikp;
  
  public static IWebView a(WebView.WebViewKind paramWebViewKind, WebView paramWebView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(156982);
    XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "getWebView, try to create webview type = ".concat(String.valueOf(paramWebViewKind)));
    c localc1 = c.c("CREATE_WEBVIEW", paramWebViewKind);
    localc1.kgZ();
    c localc2 = c.d("CREATE_WEBVIEW", paramWebViewKind);
    localc2.kgZ();
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        IWebViewProvider localIWebViewProvider = e(paramWebViewKind);
        if (localIWebViewProvider == null)
        {
          localObject1 = localObject2;
          XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "getWebView, provider not exist");
          AppMethodBeat.o(156982);
          return null;
        }
        localObject1 = localObject2;
        paramWebView = localIWebViewProvider.createWebView(paramWebView);
        if (paramWebView == null) {
          continue;
        }
        localObject1 = paramWebView;
        XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "getWebView, create webview success");
        localObject1 = paramWebView;
        localc1.kha();
        localObject1 = paramWebView;
        localc2.kha();
      }
      finally
      {
        XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "getWebView, create webview error:" + paramWebView + ", stackTrace:" + android.util.Log.getStackTraceString(paramWebView));
        l.k(paramWebViewKind);
        paramWebView = (WebView)localObject1;
        continue;
      }
      AppMethodBeat.o(156982);
      return paramWebView;
      localObject1 = paramWebView;
      XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "getWebView, create webview failed");
    }
  }
  
  public static IWebViewProvider e(WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(156981);
    if (paramWebViewKind == WebView.WebViewKind.aifI)
    {
      if (aikl == null)
      {
        paramWebViewKind = k.rc("com.tencent.xweb.xwalk.XWalkWebFactory", "getInstance");
        if (!(paramWebViewKind instanceof IWebViewProvider))
        {
          org.xwalk.core.Log.e("WebViewWrapperFactory", "getWebViewProvider, find XWalkWebFactory failed");
          AppMethodBeat.o(156981);
          return null;
        }
        aikl = (IWebViewProvider)paramWebViewKind;
      }
      paramWebViewKind = aikl;
      AppMethodBeat.o(156981);
      return paramWebViewKind;
    }
    if (paramWebViewKind == WebView.WebViewKind.aifJ)
    {
      if (aikm == null)
      {
        paramWebViewKind = k.rc("com.tencent.xweb.x5.X5WebFactory", "getInstance");
        if (!(paramWebViewKind instanceof IWebViewProvider))
        {
          org.xwalk.core.Log.e("WebViewWrapperFactory", "getWebViewProvider, find X5WebFactory failed");
          AppMethodBeat.o(156981);
          return null;
        }
        aikm = (IWebViewProvider)paramWebViewKind;
      }
      paramWebViewKind = aikm;
      AppMethodBeat.o(156981);
      return paramWebViewKind;
    }
    if (paramWebViewKind == WebView.WebViewKind.aifK)
    {
      if (aikn == null)
      {
        paramWebViewKind = k.rc("com.tencent.xweb.sys.SysWebFactory", "getInstance");
        if (!(paramWebViewKind instanceof IWebViewProvider))
        {
          org.xwalk.core.Log.e("WebViewWrapperFactory", "getWebViewProvider, find SysWebFactory failed");
          AppMethodBeat.o(156981);
          return null;
        }
        aikn = (IWebViewProvider)paramWebViewKind;
      }
      paramWebViewKind = aikn;
      AppMethodBeat.o(156981);
      return paramWebViewKind;
    }
    if (paramWebViewKind == WebView.WebViewKind.aifL)
    {
      if (aiko == null)
      {
        paramWebViewKind = k.rc("com.tencent.xweb.pinus.PinusWebFactory", "getInstance");
        if (!(paramWebViewKind instanceof IWebViewProvider))
        {
          org.xwalk.core.Log.e("WebViewWrapperFactory", "getWebViewProvider, find PinusWebFactory failed");
          AppMethodBeat.o(156981);
          return null;
        }
        aiko = (IWebViewProvider)paramWebViewKind;
      }
      paramWebViewKind = aiko;
      AppMethodBeat.o(156981);
      return paramWebViewKind;
    }
    AppMethodBeat.o(156981);
    return null;
  }
  
  public static IWebViewProvider khn()
  {
    AppMethodBeat.i(212548);
    if (aikp == null)
    {
      localObject = k.rc("com.tencent.xweb.XWebViewProvider", "getInstance");
      if (!(localObject instanceof IWebViewProvider))
      {
        org.xwalk.core.Log.e("WebViewWrapperFactory", "getXWebViewProvider, find XWebViewProvider failed");
        AppMethodBeat.o(212548);
        return null;
      }
      aikp = (IWebViewProvider)localObject;
    }
    Object localObject = aikp;
    AppMethodBeat.o(212548);
    return localObject;
  }
  
  public static int kho()
  {
    AppMethodBeat.i(212562);
    Object localObject1 = k.rd("org.xwalk.core.BuildConfig", "APK_VERSION");
    if ((localObject1 instanceof Integer)) {
      try
      {
        int i = ((Integer)localObject1).intValue();
        AppMethodBeat.o(212562);
        return i;
      }
      finally
      {
        org.xwalk.core.Log.e("WebViewWrapperFactory", "getEmbedCoreVersion, error:".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(212562);
        return -1;
      }
    }
    AppMethodBeat.o(212562);
    return -1;
  }
  
  public static abstract interface IWebViewProvider
  {
    public abstract void clearAllWebViewCache(Context paramContext, boolean paramBoolean);
    
    public abstract IWebView createWebView(WebView paramWebView);
    
    public abstract IWebStorage createWebviewStorage();
    
    public abstract Object excute(String paramString, Object[] paramArrayOfObject);
    
    public abstract CookieInternal.ICookieManagerInternal getCookieManager();
    
    public abstract CookieInternal.ICookieSyncManagerInternal getCookieSyncManager();
    
    public abstract IWebViewDatabase getWebViewDatabase();
    
    public abstract boolean hasInited();
    
    public abstract void initEnviroment(Context paramContext);
    
    public abstract void initInterface();
    
    public abstract void initWebViewExtensionListener(WebViewExtensionListener paramWebViewExtensionListener);
    
    public abstract boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.internal.WebViewWrapperFactory
 * JD-Core Version:    0.7.0.1
 */