package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"kvJsLoader", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvJsLoader", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"})
public final class k
{
  static final ax ekI()
  {
    AppMethodBeat.i(189401);
    ax localax = ax.aFC("_webview_jsloader");
    d.g.b.k.g(localax, "MultiProcessMMKV.getMMKV(\"_webview_jsloader\")");
    AppMethodBeat.o(189401);
    return localax;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.k
 * JD-Core Version:    0.7.0.1
 */