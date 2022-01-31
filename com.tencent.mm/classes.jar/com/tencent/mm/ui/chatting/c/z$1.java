package com.tencent.mm.ui.chatting.c;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class z$1
  implements h.c
{
  z$1(z paramz) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(31569);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31569);
      return;
      if (com.tencent.mm.au.b.tM((String)g.RL().Ru().get(274436, null)))
      {
        if ((com.tencent.mm.pluginsdk.permission.b.o(this.zGV.caz.zJz.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.o(this.zGV.caz.zJz.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label289;
          }
          if (((Boolean)g.RL().Ru().get(ac.a.yKH, Boolean.FALSE)).booleanValue()) {
            break;
          }
          com.tencent.mm.plugin.account.a.b.a.b(this.zGV.caz.zJz.getContext(), this.zGV.caz.zJz.getMMResources().getString(2131306183, new Object[] { aa.dsG() }), 30763, true);
          AppMethodBeat.o(31569);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.a(this.zGV.caz.zJz.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67);
        AppMethodBeat.o(31569);
        return;
      }
      boolean bool = com.tencent.mm.pluginsdk.permission.b.b(this.zGV.caz.zJz.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67);
      ab.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(31569);
        return;
      }
      label289:
      this.zGV.dIR();
      AppMethodBeat.o(31569);
      return;
      if (com.tencent.mm.au.b.tM((String)g.RL().Ru().get(274436, null)))
      {
        if ((com.tencent.mm.pluginsdk.permission.b.o(this.zGV.caz.zJz.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.o(this.zGV.caz.zJz.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label557;
          }
          if (((Boolean)g.RL().Ru().get(ac.a.yKH, Boolean.FALSE)).booleanValue()) {
            break;
          }
          com.tencent.mm.plugin.account.a.b.a.b(this.zGV.caz.zJz.getContext(), this.zGV.caz.zJz.getMMResources().getString(2131306183, new Object[] { aa.dsG() }), 30762, true);
          AppMethodBeat.o(31569);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.a(this.zGV.caz.zJz.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68);
        AppMethodBeat.o(31569);
        return;
      }
      bool = com.tencent.mm.pluginsdk.permission.b.b(this.zGV.caz.zJz.getContext(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68);
      ab.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(31569);
        return;
      }
      label557:
      this.zGV.dIS();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.z.1
 * JD-Core Version:    0.7.0.1
 */