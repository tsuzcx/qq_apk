package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.storage.ac.a;
import com.tencent.mm.y.a;
import com.tencent.mm.y.c;
import java.util.Set;

final class BaseScanUI$19
  implements SelectScanModePanel.a
{
  BaseScanUI$19(BaseScanUI paramBaseScanUI) {}
  
  public final void wQ(int paramInt)
  {
    BaseScanUI.n(this.nJg).remove(Integer.valueOf(paramInt));
    if (paramInt == 3)
    {
      c.BS().c(ac.a.uzK, ac.a.uzL);
      c.BS().b(ac.a.uzK, false);
    }
    BaseScanUI.m(this.nJg).setShowRedDotModes(BaseScanUI.n(this.nJg));
    this.nJg.L(paramInt, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.19
 * JD-Core Version:    0.7.0.1
 */