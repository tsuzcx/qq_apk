package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.a.c.a;
import com.tencent.mm.pluginsdk.h.a.c.a.a;
import com.tencent.mm.pluginsdk.h.a.c.s;
import com.tencent.mm.sdk.platformtools.bs;

final class g
  extends a
{
  final byte[] DkH;
  final boolean DkI;
  final boolean DkJ;
  private final int DkK;
  private final String Dke;
  final int Dkf;
  private final byte[] Dkg;
  final long Dki;
  private final String Dkj;
  final int dbd;
  private final boolean dbf;
  final String dbg;
  final boolean dbj;
  final long fileSize;
  final int subType;
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString3, int paramInt4, int paramInt5, long paramLong2, String paramString4, byte[] paramArrayOfByte1, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, long paramLong3, boolean paramBoolean3, boolean paramBoolean4, int paramInt8) {}
  
  public final int aGz(String paramString)
  {
    AppMethodBeat.i(151962);
    int i = bs.getInt(this.Dlt, 0);
    int j = bs.getInt(paramString, 0);
    AppMethodBeat.o(151962);
    return i - j;
  }
  
  public final s eLO()
  {
    AppMethodBeat.i(151961);
    s locals = super.eLO();
    locals.field_fileUpdated = this.dbf;
    locals.field_resType = this.dbd;
    locals.field_subType = this.subType;
    locals.field_reportId = this.Dki;
    locals.field_sampleId = this.Dkj;
    locals.field_eccSignature = this.Dkg;
    locals.field_originalMd5 = this.dbg;
    locals.field_fileCompress = this.DkI;
    locals.field_fileEncrypt = this.DkJ;
    locals.field_encryptKey = this.Dke;
    locals.field_keyVersion = this.Dkf;
    locals.field_fileSize = this.fileSize;
    locals.field_EID = this.DkK;
    AppMethodBeat.o(151961);
    return locals;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151960);
    String str = "CheckResUpdateRequest | fileUpdated=" + this.dbf + ", resType=" + this.dbd + ", subType=" + this.subType + ", reportId=" + this.Dki + ", sampleId='" + this.Dkj + '\'' + ", originalMd5='" + this.dbg + '\'' + ", fileCompress=" + this.DkI + ", fileEncrypt=" + this.DkJ + ", encryptKey='" + this.Dke + '\'' + ", keyVersion=" + this.Dkf + ", EID=" + this.DkK + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.dbj + " | " + super.toString();
    AppMethodBeat.o(151960);
    return str;
  }
  
  public static final class a
    extends a.a<g>
  {
    byte[] DkH;
    boolean DkI;
    boolean DkJ;
    int DkK;
    String Dke;
    int Dkf;
    byte[] Dkg;
    long Dki;
    String Dkj;
    int dbd;
    int dbe;
    private boolean dbf;
    String dbg;
    boolean dbj;
    long fileSize = 0L;
    int subType;
    
    public a(String paramString)
    {
      super();
    }
    
    public final g eLP()
    {
      AppMethodBeat.i(151958);
      g localg = new g(this.url, this.Dkb, this.dbe, this.networkType, this.Dkk, this.hVx, this.md5, this.dbd, this.subType, this.Dki, this.Dkj, this.Dkg, this.dbg, this.DkI, this.DkJ, this.Dke, this.Dkf, this.DkK, this.DkH, this.fileSize, this.dbj, this.dbf, this.priority);
      AppMethodBeat.o(151958);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.g
 * JD-Core Version:    0.7.0.1
 */