package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.b;

final class SnsAdNativeLandingPagesUI$4
  implements Runnable
{
  SnsAdNativeLandingPagesUI$4(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(154483);
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "noCutOut, assistActivity");
    b.a(this.rMW, false, SnsAdNativeLandingPagesUI.b(this.rMW));
    AppMethodBeat.o(154483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.4
 * JD-Core Version:    0.7.0.1
 */