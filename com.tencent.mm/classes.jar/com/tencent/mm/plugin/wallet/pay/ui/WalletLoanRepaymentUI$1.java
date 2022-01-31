package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.q.c;

final class WalletLoanRepaymentUI$1
  implements q.c
{
  WalletLoanRepaymentUI$1(WalletLoanRepaymentUI paramWalletLoanRepaymentUI) {}
  
  public final void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(45991);
    WalletLoanRepaymentUI.a(this.tWh, paramString);
    this.tWh.doSceneProgress(new v(WalletLoanRepaymentUI.a(this.tWh), WalletLoanRepaymentUI.b(this.tWh), (byte)0));
    AppMethodBeat.o(45991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.1
 * JD-Core Version:    0.7.0.1
 */