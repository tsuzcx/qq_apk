package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

final class PayURemittanceDetailUI$3
  implements a.a
{
  PayURemittanceDetailUI$3(PayURemittanceDetailUI paramPayURemittanceDetailUI) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.qOI, this.qOI.getString(a.i.remittance_detail_refund_tips, new Object[] { PayURemittanceDetailUI.QX(PayURemittanceDetailUI.e(this.qOI)) }), this.qOI.getString(a.i.app_remind), this.qOI.getString(a.i.remittance_detail_refuse_btn_text), this.qOI.getString(a.i.app_cancel), new PayURemittanceDetailUI.3.1(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.3
 * JD-Core Version:    0.7.0.1
 */