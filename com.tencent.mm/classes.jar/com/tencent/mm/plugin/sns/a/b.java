package com.tencent.mm.plugin.sns.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public static String aw(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(197733);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramString2 = h.axM(paramString2);
    localStringBuilder.append(String.valueOf(l)).append(",").append(paramString1).append(",").append(paramString2).append(",,,,").append(paramString3);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(197733);
    return paramString1;
  }
  
  public static void ax(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(197735);
    try
    {
      if (w.vF(paramString1)) {}
      for (int i = 2;; i = 1)
      {
        ad.i("AntiCheatingReportUtils", "shareType = ".concat(String.valueOf(i)));
        paramString1 = w(String.valueOf(i), paramString1, paramString2, paramString3);
        ad.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(paramString1)));
        g.yhR.kvStat(19214, paramString1);
        AppMethodBeat.o(197735);
        return;
      }
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("AntiCheatingReportUtils", paramString1.toString());
      AppMethodBeat.o(197735);
    }
  }
  
  public static String w(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(197734);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramString3 = h.axM(paramString3);
    localStringBuilder.append(String.valueOf(l)).append(",").append(paramString1).append(",").append(paramString2).append(",").append(paramString3).append(",,,,").append(paramString4);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(197734);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b
 * JD-Core Version:    0.7.0.1
 */