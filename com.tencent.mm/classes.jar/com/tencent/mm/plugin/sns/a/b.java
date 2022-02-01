package com.tencent.mm.plugin.sns.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static String G(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(227169);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramString3 = k.aYR(paramString3);
    localStringBuilder.append(String.valueOf(l)).append(",").append(paramString1).append(",").append(paramString2).append(",").append(paramString3).append(",,,,").append(paramString4);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(227169);
    return paramString1;
  }
  
  public static String aB(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(227165);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramString2 = k.aYR(paramString2);
    localStringBuilder.append(String.valueOf(l)).append(",").append(paramString1).append(",").append(paramString2).append(",,,,").append(paramString3);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(227165);
    return paramString1;
  }
  
  public static void aC(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(227174);
    try
    {
      if (ab.Lj(paramString1)) {}
      for (int i = 2;; i = 1)
      {
        Log.i("AntiCheatingReportUtils", "shareType = ".concat(String.valueOf(i)));
        paramString1 = G(String.valueOf(i), paramString1, paramString2, paramString3);
        Log.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(paramString1)));
        h.IzE.kvStat(19214, paramString1);
        AppMethodBeat.o(227174);
        return;
      }
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("AntiCheatingReportUtils", paramString1.toString());
      AppMethodBeat.o(227174);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b
 * JD-Core Version:    0.7.0.1
 */