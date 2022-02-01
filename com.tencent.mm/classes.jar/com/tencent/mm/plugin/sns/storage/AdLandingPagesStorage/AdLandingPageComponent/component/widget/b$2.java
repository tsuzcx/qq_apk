package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;

final class b$2
  implements Runnable
{
  b$2(b paramb, double paramDouble) {}
  
  public final void run()
  {
    AppMethodBeat.i(96873);
    ad.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", new Object[] { Double.valueOf(this.ySc), bt.flS().toString() });
    b.a(this.zIf, this.ySc);
    AppMethodBeat.o(96873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.2
 * JD-Core Version:    0.7.0.1
 */