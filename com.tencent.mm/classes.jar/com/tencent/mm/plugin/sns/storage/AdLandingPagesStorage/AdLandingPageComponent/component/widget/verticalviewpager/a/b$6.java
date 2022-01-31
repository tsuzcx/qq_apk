package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;

final class b$6
  implements Animation.AnimationListener
{
  b$6(b paramb, b.b paramb1) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.oJF.oJJ.getVisibility() != 0)
    {
      y.d("ContentFragment", "nextBtn not visible");
      return;
    }
    paramAnimation = new AnimationSet(true);
    Object localObject = new TranslateAnimation(0.0F, 0.0F, -10.0F, 0.0F);
    ((TranslateAnimation)localObject).setDuration(b.k(this.oJz));
    ((TranslateAnimation)localObject).setInterpolator(new DecelerateInterpolator(1.2F));
    ((TranslateAnimation)localObject).setStartTime(b.k(this.oJz));
    paramAnimation.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.3F, 0.8F);
    ((AlphaAnimation)localObject).setDuration(b.k(this.oJz));
    ((AlphaAnimation)localObject).setInterpolator(new DecelerateInterpolator(1.2F));
    ((AlphaAnimation)localObject).setStartTime(b.k(this.oJz));
    paramAnimation.addAnimation((Animation)localObject);
    paramAnimation.setAnimationListener(new b.6.1(this));
    this.oJF.oJJ.startAnimation(paramAnimation);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.6
 * JD-Core Version:    0.7.0.1
 */