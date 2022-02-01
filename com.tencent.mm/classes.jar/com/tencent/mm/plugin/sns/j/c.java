package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static Map<String, a> zKB;
  private static volatile long zKC;
  
  static
  {
    AppMethodBeat.i(96202);
    zKB = new ConcurrentHashMap();
    zKC = 0L;
    AppMethodBeat.o(96202);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(96200);
    try
    {
      a locala = new a((byte)0);
      locala.zKD = aAV(paramString2);
      locala.zKE = paramInt1;
      locala.mMimeType = paramString3;
      locala.mWidth = paramInt2;
      locala.mHeight = paramInt3;
      locala.zKF = paramInt4;
      locala.baQ = paramLong1;
      locala.zKG = paramLong2;
      zKB.put(paramString1, locala);
      AppMethodBeat.o(96200);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(96200);
    }
  }
  
  private static String aAV(String paramString)
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
  
  public static void bl(String paramString, long paramLong)
  {
    AppMethodBeat.i(96201);
    try
    {
      paramString = (a)zKB.remove(paramString);
      if (paramString == null) {
        return;
      }
      paramString.zKH = paramLong;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append(paramString.zKD).append(',').append(paramString.zKE).append(',').append(paramString.mMimeType).append(',').append(paramString.mWidth).append(',').append(paramString.mHeight).append(',').append(paramString.zKF).append(',').append(paramString.baQ).append(',').append(paramString.zKG).append(',').append(paramString.zKH);
      paramString = localStringBuilder.toString();
      ae.i("MicroMsg.SnsImgStats", "report dl: ".concat(String.valueOf(paramString)));
      g.yxI.kvStat(13513, paramString);
      return;
    }
    catch (Exception paramString) {}finally
    {
      dZd();
      AppMethodBeat.o(96201);
    }
  }
  
  public static void c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(96199);
    try
    {
      b localb = new b((byte)0);
      localb.zKD = aAV(paramString1);
      localb.mMimeType = paramString2;
      localb.mWidth = paramInt1;
      localb.mHeight = paramInt2;
      localb.zKF = paramInt3;
      localb.baQ = paramLong;
      paramString1 = new StringBuilder(1024);
      paramString1.append(localb.zKD).append(',').append(localb.mMimeType).append(',').append(localb.mWidth).append(',').append(localb.mHeight).append(',').append(localb.zKF).append(',').append(localb.baQ);
      paramString1 = paramString1.toString();
      ae.i("MicroMsg.SnsImgStats", "report up: ".concat(String.valueOf(paramString1)));
      g.yxI.kvStat(13512, paramString1);
      AppMethodBeat.o(96199);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(96199);
    }
  }
  
  private static void dZd()
  {
    AppMethodBeat.i(96197);
    synchronized (zKB)
    {
      if (bu.aO(zKC) <= 120000L)
      {
        AppMethodBeat.o(96197);
        return;
      }
      zKC = bu.HQ();
      zKB.clear();
      AppMethodBeat.o(96197);
      return;
    }
  }
  
  static final class a
  {
    long baQ = -1L;
    int mHeight = -1;
    String mMimeType = "";
    int mWidth = -1;
    String zKD = "";
    int zKE = 0;
    int zKF = -1;
    long zKG = -1L;
    long zKH = -1L;
  }
  
  static final class b
  {
    long baQ = -1L;
    int mHeight = -1;
    String mMimeType = "";
    int mWidth = -1;
    String zKD = "";
    int zKF = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.c
 * JD-Core Version:    0.7.0.1
 */