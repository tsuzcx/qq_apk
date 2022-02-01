package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.res.downloader.model.f.b;
import com.tencent.mm.pluginsdk.res.downloader.model.r;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements f.b
{
  final long Wmc;
  final String XUX;
  final boolean XUY;
  final boolean XUZ;
  final String XVa;
  final int XVb;
  final byte[] XVc;
  final boolean XVd;
  final String XVe;
  final int XVf;
  final int XVg;
  final String filePath;
  final int hCh;
  final int hCi;
  final boolean hCj;
  final String hCk;
  final int subType;
  final String url;
  
  private a(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, String paramString3, int paramInt4, byte[] paramArrayOfByte, String paramString4, boolean paramBoolean4, long paramLong, String paramString5, String paramString6, int paramInt5, int paramInt6)
  {
    this.XUX = paramString1;
    this.hCh = paramInt1;
    this.subType = paramInt2;
    this.hCi = paramInt3;
    this.hCj = paramBoolean1;
    this.filePath = paramString2;
    this.XUY = paramBoolean2;
    this.XUZ = paramBoolean3;
    this.XVa = paramString3;
    this.XVb = paramInt4;
    this.XVc = paramArrayOfByte;
    this.hCk = paramString4;
    this.XVd = paramBoolean4;
    this.Wmc = paramLong;
    this.XVe = paramString5;
    this.url = paramString6;
    this.XVf = paramInt5;
    this.XVg = paramInt6;
  }
  
  public static a a(r paramr)
  {
    AppMethodBeat.i(151909);
    paramr = new a(paramr.field_urlKey, paramr.field_resType, paramr.field_subType, Util.getInt(paramr.field_fileVersion, 0), paramr.field_fileUpdated, paramr.field_filePath, paramr.field_fileEncrypt, paramr.field_fileCompress, paramr.field_encryptKey, paramr.field_keyVersion, paramr.field_eccSignature, paramr.field_originalMd5, Util.nullAsNil(paramr.field_groupId2).equals("NewXml"), paramr.field_reportId, paramr.field_sampleId, paramr.field_url, paramr.field_maxRetryTimes, paramr.field_retryTimes);
    AppMethodBeat.o(151909);
    return paramr;
  }
  
  public final String iJd()
  {
    return this.XUX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.a
 * JD-Core Version:    0.7.0.1
 */