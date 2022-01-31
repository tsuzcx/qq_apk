package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.at.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class LocationWidget$2
  implements View.OnClickListener
{
  LocationWidget$2(LocationWidget paramLocationWidget) {}
  
  public final void onClick(View paramView)
  {
    if (b.mC((String)g.DP().Dz().get(274436, null)))
    {
      if (com.tencent.mm.pluginsdk.permission.a.j(LocationWidget.d(this.oQA), "android.permission.ACCESS_COARSE_LOCATION")) {
        break label155;
      }
      if (!((Boolean)g.DP().Dz().get(ac.a.uzP, Boolean.valueOf(false))).booleanValue()) {
        com.tencent.mm.plugin.account.a.b.a.b(LocationWidget.d(this.oQA), this.oQA.getResources().getString(i.j.location_use_scene_gdpr_url, new Object[] { x.cqJ() }), 30764, true);
      }
    }
    boolean bool;
    do
    {
      return;
      com.tencent.mm.pluginsdk.permission.a.b(LocationWidget.d(this.oQA), "android.permission.ACCESS_COARSE_LOCATION", 64);
      return;
      bool = com.tencent.mm.pluginsdk.permission.a.a(LocationWidget.d(this.oQA), "android.permission.ACCESS_COARSE_LOCATION", 64, "", "");
      y.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    } while (!bool);
    label155:
    this.oQA.bHA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget.2
 * JD-Core Version:    0.7.0.1
 */