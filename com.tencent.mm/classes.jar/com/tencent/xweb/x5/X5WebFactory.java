package com.tencent.xweb.x5;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.xweb.JsRuntime.JsRuntimeType;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.ah;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IJsRuntime;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.j.a;
import com.tencent.xweb.x5.sdk.g;
import com.tencent.xweb.x5.sdk.i;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

public class X5WebFactory
  implements j.a
{
  private static final String TAG = "MicroMsg.X5WebFactory";
  static X5WebFactory sInstance;
  
  public static X5WebFactory getInstance()
  {
    AppMethodBeat.i(153884);
    if (sInstance == null)
    {
      ah.fJR();
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
    paramWebView = new m(paramWebView);
    AppMethodBeat.o(153886);
    return paramWebView;
  }
  
  public IWebStorage createWebviewStorage()
  {
    AppMethodBeat.i(153896);
    l locall = new l();
    AppMethodBeat.o(153896);
    return locall;
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
      paramString = new com.tencent.xweb.x5.sdk.e();
      AppMethodBeat.o(153885);
      return paramString;
    }
    if (paramString.equals("STR_CMD_GET_TBS_DOWNLOADER_IMP"))
    {
      paramString = new g();
      AppMethodBeat.o(153885);
      return paramString;
    }
    AppMethodBeat.o(153885);
    return null;
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    AppMethodBeat.i(153894);
    d locald = new d();
    AppMethodBeat.o(153894);
    return locald;
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    AppMethodBeat.i(153895);
    e locale = new e();
    AppMethodBeat.o(153895);
    return locale;
  }
  
  public IJsRuntime getJsCore(JsRuntime.JsRuntimeType paramJsRuntimeType, Context paramContext)
  {
    AppMethodBeat.i(153889);
    Object localObject = null;
    switch (1.KEI[paramJsRuntimeType.ordinal()])
    {
    default: 
      paramJsRuntimeType = localObject;
    }
    boolean bool;
    do
    {
      AppMethodBeat.o(153889);
      return paramJsRuntimeType;
      bool = X5JsCore.canUseX5JsCore(paramContext);
      Log.i("MicroMsg.X5WebFactory", "canUseX5JsCore : ".concat(String.valueOf(bool)));
      paramJsRuntimeType = localObject;
    } while (!bool);
    if (X5JsCore.canUseX5JsCoreNewAPI(paramContext)) {}
    for (paramJsRuntimeType = new h(paramContext);; paramJsRuntimeType = new f(paramContext))
    {
      paramJsRuntimeType.init(0);
      break;
    }
  }
  
  public IWebViewDatabase getWebViewDatabase()
  {
    AppMethodBeat.i(208891);
    n localn = new n();
    AppMethodBeat.o(208891);
    return localn;
  }
  
  public boolean hasInited()
  {
    AppMethodBeat.i(153891);
    boolean bool = b.hasInited();
    AppMethodBeat.o(153891);
    return bool;
  }
  
  public boolean hasInitedCallback()
  {
    return true;
  }
  
  public void initCallback(WebViewExtensionListener paramWebViewExtensionListener) {}
  
  public void initEnviroment(Context paramContext)
  {
    AppMethodBeat.i(153888);
    TbsLog.setTbsLogClient(new a(paramContext));
    AppMethodBeat.o(153888);
  }
  
  public void initInterface()
  {
    AppMethodBeat.i(153887);
    com.tencent.xweb.x5.sdk.d.a(new com.tencent.xweb.x5.sdk.e());
    com.tencent.xweb.x5.sdk.f.a(new g());
    WebView.setX5Interface(new i());
    AppMethodBeat.o(153887);
  }
  
  public boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(153890);
    ah.fJR();
    com.tencent.xweb.x5.sdk.d.disableAutoCreateX5Webview();
    b.a(paramContext, paramPreInitCallback);
    AppMethodBeat.o(153890);
    return true;
  }
  
  public boolean isCoreReady()
  {
    AppMethodBeat.i(153892);
    boolean bool = b.isCoreReady();
    AppMethodBeat.o(153892);
    return bool;
  }
  
  final class a
    extends TbsLogClient
  {
    public a(Context paramContext)
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
  
  static final class b
  {
    private static boolean KEK = false;
    private static boolean pHN = false;
    
    public static void a(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
    {
      AppMethodBeat.i(153883);
      if (pHN)
      {
        AppMethodBeat.o(153883);
        return;
      }
      Log.i("X5WebFactory.preIniter", "preInit");
      pHN = true;
      QbSdk.preInit(paramContext, new QbSdk.PreInitCallback()
      {
        private boolean KEL = false;
        private boolean KEM = false;
        
        public final void onCoreInitFinished()
        {
          AppMethodBeat.i(153881);
          this.KEL = true;
          if ((this.KEL) && (this.KEM) && (this.CcD != null))
          {
            this.CcD.onCoreInitFinished();
            X5WebFactory.b.adZ();
          }
          AppMethodBeat.o(153881);
        }
        
        public final void onViewInitFinished(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(153882);
          this.KEM = true;
          if ((this.KEL) && (this.KEM) && (this.CcD != null))
          {
            this.CcD.onCoreInitFinished();
            X5WebFactory.b.adZ();
          }
          AppMethodBeat.o(153882);
        }
      });
      AppMethodBeat.o(153883);
    }
    
    public static boolean hasInited()
    {
      return pHN;
    }
    
    public static boolean isCoreReady()
    {
      return KEK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.X5WebFactory
 * JD-Core Version:    0.7.0.1
 */