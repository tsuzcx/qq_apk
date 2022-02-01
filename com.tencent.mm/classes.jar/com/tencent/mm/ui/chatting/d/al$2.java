package com.tencent.mm.ui.chatting.d;

import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class al$2
  implements q.g
{
  al$2(al paramal) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(35464);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35464);
      return;
      if (com.tencent.mm.az.b.WF((String)h.aHG().aHp().b(274436, null)))
      {
        if ((com.tencent.mm.pluginsdk.permission.b.o(this.WMG.fgR.WQv.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.o(this.WMG.fgR.WQv.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label292;
          }
          if (((Boolean)h.aHG().aHp().get(ar.a.VvE, Boolean.FALSE)).booleanValue()) {
            break;
          }
          com.tencent.mm.plugin.account.sdk.b.a.b(this.WMG.fgR.WQv.getContext(), this.WMG.fgR.WQv.getMMResources().getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30763, true);
          AppMethodBeat.o(35464);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.a(this.WMG.fgR.WQv.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 67);
        AppMethodBeat.o(35464);
        return;
      }
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.WMG.fgR.WQv.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 67, null, null);
      Log.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(35464);
        return;
      }
      label292:
      this.WMG.hQg();
      AppMethodBeat.o(35464);
      return;
      if (com.tencent.mm.az.b.WF((String)h.aHG().aHp().b(274436, null)))
      {
        if ((com.tencent.mm.pluginsdk.permission.b.o(this.WMG.fgR.WQv.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.o(this.WMG.fgR.WQv.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label559;
          }
          if (((Boolean)h.aHG().aHp().get(ar.a.VvE, Boolean.FALSE)).booleanValue()) {
            break;
          }
          com.tencent.mm.plugin.account.sdk.b.a.b(this.WMG.fgR.WQv.getContext(), this.WMG.fgR.WQv.getMMResources().getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30762, true);
          AppMethodBeat.o(35464);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.a(this.WMG.fgR.WQv.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68);
        AppMethodBeat.o(35464);
        return;
      }
      bool = com.tencent.mm.pluginsdk.permission.b.a(this.WMG.fgR.WQv.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68, null, null);
      Log.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(35464);
        return;
      }
      label559:
      this.WMG.hQh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.al.2
 * JD-Core Version:    0.7.0.1
 */