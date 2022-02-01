package com.tencent.mm.plugin.profile.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SayHiWithSnsPermissionUI3$11
  implements Animator.AnimatorListener
{
  SayHiWithSnsPermissionUI3$11(SayHiWithSnsPermissionUI3 paramSayHiWithSnsPermissionUI3) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(305541);
    if (this.val$callback != null) {
      this.val$callback.run();
    }
    AppMethodBeat.o(305541);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.11
 * JD-Core Version:    0.7.0.1
 */