package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletBalanceSaveUI$13
  implements View.OnClickListener
{
  WalletBalanceSaveUI$13(WalletBalanceSaveUI paramWalletBalanceSaveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68708);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    WalletBalanceSaveUI.f(this.CAd);
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.13
 * JD-Core Version:    0.7.0.1
 */