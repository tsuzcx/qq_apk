package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;

final class aa$11
  implements Runnable
{
  aa$11(aa paramaa) {}
  
  public final void run()
  {
    AppMethodBeat.i(37313);
    if (!this.rxT.rwF.isPlaying())
    {
      if (this.rxT.rwF.getCurrPosSec() != this.rxT.rwF.getVideoDurationSec()) {
        break label65;
      }
      this.rxT.Ee(0);
    }
    for (;;)
    {
      this.rxT.rwF.crz();
      AppMethodBeat.o(37313);
      return;
      label65:
      this.rxT.Ee(this.rxT.rwF.getCurrPosSec());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa.11
 * JD-Core Version:    0.7.0.1
 */