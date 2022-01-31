package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsAdNativeLandingTestUI$5$1
  implements Runnable
{
  SnsAdNativeLandingTestUI$5$1(SnsAdNativeLandingTestUI.5 param5, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(38706);
    ab.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + this.ieP + " video time " + this.qUL);
    if (this.qUL > 0)
    {
      SnsAdNativeLandingTestUI.a(this.rNl.rNi, this.qUL);
      SnsAdNativeLandingTestUI.b(this.rNl.rNi, this.qUL);
    }
    if (this.rNl.rNi.rNh.getVideoTotalTime() != this.qUL) {
      this.rNl.rNi.rNh.setVideoTotalTime(this.qUL);
    }
    this.rNl.rNi.rNh.seek(this.ieP);
    AppMethodBeat.o(38706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.5.1
 * JD-Core Version:    0.7.0.1
 */