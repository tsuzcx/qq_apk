package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;

final class SnsAdNativeLandingTestUI$4
  implements View.OnClickListener
{
  SnsAdNativeLandingTestUI$4(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final void onClick(View paramView)
  {
    if (SnsAdNativeLandingTestUI.a(this.oVg).isPlaying())
    {
      SnsAdNativeLandingTestUI.b(this.oVg);
      return;
    }
    SnsAdNativeLandingTestUI.c(this.oVg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.4
 * JD-Core Version:    0.7.0.1
 */