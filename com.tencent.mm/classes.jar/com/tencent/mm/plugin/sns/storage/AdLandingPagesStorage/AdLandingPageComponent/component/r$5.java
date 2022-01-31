package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.sdk.platformtools.y;

final class r$5
  implements View.OnClickListener
{
  r$5(r paramr) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(this.oHr.oGQ.isPlaying()) });
    if (this.oHr.oGQ.isPlaying())
    {
      this.oHr.bFy();
      this.oHr.oHh = 4;
      if (this.oHr.oCc)
      {
        paramView = this.oHr;
        paramView.oHk += 1;
      }
      return;
    }
    if (this.oHr.oGZ) {
      this.oHr.bER();
    }
    for (;;)
    {
      r.a(this.oHr);
      this.oHr.oHh = 3;
      break;
      this.oHr.bEW();
      this.oHr.bEV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r.5
 * JD-Core Version:    0.7.0.1
 */