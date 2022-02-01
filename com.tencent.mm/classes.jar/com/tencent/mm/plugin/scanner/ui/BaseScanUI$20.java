package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ui.widget.d;
import com.tencent.mm.sdk.platformtools.Log;

final class BaseScanUI$20
  implements d
{
  BaseScanUI$20(BaseScanUI paramBaseScanUI) {}
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(314685);
    if (paramInt == 1) {
      BaseScanUI.i(this.OYm, false);
    }
    for (;;)
    {
      Log.v("MicroMsg.ScanUI", "alvinluo onScrollStateChanged state: %d, isScrolling: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(BaseScanUI.x(this.OYm)) });
      AppMethodBeat.o(314685);
      return;
      if ((paramInt == 3) || (paramInt == 2)) {
        BaseScanUI.i(this.OYm, true);
      }
    }
  }
  
  public final void y(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(314679);
    Log.v("MicroMsg.ScanUI", "alvinluo onScroll offsetX: %f", new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(314679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.20
 * JD-Core Version:    0.7.0.1
 */