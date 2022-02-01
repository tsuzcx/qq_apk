package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.a;
import com.tencent.mm.pluginsdk.j.a.c.a.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.bt;

final class g
  extends a
{
  final long DAq;
  final byte[] EPJ;
  final boolean EPK;
  final boolean EPL;
  private final int EPM;
  private final String EPh;
  final int EPi;
  private final byte[] EPj;
  private final String EPl;
  final String dmA;
  final boolean dmD;
  final int dmx;
  private final boolean dmz;
  final long fileSize;
  final int subType;
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString3, int paramInt4, int paramInt5, long paramLong2, String paramString4, byte[] paramArrayOfByte1, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, long paramLong3, boolean paramBoolean3, boolean paramBoolean4, int paramInt8) {}
  
  public final int aLZ(String paramString)
  {
    AppMethodBeat.i(151962);
    int i = bt.getInt(this.EQv, 0);
    int j = bt.getInt(paramString, 0);
    AppMethodBeat.o(151962);
    return i - j;
  }
  
  public final s faL()
  {
    AppMethodBeat.i(151961);
    s locals = super.faL();
    locals.field_fileUpdated = this.dmz;
    locals.field_resType = this.dmx;
    locals.field_subType = this.subType;
    locals.field_reportId = this.DAq;
    locals.field_sampleId = this.EPl;
    locals.field_eccSignature = this.EPj;
    locals.field_originalMd5 = this.dmA;
    locals.field_fileCompress = this.EPK;
    locals.field_fileEncrypt = this.EPL;
    locals.field_encryptKey = this.EPh;
    locals.field_keyVersion = this.EPi;
    locals.field_fileSize = this.fileSize;
    locals.field_EID = this.EPM;
    AppMethodBeat.o(151961);
    return locals;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151960);
    String str = "CheckResUpdateRequest | fileUpdated=" + this.dmz + ", resType=" + this.dmx + ", subType=" + this.subType + ", reportId=" + this.DAq + ", sampleId='" + this.EPl + '\'' + ", originalMd5='" + this.dmA + '\'' + ", fileCompress=" + this.EPK + ", fileEncrypt=" + this.EPL + ", encryptKey='" + this.EPh + '\'' + ", keyVersion=" + this.EPi + ", EID=" + this.EPM + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.dmD + " | " + super.toString();
    AppMethodBeat.o(151960);
    return str;
  }
  
  public static final class a
    extends a.a<g>
  {
    long DAq;
    byte[] EPJ;
    boolean EPK;
    boolean EPL;
    int EPM;
    String EPh;
    int EPi;
    byte[] EPj;
    String EPl;
    String dmA;
    boolean dmD;
    int dmx;
    int dmy;
    private boolean dmz;
    long fileSize = 0L;
    int subType;
    
    public a(String paramString)
    {
      super();
    }
    
    public final g faM()
    {
      AppMethodBeat.i(151958);
      g localg = new g(this.url, this.EPe, this.dmy, this.networkType, this.EPm, this.ioS, this.md5, this.dmx, this.subType, this.DAq, this.EPl, this.EPj, this.dmA, this.EPK, this.EPL, this.EPh, this.EPi, this.EPM, this.EPJ, this.fileSize, this.dmD, this.dmz, this.priority);
      AppMethodBeat.o(151958);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.g
 * JD-Core Version:    0.7.0.1
 */