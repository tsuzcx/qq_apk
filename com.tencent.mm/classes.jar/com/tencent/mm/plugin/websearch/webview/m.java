package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchJSApiNotifier;", "", "()V", "TAG", "", "notifyJsEvent", "", "webView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "funcName", "params", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  private static final String TAG;
  public static final m WrX;
  
  static
  {
    AppMethodBeat.i(315216);
    WrX = new m();
    TAG = "MicroMsg.WebSearch.WebSearchJSApiNotifier";
    AppMethodBeat.o(315216);
  }
  
  public static void a(WebSearchWebView paramWebSearchWebView, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(315211);
    s.u(paramWebSearchWebView, "webView");
    s.u(paramString1, "funcName");
    s.u(paramString2, "params");
    try
    {
      Log.i(TAG, "notifyJsEvent %s %s", new Object[] { paramString1, paramString2 });
      am localam = am.aixg;
      paramString1 = String.format("javascript:window['%s'] && %s(%s)", Arrays.copyOf(new Object[] { paramString1, paramString1, paramString2 }, 3));
      s.s(paramString1, "java.lang.String.format(format, *args)");
      d.uiThread((a)new a(paramWebSearchWebView, paramString1));
      AppMethodBeat.o(315211);
      return;
    }
    catch (Exception paramWebSearchWebView)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramWebSearchWebView, "notifyJsEvent", new Object[0]);
      AppMethodBeat.o(315211);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(WebSearchWebView paramWebSearchWebView, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.m
 * JD-Core Version:    0.7.0.1
 */