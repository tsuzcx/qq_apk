package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NearbyFriendsIntroUI$2
  implements MenuItem.OnMenuItemClickListener
{
  NearbyFriendsIntroUI$2(NearbyFriendsIntroUI paramNearbyFriendsIntroUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(55436);
    this.pcT.hideVKB();
    this.pcT.finish();
    AppMethodBeat.o(55436);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI.2
 * JD-Core Version:    0.7.0.1
 */