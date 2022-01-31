package com.tencent.mm.ui.widget.listview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PullDownListView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  PullDownListView$5(PullDownListView paramPullDownListView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(112730);
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)PullDownListView.m(this.AIy).getLayoutParams();
    localMarginLayoutParams.topMargin = paramValueAnimator.intValue();
    PullDownListView.m(this.AIy).setLayoutParams(localMarginLayoutParams);
    AppMethodBeat.o(112730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView.5
 * JD-Core Version:    0.7.0.1
 */