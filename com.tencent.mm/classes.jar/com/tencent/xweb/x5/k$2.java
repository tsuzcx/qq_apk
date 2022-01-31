package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.xweb.util.f;
import com.tencent.xweb.w;
import org.xwalk.core.Log;

final class k$2
  extends c
{
  k$2(k paramk) {}
  
  public final void doUpdateVisitedHistory(com.tencent.smtt.sdk.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(84904);
    if (this.BIu.BHv != null)
    {
      this.BIu.BHv.a(this.BIu.BHt, paramString, paramBoolean);
      AppMethodBeat.o(84904);
      return;
    }
    super.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
    AppMethodBeat.o(84904);
  }
  
  public final void onLoadResource(com.tencent.smtt.sdk.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(84899);
    if (this.BIu.BHv != null)
    {
      this.BIu.BHv.h(this.BIu.BHt, paramString);
      AppMethodBeat.o(84899);
      return;
    }
    super.onLoadResource(paramWebView, paramString);
    AppMethodBeat.o(84899);
  }
  
  public final void onPageFinished(com.tencent.smtt.sdk.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(84898);
    Log.i("X5WebView", "onPageFinished ".concat(String.valueOf(paramString)));
    if (this.BIu.BHv != null) {
      this.BIu.BHv.b(this.BIu.BHt, paramString);
    }
    for (;;)
    {
      if ((this.BIu.BIr == null) || (!this.BIu.BIr.equals(paramString))) {
        com.tencent.xweb.c.k.dYQ().dYO();
      }
      f.pg(System.currentTimeMillis() - this.BIu.BHz);
      com.tencent.xweb.xwalk.c.a(this.BIu.BHt);
      f.pi(System.currentTimeMillis() - this.BIu.BHz);
      AppMethodBeat.o(84898);
      return;
      super.onPageFinished(paramWebView, paramString);
    }
  }
  
  public final void onPageStarted(com.tencent.smtt.sdk.WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(84897);
    Log.i("X5WebView", "onPageStarted ".concat(String.valueOf(paramString)));
    if (this.BIu.BHv != null) {
      this.BIu.BHv.b(this.BIu.BHt, paramString, paramBitmap);
    }
    for (;;)
    {
      this.BIu.BIr = "";
      this.BIu.BHz = System.currentTimeMillis();
      f.ayi(paramString);
      f.dZf();
      com.tencent.xweb.c.k.dYQ().dYN();
      AppMethodBeat.o(84897);
      return;
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
  }
  
  public final void onReceivedError(com.tencent.smtt.sdk.WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(84905);
    if (this.BIu.BHv != null) {
      this.BIu.BHv.a(this.BIu.BHt, paramInt, paramString1, paramString2);
    }
    for (;;)
    {
      this.BIu.BIr = paramString2;
      f.dZc();
      com.tencent.xweb.c.k.dYQ().dYR();
      f.dZg();
      AppMethodBeat.o(84905);
      return;
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
  }
  
  public final void onReceivedHttpError(com.tencent.smtt.sdk.WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(84907);
    Log.i("X5WebView", "onReceivedHttpError code:" + paramWebResourceResponse.getStatusCode());
    if (this.BIu.BHv != null)
    {
      this.BIu.BHv.a(this.BIu.BHt, new g.b(paramWebResourceRequest), g.a(paramWebResourceResponse));
      AppMethodBeat.o(84907);
      return;
    }
    super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    AppMethodBeat.o(84907);
  }
  
  public final void onReceivedSslError(com.tencent.smtt.sdk.WebView paramWebView, SslErrorHandler paramSslErrorHandler, com.tencent.smtt.export.external.interfaces.SslError paramSslError)
  {
    AppMethodBeat.i(84906);
    Log.i("X5WebView", "onReceivedSslError " + paramSslError.getPrimaryError());
    if (this.BIu.BHv != null)
    {
      w localw = this.BIu.BHv;
      com.tencent.xweb.WebView localWebView = this.BIu.BHt;
      paramSslErrorHandler = new g.a(paramSslErrorHandler);
      if (paramSslError != null) {}
      for (paramWebView = new android.net.http.SslError(paramSslError.getPrimaryError(), paramSslError.getCertificate());; paramWebView = null)
      {
        localw.a(localWebView, paramSslErrorHandler, paramWebView);
        AppMethodBeat.o(84906);
        return;
      }
    }
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    AppMethodBeat.o(84906);
  }
  
  public final void onScaleChanged(com.tencent.smtt.sdk.WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(84903);
    if (this.BIu.BHv != null)
    {
      this.BIu.BHv.a(this.BIu.BHt, paramFloat1, paramFloat2);
      AppMethodBeat.o(84903);
      return;
    }
    super.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
    AppMethodBeat.o(84903);
  }
  
  public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(84901);
    if (this.BIu.BHv != null)
    {
      paramWebView = new g.b(paramWebResourceRequest);
      paramWebView = a.b(this.BIu.BHv.a(this.BIu.BHt, paramWebView));
      AppMethodBeat.o(84901);
      return paramWebView;
    }
    paramWebView = super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
    AppMethodBeat.o(84901);
    return paramWebView;
  }
  
  public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(84902);
    if (this.BIu.BHv != null)
    {
      paramWebView = new g.b(paramWebResourceRequest);
      paramWebView = a.b(this.BIu.BHv.a(this.BIu.BHt, paramWebView, paramBundle));
      AppMethodBeat.o(84902);
      return paramWebView;
    }
    paramWebView = super.shouldInterceptRequest(paramWebView, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(84902);
    return paramWebView;
  }
  
  public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(84900);
    if (this.BIu.BHv != null)
    {
      paramWebView = a.b(this.BIu.BHv.c(this.BIu.BHt, paramString));
      AppMethodBeat.o(84900);
      return paramWebView;
    }
    paramWebView = super.shouldInterceptRequest(paramWebView, paramString);
    AppMethodBeat.o(84900);
    return paramWebView;
  }
  
  public final boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(84896);
    Log.i("X5WebView", "shouldOverrideUrlLoading ".concat(String.valueOf(paramString)));
    if (this.BIu.BHv != null)
    {
      bool = this.BIu.BHv.a(this.BIu.BHt, paramString);
      AppMethodBeat.o(84896);
      return bool;
    }
    boolean bool = super.shouldOverrideUrlLoading(paramWebView, paramString);
    AppMethodBeat.o(84896);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.k.2
 * JD-Core Version:    0.7.0.1
 */