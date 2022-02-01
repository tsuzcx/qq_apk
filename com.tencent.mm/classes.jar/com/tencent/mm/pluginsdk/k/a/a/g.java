package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.k.a.c.a;
import com.tencent.mm.pluginsdk.k.a.c.a.a;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.sdk.platformtools.Util;

final class g
  extends a
{
  final long PvW;
  private final String QYX;
  final int QYY;
  private final byte[] QYZ;
  final byte[] QZA;
  final boolean QZB;
  final boolean QZC;
  private final int QZD;
  private final String QZb;
  final long fileSize;
  final int fxC;
  private final boolean fxE;
  final String fxF;
  final boolean fxI;
  final int subType;
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString3, int paramInt4, int paramInt5, long paramLong2, String paramString4, byte[] paramArrayOfByte1, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, long paramLong3, boolean paramBoolean3, boolean paramBoolean4, int paramInt8) {}
  
  public final int bqt(String paramString)
  {
    AppMethodBeat.i(151962);
    int i = Util.getInt(this.Ran, 0);
    int j = Util.getInt(paramString, 0);
    AppMethodBeat.o(151962);
    return i - j;
  }
  
  public final r hip()
  {
    AppMethodBeat.i(151961);
    r localr = super.hip();
    localr.field_fileUpdated = this.fxE;
    localr.field_resType = this.fxC;
    localr.field_subType = this.subType;
    localr.field_reportId = this.PvW;
    localr.field_sampleId = this.QZb;
    localr.field_eccSignature = this.QYZ;
    localr.field_originalMd5 = this.fxF;
    localr.field_fileCompress = this.QZB;
    localr.field_fileEncrypt = this.QZC;
    localr.field_encryptKey = this.QYX;
    localr.field_keyVersion = this.QYY;
    localr.field_fileSize = this.fileSize;
    localr.field_EID = this.QZD;
    AppMethodBeat.o(151961);
    return localr;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151960);
    String str = "CheckResUpdateRequest | fileUpdated=" + this.fxE + ", resType=" + this.fxC + ", subType=" + this.subType + ", reportId=" + this.PvW + ", sampleId='" + this.QZb + '\'' + ", originalMd5='" + this.fxF + '\'' + ", fileCompress=" + this.QZB + ", fileEncrypt=" + this.QZC + ", encryptKey='" + this.QYX + '\'' + ", keyVersion=" + this.QYY + ", EID=" + this.QZD + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.fxI + " | " + super.toString();
    AppMethodBeat.o(151960);
    return str;
  }
  
  public static final class a
    extends a.a<g>
  {
    long PvW;
    String QYX;
    int QYY;
    byte[] QYZ;
    byte[] QZA;
    boolean QZB;
    boolean QZC;
    int QZD;
    String QZb;
    long fileSize = 0L;
    int fxC;
    int fxD;
    private boolean fxE;
    String fxF;
    boolean fxI;
    int subType;
    
    public a(String paramString)
    {
      super();
    }
    
    public final g hiq()
    {
      AppMethodBeat.i(151958);
      g localg = new g(this.url, this.QYU, this.fxD, this.networkType, this.QZc, this.mcX, this.md5, this.fxC, this.subType, this.PvW, this.QZb, this.QYZ, this.fxF, this.QZB, this.QZC, this.QYX, this.QYY, this.QZD, this.QZA, this.fileSize, this.fxI, this.fxE, this.priority);
      AppMethodBeat.o(151958);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.g
 * JD-Core Version:    0.7.0.1
 */