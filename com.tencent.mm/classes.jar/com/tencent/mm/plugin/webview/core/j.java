package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final MultiProcessMMKV cTb()
  {
    AppMethodBeat.i(295079);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__webview_command");
    s.s(localMultiProcessMMKV, "getMMKV(\"__webview_command\")");
    AppMethodBeat.o(295079);
    return localMultiProcessMMKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.j
 * JD-Core Version:    0.7.0.1
 */