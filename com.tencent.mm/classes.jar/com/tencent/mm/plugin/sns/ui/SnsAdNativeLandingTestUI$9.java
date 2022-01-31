package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsAdNativeLandingTestUI$9
  implements SnsAdNativeLandingTestUI.a.a
{
  SnsAdNativeLandingTestUI$9(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final void CF(String paramString)
  {
    AppMethodBeat.i(38715);
    ab.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", paramString);
    AppMethodBeat.o(38715);
  }
  
  public final void dq(String paramString, int paramInt)
  {
    AppMethodBeat.i(38714);
    if (SnsAdNativeLandingTestUI.a(this.rNi).isPlaying())
    {
      AppMethodBeat.o(38714);
      return;
    }
    SnsAdNativeLandingTestUI.a(this.rNi).setLoop(false);
    if (!paramString.equals(SnsAdNativeLandingTestUI.a(this.rNi).getVideoPath())) {
      SnsAdNativeLandingTestUI.a(this.rNi).setVideoPath(paramString);
    }
    if (this.rNi.rNh.getIsPlay())
    {
      SnsAdNativeLandingTestUI.a(this.rNi).A(SnsAdNativeLandingTestUI.d(this.rNi));
      SnsAdNativeLandingTestUI.a(this.rNi).start();
    }
    AppMethodBeat.o(38714);
  }
  
  public final void mP(String paramString)
  {
    AppMethodBeat.i(38716);
    SnsAdNativeLandingTestUI.a(this.rNi).setVideoPath(paramString);
    SnsAdNativeLandingTestUI.a(this.rNi).setLoop(true);
    if (this.rNi.rNh.getIsPlay())
    {
      SnsAdNativeLandingTestUI.a(this.rNi).A(SnsAdNativeLandingTestUI.d(this.rNi));
      SnsAdNativeLandingTestUI.a(this.rNi).start();
    }
    AppMethodBeat.o(38716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.9
 * JD-Core Version:    0.7.0.1
 */