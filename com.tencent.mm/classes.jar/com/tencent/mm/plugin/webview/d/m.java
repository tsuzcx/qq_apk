package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"kvJsLoader", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvJsLoader", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"})
public final class m
{
  static final MultiProcessMMKV gbp()
  {
    AppMethodBeat.i(225110);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("_webview_jsloader");
    p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(\"_webview_jsloader\")");
    AppMethodBeat.o(225110);
    return localMultiProcessMMKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.m
 * JD-Core Version:    0.7.0.1
 */