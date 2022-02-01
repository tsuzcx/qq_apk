package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class d$3
  implements View.OnClickListener
{
  d$3(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(96423);
    if (!this.ylX.ylW)
    {
      AppMethodBeat.o(96423);
      return;
    }
    paramView = this.ylX;
    paramView.clickCount += 1;
    if (this.ylX.ylV != null) {
      paramView = null;
    }
    for (;;)
    {
      try
      {
        if ((this.ylX.ylV instanceof o))
        {
          paramView = ((o)this.ylX.ylV).ynj;
          if (paramView != null)
          {
            paramView.performClick();
            i = this.ylX.ylV.clickCount;
            ac.i("AdLandingFloatBarCompWrapper", "onClick, clickCount=" + this.ylX.clickCount + ", btnClickCount=" + i);
            AppMethodBeat.o(96423);
          }
        }
        else
        {
          if (!(this.ylX.ylV instanceof q)) {
            continue;
          }
          paramView = ((q)this.ylX.ylV).ynt;
          continue;
        }
        ac.e("AdLandingFloatBarCompWrapper", "onClick noBtn found, comp=" + this.ylX.ylV);
        continue;
        int i = 0;
      }
      catch (Exception paramView)
      {
        ac.e("AdLandingFloatBarCompWrapper", "onClick exp=" + paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d.3
 * JD-Core Version:    0.7.0.1
 */