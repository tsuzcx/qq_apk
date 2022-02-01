package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ui.widget.d;
import com.tencent.mm.sdk.platformtools.Log;

final class BaseScanUI$10
  implements d
{
  BaseScanUI$10(BaseScanUI paramBaseScanUI) {}
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(240726);
    if (paramInt == 1) {
      BaseScanUI.h(this.CJV, false);
    }
    for (;;)
    {
      Log.v("MicroMsg.ScanUI", "alvinluo onScrollStateChanged state: %d, isScrolling: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(BaseScanUI.n(this.CJV)) });
      AppMethodBeat.o(240726);
      return;
      if ((paramInt == 3) || (paramInt == 2)) {
        BaseScanUI.h(this.CJV, true);
      }
    }
  }
  
  public final void u(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(240725);
    Log.v("MicroMsg.ScanUI", "alvinluo onScroll offsetX: %f", new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(240725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.10
 * JD-Core Version:    0.7.0.1
 */