package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.b;

final class SnsAdNativeLandingPagesUI$3
  implements Runnable
{
  SnsAdNativeLandingPagesUI$3(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(154482);
    ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, assistActivity");
    b.a(this.rMW, true, SnsAdNativeLandingPagesUI.b(this.rMW));
    AppMethodBeat.o(154482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.3
 * JD-Core Version:    0.7.0.1
 */