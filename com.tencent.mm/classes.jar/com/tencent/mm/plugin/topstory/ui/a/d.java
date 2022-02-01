package com.tencent.mm.plugin.topstory.ui.a;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  private c Gqx;
  private eii eel;
  
  public d(eii parameii, c paramc)
  {
    this.eel = parameii;
    this.Gqx = paramc;
  }
  
  private static WebResourceResponse j(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(236406);
    if (!((b)g.ah(b.class)).openJsAccelerate())
    {
      AppMethodBeat.o(236406);
      return null;
    }
    if (!paramWebView.supportFeature(2002))
    {
      AppMethodBeat.o(236406);
      return null;
    }
    at localat = ai.afr(1);
    if (paramString.startsWith("file://" + localat.fYw()))
    {
      paramString = localat.fYx();
      if (!Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.TopStory.TopStoryWebViewClient", "hit js xweb script %s", new Object[] { paramString });
        paramWebView = new ag(2, 0, paramWebView);
        paramWebView.cacheKey = (localat.fYw() + "." + paramString);
        paramWebView.oc(localat.fYw(), "path");
        paramWebView = new WebResourceResponse(null, "UTF-8", new ByteArrayInputStream(paramWebView.toString().getBytes(StandardCharsets.UTF_8)));
        AppMethodBeat.o(236406);
        return paramWebView;
      }
      AppMethodBeat.o(236406);
      return null;
    }
    AppMethodBeat.o(236406);
    return null;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(236404);
    WebResourceResponse localWebResourceResponse = j(paramWebView, paramWebResourceRequest.getUrl().toString());
    if (localWebResourceResponse != null)
    {
      AppMethodBeat.o(236404);
      return localWebResourceResponse;
    }
    paramWebView = super.a(paramWebView, paramWebResourceRequest);
    AppMethodBeat.o(236404);
    return paramWebView;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(236405);
    WebResourceResponse localWebResourceResponse = j(paramWebView, paramWebResourceRequest.getUrl().toString());
    if (localWebResourceResponse != null)
    {
      AppMethodBeat.o(236405);
      return localWebResourceResponse;
    }
    paramWebView = super.a(paramWebView, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(236405);
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
    com.tencent.mm.plugin.topstory.ui.c.c(this.eel, "pageFinish", System.currentTimeMillis());
    AppMethodBeat.o(126575);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(126574);
    com.tencent.mm.plugin.topstory.ui.c.c(this.eel, "pageStart", System.currentTimeMillis());
    Log.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageStarted %s %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(126574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.d
 * JD-Core Version:    0.7.0.1
 */