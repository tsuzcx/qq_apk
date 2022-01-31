package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.f.b;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  implements f.b
{
  final int coJ;
  final int coK;
  final boolean coL;
  final String coM;
  final String filePath;
  final int subType;
  final String url;
  final String vMK;
  final boolean vML;
  final boolean vMM;
  final String vMN;
  final int vMO;
  final byte[] vMP;
  final boolean vMQ;
  final long vMR;
  final String vMS;
  final int vMT;
  final int vMU;
  
  private a(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, String paramString3, int paramInt4, byte[] paramArrayOfByte, String paramString4, boolean paramBoolean4, long paramLong, String paramString5, String paramString6, int paramInt5, int paramInt6)
  {
    this.vMK = paramString1;
    this.coJ = paramInt1;
    this.subType = paramInt2;
    this.coK = paramInt3;
    this.coL = paramBoolean1;
    this.filePath = paramString2;
    this.vML = paramBoolean2;
    this.vMM = paramBoolean3;
    this.vMN = paramString3;
    this.vMO = paramInt4;
    this.vMP = paramArrayOfByte;
    this.coM = paramString4;
    this.vMQ = paramBoolean4;
    this.vMR = paramLong;
    this.vMS = paramString5;
    this.url = paramString6;
    this.vMT = paramInt5;
    this.vMU = paramInt6;
  }
  
  public static a a(s params)
  {
    AppMethodBeat.i(79466);
    params = new a(params.field_urlKey, params.field_resType, params.field_subType, bo.getInt(params.field_fileVersion, 0), params.field_fileUpdated, params.field_filePath, params.field_fileEncrypt, params.field_fileCompress, params.field_encryptKey, params.field_keyVersion, params.field_eccSignature, params.field_originalMd5, bo.nullAsNil(params.field_groupId2).equals("NewXml"), params.field_reportId, params.field_sampleId, params.field_url, params.field_maxRetryTimes, params.field_retryTimes);
    AppMethodBeat.o(79466);
    return params;
  }
  
  public final String dlZ()
  {
    return this.vMK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.a
 * JD-Core Version:    0.7.0.1
 */