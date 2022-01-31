package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.sdk.b.a;

final class aa$6
  implements AdLandingVideoWrapper.a
{
  aa$6(aa paramaa) {}
  
  public final void Ef(int paramInt)
  {
    AppMethodBeat.i(37307);
    if ((aa.a(this.rxT).rsG != null) && (paramInt * 1000 >= aa.a(this.rxT).rsG.rtj) && (!this.rxT.rwI))
    {
      this.rxT.rwI = true;
      mf localmf = new mf();
      localmf.cCn.cCo = aa.a(this.rxT).rsG.cCo;
      a.ymk.l(localmf);
    }
    AppMethodBeat.o(37307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa.6
 * JD-Core Version:    0.7.0.1
 */