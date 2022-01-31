package com.tencent.mm.plugin.sns.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.b;
import com.tencent.mm.sdk.platformtools.y;

final class SnsAdNativeLandingPagesUI$11
  implements b.a
{
  SnsAdNativeLandingPagesUI$11(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void onResume()
  {
    y.i("MicroMsg.SnsAdNativeLandingPagesUI", "on Resume");
  }
  
  public final void p(b paramb)
  {
    if (paramb.oJw != null) {}
    for (paramb = paramb.oJw.heQ;; paramb = null)
    {
      if (paramb != null) {
        paramb.getViewTreeObserver().addOnPreDrawListener(new SnsAdNativeLandingPagesUI.11.1(this, paramb));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.11
 * JD-Core Version:    0.7.0.1
 */