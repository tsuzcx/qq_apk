package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NearbyFriendsUI$12
  implements MenuItem.OnMenuItemClickListener
{
  NearbyFriendsUI$12(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(55453);
    this.pdm.finish();
    AppMethodBeat.o(55453);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.12
 * JD-Core Version:    0.7.0.1
 */