package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.view.View;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

final class PayURemittanceDetailUI$1
  implements a.a
{
  PayURemittanceDetailUI$1(PayURemittanceDetailUI paramPayURemittanceDetailUI) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.qOI, this.qOI.getString(a.i.remittance_confirm_resend_msg), this.qOI.getString(a.i.app_remind), this.qOI.getString(a.i.remittance_resend), this.qOI.getString(a.i.app_cancel), new PayURemittanceDetailUI.1.1(this), new PayURemittanceDetailUI.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.1
 * JD-Core Version:    0.7.0.1
 */