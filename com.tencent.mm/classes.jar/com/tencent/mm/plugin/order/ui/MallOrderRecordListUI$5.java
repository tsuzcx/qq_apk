package com.tencent.mm.plugin.order.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMLoadMoreListView;

final class MallOrderRecordListUI$5
  implements Runnable
{
  MallOrderRecordListUI$5(MallOrderRecordListUI paramMallOrderRecordListUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(43854);
    if (this.prh.orF)
    {
      ab.v("MicroMsg.WalletOrderListUI", "has more");
      if (!this.prh.prf)
      {
        this.prh.ejW.dDY();
        this.prh.ejW.setAdapter(this.prh.prc);
        this.prh.prf = true;
      }
    }
    for (;;)
    {
      this.prh.prc.notifyDataSetChanged();
      AppMethodBeat.o(43854);
      return;
      ab.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
      this.prh.ejW.dDZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.5
 * JD-Core Version:    0.7.0.1
 */