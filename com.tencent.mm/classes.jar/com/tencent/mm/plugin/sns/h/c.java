package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static Map<String, c.a> ozB = new ConcurrentHashMap();
  private static volatile long ozC = 0L;
  
  private static String Ol(String paramString)
  {
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
    str = paramString;
    if (i >= 0) {
      str = paramString.substring(i + 1);
    }
    return str;
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    try
    {
      c.b localb = new c.b((byte)0);
      localb.ozD = Ol(paramString1);
      localb.mMimeType = paramString2;
      localb.mWidth = paramInt1;
      localb.mHeight = paramInt2;
      localb.ozF = paramInt3;
      localb.ozG = paramLong;
      paramString1 = new StringBuilder(1024);
      paramString1.append(localb.ozD).append(',').append(localb.mMimeType).append(',').append(localb.mWidth).append(',').append(localb.mHeight).append(',').append(localb.ozF).append(',').append(localb.ozG);
      paramString1 = paramString1.toString();
      y.i("MicroMsg.SnsImgStats", "report up: " + paramString1);
      h.nFQ.aC(13512, paramString1);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    try
    {
      c.a locala = new c.a((byte)0);
      locala.ozD = Ol(paramString2);
      locala.ozE = paramInt1;
      locala.mMimeType = paramString3;
      locala.mWidth = paramInt2;
      locala.mHeight = paramInt3;
      locala.ozF = paramInt4;
      locala.ozG = paramLong1;
      locala.ozH = paramLong2;
      ozB.put(paramString1, locala);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void aj(String paramString, long paramLong)
  {
    try
    {
      paramString = (c.a)ozB.remove(paramString);
      if (paramString == null) {
        return;
      }
      paramString.ozI = paramLong;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append(paramString.ozD).append(',').append(paramString.ozE).append(',').append(paramString.mMimeType).append(',').append(paramString.mWidth).append(',').append(paramString.mHeight).append(',').append(paramString.ozF).append(',').append(paramString.ozG).append(',').append(paramString.ozH).append(',').append(paramString.ozI);
      paramString = localStringBuilder.toString();
      y.i("MicroMsg.SnsImgStats", "report dl: " + paramString);
      h.nFQ.aC(13513, paramString);
      return;
    }
    catch (Exception paramString) {}finally
    {
      bEB();
    }
  }
  
  private static void bEB()
  {
    synchronized (ozB)
    {
      if (bk.cp(ozC) <= 120000L) {
        return;
      }
      ozC = bk.UZ();
      ozB.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.c
 * JD-Core Version:    0.7.0.1
 */