package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;

final class r$11
  implements Runnable
{
  r$11(r paramr) {}
  
  public final void run()
  {
    AppMethodBeat.i(37215);
    if (!this.rxh.rwF.isPlaying())
    {
      if (this.rxh.rwF.getCurrPosSec() != this.rxh.rwF.getVideoDurationSec()) {
        break label65;
      }
      this.rxh.Ee(0);
    }
    for (;;)
    {
      this.rxh.rwF.crz();
      AppMethodBeat.o(37215);
      return;
      label65:
      this.rxh.Ee(this.rxh.rwF.getCurrPosSec());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r.11
 * JD-Core Version:    0.7.0.1
 */