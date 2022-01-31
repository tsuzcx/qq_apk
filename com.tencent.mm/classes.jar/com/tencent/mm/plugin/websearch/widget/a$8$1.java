package com.tencent.mm.plugin.websearch.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$8$1
  implements ValueAnimator.AnimatorUpdateListener
{
  a$8$1(a.8 param8, ViewGroup.LayoutParams paramLayoutParams1, ViewGroup.LayoutParams paramLayoutParams2) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(91400);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.uMn.height = i;
    this.uMp.uMl.setLayoutParams(this.uMn);
    this.uMo.height = i;
    this.uMp.uMm.setLayoutParams(this.uMo);
    AppMethodBeat.o(91400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.8.1
 * JD-Core Version:    0.7.0.1
 */