package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WalletPayUI$9
  implements DialogInterface.OnCancelListener
{
  WalletPayUI$9(WalletPayUI paramWalletPayUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.WalletPayUI", "WalletPwdDialog event2 %s", new Object[] { bk.csb().toString() });
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.qnV.frT = null;
    this.qnV.qgo = null;
    if (this.qnV.aSk()) {
      this.qnV.finish();
    }
    this.qnV.qmC = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.9
 * JD-Core Version:    0.7.0.1
 */