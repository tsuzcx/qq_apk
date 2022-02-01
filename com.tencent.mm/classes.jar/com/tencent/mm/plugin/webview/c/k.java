package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"kvJsLoader", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvJsLoader", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"})
public final class k
{
  static final aw eAe()
  {
    AppMethodBeat.i(205533);
    aw localaw = aw.aKT("_webview_jsloader");
    d.g.b.k.g(localaw, "MultiProcessMMKV.getMMKV(\"_webview_jsloader\")");
    AppMethodBeat.o(205533);
    return localaw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.k
 * JD-Core Version:    0.7.0.1
 */