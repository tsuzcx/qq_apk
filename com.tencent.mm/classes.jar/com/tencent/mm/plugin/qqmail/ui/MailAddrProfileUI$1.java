package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MailAddrProfileUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MailAddrProfileUI$1(MailAddrProfileUI paramMailAddrProfileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68333);
    this.pNv.hideVKB();
    this.pNv.finish();
    AppMethodBeat.o(68333);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrProfileUI.1
 * JD-Core Version:    0.7.0.1
 */