package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.b.a;
import com.tencent.xweb.c.b.b;
import com.tencent.xweb.c.l.a;
import com.tencent.xweb.k.a;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

public class X5WebFactory
  implements l.a
{
  private static final String TAG = "MicroMsg.X5WebFactory";
  static X5WebFactory sInstance;
  
  public static X5WebFactory getInstance()
  {
    AppMethodBeat.i(84869);
    if (sInstance == null) {
      sInstance = new X5WebFactory();
    }
    X5WebFactory localX5WebFactory = sInstance;
    AppMethodBeat.o(84869);
    return localX5WebFactory;
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(84878);
    QbSdk.clearAllWebViewCache(paramContext, paramBoolean);
    AppMethodBeat.o(84878);
  }
  
  public com.tencent.xweb.c.i createWebView(WebView paramWebView)
  {
    AppMethodBeat.i(84871);
    paramWebView = new k(paramWebView);
    AppMethodBeat.o(84871);
    return paramWebView;
  }
  
  public com.tencent.xweb.c.h createWebviewStorage()
  {
    AppMethodBeat.i(84881);
    j localj = new j();
    AppMethodBeat.o(84881);
    return localj;
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(84870);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(84870);
      return null;
    }
    if (paramString.equals("STR_CMD_GET_TBS_QBSDK_IMP"))
    {
      paramString = new com.tencent.xweb.x5.sdk.e();
      AppMethodBeat.o(84870);
      return paramString;
    }
    if (paramString.equals("STR_CMD_GET_TBS_DOWNLOADER_IMP"))
    {
      paramString = new com.tencent.xweb.x5.sdk.g();
      AppMethodBeat.o(84870);
      return paramString;
    }
    AppMethodBeat.o(84870);
    return null;
  }
  
  public b.a getCookieManager()
  {
    AppMethodBeat.i(84879);
    d locald = new d();
    AppMethodBeat.o(84879);
    return locald;
  }
  
  public b.b getCookieSyncManager()
  {
    AppMethodBeat.i(84880);
    e locale = new e();
    AppMethodBeat.o(84880);
    return locale;
  }
  
  public com.tencent.xweb.c.g getJsCore(k.a parama, Context paramContext)
  {
    AppMethodBeat.i(84874);
    Object localObject = null;
    switch (1.BIj[parama.ordinal()])
    {
    default: 
      parama = localObject;
    }
    boolean bool;
    do
    {
      AppMethodBeat.o(84874);
      return parama;
      bool = X5JsCore.canUseX5JsCore(paramContext);
      Log.i("MicroMsg.X5WebFactory", "canUseX5JsCore : ".concat(String.valueOf(bool)));
      parama = localObject;
    } while (!bool);
    if (X5JsCore.canUseX5JsCoreNewAPI(paramContext)) {}
    for (parama = new h(paramContext);; parama = new f(paramContext))
    {
      parama.init(0);
      break;
    }
  }
  
  public boolean hasInited()
  {
    AppMethodBeat.i(84876);
    boolean bool = X5WebFactory.b.hasInited();
    AppMethodBeat.o(84876);
    return bool;
  }
  
  public boolean hasInitedCallback()
  {
    return true;
  }
  
  public void initCallback(WebViewExtensionListener paramWebViewExtensionListener) {}
  
  public void initEnviroment(Context paramContext)
  {
    AppMethodBeat.i(84873);
    TbsLog.setTbsLogClient(new X5WebFactory.a(this, paramContext));
    AppMethodBeat.o(84873);
  }
  
  public void initInterface()
  {
    AppMethodBeat.i(84872);
    com.tencent.xweb.x5.sdk.d.a(new com.tencent.xweb.x5.sdk.e());
    com.tencent.xweb.x5.sdk.f.a(new com.tencent.xweb.x5.sdk.g());
    WebView.setX5Interface(new com.tencent.xweb.x5.sdk.i());
    AppMethodBeat.o(84872);
  }
  
  public boolean initWebviewCore(Context paramContext, WebView.c paramc)
  {
    AppMethodBeat.i(84875);
    X5WebFactory.b.a(paramContext, paramc);
    AppMethodBeat.o(84875);
    return true;
  }
  
  public boolean isCoreReady()
  {
    AppMethodBeat.i(84877);
    boolean bool = X5WebFactory.b.isCoreReady();
    AppMethodBeat.o(84877);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.x5.X5WebFactory
 * JD-Core Version:    0.7.0.1
 */