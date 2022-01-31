package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.sdk.platformtools.y;

final class SnsAdNativeLandingTestUI$5$1
  implements Runnable
{
  SnsAdNativeLandingTestUI$5$1(SnsAdNativeLandingTestUI.5 param5, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    y.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + this.gFM + " video time " + this.ogw);
    if (this.ogw > 0)
    {
      SnsAdNativeLandingTestUI.a(this.oVj.oVg, this.ogw);
      SnsAdNativeLandingTestUI.b(this.oVj.oVg, this.ogw);
    }
    if (this.oVj.oVg.oVf.getVideoTotalTime() != this.ogw) {
      this.oVj.oVg.oVf.setVideoTotalTime(this.ogw);
    }
    this.oVj.oVg.oVf.seek(this.gFM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.5.1
 * JD-Core Version:    0.7.0.1
 */