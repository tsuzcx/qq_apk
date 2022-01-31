package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ah;

final class o$a$2
  implements Animation.AnimationListener
{
  o$a$2(o.a parama, ImageView paramImageView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    new ah().postDelayed(new o.a.2.1(this), 200L);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.a.2
 * JD-Core Version:    0.7.0.1
 */