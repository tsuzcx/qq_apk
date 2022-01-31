package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class PayURemittanceDetailUI$8
  implements DialogInterface.OnClickListener
{
  PayURemittanceDetailUI$8(PayURemittanceDetailUI paramPayURemittanceDetailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.bC(this.qOI.mController.uMN, this.qOI.getString(a.i.remittance_detail_msg_collect_suc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.8
 * JD-Core Version:    0.7.0.1
 */