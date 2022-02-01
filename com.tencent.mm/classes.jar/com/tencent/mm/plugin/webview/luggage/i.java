package com.tencent.mm.plugin.webview.luggage;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.r;

public class i
  extends ac
{
  private ac Ban;
  
  public i()
  {
    AppMethodBeat.i(78342);
    this.Ban = new ac();
    AppMethodBeat.o(78342);
  }
  
  public WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(78349);
    paramWebView = this.Ban.a(paramWebView, paramWebResourceRequest);
    AppMethodBeat.o(78349);
    return paramWebView;
  }
  
  public WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(78350);
    paramWebView = this.Ban.a(paramWebView, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(78350);
    return paramWebView;
  }
  
  public final void a(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(78353);
    this.Ban.a(paramWebView, paramFloat1, paramFloat2);
    AppMethodBeat.o(78353);
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(78346);
    this.Ban.a(paramWebView, paramInt, paramString1, paramString2);
    AppMethodBeat.o(78346);
  }
  
  public void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(78354);
    this.Ban.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    AppMethodBeat.o(78354);
  }
  
  public void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    AppMethodBeat.i(78352);
    this.Ban.a(paramWebView, paramr, paramSslError);
    AppMethodBeat.o(78352);
  }
  
  public final void a(ac paramac)
  {
    if (paramac != null) {
      this.Ban = paramac;
    }
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(78347);
    boolean bool = this.Ban.a(paramWebView, paramString);
    AppMethodBeat.o(78347);
    return bool;
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(78345);
    this.Ban.b(paramWebView, paramString);
    AppMethodBeat.o(78345);
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(78344);
    this.Ban.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(78344);
  }
  
  public final void b(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78351);
    this.Ban.b(paramWebView, paramString, paramBoolean);
    AppMethodBeat.o(78351);
  }
  
  public WebResourceResponse c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(78348);
    paramWebView = this.Ban.c(paramWebView, paramString);
    AppMethodBeat.o(78348);
    return paramWebView;
  }
  
  public final boolean e(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(210916);
    boolean bool = this.Ban.e(paramWebView, paramWebResourceRequest);
    AppMethodBeat.o(210916);
    return bool;
  }
  
  public void h(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(78343);
    this.Ban.h(paramWebView, paramString);
    AppMethodBeat.o(78343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i
 * JD-Core Version:    0.7.0.1
 */