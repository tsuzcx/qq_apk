package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RecordMsgBaseUI$3
  implements MenuItem.OnMenuItemClickListener
{
  RecordMsgBaseUI$3(RecordMsgBaseUI paramRecordMsgBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(27874);
    this.BHY.finish();
    AppMethodBeat.o(27874);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgBaseUI.3
 * JD-Core Version:    0.7.0.1
 */