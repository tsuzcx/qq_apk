package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"kvJsLoader", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvJsLoader", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"})
public final class k
{
  static final ay eSD()
  {
    AppMethodBeat.i(214163);
    ay localay = ay.aRW("_webview_jsloader");
    p.g(localay, "MultiProcessMMKV.getMMKV(\"_webview_jsloader\")");
    AppMethodBeat.o(214163);
    return localay;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.k
 * JD-Core Version:    0.7.0.1
 */