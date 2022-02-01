package com.tencent.mm.plugin.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;

public final class b
{
  public static String I(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(306319);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramString3 = k.aXd(paramString3);
    localStringBuilder.append(String.valueOf(l)).append(",").append(paramString1).append(",").append(paramString2).append(",").append(paramString3).append(",,,,").append(paramString4);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(306319);
    return paramString1;
  }
  
  public static String aR(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(306317);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramString2 = k.aXd(paramString2);
    localStringBuilder.append(String.valueOf(l)).append(",").append(paramString1).append(",").append(paramString2).append(",,,,").append(paramString3);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(306317);
    return paramString1;
  }
  
  public static void aS(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(306323);
    try
    {
      if (au.bwE(paramString1)) {}
      for (int i = 2;; i = 1)
      {
        Log.i("AntiCheatingReportUtils", "shareType = ".concat(String.valueOf(i)));
        paramString1 = I(String.valueOf(i), paramString1, paramString2, paramString3);
        Log.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(paramString1)));
        h.OAn.kvStat(19214, paramString1);
        AppMethodBeat.o(306323);
        return;
      }
      return;
    }
    finally
    {
      Log.e("AntiCheatingReportUtils", paramString1.toString());
      AppMethodBeat.o(306323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.b
 * JD-Core Version:    0.7.0.1
 */