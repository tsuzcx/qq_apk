package com.tencent.mm.ui.chatting.b;

import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.at.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h.c;

final class y$1
  implements h.c
{
  y$1(y paramy) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    }
    boolean bool;
    do
    {
      do
      {
        return;
        if (b.mC((String)g.DP().Dz().get(274436, null)))
        {
          if (com.tencent.mm.pluginsdk.permission.a.j(this.vrq.byx.vtz.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
            break;
          }
          if (!((Boolean)g.DP().Dz().get(ac.a.uzP, Boolean.valueOf(false))).booleanValue())
          {
            com.tencent.mm.plugin.account.a.b.a.b(this.vrq.byx.vtz.getContext(), this.vrq.byx.vtz.getMMResources().getString(R.l.location_use_scene_gdpr_url, new Object[] { x.cqJ() }), 30763, true);
            return;
          }
          com.tencent.mm.pluginsdk.permission.a.b(this.vrq.byx.vtz.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 67);
          return;
        }
        bool = com.tencent.mm.pluginsdk.permission.a.a(this.vrq.byx.vtz.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      } while (!bool);
      this.vrq.cEZ();
      return;
      if (b.mC((String)g.DP().Dz().get(274436, null)))
      {
        if (com.tencent.mm.pluginsdk.permission.a.j(this.vrq.byx.vtz.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
          break;
        }
        if (!((Boolean)g.DP().Dz().get(ac.a.uzP, Boolean.valueOf(false))).booleanValue())
        {
          com.tencent.mm.plugin.account.a.b.a.b(this.vrq.byx.vtz.getContext(), this.vrq.byx.vtz.getMMResources().getString(R.l.location_use_scene_gdpr_url, new Object[] { x.cqJ() }), 30762, true);
          return;
        }
        com.tencent.mm.pluginsdk.permission.a.b(this.vrq.byx.vtz.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 68);
        return;
      }
      bool = com.tencent.mm.pluginsdk.permission.a.a(this.vrq.byx.vtz.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    } while (!bool);
    this.vrq.cFa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.y.1
 * JD-Core Version:    0.7.0.1
 */