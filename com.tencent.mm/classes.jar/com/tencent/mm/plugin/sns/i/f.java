package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
{
  public static void l(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(94486);
    paramString = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
    ab.i("MicroMsg.SNS.SnsReportLogic", "snsRedDotAction 16172 report %s", new Object[] { paramString });
    e.qrI.kvStat(16172, paramString);
    AppMethodBeat.o(94486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.f
 * JD-Core Version:    0.7.0.1
 */