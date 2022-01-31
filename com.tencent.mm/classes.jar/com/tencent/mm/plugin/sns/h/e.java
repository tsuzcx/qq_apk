package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  public static void i(int paramInt1, String paramString, int paramInt2)
  {
    paramString = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
    y.i("MicroMsg.SNS.SnsReportLogic", "snsRedDotAction 16172 report %s", new Object[] { paramString });
    f.nEG.aC(16172, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.e
 * JD-Core Version:    0.7.0.1
 */