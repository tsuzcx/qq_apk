package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class WalletBalanceFetchUI$16
  implements View.OnClickListener
{
  WalletBalanceFetchUI$16(WalletBalanceFetchUI paramWalletBalanceFetchUI, Context paramContext, String paramString, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190058);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog completeBtn click");
    com.tencent.mm.plugin.account.a.b.a.b(this.val$context, this.val$url, 2, true);
    if ((this.CQU != null) && (this.CQU.isShowing())) {
      this.CQU.dismiss();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(190058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.16
 * JD-Core Version:    0.7.0.1
 */