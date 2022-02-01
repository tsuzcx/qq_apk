package com.tencent.xweb.x5;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.ao;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import com.tencent.xweb.x5.a.e;
import com.tencent.xweb.x5.a.f;
import com.tencent.xweb.x5.a.g;
import com.tencent.xweb.x5.a.h;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

public class X5WebFactory
  implements WebViewWrapperFactory.IWebViewProvider
{
  private static final String TAG = "X5WebFactory";
  private static X5WebFactory sInstance;
  private WebViewExtensionListener mWebViewExtensionListener;
  
  public static X5WebFactory getInstance()
  {
    AppMethodBeat.i(153884);
    if (sInstance == null)
    {
      ao.kgs();
      sInstance = new X5WebFactory();
    }
    X5WebFactory localX5WebFactory = sInstance;
    AppMethodBeat.o(153884);
    return localX5WebFactory;
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(153893);
    QbSdk.clearAllWebViewCache(paramContext, paramBoolean);
    AppMethodBeat.o(153893);
  }
  
  public IWebView createWebView(WebView paramWebView)
  {
    AppMethodBeat.i(153886);
    try
    {
      paramWebView = new j(paramWebView);
      return paramWebView;
    }
    finally
    {
      AppMethodBeat.o(153886);
    }
  }
  
  public IWebStorage createWebviewStorage()
  {
    AppMethodBeat.i(153896);
    i locali = new i();
    AppMethodBeat.o(153896);
    return locali;
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(153885);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(153885);
      return null;
    }
    if (paramString.equals("STR_CMD_GET_TBS_QBSDK_IMP"))
    {
      paramString = new f();
      AppMethodBeat.o(153885);
      return paramString;
    }
    if (paramString.equals("STR_CMD_GET_TBS_DOWNLOADER_IMP"))
    {
      paramString = new h();
      AppMethodBeat.o(153885);
      return paramString;
    }
    AppMethodBeat.o(153885);
    return null;
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    AppMethodBeat.i(153894);
    b localb = new b();
    AppMethodBeat.o(153894);
    return localb;
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    AppMethodBeat.i(153895);
    c localc = new c();
    AppMethodBeat.o(153895);
    return localc;
  }
  
  public WebViewExtensionListener getExtensionCallback()
  {
    return this.mWebViewExtensionListener;
  }
  
  public IWebViewDatabase getWebViewDatabase()
  {
    AppMethodBeat.i(213169);
    l locall = new l();
    AppMethodBeat.o(213169);
    return locall;
  }
  
  public boolean hasInited()
  {
    AppMethodBeat.i(153891);
    boolean bool = a.hasInited();
    AppMethodBeat.o(153891);
    return bool;
  }
  
  public boolean hasInitedCallback()
  {
    return true;
  }
  
  public void initEnviroment(Context paramContext)
  {
    AppMethodBeat.i(153888);
    Log.i("X5WebFactory", "initEnvironment");
    TbsLog.setTbsLogClient(new b(paramContext));
    AppMethodBeat.o(153888);
  }
  
  public void initInterface()
  {
    AppMethodBeat.i(153887);
    e.a(new f());
    g.a(new h());
    WebView.setX5Interface(new com.tencent.xweb.x5.a.j());
    AppMethodBeat.o(153887);
  }
  
  public void initWebViewExtensionListener(WebViewExtensionListener paramWebViewExtensionListener)
  {
    this.mWebViewExtensionListener = paramWebViewExtensionListener;
  }
  
  public boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(153890);
    Log.i("X5WebFactory", "initWebviewCore");
    ao.kgs();
    e.disableAutoCreateX5Webview();
    a.a(paramContext, paramPreInitCallback);
    AppMethodBeat.o(153890);
    return true;
  }
  
  public boolean isCoreReady()
  {
    AppMethodBeat.i(153892);
    boolean bool = a.isCoreReady();
    AppMethodBeat.o(153892);
    return bool;
  }
  
  static final class a
  {
    private static boolean mHasInited = false;
    private static boolean mIsCoreReady = false;
    
    public static void a(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
    {
      AppMethodBeat.i(213154);
      if (mHasInited)
      {
        AppMethodBeat.o(213154);
        return;
      }
      Log.i("X5WebFactory.PreIniter", "preInit start");
      mHasInited = true;
      QbSdk.preInit(paramContext, new QbSdk.PreInitCallback()
      {
        private boolean aink = false;
        private boolean ainl = false;
        
        public final void onCoreInitFinished()
        {
          AppMethodBeat.i(213155);
          Log.i("X5WebFactory.PreIniter", "onCoreInitFinished");
          this.aink = true;
          if ((this.aink) && (this.ainl) && (X5WebFactory.a.this != null))
          {
            X5WebFactory.a.this.onCoreInitFinished();
            X5WebFactory.a.aAs();
          }
          AppMethodBeat.o(213155);
        }
        
        public final void onViewInitFinished(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(213158);
          Log.i("X5WebFactory.PreIniter", "onViewInitFinished");
          this.ainl = true;
          if ((this.aink) && (this.ainl) && (X5WebFactory.a.this != null))
          {
            X5WebFactory.a.this.onCoreInitFinished();
            X5WebFactory.a.aAs();
          }
          AppMethodBeat.o(213158);
        }
      });
      AppMethodBeat.o(213154);
    }
    
    public static boolean hasInited()
    {
      return mHasInited;
    }
    
    public static boolean isCoreReady()
    {
      return mIsCoreReady;
    }
  }
  
  final class b
    extends TbsLogClient
  {
    public b(Context paramContext)
    {
      super();
    }
    
    public final void d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(153879);
      super.d(paramString1, paramString2);
      Log.d(paramString1, paramString2);
      AppMethodBeat.o(153879);
    }
    
    public final void e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(153877);
      super.e(paramString1, paramString2);
      Log.e(paramString1, paramString2);
      AppMethodBeat.o(153877);
    }
    
    public final void i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(153876);
      super.i(paramString1, paramString2);
      Log.i(paramString1, paramString2);
      AppMethodBeat.o(153876);
    }
    
    public final void setLogView(TextView paramTextView)
    {
      AppMethodBeat.i(153875);
      super.setLogView(paramTextView);
      AppMethodBeat.o(153875);
    }
    
    public final void showLog(String paramString)
    {
      AppMethodBeat.i(153874);
      super.showLog(paramString);
      AppMethodBeat.o(153874);
    }
    
    public final void v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(153880);
      super.v(paramString1, paramString2);
      Log.v(paramString1, paramString2);
      AppMethodBeat.o(153880);
    }
    
    public final void w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(153878);
      super.w(paramString1, paramString2);
      Log.w(paramString1, paramString2);
      AppMethodBeat.o(153878);
    }
    
    public final void writeLog(String paramString)
    {
      AppMethodBeat.i(153872);
      super.writeLog(paramString);
      AppMethodBeat.o(153872);
    }
    
    public final void writeLogToDisk()
    {
      AppMethodBeat.i(153873);
      super.writeLogToDisk();
      AppMethodBeat.o(153873);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.X5WebFactory
 * JD-Core Version:    0.7.0.1
 */