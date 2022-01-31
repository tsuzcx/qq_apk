package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bk;

final class c
  extends l
{
  private final boolean bHB;
  final String bIW;
  final long fileSize;
  volatile boolean qZj;
  final long rWb;
  volatile byte[] rWy;
  
  private c(String paramString1, int paramInt1, String paramString2, boolean paramBoolean, long paramLong1, String paramString3, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    super(paramString1, i.Wg(paramString1), String.valueOf(paramInt1), "CheckResUpdate", paramString3, "GET", paramInt2, paramInt3, paramInt4);
    this.bIW = paramString2;
    this.rWb = paramLong1;
    this.bHB = paramBoolean;
    this.fileSize = paramLong2;
  }
  
  static c c(s params)
  {
    return new c(params.field_urlKey, bk.getInt(params.field_fileVersion, 0), params.field_md5, bk.pm(params.field_groupId2).equals("NewXml"), params.field_reportId, params.field_url, params.field_maxRetryTimes, params.field_fileSize, params.field_networkType, params.field_priority);
  }
  
  public final String acb()
  {
    return "CheckResUpdate";
  }
  
  public final String bjl()
  {
    return i.Wg(this.rVT);
  }
  
  public final boolean clw()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.c
 * JD-Core Version:    0.7.0.1
 */