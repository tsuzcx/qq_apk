package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"})
public final class g
{
  static final aw bBL()
  {
    AppMethodBeat.i(205491);
    aw localaw = aw.aKT("__webview_command");
    k.g(localaw, "MultiProcessMMKV.getMMKV(\"__webview_command\")");
    AppMethodBeat.o(205491);
    return localaw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.g
 * JD-Core Version:    0.7.0.1
 */