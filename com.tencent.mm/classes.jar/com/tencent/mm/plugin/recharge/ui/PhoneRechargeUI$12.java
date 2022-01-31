package com.tencent.mm.plugin.recharge.ui;

import android.content.res.Resources;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class PhoneRechargeUI$12
  implements MallFormView.a
{
  PhoneRechargeUI$12(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void gG(boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      this.nrb.XM();
      str = b.qa(PhoneRechargeUI.a(this.nrb).getText());
      if (str == null) {
        y.e("MicroMsg.PhoneRechargeUI", "null phone, return");
      }
    }
    do
    {
      return;
      e.a(new PhoneRechargeUI.12.1(this, str), "search_matched_mobile");
      if (!PhoneRechargeUI.c(this.nrb))
      {
        y.d("MicroMsg.PhoneRechargeUI", "clear focus");
        PhoneRechargeUI.a(this.nrb, true);
        return;
      }
      PhoneRechargeUI.a(this.nrb, false);
      return;
      PhoneRechargeUI.a(this.nrb).getTipsTv().setText("");
      PhoneRechargeUI.a(this.nrb).getTipsTv().setTextColor(this.nrb.getResources().getColor(a.c.normal_text_color));
      PhoneRechargeUI.d(this.nrb);
      PhoneRechargeUI.e(this.nrb);
    } while (!bk.bl(PhoneRechargeUI.a(this.nrb).getText()));
    ((AutoCompleteTextView)PhoneRechargeUI.a(this.nrb).getContentEditText()).showDropDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.12
 * JD-Core Version:    0.7.0.1
 */