package com.tencent.mm.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NewChattingTabUI$6$1
  implements Animation.AnimationListener
{
  NewChattingTabUI$6$1(NewChattingTabUI.6 param6) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(29800);
    NewChattingTabUI.v(this.zeo.zei);
    AppMethodBeat.o(29800);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(29799);
    NewChattingTabUI.u(this.zeo.zei);
    this.zeo.zei.H(false, 0);
    AppMethodBeat.o(29799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI.6.1
 * JD-Core Version:    0.7.0.1
 */