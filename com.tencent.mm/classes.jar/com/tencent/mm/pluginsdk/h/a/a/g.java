package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.a.c.a;
import com.tencent.mm.pluginsdk.h.a.c.a.a;
import com.tencent.mm.pluginsdk.h.a.c.s;
import com.tencent.mm.sdk.platformtools.bt;

final class g
  extends a
{
  private final String BRO;
  final int BRP;
  private final byte[] BRQ;
  final long BRS;
  private final String BRT;
  final byte[] BSr;
  final boolean BSs;
  final boolean BSt;
  private final int BSu;
  final int ddH;
  private final boolean ddJ;
  final String ddK;
  final boolean ddN;
  final long fileSize;
  final int subType;
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString3, int paramInt4, int paramInt5, long paramLong2, String paramString4, byte[] paramArrayOfByte1, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, long paramLong3, boolean paramBoolean3, boolean paramBoolean4, int paramInt8) {}
  
  public final int aBh(String paramString)
  {
    AppMethodBeat.i(151962);
    int i = bt.getInt(this.BTd, 0);
    int j = bt.getInt(paramString, 0);
    AppMethodBeat.o(151962);
    return i - j;
  }
  
  public final s ewu()
  {
    AppMethodBeat.i(151961);
    s locals = super.ewu();
    locals.field_fileUpdated = this.ddJ;
    locals.field_resType = this.ddH;
    locals.field_subType = this.subType;
    locals.field_reportId = this.BRS;
    locals.field_sampleId = this.BRT;
    locals.field_eccSignature = this.BRQ;
    locals.field_originalMd5 = this.ddK;
    locals.field_fileCompress = this.BSs;
    locals.field_fileEncrypt = this.BSt;
    locals.field_encryptKey = this.BRO;
    locals.field_keyVersion = this.BRP;
    locals.field_fileSize = this.fileSize;
    locals.field_EID = this.BSu;
    AppMethodBeat.o(151961);
    return locals;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151960);
    String str = "CheckResUpdateRequest | fileUpdated=" + this.ddJ + ", resType=" + this.ddH + ", subType=" + this.subType + ", reportId=" + this.BRS + ", sampleId='" + this.BRT + '\'' + ", originalMd5='" + this.ddK + '\'' + ", fileCompress=" + this.BSs + ", fileEncrypt=" + this.BSt + ", encryptKey='" + this.BRO + '\'' + ", keyVersion=" + this.BRP + ", EID=" + this.BSu + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.ddN + " | " + super.toString();
    AppMethodBeat.o(151960);
    return str;
  }
  
  public static final class a
    extends a.a<g>
  {
    String BRO;
    int BRP;
    byte[] BRQ;
    long BRS;
    String BRT;
    byte[] BSr;
    boolean BSs;
    boolean BSt;
    int BSu;
    int ddH;
    int ddI;
    private boolean ddJ;
    String ddK;
    boolean ddN;
    long fileSize = 0L;
    int subType;
    
    public a(String paramString)
    {
      super();
    }
    
    public final g ewv()
    {
      AppMethodBeat.i(151958);
      g localg = new g(this.url, this.BRL, this.ddI, this.networkType, this.BRU, this.huV, this.md5, this.ddH, this.subType, this.BRS, this.BRT, this.BRQ, this.ddK, this.BSs, this.BSt, this.BRO, this.BRP, this.BSu, this.BSr, this.fileSize, this.ddN, this.ddJ, this.priority);
      AppMethodBeat.o(151958);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.g
 * JD-Core Version:    0.7.0.1
 */