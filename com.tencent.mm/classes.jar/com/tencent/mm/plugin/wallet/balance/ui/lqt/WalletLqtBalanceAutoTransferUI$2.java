package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class WalletLqtBalanceAutoTransferUI$2
  implements View.OnClickListener
{
  WalletLqtBalanceAutoTransferUI$2(WalletLqtBalanceAutoTransferUI paramWalletLqtBalanceAutoTransferUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68753);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtBalanceAutoTransferUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.d("MicroMsg.WalletLqtBalanceAutoTransferUI", "click time layout");
    WalletLqtBalanceAutoTransferUI.c(this.CSk);
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtBalanceAutoTransferUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI.2
 * JD-Core Version:    0.7.0.1
 */