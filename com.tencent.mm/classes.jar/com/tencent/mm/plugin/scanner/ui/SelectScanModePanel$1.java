package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMFlipper.a;

final class SelectScanModePanel$1
  implements MMFlipper.a
{
  SelectScanModePanel$1(SelectScanModePanel paramSelectScanModePanel) {}
  
  public final void fp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(81331);
    ab.v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + paramInt1 + " height:" + paramInt2 + " isMeasured:" + SelectScanModePanel.a(this.qBF));
    if ((SelectScanModePanel.a(this.qBF)) || (paramInt2 == 0) || (paramInt1 == 0))
    {
      AppMethodBeat.o(81331);
      return;
    }
    SelectScanModePanel.b(this.qBF);
    SelectScanModePanel.a(this.qBF, paramInt2);
    SelectScanModePanel.b(this.qBF, paramInt1);
    SelectScanModePanel.c(this.qBF);
    AppMethodBeat.o(81331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModePanel.1
 * JD-Core Version:    0.7.0.1
 */