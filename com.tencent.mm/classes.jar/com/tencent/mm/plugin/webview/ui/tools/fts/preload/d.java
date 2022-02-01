package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.webview.d.i;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "", "biz", "", "url", "", "(ILjava/lang/String;)V", "getBiz", "()I", "proxy", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandlerProxy;", "getProxy", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandlerProxy;", "setProxy", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandlerProxy;)V", "scene", "getScene", "setScene", "(I)V", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "getUrl", "webView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "getWebView", "()Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "setWebView", "(Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;)V", "webViewReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getWebViewReady", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setWebViewReady", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-webview_release"})
public final class d
{
  public WebSearchWebView Ndj;
  public i PzB;
  AtomicBoolean QmX;
  final int ppO;
  private int scene;
  private String sessionId;
  private final String url;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(216504);
    this.ppO = paramInt;
    this.url = paramString;
    this.sessionId = "";
    this.QmX = new AtomicBoolean(false);
    paramString = Uri.parse(this.url);
    for (;;)
    {
      try
      {
        String str = paramString.getQueryParameter("scene");
        if (str == null) {
          continue;
        }
        paramInt = Integer.parseInt(str);
        this.scene = paramInt;
      }
      catch (Exception localException)
      {
        continue;
      }
      paramString = paramString.getQueryParameter("sessionId");
      if (paramString == null) {
        continue;
      }
      p.j(paramString, "it");
      this.sessionId = paramString;
      AppMethodBeat.o(216504);
      return;
      paramInt = i;
    }
    AppMethodBeat.o(216504);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216510);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.ppO != paramObject.ppO) || (!p.h(this.url, paramObject.url))) {}
      }
    }
    else
    {
      AppMethodBeat.o(216510);
      return true;
    }
    AppMethodBeat.o(216510);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(216508);
    int j = this.ppO;
    String str = this.url;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(216508);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216506);
    String str = "WebSearchPreloadObj(biz=" + this.ppO + ", url=" + this.url + ")";
    AppMethodBeat.o(216506);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.preload.d
 * JD-Core Version:    0.7.0.1
 */