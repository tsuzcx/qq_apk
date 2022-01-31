package com.tencent.mm.plugin.order.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMLoadMoreListView;

final class MallOrderRecordListUI$5
  implements Runnable
{
  MallOrderRecordListUI$5(MallOrderRecordListUI paramMallOrderRecordListUI) {}
  
  public final void run()
  {
    if (this.mQU.lUw)
    {
      y.v("MicroMsg.WalletOrderListUI", "has more");
      if (!this.mQU.mQS)
      {
        this.mQU.dso.cAO();
        this.mQU.dso.setAdapter(this.mQU.mQP);
        this.mQU.mQS = true;
      }
    }
    for (;;)
    {
      this.mQU.mQP.notifyDataSetChanged();
      return;
      y.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
      this.mQU.dso.cAP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.5
 * JD-Core Version:    0.7.0.1
 */