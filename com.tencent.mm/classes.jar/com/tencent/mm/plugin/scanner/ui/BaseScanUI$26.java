package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.x.a;
import com.tencent.mm.x.c;
import java.util.Set;

final class BaseScanUI$26
  implements SelectScanModePanel.a
{
  BaseScanUI$26(BaseScanUI paramBaseScanUI) {}
  
  public final void CH(int paramInt)
  {
    AppMethodBeat.i(138485);
    BaseScanUI.n(this.qwI).remove(Integer.valueOf(paramInt));
    if (paramInt == 3)
    {
      c.PJ().c(ac.a.yKC, ac.a.yKD);
      c.PJ().b(ac.a.yKC, false);
    }
    BaseScanUI.m(this.qwI).setShowRedDotModes(BaseScanUI.n(this.qwI));
    this.qwI.ab(paramInt, 50L);
    AppMethodBeat.o(138485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.26
 * JD-Core Version:    0.7.0.1
 */