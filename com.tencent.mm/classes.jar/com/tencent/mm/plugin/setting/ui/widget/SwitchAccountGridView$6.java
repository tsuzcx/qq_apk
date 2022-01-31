package com.tencent.mm.plugin.setting.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class SwitchAccountGridView$6
  extends AnimatorListenerAdapter
{
  public SwitchAccountGridView$6(SwitchAccountGridView paramSwitchAccountGridView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(127707);
    ab.i("MicroMsg.SwitchAccountGridView", "avatar animator end");
    SwitchAccountGridView.g(this.qMx);
    if (SwitchAccountGridView.h(this.qMx) != null) {
      SwitchAccountGridView.h(this.qMx).ckB();
    }
    AppMethodBeat.o(127707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.6
 * JD-Core Version:    0.7.0.1
 */