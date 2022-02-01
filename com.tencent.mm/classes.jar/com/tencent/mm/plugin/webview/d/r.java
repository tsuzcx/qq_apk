package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPoolManager;", "", "()V", "TAG", "", "defaultJsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPool;", "jsApiPoolList", "", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "addJsApiPool", "", "jsApiPool", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "removeJsApiPool", "webview-sdk_release"})
public final class r
{
  private static final List<e> POC;
  private static final q POD;
  public static final r POE;
  
  static
  {
    AppMethodBeat.i(206278);
    POE = new r();
    POC = (List)new ArrayList();
    POD = q.POB;
    AppMethodBeat.o(206278);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(206272);
    p.k(parame, "jsApiPool");
    if (!POC.contains(parame))
    {
      POC.add(parame);
      Log.v("MicroMsg.WebViewJsApiPoolManager", "addJsApiPool size: %s, added: %s", new Object[] { Integer.valueOf(POC.size()), parame });
    }
    AppMethodBeat.o(206272);
  }
  
  public static boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(206269);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Iterator localIterator = ((Iterable)POC).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if ((locale.b(paramf, paramn)) && (locale.a(paramf, paramn)))
      {
        AppMethodBeat.o(206269);
        return true;
      }
    }
    if ((POD.b(paramf, paramn)) && (POD.a(paramf, paramn)))
    {
      AppMethodBeat.o(206269);
      return true;
    }
    AppMethodBeat.o(206269);
    return false;
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(206274);
    p.k(parame, "jsApiPool");
    if (POC.contains(parame))
    {
      POC.remove(parame);
      Log.v("MicroMsg.WebViewJsApiPoolManager", "removeJsApiPool size: %s, removed: %s", new Object[] { Integer.valueOf(POC.size()), parame });
    }
    AppMethodBeat.o(206274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.r
 * JD-Core Version:    0.7.0.1
 */