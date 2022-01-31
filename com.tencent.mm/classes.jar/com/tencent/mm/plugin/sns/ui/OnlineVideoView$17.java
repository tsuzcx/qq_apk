package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.am.a;

final class OnlineVideoView$17
  implements am.a
{
  OnlineVideoView$17(OnlineVideoView paramOnlineVideoView) {}
  
  public final boolean tC()
  {
    if (OnlineVideoView.d(this.oRM) == null) {
      return false;
    }
    if (((View)OnlineVideoView.d(this.oRM)).getAlpha() < 1.0F) {
      OnlineVideoView.m(this.oRM);
    }
    if (OnlineVideoView.d(this.oRM).isPlaying())
    {
      OnlineVideoView.n(this.oRM);
      OnlineVideoView.d(this.oRM).getCurrentPosition();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.17
 * JD-Core Version:    0.7.0.1
 */