package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

final class WalletBalanceManagerUI$2
  implements View.OnClickListener
{
  WalletBalanceManagerUI$2(WalletBalanceManagerUI paramWalletBalanceManagerUI, an paraman) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68646);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    g.ajD();
    g.ajC().ajl().set(al.a.IAc, Integer.valueOf(-1));
    com.tencent.mm.wallet_core.ui.e.n(this.CzL, this.CzM.eGm(), true);
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.2
 * JD-Core Version:    0.7.0.1
 */