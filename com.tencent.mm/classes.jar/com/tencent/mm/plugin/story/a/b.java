package com.tencent.mm.plugin.story.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "prepare", "", "target", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  private final String tag = "MicroMsg.SwingAnimator";
  
  protected final void ka(View paramView)
  {
    AppMethodBeat.i(118566);
    s.u(paramView, "target");
    paramView.setPivotX(paramView.getWidth() / 2.0F);
    paramView.setPivotY(paramView.getHeight());
    this.mDuration = 800L;
    AnimatorSet localAnimatorSet = this.Sid;
    if (localAnimatorSet != null) {
      localAnimatorSet.playTogether(new Animator[] { (Animator)ObjectAnimator.ofFloat(paramView, "rotation", new float[] { 0.0F, 5.0F, 0.0F, -5.0F, 0.0F, 5.0F, 0.0F, -5.0F, 0.0F }) });
    }
    AppMethodBeat.o(118566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.a.b
 * JD-Core Version:    0.7.0.1
 */