package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.f.b;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements f.b
{
  final long IBJ;
  final int JYA;
  final int JYB;
  final String JYs;
  final boolean JYt;
  final boolean JYu;
  final String JYv;
  final int JYw;
  final byte[] JYx;
  final boolean JYy;
  final String JYz;
  final int dEO;
  final int dEP;
  final boolean dEQ;
  final String dER;
  final String filePath;
  final int subType;
  final String url;
  
  private a(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, String paramString3, int paramInt4, byte[] paramArrayOfByte, String paramString4, boolean paramBoolean4, long paramLong, String paramString5, String paramString6, int paramInt5, int paramInt6)
  {
    this.JYs = paramString1;
    this.dEO = paramInt1;
    this.subType = paramInt2;
    this.dEP = paramInt3;
    this.dEQ = paramBoolean1;
    this.filePath = paramString2;
    this.JYt = paramBoolean2;
    this.JYu = paramBoolean3;
    this.JYv = paramString3;
    this.JYw = paramInt4;
    this.JYx = paramArrayOfByte;
    this.dER = paramString4;
    this.JYy = paramBoolean4;
    this.IBJ = paramLong;
    this.JYz = paramString5;
    this.url = paramString6;
    this.JYA = paramInt5;
    this.JYB = paramInt6;
  }
  
  public static a a(s params)
  {
    AppMethodBeat.i(151909);
    params = new a(params.field_urlKey, params.field_resType, params.field_subType, Util.getInt(params.field_fileVersion, 0), params.field_fileUpdated, params.field_filePath, params.field_fileEncrypt, params.field_fileCompress, params.field_encryptKey, params.field_keyVersion, params.field_eccSignature, params.field_originalMd5, Util.nullAsNil(params.field_groupId2).equals("NewXml"), params.field_reportId, params.field_sampleId, params.field_url, params.field_maxRetryTimes, params.field_retryTimes);
    AppMethodBeat.o(151909);
    return params;
  }
  
  public final String gnA()
  {
    return this.JYs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.a
 * JD-Core Version:    0.7.0.1
 */