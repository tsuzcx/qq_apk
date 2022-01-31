package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletVerifyCodeUI$8$1
  implements DialogInterface.OnClickListener
{
  WalletVerifyCodeUI$8$1(WalletVerifyCodeUI.8 param8) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess2 and finish to reset mobile num!");
    paramDialogInterface = this.qHj.qHg.BX;
    paramDialogInterface.putInt("key_err_code", 408);
    a.j(this.qHj.qHg, paramDialogInterface);
    this.qHj.qHg.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.8.1
 * JD-Core Version:    0.7.0.1
 */