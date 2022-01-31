package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class OnlineVideoView$10
  implements Runnable
{
  OnlineVideoView$10(OnlineVideoView paramOnlineVideoView) {}
  
  public final void run()
  {
    if (OnlineVideoView.d(this.oRM) != null)
    {
      if (!bk.bl(OnlineVideoView.d(this.oRM).getVideoPath())) {
        break label87;
      }
      y.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[] { Integer.valueOf(this.oRM.hashCode()) });
      str = aq.a(OnlineVideoView.a(this.oRM), OnlineVideoView.e(this.oRM));
      if (!bk.bl(str)) {
        this.oRM.bg(str, false);
      }
    }
    label87:
    while (OnlineVideoView.d(this.oRM).isPlaying())
    {
      String str;
      return;
    }
    OnlineVideoView.d(this.oRM).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.10
 * JD-Core Version:    0.7.0.1
 */