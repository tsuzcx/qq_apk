package com.tencent.mm.plugin.story.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class StoryActionView$b
  implements ValueAnimator.AnimatorUpdateListener
{
  StoryActionView$b(TextView paramTextView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(120067);
    TextView localTextView = this.gZf;
    p.g(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(120067);
      throw paramValueAnimator;
    }
    localTextView.setTextColor(((Integer)paramValueAnimator).intValue());
    AppMethodBeat.o(120067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryActionView.b
 * JD-Core Version:    0.7.0.1
 */