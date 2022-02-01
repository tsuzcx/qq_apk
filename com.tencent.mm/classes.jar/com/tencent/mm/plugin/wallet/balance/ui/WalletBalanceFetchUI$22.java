package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletBalanceFetchUI$22
  implements View.OnClickListener
{
  WalletBalanceFetchUI$22(WalletBalanceFetchUI paramWalletBalanceFetchUI, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(316274);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog closeIcon click");
    if ((this.Vcv != null) && (this.Vcv.isShowing())) {
      this.Vcv.dismiss();
    }
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.22
 * JD-Core Version:    0.7.0.1
 */