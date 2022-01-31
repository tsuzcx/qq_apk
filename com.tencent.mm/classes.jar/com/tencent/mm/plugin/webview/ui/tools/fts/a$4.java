package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$4
  implements ValueAnimator.AnimatorUpdateListener
{
  a$4(a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(8564);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.vlQ.vlz.setAlpha(f);
    this.vlQ.vlz.setX(this.vlQ.vlI[1][1]);
    this.vlQ.vlz.setY(this.vlQ.vlI[0][1]);
    this.vlQ.vlz.setPadding(this.vlQ.vly, 0, 0, 0);
    paramValueAnimator = (RelativeLayout.LayoutParams)this.vlQ.vlz.getLayoutParams();
    if (paramValueAnimator.leftMargin != 0)
    {
      paramValueAnimator.leftMargin = 0;
      paramValueAnimator.rightMargin = 0;
      paramValueAnimator.width = ((int)this.vlQ.vlI[2][0] + this.vlQ.vlv * 2);
      this.vlQ.vlz.setLayoutParams(paramValueAnimator);
    }
    AppMethodBeat.o(8564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a.4
 * JD-Core Version:    0.7.0.1
 */