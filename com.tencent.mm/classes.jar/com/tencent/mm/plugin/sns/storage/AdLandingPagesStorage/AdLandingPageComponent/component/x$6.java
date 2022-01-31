package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.y;

final class x$6
  implements b
{
  x$6(x paramx) {}
  
  public final void akz()
  {
    if (x.a(this.oHV) != null) {
      x.a(this.oHV).bHK();
    }
  }
  
  public final void lE(int paramInt)
  {
    y.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onSeek time " + paramInt);
    if (this.oHV.oGZ) {
      this.oHV.bER();
    }
    for (;;)
    {
      x.a(this.oHV).Y(paramInt, this.oHV.oGR.bNU);
      return;
      this.oHV.bEV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.6
 * JD-Core Version:    0.7.0.1
 */