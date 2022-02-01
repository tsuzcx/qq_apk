package com.tencent.mm.plugin.websearch.webview;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchClient;", "Lcom/tencent/xweb/WebViewClient;", "templateType", "", "(I)V", "TAG", "", "handleRequest", "Lcom/tencent/xweb/WebResourceResponse;", "view", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "shouldInterceptRequest", "bundle", "Landroid/os/Bundle;", "wrapResponse", "url", "ui-websearch_release"})
public class f
  extends ad
{
  private final String TAG;
  private final int mod;
  
  public f(byte paramByte)
  {
    this();
  }
  
  public f(int paramInt)
  {
    this.mod = paramInt;
    this.TAG = "MicroMsg.WebSearch.WebSearchClient";
  }
  
  private final WebResourceResponse bjb(String paramString)
  {
    AppMethodBeat.i(198557);
    String str = this.TAG;
    Thread localThread = Thread.currentThread();
    p.j(localThread, "Thread.currentThread()");
    Log.i(str, "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(localThread.getId()) });
    paramString = Uri.parse(paramString);
    try
    {
      paramString = paramString.getQueryParameter("path");
      if (paramString == null) {
        p.iCn();
      }
      paramString = u.Tf(paramString);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      AppMethodBeat.o(198557);
    }
    if (paramString != null)
    {
      paramString = new WebResourceResponse("image/*", "utf8", paramString);
      AppMethodBeat.o(198557);
      return paramString;
    }
    return null;
  }
  
  private final WebResourceResponse d(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(198556);
    if (paramWebResourceRequest != null)
    {
      paramWebResourceRequest = paramWebResourceRequest.getUrl();
      if (paramWebResourceRequest != null)
      {
        paramWebResourceRequest = paramWebResourceRequest.toString();
        if (paramWebResourceRequest != null)
        {
          p.j(paramWebResourceRequest, "it");
          if (n.M(paramWebResourceRequest, "weixin://fts", false)) {}
          for (Object localObject = paramWebResourceRequest; localObject != null; localObject = null)
          {
            p.j(localObject, "it");
            paramWebView = bjb((String)localObject);
            AppMethodBeat.o(198556);
            return paramWebView;
          }
          if (this.mod >= 0)
          {
            localObject = com.tencent.mm.plugin.websearch.api.ai.anf(this.mod);
            p.j(paramWebResourceRequest, "it");
            StringBuilder localStringBuilder = new StringBuilder("file://");
            p.j(localObject, "webSearchTemplate");
            if (n.M(paramWebResourceRequest, ((at)localObject).gRh(), false)) {}
            while (paramWebResourceRequest != null)
            {
              paramWebResourceRequest = ((at)localObject).gRi();
              if (!Util.isNullOrNil(paramWebResourceRequest))
              {
                Log.i(this.TAG, "hit js xweb script %s", new Object[] { paramWebResourceRequest });
                paramWebView = new com.tencent.xweb.ai(2, 0, paramWebView);
                paramWebView.setCacheKey(((at)localObject).gRh() + "." + paramWebResourceRequest);
                paramWebView.bFn(((at)localObject).gRh());
                paramWebView = paramWebView.toString();
                p.j(paramWebView, "script.toString()");
                paramWebResourceRequest = StandardCharsets.UTF_8;
                p.j(paramWebResourceRequest, "StandardCharsets.UTF_8");
                if (paramWebView == null)
                {
                  paramWebView = new t("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(198556);
                  throw paramWebView;
                  paramWebResourceRequest = null;
                }
                else
                {
                  paramWebView = paramWebView.getBytes(paramWebResourceRequest);
                  p.j(paramWebView, "(this as java.lang.String).getBytes(charset)");
                  paramWebView = new WebResourceResponse(null, "UTF-8", (InputStream)new ByteArrayInputStream(paramWebView));
                  AppMethodBeat.o(198556);
                  return paramWebView;
                }
              }
              else
              {
                AppMethodBeat.o(198556);
                return null;
              }
            }
          }
          AppMethodBeat.o(198556);
          return null;
        }
      }
    }
    AppMethodBeat.o(198556);
    return null;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(198550);
    WebResourceResponse localWebResourceResponse2 = d(paramWebView, paramWebResourceRequest);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest);
    }
    AppMethodBeat.o(198550);
    return localWebResourceResponse1;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(198551);
    WebResourceResponse localWebResourceResponse2 = d(paramWebView, paramWebResourceRequest);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest, paramBundle);
    }
    AppMethodBeat.o(198551);
    return localWebResourceResponse1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.f
 * JD-Core Version:    0.7.0.1
 */