package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bk;

final class g
  extends a
{
  final boolean bHB;
  final int bHv;
  private final boolean bHx;
  final int brC;
  final long fileSize;
  private final String rVW;
  final int rVX;
  private final byte[] rVY;
  final String rVZ;
  final boolean rWA;
  private final int rWB;
  final long rWb;
  private final String rWc;
  final byte[] rWy;
  final boolean rWz;
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString3, int paramInt4, int paramInt5, long paramLong2, String paramString4, byte[] paramArrayOfByte1, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, long paramLong3, boolean paramBoolean3, boolean paramBoolean4, int paramInt8) {}
  
  protected final int Wf(String paramString)
  {
    return bk.getInt(this.rXl, 0) - bk.getInt(paramString, 0);
  }
  
  public final s clx()
  {
    s locals = super.clx();
    locals.field_fileUpdated = this.bHx;
    locals.field_resType = this.bHv;
    locals.field_subType = this.brC;
    locals.field_reportId = this.rWb;
    locals.field_sampleId = this.rWc;
    locals.field_eccSignature = this.rVY;
    locals.field_originalMd5 = this.rVZ;
    locals.field_fileCompress = this.rWz;
    locals.field_fileEncrypt = this.rWA;
    locals.field_encryptKey = this.rVW;
    locals.field_keyVersion = this.rVX;
    locals.field_fileSize = this.fileSize;
    locals.field_EID = this.rWB;
    return locals;
  }
  
  public final String toString()
  {
    return "CheckResUpdateRequest | fileUpdated=" + this.bHx + ", resType=" + this.bHv + ", subType=" + this.brC + ", reportId=" + this.rWb + ", sampleId='" + this.rWc + '\'' + ", originalMd5='" + this.rVZ + '\'' + ", fileCompress=" + this.rWz + ", fileEncrypt=" + this.rWA + ", encryptKey='" + this.rVW + '\'' + ", keyVersion=" + this.rVX + ", EID=" + this.rWB + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.bHB + " | " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.g
 * JD-Core Version:    0.7.0.1
 */