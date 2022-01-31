package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.pluginsdk.ui.d.c.a;
import java.util.List;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37034);
    paramView = this.ruT;
    paramView.clickCount += 1;
    if (c.a.wbU == null)
    {
      AppMethodBeat.o(37034);
      return;
    }
    if (c.a(this.ruT).rrT.size() > 1)
    {
      c.a.wbU.a(this.ruT.context, c.a(this.ruT).rrT, new c.1.1(this));
      AppMethodBeat.o(37034);
      return;
    }
    if (c.a(this.ruT).rrT.size() > 0) {
      AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)this.ruT.context, (String)c.a(this.ruT).rrT.get(0));
    }
    AppMethodBeat.o(37034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c.1
 * JD-Core Version:    0.7.0.1
 */