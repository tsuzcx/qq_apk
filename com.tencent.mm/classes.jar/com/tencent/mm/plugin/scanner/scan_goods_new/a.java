package com.tencent.mm.plugin.scanner.scan_goods_new;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageBaseRequest;", "", "scanImageType", "", "scanProductRequestInfo", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;", "(ILcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;)V", "mode", "getMode", "()I", "setMode", "(I)V", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getNetScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "setNetScene", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "getScanImageType", "getScanProductRequestInfo", "()Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;", "session", "", "getSession", "()J", "setSession", "(J)V", "source", "getSource", "setSource", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
{
  public p ORg;
  private final int OVD;
  private final j OVE;
  public long hBk;
  public int mode;
  public int source;
  
  public a(int paramInt, j paramj)
  {
    AppMethodBeat.i(313842);
    this.OVD = paramInt;
    this.OVE = paramj;
    AppMethodBeat.o(313842);
  }
  
  public int gRK()
  {
    return this.OVD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.a
 * JD-Core Version:    0.7.0.1
 */