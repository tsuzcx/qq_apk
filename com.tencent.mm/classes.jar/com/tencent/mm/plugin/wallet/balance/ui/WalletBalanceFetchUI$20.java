package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletBalanceFetchUI$20
  implements View.OnClickListener
{
  WalletBalanceFetchUI$20(WalletBalanceFetchUI paramWalletBalanceFetchUI, Context paramContext, String paramString, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213890);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog completeBtn click");
    com.tencent.mm.plugin.account.a.b.a.b(this.val$context, this.val$url, 2, true);
    if ((this.HvS != null) && (this.HvS.isShowing())) {
      this.HvS.dismiss();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.20
 * JD-Core Version:    0.7.0.1
 */