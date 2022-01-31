package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletWXCreditChangeAmountUI$1
  implements View.OnClickListener
{
  WalletWXCreditChangeAmountUI$1(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48688);
    WalletWXCreditChangeAmountUI.a(this.vIv, true);
    WalletWXCreditChangeAmountUI.a(this.vIv);
    this.vIv.showDialog(1);
    AppMethodBeat.o(48688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.1
 * JD-Core Version:    0.7.0.1
 */