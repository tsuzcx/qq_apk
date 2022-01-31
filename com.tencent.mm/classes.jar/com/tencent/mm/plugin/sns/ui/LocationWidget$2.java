package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class LocationWidget$2
  implements View.OnClickListener
{
  LocationWidget$2(LocationWidget paramLocationWidget) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38286);
    if (com.tencent.mm.au.b.tM((String)g.RL().Ru().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.o(LocationWidget.d(this.rIm), "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)g.RL().Ru().get(ac.a.yKH, Boolean.FALSE)).booleanValue())
        {
          a.b(LocationWidget.d(this.rIm), this.rIm.getResources().getString(2131306183, new Object[] { aa.dsG() }), 30764, true);
          AppMethodBeat.o(38286);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.b(LocationWidget.d(this.rIm), "android.permission.ACCESS_COARSE_LOCATION", 64);
        AppMethodBeat.o(38286);
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(LocationWidget.d(this.rIm), "android.permission.ACCESS_COARSE_LOCATION", 64, "", "");
      ab.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(38286);
        return;
      }
    }
    this.rIm.ctG();
    AppMethodBeat.o(38286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget.2
 * JD-Core Version:    0.7.0.1
 */