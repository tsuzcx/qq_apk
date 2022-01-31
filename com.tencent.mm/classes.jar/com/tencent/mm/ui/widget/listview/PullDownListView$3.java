package com.tencent.mm.ui.widget.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PullDownListView$3
  extends AnimatorListenerAdapter
{
  PullDownListView$3(PullDownListView paramPullDownListView) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(112727);
    if (PullDownListView.b(this.AIy) != null) {
      PullDownListView.b(this.AIy).setVisibility(8);
    }
    AppMethodBeat.o(112727);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(112726);
    if (PullDownListView.b(this.AIy) != null) {
      PullDownListView.b(this.AIy).setVisibility(8);
    }
    AppMethodBeat.o(112726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView.3
 * JD-Core Version:    0.7.0.1
 */