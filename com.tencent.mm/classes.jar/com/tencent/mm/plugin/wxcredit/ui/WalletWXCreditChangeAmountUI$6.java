package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.List;

final class WalletWXCreditChangeAmountUI$6
  implements View.OnClickListener
{
  WalletWXCreditChangeAmountUI$6(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48694);
    if (WalletWXCreditChangeAmountUI.b(this.vIv))
    {
      if (WalletWXCreditChangeAmountUI.c(this.vIv).vHW != null)
      {
        if (WalletWXCreditChangeAmountUI.d(this.vIv).getVisibility() == 0) {
          WalletWXCreditChangeAmountUI.c(this.vIv).vHW.ooD = WalletWXCreditChangeAmountUI.d(this.vIv).getText().toString();
        }
        if (WalletWXCreditChangeAmountUI.f(this.vIv).vHW == null) {
          break label231;
        }
        if (WalletWXCreditChangeAmountUI.g(this.vIv).getVisibility() != 0) {}
      }
      label231:
      for (WalletWXCreditChangeAmountUI.f(this.vIv).vHW.ooD = WalletWXCreditChangeAmountUI.g(this.vIv).getText().toString();; WalletWXCreditChangeAmountUI.f(this.vIv).ooD = WalletWXCreditChangeAmountUI.h(this.vIv).getText().toString())
      {
        paramView = new ArrayList();
        paramView.add(WalletWXCreditChangeAmountUI.c(this.vIv));
        paramView.add(WalletWXCreditChangeAmountUI.f(this.vIv));
        String str = this.vIv.getInput().getString("kreq_token");
        this.vIv.getInput().getString("key_bank_type");
        paramView = new c(paramView, str);
        this.vIv.doSceneForceProgress(paramView);
        AppMethodBeat.o(48694);
        return;
        WalletWXCreditChangeAmountUI.c(this.vIv).ooD = WalletWXCreditChangeAmountUI.e(this.vIv).getText().toString();
        break;
      }
    }
    t.makeText(this.vIv.getContext(), 2131305804, 0).show();
    AppMethodBeat.o(48694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.6
 * JD-Core Version:    0.7.0.1
 */