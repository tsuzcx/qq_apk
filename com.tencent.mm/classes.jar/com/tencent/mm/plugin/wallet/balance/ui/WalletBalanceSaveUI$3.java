package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletBalanceSaveUI$3
  implements View.OnClickListener
{
  WalletBalanceSaveUI$3(WalletBalanceSaveUI paramWalletBalanceSaveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213912);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    WalletBalanceSaveUI.g(this.HwD);
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.3
 * JD-Core Version:    0.7.0.1
 */