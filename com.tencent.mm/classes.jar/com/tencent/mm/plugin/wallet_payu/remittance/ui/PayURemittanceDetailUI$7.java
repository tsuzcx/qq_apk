package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.view.View;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

final class PayURemittanceDetailUI$7
  implements a.a
{
  PayURemittanceDetailUI$7(PayURemittanceDetailUI paramPayURemittanceDetailUI) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.qOI, this.qOI.getString(a.i.remittance_detail_refund_tips, new Object[] { PayURemittanceDetailUI.QY(PayURemittanceDetailUI.f(this.qOI)) }), this.qOI.getString(a.i.app_remind), this.qOI.getString(a.i.remittance_detail_refuse_btn_text), this.qOI.getString(a.i.app_cancel), new PayURemittanceDetailUI.7.1(this), new PayURemittanceDetailUI.7.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.7
 * JD-Core Version:    0.7.0.1
 */