package com.tencent.mm.plugin.story.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "prepare", "", "target", "Landroid/view/View;", "plugin-story_release"})
public final class b
  extends a
{
  private final String tag = "MicroMsg.SwingAnimator";
  
  protected final void fN(View paramView)
  {
    AppMethodBeat.i(118566);
    p.h(paramView, "target");
    paramView.setPivotX(paramView.getWidth() / 2.0F);
    paramView.setPivotY(paramView.getHeight());
    this.mDuration = 800L;
    AnimatorSet localAnimatorSet = this.Fkp;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.playTogether(new Animator[] { (Animator)ObjectAnimator.ofFloat(paramView, "rotation", new float[] { 0.0F, 5.0F, 0.0F, -5.0F, 0.0F, 5.0F, 0.0F, -5.0F, 0.0F }) });
      AppMethodBeat.o(118566);
      return;
    }
    AppMethodBeat.o(118566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.a.b
 * JD-Core Version:    0.7.0.1
 */