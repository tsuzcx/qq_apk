package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class aa$9
  implements View.OnClickListener
{
  aa$9(aa paramaa) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37311);
    aa.b(this.rxT);
    this.rxT.rwQ = false;
    this.rxT.rwN = true;
    this.rxT.rwX = 3;
    this.rxT.cqD();
    this.rxT.setFocus(true);
    al.p(new aa.9.1(this), 10000L);
    AppMethodBeat.o(37311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa.9
 * JD-Core Version:    0.7.0.1
 */