package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.ui.f;

final class WalletBalanceManagerUI$2
  implements View.OnClickListener
{
  WalletBalanceManagerUI$2(WalletBalanceManagerUI paramWalletBalanceManagerUI, an paraman) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68646);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    g.aAi();
    g.aAh().azQ().set(ar.a.OcP, Integer.valueOf(-1));
    f.o(this.Hwm, this.Hwn.fRw(), true);
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.2
 * JD-Core Version:    0.7.0.1
 */