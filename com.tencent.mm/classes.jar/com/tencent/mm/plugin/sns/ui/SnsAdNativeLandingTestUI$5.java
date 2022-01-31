package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.al;

final class SnsAdNativeLandingTestUI$5
  implements e.a
{
  SnsAdNativeLandingTestUI$5(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final void Es() {}
  
  public final int dP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38709);
    al.d(new SnsAdNativeLandingTestUI.5.1(this, paramInt1, paramInt2));
    AppMethodBeat.o(38709);
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38710);
    SnsAdNativeLandingTestUI.c(this.rNi, paramInt1);
    SnsAdNativeLandingTestUI.d(this.rNi, paramInt2);
    AppMethodBeat.o(38710);
  }
  
  public final void mG()
  {
    AppMethodBeat.i(38707);
    if (this.rNi.rNh.getIsPlay()) {
      SnsAdNativeLandingTestUI.c(this.rNi);
    }
    AppMethodBeat.o(38707);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38708);
    SnsAdNativeLandingTestUI.a(this.rNi).stop();
    AppMethodBeat.o(38708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.5
 * JD-Core Version:    0.7.0.1
 */