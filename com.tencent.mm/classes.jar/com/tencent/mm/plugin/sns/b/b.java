package com.tencent.mm.plugin.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public static String an(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(187244);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramString2 = com.tencent.mm.plugin.sns.data.h.any(paramString2);
    localStringBuilder.append(String.valueOf(l)).append(",").append(paramString1).append(",").append(paramString2).append(",,,,").append(paramString3);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(187244);
    return paramString1;
  }
  
  public static void ao(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(187246);
    try
    {
      if (w.pF(paramString1)) {}
      for (int i = 2;; i = 1)
      {
        ad.i("AntiCheatingReportUtils", "shareType = ".concat(String.valueOf(i)));
        paramString1 = t(String.valueOf(i), paramString1, paramString2, paramString3);
        ad.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(paramString1)));
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(19214, paramString1);
        AppMethodBeat.o(187246);
        return;
      }
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("AntiCheatingReportUtils", paramString1.toString());
      AppMethodBeat.o(187246);
    }
  }
  
  public static String t(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(187245);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramString3 = com.tencent.mm.plugin.sns.data.h.any(paramString3);
    localStringBuilder.append(String.valueOf(l)).append(",").append(paramString1).append(",").append(paramString2).append(",").append(paramString3).append(",,,,").append(paramString4);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(187245);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.b
 * JD-Core Version:    0.7.0.1
 */