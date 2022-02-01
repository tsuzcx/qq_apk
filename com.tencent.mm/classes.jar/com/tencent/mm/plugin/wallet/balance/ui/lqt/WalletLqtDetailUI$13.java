package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletLqtDetailUI$13
  implements View.OnClickListener
{
  WalletLqtDetailUI$13(WalletLqtDetailUI paramWalletLqtDetailUI, android.support.design.widget.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190065);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.CTc.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(190065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.13
 * JD-Core Version:    0.7.0.1
 */