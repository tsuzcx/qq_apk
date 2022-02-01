package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ComposeUI$5
  implements MenuItem.OnMenuItemClickListener
{
  ComposeUI$5(ComposeUI paramComposeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(122896);
    ComposeUI.l(this.uOk).onClick(null);
    AppMethodBeat.o(122896);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.5
 * JD-Core Version:    0.7.0.1
 */