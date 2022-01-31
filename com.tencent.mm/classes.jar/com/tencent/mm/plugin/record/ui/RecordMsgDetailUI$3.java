package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class RecordMsgDetailUI$3
  implements MenuItem.OnMenuItemClickListener
{
  RecordMsgDetailUI$3(RecordMsgDetailUI paramRecordMsgDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24238);
    paramMenuItem = new d(this.pZH.getContext(), 1, false);
    paramMenuItem.sao = new RecordMsgDetailUI.3.1(this);
    paramMenuItem.sap = new RecordMsgDetailUI.3.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(24238);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.3
 * JD-Core Version:    0.7.0.1
 */