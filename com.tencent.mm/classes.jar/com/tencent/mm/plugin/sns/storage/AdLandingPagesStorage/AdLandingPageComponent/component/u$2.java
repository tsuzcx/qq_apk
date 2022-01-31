package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.widget.HorizontalScrollView;
import android.widget.ImageView;

final class u$2
  implements Runnable
{
  u$2(u paramu) {}
  
  public final void run()
  {
    int i = this.oHE.bNu.getMeasuredWidth();
    if (i > this.oHE.gHR)
    {
      this.oHE.oHw = ((i - this.oHE.gHR) / 2);
      this.oHE.oHz.scrollBy(this.oHE.oHw, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u.2
 * JD-Core Version:    0.7.0.1
 */