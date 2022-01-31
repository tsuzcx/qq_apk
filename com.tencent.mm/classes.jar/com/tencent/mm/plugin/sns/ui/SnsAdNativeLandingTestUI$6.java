package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;

final class SnsAdNativeLandingTestUI$6
  implements View.OnClickListener
{
  SnsAdNativeLandingTestUI$6(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final void onClick(View paramView)
  {
    if ((!"".equals(SnsAdNativeLandingTestUI.a(this.oVg).getVideoPath())) && (SnsAdNativeLandingTestUI.a(this.oVg).getVideoPath() != null))
    {
      if (this.oVg.oVf.getVisibility() == 0) {
        this.oVg.oVf.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.oVg.oVf.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.6
 * JD-Core Version:    0.7.0.1
 */