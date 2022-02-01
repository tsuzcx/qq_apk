package com.tencent.mm.plugin.websearch.webview;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.au;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ag;
import com.tencent.xweb.an;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchClient;", "Lcom/tencent/xweb/WebViewClient;", "templateType", "", "(I)V", "TAG", "", "handleRequest", "Lcom/tencent/xweb/WebResourceResponse;", "view", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "shouldInterceptRequest", "bundle", "Landroid/os/Bundle;", "wrapResponse", "url", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public class j
  extends ag
{
  private final String TAG;
  private final int phR;
  
  public j(int paramInt)
  {
    this.phR = paramInt;
    this.TAG = "MicroMsg.WebSearch.WebSearchClient";
  }
  
  private final WebResourceResponse biK(String paramString)
  {
    AppMethodBeat.i(315252);
    Log.i(this.TAG, "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    paramString = Uri.parse(paramString);
    try
    {
      paramString = paramString.getQueryParameter("path");
      if (paramString == null) {
        break label80;
      }
      paramString = y.Lh(paramString);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      AppMethodBeat.o(315252);
    }
    if (paramString != null)
    {
      paramString = new WebResourceResponse("image/*", "utf8", paramString);
      AppMethodBeat.o(315252);
      return paramString;
    }
    label80:
    return null;
  }
  
  private final WebResourceResponse d(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(315248);
    if (paramWebResourceRequest != null)
    {
      paramWebResourceRequest = paramWebResourceRequest.getUrl();
      if (paramWebResourceRequest != null)
      {
        String str = paramWebResourceRequest.toString();
        if (str != null)
        {
          if (n.U(str, "weixin://fts", false)) {}
          for (paramWebResourceRequest = str; paramWebResourceRequest != null; paramWebResourceRequest = null)
          {
            paramWebView = biK(paramWebResourceRequest);
            AppMethodBeat.o(315248);
            return paramWebView;
          }
          if (this.phR >= 0)
          {
            au localau;
            if ((paramWebView != null) && (paramWebView.supportFeature(2002) == true))
            {
              i = 1;
              if ((i == 0) || (Util.isNullOrNil(str)) || (str.length() <= 7)) {
                break label392;
              }
              localau = aj.asW(this.phR);
              paramWebResourceRequest = Integer.valueOf(n.a((CharSequence)str, "?", 0, false, 6));
              if (((Number)paramWebResourceRequest).intValue() <= 7) {
                break label345;
              }
              i = 1;
              label154:
              if (i == 0) {
                break label350;
              }
              label158:
              if (paramWebResourceRequest != null) {
                break label355;
              }
            }
            label345:
            label350:
            label355:
            for (int i = str.length();; i = paramWebResourceRequest.intValue())
            {
              paramWebResourceRequest = str.substring(7, i);
              s.s(paramWebResourceRequest, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              str = (String)localau.iqt().get(paramWebResourceRequest);
              if (str == null) {
                break label392;
              }
              if (Util.isNullOrNil(str)) {
                break label363;
              }
              Log.i(this.TAG, "hit js xweb script %s %s", new Object[] { str, paramWebResourceRequest });
              paramWebView = new an(2, 0, paramWebView);
              paramWebView.mgR = (paramWebResourceRequest + '.' + str);
              paramWebView.qU(paramWebResourceRequest, "path");
              paramWebView = paramWebView.toString();
              s.s(paramWebView, "script.toString()");
              paramWebResourceRequest = StandardCharsets.UTF_8;
              s.s(paramWebResourceRequest, "UTF_8");
              paramWebView = paramWebView.getBytes(paramWebResourceRequest);
              s.s(paramWebView, "(this as java.lang.String).getBytes(charset)");
              paramWebView = new WebResourceResponse(null, "UTF-8", (InputStream)new ByteArrayInputStream(paramWebView));
              AppMethodBeat.o(315248);
              return paramWebView;
              i = 0;
              break;
              i = 0;
              break label154;
              paramWebResourceRequest = null;
              break label158;
            }
            label363:
            Log.i(this.TAG, "not hit js xweb script %s %s", new Object[] { str, paramWebResourceRequest });
            AppMethodBeat.o(315248);
            return null;
          }
          label392:
          AppMethodBeat.o(315248);
          return null;
        }
      }
    }
    AppMethodBeat.o(315248);
    return null;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(315254);
    WebResourceResponse localWebResourceResponse = d(paramWebView, paramWebResourceRequest);
    if (localWebResourceResponse == null)
    {
      paramWebView = super.a(paramWebView, paramWebResourceRequest);
      AppMethodBeat.o(315254);
      return paramWebView;
    }
    AppMethodBeat.o(315254);
    return localWebResourceResponse;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(315261);
    WebResourceResponse localWebResourceResponse = d(paramWebView, paramWebResourceRequest);
    if (localWebResourceResponse == null)
    {
      paramWebView = super.a(paramWebView, paramWebResourceRequest, paramBundle);
      AppMethodBeat.o(315261);
      return paramWebView;
    }
    AppMethodBeat.o(315261);
    return localWebResourceResponse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.j
 * JD-Core Version:    0.7.0.1
 */