package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.f.b;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
  implements f.b
{
  final long DRK;
  final boolean FhA;
  final boolean FhB;
  final String FhC;
  final int FhD;
  final byte[] FhE;
  final boolean FhF;
  final String FhG;
  final int FhH;
  final int FhI;
  final String Fhz;
  final int dnA;
  final boolean dnB;
  final String dnC;
  final int dnz;
  final String filePath;
  final int subType;
  final String url;
  
  private a(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, String paramString3, int paramInt4, byte[] paramArrayOfByte, String paramString4, boolean paramBoolean4, long paramLong, String paramString5, String paramString6, int paramInt5, int paramInt6)
  {
    this.Fhz = paramString1;
    this.dnz = paramInt1;
    this.subType = paramInt2;
    this.dnA = paramInt3;
    this.dnB = paramBoolean1;
    this.filePath = paramString2;
    this.FhA = paramBoolean2;
    this.FhB = paramBoolean3;
    this.FhC = paramString3;
    this.FhD = paramInt4;
    this.FhE = paramArrayOfByte;
    this.dnC = paramString4;
    this.FhF = paramBoolean4;
    this.DRK = paramLong;
    this.FhG = paramString5;
    this.url = paramString6;
    this.FhH = paramInt5;
    this.FhI = paramInt6;
  }
  
  public static a a(s params)
  {
    AppMethodBeat.i(151909);
    params = new a(params.field_urlKey, params.field_resType, params.field_subType, bu.getInt(params.field_fileVersion, 0), params.field_fileUpdated, params.field_filePath, params.field_fileEncrypt, params.field_fileCompress, params.field_encryptKey, params.field_keyVersion, params.field_eccSignature, params.field_originalMd5, bu.nullAsNil(params.field_groupId2).equals("NewXml"), params.field_reportId, params.field_sampleId, params.field_url, params.field_maxRetryTimes, params.field_retryTimes);
    AppMethodBeat.o(151909);
    return params;
  }
  
  public final String feq()
  {
    return this.Fhz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.a
 * JD-Core Version:    0.7.0.1
 */