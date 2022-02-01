package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static Map<String, a> KhN;
  private static volatile long KhO;
  
  static
  {
    AppMethodBeat.i(96202);
    KhN = new ConcurrentHashMap();
    KhO = 0L;
    AppMethodBeat.o(96202);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(96200);
    try
    {
      a locala = new a((byte)0);
      locala.KhP = baM(paramString2);
      locala.KhQ = paramInt1;
      locala.mMimeType = paramString3;
      locala.mWidth = paramInt2;
      locala.mHeight = paramInt3;
      locala.KhR = paramInt4;
      locala.aKk = paramLong1;
      locala.KhS = paramLong2;
      KhN.put(paramString1, locala);
      AppMethodBeat.o(96200);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(96200);
    }
  }
  
  private static String baM(String paramString)
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
  
  public static void bq(String paramString, long paramLong)
  {
    AppMethodBeat.i(96201);
    try
    {
      paramString = (a)KhN.remove(paramString);
      if (paramString == null) {
        return;
      }
      paramString.KhT = paramLong;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append(paramString.KhP).append(',').append(paramString.KhQ).append(',').append(paramString.mMimeType).append(',').append(paramString.mWidth).append(',').append(paramString.mHeight).append(',').append(paramString.KhR).append(',').append(paramString.aKk).append(',').append(paramString.KhS).append(',').append(paramString.KhT);
      paramString = localStringBuilder.toString();
      Log.i("MicroMsg.SnsImgStats", "report dl: ".concat(String.valueOf(paramString)));
      h.IzE.kvStat(13513, paramString);
      return;
    }
    catch (Exception paramString) {}finally
    {
      fQk();
      AppMethodBeat.o(96201);
    }
  }
  
  public static void c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(96199);
    try
    {
      b localb = new b((byte)0);
      localb.KhP = baM(paramString1);
      localb.mMimeType = paramString2;
      localb.mWidth = paramInt1;
      localb.mHeight = paramInt2;
      localb.KhR = paramInt3;
      localb.aKk = paramLong;
      paramString1 = new StringBuilder(1024);
      paramString1.append(localb.KhP).append(',').append(localb.mMimeType).append(',').append(localb.mWidth).append(',').append(localb.mHeight).append(',').append(localb.KhR).append(',').append(localb.aKk);
      paramString1 = paramString1.toString();
      Log.i("MicroMsg.SnsImgStats", "report up: ".concat(String.valueOf(paramString1)));
      h.IzE.kvStat(13512, paramString1);
      AppMethodBeat.o(96199);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(96199);
    }
  }
  
  private static void fQk()
  {
    AppMethodBeat.i(96197);
    synchronized (KhN)
    {
      if (Util.ticksToNow(KhO) <= 120000L)
      {
        AppMethodBeat.o(96197);
        return;
      }
      KhO = Util.currentTicks();
      KhN.clear();
      AppMethodBeat.o(96197);
      return;
    }
  }
  
  static final class a
  {
    String KhP = "";
    int KhQ = 0;
    int KhR = -1;
    long KhS = -1L;
    long KhT = -1L;
    long aKk = -1L;
    int mHeight = -1;
    String mMimeType = "";
    int mWidth = -1;
  }
  
  static final class b
  {
    String KhP = "";
    int KhR = -1;
    long aKk = -1L;
    int mHeight = -1;
    String mMimeType = "";
    int mWidth = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.e
 * JD-Core Version:    0.7.0.1
 */