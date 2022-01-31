package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$8
  implements View.OnClickListener
{
  r$8(r paramr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37211);
    paramView = this.rxh;
    paramView.rxb += 1;
    if (this.rxh.rwP)
    {
      this.rxh.cqE();
      this.rxh.cqD();
    }
    for (;;)
    {
      this.rxh.rwM = true;
      AppMethodBeat.o(37211);
      return;
      this.rxh.cqy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r.8
 * JD-Core Version:    0.7.0.1
 */