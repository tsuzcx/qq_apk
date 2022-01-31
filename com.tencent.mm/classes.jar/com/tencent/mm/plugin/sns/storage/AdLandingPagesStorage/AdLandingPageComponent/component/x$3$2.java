package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class x$3$2
  implements Runnable
{
  x$3$2(x.3 param3, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(37276);
    ab.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + this.qVH + " video time " + x.g(this.rxH.rxG));
    if ((x.b(this.rxH.rxG).rsG != null) && (this.qVH * 1000 >= x.b(this.rxH.rxG).rsG.rtj) && (!x.h(this.rxH.rxG)))
    {
      x.i(this.rxH.rxG);
      mf localmf = new mf();
      localmf.cCn.cCo = x.b(this.rxH.rxG).rsG.cCo;
      a.ymk.l(localmf);
    }
    AppMethodBeat.o(37276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.3.2
 * JD-Core Version:    0.7.0.1
 */