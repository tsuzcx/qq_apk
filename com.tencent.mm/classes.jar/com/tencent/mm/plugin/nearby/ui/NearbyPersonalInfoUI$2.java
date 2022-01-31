package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;

final class NearbyPersonalInfoUI$2
  implements MenuItem.OnMenuItemClickListener
{
  NearbyPersonalInfoUI$2(NearbyPersonalInfoUI paramNearbyPersonalInfoUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (NearbyPersonalInfoUI.a(this.mDH) != -1)
    {
      paramMenuItem = bn.Id();
      paramMenuItem.sex = NearbyPersonalInfoUI.a(this.mDH);
      bn.a(paramMenuItem);
    }
    paramMenuItem = bn.Ie();
    if (paramMenuItem == null)
    {
      NearbyPersonalInfoUI.b(this.mDH);
      return true;
    }
    String str = bk.pm(paramMenuItem.getProvince());
    bk.pm(paramMenuItem.getCity());
    int i = paramMenuItem.sex;
    if ((bk.bl(str)) || (i == 0))
    {
      NearbyPersonalInfoUI.b(this.mDH);
      return true;
    }
    this.mDH.startActivity(new Intent(this.mDH, NearbyFriendsUI.class));
    paramMenuItem = bn.Id();
    if (i != -1) {
      paramMenuItem.sex = i;
    }
    ((j)g.r(j.class)).Fv().b(new i.a(1, bn.a(paramMenuItem)));
    this.mDH.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI.2
 * JD-Core Version:    0.7.0.1
 */