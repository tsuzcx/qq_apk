package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"kvJsLoader", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvJsLoader", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"})
public final class k
{
  static final ax eOS()
  {
    AppMethodBeat.i(214322);
    ax localax = ax.aQz("_webview_jsloader");
    p.g(localax, "MultiProcessMMKV.getMMKV(\"_webview_jsloader\")");
    AppMethodBeat.o(214322);
    return localax;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.k
 * JD-Core Version:    0.7.0.1
 */