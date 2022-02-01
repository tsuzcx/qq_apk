package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static Map<String, a> ydr;
  private static volatile long yds;
  
  static
  {
    AppMethodBeat.i(96202);
    ydr = new ConcurrentHashMap();
    yds = 0L;
    AppMethodBeat.o(96202);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(96199);
    try
    {
      b localb = new b((byte)0);
      localb.ydt = auy(paramString1);
      localb.mMimeType = paramString2;
      localb.mWidth = paramInt1;
      localb.mHeight = paramInt2;
      localb.ydv = paramInt3;
      localb.aQw = paramLong;
      paramString1 = new StringBuilder(1024);
      paramString1.append(localb.ydt).append(',').append(localb.mMimeType).append(',').append(localb.mWidth).append(',').append(localb.mHeight).append(',').append(localb.ydv).append(',').append(localb.aQw);
      paramString1 = paramString1.toString();
      ac.i("MicroMsg.SnsImgStats", "report up: ".concat(String.valueOf(paramString1)));
      h.wUl.kvStat(13512, paramString1);
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
      locala.ydt = auy(paramString2);
      locala.ydu = paramInt1;
      locala.mMimeType = paramString3;
      locala.mWidth = paramInt2;
      locala.mHeight = paramInt3;
      locala.ydv = paramInt4;
      locala.aQw = paramLong1;
      locala.ydw = paramLong2;
      ydr.put(paramString1, locala);
      AppMethodBeat.o(96200);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(96200);
    }
  }
  
  private static String auy(String paramString)
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
  
  public static void bh(String paramString, long paramLong)
  {
    AppMethodBeat.i(96201);
    try
    {
      paramString = (a)ydr.remove(paramString);
      if (paramString == null) {
        return;
      }
      paramString.ydx = paramLong;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append(paramString.ydt).append(',').append(paramString.ydu).append(',').append(paramString.mMimeType).append(',').append(paramString.mWidth).append(',').append(paramString.mHeight).append(',').append(paramString.ydv).append(',').append(paramString.aQw).append(',').append(paramString.ydw).append(',').append(paramString.ydx);
      paramString = localStringBuilder.toString();
      ac.i("MicroMsg.SnsImgStats", "report dl: ".concat(String.valueOf(paramString)));
      h.wUl.kvStat(13513, paramString);
      return;
    }
    catch (Exception paramString) {}finally
    {
      dJp();
      AppMethodBeat.o(96201);
    }
  }
  
  private static void dJp()
  {
    AppMethodBeat.i(96197);
    synchronized (ydr)
    {
      if (bs.aO(yds) <= 120000L)
      {
        AppMethodBeat.o(96197);
        return;
      }
      yds = bs.Gn();
      ydr.clear();
      AppMethodBeat.o(96197);
      return;
    }
  }
  
  static final class a
  {
    long aQw = -1L;
    int mHeight = -1;
    String mMimeType = "";
    int mWidth = -1;
    String ydt = "";
    int ydu = 0;
    int ydv = -1;
    long ydw = -1L;
    long ydx = -1L;
  }
  
  static final class b
  {
    long aQw = -1L;
    int mHeight = -1;
    String mMimeType = "";
    int mWidth = -1;
    String ydt = "";
    int ydv = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.d
 * JD-Core Version:    0.7.0.1
 */