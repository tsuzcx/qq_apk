package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;

final class z$9
  implements View.OnClickListener
{
  z$9(z paramz) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = true;
    if (this.oHY.dDs)
    {
      this.oHY.oHR = true;
      if (this.oHY.oGR.getVisibility() != 0) {
        break label106;
      }
      this.oHY.oGR.setVisibility(4);
      this.oHY.oGS.setVisibility(8);
      this.oHY.hoY.setVisibility(4);
      if (this.oHY.oHm != null)
      {
        paramView = this.oHY.oHm;
        if (this.oHY.oGR.getVisibility() != 0) {
          break label142;
        }
      }
    }
    for (;;)
    {
      paramView.jp(bool);
      return;
      label106:
      this.oHY.oGR.setVisibility(0);
      this.oHY.oGS.setVisibility(0);
      this.oHY.hoY.setVisibility(0);
      break;
      label142:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z.9
 * JD-Core Version:    0.7.0.1
 */