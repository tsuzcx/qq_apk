package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

final class BaseScanUI$16
  extends n.a
{
  BaseScanUI$16(BaseScanUI paramBaseScanUI) {}
  
  public final void onNetworkChange(final int paramInt)
  {
    AppMethodBeat.i(186178);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186177);
        boolean bool = BaseScanUI.L(BaseScanUI.16.this.yqg);
        ad.i("MicroMsg.ScanUI", "onNetWorkChange %d, canResume: %b", new Object[] { Integer.valueOf(g.aiU().aEN()), Boolean.valueOf(bool) });
        ScanUIRectView localScanUIRectView;
        int i;
        if (BaseScanUI.g(BaseScanUI.16.this.yqg) != null)
        {
          localScanUIRectView = BaseScanUI.g(BaseScanUI.16.this.yqg);
          i = paramInt;
          if ((g.aiU().aEN() != 6) && (g.aiU().aEN() != 4)) {
            break label174;
          }
          localScanUIRectView.ypI = true;
          if ((!o.OW(localScanUIRectView.mode)) && (bool)) {
            localScanUIRectView.onResume();
          }
        }
        for (;;)
        {
          if (localScanUIRectView.ynO != null) {
            localScanUIRectView.ynO.onNetworkChange(i);
          }
          if ((g.aiU().aEN() != 6) && (g.aiU().aEN() != 4)) {
            break label224;
          }
          if (!BaseScanUI.M(BaseScanUI.16.this.yqg)) {
            break;
          }
          AppMethodBeat.o(186177);
          return;
          label174:
          localScanUIRectView.ypI = false;
          if (!o.OW(localScanUIRectView.mode)) {
            localScanUIRectView.onPause();
          }
        }
        BaseScanUI.i(BaseScanUI.16.this.yqg, true);
        BaseScanUI.N(BaseScanUI.16.this.yqg);
        AppMethodBeat.o(186177);
        return;
        label224:
        if (!BaseScanUI.M(BaseScanUI.16.this.yqg))
        {
          AppMethodBeat.o(186177);
          return;
        }
        BaseScanUI.i(BaseScanUI.16.this.yqg, false);
        BaseScanUI.N(BaseScanUI.16.this.yqg);
        AppMethodBeat.o(186177);
      }
    });
    AppMethodBeat.o(186178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.16
 * JD-Core Version:    0.7.0.1
 */