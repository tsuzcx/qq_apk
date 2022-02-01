package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"})
public final class h
{
  public static final MultiProcessMMKV cdi()
  {
    AppMethodBeat.i(225051);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__webview_command");
    p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(\"__webview_command\")");
    AppMethodBeat.o(225051);
    return localMultiProcessMMKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.h
 * JD-Core Version:    0.7.0.1
 */