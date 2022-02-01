package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletLqtSaveFetchUI$11
  implements View.OnClickListener
{
  WalletLqtSaveFetchUI$11(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213979);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (!WalletLqtSaveFetchUI.s(this.HBI).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      WalletLqtSaveFetchUI.s(this.HBI).setChecked(bool);
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(213979);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.11
 * JD-Core Version:    0.7.0.1
 */