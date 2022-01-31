package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebViewClient;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.a.a;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import org.xwalk.core.Log;

final class e$1
  extends WebViewClient
{
  e$1(e parame) {}
  
  public final void doUpdateVisitedHistory(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    if (this.xjZ.xjR != null)
    {
      this.xjZ.xjR.a(this.xjZ.xjP, paramString, paramBoolean);
      return;
    }
    super.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
  }
  
  public final void onLoadResource(android.webkit.WebView paramWebView, String paramString)
  {
    if (this.xjZ.xjR != null)
    {
      this.xjZ.xjR.f(this.xjZ.xjP, paramString);
      return;
    }
    super.onLoadResource(paramWebView, paramString);
  }
  
  public final void onPageFinished(android.webkit.WebView paramWebView, String paramString)
  {
    Log.i("SysWebView", "onPageFinished " + paramString);
    boolean bool;
    if (this.xjZ.xjW != null)
    {
      b localb = this.xjZ.xjW;
      if (this.xjZ.xjP.getFullscreenVideoKind() == WebView.a.xhl)
      {
        bool = true;
        localb.aa(false, bool);
      }
    }
    else
    {
      if (this.xjZ.xjR == null) {
        break label129;
      }
      this.xjZ.xjR.a(this.xjZ.xjP, paramString);
    }
    for (;;)
    {
      com.tencent.xweb.util.e.iu(System.currentTimeMillis() - this.xjZ.xjV);
      com.tencent.xweb.util.e.iv(System.currentTimeMillis() - this.xjZ.xjV);
      return;
      bool = false;
      break;
      label129:
      super.onPageFinished(paramWebView, paramString);
    }
  }
  
  public final void onPageStarted(android.webkit.WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    Log.i("SysWebView", "onPageStarted " + paramString);
    if (this.xjZ.xjR != null)
    {
      this.xjZ.xjR.b(this.xjZ.xjP, paramString, paramBitmap);
      this.xjZ.xjV = System.currentTimeMillis();
      com.tencent.xweb.util.e.agZ(paramString);
      com.tencent.xweb.util.e.cSM();
      if (this.xjZ.xjW != null)
      {
        paramWebView = this.xjZ.xjW;
        if (this.xjZ.xjP.getFullscreenVideoKind() != WebView.a.xhl) {
          break label124;
        }
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      paramWebView.aa(true, bool);
      return;
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      break;
    }
  }
  
  public final void onReceivedError(android.webkit.WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (this.xjZ.xjR != null) {
      this.xjZ.xjR.a(this.xjZ.xjP, paramInt, paramString1, paramString2);
    }
    for (;;)
    {
      com.tencent.xweb.util.e.cSL();
      com.tencent.xweb.util.e.cSN();
      return;
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
  }
  
  public final void onReceivedHttpError(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    Object localObject;
    com.tencent.xweb.WebView localWebView;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = String.valueOf(paramWebResourceResponse.getStatusCode());
      Log.i("SysWebView", "onReceivedHttpError code:" + (String)localObject);
      if (this.xjZ.xjR == null) {
        break label165;
      }
      localObject = this.xjZ.xjR;
      localWebView = this.xjZ.xjP;
      paramWebResourceRequest = new c.e(paramWebResourceRequest);
      if (paramWebResourceResponse != null) {
        break label99;
      }
      paramWebView = null;
    }
    for (;;)
    {
      ((p)localObject).a(localWebView, paramWebResourceRequest, paramWebView);
      return;
      localObject = "Invalid";
      break;
      label99:
      if (Build.VERSION.SDK_INT >= 21) {
        paramWebView = new m(paramWebResourceResponse.getMimeType(), paramWebResourceResponse.getEncoding(), paramWebResourceResponse.getStatusCode(), paramWebResourceResponse.getReasonPhrase(), paramWebResourceResponse.getResponseHeaders(), paramWebResourceResponse.getData());
      } else {
        paramWebView = new m(paramWebResourceResponse.getMimeType(), paramWebResourceResponse.getEncoding(), paramWebResourceResponse.getData());
      }
    }
    label165:
    super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
  }
  
  public final void onReceivedSslError(android.webkit.WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    Log.i("SysWebView", "onReceivedSslError " + paramSslError.getPrimaryError());
    if (this.xjZ.xjR != null)
    {
      this.xjZ.xjR.a(this.xjZ.xjP, new c.a(paramSslErrorHandler), paramSslError);
      return;
    }
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }
  
  public final void onScaleChanged(android.webkit.WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    if (this.xjZ.xjR != null)
    {
      this.xjZ.xjR.a(this.xjZ.xjP, paramFloat1, paramFloat2);
      return;
    }
    super.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
  }
  
  public final WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    Object localObject = null;
    if (this.xjZ.xjR != null)
    {
      c.e locale = new c.e(paramWebResourceRequest);
      if (locale.xjK == null) {}
      for (paramWebResourceRequest = null;; paramWebResourceRequest = locale.xjK.getBundle())
      {
        paramWebView = localObject;
        if (paramWebResourceRequest != null) {
          paramWebView = this.xjZ.xjR.a(this.xjZ.xjP, locale, paramWebResourceRequest);
        }
        paramWebResourceRequest = paramWebView;
        if (paramWebView == null) {
          paramWebResourceRequest = this.xjZ.xjR.a(this.xjZ.xjP, locale);
        }
        return c.a(paramWebResourceRequest);
      }
    }
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
  
  public final WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, String paramString)
  {
    if (this.xjZ.xjR != null) {
      return c.a(this.xjZ.xjR.c(this.xjZ.xjP, paramString));
    }
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
  
  public final boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, String paramString)
  {
    Log.i("SysWebView", "shouldOverrideUrlLoading " + paramString);
    if (this.xjZ.xjR != null) {
      return this.xjZ.xjR.b(this.xjZ.xjP, paramString);
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.e.1
 * JD-Core Version:    0.7.0.1
 */