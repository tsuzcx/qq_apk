package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.b.a;
import com.tencent.xweb.c.b.b;
import com.tencent.xweb.c.j.a;
import com.tencent.xweb.g.a;
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
    if (sInstance == null) {
      sInstance = new X5WebFactory();
    }
    return sInstance;
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    QbSdk.clearAllWebViewCache(paramContext, paramBoolean);
  }
  
  public com.tencent.xweb.c.h createWebView(WebView paramWebView)
  {
    return new j(paramWebView);
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    if ((paramString == null) || (paramString.isEmpty())) {}
    do
    {
      return null;
      if (paramString.equals("STR_CMD_GET_TBS_QBSDK_IMP")) {
        return new com.tencent.xweb.x5.sdk.e();
      }
    } while (!paramString.equals("STR_CMD_GET_TBS_DOWNLOADER_IMP"));
    return new com.tencent.xweb.x5.sdk.g();
  }
  
  public b.a getCookieManager()
  {
    return new d();
  }
  
  public b.b getCookieSyncManager()
  {
    return new e();
  }
  
  public com.tencent.xweb.c.g getJsCore(g.a parama, Context paramContext)
  {
    switch (1.gXB[parama.ordinal()])
    {
    }
    boolean bool;
    do
    {
      return null;
      bool = X5JsCore.canUseX5JsCore(paramContext);
      Log.i("MicroMsg.X5WebFactory", "canUseX5JsCore : " + bool);
    } while (!bool);
    if (X5JsCore.canUseX5JsCoreNewAPI(paramContext)) {}
    for (parama = new h(paramContext);; parama = new f(paramContext))
    {
      parama.init(0);
      return parama;
    }
  }
  
  public boolean hasInited()
  {
    return X5WebFactory.b.hasInited();
  }
  
  public boolean hasInitedCallback()
  {
    return true;
  }
  
  public void initCallback(WebViewExtensionListener paramWebViewExtensionListener) {}
  
  public void initEnviroment(Context paramContext)
  {
    TbsLog.setTbsLogClient(new X5WebFactory.a(this, paramContext));
  }
  
  public void initInterface()
  {
    com.tencent.xweb.x5.sdk.d.a(new com.tencent.xweb.x5.sdk.e());
    com.tencent.xweb.x5.sdk.f.a(new com.tencent.xweb.x5.sdk.g());
    WebView.setX5Interface(new i());
  }
  
  public boolean initWebviewCore(Context paramContext, WebView.c paramc)
  {
    X5WebFactory.b.a(paramContext, paramc);
    return true;
  }
  
  public boolean isCoreReady()
  {
    return X5WebFactory.b.isCoreReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.X5WebFactory
 * JD-Core Version:    0.7.0.1
 */