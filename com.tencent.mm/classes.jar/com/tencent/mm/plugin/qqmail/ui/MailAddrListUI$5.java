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
    AppMethodBeat.i(68315);
    this.pNn.setResult(0);
    this.pNn.finish();
    AppMethodBeat.o(68315);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.5
 * JD-Core Version:    0.7.0.1
 */