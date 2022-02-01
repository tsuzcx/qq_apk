package com.tencent.mm.plugin.topstory.ui.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.ag;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public final class d
  extends ac
{
  private c BPR;
  private dom dMt;
  
  public d(dom paramdom, c paramc)
  {
    this.dMt = paramdom;
    this.BPR = paramc;
  }
  
  private static WebResourceResponse i(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(220249);
    if (!((b)g.ad(b.class)).openJsAccelerate())
    {
      AppMethodBeat.o(220249);
      return null;
    }
    if (!paramWebView.supportFeature(2002))
    {
      AppMethodBeat.o(220249);
      return null;
    }
    ao localao = ad.WJ(1);
    if (paramString.startsWith("file://" + localao.eQj()))
    {
      paramString = localao.eQk();
      if (!bu.isNullOrNil(paramString))
      {
        ae.i("MicroMsg.TopStory.TopStoryWebViewClient", "hit js xweb script %s", new Object[] { paramString });
        paramWebView = new ag(2, 0, paramWebView);
        paramWebView.cacheKey = (localao.eQj() + "." + paramString);
        paramWebView.nh(localao.eQj(), "path");
        paramWebView = new WebResourceResponse(null, "UTF-8", new ByteArrayInputStream(paramWebView.toString().getBytes(StandardCharsets.UTF_8)));
        AppMethodBeat.o(220249);
        return paramWebView;
      }
      AppMethodBeat.o(220249);
      return null;
    }
    AppMethodBeat.o(220249);
    return null;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(220247);
    WebResourceResponse localWebResourceResponse = i(paramWebView, paramWebResourceRequest.getUrl().toString());
    if (localWebResourceResponse != null)
    {
      AppMethodBeat.o(220247);
      return localWebResourceResponse;
    }
    paramWebView = super.a(paramWebView, paramWebResourceRequest);
    AppMethodBeat.o(220247);
    return paramWebView;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(220248);
    WebResourceResponse localWebResourceResponse = i(paramWebView, paramWebResourceRequest.getUrl().toString());
    if (localWebResourceResponse != null)
    {
      AppMethodBeat.o(220248);
      return localWebResourceResponse;
    }
    paramWebView = super.a(paramWebView, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(220248);
    return paramWebView;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(126576);
    ae.i("MicroMsg.TopStory.TopStoryWebViewClient", "shouldOverrideUrlLoading %s", new Object[] { paramString });
    boolean bool = super.a(paramWebView, paramString);
    AppMethodBeat.o(126576);
    return bool;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(126575);
    ae.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageFinished %s  %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString);
    com.tencent.mm.plugin.topstory.ui.d.c(this.dMt, "pageFinish", System.currentTimeMillis());
    AppMethodBeat.o(126575);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(126574);
    com.tencent.mm.plugin.topstory.ui.d.c(this.dMt, "pageStart", System.currentTimeMillis());
    ae.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageStarted %s %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(126574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.d
 * JD-Core Version:    0.7.0.1
 */