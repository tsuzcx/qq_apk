package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class SnsAdNativeLandingPagesUI$6
  implements Runnable
{
  SnsAdNativeLandingPagesUI$6(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void run()
  {
    if (this.oUU.mController.uNh != 1) {
      SnsAdNativeLandingPagesUI.b(this.oUU);
    }
    for (;;)
    {
      new ArrayList();
      Iterator localIterator = ((c)SnsAdNativeLandingPagesUI.a(this.oUU).getAdapter()).oJM.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        int i = this.oUU.mController.uNh;
        localb.bFM();
      }
      ad.O(this.oUU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.6
 * JD-Core Version:    0.7.0.1
 */