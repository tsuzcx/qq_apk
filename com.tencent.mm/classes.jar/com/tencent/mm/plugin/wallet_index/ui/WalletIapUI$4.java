package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.plugin.wallet_index.c.b;
import com.tencent.mm.sdk.platformtools.y;

final class WalletIapUI$4
  implements DialogInterface.OnCancelListener
{
  WalletIapUI$4(WalletIapUI paramWalletIapUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.WalletIapUI", "showLoadingDialog onCancel");
    paramDialogInterface = b.aP(1, "");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramDialogInterface.ljp);
    localIntent.putExtra("key_err_msg", paramDialogInterface.ljq);
    this.qMn.setResult(-1, localIntent);
    this.qMn.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.4
 * JD-Core Version:    0.7.0.1
 */