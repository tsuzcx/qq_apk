package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceManagerUI$11
  implements View.OnClickListener
{
  WalletBalanceManagerUI$11(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68657);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.CzL.eCz();
    e.agr(14);
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.11
 * JD-Core Version:    0.7.0.1
 */