package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

final class WalletWXCreditChangeAmountUI$6
  implements View.OnClickListener
{
  WalletWXCreditChangeAmountUI$6(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  public final void onClick(View paramView)
  {
    if (WalletWXCreditChangeAmountUI.b(this.rRF))
    {
      if (WalletWXCreditChangeAmountUI.c(this.rRF).rRg != null)
      {
        if (WalletWXCreditChangeAmountUI.d(this.rRF).getVisibility() == 0) {
          WalletWXCreditChangeAmountUI.c(this.rRF).rRg.lQN = WalletWXCreditChangeAmountUI.d(this.rRF).getText().toString();
        }
        if (WalletWXCreditChangeAmountUI.f(this.rRF).rRg == null) {
          break label223;
        }
        if (WalletWXCreditChangeAmountUI.g(this.rRF).getVisibility() != 0) {}
      }
      label223:
      for (WalletWXCreditChangeAmountUI.f(this.rRF).rRg.lQN = WalletWXCreditChangeAmountUI.g(this.rRF).getText().toString();; WalletWXCreditChangeAmountUI.f(this.rRF).lQN = WalletWXCreditChangeAmountUI.h(this.rRF).getText().toString())
      {
        paramView = new ArrayList();
        paramView.add(WalletWXCreditChangeAmountUI.c(this.rRF));
        paramView.add(WalletWXCreditChangeAmountUI.f(this.rRF));
        String str = this.rRF.BX.getString("kreq_token");
        this.rRF.BX.getString("key_bank_type");
        paramView = new c(paramView, str);
        this.rRF.a(paramView, true, false);
        return;
        WalletWXCreditChangeAmountUI.c(this.rRF).lQN = WalletWXCreditChangeAmountUI.e(this.rRF).getText().toString();
        break;
      }
    }
    com.tencent.mm.ui.base.s.makeText(this.rRF.mController.uMN, a.i.wallet_wxcredit_qustion_input_err, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.6
 * JD-Core Version:    0.7.0.1
 */