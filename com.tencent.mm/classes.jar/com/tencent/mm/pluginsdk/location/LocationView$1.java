package com.tencent.mm.pluginsdk.location;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class LocationView$1
  implements View.OnClickListener
{
  LocationView$1(LocationView paramLocationView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(169199);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (com.tencent.mm.aw.b.Pi((String)g.aAh().azQ().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.n(this.JTt.getContext(), "android.permission.ACCESS_FINE_LOCATION"))
      {
        if (!((Boolean)g.aAh().azQ().get(ar.a.Oho, Boolean.FALSE)).booleanValue()) {
          LocationView.a(this.JTt);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169199);
          return;
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this.JTt.getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
        }
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.JTt.getContext(), "android.permission.ACCESS_FINE_LOCATION", 64, "", "");
      Log.i("MicroMsg.LocationView", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        a.a(this, "com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(169199);
        return;
      }
    }
    LocationView.b(this.JTt);
    a.a(this, "com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(169199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationView.1
 * JD-Core Version:    0.7.0.1
 */