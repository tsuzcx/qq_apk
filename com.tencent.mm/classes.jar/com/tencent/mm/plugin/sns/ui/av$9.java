package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class av$9
  implements Animation.AnimationListener
{
  boolean rPJ = false;
  
  av$9(av paramav, LinearLayout paramLinearLayout, Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(39411);
    if (this.rPK != null) {
      this.rPK.setPressed(false);
    }
    if (!this.rPJ)
    {
      this.rPJ = true;
      if (((this.rXd.cmc instanceof t)) && (((t)this.rXd.cmc).ctC())) {
        this.rXd.rWO.notifyDataSetChanged();
      }
    }
    if (this.rXf != null) {
      this.rXf.run();
    }
    AppMethodBeat.o(39411);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av.9
 * JD-Core Version:    0.7.0.1
 */