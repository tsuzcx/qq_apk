package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.j.b;
import com.tencent.mm.sdk.platformtools.ab;

final class j$1
  implements ValueAnimator.AnimatorUpdateListener
{
  j$1(j paramj) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40081);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ab.i("MicroMsg.TurnCardAdClickAnimation", "value %f", new Object[] { Float.valueOf(f) });
    if (f != 1.0F)
    {
      this.sfF.sfD.siM.setScaleX(f);
      this.sfF.sfD.siM.setScaleY(f);
      this.sfF.sfD.siM.setAlpha(f);
    }
    AppMethodBeat.o(40081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.j.1
 * JD-Core Version:    0.7.0.1
 */