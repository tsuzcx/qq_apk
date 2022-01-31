package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;

final class NearbyFriendsUI$14
  implements MenuItem.OnMenuItemClickListener
{
  NearbyFriendsUI$14(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.mDs, 1, false);
    paramMenuItem.phI = new NearbyFriendsUI.14.1(this);
    paramMenuItem.phH = new n.c()
    {
      public final void a(l paramAnonymousl)
      {
        paramAnonymousl.fq(-1, b.h.nearby_friend_location_findmm);
        paramAnonymousl.fq(-1, b.h.nearby_friend_location_findgg);
        paramAnonymousl.fq(-1, b.h.nearby_friend_location_findall);
        paramAnonymousl.fq(-1, b.h.say_hi_list_lbs_title);
        paramAnonymousl.fq(-1, b.h.nearby_friend_clear_location_exit);
      }
    };
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.14
 * JD-Core Version:    0.7.0.1
 */