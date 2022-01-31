package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebViewClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.a.a;
import com.tencent.xweb.c.k;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.s;
import com.tencent.xweb.util.f;
import com.tencent.xweb.w;
import org.xwalk.core.Log;

final class e$1
  extends WebViewClient
{
  e$1(e parame) {}
  
  public final void doUpdateVisitedHistory(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(84693);
    if (this.BHD.BHv != null)
    {
      this.BHD.BHv.a(this.BHD.BHt, paramString, paramBoolean);
      AppMethodBeat.o(84693);
      return;
    }
    super.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
    AppMethodBeat.o(84693);
  }
  
  public final void onLoadResource(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(84689);
    if (this.BHD.BHv != null)
    {
      this.BHD.BHv.h(this.BHD.BHt, paramString);
      AppMethodBeat.o(84689);
      return;
    }
    super.onLoadResource(paramWebView, paramString);
    AppMethodBeat.o(84689);
  }
  
  public final void onPageFinished(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(84688);
    Log.i("SysWebView", "onPageFinished ".concat(String.valueOf(paramString)));
    boolean bool;
    if (this.BHD.BHA != null)
    {
      b localb = this.BHD.BHA;
      if (this.BHD.BHt.getFullscreenVideoKind() == WebView.a.BEn)
      {
        bool = true;
        localb.ao(false, bool);
      }
    }
    else
    {
      if (this.BHD.BHv == null) {
        break label148;
      }
      this.BHD.BHv.b(this.BHD.BHt, paramString);
    }
    for (;;)
    {
      f.pg(System.currentTimeMillis() - this.BHD.BHz);
      com.tencent.xweb.xwalk.c.a(this.BHD.BHt);
      f.ph(System.currentTimeMillis() - this.BHD.BHz);
      k.dYQ().dYW();
      AppMethodBeat.o(84688);
      return;
      bool = false;
      break;
      label148:
      super.onPageFinished(paramWebView, paramString);
    }
  }
  
  public final void onPageStarted(android.webkit.WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(84687);
    Log.i("SysWebView", "onPageStarted ".concat(String.valueOf(paramString)));
    if (this.BHD.BHv != null)
    {
      this.BHD.BHv.b(this.BHD.BHt, paramString, paramBitmap);
      this.BHD.BHz = System.currentTimeMillis();
      f.ayi(paramString);
      f.dZd();
      if (this.BHD.BHA != null)
      {
        paramWebView = this.BHD.BHA;
        if (this.BHD.BHt.getFullscreenVideoKind() != WebView.a.BEn) {
          break label127;
        }
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      paramWebView.ao(true, bool);
      AppMethodBeat.o(84687);
      return;
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      break;
    }
  }
  
  public final void onReceivedError(android.webkit.WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(84694);
    if (this.BHD.BHv != null) {
      this.BHD.BHv.a(this.BHD.BHt, paramInt, paramString1, paramString2);
    }
    for (;;)
    {
      f.dZc();
      f.dZe();
      k.dYQ().dYX();
      AppMethodBeat.o(84694);
      return;
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
  }
  
  public final void onReceivedHttpError(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(84696);
    Object localObject;
    com.tencent.xweb.WebView localWebView;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = String.valueOf(paramWebResourceResponse.getStatusCode());
      Log.i("SysWebView", "onReceivedHttpError code:".concat(String.valueOf(localObject)));
      if (this.BHD.BHv == null) {
        break label168;
      }
      localObject = this.BHD.BHv;
      localWebView = this.BHD.BHt;
      paramWebResourceRequest = new c.e(paramWebResourceRequest);
      if (paramWebResourceResponse != null) {
        break label102;
      }
      paramWebView = null;
    }
    for (;;)
    {
      ((w)localObject).a(localWebView, paramWebResourceRequest, paramWebView);
      AppMethodBeat.o(84696);
      return;
      localObject = "Invalid";
      break;
      label102:
      if (Build.VERSION.SDK_INT >= 21) {
        paramWebView = new s(paramWebResourceResponse.getMimeType(), paramWebResourceResponse.getEncoding(), paramWebResourceResponse.getStatusCode(), paramWebResourceResponse.getReasonPhrase(), paramWebResourceResponse.getResponseHeaders(), paramWebResourceResponse.getData());
      } else {
        paramWebView = new s(paramWebResourceResponse.getMimeType(), paramWebResourceResponse.getEncoding(), paramWebResourceResponse.getData());
      }
    }
    label168:
    super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    AppMethodBeat.o(84696);
  }
  
  public final void onReceivedSslError(android.webkit.WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    AppMethodBeat.i(84695);
    Log.i("SysWebView", "onReceivedSslError " + paramSslError.getPrimaryError());
    if (this.BHD.BHv != null)
    {
      this.BHD.BHv.a(this.BHD.BHt, new c.a(paramSslErrorHandler), paramSslError);
      AppMethodBeat.o(84695);
      return;
    }
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    AppMethodBeat.o(84695);
  }
  
  public final void onScaleChanged(android.webkit.WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(84692);
    if (this.BHD.BHv != null)
    {
      this.BHD.BHv.a(this.BHD.BHt, paramFloat1, paramFloat2);
      AppMethodBeat.o(84692);
      return;
    }
    super.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
    AppMethodBeat.o(84692);
  }
  
  public final WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    Object localObject = null;
    AppMethodBeat.i(84691);
    if (this.BHD.BHv != null)
    {
      c.e locale = new c.e(paramWebResourceRequest);
      if (locale.BHo == null) {}
      for (paramWebResourceRequest = null;; paramWebResourceRequest = locale.BHo.getBundle())
      {
        paramWebView = localObject;
        if (paramWebResourceRequest != null) {
          paramWebView = this.BHD.BHv.a(this.BHD.BHt, locale, paramWebResourceRequest);
        }
        paramWebResourceRequest = paramWebView;
        if (paramWebView == null) {
          paramWebResourceRequest = this.BHD.BHv.a(this.BHD.BHt, locale);
        }
        paramWebView = c.a(paramWebResourceRequest);
        AppMethodBeat.o(84691);
        return paramWebView;
      }
    }
    paramWebView = super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
    AppMethodBeat.o(84691);
    return paramWebView;
  }
  
  public final WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(84690);
    if (this.BHD.BHv != null)
    {
      paramWebView = c.a(this.BHD.BHv.c(this.BHD.BHt, paramString));
      AppMethodBeat.o(84690);
      return paramWebView;
    }
    paramWebView = super.shouldInterceptRequest(paramWebView, paramString);
    AppMethodBeat.o(84690);
    return paramWebView;
  }
  
  public final boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(84686);
    Log.i("SysWebView", "shouldOverrideUrlLoading ".concat(String.valueOf(paramString)));
    if (this.BHD.BHv != null)
    {
      bool = this.BHD.BHv.a(this.BHD.BHt, paramString);
      AppMethodBeat.o(84686);
      return bool;
    }
    boolean bool = super.shouldOverrideUrlLoading(paramWebView, paramString);
    AppMethodBeat.o(84686);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.sys.e.1
 * JD-Core Version:    0.7.0.1
 */