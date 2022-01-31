package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;

final class NearbyPersonalInfoUI$2
  implements MenuItem.OnMenuItemClickListener
{
  NearbyPersonalInfoUI$2(NearbyPersonalInfoUI paramNearbyPersonalInfoUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(55484);
    if (NearbyPersonalInfoUI.a(this.pdJ) != -1)
    {
      paramMenuItem = bp.aba();
      paramMenuItem.dqC = NearbyPersonalInfoUI.a(this.pdJ);
      bp.a(paramMenuItem);
    }
    paramMenuItem = bp.abb();
    if (paramMenuItem == null) {
      NearbyPersonalInfoUI.b(this.pdJ);
    }
    for (;;)
    {
      AppMethodBeat.o(55484);
      return true;
      String str = bo.nullAsNil(paramMenuItem.getProvince());
      bo.nullAsNil(paramMenuItem.getCity());
      int i = paramMenuItem.dqC;
      if ((bo.isNullOrNil(str)) || (i == 0))
      {
        NearbyPersonalInfoUI.b(this.pdJ);
      }
      else
      {
        this.pdJ.startActivity(new Intent(this.pdJ, NearbyFriendsUI.class));
        paramMenuItem = bp.aba();
        if (i != -1) {
          paramMenuItem.dqC = i;
        }
        ((j)g.E(j.class)).Yz().c(new j.a(1, bp.a(paramMenuItem)));
        this.pdJ.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI.2
 * JD-Core Version:    0.7.0.1
 */