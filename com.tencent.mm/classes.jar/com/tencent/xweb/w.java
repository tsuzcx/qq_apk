package com.tencent.xweb;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.f;

public class w
{
  public f BDF;
  
  public s a(WebView paramWebView, r paramr)
  {
    return null;
  }
  
  public s a(WebView paramWebView, r paramr, Bundle paramBundle)
  {
    return null;
  }
  
  public void a(WebView paramWebView, float paramFloat1, float paramFloat2) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, m paramm, SslError paramSslError)
  {
    AppMethodBeat.i(3943);
    if (paramm != null) {
      paramm.cancel();
    }
    AppMethodBeat.o(3943);
  }
  
  public void a(WebView paramWebView, r paramr, s params) {}
  
  public void a(WebView paramWebView, String paramString, boolean paramBoolean) {}
  
  public boolean a(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public void b(WebView paramWebView, String paramString) {}
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(3942);
    if (this.BDF == null)
    {
      AppMethodBeat.o(3942);
      return;
    }
    this.BDF.w(paramString, paramBitmap);
    AppMethodBeat.o(3942);
  }
  
  public boolean b(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    return false;
  }
  
  public s c(WebView paramWebView, String paramString)
  {
    return null;
  }
  
  public void h(WebView paramWebView, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.w
 * JD-Core Version:    0.7.0.1
 */