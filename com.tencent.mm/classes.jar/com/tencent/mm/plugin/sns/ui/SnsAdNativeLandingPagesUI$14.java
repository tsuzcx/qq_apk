package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i.a;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsAdNativeLandingPagesUI$14
  implements i.a
{
  SnsAdNativeLandingPagesUI$14(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI, View paramView) {}
  
  private void cuL()
  {
    AppMethodBeat.i(154495);
    if ((this.rMZ != null) && (this.rMZ.getParent() != null)) {
      ((ViewGroup)this.rMZ.getParent()).removeView(this.rMZ);
    }
    SnsAdNativeLandingPagesUI.P(this.rMW);
    AppMethodBeat.o(154495);
  }
  
  public final void crf()
  {
    AppMethodBeat.i(154493);
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
    cuL();
    AppMethodBeat.o(154493);
  }
  
  public final void crg()
  {
    AppMethodBeat.i(154494);
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
    cuL();
    AppMethodBeat.o(154494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.14
 * JD-Core Version:    0.7.0.1
 */