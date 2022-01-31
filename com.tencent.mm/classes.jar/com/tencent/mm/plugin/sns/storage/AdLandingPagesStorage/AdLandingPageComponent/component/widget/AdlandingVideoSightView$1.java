package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.pluginsdk.ui.tools.f.a;

final class AdlandingVideoSightView$1
  implements a.e
{
  AdlandingVideoSightView$1(AdlandingVideoSightView paramAdlandingVideoSightView) {}
  
  public final void yi(int paramInt)
  {
    if (-1 == paramInt) {
      if (this.oIL.joM != null) {
        this.oIL.joM.onError(0, 0);
      }
    }
    while ((paramInt != 0) || (this.oIL.joM == null)) {
      return;
    }
    this.oIL.joM.ug();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingVideoSightView.1
 * JD-Core Version:    0.7.0.1
 */