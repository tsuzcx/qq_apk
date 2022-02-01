package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/BizCardReport;", "", "()V", "bizRecycleCardRejectReport", "", "status", "", "extraData", "", "report20800Insert", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "arriveType", "pos", "useServerTime", "cardType", "style", "recID", "", "cardId", "expType", "report20800Receive", "weight", "plugin-biz_release"})
public final class s
{
  public static final s NPC;
  
  static
  {
    AppMethodBeat.i(212554);
    NPC = new s();
    AppMethodBeat.o(212554);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(212551);
    h.CyF.a(20800, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Long.valueOf(paramLong), paramString1, paramString2, com.tencent.mm.pluginsdk.ui.tools.z.bfG(Util.nullAsNil(paramString3)) });
    AppMethodBeat.o(212551);
  }
  
  public static void a(z paramz, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(212552);
    p.h(paramz, "info");
    if (!paramz.gAu())
    {
      AppMethodBeat.o(212552);
      return;
    }
    h.CyF.a(20800, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramz.gAp()), Integer.valueOf(paramInt3), Integer.valueOf(5), Integer.valueOf(paramInt4), Long.valueOf(paramLong), paramString1, paramString2, com.tencent.mm.pluginsdk.ui.tools.z.bfG(Util.nullAsNil(paramString3)) });
    AppMethodBeat.o(212552);
  }
  
  public static void di(int paramInt, String paramString)
  {
    AppMethodBeat.i(212553);
    h.CyF.a(21314, new Object[] { com.tencent.mm.pluginsdk.ui.tools.z.bfG(Util.nullAsNil(paramString)), Integer.valueOf(paramInt) });
    AppMethodBeat.o(212553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.s
 * JD-Core Version:    0.7.0.1
 */