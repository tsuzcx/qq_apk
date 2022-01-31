package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.d;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.List;

final class WalletLqtSaveFetchUI$4
  implements n.d
{
  WalletLqtSaveFetchUI$4(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, d paramd) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(155070);
    if (this.gEx != null)
    {
      this.gEx.cre();
      if (paramInt < WalletLqtSaveFetchUI.k(this.tRZ).size())
      {
        paramMenuItem = (Bankcard)WalletLqtSaveFetchUI.k(this.tRZ).get(paramInt);
        WalletLqtSaveFetchUI.a(this.tRZ, paramMenuItem.field_bindSerial);
        WalletLqtSaveFetchUI.m(this.tRZ);
        WalletLqtSaveFetchUI.h(this.tRZ).cfK();
        AppMethodBeat.o(155070);
        return;
      }
      if (WalletLqtSaveFetchUI.e(this.tRZ) == 1)
      {
        WalletLqtSaveFetchUI.n(this.tRZ);
        AppMethodBeat.o(155070);
        return;
      }
      if (WalletLqtSaveFetchUI.e(this.tRZ) == 2) {
        WalletLqtSaveFetchUI.n(this.tRZ);
      }
    }
    AppMethodBeat.o(155070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.4
 * JD-Core Version:    0.7.0.1
 */