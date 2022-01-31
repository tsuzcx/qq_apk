package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;

final class b$4$1
  implements Runnable
{
  b$4$1(b.4 param4) {}
  
  public final void run()
  {
    if (b.j(this.oJD.oJz))
    {
      this.oJD.oJz.bFP();
      return;
    }
    y.d("ContentFragment", "onAnimationEnd show nextBtn");
    b.a(this.oJD.oJz).oJJ.setAlpha(1.0F);
    b.a(this.oJD.oJz, b.a(this.oJD.oJz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.4.1
 * JD-Core Version:    0.7.0.1
 */