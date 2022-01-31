package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.y;

final class WalletPasswordSettingUI$12
  implements DialogInterface.OnClickListener
{
  WalletPasswordSettingUI$12(WalletPasswordSettingUI paramWalletPasswordSettingUI, k paramk) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.WalletPasswordSettingUI", "user click the button to set system fingerprint");
    this.qpH.dh(this.qpD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.12
 * JD-Core Version:    0.7.0.1
 */