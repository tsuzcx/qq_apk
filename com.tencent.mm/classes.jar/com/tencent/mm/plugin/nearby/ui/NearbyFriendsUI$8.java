package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.h;

final class NearbyFriendsUI$8
  implements a.a
{
  NearbyFriendsUI$8(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (NearbyFriendsUI.d(this.mDs)) {
      return false;
    }
    NearbyFriendsUI.e(this.mDs);
    if (this.mDs.edT)
    {
      if (NearbyFriendsUI.f(this.mDs) != null)
      {
        NearbyFriendsUI.f(this.mDs).dismiss();
        NearbyFriendsUI.a(this.mDs, null);
      }
      com.tencent.mm.plugin.report.service.g.wK(11);
      return false;
    }
    boolean bool;
    if (paramBoolean)
    {
      if (NearbyFriendsUI.f(this.mDs) != null) {
        NearbyFriendsUI.f(this.mDs).setMessage(this.mDs.getString(b.h.nearby_friend_finding));
      }
      NearbyFriendsUI.a(this.mDs, new NearbyFriendsUI.a(this.mDs, paramFloat2, paramFloat1, (int)paramDouble2));
      e locale = e.Rq();
      if (paramInt == 0)
      {
        paramBoolean = false;
        if (NearbyFriendsUI.g(this.mDs) != null) {
          break label245;
        }
        bool = false;
        label149:
        locale.a(2001, paramBoolean, bool, paramFloat1, paramFloat2, (int)paramDouble2);
        NearbyFriendsUI.a(this.mDs, new com.tencent.mm.plugin.nearby.a.c(NearbyFriendsUI.h(this.mDs), NearbyFriendsUI.i(this.mDs).ell, NearbyFriendsUI.i(this.mDs).elk, NearbyFriendsUI.i(this.mDs).accuracy, paramInt, "", ""));
        com.tencent.mm.kernel.g.Dk().a(NearbyFriendsUI.b(this.mDs), 0);
      }
    }
    for (;;)
    {
      return false;
      paramBoolean = true;
      break;
      label245:
      bool = NearbyFriendsUI.g(this.mDs).elu;
      break label149;
      com.tencent.mm.plugin.report.service.g.wK(11);
      if (NearbyFriendsUI.f(this.mDs) != null)
      {
        NearbyFriendsUI.f(this.mDs).dismiss();
        NearbyFriendsUI.a(this.mDs, null);
      }
      NearbyFriendsUI.j(this.mDs);
      this.mDs.findViewById(b.d.nearby_friend_locate_failed).setVisibility(0);
      NearbyFriendsUI.k(this.mDs).setVisibility(8);
      NearbyFriendsUI.l(this.mDs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.8
 * JD-Core Version:    0.7.0.1
 */