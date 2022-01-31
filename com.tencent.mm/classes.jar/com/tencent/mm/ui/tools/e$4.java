package com.tencent.mm.ui.tools;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.y;

final class e$4
  implements Animation.AnimationListener
{
  e$4(e parame, e.b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    y.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation end!");
    if (this.wcO != null) {
      this.wcO.onAnimationEnd();
    }
    this.wcP.wcN = this.wcP.wcJ;
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    y.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation start!");
    if (this.wcO != null) {
      this.wcO.onAnimationStart();
    }
    this.wcP.wcN = this.wcP.wcM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e.4
 * JD-Core Version:    0.7.0.1
 */