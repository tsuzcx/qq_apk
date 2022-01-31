package com.tencent.mm.ui.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class MMSwitchBtn$b$1
  implements Animation.AnimationListener
{
  MMSwitchBtn$b$1(MMSwitchBtn.b paramb, MMSwitchBtn paramMMSwitchBtn) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool2 = true;
    boolean bool3 = MMSwitchBtn.a(this.wkg.wke);
    if (this.wkg.direction == 1)
    {
      bool1 = true;
      if (bool3 != bool1)
      {
        paramAnimation = this.wkg.wke;
        if (this.wkg.direction != 1) {
          break label96;
        }
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      MMSwitchBtn.a(paramAnimation, bool1);
      this.wkg.wke.post(new MMSwitchBtn.b.1.1(this));
      MMSwitchBtn.c(this.wkg.wke);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSwitchBtn.b.1
 * JD-Core Version:    0.7.0.1
 */