package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static Map<String, a> ztm;
  private static volatile long ztn;
  
  static
  {
    AppMethodBeat.i(96202);
    ztm = new ConcurrentHashMap();
    ztn = 0L;
    AppMethodBeat.o(96202);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(96199);
    try
    {
      b localb = new b((byte)0);
      localb.zto = azE(paramString1);
      localb.mMimeType = paramString2;
      localb.mWidth = paramInt1;
      localb.mHeight = paramInt2;
      localb.ztq = paramInt3;
      localb.baQ = paramLong;
      paramString1 = new StringBuilder(1024);
      paramString1.append(localb.zto).append(',').append(localb.mMimeType).append(',').append(localb.mWidth).append(',').append(localb.mHeight).append(',').append(localb.ztq).append(',').append(localb.baQ);
      paramString1 = paramString1.toString();
      ad.i("MicroMsg.SnsImgStats", "report up: ".concat(String.valueOf(paramString1)));
      g.yhR.kvStat(13512, paramString1);
      AppMethodBeat.o(96199);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(96199);
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(96200);
    try
    {
      a locala = new a((byte)0);
      locala.zto = azE(paramString2);
      locala.ztp = paramInt1;
      locala.mMimeType = paramString3;
      locala.mWidth = paramInt2;
      locala.mHeight = paramInt3;
      locala.ztq = paramInt4;
      locala.baQ = paramLong1;
      locala.ztr = paramLong2;
      ztm.put(paramString1, locala);
      AppMethodBeat.o(96200);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(96200);
    }
  }
  
  private static String azE(String paramString)
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
  
  public static void bk(String paramString, long paramLong)
  {
    AppMethodBeat.i(96201);
    try
    {
      paramString = (a)ztm.remove(paramString);
      if (paramString == null) {
        return;
      }
      paramString.zts = paramLong;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append(paramString.zto).append(',').append(paramString.ztp).append(',').append(paramString.mMimeType).append(',').append(paramString.mWidth).append(',').append(paramString.mHeight).append(',').append(paramString.ztq).append(',').append(paramString.baQ).append(',').append(paramString.ztr).append(',').append(paramString.zts);
      paramString = localStringBuilder.toString();
      ad.i("MicroMsg.SnsImgStats", "report dl: ".concat(String.valueOf(paramString)));
      g.yhR.kvStat(13513, paramString);
      return;
    }
    catch (Exception paramString) {}finally
    {
      dVC();
      AppMethodBeat.o(96201);
    }
  }
  
  private static void dVC()
  {
    AppMethodBeat.i(96197);
    synchronized (ztm)
    {
      if (bt.aO(ztn) <= 120000L)
      {
        AppMethodBeat.o(96197);
        return;
      }
      ztn = bt.HI();
      ztm.clear();
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
    String zto = "";
    int ztp = 0;
    int ztq = -1;
    long ztr = -1L;
    long zts = -1L;
  }
  
  static final class b
  {
    long baQ = -1L;
    int mHeight = -1;
    String mMimeType = "";
    int mWidth = -1;
    String zto = "";
    int ztq = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.c
 * JD-Core Version:    0.7.0.1
 */