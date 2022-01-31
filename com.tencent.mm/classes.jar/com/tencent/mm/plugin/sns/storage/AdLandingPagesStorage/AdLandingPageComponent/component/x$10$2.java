package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.y;

final class x$10$2
  implements Runnable
{
  x$10$2(x.10 param10, int paramInt) {}
  
  public final void run()
  {
    y.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + this.gFM + " video time " + x.q(this.oHX.oHV));
    if (this.oHX.oHV.oGR.getVideoTotalTime() != x.q(this.oHX.oHV)) {
      this.oHX.oHV.oGR.setVideoTotalTime(x.q(this.oHX.oHV));
    }
    this.oHX.oHV.oGR.seek(this.gFM);
    this.oHX.oHV.oGR.setIsPlay(x.a(this.oHX.oHV).isPlaying());
    if (x.a(this.oHX.oHV).isPlaying()) {
      x.p(this.oHX.oHV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.10.2
 * JD-Core Version:    0.7.0.1
 */