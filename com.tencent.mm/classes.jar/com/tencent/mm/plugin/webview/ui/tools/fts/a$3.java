package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  implements ValueAnimator.AnimatorUpdateListener
{
  a$3(a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(8563);
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = this.vlQ.vlI[1][1];
    float f3 = this.vlQ.vlI[1][0];
    float f4 = this.vlQ.vlI[1][0];
    float f5 = this.vlQ.vlI[0][1];
    float f6 = this.vlQ.vlI[0][0];
    float f7 = this.vlQ.vlI[0][0];
    this.vlQ.vlz.setX((f2 - f3) * f1 + f4);
    this.vlQ.vlz.setY((f5 - f6) * f1 + f7);
    this.vlQ.vlz.setPadding((int)((this.vlQ.vly - this.vlQ.vlx) * f1 + this.vlQ.vlx), 0, 0, 0);
    ab.v("MicroMsg.WebSearch.SosAnimatorBaseController", "searchBarView.paddingLeft %d", new Object[] { Integer.valueOf(this.vlQ.vlz.getPaddingLeft()) });
    paramValueAnimator = (RelativeLayout.LayoutParams)this.vlQ.vlz.getLayoutParams();
    int i = (int)((1.0F - f1) * this.vlQ.vlv);
    paramValueAnimator.leftMargin = i;
    paramValueAnimator.rightMargin = i;
    int j = (int)this.vlQ.vlI[2][0];
    paramValueAnimator.width = ((this.vlQ.vlv - i) * 2 + j);
    this.vlQ.vlz.setLayoutParams(paramValueAnimator);
    AppMethodBeat.o(8563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a.3
 * JD-Core Version:    0.7.0.1
 */