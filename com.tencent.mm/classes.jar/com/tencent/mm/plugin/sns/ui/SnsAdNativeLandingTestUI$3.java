package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsAdNativeLandingTestUI$3
  implements b
{
  SnsAdNativeLandingTestUI$3(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final void aFf() {}
  
  public final void on(int paramInt)
  {
    AppMethodBeat.i(38704);
    ab.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time ".concat(String.valueOf(paramInt)));
    SnsAdNativeLandingTestUI.a(this.rNi, paramInt);
    SnsAdNativeLandingTestUI.a(this.rNi).A(paramInt);
    AppMethodBeat.o(38704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.3
 * JD-Core Version:    0.7.0.1
 */