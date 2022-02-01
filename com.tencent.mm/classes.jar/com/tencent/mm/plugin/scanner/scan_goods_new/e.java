package com.tencent.mm.plugin.scanner.scan_goods_new;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageUploadRequest;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageBaseRequest;", "scanProductRequestInfo", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;", "scanImageType", "", "uploadImageData", "", "imageEncodeType", "width", "height", "(Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;I[BIII)V", "doRetrievalWhenUploadSuccess", "", "getDoRetrievalWhenUploadSuccess", "()Z", "setDoRetrievalWhenUploadSuccess", "(Z)V", "getHeight", "()I", "getImageEncodeType", "localTrackId", "getLocalTrackId", "setLocalTrackId", "(I)V", "getScanImageType", "getScanProductRequestInfo", "()Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;", "getUploadImageData", "()[B", "getWidth", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  public static final e.a OVR;
  public final int ORl;
  public final int OVD;
  public final j OVE;
  public int OVP;
  public final byte[] OVS;
  public boolean OVT;
  public final int height;
  public final int width;
  
  static
  {
    AppMethodBeat.i(313847);
    OVR = new e.a((byte)0);
    AppMethodBeat.o(313847);
  }
  
  public e(j paramj, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramj);
    AppMethodBeat.i(313840);
    this.OVE = paramj;
    this.OVD = paramInt1;
    this.OVS = paramArrayOfByte;
    this.ORl = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.OVT = true;
    AppMethodBeat.o(313840);
  }
  
  public final int gRK()
  {
    return this.OVD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.e
 * JD-Core Version:    0.7.0.1
 */