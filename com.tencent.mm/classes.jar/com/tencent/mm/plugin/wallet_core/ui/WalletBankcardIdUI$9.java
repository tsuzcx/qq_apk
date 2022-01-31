package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;

final class WalletBankcardIdUI$9
  implements DialogInterface.OnClickListener
{
  WalletBankcardIdUI$9(WalletBankcardIdUI paramWalletBankcardIdUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (WalletBankcardIdUI.d(this.qAC) == null) {}
    for (paramDialogInterface = null;; paramDialogInterface = WalletBankcardIdUI.e(this.qAC).findFocus())
    {
      if ((paramDialogInterface != null) && ((paramDialogInterface instanceof EditText))) {
        this.qAC.showVKB();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.9
 * JD-Core Version:    0.7.0.1
 */