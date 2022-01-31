package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.pluginsdk.ui.d.c.a;
import java.util.List;

final class d$1
  implements View.OnClickListener
{
  d$1(d paramd) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.oFt;
    paramView.oFs += 1;
    if (c.a.sjo == null) {}
    do
    {
      return;
      if (d.a(this.oFt).oCu.size() > 1)
      {
        c.a.sjo.a(this.oFt.context, d.a(this.oFt).oCu, new d.1.1(this));
        return;
      }
    } while (d.a(this.oFt).oCu.size() <= 0);
    AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)this.oFt.context, (String)d.a(this.oFt).oCu.get(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d.1
 * JD-Core Version:    0.7.0.1
 */