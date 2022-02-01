package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.res.downloader.model.a;
import com.tencent.mm.pluginsdk.res.downloader.model.a.a;
import com.tencent.mm.pluginsdk.res.downloader.model.r;
import com.tencent.mm.sdk.platformtools.Util;

final class g
  extends a
{
  final long Wmc;
  final byte[] XVE;
  final boolean XVF;
  final boolean XVG;
  private final int XVH;
  private final String XVa;
  final int XVb;
  private final byte[] XVc;
  private final String XVe;
  final long fileSize;
  final int hCh;
  private final boolean hCj;
  final String hCk;
  final boolean hCn;
  final int subType;
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString3, int paramInt4, int paramInt5, long paramLong2, String paramString4, byte[] paramArrayOfByte1, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, long paramLong3, boolean paramBoolean3, boolean paramBoolean4, int paramInt8) {}
  
  public final int bqh(String paramString)
  {
    AppMethodBeat.i(151962);
    int i = Util.getInt(this.XWr, 0);
    int j = Util.getInt(paramString, 0);
    AppMethodBeat.o(151962);
    return i - j;
  }
  
  public final r iJo()
  {
    AppMethodBeat.i(151961);
    r localr = super.iJo();
    localr.field_fileUpdated = this.hCj;
    localr.field_resType = this.hCh;
    localr.field_subType = this.subType;
    localr.field_reportId = this.Wmc;
    localr.field_sampleId = this.XVe;
    localr.field_eccSignature = this.XVc;
    localr.field_originalMd5 = this.hCk;
    localr.field_fileCompress = this.XVF;
    localr.field_fileEncrypt = this.XVG;
    localr.field_encryptKey = this.XVa;
    localr.field_keyVersion = this.XVb;
    localr.field_fileSize = this.fileSize;
    localr.field_EID = this.XVH;
    AppMethodBeat.o(151961);
    return localr;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151960);
    String str = "CheckResUpdateRequest | fileUpdated=" + this.hCj + ", resType=" + this.hCh + ", subType=" + this.subType + ", reportId=" + this.Wmc + ", sampleId='" + this.XVe + '\'' + ", originalMd5='" + this.hCk + '\'' + ", fileCompress=" + this.XVF + ", fileEncrypt=" + this.XVG + ", encryptKey='" + this.XVa + '\'' + ", keyVersion=" + this.XVb + ", EID=" + this.XVH + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.hCn + " | " + super.toString();
    AppMethodBeat.o(151960);
    return str;
  }
  
  public static final class a
    extends a.a<g>
  {
    long Wmc;
    byte[] XVE;
    boolean XVF;
    boolean XVG;
    int XVH;
    String XVa;
    int XVb;
    byte[] XVc;
    String XVe;
    long fileSize = 0L;
    int hCh;
    int hCi;
    private boolean hCj;
    String hCk;
    boolean hCn;
    int subType;
    
    public a(String paramString)
    {
      super();
    }
    
    public final g iJp()
    {
      AppMethodBeat.i(151958);
      g localg = new g(this.url, this.XUX, this.hCi, this.networkType, this.XVf, this.ofU, this.md5, this.hCh, this.subType, this.Wmc, this.XVe, this.XVc, this.hCk, this.XVF, this.XVG, this.XVa, this.XVb, this.XVH, this.XVE, this.fileSize, this.hCn, this.hCj, this.priority);
      AppMethodBeat.o(151958);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.g
 * JD-Core Version:    0.7.0.1
 */