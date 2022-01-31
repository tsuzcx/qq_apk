package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;

final class r$9
  implements Runnable
{
  r$9(r paramr) {}
  
  public final void run()
  {
    if (!this.oHr.oGQ.isPlaying())
    {
      if (this.oHr.oGQ.getCurrPosSec() == this.oHr.oGQ.getVideoDurationSec()) {
        this.oHr.yf(0);
      }
    }
    else {
      return;
    }
    this.oHr.yf(this.oHr.oGQ.getCurrPosSec());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r.9
 * JD-Core Version:    0.7.0.1
 */