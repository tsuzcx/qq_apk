package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.a;
import com.tencent.mm.pluginsdk.j.a.c.a.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.bu;

final class g
  extends a
{
  final long DRK;
  private final String FhC;
  final int FhD;
  private final byte[] FhE;
  private final String FhG;
  final byte[] Fie;
  final boolean Fif;
  final boolean Fig;
  private final int Fih;
  private final boolean dnB;
  final String dnC;
  final boolean dnF;
  final int dnz;
  final long fileSize;
  final int subType;
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString3, int paramInt4, int paramInt5, long paramLong2, String paramString4, byte[] paramArrayOfByte1, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, long paramLong3, boolean paramBoolean3, boolean paramBoolean4, int paramInt8) {}
  
  public final int aNv(String paramString)
  {
    AppMethodBeat.i(151962);
    int i = bu.getInt(this.FiQ, 0);
    int j = bu.getInt(paramString, 0);
    AppMethodBeat.o(151962);
    return i - j;
  }
  
  public final s fez()
  {
    AppMethodBeat.i(151961);
    s locals = super.fez();
    locals.field_fileUpdated = this.dnB;
    locals.field_resType = this.dnz;
    locals.field_subType = this.subType;
    locals.field_reportId = this.DRK;
    locals.field_sampleId = this.FhG;
    locals.field_eccSignature = this.FhE;
    locals.field_originalMd5 = this.dnC;
    locals.field_fileCompress = this.Fif;
    locals.field_fileEncrypt = this.Fig;
    locals.field_encryptKey = this.FhC;
    locals.field_keyVersion = this.FhD;
    locals.field_fileSize = this.fileSize;
    locals.field_EID = this.Fih;
    AppMethodBeat.o(151961);
    return locals;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151960);
    String str = "CheckResUpdateRequest | fileUpdated=" + this.dnB + ", resType=" + this.dnz + ", subType=" + this.subType + ", reportId=" + this.DRK + ", sampleId='" + this.FhG + '\'' + ", originalMd5='" + this.dnC + '\'' + ", fileCompress=" + this.Fif + ", fileEncrypt=" + this.Fig + ", encryptKey='" + this.FhC + '\'' + ", keyVersion=" + this.FhD + ", EID=" + this.Fih + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.dnF + " | " + super.toString();
    AppMethodBeat.o(151960);
    return str;
  }
  
  public static final class a
    extends a.a<g>
  {
    long DRK;
    String FhC;
    int FhD;
    byte[] FhE;
    String FhG;
    byte[] Fie;
    boolean Fif;
    boolean Fig;
    int Fih;
    int dnA;
    private boolean dnB;
    String dnC;
    boolean dnF;
    int dnz;
    long fileSize = 0L;
    int subType;
    
    public a(String paramString)
    {
      super();
    }
    
    public final g feA()
    {
      AppMethodBeat.i(151958);
      g localg = new g(this.url, this.Fhz, this.dnA, this.networkType, this.FhH, this.irN, this.md5, this.dnz, this.subType, this.DRK, this.FhG, this.FhE, this.dnC, this.Fif, this.Fig, this.FhC, this.FhD, this.Fih, this.Fie, this.fileSize, this.dnF, this.dnB, this.priority);
      AppMethodBeat.o(151958);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.g
 * JD-Core Version:    0.7.0.1
 */