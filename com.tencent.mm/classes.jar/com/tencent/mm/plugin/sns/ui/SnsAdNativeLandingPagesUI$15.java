package com.tencent.mm.plugin.sns.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.b;

final class SnsAdNativeLandingPagesUI$15
  implements ContentFragment.a
{
  SnsAdNativeLandingPagesUI$15(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void n(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(38643);
    if (paramContentFragment.rzs != null) {}
    for (paramContentFragment = paramContentFragment.rzs.iQe;; paramContentFragment = null)
    {
      if (paramContentFragment != null) {
        paramContentFragment.getViewTreeObserver().addOnPreDrawListener(new SnsAdNativeLandingPagesUI.15.1(this, paramContentFragment));
      }
      AppMethodBeat.o(38643);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.15
 * JD-Core Version:    0.7.0.1
 */