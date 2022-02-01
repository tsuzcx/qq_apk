package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/BizCardReport;", "", "()V", "bizRecycleCardRejectReport", "", "status", "", "extraData", "", "report20800Insert", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "arriveType", "pos", "useServerTime", "cardType", "style", "recID", "", "cardId", "expType", "report20800Receive", "weight", "plugin-biz_release"})
public final class s
{
  public static final s Vdo;
  
  static
  {
    AppMethodBeat.i(206288);
    Vdo = new s();
    AppMethodBeat.o(206288);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(206285);
    h.IzE.a(20800, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Long.valueOf(paramLong), paramString1, paramString2, ab.aXb(Util.nullAsNil(paramString3)) });
    AppMethodBeat.o(206285);
  }
  
  public static void a(z paramz, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(206286);
    p.k(paramz, "info");
    if (!paramz.hwB())
    {
      AppMethodBeat.o(206286);
      return;
    }
    h.IzE.a(20800, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramz.hww()), Integer.valueOf(paramInt3), Integer.valueOf(5), Integer.valueOf(paramInt4), Long.valueOf(paramLong), paramString1, paramString2, ab.aXb(Util.nullAsNil(paramString3)) });
    AppMethodBeat.o(206286);
  }
  
  public static void dh(int paramInt, String paramString)
  {
    AppMethodBeat.i(206287);
    h.IzE.a(21314, new Object[] { ab.aXb(Util.nullAsNil(paramString)), Integer.valueOf(paramInt) });
    AppMethodBeat.o(206287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.s
 * JD-Core Version:    0.7.0.1
 */