package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.y;

final class z$8$3
  implements Runnable
{
  z$8$3(z.8 param8, int paramInt) {}
  
  public final void run()
  {
    y.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "play time " + this.gFM + " video time " + this.oIa.oHY.oHM);
    if (this.oIa.oHY.oGR.getVideoTotalTime() != this.oIa.oHY.oHM) {
      this.oIa.oHY.oGR.setVideoTotalTime(this.oIa.oHY.oHM);
    }
    this.oIa.oHY.oGR.seek(this.gFM);
    this.oIa.oHY.oGR.setIsPlay(this.oIa.oHY.oHK.isPlaying());
    if (this.oIa.oHY.oHK.isPlaying()) {
      this.oIa.oHY.dDs = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z.8.3
 * JD-Core Version:    0.7.0.1
 */