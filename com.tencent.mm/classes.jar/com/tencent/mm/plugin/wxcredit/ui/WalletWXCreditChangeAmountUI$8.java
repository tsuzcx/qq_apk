package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class WalletWXCreditChangeAmountUI$8
  implements AdapterView.OnItemClickListener
{
  WalletWXCreditChangeAmountUI$8(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.rRF.dismissDialog(2);
    if (WalletWXCreditChangeAmountUI.l(this.rRF)) {
      if (paramInt == 0) {
        WalletWXCreditChangeAmountUI.c(this.rRF).lQN = "Y";
      }
    }
    for (;;)
    {
      WalletWXCreditChangeAmountUI.k(this.rRF);
      return;
      WalletWXCreditChangeAmountUI.c(this.rRF).lQN = "N";
      continue;
      if (paramInt == 0) {
        WalletWXCreditChangeAmountUI.f(this.rRF).lQN = "Y";
      } else {
        WalletWXCreditChangeAmountUI.f(this.rRF).lQN = "N";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.8
 * JD-Core Version:    0.7.0.1
 */