package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;

final class x$11
  implements View.OnClickListener
{
  x$11(x paramx) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    if (x.r(this.oHV))
    {
      paramView = this.oHV;
      paramView.oHP += 1;
      if (!x.s(this.oHV)) {
        break label38;
      }
    }
    for (;;)
    {
      return;
      label38:
      x.t(this.oHV);
      if (this.oHV.oGR.getVisibility() == 0)
      {
        this.oHV.oGR.setVisibility(4);
        this.oHV.oGS.setVisibility(8);
        x.j(this.oHV).setVisibility(4);
      }
      while (this.oHV.oHm != null)
      {
        paramView = this.oHV.oHm;
        if (this.oHV.oGR.getVisibility() == 0) {
          bool = true;
        }
        paramView.jp(bool);
        return;
        this.oHV.oGR.setVisibility(4);
        this.oHV.oGS.setVisibility(0);
        x.j(this.oHV).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.11
 * JD-Core Version:    0.7.0.1
 */