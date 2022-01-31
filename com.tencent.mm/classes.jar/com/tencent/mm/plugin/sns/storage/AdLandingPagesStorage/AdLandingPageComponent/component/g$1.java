package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h.a;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.oFC;
    paramView.oFs += 1;
    paramView = new Intent();
    paramView.putExtra("map_view_type", 1);
    paramView.putExtra("kwebmap_slat", this.oFC.oFz.oCw.lCJ);
    paramView.putExtra("kwebmap_lng", this.oFC.oFz.oCw.lCK);
    paramView.putExtra("kwebmap_scale", this.oFC.oFz.oCw.bRv);
    paramView.putExtra("kPoiName", this.oFC.oFz.oCw.bVA);
    paramView.putExtra("Kwebmap_locaion", this.oFC.oFz.oCw.lCM);
    y.i("AdLandingBorderedComp", "locatint to slat " + this.oFC.oFz.oCw.lCJ + ", slong " + this.oFC.oFz.oCw.lCK + ", " + this.oFC.oFz.oCw.bVA);
    d.b(this.oFC.context, "location", ".ui.RedirectUI", paramView, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g.1
 * JD-Core Version:    0.7.0.1
 */