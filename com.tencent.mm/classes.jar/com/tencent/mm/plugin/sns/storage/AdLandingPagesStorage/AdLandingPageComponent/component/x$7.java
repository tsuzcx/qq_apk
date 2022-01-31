package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.y;

final class x$7
  implements View.OnClickListener
{
  x$7(x paramx) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "btn onclick view [%b] bar[%b]", new Object[] { Boolean.valueOf(x.a(this.oHV).isPlaying()), Boolean.valueOf(this.oHV.oGR.bNU) });
    x.b(this.oHV);
    if (this.oHV.oGR.bNU)
    {
      x.c(this.oHV);
      x.a(this.oHV, 4);
      x.f(this.oHV);
      return;
    }
    if (this.oHV.oGZ) {
      this.oHV.bER();
    }
    for (;;)
    {
      x.e(this.oHV);
      x.a(this.oHV, 3);
      if (!this.oHV.oCa) {
        break;
      }
      this.oHV.bEW();
      break;
      this.oHV.bEV();
      x.d(this.oHV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.7
 * JD-Core Version:    0.7.0.1
 */