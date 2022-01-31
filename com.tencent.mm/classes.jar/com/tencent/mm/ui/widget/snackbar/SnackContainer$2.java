package com.tencent.mm.ui.widget.snackbar;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;

final class SnackContainer$2
  implements Animation.AnimationListener
{
  SnackContainer$2(SnackContainer paramSnackContainer) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(112993);
    this.AKD.removeAllViews();
    if (!SnackContainer.b(this.AKD).isEmpty()) {
      SnackContainer.d((SnackContainer.a)SnackContainer.b(this.AKD).poll());
    }
    if (!this.AKD.isEmpty())
    {
      SnackContainer.a(this.AKD, (SnackContainer.a)SnackContainer.b(this.AKD).peek());
      AppMethodBeat.o(112993);
      return;
    }
    this.AKD.setVisibility(8);
    AppMethodBeat.o(112993);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(112992);
    if ((!this.AKD.isEmpty()) && (SnackContainer.b(this.AKD).peek() != null) && (((SnackContainer.a)SnackContainer.b(this.AKD).peek()).AKJ != null))
    {
      b.rJ(false);
      ((SnackContainer.a)SnackContainer.b(this.AKD).peek()).AKJ.cPa();
    }
    AppMethodBeat.o(112992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer.2
 * JD-Core Version:    0.7.0.1
 */