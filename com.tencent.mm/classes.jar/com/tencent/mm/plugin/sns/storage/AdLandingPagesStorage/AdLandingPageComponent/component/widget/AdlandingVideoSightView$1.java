package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e.a;

final class AdlandingVideoSightView$1
  implements b.e
{
  AdlandingVideoSightView$1(AdlandingVideoSightView paramAdlandingVideoSightView) {}
  
  public final void Eh(int paramInt)
  {
    AppMethodBeat.i(37456);
    if (-1 == paramInt)
    {
      if (this.ryJ.lxA != null)
      {
        this.ryJ.lxA.onError(0, 0);
        AppMethodBeat.o(37456);
      }
    }
    else if ((paramInt == 0) && (this.ryJ.lxA != null)) {
      this.ryJ.lxA.Es();
    }
    AppMethodBeat.o(37456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingVideoSightView.1
 * JD-Core Version:    0.7.0.1
 */