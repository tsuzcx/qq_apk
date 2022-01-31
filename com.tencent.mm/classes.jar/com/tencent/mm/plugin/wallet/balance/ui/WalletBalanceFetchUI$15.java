package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletBalanceFetchUI$15
  implements View.OnClickListener
{
  WalletBalanceFetchUI$15(WalletBalanceFetchUI paramWalletBalanceFetchUI, Context paramContext, String paramString, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142277);
    ab.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog completeBtn click");
    a.b(this.val$context, this.val$url, 2, true);
    if ((this.tOr != null) && (this.tOr.isShowing())) {
      this.tOr.dismiss();
    }
    AppMethodBeat.o(142277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.15
 * JD-Core Version:    0.7.0.1
 */