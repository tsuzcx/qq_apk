package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

final class LocationWidget$2
  implements View.OnClickListener
{
  LocationWidget$2(LocationWidget paramLocationWidget) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(97937);
    if (com.tencent.mm.ax.b.yL((String)g.afB().afk().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.o(LocationWidget.d(this.xom), "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)g.afB().afk().get(ae.a.FtT, Boolean.FALSE)).booleanValue())
        {
          a.b(LocationWidget.d(this.xom), this.xom.getResources().getString(2131760740, new Object[] { ac.eFu() }), 30764, true);
          AppMethodBeat.o(97937);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.b(LocationWidget.d(this.xom), "android.permission.ACCESS_COARSE_LOCATION", 64);
        AppMethodBeat.o(97937);
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(LocationWidget.d(this.xom), "android.permission.ACCESS_COARSE_LOCATION", 64, "", "");
      ad.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(97937);
        return;
      }
    }
    this.xom.dzf();
    AppMethodBeat.o(97937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget.2
 * JD-Core Version:    0.7.0.1
 */