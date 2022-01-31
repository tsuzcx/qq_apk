package com.tencent.mm.plugin.scanner.ui;

import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.sdk.platformtools.ah;

final class BaseScanUI$1
  extends n.a
{
  BaseScanUI$1(BaseScanUI paramBaseScanUI) {}
  
  public final void et(final int paramInt)
  {
    if (!BaseScanUI.a(this.nJg)) {
      return;
    }
    new ah(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        if ((au.Dk().KG() == 6) || (au.Dk().KG() == 4)) {
          if (!BaseScanUI.b(BaseScanUI.1.this.nJg)) {}
        }
        label364:
        for (;;)
        {
          return;
          if ((BaseScanUI.c(BaseScanUI.1.this.nJg) != null) && (BaseScanUI.d(BaseScanUI.1.this.nJg) != null))
          {
            BaseScanUI.c(BaseScanUI.1.this.nJg).setVisibility(8);
            BaseScanUI.d(BaseScanUI.1.this.nJg).setVisibility(8);
          }
          BaseScanUI.a(BaseScanUI.1.this.nJg, true);
          BaseScanUI.b(BaseScanUI.1.this.nJg, false);
          BaseScanUI.e(BaseScanUI.1.this.nJg);
          for (;;)
          {
            if (BaseScanUI.i(BaseScanUI.1.this.nJg) == null) {
              break label364;
            }
            BaseScanUI.i(BaseScanUI.1.this.nJg).bxo();
            return;
            if (!BaseScanUI.b(BaseScanUI.1.this.nJg)) {
              break;
            }
            if ((BaseScanUI.c(BaseScanUI.1.this.nJg) != null) && (BaseScanUI.d(BaseScanUI.1.this.nJg) != null))
            {
              BaseScanUI.c(BaseScanUI.1.this.nJg).setText(R.l.scan_no_network);
              BaseScanUI.d(BaseScanUI.1.this.nJg).setVisibility(0);
              BaseScanUI.c(BaseScanUI.1.this.nJg).setVisibility(0);
            }
            if ((!BaseScanUI.f(BaseScanUI.1.this.nJg)) && (BaseScanUI.g(BaseScanUI.1.this.nJg) != null) && (BaseScanUI.g(BaseScanUI.1.this.nJg).mgM)) {
              BaseScanUI.g(BaseScanUI.1.this.nJg).biP();
            }
            if (BaseScanUI.h(BaseScanUI.1.this.nJg) != null)
            {
              BaseScanUI.h(BaseScanUI.1.this.nJg).byd();
              BaseScanUI.h(BaseScanUI.1.this.nJg).hide();
            }
            BaseScanUI.a(BaseScanUI.1.this.nJg, false);
            BaseScanUI.b(BaseScanUI.1.this.nJg, true);
            BaseScanUI.1.this.nJg.bxx();
          }
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.1
 * JD-Core Version:    0.7.0.1
 */