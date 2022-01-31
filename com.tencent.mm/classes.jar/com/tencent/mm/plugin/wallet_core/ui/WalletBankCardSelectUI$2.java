package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.q.b;

final class WalletBankCardSelectUI$2
  implements q.b
{
  WalletBankCardSelectUI$2(WalletBankCardSelectUI paramWalletBankCardSelectUI) {}
  
  public final void apN()
  {
    AppMethodBeat.i(47142);
    WalletBankCardSelectUI.access$102(this.umW, false);
    this.umW.hideVKB();
    this.umW.mBankCardSelectSortView.qM(true);
    this.umW.mBankCardSelectSortView.setMode(0);
    AppMethodBeat.o(47142);
  }
  
  public final void apO()
  {
    AppMethodBeat.i(47141);
    WalletBankCardSelectUI.access$102(this.umW, true);
    this.umW.mBankCardSelectSortView.qM(false);
    this.umW.mBankCardSelectSortView.setMode(1);
    AppMethodBeat.o(47141);
  }
  
  public final void apP() {}
  
  public final void apQ() {}
  
  public final boolean wR(String paramString)
  {
    AppMethodBeat.i(47144);
    this.umW.hideVKB();
    AppMethodBeat.o(47144);
    return false;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(47143);
    ab.d("WalletBankCardSelectUI", "search text: %s", new Object[] { paramString });
    this.umW.mBankCardSelectSortView.atB(paramString);
    AppMethodBeat.o(47143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI.2
 * JD-Core Version:    0.7.0.1
 */