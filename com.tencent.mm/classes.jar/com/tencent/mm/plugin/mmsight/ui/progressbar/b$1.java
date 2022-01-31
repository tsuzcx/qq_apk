package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements ValueAnimator.AnimatorUpdateListener
{
  b$1(b paramb) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(55341);
    this.oRv.progress = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.oRv;
    float f1 = this.oRv.progress;
    paramValueAnimator.oRs = ((int)(Math.round(MMSightProgressBar.oQS + MMSightProgressBar.lQb * 2) * (f1 / 100.0F)));
    float f2 = paramValueAnimator.oRq;
    float f3 = paramValueAnimator.oRq;
    float f4 = paramValueAnimator.oRr;
    paramValueAnimator.oRp = (f2 - f1 / 100.0F * (f3 - f4));
    paramValueAnimator.oRj = new PointF(MMSightProgressBar.lQb, 0.0F);
    paramValueAnimator.oRk = new PointF(MMSightProgressBar.lQb + paramValueAnimator.oRs / 2.0F, MMSightProgressBar.lQb - paramValueAnimator.oRp / 2.0F);
    paramValueAnimator.oRl = new PointF(MMSightProgressBar.lQb + paramValueAnimator.oRs, 0.0F);
    paramValueAnimator.oRm = new PointF(MMSightProgressBar.lQb, MMSightProgressBar.lQb * 2);
    paramValueAnimator.oRn = new PointF(MMSightProgressBar.lQb + paramValueAnimator.oRs / 2.0F, MMSightProgressBar.lQb + paramValueAnimator.oRp / 2.0F);
    paramValueAnimator.oRo = new PointF(MMSightProgressBar.lQb + paramValueAnimator.oRs, MMSightProgressBar.lQb * 2.0F);
    ab.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, currentPointDistance: %s, curveCenterDistance: %s", new Object[] { Float.valueOf(paramValueAnimator.oRs), Float.valueOf(paramValueAnimator.oRp) });
    ab.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, point1: %s, point2: %s, point3: %s, point4: %s, point5: %s, point6: %s", new Object[] { paramValueAnimator.oRj, paramValueAnimator.oRk, paramValueAnimator.oRl, paramValueAnimator.oRm, paramValueAnimator.oRn, paramValueAnimator.oRo });
    if (this.oRv.oRi != null) {
      this.oRv.oRi.bSn();
    }
    AppMethodBeat.o(55341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b.1
 * JD-Core Version:    0.7.0.1
 */