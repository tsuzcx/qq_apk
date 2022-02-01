package com.tencent.mm.plugin.story.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class StoryActionView$g
  implements ValueAnimator.AnimatorUpdateListener
{
  StoryActionView$g(TextView paramTextView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(120072);
    TextView localTextView = this.gZf;
    p.g(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(120072);
      throw paramValueAnimator;
    }
    localTextView.setTextSize(0, ((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(120072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryActionView.g
 * JD-Core Version:    0.7.0.1
 */