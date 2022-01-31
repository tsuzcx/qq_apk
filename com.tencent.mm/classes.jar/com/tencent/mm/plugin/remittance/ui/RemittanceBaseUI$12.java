package com.tencent.mm.plugin.remittance.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.u;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class RemittanceBaseUI$12
  extends u
{
  RemittanceBaseUI$12(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void aEI()
  {
    if (this.nAH.nzY == 33)
    {
      this.nAH.a(this.nAH.dkv, this.nAH.nAl, "", null);
      if (RemittanceBaseUI.a(this.nAH) == 0.0D)
      {
        if (this.nAH.fzn != 1) {
          break label241;
        }
        h.nFQ.f(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
      }
    }
    for (;;)
    {
      if ((this.nAH.fzn == 1) && (!bk.bl(this.nAH.dkv))) {
        h.nFQ.f(14074, new Object[] { Integer.valueOf(2) });
      }
      return;
      this.nAH.nzU = bk.getDouble(this.nAH.iKG.getText(), 0.0D);
      if (!this.nAH.iKG.YL())
      {
        com.tencent.mm.ui.base.s.makeText(this.nAH.mController.uMN, a.i.wallet_balance_save_input_invalid, 0).show();
        break;
      }
      if (this.nAH.nzU < 0.01D)
      {
        this.nAH.bwr();
        break;
      }
      this.nAH.VH();
      this.nAH.a(this.nAH.dkv, null, "", null);
      break;
      label241:
      h.nFQ.f(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.12
 * JD-Core Version:    0.7.0.1
 */