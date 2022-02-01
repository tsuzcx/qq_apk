package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.a.c.f.b;
import com.tencent.mm.pluginsdk.h.a.c.s;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  implements f.b
{
  final String BRL;
  final boolean BRM;
  final boolean BRN;
  final String BRO;
  final int BRP;
  final byte[] BRQ;
  final boolean BRR;
  final long BRS;
  final String BRT;
  final int BRU;
  final int BRV;
  final int ddH;
  final int ddI;
  final boolean ddJ;
  final String ddK;
  final String filePath;
  final int subType;
  final String url;
  
  private a(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, String paramString3, int paramInt4, byte[] paramArrayOfByte, String paramString4, boolean paramBoolean4, long paramLong, String paramString5, String paramString6, int paramInt5, int paramInt6)
  {
    this.BRL = paramString1;
    this.ddH = paramInt1;
    this.subType = paramInt2;
    this.ddI = paramInt3;
    this.ddJ = paramBoolean1;
    this.filePath = paramString2;
    this.BRM = paramBoolean2;
    this.BRN = paramBoolean3;
    this.BRO = paramString3;
    this.BRP = paramInt4;
    this.BRQ = paramArrayOfByte;
    this.ddK = paramString4;
    this.BRR = paramBoolean4;
    this.BRS = paramLong;
    this.BRT = paramString5;
    this.url = paramString6;
    this.BRU = paramInt5;
    this.BRV = paramInt6;
  }
  
  public static a a(s params)
  {
    AppMethodBeat.i(151909);
    params = new a(params.field_urlKey, params.field_resType, params.field_subType, bt.getInt(params.field_fileVersion, 0), params.field_fileUpdated, params.field_filePath, params.field_fileEncrypt, params.field_fileCompress, params.field_encryptKey, params.field_keyVersion, params.field_eccSignature, params.field_originalMd5, bt.nullAsNil(params.field_groupId2).equals("NewXml"), params.field_reportId, params.field_sampleId, params.field_url, params.field_maxRetryTimes, params.field_retryTimes);
    AppMethodBeat.o(151909);
    return params;
  }
  
  public final String ewl()
  {
    return this.BRL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.a
 * JD-Core Version:    0.7.0.1
 */