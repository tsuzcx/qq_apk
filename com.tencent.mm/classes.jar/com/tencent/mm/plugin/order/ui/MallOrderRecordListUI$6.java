package com.tencent.mm.plugin.order.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallOrderRecordListUI$6
  implements Runnable
{
  MallOrderRecordListUI$6(MallOrderRecordListUI paramMallOrderRecordListUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(43855);
    this.prh.prc.notifyDataSetChanged();
    AppMethodBeat.o(43855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.6
 * JD-Core Version:    0.7.0.1
 */