package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

final class WalletBalanceManagerUI$11
  implements View.OnClickListener
{
  WalletBalanceManagerUI$11(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45437);
    s.cRG();
    paramView = s.cRH().cUH();
    if ((paramView == null) || (paramView.size() == 0))
    {
      ab.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
      WalletBalanceManagerUI.d(this.tOJ);
      AppMethodBeat.o(45437);
      return;
    }
    ab.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
    a.a(this.tOJ, b.class, null, null);
    e.RX(15);
    AppMethodBeat.o(45437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.11
 * JD-Core Version:    0.7.0.1
 */