package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.bs;
import com.tencent.mm.sdk.b.a;

final class WalletPasswordSettingUI$8
  implements DialogInterface.OnClickListener
{
  WalletPasswordSettingUI$8(WalletPasswordSettingUI paramWalletPasswordSettingUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new bs();
    paramDialogInterface.bFJ = new WalletPasswordSettingUI.8.1(this, paramDialogInterface);
    a.udP.a(paramDialogInterface, this.qpD.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.8
 * JD-Core Version:    0.7.0.1
 */