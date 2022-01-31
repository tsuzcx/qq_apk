package com.tencent.mm.plugin.wallet_payu.order.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.a;

final class PayUMallOrderRecordListUI$2
  implements Runnable
{
  PayUMallOrderRecordListUI$2(PayUMallOrderRecordListUI paramPayUMallOrderRecordListUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(48431);
    PayUMallOrderRecordListUI.i(this.uCY).notifyDataSetChanged();
    AppMethodBeat.o(48431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI.2
 * JD-Core Version:    0.7.0.1
 */