package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.f.b;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  implements f.b
{
  final long DAq;
  final String EPe;
  final boolean EPf;
  final boolean EPg;
  final String EPh;
  final int EPi;
  final byte[] EPj;
  final boolean EPk;
  final String EPl;
  final int EPm;
  final int EPn;
  final String dmA;
  final int dmx;
  final int dmy;
  final boolean dmz;
  final String filePath;
  final int subType;
  final String url;
  
  private a(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, String paramString3, int paramInt4, byte[] paramArrayOfByte, String paramString4, boolean paramBoolean4, long paramLong, String paramString5, String paramString6, int paramInt5, int paramInt6)
  {
    this.EPe = paramString1;
    this.dmx = paramInt1;
    this.subType = paramInt2;
    this.dmy = paramInt3;
    this.dmz = paramBoolean1;
    this.filePath = paramString2;
    this.EPf = paramBoolean2;
    this.EPg = paramBoolean3;
    this.EPh = paramString3;
    this.EPi = paramInt4;
    this.EPj = paramArrayOfByte;
    this.dmA = paramString4;
    this.EPk = paramBoolean4;
    this.DAq = paramLong;
    this.EPl = paramString5;
    this.url = paramString6;
    this.EPm = paramInt5;
    this.EPn = paramInt6;
  }
  
  public static a a(s params)
  {
    AppMethodBeat.i(151909);
    params = new a(params.field_urlKey, params.field_resType, params.field_subType, bt.getInt(params.field_fileVersion, 0), params.field_fileUpdated, params.field_filePath, params.field_fileEncrypt, params.field_fileCompress, params.field_encryptKey, params.field_keyVersion, params.field_eccSignature, params.field_originalMd5, bt.nullAsNil(params.field_groupId2).equals("NewXml"), params.field_reportId, params.field_sampleId, params.field_url, params.field_maxRetryTimes, params.field_retryTimes);
    AppMethodBeat.o(151909);
    return params;
  }
  
  public final String faC()
  {
    return this.EPe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.a
 * JD-Core Version:    0.7.0.1
 */