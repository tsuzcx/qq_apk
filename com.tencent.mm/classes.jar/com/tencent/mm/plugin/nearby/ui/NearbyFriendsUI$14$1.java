package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class NearbyFriendsUI$14$1
  implements n.d
{
  NearbyFriendsUI$14$1(NearbyFriendsUI.14 param14) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(55456);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55456);
      return;
      NearbyFriendsUI.a(this.pdp.pdm, 4);
      NearbyFriendsUI.v(this.pdp.pdm);
      g.RL().Ru().set(16386, Integer.valueOf(NearbyFriendsUI.h(this.pdp.pdm)));
      NearbyFriendsUI.w(this.pdp.pdm);
      AppMethodBeat.o(55456);
      return;
      NearbyFriendsUI.a(this.pdp.pdm, 3);
      NearbyFriendsUI.v(this.pdp.pdm);
      g.RL().Ru().set(16386, Integer.valueOf(NearbyFriendsUI.h(this.pdp.pdm)));
      NearbyFriendsUI.w(this.pdp.pdm);
      AppMethodBeat.o(55456);
      return;
      NearbyFriendsUI.a(this.pdp.pdm, 1);
      NearbyFriendsUI.v(this.pdp.pdm);
      g.RL().Ru().set(16386, Integer.valueOf(NearbyFriendsUI.h(this.pdp.pdm)));
      NearbyFriendsUI.w(this.pdp.pdm);
      AppMethodBeat.o(55456);
      return;
      paramMenuItem = new Intent(this.pdp.pdm, NearbySayHiListUI.class);
      paramMenuItem.putExtra("k_say_hi_type", 2);
      this.pdp.pdm.startActivityForResult(paramMenuItem, 2009);
      AppMethodBeat.o(55456);
      return;
      NearbyFriendsUI.b(this.pdp.pdm, new c(2, 0.0F, 0.0F, 0, 0, "", ""));
      g.Rc().a(NearbyFriendsUI.x(this.pdp.pdm), 0);
      paramMenuItem = this.pdp.pdm;
      AppCompatActivity localAppCompatActivity = this.pdp.pdm.getContext();
      this.pdp.pdm.getString(2131297087);
      NearbyFriendsUI.a(paramMenuItem, h.b(localAppCompatActivity, this.pdp.pdm.getString(2131301752), true, new NearbyFriendsUI.14.1.1(this)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.14.1
 * JD-Core Version:    0.7.0.1
 */