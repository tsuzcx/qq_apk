package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WalletPayDeductUI$2
  implements MMSwitchBtn.a
{
  WalletPayDeductUI$2(WalletPayDeductUI paramWalletPayDeductUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(46018);
    this.tWw.ny(paramBoolean);
    if (this.tWw.qrf != null)
    {
      h localh = h.qsU;
      if (paramBoolean) {
        i = 1;
      }
      localh.e(15379, new Object[] { Integer.valueOf(i), this.tWw.qrf.cnI });
    }
    AppMethodBeat.o(46018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.2
 * JD-Core Version:    0.7.0.1
 */