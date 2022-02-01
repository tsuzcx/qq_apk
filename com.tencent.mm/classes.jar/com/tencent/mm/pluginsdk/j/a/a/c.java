package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.Util;

final class c
  extends l
{
  final long IBJ;
  volatile boolean IOp;
  volatile byte[] JYY;
  private final boolean dEU;
  final long fileSize;
  final String md5;
  
  private c(String paramString1, int paramInt1, String paramString2, boolean paramBoolean, long paramLong1, String paramString3, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    super(paramString1, i.aee(paramString1), String.valueOf(paramInt1), "CheckResUpdate", paramString3, "GET", paramInt2, paramInt3, paramInt4);
    AppMethodBeat.i(151943);
    this.md5 = paramString2;
    this.IBJ = paramLong1;
    this.dEU = paramBoolean;
    this.fileSize = paramLong2;
    AppMethodBeat.o(151943);
  }
  
  static c d(s params)
  {
    AppMethodBeat.i(151945);
    params = new c(params.field_urlKey, Util.getInt(params.field_fileVersion, 0), params.field_md5, Util.nullAsNil(params.field_groupId2).equals("NewXml"), params.field_reportId, params.field_url, params.field_maxRetryTimes, params.field_fileSize, params.field_networkType, params.field_priority);
    AppMethodBeat.o(151945);
    return params;
  }
  
  public final String avy()
  {
    return "CheckResUpdate";
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(151944);
    String str = i.aee(this.JYs);
    AppMethodBeat.o(151944);
    return str;
  }
  
  public final boolean gnI()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.c
 * JD-Core Version:    0.7.0.1
 */