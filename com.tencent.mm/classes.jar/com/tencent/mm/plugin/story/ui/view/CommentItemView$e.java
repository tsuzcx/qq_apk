package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.f.b.u.d;
import a.l;
import a.v;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class CommentItemView$e
  implements ValueAnimator.AnimatorUpdateListener
{
  CommentItemView$e(CommentItemView paramCommentItemView, int paramInt1, int paramInt2, u.d paramd, a.f.a.a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(110345);
    j.p(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(110345);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    int i = (int)((this.sLH - this.sLI) * (1.0F - f));
    this.sLG.setTranslationY(i);
    if (f < this.sLJ)
    {
      this.sLG.setScaleX(f / this.sLJ);
      this.sLG.setScaleY(f / this.sLJ);
      this.sLG.setAlpha(f / this.sLJ * 0.5F + 0.5F);
    }
    do
    {
      if (i < 100) {
        this.sLG.setAlpha(i / 100.0F);
      }
      if (this.sLG.getAlpha() >= 0.05F) {
        break;
      }
      paramValueAnimator = this.sLG.getNormalAnimator();
      if (paramValueAnimator != null) {
        paramValueAnimator.removeAllUpdateListeners();
      }
      paramValueAnimator = this.sLL;
      if (paramValueAnimator == null) {
        break;
      }
      paramValueAnimator.invoke();
      AppMethodBeat.o(110345);
      return;
      this.sLG.setScaleX(1.0F);
      this.sLG.setScaleY(1.0F);
      this.sLG.setAlpha(1.0F);
      paramValueAnimator = (a.f.a.a)this.sLK.BNq;
      if (paramValueAnimator != null) {
        paramValueAnimator.invoke();
      }
      this.sLK.BNq = null;
    } while (CommentItemView.a(this.sLG));
    CommentItemView.b(this.sLG);
    paramValueAnimator = this.sLG;
    long l = 0L;
    Object localObject;
    if (!paramValueAnimator.sLw.sxz)
    {
      localObject = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CommentItemView.d(paramValueAnimator));
      j.p(localObject, "sizeAnimator");
      ((ValueAnimator)localObject).setDuration(300L);
      ((ValueAnimator)localObject).start();
      l = 300L;
    }
    for (;;)
    {
      localObject = paramValueAnimator.owk;
      if (localObject == null) {
        j.ays("contentLayout");
      }
      ((ViewGroup)localObject).setVisibility(0);
      localObject = paramValueAnimator.owk;
      if (localObject == null) {
        j.ays("contentLayout");
      }
      ((ViewGroup)localObject).setAlpha(0.0F);
      paramValueAnimator = paramValueAnimator.owk;
      if (paramValueAnimator == null) {
        j.ays("contentLayout");
      }
      paramValueAnimator = ObjectAnimator.ofFloat(paramValueAnimator, "alpha", new float[] { 0.0F, 1.0F });
      j.p(paramValueAnimator, "contentLayoutAnim");
      paramValueAnimator.setStartDelay(l);
      paramValueAnimator.setDuration(100L);
      paramValueAnimator.start();
      break;
      localObject = paramValueAnimator.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = paramValueAnimator.sLA;
      ((ViewGroup.LayoutParams)localObject).height = paramValueAnimator.sLz;
      paramValueAnimator.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(110345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentItemView.e
 * JD-Core Version:    0.7.0.1
 */