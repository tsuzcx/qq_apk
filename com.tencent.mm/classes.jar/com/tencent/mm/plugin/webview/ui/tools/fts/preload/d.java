package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.webview.jsapi.k;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "", "biz", "", "url", "", "(ILjava/lang/String;)V", "getBiz", "()I", "proxy", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandlerProxy;", "getProxy", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandlerProxy;", "setProxy", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandlerProxy;)V", "scene", "getScene", "setScene", "(I)V", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "getUrl", "webView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "getWebView", "()Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "setWebView", "(Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;)V", "webViewReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getWebViewReady", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setWebViewReady", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public WebSearchWebView TPU;
  public k WpJ;
  AtomicBoolean Xfn;
  final int biz;
  private int scene;
  private String sessionId;
  private final String url;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(296985);
    this.biz = paramInt;
    this.url = paramString;
    this.sessionId = "";
    this.Xfn = new AtomicBoolean(false);
    paramString = Uri.parse(this.url);
    for (;;)
    {
      try
      {
        str = paramString.getQueryParameter("scene");
        if (str != null) {
          continue;
        }
        paramInt = i;
        this.scene = paramInt;
      }
      catch (Exception localException)
      {
        String str;
        continue;
      }
      paramString = paramString.getQueryParameter("sessionId");
      if (paramString != null)
      {
        s.u(paramString, "<set-?>");
        this.sessionId = paramString;
      }
      AppMethodBeat.o(296985);
      return;
      paramInt = Integer.parseInt(str);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(297006);
    if (this == paramObject)
    {
      AppMethodBeat.o(297006);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(297006);
      return false;
    }
    paramObject = (d)paramObject;
    if (this.biz != paramObject.biz)
    {
      AppMethodBeat.o(297006);
      return false;
    }
    if (!s.p(this.url, paramObject.url))
    {
      AppMethodBeat.o(297006);
      return false;
    }
    AppMethodBeat.o(297006);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(296999);
    int i = this.biz;
    int j = this.url.hashCode();
    AppMethodBeat.o(296999);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(296994);
    String str = "WebSearchPreloadObj(biz=" + this.biz + ", url=" + this.url + ')';
    AppMethodBeat.o(296994);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.preload.d
 * JD-Core Version:    0.7.0.1
 */