package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.al;

final class SnsAdNativeLandingPagesUI$17$1
  implements Runnable
{
  SnsAdNativeLandingPagesUI$17$1(SnsAdNativeLandingPagesUI.17 param17, Object paramObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(38648);
    SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = this.rNe.rMW;
    String str1 = SnsAdNativeLandingPagesUI.m(this.rNe.rMW);
    String str2 = SnsAdNativeLandingPagesUI.n(this.rNe.rMW);
    String str3 = (String)this.rNd;
    SnsAdNativeLandingPagesUI.o(this.rNe.rMW);
    SnsAdNativeLandingPagesUI.p(this.rNe.rMW);
    localSnsAdNativeLandingPagesUI.rLY = i.am(str1, str2, str3);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38647);
        SnsAdNativeLandingPagesUI.q(SnsAdNativeLandingPagesUI.17.1.this.rNe.rMW);
        AppMethodBeat.o(38647);
      }
    });
    AppMethodBeat.o(38648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.17.1
 * JD-Core Version:    0.7.0.1
 */