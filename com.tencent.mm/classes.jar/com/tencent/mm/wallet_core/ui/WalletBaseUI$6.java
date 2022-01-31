package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;

final class WalletBaseUI$6
  implements DialogInterface.OnClickListener
{
  WalletBaseUI$6(WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (WalletBaseUI.a(this.wCn) == null) {}
    for (paramDialogInterface = null;; paramDialogInterface = WalletBaseUI.b(this.wCn).findFocus())
    {
      if ((paramDialogInterface != null) && ((paramDialogInterface instanceof EditText))) {
        this.wCn.showVKB();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.6
 * JD-Core Version:    0.7.0.1
 */