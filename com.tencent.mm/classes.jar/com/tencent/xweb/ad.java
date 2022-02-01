package com.tencent.xweb;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.e;

public class ad
{
  public e aaaF;
  
  public WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return null;
  }
  
  public WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    return null;
  }
  
  public void a(WebView paramWebView, float paramFloat1, float paramFloat2) {}
  
  @Deprecated
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse) {}
  
  public void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, z paramz) {}
  
  public void a(WebView paramWebView, j paramj, String paramString1, String paramString2)
  {
    AppMethodBeat.i(196877);
    paramj.cancel();
    AppMethodBeat.o(196877);
  }
  
  public void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    AppMethodBeat.i(156921);
    if (paramr != null) {
      paramr.cancel();
    }
    AppMethodBeat.o(156921);
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public void b(WebView paramWebView, String paramString) {}
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(156919);
    if (this.aaaF == null)
    {
      AppMethodBeat.o(156919);
      return;
    }
    this.aaaF.y(paramString, paramBitmap);
    AppMethodBeat.o(156919);
  }
  
  public void b(WebView paramWebView, String paramString, boolean paramBoolean) {}
  
  public boolean b(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    return false;
  }
  
  public WebResourceResponse c(WebView paramWebView, String paramString)
  {
    return null;
  }
  
  public void e(WebView paramWebView, String paramString) {}
  
  public boolean e(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(156920);
    if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null))
    {
      AppMethodBeat.o(156920);
      return false;
    }
    boolean bool = a(paramWebView, paramWebResourceRequest.getUrl().toString());
    AppMethodBeat.o(156920);
    return bool;
  }
  
  public void i(WebView paramWebView, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.ad
 * JD-Core Version:    0.7.0.1
 */