package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

final class WalletBaseUI$5
  implements DialogInterface.OnClickListener
{
  WalletBaseUI$5(WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.wCn.cNg();
    paramDialogInterface = a.aj(this.wCn);
    if (paramDialogInterface != null)
    {
      if (!paramDialogInterface.h(this.wCn, this.wCn.BX)) {
        paramDialogInterface.b(this.wCn, this.wCn.BX);
      }
      return;
    }
    this.wCn.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.5
 * JD-Core Version:    0.7.0.1
 */