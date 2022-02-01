package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ui.h;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class ScanGoodsMaskView$p
  implements Runnable
{
  ScanGoodsMaskView$p(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(189660);
    h localh = h.yKm;
    if (h.a(this.cwB, ScanGoodsMaskView.s(this.yMB), ScanGoodsMaskView.t(this.yMB), ScanGoodsMaskView.u(this.yMB)))
    {
      ScanGoodsMaskView.s(this.yMB).setVisibility(0);
      ScanGoodsMaskView.v(this.yMB);
      AppMethodBeat.o(189660);
      return;
    }
    ScanGoodsMaskView.w(this.yMB);
    AppMethodBeat.o(189660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView.p
 * JD-Core Version:    0.7.0.1
 */