package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ReadMailUI$9
  implements MenuItem.OnMenuItemClickListener
{
  ReadMailUI$9(ReadMailUI paramReadMailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68429);
    this.pOX.finish();
    AppMethodBeat.o(68429);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.9
 * JD-Core Version:    0.7.0.1
 */