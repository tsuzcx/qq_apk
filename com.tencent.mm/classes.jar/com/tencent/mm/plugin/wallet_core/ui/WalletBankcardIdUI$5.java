package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletBankcardIdUI$5
  implements View.OnClickListener
{
  WalletBankcardIdUI$5(WalletBankcardIdUI paramWalletBankcardIdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70726);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.DcG.showDialog(1);
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.5
 * JD-Core Version:    0.7.0.1
 */