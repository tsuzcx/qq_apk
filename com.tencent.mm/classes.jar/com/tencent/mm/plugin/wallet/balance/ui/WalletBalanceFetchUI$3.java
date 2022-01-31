package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet.balance.a.b;

final class WalletBalanceFetchUI$3
  implements DialogInterface.OnClickListener
{
  WalletBalanceFetchUI$3(WalletBalanceFetchUI paramWalletBalanceFetchUI, b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (!WalletBalanceFetchUI.a(this.qgO, this.qgT))
    {
      WalletBalanceFetchUI.a(this.qgO, this.qgT.bOT);
      WalletBalanceFetchUI.b(this.qgO, this.qgT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.3
 * JD-Core Version:    0.7.0.1
 */