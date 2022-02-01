package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.webview.d.i;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "", "biz", "", "url", "", "(ILjava/lang/String;)V", "getBiz", "()I", "proxy", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandlerProxy;", "getProxy", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandlerProxy;", "setProxy", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandlerProxy;)V", "scene", "getScene", "setScene", "(I)V", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "getUrl", "webView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "getWebView", "()Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "setWebView", "(Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;)V", "webViewReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getWebViewReady", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setWebViewReady", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-webview_release"})
public final class d
{
  public WebSearchWebView Gqy;
  public i IFj;
  AtomicBoolean JpC;
  final int mrG;
  private int scene;
  private String sessionId;
  private final String url;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(210529);
    this.mrG = paramInt;
    this.url = paramString;
    this.sessionId = "";
    this.JpC = new AtomicBoolean(false);
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
      p.g(paramString, "it");
      this.sessionId = paramString;
      AppMethodBeat.o(210529);
      return;
      paramInt = i;
    }
    AppMethodBeat.o(210529);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(210532);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.mrG != paramObject.mrG) || (!p.j(this.url, paramObject.url))) {}
      }
    }
    else
    {
      AppMethodBeat.o(210532);
      return true;
    }
    AppMethodBeat.o(210532);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(210531);
    int j = this.mrG;
    String str = this.url;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(210531);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210530);
    String str = "WebSearchPreloadObj(biz=" + this.mrG + ", url=" + this.url + ")";
    AppMethodBeat.o(210530);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.preload.d
 * JD-Core Version:    0.7.0.1
 */