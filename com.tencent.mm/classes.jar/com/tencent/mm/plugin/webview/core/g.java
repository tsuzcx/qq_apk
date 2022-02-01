package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"})
public final class g
{
  static final ax buO()
  {
    AppMethodBeat.i(189359);
    ax localax = ax.aFC("__webview_command");
    k.g(localax, "MultiProcessMMKV.getMMKV(\"__webview_command\")");
    AppMethodBeat.o(189359);
    return localax;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.g
 * JD-Core Version:    0.7.0.1
 */