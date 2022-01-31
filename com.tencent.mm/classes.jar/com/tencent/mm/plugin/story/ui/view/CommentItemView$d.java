package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
import a.v;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class CommentItemView$d
  implements ValueAnimator.AnimatorUpdateListener
{
  CommentItemView$d(CommentItemView paramCommentItemView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(110344);
    j.p(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(110344);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramValueAnimator = this.sLG.getLayoutParams();
    paramValueAnimator.width = (CommentItemView.c(this.sLG) + (int)((CommentItemView.d(this.sLG) - CommentItemView.c(this.sLG)) * f));
    int i = CommentItemView.c(this.sLG);
    paramValueAnimator.height = ((int)(f * (CommentItemView.e(this.sLG) - CommentItemView.c(this.sLG))) + i);
    this.sLG.setLayoutParams(paramValueAnimator);
    AppMethodBeat.o(110344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentItemView.d
 * JD-Core Version:    0.7.0.1
 */