package com.tencent.mm.plugin.story.a;

import a.f.b.j;
import a.l;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "prepare", "", "target", "Landroid/view/View;", "plugin-story_release"})
public final class b
  extends a
{
  private final String tag = "MicroMsg.SwingAnimator";
  
  protected final void ee(View paramView)
  {
    AppMethodBeat.i(108939);
    j.q(paramView, "target");
    paramView.setPivotX(paramView.getWidth() / 2.0F);
    paramView.setPivotY(paramView.getHeight());
    this.mDuration = 800L;
    AnimatorSet localAnimatorSet = this.sqG;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.playTogether(new Animator[] { (Animator)ObjectAnimator.ofFloat(paramView, "rotation", new float[] { 0.0F, 5.0F, 0.0F, -5.0F, 0.0F, 5.0F, 0.0F, -5.0F, 0.0F }) });
      AppMethodBeat.o(108939);
      return;
    }
    AppMethodBeat.o(108939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.a.b
 * JD-Core Version:    0.7.0.1
 */