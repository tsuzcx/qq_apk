package com.tencent.mm.ui.n.b;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/magicemoji/jsapi/MEShakeBubblesAndAvatars$MEAnimationListener;", "Landroid/view/animation/Animation$AnimationListener;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h$b
  implements Animation.AnimationListener
{
  private final View view;
  
  public h$b(View paramView)
  {
    AppMethodBeat.i(249817);
    this.view = paramView;
    AppMethodBeat.o(249817);
  }
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(249821);
    if (paramAnimation != null) {
      paramAnimation.setAnimationListener(null);
    }
    this.view.clearAnimation();
    AppMethodBeat.o(249821);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.n.b.h.b
 * JD-Core Version:    0.7.0.1
 */