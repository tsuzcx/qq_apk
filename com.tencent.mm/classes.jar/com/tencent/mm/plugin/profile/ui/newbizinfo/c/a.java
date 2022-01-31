package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static int naq = 0;
  public static int nar = 1;
  public static int nas = 2;
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4)
  {
    y.d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s decryptUserName:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4 });
    h.nFQ.f(10298, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, paramString3, paramString4 });
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    a(paramString, paramInt1, wg(paramInt2), 1, paramLong, 0L, paramInt3, 0, 0, 0, "", "", "");
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramInt1, wg(paramInt2), 3, paramLong, 0L, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramInt1, wg(paramInt2), 2, paramLong1, paramLong2, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramString3, paramString4);
  }
  
  public static String bY(List<b> paramList)
  {
    if (paramList == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      localStringBuilder.append(localb.nal + "#" + localb.nam + "#" + localb.nan + ";");
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static String bZ(List<e> paramList)
  {
    if (paramList == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      e locale = (e)paramList.next();
      localStringBuilder.append(locale.id + "#" + locale.key + ";");
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private static int wg(int paramInt)
  {
    if (paramInt == 0) {
      return nar;
    }
    if (paramInt == 1) {
      return nas;
    }
    return naq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.a
 * JD-Core Version:    0.7.0.1
 */