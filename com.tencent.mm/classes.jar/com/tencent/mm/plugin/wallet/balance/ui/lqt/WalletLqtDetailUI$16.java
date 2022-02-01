package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletLqtDetailUI$16
  implements View.OnClickListener
{
  WalletLqtDetailUI$16(WalletLqtDetailUI paramWalletLqtDetailUI, com.google.android.material.bottomsheet.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(316468);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.Vfg.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.16
 * JD-Core Version:    0.7.0.1
 */