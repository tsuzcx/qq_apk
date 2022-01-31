package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ContactSearchUI$4
  implements MenuItem.OnMenuItemClickListener
{
  ContactSearchUI$4(ContactSearchUI paramContactSearchUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(25528);
    this.sZC.hideVKB();
    this.sZC.finish();
    AppMethodBeat.o(25528);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI.4
 * JD-Core Version:    0.7.0.1
 */