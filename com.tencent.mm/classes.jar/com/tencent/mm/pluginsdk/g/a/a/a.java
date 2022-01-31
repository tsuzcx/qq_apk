package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.f.b;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bk;

public final class a
  implements f.b
{
  final int bHv;
  final int bHw;
  final boolean bHx;
  final int brC;
  final String filePath;
  final String rVT;
  final boolean rVU;
  final boolean rVV;
  final String rVW;
  final int rVX;
  final byte[] rVY;
  final String rVZ;
  final boolean rWa;
  final long rWb;
  final String rWc;
  final int rWd;
  final int rWe;
  final String url;
  
  private a(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, String paramString3, int paramInt4, byte[] paramArrayOfByte, String paramString4, boolean paramBoolean4, long paramLong, String paramString5, String paramString6, int paramInt5, int paramInt6)
  {
    this.rVT = paramString1;
    this.bHv = paramInt1;
    this.brC = paramInt2;
    this.bHw = paramInt3;
    this.bHx = paramBoolean1;
    this.filePath = paramString2;
    this.rVU = paramBoolean2;
    this.rVV = paramBoolean3;
    this.rVW = paramString3;
    this.rVX = paramInt4;
    this.rVY = paramArrayOfByte;
    this.rVZ = paramString4;
    this.rWa = paramBoolean4;
    this.rWb = paramLong;
    this.rWc = paramString5;
    this.url = paramString6;
    this.rWd = paramInt5;
    this.rWe = paramInt6;
  }
  
  public static a a(s params)
  {
    return new a(params.field_urlKey, params.field_resType, params.field_subType, bk.getInt(params.field_fileVersion, 0), params.field_fileUpdated, params.field_filePath, params.field_fileEncrypt, params.field_fileCompress, params.field_encryptKey, params.field_keyVersion, params.field_eccSignature, params.field_originalMd5, bk.pm(params.field_groupId2).equals("NewXml"), params.field_reportId, params.field_sampleId, params.field_url, params.field_maxRetryTimes, params.field_retryTimes);
  }
  
  public final String cls()
  {
    return this.rVT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.a
 * JD-Core Version:    0.7.0.1
 */