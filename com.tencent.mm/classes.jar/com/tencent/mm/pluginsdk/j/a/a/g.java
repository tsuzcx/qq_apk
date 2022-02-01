package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.a;
import com.tencent.mm.pluginsdk.j.a.c.a.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.Util;

final class g
  extends a
{
  final long IBJ;
  final byte[] JYY;
  final boolean JYZ;
  private final String JYv;
  final int JYw;
  private final byte[] JYx;
  private final String JYz;
  final boolean JZa;
  private final int JZb;
  final int dEO;
  private final boolean dEQ;
  final String dER;
  final boolean dEU;
  final long fileSize;
  final int subType;
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString3, int paramInt4, int paramInt5, long paramLong2, String paramString4, byte[] paramArrayOfByte1, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, long paramLong3, boolean paramBoolean3, boolean paramBoolean4, int paramInt8) {}
  
  public final int bdX(String paramString)
  {
    AppMethodBeat.i(151962);
    int i = Util.getInt(this.JZK, 0);
    int j = Util.getInt(paramString, 0);
    AppMethodBeat.o(151962);
    return i - j;
  }
  
  public final s gnJ()
  {
    AppMethodBeat.i(151961);
    s locals = super.gnJ();
    locals.field_fileUpdated = this.dEQ;
    locals.field_resType = this.dEO;
    locals.field_subType = this.subType;
    locals.field_reportId = this.IBJ;
    locals.field_sampleId = this.JYz;
    locals.field_eccSignature = this.JYx;
    locals.field_originalMd5 = this.dER;
    locals.field_fileCompress = this.JYZ;
    locals.field_fileEncrypt = this.JZa;
    locals.field_encryptKey = this.JYv;
    locals.field_keyVersion = this.JYw;
    locals.field_fileSize = this.fileSize;
    locals.field_EID = this.JZb;
    AppMethodBeat.o(151961);
    return locals;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151960);
    String str = "CheckResUpdateRequest | fileUpdated=" + this.dEQ + ", resType=" + this.dEO + ", subType=" + this.subType + ", reportId=" + this.IBJ + ", sampleId='" + this.JYz + '\'' + ", originalMd5='" + this.dER + '\'' + ", fileCompress=" + this.JYZ + ", fileEncrypt=" + this.JZa + ", encryptKey='" + this.JYv + '\'' + ", keyVersion=" + this.JYw + ", EID=" + this.JZb + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.dEU + " | " + super.toString();
    AppMethodBeat.o(151960);
    return str;
  }
  
  public static final class a
    extends a.a<g>
  {
    long IBJ;
    byte[] JYY;
    boolean JYZ;
    String JYv;
    int JYw;
    byte[] JYx;
    String JYz;
    boolean JZa;
    int JZb;
    int dEO;
    int dEP;
    private boolean dEQ;
    String dER;
    boolean dEU;
    long fileSize = 0L;
    int subType;
    
    public a(String paramString)
    {
      super();
    }
    
    public final g gnK()
    {
      AppMethodBeat.i(151958);
      g localg = new g(this.url, this.JYs, this.dEP, this.networkType, this.JYA, this.jmW, this.md5, this.dEO, this.subType, this.IBJ, this.JYz, this.JYx, this.dER, this.JYZ, this.JZa, this.JYv, this.JYw, this.JZb, this.JYY, this.fileSize, this.dEU, this.dEQ, this.priority);
      AppMethodBeat.o(151958);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.g
 * JD-Core Version:    0.7.0.1
 */