package com.tencent.mm.plugin.webview.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"kvJsLoader", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvJsLoader", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class o
{
  static final MultiProcessMMKV itQ()
  {
    AppMethodBeat.i(295216);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("_webview_jsloader");
    s.s(localMultiProcessMMKV, "getMMKV(\"_webview_jsloader\")");
    AppMethodBeat.o(295216);
    return localMultiProcessMMKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.o
 * JD-Core Version:    0.7.0.1
 */