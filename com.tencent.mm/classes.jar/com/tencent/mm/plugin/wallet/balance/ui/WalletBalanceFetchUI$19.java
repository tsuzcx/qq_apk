package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletBalanceFetchUI$19
  implements View.OnClickListener
{
  WalletBalanceFetchUI$19(WalletBalanceFetchUI paramWalletBalanceFetchUI, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213889);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog closeIcon click");
    if ((this.HvS != null) && (this.HvS.isShowing())) {
      this.HvS.dismiss();
    }
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.19
 * JD-Core Version:    0.7.0.1
 */