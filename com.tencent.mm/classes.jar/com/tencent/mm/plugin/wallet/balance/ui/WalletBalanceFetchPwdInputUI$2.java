package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a;
import com.tencent.mm.wallet_core.d.g;

final class WalletBalanceFetchPwdInputUI$2
  implements WcPayCashierDialog.a
{
  WalletBalanceFetchPwdInputUI$2(WalletBalanceFetchPwdInputUI paramWalletBalanceFetchPwdInputUI) {}
  
  public final void a(String paramString, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(45336);
    if (this.tNE.getProcess() != null) {
      this.tNE.getNetController().p(new Object[] { paramString });
    }
    AppMethodBeat.o(45336);
  }
  
  public final void cQU() {}
  
  public final void onCancel()
  {
    AppMethodBeat.i(45337);
    this.tNE.finish();
    h.qsU.e(16398, new Object[] { WalletBalanceFetchPwdInputUI.a(this.tNE), Integer.valueOf(8), "", "" });
    AppMethodBeat.o(45337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI.2
 * JD-Core Version:    0.7.0.1
 */