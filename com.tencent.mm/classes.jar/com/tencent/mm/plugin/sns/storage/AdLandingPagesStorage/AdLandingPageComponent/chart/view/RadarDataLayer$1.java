package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = RadarDataLayer.a(this.oEU).entrySet().iterator();
    while (paramValueAnimator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramValueAnimator.next();
      RadarDataLayer.b(this.oEU).put(localEntry.getKey(), Float.valueOf(((Float)localEntry.getValue()).floatValue() * f));
      this.oEU.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarDataLayer.1
 * JD-Core Version:    0.7.0.1
 */