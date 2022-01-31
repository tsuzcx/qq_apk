package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;

final class SnsAdNativeLandingTestUI$6
  implements View.OnClickListener
{
  SnsAdNativeLandingTestUI$6(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38711);
    if ((!"".equals(SnsAdNativeLandingTestUI.a(this.rNi).getVideoPath())) && (SnsAdNativeLandingTestUI.a(this.rNi).getVideoPath() != null))
    {
      if (this.rNi.rNh.getVisibility() == 0)
      {
        this.rNi.rNh.setVisibility(4);
        AppMethodBeat.o(38711);
        return;
      }
      this.rNi.rNh.setVisibility(0);
    }
    AppMethodBeat.o(38711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.6
 * JD-Core Version:    0.7.0.1
 */