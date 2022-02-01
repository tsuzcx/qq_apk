package com.tencent.mm.plugin.webview.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPoolManager;", "", "()V", "TAG", "", "defaultJsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPool;", "jsApiPoolList", "", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "addJsApiPool", "", "jsApiPool", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "removeJsApiPool", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final t WEP;
  private static final List<g> WEQ;
  private static final s WER;
  
  static
  {
    AppMethodBeat.i(295301);
    WEP = new t();
    WEQ = (List)new ArrayList();
    WER = s.WEN;
    AppMethodBeat.o(295301);
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(295291);
    kotlin.g.b.s.u(paramg, "jsApiPool");
    if (!WEQ.contains(paramg))
    {
      WEQ.add(paramg);
      Log.v("MicroMsg.WebViewJsApiPoolManager", "addJsApiPool size: %s, added: %s", new Object[] { Integer.valueOf(WEQ.size()), paramg });
    }
    AppMethodBeat.o(295291);
  }
  
  public static boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(295277);
    kotlin.g.b.s.u(paramh, "env");
    kotlin.g.b.s.u(paramp, "msg");
    Object localObject = paramh.WDy.itt();
    if ((localObject != null) && (((g)localObject).b(paramh, paramp)) && (((g)localObject).a(paramh, paramp)))
    {
      AppMethodBeat.o(295277);
      return true;
    }
    localObject = ((Iterable)WEQ).iterator();
    while (((Iterator)localObject).hasNext())
    {
      g localg = (g)((Iterator)localObject).next();
      if ((localg.b(paramh, paramp)) && (localg.a(paramh, paramp)))
      {
        AppMethodBeat.o(295277);
        return true;
      }
    }
    if ((WER.b(paramh, paramp)) && (WER.a(paramh, paramp)))
    {
      AppMethodBeat.o(295277);
      return true;
    }
    AppMethodBeat.o(295277);
    return false;
  }
  
  public static boolean a(h paramh, p paramp, g paramg)
  {
    AppMethodBeat.i(295282);
    kotlin.g.b.s.u(paramh, "env");
    kotlin.g.b.s.u(paramp, "msg");
    kotlin.g.b.s.u(paramg, "jsApiPool");
    if ((paramg.b(paramh, paramp)) && (paramg.a(paramh, paramp)))
    {
      AppMethodBeat.o(295282);
      return true;
    }
    AppMethodBeat.o(295282);
    return false;
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(295295);
    kotlin.g.b.s.u(paramg, "jsApiPool");
    if (WEQ.contains(paramg))
    {
      WEQ.remove(paramg);
      Log.v("MicroMsg.WebViewJsApiPoolManager", "removeJsApiPool size: %s, removed: %s", new Object[] { Integer.valueOf(WEQ.size()), paramg });
    }
    AppMethodBeat.o(295295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.t
 * JD-Core Version:    0.7.0.1
 */