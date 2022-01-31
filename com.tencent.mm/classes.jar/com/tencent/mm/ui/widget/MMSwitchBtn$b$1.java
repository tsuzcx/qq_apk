package com.tencent.mm.ui.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMSwitchBtn$b$1
  implements Animation.AnimationListener
{
  MMSwitchBtn$b$1(MMSwitchBtn.b paramb, MMSwitchBtn paramMMSwitchBtn) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool2 = true;
    AppMethodBeat.i(112575);
    boolean bool3 = MMSwitchBtn.a(this.ADO.ADM);
    if (this.ADO.direction == 1)
    {
      bool1 = true;
      if (bool3 != bool1)
      {
        paramAnimation = this.ADO.ADM;
        if (this.ADO.direction != 1) {
          break label106;
        }
      }
    }
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      MMSwitchBtn.a(paramAnimation, bool1);
      this.ADO.ADM.post(new MMSwitchBtn.b.1.1(this));
      MMSwitchBtn.c(this.ADO.ADM);
      AppMethodBeat.o(112575);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSwitchBtn.b.1
 * JD-Core Version:    0.7.0.1
 */