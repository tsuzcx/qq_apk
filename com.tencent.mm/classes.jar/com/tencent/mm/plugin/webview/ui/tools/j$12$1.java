package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$12$1
  implements Animation.AnimationListener
{
  j$12$1(j.12 param12) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(7651);
    this.vcS.vcO.ddt().vei.setVisibility(8);
    AppMethodBeat.o(7651);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j.12.1
 * JD-Core Version:    0.7.0.1
 */