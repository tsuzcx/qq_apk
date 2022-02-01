package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.res.downloader.model.k;
import com.tencent.mm.pluginsdk.res.downloader.model.r;
import com.tencent.mm.sdk.platformtools.Util;

final class c
  extends k
{
  volatile boolean WAT;
  final long Wmc;
  volatile byte[] XVE;
  final long fileSize;
  private final boolean hCn;
  final String md5;
  
  private c(String paramString1, int paramInt1, String paramString2, boolean paramBoolean, long paramLong1, String paramString3, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    super(paramString1, i.afg(paramString1), String.valueOf(paramInt1), "CheckResUpdate", paramString3, "GET", paramInt2, paramInt3, paramInt4);
    AppMethodBeat.i(151943);
    this.md5 = paramString2;
    this.Wmc = paramLong1;
    this.hCn = paramBoolean;
    this.fileSize = paramLong2;
    AppMethodBeat.o(151943);
  }
  
  static c d(r paramr)
  {
    AppMethodBeat.i(151945);
    paramr = new c(paramr.field_urlKey, Util.getInt(paramr.field_fileVersion, 0), paramr.field_md5, Util.nullAsNil(paramr.field_groupId2).equals("NewXml"), paramr.field_reportId, paramr.field_url, paramr.field_maxRetryTimes, paramr.field_fileSize, paramr.field_networkType, paramr.field_priority);
    AppMethodBeat.o(151945);
    return paramr;
  }
  
  public final String aVp()
  {
    return "CheckResUpdate";
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(151944);
    String str = i.afg(this.XUX);
    AppMethodBeat.o(151944);
    return str;
  }
  
  public final boolean iJn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.c
 * JD-Core Version:    0.7.0.1
 */