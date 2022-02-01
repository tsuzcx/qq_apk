package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;

final class WalletBalanceManagerUI$15
  extends k
{
  WalletBalanceManagerUI$15(WalletBalanceManagerUI paramWalletBalanceManagerUI, am paramam) {}
  
  public final void dr(View paramView)
  {
    AppMethodBeat.i(316301);
    h.baF();
    h.baE().ban().set(at.a.acSy, Integer.valueOf(-1));
    i.o(this.VcP, this.VcT.ijt(), true);
    AppMethodBeat.o(316301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.15
 * JD-Core Version:    0.7.0.1
 */