package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletLqtSaveFetchUI$8
  implements View.OnClickListener
{
  WalletLqtSaveFetchUI$8(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199236);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (!WalletLqtSaveFetchUI.q(this.CEJ).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      WalletLqtSaveFetchUI.q(this.CEJ).setChecked(bool);
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(199236);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.8
 * JD-Core Version:    0.7.0.1
 */