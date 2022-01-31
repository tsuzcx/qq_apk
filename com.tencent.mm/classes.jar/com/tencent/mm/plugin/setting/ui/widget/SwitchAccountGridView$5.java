package com.tencent.mm.plugin.setting.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class SwitchAccountGridView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  public SwitchAccountGridView$5(SwitchAccountGridView paramSwitchAccountGridView, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(127706);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ab.i("MicroMsg.SwitchAccountGridView", "value %f", new Object[] { Float.valueOf(f) });
    int i = 0;
    while (i < this.qMy)
    {
      if (((String)SwitchAccountGridView.e(this.qMx).get(i)).equals(SwitchAccountGridView.d(this.qMx)))
      {
        ((View)SwitchAccountGridView.f(this.qMx).get(i)).setTranslationX((this.qMx.getWidth() / 2 - ((View)SwitchAccountGridView.f(this.qMx).get(i)).getWidth() * i - ((View)SwitchAccountGridView.f(this.qMx).get(i)).getWidth() / 2) * f);
        AppMethodBeat.o(127706);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(127706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.5
 * JD-Core Version:    0.7.0.1
 */