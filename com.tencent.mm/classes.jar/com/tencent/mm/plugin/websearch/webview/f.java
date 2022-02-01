package com.tencent.mm.plugin.websearch.webview;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.ag;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchClient;", "Lcom/tencent/xweb/WebViewClient;", "templateType", "", "(I)V", "TAG", "", "handleRequest", "Lcom/tencent/xweb/WebResourceResponse;", "view", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "shouldInterceptRequest", "bundle", "Landroid/os/Bundle;", "wrapResponse", "url", "ui-websearch_release"})
public class f
  extends ac
{
  private final String TAG;
  private final int jyz;
  
  public f(byte paramByte)
  {
    this();
  }
  
  public f(int paramInt)
  {
    this.jyz = paramInt;
    this.TAG = "MicroMsg.WebSearch.WebSearchClient";
  }
  
  private final WebResourceResponse aXq(String paramString)
  {
    AppMethodBeat.i(198062);
    String str = this.TAG;
    Thread localThread = Thread.currentThread();
    p.g(localThread, "Thread.currentThread()");
    Log.i(str, "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(localThread.getId()) });
    paramString = Uri.parse(paramString);
    try
    {
      paramString = paramString.getQueryParameter("path");
      if (paramString == null) {
        p.hyc();
      }
      paramString = s.openRead(paramString);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      AppMethodBeat.o(198062);
    }
    if (paramString != null)
    {
      paramString = new WebResourceResponse("image/*", "utf8", paramString);
      AppMethodBeat.o(198062);
      return paramString;
    }
    return null;
  }
  
  private final WebResourceResponse d(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(198061);
    if (paramWebResourceRequest != null)
    {
      paramWebResourceRequest = paramWebResourceRequest.getUrl();
      if (paramWebResourceRequest != null)
      {
        paramWebResourceRequest = paramWebResourceRequest.toString();
        if (paramWebResourceRequest != null)
        {
          p.g(paramWebResourceRequest, "it");
          if (n.J(paramWebResourceRequest, "weixin://fts", false)) {}
          for (Object localObject = paramWebResourceRequest; localObject != null; localObject = null)
          {
            p.g(localObject, "it");
            paramWebView = aXq((String)localObject);
            AppMethodBeat.o(198061);
            return paramWebView;
          }
          if (this.jyz >= 0)
          {
            localObject = ai.afr(this.jyz);
            p.g(paramWebResourceRequest, "it");
            StringBuilder localStringBuilder = new StringBuilder("file://");
            p.g(localObject, "webSearchTemplate");
            if (n.J(paramWebResourceRequest, ((at)localObject).fYw(), false)) {}
            while (paramWebResourceRequest != null)
            {
              paramWebResourceRequest = ((at)localObject).fYx();
              if (!Util.isNullOrNil(paramWebResourceRequest))
              {
                Log.i(this.TAG, "hit js xweb script %s", new Object[] { paramWebResourceRequest });
                paramWebView = new ag(2, 0, paramWebView);
                paramWebView.setCacheKey(((at)localObject).fYw() + "." + paramWebResourceRequest);
                paramWebView.bso(((at)localObject).fYw());
                paramWebView = paramWebView.toString();
                p.g(paramWebView, "script.toString()");
                paramWebResourceRequest = StandardCharsets.UTF_8;
                p.g(paramWebResourceRequest, "StandardCharsets.UTF_8");
                if (paramWebView == null)
                {
                  paramWebView = new t("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(198061);
                  throw paramWebView;
                  paramWebResourceRequest = null;
                }
                else
                {
                  paramWebView = paramWebView.getBytes(paramWebResourceRequest);
                  p.g(paramWebView, "(this as java.lang.String).getBytes(charset)");
                  paramWebView = new WebResourceResponse(null, "UTF-8", (InputStream)new ByteArrayInputStream(paramWebView));
                  AppMethodBeat.o(198061);
                  return paramWebView;
                }
              }
              else
              {
                AppMethodBeat.o(198061);
                return null;
              }
            }
          }
          AppMethodBeat.o(198061);
          return null;
        }
      }
    }
    AppMethodBeat.o(198061);
    return null;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(198059);
    WebResourceResponse localWebResourceResponse2 = d(paramWebView, paramWebResourceRequest);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest);
    }
    AppMethodBeat.o(198059);
    return localWebResourceResponse1;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(198060);
    WebResourceResponse localWebResourceResponse2 = d(paramWebView, paramWebResourceRequest);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest, paramBundle);
    }
    AppMethodBeat.o(198060);
    return localWebResourceResponse1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.f
 * JD-Core Version:    0.7.0.1
 */