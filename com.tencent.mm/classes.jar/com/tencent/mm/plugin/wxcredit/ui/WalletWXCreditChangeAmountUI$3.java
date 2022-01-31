package com.tencent.mm.plugin.wxcredit.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletWXCreditChangeAmountUI$3
  implements DialogInterface.OnClickListener
{
  WalletWXCreditChangeAmountUI$3(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = a.aj(this.rRF);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.b(this.rRF, this.rRF.BX);
      return;
    }
    this.rRF.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.3
 * JD-Core Version:    0.7.0.1
 */