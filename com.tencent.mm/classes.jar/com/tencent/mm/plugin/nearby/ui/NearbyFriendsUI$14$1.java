package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class NearbyFriendsUI$14$1
  implements n.d
{
  NearbyFriendsUI$14$1(NearbyFriendsUI.14 param14) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      NearbyFriendsUI.a(this.mDu.mDs, 4);
      NearbyFriendsUI.t(this.mDu.mDs);
      g.DP().Dz().o(16386, Integer.valueOf(NearbyFriendsUI.h(this.mDu.mDs)));
      NearbyFriendsUI.u(this.mDu.mDs);
      return;
    case 1: 
      NearbyFriendsUI.a(this.mDu.mDs, 3);
      NearbyFriendsUI.t(this.mDu.mDs);
      g.DP().Dz().o(16386, Integer.valueOf(NearbyFriendsUI.h(this.mDu.mDs)));
      NearbyFriendsUI.u(this.mDu.mDs);
      return;
    case 2: 
      NearbyFriendsUI.a(this.mDu.mDs, 1);
      NearbyFriendsUI.t(this.mDu.mDs);
      g.DP().Dz().o(16386, Integer.valueOf(NearbyFriendsUI.h(this.mDu.mDs)));
      NearbyFriendsUI.u(this.mDu.mDs);
      return;
    case 3: 
      paramMenuItem = new Intent(this.mDu.mDs, NearbySayHiListUI.class);
      paramMenuItem.putExtra("k_say_hi_type", 2);
      this.mDu.mDs.startActivityForResult(paramMenuItem, 2009);
      return;
    }
    NearbyFriendsUI.b(this.mDu.mDs, new c(2, 0.0F, 0.0F, 0, 0, "", ""));
    g.Dk().a(NearbyFriendsUI.v(this.mDu.mDs), 0);
    paramMenuItem = this.mDu.mDs;
    AppCompatActivity localAppCompatActivity = this.mDu.mDs.mController.uMN;
    this.mDu.mDs.getString(b.h.app_tip);
    NearbyFriendsUI.a(paramMenuItem, h.b(localAppCompatActivity, this.mDu.mDs.getString(b.h.nearby_friend_clearing_location), true, new NearbyFriendsUI.14.1.1(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.14.1
 * JD-Core Version:    0.7.0.1
 */