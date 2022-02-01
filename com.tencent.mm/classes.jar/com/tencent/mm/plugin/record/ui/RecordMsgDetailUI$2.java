package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RecordMsgDetailUI$2
  implements MenuItem.OnMenuItemClickListener
{
  RecordMsgDetailUI$2(RecordMsgDetailUI paramRecordMsgDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(305290);
    this.NBO.finish();
    AppMethodBeat.o(305290);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.2
 * JD-Core Version:    0.7.0.1
 */