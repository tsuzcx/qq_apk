package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.f;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;

final class FTSBaseWebViewUI$b
  extends k
{
  FTSBaseWebViewUI.b.a JnR;
  
  private FTSBaseWebViewUI$b(FTSBaseWebViewUI paramFTSBaseWebViewUI)
  {
    AppMethodBeat.i(211234);
    this.JnR = new FTSBaseWebViewUI.b.a(this, (byte)0);
    AppMethodBeat.o(211234);
  }
  
  private static WebResourceResponse aXq(String paramString)
  {
    AppMethodBeat.i(211236);
    Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    paramString = Uri.parse(paramString);
    try
    {
      paramString = s.openRead(paramString.getQueryParameter("path"));
      if (paramString != null)
      {
        paramString = new WebResourceResponse("image/*", "utf8", paramString);
        AppMethodBeat.o(211236);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      AppMethodBeat.o(211236);
    }
    return null;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(211235);
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
    {
      paramWebView = aXq(paramWebResourceRequest.getUrl().toString());
      AppMethodBeat.o(211235);
      return paramWebView;
    }
    AppMethodBeat.o(211235);
    return null;
  }
  
  public final f gai()
  {
    return this.JnR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */