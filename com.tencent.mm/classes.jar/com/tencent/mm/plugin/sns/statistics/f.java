package com.tencent.mm.plugin.sns.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f
{
  private static Map<String, a> QFC;
  private static volatile long QFD;
  
  static
  {
    AppMethodBeat.i(96202);
    QFC = new ConcurrentHashMap();
    QFD = 0L;
    AppMethodBeat.o(96202);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(96200);
    try
    {
      a locala = new a((byte)0);
      locala.QFE = aZk(paramString2);
      locala.QFF = paramInt1;
      locala.mMimeType = paramString3;
      locala.mWidth = paramInt2;
      locala.mHeight = paramInt3;
      locala.QFG = paramInt4;
      locala.cEg = paramLong1;
      locala.QFH = paramLong2;
      QFC.put(paramString1, locala);
      AppMethodBeat.o(96200);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(96200);
    }
  }
  
  private static String aZk(String paramString)
  {
    AppMethodBeat.i(96198);
    int i = paramString.indexOf('?');
    String str = paramString;
    if (i >= 0) {
      str = paramString.substring(0, i);
    }
    i = str.indexOf("://");
    paramString = str;
    if (i >= 0) {
      paramString = str.substring(i + 3);
    }
    i = paramString.indexOf('/');
    if (i >= 0)
    {
      paramString = paramString.substring(i + 1);
      AppMethodBeat.o(96198);
      return paramString;
    }
    AppMethodBeat.o(96198);
    return paramString;
  }
  
  public static void bC(String paramString, long paramLong)
  {
    AppMethodBeat.i(96201);
    try
    {
      paramString = (a)QFC.remove(paramString);
      if (paramString == null) {
        return;
      }
      paramString.QFI = paramLong;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append(paramString.QFE).append(',').append(paramString.QFF).append(',').append(paramString.mMimeType).append(',').append(paramString.mWidth).append(',').append(paramString.mHeight).append(',').append(paramString.QFG).append(',').append(paramString.cEg).append(',').append(paramString.QFH).append(',').append(paramString.QFI);
      paramString = localStringBuilder.toString();
      Log.i("MicroMsg.SnsImgStats", "report dl: ".concat(String.valueOf(paramString)));
      h.OAn.kvStat(13513, paramString);
      return;
    }
    catch (Exception paramString) {}finally
    {
      hih();
      AppMethodBeat.o(96201);
    }
  }
  
  public static void c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(96199);
    try
    {
      b localb = new b((byte)0);
      localb.QFE = aZk(paramString1);
      localb.mMimeType = paramString2;
      localb.mWidth = paramInt1;
      localb.mHeight = paramInt2;
      localb.QFG = paramInt3;
      localb.cEg = paramLong;
      paramString1 = new StringBuilder(1024);
      paramString1.append(localb.QFE).append(',').append(localb.mMimeType).append(',').append(localb.mWidth).append(',').append(localb.mHeight).append(',').append(localb.QFG).append(',').append(localb.cEg);
      paramString1 = paramString1.toString();
      Log.i("MicroMsg.SnsImgStats", "report up: ".concat(String.valueOf(paramString1)));
      h.OAn.kvStat(13512, paramString1);
      AppMethodBeat.o(96199);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(96199);
    }
  }
  
  private static void hih()
  {
    AppMethodBeat.i(96197);
    synchronized (QFC)
    {
      if (Util.ticksToNow(QFD) <= 120000L)
      {
        AppMethodBeat.o(96197);
        return;
      }
      QFD = Util.currentTicks();
      QFC.clear();
      AppMethodBeat.o(96197);
      return;
    }
  }
  
  static final class a
  {
    String QFE = "";
    int QFF = 0;
    int QFG = -1;
    long QFH = -1L;
    long QFI = -1L;
    long cEg = -1L;
    int mHeight = -1;
    String mMimeType = "";
    int mWidth = -1;
  }
  
  static final class b
  {
    String QFE = "";
    int QFG = -1;
    long cEg = -1L;
    int mHeight = -1;
    String mMimeType = "";
    int mWidth = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.f
 * JD-Core Version:    0.7.0.1
 */