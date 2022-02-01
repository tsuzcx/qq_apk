package com.tencent.mm.plugin.scanner.scan_goods_new;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.d.a;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeResult;", "", "source", "", "session", "", "scanImageType", "(IJI)V", "clientLogInfo", "Lcom/tencent/mm/plugin/scanner/model/CameraScanCombineClientLogReporter$ClientLogInfo;", "getClientLogInfo", "()Lcom/tencent/mm/plugin/scanner/model/CameraScanCombineClientLogReporter$ClientLogInfo;", "setClientLogInfo", "(Lcom/tencent/mm/plugin/scanner/model/CameraScanCombineClientLogReporter$ClientLogInfo;)V", "productItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;", "Lkotlin/collections/ArrayList;", "getProductItemList", "()Ljava/util/ArrayList;", "setProductItemList", "(Ljava/util/ArrayList;)V", "getScanImageType", "()I", "getSession", "()J", "getSource", "convertFromUploadResponse", "response", "Lcom/tencent/mm/protocal/protobuf/ScanV2UploadResponse;", "updateFromRetrievalResponse", "Lcom/tencent/mm/protocal/protobuf/ScanV2RetrievalLiteResponse;", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a OWe;
  public final int OVD;
  public ArrayList<h> OWf;
  public d.a OWg;
  public final long hBk;
  public final int source;
  
  static
  {
    AppMethodBeat.i(313884);
    OWe = new i.a((byte)0);
    AppMethodBeat.o(313884);
  }
  
  public i(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(313877);
    this.source = paramInt1;
    this.hBk = paramLong;
    this.OVD = paramInt2;
    this.OWf = new ArrayList();
    AppMethodBeat.o(313877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.i
 * JD-Core Version:    0.7.0.1
 */