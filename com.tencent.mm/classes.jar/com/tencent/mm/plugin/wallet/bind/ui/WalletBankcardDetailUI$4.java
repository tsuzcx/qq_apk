package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletBankcardDetailUI$4
  implements View.OnClickListener
{
  WalletBankcardDetailUI$4(WalletBankcardDetailUI paramWalletBankcardDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69080);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    com.tencent.mm.wallet_core.a.k(this.CXs, this.CXs.getInput());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.4
 * JD-Core Version:    0.7.0.1
 */