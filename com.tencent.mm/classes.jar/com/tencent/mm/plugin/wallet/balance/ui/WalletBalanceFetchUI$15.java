package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class WalletBalanceFetchUI$15
  implements View.OnClickListener
{
  WalletBalanceFetchUI$15(WalletBalanceFetchUI paramWalletBalanceFetchUI, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68594);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog closeIcon click");
    if ((this.CQU != null) && (this.CQU.isShowing())) {
      this.CQU.dismiss();
    }
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.15
 * JD-Core Version:    0.7.0.1
 */