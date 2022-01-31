package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.sdk.platformtools.y;

final class WalletBalanceFetchPwdInputUI$3
  implements DialogInterface.OnCancelListener
{
  WalletBalanceFetchPwdInputUI$3(WalletBalanceFetchPwdInputUI paramWalletBalanceFetchPwdInputUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: dialog cancel. finish");
    WalletBalanceFetchPwdInputUI.a(this.qgp).dismiss();
    this.qgp.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI.3
 * JD-Core Version:    0.7.0.1
 */