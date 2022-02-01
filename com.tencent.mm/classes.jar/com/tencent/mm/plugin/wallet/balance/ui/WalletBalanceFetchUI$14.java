package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class WalletBalanceFetchUI$14
  implements View.OnClickListener
{
  WalletBalanceFetchUI$14(WalletBalanceFetchUI paramWalletBalanceFetchUI, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68593);
    ac.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog closeIcon click");
    if ((this.AZd != null) && (this.AZd.isShowing())) {
      this.AZd.dismiss();
    }
    AppMethodBeat.o(68593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.14
 * JD-Core Version:    0.7.0.1
 */