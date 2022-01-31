package com.tencent.mm.plugin.order.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;

final class MallOrderRecordListUI$3
  implements MMLoadMoreListView.a
{
  MallOrderRecordListUI$3(MallOrderRecordListUI paramMallOrderRecordListUI) {}
  
  public final void Kt()
  {
    AppMethodBeat.i(43852);
    if (!this.prh.isLoading)
    {
      this.prh.isLoading = true;
      MallOrderRecordListUI localMallOrderRecordListUI = this.prh;
      localMallOrderRecordListUI.Fb += 10;
      this.prh.caz();
    }
    AppMethodBeat.o(43852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.3
 * JD-Core Version:    0.7.0.1
 */