package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
{
  public static void r(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(125685);
    paramString = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
    ac.i("MicroMsg.SNS.SnsReportLogic", "snsRedDotAction 16172 report %s", new Object[] { paramString });
    e.wTc.kvStat(16172, paramString);
    AppMethodBeat.o(125685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.g
 * JD-Core Version:    0.7.0.1
 */