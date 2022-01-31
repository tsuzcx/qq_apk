package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class BaseScanUI$5
  implements Runnable
{
  BaseScanUI$5(BaseScanUI paramBaseScanUI) {}
  
  public final void run()
  {
    try
    {
      if (BaseScanUI.g(this.nJg) == null)
      {
        y.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in openCamera()");
        return;
      }
      if (!BaseScanUI.r(this.nJg)) {
        BaseScanUI.c(this.nJg, true);
      }
      if (BaseScanUI.g(this.nJg).isOpen()) {
        y.d("MicroMsg.scanner.BaseScanUI", "camera already open");
      }
      for (;;)
      {
        ai.l(new BaseScanUI.5.2(this), 50L);
        BaseScanUI.g(this.nJg).g(BaseScanUI.y(this.nJg));
        BaseScanUI.i(this.nJg).iB(this.nJg.bxE());
        BaseScanUI.i(this.nJg).h(BaseScanUI.g(this.nJg).jOD);
        if ((BaseScanUI.g(this.nJg) != null) && (BaseScanUI.g(this.nJg).jOC))
        {
          this.nJg.fD(0L);
          return;
          synchronized (BaseScanUI.s(this.nJg))
          {
            BaseScanUI.g(this.nJg).open();
            y.d("MicroMsg.scanner.BaseScanUI", "scanCamera.open done");
            this.nJg.fC(0L);
            BaseScanUI.c(this.nJg, false);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.open(), [%s]", new Object[] { localException.toString() });
      y.printErrStackTrace("MicroMsg.scanner.BaseScanUI", localException, "", new Object[0]);
      BaseScanUI.t(this.nJg);
      if (BaseScanUI.u(this.nJg) >= 5)
      {
        BaseScanUI.v(this.nJg);
        return;
      }
      ai.l(new BaseScanUI.5.1(this), 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.5
 * JD-Core Version:    0.7.0.1
 */