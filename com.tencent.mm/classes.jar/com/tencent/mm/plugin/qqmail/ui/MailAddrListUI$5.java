package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MailAddrListUI$5
  implements MenuItem.OnMenuItemClickListener
{
  MailAddrListUI$5(MailAddrListUI paramMailAddrListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(123041);
    this.BvT.setResult(0);
    this.BvT.finish();
    AppMethodBeat.o(123041);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.5
 * JD-Core Version:    0.7.0.1
 */