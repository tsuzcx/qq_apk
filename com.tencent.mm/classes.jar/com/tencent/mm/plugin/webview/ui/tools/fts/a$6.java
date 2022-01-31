package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$6
  implements ValueAnimator.AnimatorUpdateListener
{
  a$6(a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(8566);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (Math.abs(f - 1.0F) <= 0.001D)
    {
      this.vlQ.vlz.setX(this.vlQ.vlI[1][0]);
      this.vlQ.vlz.setY(this.vlQ.vlI[0][0]);
      this.vlQ.vlz.setPadding(0, 0, 0, 0);
      paramValueAnimator = (RelativeLayout.LayoutParams)this.vlQ.vlz.getLayoutParams();
      paramValueAnimator.leftMargin = this.vlQ.vlv;
      paramValueAnimator.rightMargin = this.vlQ.vlv;
      paramValueAnimator.width = ((int)this.vlQ.vlI[2][0]);
      this.vlQ.vlz.setLayoutParams(paramValueAnimator);
      this.vlQ.vlz.setAlpha(1.0F);
      AppMethodBeat.o(8566);
      return;
    }
    this.vlQ.vlz.setAlpha(1.0F - f);
    AppMethodBeat.o(8566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a.6
 * JD-Core Version:    0.7.0.1
 */