package io.flutter.embedding.android;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DrawableSplashScreen$1
  implements Animator.AnimatorListener
{
  DrawableSplashScreen$1(DrawableSplashScreen paramDrawableSplashScreen, Runnable paramRunnable) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(10027);
    this.IXh.run();
    AppMethodBeat.o(10027);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(10026);
    this.IXh.run();
    AppMethodBeat.o(10026);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.embedding.android.DrawableSplashScreen.1
 * JD-Core Version:    0.7.0.1
 */