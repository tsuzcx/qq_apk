package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bo;

final class c
  extends l
{
  private final boolean coQ;
  final String cqq;
  final long fileSize;
  volatile boolean uOQ;
  final long vMR;
  volatile byte[] vNq;
  
  private c(String paramString1, int paramInt1, String paramString2, boolean paramBoolean, long paramLong1, String paramString3, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    super(paramString1, i.alH(paramString1), String.valueOf(paramInt1), "CheckResUpdate", paramString3, "GET", paramInt2, paramInt3, paramInt4);
    AppMethodBeat.i(79500);
    this.cqq = paramString2;
    this.vMR = paramLong1;
    this.coQ = paramBoolean;
    this.fileSize = paramLong2;
    AppMethodBeat.o(79500);
  }
  
  static c d(s params)
  {
    AppMethodBeat.i(79502);
    params = new c(params.field_urlKey, bo.getInt(params.field_fileVersion, 0), params.field_md5, bo.nullAsNil(params.field_groupId2).equals("NewXml"), params.field_reportId, params.field_url, params.field_maxRetryTimes, params.field_fileSize, params.field_networkType, params.field_priority);
    AppMethodBeat.o(79502);
    return params;
  }
  
  public final String avS()
  {
    return "CheckResUpdate";
  }
  
  public final boolean dmh()
  {
    return true;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(79501);
    String str = i.alH(this.vMK);
    AppMethodBeat.o(79501);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.c
 * JD-Core Version:    0.7.0.1
 */