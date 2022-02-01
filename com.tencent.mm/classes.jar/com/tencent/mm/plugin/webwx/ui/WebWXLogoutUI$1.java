package com.tencent.mm.plugin.webwx.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebWXLogoutUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WebWXLogoutUI$1(WebWXLogoutUI paramWebWXLogoutUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(30213);
    this.JFH.finish();
    AppMethodBeat.o(30213);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.1
 * JD-Core Version:    0.7.0.1
 */