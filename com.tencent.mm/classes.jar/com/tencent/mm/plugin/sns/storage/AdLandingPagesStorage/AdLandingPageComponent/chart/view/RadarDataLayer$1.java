package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class RadarDataLayer$1
  implements ValueAnimator.AnimatorUpdateListener
{
  RadarDataLayer$1(RadarDataLayer paramRadarDataLayer) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(36965);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = RadarDataLayer.a(this.ruv).entrySet().iterator();
    while (paramValueAnimator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramValueAnimator.next();
      RadarDataLayer.b(this.ruv).put(localEntry.getKey(), Float.valueOf(((Float)localEntry.getValue()).floatValue() * f));
      this.ruv.invalidate();
    }
    AppMethodBeat.o(36965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarDataLayer.1
 * JD-Core Version:    0.7.0.1
 */