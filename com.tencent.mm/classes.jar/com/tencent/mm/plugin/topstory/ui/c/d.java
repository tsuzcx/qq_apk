package com.tencent.mm.plugin.topstory.ui.c;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.protocal.protobuf.esk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public final class d
  extends ad
{
  private c Ndi;
  private esk fYA;
  
  public d(esk paramesk, c paramc)
  {
    this.fYA = paramesk;
    this.Ndi = paramc;
  }
  
  private static WebResourceResponse j(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(204867);
    if (!((b)h.ag(b.class)).openJsAccelerate())
    {
      AppMethodBeat.o(204867);
      return null;
    }
    if (!paramWebView.supportFeature(2002))
    {
      AppMethodBeat.o(204867);
      return null;
    }
    at localat = com.tencent.mm.plugin.websearch.api.ai.anf(1);
    if (paramString.startsWith("file://" + localat.gRh()))
    {
      paramString = localat.gRi();
      if (!Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.TopStory.TopStoryWebViewClient", "hit js xweb script %s", new Object[] { paramString });
        paramWebView = new com.tencent.xweb.ai(2, 0, paramWebView);
        paramWebView.cacheKey = (localat.gRh() + "." + paramString);
        paramWebView.oY(localat.gRh(), "path");
        paramWebView = new WebResourceResponse(null, "UTF-8", new ByteArrayInputStream(paramWebView.toString().getBytes(StandardCharsets.UTF_8)));
        AppMethodBeat.o(204867);
        return paramWebView;
      }
      AppMethodBeat.o(204867);
      return null;
    }
    AppMethodBeat.o(204867);
    return null;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(204863);
    WebResourceResponse localWebResourceResponse = j(paramWebView, paramWebResourceRequest.getUrl().toString());
    if (localWebResourceResponse != null)
    {
      AppMethodBeat.o(204863);
      return localWebResourceResponse;
    }
    paramWebView = super.a(paramWebView, paramWebResourceRequest);
    AppMethodBeat.o(204863);
    return paramWebView;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(204865);
    WebResourceResponse localWebResourceResponse = j(paramWebView, paramWebResourceRequest.getUrl().toString());
    if (localWebResourceResponse != null)
    {
      AppMethodBeat.o(204865);
      return localWebResourceResponse;
    }
    paramWebView = super.a(paramWebView, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(204865);
    return paramWebView;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(126576);
    Log.i("MicroMsg.TopStory.TopStoryWebViewClient", "shouldOverrideUrlLoading %s", new Object[] { paramString });
    boolean bool = super.a(paramWebView, paramString);
    AppMethodBeat.o(126576);
    return bool;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(126575);
    Log.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageFinished %s  %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString);
    com.tencent.mm.plugin.topstory.ui.d.c(this.fYA, "pageFinish", System.currentTimeMillis());
    AppMethodBeat.o(126575);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(126574);
    com.tencent.mm.plugin.topstory.ui.d.c(this.fYA, "pageStart", System.currentTimeMillis());
    Log.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageStarted %s %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(126574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c.d
 * JD-Core Version:    0.7.0.1
 */