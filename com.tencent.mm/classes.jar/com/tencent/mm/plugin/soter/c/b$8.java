package com.tencent.mm.plugin.soter.c;

import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$8
  implements Animation.AnimationListener
{
  b$8(b paramb, CharSequence paramCharSequence) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(73879);
    this.soc.iuP.post(this.soc.sob);
    AppMethodBeat.o(73879);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(73878);
    this.soc.snV.setImageResource(2130838875);
    this.soc.iuP.setText(this.mU);
    this.soc.iuP.setTextColor(this.soc.iuP.getResources().getColor(2131690669));
    this.soc.iuP.removeCallbacks(this.soc.sob);
    AppMethodBeat.o(73878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b.8
 * JD-Core Version:    0.7.0.1
 */