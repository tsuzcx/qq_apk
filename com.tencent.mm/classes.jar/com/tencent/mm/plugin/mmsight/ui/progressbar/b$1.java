package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements ValueAnimator.AnimatorUpdateListener
{
  b$1(b paramb) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.mrH.progress = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.mrH;
    float f1 = this.mrH.progress;
    paramValueAnimator.mrE = ((int)(Math.round(MMSightProgressBar.mre + MMSightProgressBar.jGD * 2) * (f1 / 100.0F)));
    float f2 = paramValueAnimator.mrC;
    float f3 = paramValueAnimator.mrC;
    float f4 = paramValueAnimator.mrD;
    paramValueAnimator.mrB = (f2 - f1 / 100.0F * (f3 - f4));
    paramValueAnimator.mrv = new PointF(MMSightProgressBar.jGD, 0.0F);
    paramValueAnimator.mrw = new PointF(MMSightProgressBar.jGD + paramValueAnimator.mrE / 2.0F, MMSightProgressBar.jGD - paramValueAnimator.mrB / 2.0F);
    paramValueAnimator.mrx = new PointF(MMSightProgressBar.jGD + paramValueAnimator.mrE, 0.0F);
    paramValueAnimator.mry = new PointF(MMSightProgressBar.jGD, MMSightProgressBar.jGD * 2);
    paramValueAnimator.mrz = new PointF(MMSightProgressBar.jGD + paramValueAnimator.mrE / 2.0F, MMSightProgressBar.jGD + paramValueAnimator.mrB / 2.0F);
    paramValueAnimator.mrA = new PointF(MMSightProgressBar.jGD + paramValueAnimator.mrE, MMSightProgressBar.jGD * 2.0F);
    y.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, currentPointDistance: %s, curveCenterDistance: %s", new Object[] { Float.valueOf(paramValueAnimator.mrE), Float.valueOf(paramValueAnimator.mrB) });
    y.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, point1: %s, point2: %s, point3: %s, point4: %s, point5: %s, point6: %s", new Object[] { paramValueAnimator.mrv, paramValueAnimator.mrw, paramValueAnimator.mrx, paramValueAnimator.mry, paramValueAnimator.mrz, paramValueAnimator.mrA });
    if (this.mrH.mru != null) {
      this.mrH.mru.bkm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.b.1
 * JD-Core Version:    0.7.0.1
 */