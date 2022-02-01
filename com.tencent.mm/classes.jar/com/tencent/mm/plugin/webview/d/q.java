package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPoolManager;", "", "()V", "TAG", "", "jsApiPoolList", "", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "addJsApiPool", "", "jsApiPool", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "removeJsApiPool", "webview-sdk_release"})
public final class q
{
  private static final List<e> ISl;
  public static final q ISm;
  
  static
  {
    AppMethodBeat.i(225123);
    ISm = new q();
    ISl = j.mutableListOf(new e[] { (e)p.ISk });
    AppMethodBeat.o(225123);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(225121);
    kotlin.g.b.p.h(parame, "jsApiPool");
    if (!ISl.contains(parame))
    {
      ISl.add(parame);
      Log.v("MicroMsg.WebViewJsApiPoolManager", "addJsApiPool size: %s, added: %s", new Object[] { Integer.valueOf(ISl.size()), parame });
    }
    AppMethodBeat.o(225121);
  }
  
  public static boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(225120);
    kotlin.g.b.p.h(paramf, "env");
    kotlin.g.b.p.h(paramn, "msg");
    Iterator localIterator = ((Iterable)ISl).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if ((locale.b(paramf, paramn)) && (locale.a(paramf, paramn)))
      {
        AppMethodBeat.o(225120);
        return true;
      }
    }
    AppMethodBeat.o(225120);
    return false;
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(225122);
    kotlin.g.b.p.h(parame, "jsApiPool");
    if (ISl.contains(parame))
    {
      ISl.remove(parame);
      Log.v("MicroMsg.WebViewJsApiPoolManager", "removeJsApiPool size: %s, removed: %s", new Object[] { Integer.valueOf(ISl.size()), parame });
    }
    AppMethodBeat.o(225122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.q
 * JD-Core Version:    0.7.0.1
 */