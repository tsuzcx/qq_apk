package com.tencent.mm.plugin.sns.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  public static String ap(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(200029);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramString2 = com.tencent.mm.plugin.sns.data.h.asK(paramString2);
    localStringBuilder.append(String.valueOf(l)).append(",").append(paramString1).append(",").append(paramString2).append(",,,,").append(paramString3);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(200029);
    return paramString1;
  }
  
  public static void aq(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(200031);
    try
    {
      if (w.sQ(paramString1)) {}
      for (int i = 2;; i = 1)
      {
        ac.i("AntiCheatingReportUtils", "shareType = ".concat(String.valueOf(i)));
        paramString1 = v(String.valueOf(i), paramString1, paramString2, paramString3);
        ac.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(paramString1)));
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(19214, paramString1);
        AppMethodBeat.o(200031);
        return;
      }
      return;
    }
    catch (Throwable paramString1)
    {
      ac.e("AntiCheatingReportUtils", paramString1.toString());
      AppMethodBeat.o(200031);
    }
  }
  
  public static String v(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(200030);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramString3 = com.tencent.mm.plugin.sns.data.h.asK(paramString3);
    localStringBuilder.append(String.valueOf(l)).append(",").append(paramString1).append(",").append(paramString2).append(",").append(paramString3).append(",,,,").append(paramString4);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(200030);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b
 * JD-Core Version:    0.7.0.1
 */