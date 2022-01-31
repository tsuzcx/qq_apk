package com.tencent.xweb.c;

import android.content.Context;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.g.a;
import org.xwalk.core.WebViewExtensionListener;

public abstract interface j$a
{
  public abstract void clearAllWebViewCache(Context paramContext, boolean paramBoolean);
  
  public abstract h createWebView(WebView paramWebView);
  
  public abstract Object excute(String paramString, Object[] paramArrayOfObject);
  
  public abstract b.a getCookieManager();
  
  public abstract b.b getCookieSyncManager();
  
  public abstract g getJsCore(g.a parama, Context paramContext);
  
  public abstract boolean hasInited();
  
  public abstract void initCallback(WebViewExtensionListener paramWebViewExtensionListener);
  
  public abstract void initEnviroment(Context paramContext);
  
  public abstract void initInterface();
  
  public abstract boolean initWebviewCore(Context paramContext, WebView.c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.c.j.a
 * JD-Core Version:    0.7.0.1
 */