package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletBankcardDetailUI$2
  implements View.OnClickListener
{
  WalletBankcardDetailUI$2(WalletBankcardDetailUI paramWalletBankcardDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69078);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.OuZ.showDialog(0);
    a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.2
 * JD-Core Version:    0.7.0.1
 */