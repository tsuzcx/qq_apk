package com.tencent.mm.plugin.sns.ui;

import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsSightPlayerUI$9$2
  implements Runnable
{
  SnsSightPlayerUI$9$2(SnsSightPlayerUI.9 param9) {}
  
  public final void run()
  {
    AppMethodBeat.i(39259);
    if (SnsSightPlayerUI.k(this.rVX.rVT).getVisibility() != 0)
    {
      SnsSightPlayerUI.k(this.rVX.rVT).setVisibility(0);
      SnsSightPlayerUI.k(this.rVX.rVT).startAnimation(AnimationUtils.loadAnimation(this.rVX.rVT.getContext(), 2131034181));
    }
    AppMethodBeat.o(39259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.9.2
 * JD-Core Version:    0.7.0.1
 */