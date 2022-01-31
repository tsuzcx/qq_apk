package com.tencent.mm.plugin.webview.luggage;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.m;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.w;

public class g
  extends w
{
  private w pvo;
  
  public g()
  {
    AppMethodBeat.i(6106);
    this.pvo = new w();
    AppMethodBeat.o(6106);
  }
  
  public s a(WebView paramWebView, r paramr)
  {
    AppMethodBeat.i(6113);
    paramWebView = this.pvo.a(paramWebView, paramr);
    AppMethodBeat.o(6113);
    return paramWebView;
  }
  
  public s a(WebView paramWebView, r paramr, Bundle paramBundle)
  {
    AppMethodBeat.i(6114);
    paramWebView = this.pvo.a(paramWebView, paramr, paramBundle);
    AppMethodBeat.o(6114);
    return paramWebView;
  }
  
  public final void a(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(6117);
    this.pvo.a(paramWebView, paramFloat1, paramFloat2);
    AppMethodBeat.o(6117);
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(6110);
    this.pvo.a(paramWebView, paramInt, paramString1, paramString2);
    AppMethodBeat.o(6110);
  }
  
  public void a(WebView paramWebView, m paramm, SslError paramSslError)
  {
    AppMethodBeat.i(6116);
    this.pvo.a(paramWebView, paramm, paramSslError);
    AppMethodBeat.o(6116);
  }
  
  public void a(WebView paramWebView, r paramr, s params)
  {
    AppMethodBeat.i(6118);
    this.pvo.a(paramWebView, paramr, params);
    AppMethodBeat.o(6118);
  }
  
  public final void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6115);
    this.pvo.a(paramWebView, paramString, paramBoolean);
    AppMethodBeat.o(6115);
  }
  
  public final void a(w paramw)
  {
    if (paramw != null) {
      this.pvo = paramw;
    }
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(6111);
    boolean bool = this.pvo.a(paramWebView, paramString);
    AppMethodBeat.o(6111);
    return bool;
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(6109);
    this.pvo.b(paramWebView, paramString);
    AppMethodBeat.o(6109);
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(6108);
    this.pvo.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(6108);
  }
  
  public s c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(6112);
    paramWebView = this.pvo.c(paramWebView, paramString);
    AppMethodBeat.o(6112);
    return paramWebView;
  }
  
  public void h(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(6107);
    this.pvo.h(paramWebView, paramString);
    AppMethodBeat.o(6107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.g
 * JD-Core Version:    0.7.0.1
 */