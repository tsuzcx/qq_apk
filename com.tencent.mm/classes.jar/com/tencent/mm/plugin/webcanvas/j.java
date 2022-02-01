package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasReport;", "", "()V", "idKey1454", "", "value", "", "kv20821", "appId", "", "contextName", "reason", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j WkY;
  
  static
  {
    AppMethodBeat.i(261307);
    WkY = new j();
    AppMethodBeat.o(261307);
  }
  
  public static void bn(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(261287);
    if (paramString3 == null) {}
    for (paramString3 = null;; paramString3 = n.a(paramString3, ',', '.'))
    {
      h.OAn.b(20821, new Object[] { paramString1, paramString2, paramString3 });
      AppMethodBeat.o(261287);
      return;
    }
  }
  
  public static void xC(long paramLong)
  {
    AppMethodBeat.i(261274);
    h.OAn.p(1454L, paramLong, 1L);
    AppMethodBeat.o(261274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.j
 * JD-Core Version:    0.7.0.1
 */