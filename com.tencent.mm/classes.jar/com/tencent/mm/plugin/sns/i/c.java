package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static volatile long roA;
  private static Map<String, c.a> roz;
  
  static
  {
    AppMethodBeat.i(36872);
    roz = new ConcurrentHashMap();
    roA = 0L;
    AppMethodBeat.o(36872);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(36869);
    try
    {
      c.b localb = new c.b((byte)0);
      localb.roB = abf(paramString1);
      localb.mMimeType = paramString2;
      localb.mWidth = paramInt1;
      localb.mHeight = paramInt2;
      localb.roD = paramInt3;
      localb.roE = paramLong;
      paramString1 = new StringBuilder(1024);
      paramString1.append(localb.roB).append(',').append(localb.mMimeType).append(',').append(localb.mWidth).append(',').append(localb.mHeight).append(',').append(localb.roD).append(',').append(localb.roE);
      paramString1 = paramString1.toString();
      ab.i("MicroMsg.SnsImgStats", "report up: ".concat(String.valueOf(paramString1)));
      h.qsU.kvStat(13512, paramString1);
      AppMethodBeat.o(36869);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(36869);
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(36870);
    try
    {
      c.a locala = new c.a((byte)0);
      locala.roB = abf(paramString2);
      locala.roC = paramInt1;
      locala.mMimeType = paramString3;
      locala.mWidth = paramInt2;
      locala.mHeight = paramInt3;
      locala.roD = paramInt4;
      locala.roE = paramLong1;
      locala.roF = paramLong2;
      roz.put(paramString1, locala);
      AppMethodBeat.o(36870);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(36870);
    }
  }
  
  public static void aD(String paramString, long paramLong)
  {
    AppMethodBeat.i(36871);
    try
    {
      paramString = (c.a)roz.remove(paramString);
      if (paramString == null) {
        return;
      }
      paramString.roG = paramLong;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append(paramString.roB).append(',').append(paramString.roC).append(',').append(paramString.mMimeType).append(',').append(paramString.mWidth).append(',').append(paramString.mHeight).append(',').append(paramString.roD).append(',').append(paramString.roE).append(',').append(paramString.roF).append(',').append(paramString.roG);
      paramString = localStringBuilder.toString();
      ab.i("MicroMsg.SnsImgStats", "report dl: ".concat(String.valueOf(paramString)));
      h.qsU.kvStat(13513, paramString);
      return;
    }
    catch (Exception paramString) {}finally
    {
      cqd();
      AppMethodBeat.o(36871);
    }
  }
  
  private static String abf(String paramString)
  {
    AppMethodBeat.i(36868);
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
      AppMethodBeat.o(36868);
      return paramString;
    }
    AppMethodBeat.o(36868);
    return paramString;
  }
  
  private static void cqd()
  {
    AppMethodBeat.i(36867);
    synchronized (roz)
    {
      if (bo.av(roA) <= 120000L)
      {
        AppMethodBeat.o(36867);
        return;
      }
      roA = bo.yB();
      roz.clear();
      AppMethodBeat.o(36867);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.c
 * JD-Core Version:    0.7.0.1
 */