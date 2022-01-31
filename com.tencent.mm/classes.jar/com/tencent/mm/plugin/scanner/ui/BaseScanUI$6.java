package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.sdk.platformtools.y;

final class BaseScanUI$6
  implements Runnable
{
  BaseScanUI$6(BaseScanUI paramBaseScanUI) {}
  
  public final void run()
  {
    if (BaseScanUI.g(this.nJg) == null) {
      return;
    }
    synchronized (BaseScanUI.s(this.nJg))
    {
      if ((!BaseScanUI.f(this.nJg)) && (BaseScanUI.g(this.nJg) != null))
      {
        BaseScanUI.d(this.nJg, true);
        y.i("MicroMsg.scanner.BaseScanUI", "closeCamera");
        BaseScanUI.g(this.nJg).release();
        BaseScanUI.z(this.nJg);
        BaseScanUI.d(this.nJg, false);
        y.i("MicroMsg.scanner.BaseScanUI", "scanCamera.release() done");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.6
 * JD-Core Version:    0.7.0.1
 */