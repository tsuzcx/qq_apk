package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$setScanRequest$1", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "onLoadResult", "", "errCode", "", "errMsg", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanGoodsMaskView$j
  implements af
{
  ScanGoodsMaskView$j(ScanGoodsMaskView paramScanGoodsMaskView, ScanGoodsRequest paramScanGoodsRequest) {}
  
  public final void cX(int paramInt, String paramString)
  {
    AppMethodBeat.i(314605);
    s.u(paramString, "errMsg");
    Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo loadResource onLoadResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      paramString = this.PeI;
      String str = this.PeO.OMA;
      s.s(str, "request.decorationImagePath");
      ScanGoodsMaskView.a(paramString, str);
    }
    AppMethodBeat.o(314605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView.j
 * JD-Core Version:    0.7.0.1
 */