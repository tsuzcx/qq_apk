package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.am;

final class OnlineVideoView$15
  implements Runnable
{
  OnlineVideoView$15(OnlineVideoView paramOnlineVideoView) {}
  
  public final void run()
  {
    if ((OnlineVideoView.d(this.oRM) != null) && (OnlineVideoView.k(this.oRM) != null))
    {
      int i = OnlineVideoView.d(this.oRM).getCurrentPosition() / 1000;
      OnlineVideoView.k(this.oRM).jr(i);
    }
    OnlineVideoView.l(this.oRM).S(500L, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.15
 * JD-Core Version:    0.7.0.1
 */