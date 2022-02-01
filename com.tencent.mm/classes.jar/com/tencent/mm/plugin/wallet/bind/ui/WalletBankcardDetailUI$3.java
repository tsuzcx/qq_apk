package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletBankcardDetailUI$3
  implements View.OnClickListener
{
  WalletBankcardDetailUI$3(WalletBankcardDetailUI paramWalletBankcardDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69079);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.Vkn.showDialog(0);
    a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.3
 * JD-Core Version:    0.7.0.1
 */