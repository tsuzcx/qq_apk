package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ui.widget.d;
import com.tencent.mm.sdk.platformtools.ad;

final class BaseScanUI$14
  implements d
{
  BaseScanUI$14(BaseScanUI paramBaseScanUI) {}
  
  public final void cp(int paramInt)
  {
    AppMethodBeat.i(51697);
    if (paramInt == 1) {
      BaseScanUI.g(this.yqg, false);
    }
    for (;;)
    {
      ad.v("MicroMsg.ScanUI", "alvinluo onScrollStateChanged state: %d, isScrolling: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(BaseScanUI.l(this.yqg)) });
      AppMethodBeat.o(51697);
      return;
      if ((paramInt == 3) || (paramInt == 2)) {
        BaseScanUI.g(this.yqg, true);
      }
    }
  }
  
  public final void t(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(51696);
    ad.v("MicroMsg.ScanUI", "alvinluo onScroll offsetX: %f", new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(51696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.14
 * JD-Core Version:    0.7.0.1
 */