package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.j.b;
import com.tencent.mm.sdk.platformtools.ab;

final class i$1
  implements ValueAnimator.AnimatorUpdateListener
{
  i$1(i parami) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(40074);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ab.i("MicroMsg.TurnCardAdBackAnimation", "value %f", new Object[] { Float.valueOf(f) });
    if (f != 0.0F)
    {
      this.sfE.sfD.siM.setScaleX(f);
      this.sfE.sfD.siM.setScaleY(f);
      this.sfE.sfD.siM.setAlpha(f);
    }
    AppMethodBeat.o(40074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.i.1
 * JD-Core Version:    0.7.0.1
 */