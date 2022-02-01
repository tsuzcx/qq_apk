package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

final class WalletBalanceManagerUI$12
  implements View.OnClickListener
{
  WalletBalanceManagerUI$12(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68658);
    s.dZT();
    paramView = s.dZU().edb();
    if ((paramView == null) || (paramView.size() == 0))
    {
      ad.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
      WalletBalanceManagerUI.d(this.zHn);
      AppMethodBeat.o(68658);
      return;
    }
    ad.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
    a.a(this.zHn, b.class, null, null);
    e.aby(15);
    AppMethodBeat.o(68658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.12
 * JD-Core Version:    0.7.0.1
 */