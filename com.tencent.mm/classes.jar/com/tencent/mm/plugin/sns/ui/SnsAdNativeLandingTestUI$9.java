package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.y;

final class SnsAdNativeLandingTestUI$9
  implements SnsAdNativeLandingTestUI.a.a
{
  SnsAdNativeLandingTestUI$9(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final void Oq(String paramString)
  {
    SnsAdNativeLandingTestUI.a(this.oVg).setVideoPath(paramString);
    SnsAdNativeLandingTestUI.a(this.oVg).setLoop(true);
    if (this.oVg.oVf.getIsPlay())
    {
      SnsAdNativeLandingTestUI.a(this.oVg).x(SnsAdNativeLandingTestUI.d(this.oVg));
      SnsAdNativeLandingTestUI.a(this.oVg).start();
    }
  }
  
  public final void cu(String paramString, int paramInt)
  {
    if (SnsAdNativeLandingTestUI.a(this.oVg).isPlaying()) {}
    do
    {
      return;
      SnsAdNativeLandingTestUI.a(this.oVg).setLoop(false);
      if (!paramString.equals(SnsAdNativeLandingTestUI.a(this.oVg).getVideoPath())) {
        SnsAdNativeLandingTestUI.a(this.oVg).setVideoPath(paramString);
      }
    } while (!this.oVg.oVf.getIsPlay());
    SnsAdNativeLandingTestUI.a(this.oVg).x(SnsAdNativeLandingTestUI.d(this.oVg));
    SnsAdNativeLandingTestUI.a(this.oVg).start();
  }
  
  public final void uv(String paramString)
  {
    y.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.9
 * JD-Core Version:    0.7.0.1
 */