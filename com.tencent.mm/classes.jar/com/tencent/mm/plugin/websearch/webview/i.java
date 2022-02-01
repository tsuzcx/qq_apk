package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.a.a;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchJSApiNotifier;", "", "()V", "TAG", "", "notifyJsEvent", "", "webView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "funcName", "params", "ui-websearch_release"})
public final class i
{
  public static final i IHk;
  private static final String TAG = "MicroMsg.WebSearch.WebSearchJSApiNotifier";
  
  static
  {
    AppMethodBeat.i(198076);
    IHk = new i();
    TAG = "MicroMsg.WebSearch.WebSearchJSApiNotifier";
    AppMethodBeat.o(198076);
  }
  
  public static void a(WebSearchWebView paramWebSearchWebView, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(198075);
    p.h(paramWebSearchWebView, "webView");
    p.h(paramString1, "funcName");
    p.h(paramString2, "params");
    try
    {
      Log.i(TAG, "notifyJsEvent %s %s", new Object[] { paramString1, paramString2 });
      ae localae = ae.SYK;
      paramString1 = String.format("javascript:window['%s'] && %s(%s)", Arrays.copyOf(new Object[] { paramString1, paramString1, paramString2 }, 3));
      p.g(paramString1, "java.lang.String.format(format, *args)");
      d.h((a)new a(paramWebSearchWebView, paramString1));
      AppMethodBeat.o(198075);
      return;
    }
    catch (Exception paramWebSearchWebView)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramWebSearchWebView, "notifyJsEvent", new Object[0]);
      AppMethodBeat.o(198075);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(WebSearchWebView paramWebSearchWebView, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.i
 * JD-Core Version:    0.7.0.1
 */