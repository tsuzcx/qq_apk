package com.tencent.mm.plugin.wxcredit.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

final class WalletWXCreditDetailUI$1
  implements DialogInterface.OnClickListener
{
  WalletWXCreditDetailUI$1(WalletWXCreditDetailUI paramWalletWXCreditDetailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48720);
    this.vIB.dSV().a(new com.tencent.mm.plugin.wxcredit.a.i(WalletWXCreditDetailUI.a(this.vIB).field_bankcardType, WalletWXCreditDetailUI.a(this.vIB).ufI), true, 1);
    AppMethodBeat.o(48720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI.1
 * JD-Core Version:    0.7.0.1
 */