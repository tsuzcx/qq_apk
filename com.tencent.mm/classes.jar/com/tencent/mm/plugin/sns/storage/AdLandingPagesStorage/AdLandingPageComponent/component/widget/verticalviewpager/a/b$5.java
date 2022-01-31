package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$5
  implements f.a
{
  b$5(b paramb, AlphaAnimation paramAlphaAnimation) {}
  
  public final void Op(String paramString)
  {
    y.d("ContentFragment", "onDownloaded show nextBtn");
    b.a(this.oJz, paramString, b.a(this.oJz).oJJ);
    b.a(this.oJz).oJJ.setVisibility(0);
    b.a(this.oJz).oJJ.startAnimation(this.oJE);
  }
  
  public final void bCF()
  {
    y.d("ContentFragment", "onDownloadError show nextBtn");
    b.a(this.oJz).oJJ.setVisibility(0);
    b.a(this.oJz).oJJ.startAnimation(this.oJE);
  }
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.5
 * JD-Core Version:    0.7.0.1
 */