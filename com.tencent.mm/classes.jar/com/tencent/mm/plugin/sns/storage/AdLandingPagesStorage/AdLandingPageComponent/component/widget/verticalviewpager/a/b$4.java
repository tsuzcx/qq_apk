package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class b$4
  implements Animation.AnimationListener
{
  b$4(b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    new ah().postDelayed(new b.4.1(this), 200L);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    if (b.j(this.oJz))
    {
      paramAnimation.cancel();
      this.oJz.bFP();
      return;
    }
    y.d("ContentFragment", "onAnimationStart show nextBtn");
    b.a(this.oJz).oJK = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.4
 * JD-Core Version:    0.7.0.1
 */