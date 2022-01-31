package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class RecordMsgFileUI$11
  implements MenuItem.OnMenuItemClickListener
{
  RecordMsgFileUI$11(RecordMsgFileUI paramRecordMsgFileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24265);
    paramMenuItem = new d(this.pZN.getContext(), 1, false);
    paramMenuItem.sao = new RecordMsgFileUI.11.1(this);
    paramMenuItem.sap = new RecordMsgFileUI.11.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(24265);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.11
 * JD-Core Version:    0.7.0.1
 */