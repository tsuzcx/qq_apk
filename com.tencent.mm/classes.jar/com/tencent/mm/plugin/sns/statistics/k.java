package com.tencent.mm.plugin.sns.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
{
  public static void z(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(125685);
    paramString = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
    Log.i("MicroMsg.SNS.SnsReportLogic", "snsRedDotAction 16172 report %s", new Object[] { paramString });
    f.Ozc.kvStat(16172, paramString);
    AppMethodBeat.o(125685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.k
 * JD-Core Version:    0.7.0.1
 */