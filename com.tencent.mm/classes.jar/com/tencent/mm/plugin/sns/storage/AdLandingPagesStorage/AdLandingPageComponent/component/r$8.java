package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;

final class r$8
  implements View.OnClickListener
{
  r$8(r paramr) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = true;
    int i;
    if (this.oHr.oGQ.getVideoDurationSec() > 0)
    {
      i = 1;
      if (i != 0) {
        if (this.oHr.oGR.getVisibility() == 0) {
          break label56;
        }
      }
    }
    for (;;)
    {
      this.oHr.oGY = bool;
      this.oHr.jo(bool);
      return;
      i = 0;
      break;
      label56:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r.8
 * JD-Core Version:    0.7.0.1
 */