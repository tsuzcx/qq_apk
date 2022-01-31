package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bo;

final class g
  extends a
{
  final int coJ;
  private final boolean coL;
  final String coM;
  final boolean coQ;
  final long fileSize;
  final int subType;
  private final String vMN;
  final int vMO;
  private final byte[] vMP;
  final long vMR;
  private final String vMS;
  final byte[] vNq;
  final boolean vNr;
  final boolean vNs;
  private final int vNt;
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString3, int paramInt4, int paramInt5, long paramLong2, String paramString4, byte[] paramArrayOfByte1, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, long paramLong3, boolean paramBoolean3, boolean paramBoolean4, int paramInt8) {}
  
  public final int alG(String paramString)
  {
    AppMethodBeat.i(79519);
    int i = bo.getInt(this.vOd, 0);
    int j = bo.getInt(paramString, 0);
    AppMethodBeat.o(79519);
    return i - j;
  }
  
  public final s dmi()
  {
    AppMethodBeat.i(79518);
    s locals = super.dmi();
    locals.field_fileUpdated = this.coL;
    locals.field_resType = this.coJ;
    locals.field_subType = this.subType;
    locals.field_reportId = this.vMR;
    locals.field_sampleId = this.vMS;
    locals.field_eccSignature = this.vMP;
    locals.field_originalMd5 = this.coM;
    locals.field_fileCompress = this.vNr;
    locals.field_fileEncrypt = this.vNs;
    locals.field_encryptKey = this.vMN;
    locals.field_keyVersion = this.vMO;
    locals.field_fileSize = this.fileSize;
    locals.field_EID = this.vNt;
    AppMethodBeat.o(79518);
    return locals;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(79517);
    String str = "CheckResUpdateRequest | fileUpdated=" + this.coL + ", resType=" + this.coJ + ", subType=" + this.subType + ", reportId=" + this.vMR + ", sampleId='" + this.vMS + '\'' + ", originalMd5='" + this.coM + '\'' + ", fileCompress=" + this.vNr + ", fileEncrypt=" + this.vNs + ", encryptKey='" + this.vMN + '\'' + ", keyVersion=" + this.vMO + ", EID=" + this.vNt + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.coQ + " | " + super.toString();
    AppMethodBeat.o(79517);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.g
 * JD-Core Version:    0.7.0.1
 */