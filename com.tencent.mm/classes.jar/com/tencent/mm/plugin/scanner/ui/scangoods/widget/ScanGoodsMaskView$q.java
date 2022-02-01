package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$setScanRequest$1", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "onLoadResult", "", "errCode", "", "errMsg", "", "plugin-scan_release"})
public final class ScanGoodsMaskView$q
  implements y
{
  ScanGoodsMaskView$q(ScanGoodsRequest paramScanGoodsRequest) {}
  
  public final void cm(int paramInt, String paramString)
  {
    AppMethodBeat.i(216985);
    p.k(paramString, "errMsg");
    Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo loadResource onLoadResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      paramString = this.IVU;
      String str = this.ILL.IGs;
      p.j(str, "request.decorationImagePath");
      ScanGoodsMaskView.a(paramString, str);
    }
    AppMethodBeat.o(216985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView.q
 * JD-Core Version:    0.7.0.1
 */