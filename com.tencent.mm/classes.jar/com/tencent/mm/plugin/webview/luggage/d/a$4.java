package com.tencent.mm.plugin.webview.luggage.d;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.g.d;
import com.tencent.luggage.webview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.s;

final class a$4
  extends g
{
  a$4(a parama, a.a parama1) {}
  
  private s a(r paramr, Bundle paramBundle)
  {
    AppMethodBeat.i(6517);
    paramr = new b(paramr.getUrl(), paramr.isForMainFrame(), paramr.hasGesture(), paramr.getMethod(), paramr.getRequestHeaders());
    paramr = this.bFH.a(paramr, paramBundle);
    if (paramr != null)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramr = new s(paramr.getMimeType(), paramr.getEncoding(), paramr.getStatusCode(), paramr.getReasonPhrase(), paramr.getResponseHeaders(), paramr.getData());
        AppMethodBeat.o(6517);
        return paramr;
      }
      paramr = new s(paramr.getMimeType(), paramr.getEncoding(), paramr.getData());
      AppMethodBeat.o(6517);
      return paramr;
    }
    AppMethodBeat.o(6517);
    return null;
  }
  
  public final s a(WebView paramWebView, r paramr)
  {
    AppMethodBeat.i(6514);
    d.i("MicroMsg.LuggageMMWebViewCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramr.getUrl().toString() });
    s locals = a(paramr, new Bundle());
    if (locals != null)
    {
      AppMethodBeat.o(6514);
      return locals;
    }
    paramWebView = super.a(paramWebView, paramr);
    AppMethodBeat.o(6514);
    return paramWebView;
  }
  
  public final s a(WebView paramWebView, r paramr, Bundle paramBundle)
  {
    AppMethodBeat.i(6516);
    d.i("MicroMsg.LuggageMMWebViewCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramr.getUrl().toString() });
    paramBundle = a(paramr, paramBundle);
    if (paramBundle != null)
    {
      AppMethodBeat.o(6516);
      return paramBundle;
    }
    paramWebView = super.c(paramWebView, paramr.getUrl().toString());
    AppMethodBeat.o(6516);
    return paramWebView;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(6510);
    if (DownloadChecker.a(paramString, this.uUY.nYv, paramWebView))
    {
      ab.i("MicroMsg.LuggageMMWebViewCoreImpl", "use the downloader to download");
      AppMethodBeat.o(6510);
      return true;
    }
    if ((this.bFH.bD(paramString)) || (super.a(paramWebView, paramString)))
    {
      AppMethodBeat.o(6510);
      return true;
    }
    AppMethodBeat.o(6510);
    return false;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(6512);
    this.bFH.bF(paramString);
    super.b(paramWebView, paramString);
    AppMethodBeat.o(6512);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(6511);
    this.bFH.bE(paramString);
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(6511);
  }
  
  public final s c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(6515);
    d.i("MicroMsg.LuggageMMWebViewCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramString });
    Object localObject = this.bFH.bG(paramString);
    if (localObject != null) {
      if (Build.VERSION.SDK_INT >= 21) {
        localObject = new s(((WebResourceResponse)localObject).getMimeType(), ((WebResourceResponse)localObject).getEncoding(), ((WebResourceResponse)localObject).getStatusCode(), ((WebResourceResponse)localObject).getReasonPhrase(), ((WebResourceResponse)localObject).getResponseHeaders(), ((WebResourceResponse)localObject).getData());
      }
    }
    while (localObject != null)
    {
      AppMethodBeat.o(6515);
      return localObject;
      localObject = new s(((WebResourceResponse)localObject).getMimeType(), ((WebResourceResponse)localObject).getEncoding(), ((WebResourceResponse)localObject).getData());
      continue;
      localObject = null;
    }
    paramWebView = super.c(paramWebView, paramString);
    AppMethodBeat.o(6515);
    return paramWebView;
  }
  
  public final void h(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(6513);
    this.bFH.bI(paramString);
    super.h(paramWebView, paramString);
    AppMethodBeat.o(6513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.a.4
 * JD-Core Version:    0.7.0.1
 */