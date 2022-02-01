package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.j;

final class WalletBalanceSaveUI$8
  implements View.OnClickListener
{
  WalletBalanceSaveUI$8(WalletBalanceSaveUI paramWalletBalanceSaveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(316356);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (WalletBalanceSaveUI.j(this.Vdh) != null) {
      WalletBalanceSaveUI.j(this.Vdh).xcO.cyW();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.8
 * JD-Core Version:    0.7.0.1
 */