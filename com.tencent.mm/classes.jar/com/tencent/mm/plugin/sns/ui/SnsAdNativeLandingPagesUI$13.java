package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.ui.base.p;

final class SnsAdNativeLandingPagesUI$13
  implements AdLandingPagesProxy.e
{
  SnsAdNativeLandingPagesUI$13(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI, boolean paramBoolean) {}
  
  public final void ad(Object paramObject) {}
  
  public final void h(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(154492);
    this.rMW.lz(false);
    if (this.rMY)
    {
      if (SnsAdNativeLandingPagesUI.M(this.rMW) != null) {
        SnsAdNativeLandingPagesUI.M(this.rMW).cre();
      }
      if (SnsAdNativeLandingPagesUI.N(this.rMW) != null)
      {
        SnsAdNativeLandingPagesUI.N(this.rMW).dismiss();
        SnsAdNativeLandingPagesUI.O(this.rMW);
      }
    }
    AppMethodBeat.o(154492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.13
 * JD-Core Version:    0.7.0.1
 */