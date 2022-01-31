package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AddMoreFriendsUI$2
  implements MenuItem.OnMenuItemClickListener
{
  AddMoreFriendsUI$2(AddMoreFriendsUI paramAddMoreFriendsUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(25505);
    this.sZu.finish();
    AppMethodBeat.o(25505);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI.2
 * JD-Core Version:    0.7.0.1
 */