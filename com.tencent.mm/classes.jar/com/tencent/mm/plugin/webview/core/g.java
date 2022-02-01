package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"})
public final class g
{
  public static final ay bGK()
  {
    AppMethodBeat.i(214121);
    ay localay = ay.aRW("__webview_command");
    p.g(localay, "MultiProcessMMKV.getMMKV(\"__webview_command\")");
    AppMethodBeat.o(214121);
    return localay;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.g
 * JD-Core Version:    0.7.0.1
 */