package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.sdk.b.a;

final class r$6
  implements AdLandingVideoWrapper.a
{
  r$6(r paramr) {}
  
  public final void Ef(int paramInt)
  {
    AppMethodBeat.i(37209);
    if ((r.a(this.rxh).rsG != null) && (paramInt * 1000 >= r.a(this.rxh).rsG.rtj) && (!this.rxh.rwI))
    {
      this.rxh.rwI = true;
      mf localmf = new mf();
      localmf.cCn.cCo = r.a(this.rxh).rsG.cCo;
      a.ymk.l(localmf);
    }
    AppMethodBeat.o(37209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r.6
 * JD-Core Version:    0.7.0.1
 */