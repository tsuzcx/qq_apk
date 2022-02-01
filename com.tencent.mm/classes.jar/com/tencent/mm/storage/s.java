package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/BizCardReport;", "", "()V", "bizRecycleCardRejectReport", "", "status", "", "extraData", "", "report20800Insert", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "arriveType", "pos", "useServerTime", "cardType", "style", "recID", "", "cardId", "expType", "report20800Receive", "weight", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s acEH;
  
  static
  {
    AppMethodBeat.i(248796);
    acEH = new s();
    AppMethodBeat.o(248796);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(248785);
    h.OAn.b(20800, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Long.valueOf(paramLong), paramString1, paramString2, aa.aUC(Util.nullAsNil(paramString3)) });
    AppMethodBeat.o(248785);
  }
  
  public static void a(ab paramab, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(248788);
    kotlin.g.b.s.u(paramab, "info");
    if (!paramab.iYf())
    {
      AppMethodBeat.o(248788);
      return;
    }
    h.OAn.b(20800, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramab.iYb()), Integer.valueOf(paramInt3), Integer.valueOf(5), Integer.valueOf(paramInt4), Long.valueOf(paramLong), paramString1, paramString2, aa.aUC(Util.nullAsNil(paramString3)) });
    AppMethodBeat.o(248788);
  }
  
  public static void dZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(248792);
    h.OAn.b(21314, new Object[] { aa.aUC(Util.nullAsNil(paramString)), Integer.valueOf(paramInt) });
    AppMethodBeat.o(248792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.storage.s
 * JD-Core Version:    0.7.0.1
 */