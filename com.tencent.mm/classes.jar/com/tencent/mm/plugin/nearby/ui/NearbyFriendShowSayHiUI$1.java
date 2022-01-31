package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NearbyFriendShowSayHiUI$1
  implements MenuItem.OnMenuItemClickListener
{
  NearbyFriendShowSayHiUI$1(NearbyFriendShowSayHiUI paramNearbyFriendShowSayHiUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(55426);
    this.pcS.hideVKB();
    this.pcS.finish();
    AppMethodBeat.o(55426);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI.1
 * JD-Core Version:    0.7.0.1
 */