package com.tencent.mm.plugin.qqmail.ui;

import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ReadMailUI$13
  implements MenuItem.OnMenuItemClickListener
{
  ReadMailUI$13(ReadMailUI paramReadMailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(123165);
    paramMenuItem = this.uRh.getResources().getStringArray(2130903057);
    h.b(this.uRh, null, paramMenuItem, this.uRh.getResources().getString(2131762191), new ReadMailUI.13.1(this));
    AppMethodBeat.o(123165);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.13
 * JD-Core Version:    0.7.0.1
 */