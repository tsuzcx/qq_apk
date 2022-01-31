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
    AppMethodBeat.i(68437);
    paramMenuItem = this.pOX.getResources().getStringArray(2131755025);
    h.a(this.pOX, null, paramMenuItem, this.pOX.getResources().getString(2131302310), false, new ReadMailUI.13.1(this));
    AppMethodBeat.o(68437);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.13
 * JD-Core Version:    0.7.0.1
 */