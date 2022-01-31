package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ai;

final class SnsAdNativeLandingTestUI$5
  implements f.a
{
  SnsAdNativeLandingTestUI$5(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    ai.d(new SnsAdNativeLandingTestUI.5.1(this, paramInt1, paramInt2));
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2)
  {
    SnsAdNativeLandingTestUI.c(this.oVg, paramInt1);
    SnsAdNativeLandingTestUI.d(this.oVg, paramInt2);
  }
  
  public final void kA()
  {
    if (this.oVg.oVf.getIsPlay()) {
      SnsAdNativeLandingTestUI.c(this.oVg);
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    SnsAdNativeLandingTestUI.a(this.oVg).stop();
  }
  
  public final void ug() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.5
 * JD-Core Version:    0.7.0.1
 */