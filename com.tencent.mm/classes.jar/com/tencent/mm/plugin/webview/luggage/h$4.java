package com.tencent.mm.plugin.webview.luggage;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.j.c;
import com.tencent.luggage.webview.a.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;

final class h$4
  extends g
{
  h$4(h paramh, a.a parama) {}
  
  private m RK(String paramString)
  {
    paramString = this.bjP.bf(paramString);
    if (paramString != null)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return new m(paramString.getMimeType(), paramString.getEncoding(), paramString.getStatusCode(), paramString.getReasonPhrase(), paramString.getResponseHeaders(), paramString.getData());
      }
      return new m(paramString.getMimeType(), paramString.getEncoding(), paramString.getData());
    }
    return null;
  }
  
  public final m a(WebView paramWebView, l paraml)
  {
    c.i("MicroMsg.LuggageMMWebViewCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paraml.getUrl().toString() });
    m localm = RK(paraml.getUrl().toString());
    if (localm != null) {
      return localm;
    }
    return super.a(paramWebView, paraml);
  }
  
  public final m a(WebView paramWebView, l paraml, Bundle paramBundle)
  {
    c.i("MicroMsg.LuggageMMWebViewCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paraml.getUrl().toString() });
    paramBundle = RK(paraml.getUrl().toString());
    if (paramBundle != null) {
      return paramBundle;
    }
    return super.c(paramWebView, paraml.getUrl().toString());
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    this.bjP.bd(paramString);
    h.a(this.rcn);
    super.a(paramWebView, paramString);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.bjP.bc(paramString);
    h.a(this.rcn);
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    return (this.bjP.be(paramString)) || (super.b(paramWebView, paramString));
  }
  
  public final m c(WebView paramWebView, String paramString)
  {
    c.i("MicroMsg.LuggageMMWebViewCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramString });
    m localm = RK(paramString);
    if (localm != null) {
      return localm;
    }
    return super.c(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.4
 * JD-Core Version:    0.7.0.1
 */