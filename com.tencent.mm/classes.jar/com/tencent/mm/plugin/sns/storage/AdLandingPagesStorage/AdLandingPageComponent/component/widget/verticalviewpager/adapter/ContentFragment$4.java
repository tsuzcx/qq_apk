package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

final class ContentFragment$4
  implements ValueAnimator.AnimatorUpdateListener
{
  ContentFragment$4(ContentFragment paramContentFragment) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(37619);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ContentFragment.a(this.rzA).rzG.setTranslationY((int)(f * -a.fromDPToPix(this.rzA.getContext(), 5)));
    AppMethodBeat.o(37619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.4
 * JD-Core Version:    0.7.0.1
 */