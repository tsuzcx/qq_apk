package com.tencent.mm.plugin.setting.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class SwitchAccountGridView$4
  implements ValueAnimator.AnimatorUpdateListener
{
  public SwitchAccountGridView$4(SwitchAccountGridView paramSwitchAccountGridView, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = 0;
    AppMethodBeat.i(127705);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ab.i("MicroMsg.SwitchAccountGridView", "value %f", new Object[] { Float.valueOf(f) });
    while (i < this.qMy)
    {
      if (!((String)SwitchAccountGridView.e(this.qMx).get(i)).equals(SwitchAccountGridView.d(this.qMx))) {
        ((View)SwitchAccountGridView.f(this.qMx).get(i)).setAlpha(1.0F - f);
      }
      i += 1;
    }
    if (this.qMy < this.qMx.getChildCount()) {
      ((View)SwitchAccountGridView.f(this.qMx).get(this.qMy)).setTranslationX(((View)SwitchAccountGridView.f(this.qMx).get(this.qMy)).getWidth() * f);
    }
    AppMethodBeat.o(127705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.4
 * JD-Core Version:    0.7.0.1
 */