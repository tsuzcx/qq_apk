package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.k.a.c.f.b;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements f.b
{
  final long PvW;
  final String QYU;
  final boolean QYV;
  final boolean QYW;
  final String QYX;
  final int QYY;
  final byte[] QYZ;
  final boolean QZa;
  final String QZb;
  final int QZc;
  final int QZd;
  final String filePath;
  final int fxC;
  final int fxD;
  final boolean fxE;
  final String fxF;
  final int subType;
  final String url;
  
  private a(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, String paramString3, int paramInt4, byte[] paramArrayOfByte, String paramString4, boolean paramBoolean4, long paramLong, String paramString5, String paramString6, int paramInt5, int paramInt6)
  {
    this.QYU = paramString1;
    this.fxC = paramInt1;
    this.subType = paramInt2;
    this.fxD = paramInt3;
    this.fxE = paramBoolean1;
    this.filePath = paramString2;
    this.QYV = paramBoolean2;
    this.QYW = paramBoolean3;
    this.QYX = paramString3;
    this.QYY = paramInt4;
    this.QYZ = paramArrayOfByte;
    this.fxF = paramString4;
    this.QZa = paramBoolean4;
    this.PvW = paramLong;
    this.QZb = paramString5;
    this.url = paramString6;
    this.QZc = paramInt5;
    this.QZd = paramInt6;
  }
  
  public static a a(r paramr)
  {
    AppMethodBeat.i(151909);
    paramr = new a(paramr.field_urlKey, paramr.field_resType, paramr.field_subType, Util.getInt(paramr.field_fileVersion, 0), paramr.field_fileUpdated, paramr.field_filePath, paramr.field_fileEncrypt, paramr.field_fileCompress, paramr.field_encryptKey, paramr.field_keyVersion, paramr.field_eccSignature, paramr.field_originalMd5, Util.nullAsNil(paramr.field_groupId2).equals("NewXml"), paramr.field_reportId, paramr.field_sampleId, paramr.field_url, paramr.field_maxRetryTimes, paramr.field_retryTimes);
    AppMethodBeat.o(151909);
    return paramr;
  }
  
  public final String hig()
  {
    return this.QYU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.a
 * JD-Core Version:    0.7.0.1
 */