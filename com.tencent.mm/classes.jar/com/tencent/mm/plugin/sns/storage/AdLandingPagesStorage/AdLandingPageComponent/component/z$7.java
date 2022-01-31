package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ai;

final class z$7
  implements View.OnClickListener
{
  z$7(z paramz) {}
  
  public final void onClick(View paramView)
  {
    this.oHY.oHN = true;
    this.oHY.aEw();
    this.oHY.oHa = false;
    if (this.oHY.oGW) {
      if (this.oHY.oGZ) {
        this.oHY.bER();
      }
    }
    for (;;)
    {
      this.oHY.oHh = 3;
      this.oHY.oGR.setVisibility(0);
      this.oHY.oGS.setVisibility(0);
      this.oHY.hoY.setVisibility(0);
      if (this.oHY.oHm != null) {
        this.oHY.oHm.jp(true);
      }
      ai.l(new z.7.1(this), 10000L);
      return;
      this.oHY.bEV();
      this.oHY.oHU = true;
      continue;
      this.oHY.bEV();
      this.oHY.oHU = true;
      this.oHY.oGW = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z.7
 * JD-Core Version:    0.7.0.1
 */