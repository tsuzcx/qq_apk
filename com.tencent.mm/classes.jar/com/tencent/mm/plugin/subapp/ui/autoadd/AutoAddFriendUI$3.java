package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AutoAddFriendUI$3
  implements MenuItem.OnMenuItemClickListener
{
  AutoAddFriendUI$3(AutoAddFriendUI paramAutoAddFriendUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(25331);
    this.sXJ.finish();
    AppMethodBeat.o(25331);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI.3
 * JD-Core Version:    0.7.0.1
 */