package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletLqtBalanceAutoTransferUI$2
  implements View.OnClickListener
{
  WalletLqtBalanceAutoTransferUI$2(WalletLqtBalanceAutoTransferUI paramWalletLqtBalanceAutoTransferUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68753);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtBalanceAutoTransferUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.d("MicroMsg.WalletLqtBalanceAutoTransferUI", "click time layout");
    WalletLqtBalanceAutoTransferUI.c(this.Hxh);
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtBalanceAutoTransferUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI.2
 * JD-Core Version:    0.7.0.1
 */