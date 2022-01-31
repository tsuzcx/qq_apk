package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;

final class SnsAdNativeLandingTestUI$4
  implements View.OnClickListener
{
  SnsAdNativeLandingTestUI$4(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38705);
    if (SnsAdNativeLandingTestUI.a(this.rNi).isPlaying())
    {
      SnsAdNativeLandingTestUI.b(this.rNi);
      AppMethodBeat.o(38705);
      return;
    }
    SnsAdNativeLandingTestUI.c(this.rNi);
    AppMethodBeat.o(38705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.4
 * JD-Core Version:    0.7.0.1
 */