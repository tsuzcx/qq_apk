package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

final class b$2
  implements Runnable
{
  b$2(b paramb, double paramDouble) {}
  
  public final void run()
  {
    AppMethodBeat.i(37411);
    ab.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", new Object[] { Double.valueOf(this.qTo), bo.dtY().toString() });
    b.a(this.ryy, this.qTo);
    AppMethodBeat.o(37411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.2
 * JD-Core Version:    0.7.0.1
 */