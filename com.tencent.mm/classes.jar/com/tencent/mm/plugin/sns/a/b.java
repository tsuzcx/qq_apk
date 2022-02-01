package com.tencent.mm.plugin.sns.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static String A(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(202553);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramString3 = i.aNZ(paramString3);
    localStringBuilder.append(String.valueOf(l)).append(",").append(paramString1).append(",").append(paramString2).append(",").append(paramString3).append(",,,,").append(paramString4);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(202553);
    return paramString1;
  }
  
  public static String aH(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(202552);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    paramString2 = i.aNZ(paramString2);
    localStringBuilder.append(String.valueOf(l)).append(",").append(paramString1).append(",").append(paramString2).append(",,,,").append(paramString3);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(202552);
    return paramString1;
  }
  
  public static void aI(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(202554);
    try
    {
      if (ab.Eq(paramString1)) {}
      for (int i = 2;; i = 1)
      {
        Log.i("AntiCheatingReportUtils", "shareType = ".concat(String.valueOf(i)));
        paramString1 = A(String.valueOf(i), paramString1, paramString2, paramString3);
        Log.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(paramString1)));
        h.CyF.kvStat(19214, paramString1);
        AppMethodBeat.o(202554);
        return;
      }
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("AntiCheatingReportUtils", paramString1.toString());
      AppMethodBeat.o(202554);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b
 * JD-Core Version:    0.7.0.1
 */