package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class r$9
  implements View.OnClickListener
{
  r$9(r paramr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37213);
    r.b(this.rxh);
    this.rxh.rwQ = false;
    this.rxh.rwN = true;
    this.rxh.rwX = 3;
    this.rxh.cqD();
    this.rxh.setFocus(true);
    al.p(new r.9.1(this), 10000L);
    AppMethodBeat.o(37213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r.9
 * JD-Core Version:    0.7.0.1
 */