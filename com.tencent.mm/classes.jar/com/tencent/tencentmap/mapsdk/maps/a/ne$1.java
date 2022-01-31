package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ne$1
  implements Animation.AnimationListener
{
  ne$1(ne paramne) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(149399);
    if (ne.a(this.a) != null) {
      ne.a(this.a).setVisibility(8);
    }
    AppMethodBeat.o(149399);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(149398);
    if (ne.a(this.a) != null) {
      ne.a(this.a).setVisibility(0);
    }
    AppMethodBeat.o(149398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ne.1
 * JD-Core Version:    0.7.0.1
 */