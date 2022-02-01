package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.a.c.f.b;
import com.tencent.mm.pluginsdk.h.a.c.s;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  implements f.b
{
  final String Dkb;
  final boolean Dkc;
  final boolean Dkd;
  final String Dke;
  final int Dkf;
  final byte[] Dkg;
  final boolean Dkh;
  final long Dki;
  final String Dkj;
  final int Dkk;
  final int Dkl;
  final int dbd;
  final int dbe;
  final boolean dbf;
  final String dbg;
  final String filePath;
  final int subType;
  final String url;
  
  private a(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, String paramString3, int paramInt4, byte[] paramArrayOfByte, String paramString4, boolean paramBoolean4, long paramLong, String paramString5, String paramString6, int paramInt5, int paramInt6)
  {
    this.Dkb = paramString1;
    this.dbd = paramInt1;
    this.subType = paramInt2;
    this.dbe = paramInt3;
    this.dbf = paramBoolean1;
    this.filePath = paramString2;
    this.Dkc = paramBoolean2;
    this.Dkd = paramBoolean3;
    this.Dke = paramString3;
    this.Dkf = paramInt4;
    this.Dkg = paramArrayOfByte;
    this.dbg = paramString4;
    this.Dkh = paramBoolean4;
    this.Dki = paramLong;
    this.Dkj = paramString5;
    this.url = paramString6;
    this.Dkk = paramInt5;
    this.Dkl = paramInt6;
  }
  
  public static a a(s params)
  {
    AppMethodBeat.i(151909);
    params = new a(params.field_urlKey, params.field_resType, params.field_subType, bs.getInt(params.field_fileVersion, 0), params.field_fileUpdated, params.field_filePath, params.field_fileEncrypt, params.field_fileCompress, params.field_encryptKey, params.field_keyVersion, params.field_eccSignature, params.field_originalMd5, bs.nullAsNil(params.field_groupId2).equals("NewXml"), params.field_reportId, params.field_sampleId, params.field_url, params.field_maxRetryTimes, params.field_retryTimes);
    AppMethodBeat.o(151909);
    return params;
  }
  
  public final String eLF()
  {
    return this.Dkb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.a
 * JD-Core Version:    0.7.0.1
 */