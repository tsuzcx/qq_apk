package com.tencent.mm.plugin.recharge.ui;

import android.content.res.Resources;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class PhoneRechargeUI$12
  implements MallFormView.a
{
  PhoneRechargeUI$12(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(44265);
    if (paramBoolean)
    {
      this.pWp.hideVKB();
      String str = b.xw(PhoneRechargeUI.a(this.pWp).getText());
      if (str == null)
      {
        ab.e("MicroMsg.PhoneRechargeUI", "null phone, return");
        AppMethodBeat.o(44265);
        return;
      }
      d.g(new PhoneRechargeUI.12.1(this, str), "search_matched_mobile");
      if (!PhoneRechargeUI.c(this.pWp))
      {
        ab.d("MicroMsg.PhoneRechargeUI", "clear focus");
        PhoneRechargeUI.a(this.pWp, true);
        AppMethodBeat.o(44265);
        return;
      }
      PhoneRechargeUI.a(this.pWp, false);
      AppMethodBeat.o(44265);
      return;
    }
    PhoneRechargeUI.a(this.pWp).getTipsTv().setText("");
    PhoneRechargeUI.a(this.pWp).getTipsTv().setTextColor(this.pWp.getResources().getColor(2131690322));
    PhoneRechargeUI.d(this.pWp);
    PhoneRechargeUI.e(this.pWp);
    if (bo.isNullOrNil(PhoneRechargeUI.a(this.pWp).getText())) {
      ((AutoCompleteTextView)PhoneRechargeUI.a(this.pWp).getContentEditText()).showDropDown();
    }
    AppMethodBeat.o(44265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.12
 * JD-Core Version:    0.7.0.1
 */