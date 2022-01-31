package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.a.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

final class WalletBalanceFetchUI$6
  implements DialogInterface.OnClickListener
{
  WalletBalanceFetchUI$6(WalletBalanceFetchUI paramWalletBalanceFetchUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45360);
    paramDialogInterface.dismiss();
    paramDialogInterface = "";
    if (WalletBalanceFetchUI.b(this.tOj) != null) {
      paramDialogInterface = WalletBalanceFetchUI.b(this.tOj).field_bankcardType;
    }
    WalletBalanceFetchUI.p(this.tOj);
    WalletBalanceFetchUI.q(this.tOj);
    this.tOj.doSceneProgress(new d(WalletBalanceFetchUI.r(this.tOj), "CNY", paramDialogInterface, WalletBalanceFetchUI.s(this.tOj)));
    AppMethodBeat.o(45360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.6
 * JD-Core Version:    0.7.0.1
 */