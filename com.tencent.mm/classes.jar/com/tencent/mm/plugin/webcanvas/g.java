package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasReport;", "", "()V", "idKey1454", "", "value", "", "kv20821", "appId", "", "contextName", "reason", "webview-sdk_release"})
public final class g
{
  public static final g DQG;
  
  static
  {
    AppMethodBeat.i(213941);
    DQG = new g();
    AppMethodBeat.o(213941);
  }
  
  public static void CH(long paramLong)
  {
    AppMethodBeat.i(213939);
    com.tencent.mm.plugin.report.service.g.yxI.n(1454L, paramLong, 1L);
    AppMethodBeat.o(213939);
  }
  
  public static void aP(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213940);
    com.tencent.mm.plugin.report.service.g.yxI.f(20821, new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(213940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.g
 * JD-Core Version:    0.7.0.1
 */