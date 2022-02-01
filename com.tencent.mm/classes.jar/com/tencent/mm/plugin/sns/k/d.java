package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static Map<String, a> wQL;
  private static volatile long wQM;
  
  static
  {
    AppMethodBeat.i(96202);
    wQL = new ConcurrentHashMap();
    wQM = 0L;
    AppMethodBeat.o(96202);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(96199);
    try
    {
      b localb = new b((byte)0);
      localb.wQN = apn(paramString1);
      localb.mMimeType = paramString2;
      localb.mWidth = paramInt1;
      localb.mHeight = paramInt2;
      localb.wQP = paramInt3;
      localb.aPG = paramLong;
      paramString1 = new StringBuilder(1024);
      paramString1.append(localb.wQN).append(',').append(localb.mMimeType).append(',').append(localb.mWidth).append(',').append(localb.mHeight).append(',').append(localb.wQP).append(',').append(localb.aPG);
      paramString1 = paramString1.toString();
      ad.i("MicroMsg.SnsImgStats", "report up: ".concat(String.valueOf(paramString1)));
      h.vKh.kvStat(13512, paramString1);
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
      locala.wQN = apn(paramString2);
      locala.wQO = paramInt1;
      locala.mMimeType = paramString3;
      locala.mWidth = paramInt2;
      locala.mHeight = paramInt3;
      locala.wQP = paramInt4;
      locala.aPG = paramLong1;
      locala.wQQ = paramLong2;
      wQL.put(paramString1, locala);
      AppMethodBeat.o(96200);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(96200);
    }
  }
  
  private static String apn(String paramString)
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
  
  public static void bf(String paramString, long paramLong)
  {
    AppMethodBeat.i(96201);
    try
    {
      paramString = (a)wQL.remove(paramString);
      if (paramString == null) {
        return;
      }
      paramString.wQR = paramLong;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append(paramString.wQN).append(',').append(paramString.wQO).append(',').append(paramString.mMimeType).append(',').append(paramString.mWidth).append(',').append(paramString.mHeight).append(',').append(paramString.wQP).append(',').append(paramString.aPG).append(',').append(paramString.wQQ).append(',').append(paramString.wQR);
      paramString = localStringBuilder.toString();
      ad.i("MicroMsg.SnsImgStats", "report dl: ".concat(String.valueOf(paramString)));
      h.vKh.kvStat(13513, paramString);
      return;
    }
    catch (Exception paramString) {}finally
    {
      duQ();
      AppMethodBeat.o(96201);
    }
  }
  
  private static void duQ()
  {
    AppMethodBeat.i(96197);
    synchronized (wQL)
    {
      if (bt.aS(wQM) <= 120000L)
      {
        AppMethodBeat.o(96197);
        return;
      }
      wQM = bt.GC();
      wQL.clear();
      AppMethodBeat.o(96197);
      return;
    }
  }
  
  static final class a
  {
    long aPG = -1L;
    int mHeight = -1;
    String mMimeType = "";
    int mWidth = -1;
    String wQN = "";
    int wQO = 0;
    int wQP = -1;
    long wQQ = -1L;
    long wQR = -1L;
  }
  
  static final class b
  {
    long aPG = -1L;
    int mHeight = -1;
    String mMimeType = "";
    int mWidth = -1;
    String wQN = "";
    int wQP = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.d
 * JD-Core Version:    0.7.0.1
 */