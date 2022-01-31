package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mq;
import com.tencent.mm.sdk.b.a;

final class BaseScanUI$15
  implements ScanMaskView.a
{
  BaseScanUI$15(BaseScanUI paramBaseScanUI) {}
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(138471);
    mq localmq = new mq();
    localmq.cCN.action = 2;
    a.ymk.l(localmq);
    AppMethodBeat.o(138471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.15
 * JD-Core Version:    0.7.0.1
 */