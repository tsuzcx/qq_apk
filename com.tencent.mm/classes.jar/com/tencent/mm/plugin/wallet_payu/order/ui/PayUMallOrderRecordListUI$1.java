package com.tencent.mm.plugin.wallet_payu.order.ui;

import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMLoadMoreListView;

final class PayUMallOrderRecordListUI$1
  implements Runnable
{
  PayUMallOrderRecordListUI$1(PayUMallOrderRecordListUI paramPayUMallOrderRecordListUI) {}
  
  public final void run()
  {
    if (PayUMallOrderRecordListUI.a(this.qNR))
    {
      y.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
      if (!PayUMallOrderRecordListUI.b(this.qNR))
      {
        PayUMallOrderRecordListUI.c(this.qNR).cAO();
        PayUMallOrderRecordListUI.e(this.qNR).setAdapter(PayUMallOrderRecordListUI.d(this.qNR));
        PayUMallOrderRecordListUI.f(this.qNR);
      }
    }
    for (;;)
    {
      PayUMallOrderRecordListUI.h(this.qNR).notifyDataSetChanged();
      return;
      y.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
      PayUMallOrderRecordListUI.g(this.qNR).cAP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI.1
 * JD-Core Version:    0.7.0.1
 */