package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import java.math.BigInteger;

final class o$a$1$1
  implements Animation.AnimationListener
{
  o$a$1$1(o.a.1 param1) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    long l = new BigInteger((String)this.oGK.oGI.getTag()).longValue();
    if (l >= 3L)
    {
      paramAnimation = new AlphaAnimation(0.8F, 0.0F);
      paramAnimation.setDuration(this.oGK.oGJ.oGF);
      paramAnimation.setInterpolator(new DecelerateInterpolator(1.2F));
      paramAnimation.setAnimationListener(new o.a.1.1.1(this));
      this.oGK.oGI.startAnimation(paramAnimation);
      return;
    }
    this.oGK.oGI.setTag(String.valueOf(l + 1L));
    o.a.a(this.oGK.oGJ, this.oGK.oGI);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.a.1.1
 * JD-Core Version:    0.7.0.1
 */