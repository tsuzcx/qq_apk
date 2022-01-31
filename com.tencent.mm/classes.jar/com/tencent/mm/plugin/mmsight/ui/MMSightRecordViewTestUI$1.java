package com.tencent.mm.plugin.mmsight.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMSightRecordViewTestUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MMSightRecordViewTestUI$1(MMSightRecordViewTestUI paramMMSightRecordViewTestUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(55117);
    this.oOk.finish();
    AppMethodBeat.o(55117);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.1
 * JD-Core Version:    0.7.0.1
 */