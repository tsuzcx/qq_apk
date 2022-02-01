package com.tencent.mm.plugin.scanner.e;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.ui.BaseScanUI;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/service/ScanServiceImpl;", "Lcom/tencent/mm/plugin/scanner/api/IScanService;", "()V", "preloadResource", "", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "startScanGoods", "context", "Landroid/content/Context;", "Companion", "plugin-scan_release"})
public final class a
  implements com.tencent.mm.plugin.scanner.api.a
{
  public static final a xbi;
  
  static
  {
    AppMethodBeat.i(199626);
    xbi = new a((byte)0);
    AppMethodBeat.o(199626);
  }
  
  public final void a(Context paramContext, ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(199625);
    k.h(paramContext, "context");
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(199625);
      return;
    }
    ac.i("MicroMsg.ScanServiceImpl", "startScanGoods");
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 12);
    localIntent.putExtra("key_scan_request", (Parcelable)paramScanGoodsRequest);
    localIntent.setClass(paramContext, BaseScanUI.class);
    paramScanGoodsRequest = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramScanGoodsRequest.aeD(), "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramScanGoodsRequest.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199625);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/service/ScanServiceImpl$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a
 * JD-Core Version:    0.7.0.1
 */