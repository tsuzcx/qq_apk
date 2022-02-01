package com.tencent.mm.ui.anim.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/conv/ConvItemUnselectedAnim;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "run", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements Runnable
{
  final View view;
  
  public a(View paramView)
  {
    AppMethodBeat.i(251188);
    this.view = paramView;
    AppMethodBeat.o(251188);
  }
  
  private static final void a(Drawable paramDrawable, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(251196);
    s.u(paramDrawable, "$pressDrawable");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramDrawable = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(251196);
      throw paramDrawable;
    }
    paramDrawable.setAlpha(255 - ((Integer)paramValueAnimator).intValue());
    AppMethodBeat.o(251196);
  }
  
  public final void run()
  {
    AppMethodBeat.i(251204);
    this.view.setSelected(false);
    Drawable localDrawable = this.view.getContext().getDrawable(a.d.list_devider_color);
    s.checkNotNull(localDrawable);
    s.s(localDrawable, "view.context.getDrawable…lor.list_devider_color)!!");
    this.view.setBackground(localDrawable);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 240 });
    localValueAnimator.addUpdateListener(new a..ExternalSyntheticLambda0(localDrawable));
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener((Animator.AnimatorListener)new a(localDrawable, this));
    localValueAnimator.start();
    AppMethodBeat.o(251204);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/anim/conv/ConvItemUnselectedAnim$run$animator$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Animator.AnimatorListener
  {
    a(Drawable paramDrawable, a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(251201);
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(251201);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(251199);
      this.adMG.setAlpha(255);
      jdField_this.view.setBackgroundResource(a.f.comm_list_item_selector);
      AppMethodBeat.o(251199);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.anim.c.a
 * JD-Core Version:    0.7.0.1
 */