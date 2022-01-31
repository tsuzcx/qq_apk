package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletWXCreditChangeAmountUI$8
  implements AdapterView.OnItemClickListener
{
  WalletWXCreditChangeAmountUI$8(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(48696);
    this.vIv.dismissDialog(2);
    if (WalletWXCreditChangeAmountUI.l(this.vIv)) {
      if (paramInt == 0) {
        WalletWXCreditChangeAmountUI.c(this.vIv).ooD = "Y";
      }
    }
    for (;;)
    {
      WalletWXCreditChangeAmountUI.k(this.vIv);
      AppMethodBeat.o(48696);
      return;
      WalletWXCreditChangeAmountUI.c(this.vIv).ooD = "N";
      continue;
      if (paramInt == 0) {
        WalletWXCreditChangeAmountUI.f(this.vIv).ooD = "Y";
      } else {
        WalletWXCreditChangeAmountUI.f(this.vIv).ooD = "N";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.8
 * JD-Core Version:    0.7.0.1
 */