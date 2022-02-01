package com.tencent.mm.view;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AnimationLayout$2
  implements ViewTreeObserver.OnPreDrawListener
{
  AnimationLayout$2(AnimationLayout paramAnimationLayout, Runnable paramRunnable) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(164236);
    this.Rip.getViewTreeObserver().removeOnPreDrawListener(this);
    this.val$runnable.run();
    AppMethodBeat.o(164236);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.AnimationLayout.2
 * JD-Core Version:    0.7.0.1
 */