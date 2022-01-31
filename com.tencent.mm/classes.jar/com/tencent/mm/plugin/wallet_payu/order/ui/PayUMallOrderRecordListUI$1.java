package com.tencent.mm.plugin.wallet_payu.order.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMLoadMoreListView;

final class PayUMallOrderRecordListUI$1
  implements Runnable
{
  PayUMallOrderRecordListUI$1(PayUMallOrderRecordListUI paramPayUMallOrderRecordListUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(48430);
    if (PayUMallOrderRecordListUI.a(this.uCY))
    {
      ab.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
      if (!PayUMallOrderRecordListUI.b(this.uCY))
      {
        PayUMallOrderRecordListUI.c(this.uCY).dDY();
        PayUMallOrderRecordListUI.e(this.uCY).setAdapter(PayUMallOrderRecordListUI.d(this.uCY));
        PayUMallOrderRecordListUI.f(this.uCY);
      }
    }
    for (;;)
    {
      PayUMallOrderRecordListUI.h(this.uCY).notifyDataSetChanged();
      AppMethodBeat.o(48430);
      return;
      ab.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
      PayUMallOrderRecordListUI.g(this.uCY).dDZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI.1
 * JD-Core Version:    0.7.0.1
 */