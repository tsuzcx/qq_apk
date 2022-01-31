package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletWXCreditChangeAmountUI$4
  implements View.OnClickListener
{
  WalletWXCreditChangeAmountUI$4(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48692);
    WalletWXCreditChangeAmountUI.a(this.vIv, false);
    WalletWXCreditChangeAmountUI.a(this.vIv);
    this.vIv.showDialog(1);
    AppMethodBeat.o(48692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.4
 * JD-Core Version:    0.7.0.1
 */