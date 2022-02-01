package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

final class LocationWidget$2
  implements View.OnClickListener
{
  LocationWidget$2(LocationWidget paramLocationWidget) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(97937);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (com.tencent.mm.aw.b.Gw((String)g.ajR().ajA().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.n(LocationWidget.d(this.Ajz), "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)g.ajR().ajA().get(am.a.IYR, Boolean.FALSE)).booleanValue()) {
          com.tencent.mm.plugin.account.a.b.a.b(LocationWidget.d(this.Ajz), this.Ajz.getResources().getString(2131760740, new Object[] { ad.fom() }), 30764, true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97937);
          return;
          com.tencent.mm.pluginsdk.permission.b.b(LocationWidget.d(this.Ajz), "android.permission.ACCESS_COARSE_LOCATION", 64);
        }
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(LocationWidget.d(this.Ajz), "android.permission.ACCESS_COARSE_LOCATION", 64, "", "");
      ae.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97937);
        return;
      }
    }
    this.Ajz.edx();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(97937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget.2
 * JD-Core Version:    0.7.0.1
 */