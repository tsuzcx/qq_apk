package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;

final class z$10
  implements Runnable
{
  z$10(z paramz) {}
  
  public final void run()
  {
    OfflineVideoView localOfflineVideoView = this.oHY.oHK;
    boolean bool;
    if ((localOfflineVideoView.iuC instanceof VideoPlayerTextureView)) {
      if ((((VideoPlayerTextureView)localOfflineVideoView.iuC).coq()) && (localOfflineVideoView.isPlaying())) {
        bool = true;
      }
    }
    while (!bool)
    {
      this.oHY.oGR.setIsPlay(true);
      this.oHY.oHK.bHL();
      return;
      bool = false;
      continue;
      bool = localOfflineVideoView.isPlaying();
    }
    this.oHY.oHK.startTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z.10
 * JD-Core Version:    0.7.0.1
 */