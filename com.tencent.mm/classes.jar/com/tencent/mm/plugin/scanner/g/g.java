package com.tencent.mm.plugin.scanner.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.view.c;
import com.tencent.scanlib.ui.ScanView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/result/ScanCodeProductMergeHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler;", "Lcom/tencent/mm/plugin/scanner/result/ScanCodeProductMergeHandler$ScanCodeProductMergeData;", "", "scanMode", "", "entryScene", "isFromScanUI", "", "scanView", "Lcom/tencent/scanlib/ui/ScanView;", "uiCallback", "Lcom/tencent/mm/plugin/scanner/result/QRCodeHandler$QRCodeResultHandlerUICallback;", "loadingViewModel", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel;", "aiImageHandleCallback", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanProductHandleCallback;", "(IIZLcom/tencent/scanlib/ui/ScanView;Lcom/tencent/mm/plugin/scanner/result/QRCodeHandler$QRCodeResultHandlerUICallback;Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel;Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanProductHandleCallback;)V", "isDestroy", "newAiImageHandlerImpl", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/NewAiImageHandler;", "qrCodeHandlerImpl", "Lcom/tencent/mm/plugin/scanner/result/QRCodeHandler;", "destroy", "", "finishResult", "session", "", "success", "handleResult", "result", "Companion", "ScanCodeProductMergeData", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends f<g.b<Object>>
{
  public static final g.a OVA;
  private boolean EsR;
  private e OVB;
  private com.tencent.mm.plugin.scanner.scan_goods_new.g OVC;
  
  static
  {
    AppMethodBeat.i(313552);
    OVA = new g.a((byte)0);
    AppMethodBeat.o(313552);
  }
  
  public g(int paramInt1, int paramInt2, ScanView paramScanView, e.a parama, c paramc, com.tencent.mm.plugin.scanner.scan_goods_new.f paramf)
  {
    AppMethodBeat.i(313546);
    this.OVB = new e(paramInt1, paramInt2, paramScanView, parama, paramc);
    this.OVC = new com.tencent.mm.plugin.scanner.scan_goods_new.g(paramf);
    AppMethodBeat.o(313546);
  }
  
  public final void Q(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(313568);
    Object localObject = this.OVB;
    if (localObject != null) {
      ((e)localObject).Q(paramLong, paramBoolean);
    }
    localObject = this.OVC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.scanner.scan_goods_new.g)localObject).Q(paramLong, paramBoolean);
    }
    AppMethodBeat.o(313568);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(313558);
    this.EsR = true;
    Object localObject = this.OVB;
    if (localObject != null) {
      ((e)localObject).destroy();
    }
    localObject = this.OVC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.scanner.scan_goods_new.g)localObject).destroy();
    }
    AppMethodBeat.o(313558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.g.g
 * JD-Core Version:    0.7.0.1
 */