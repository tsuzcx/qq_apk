package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WalletPayDeductUI$2
  implements MMSwitchBtn.a
{
  WalletPayDeductUI$2(WalletPayDeductUI paramWalletPayDeductUI) {}
  
  public final void cr(boolean paramBoolean)
  {
    int i = 2;
    this.qng.kv(paramBoolean);
    if (this.qng.nEh != null)
    {
      h localh = h.nFQ;
      if (paramBoolean) {
        i = 1;
      }
      localh.f(15379, new Object[] { Integer.valueOf(i), this.qng.nEh.bMX });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.2
 * JD-Core Version:    0.7.0.1
 */