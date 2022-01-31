package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class OnlineVideoView$9
  implements Runnable
{
  OnlineVideoView$9(OnlineVideoView paramOnlineVideoView) {}
  
  public final void run()
  {
    y.w("MicroMsg.OnlineVideoView", "%d deal sns video change isOnlinePlay[%b]", new Object[] { Integer.valueOf(this.oRM.hashCode()), Boolean.valueOf(OnlineVideoView.x(this.oRM)) });
    if (OnlineVideoView.x(this.oRM))
    {
      OnlineVideoView.y(this.oRM);
      OnlineVideoView.d(this.oRM).stop();
      this.oRM.bHO();
      String str = aq.D(OnlineVideoView.e(this.oRM));
      boolean bool = e.deleteFile(str);
      if (OnlineVideoView.k(this.oRM) != null)
      {
        OnlineVideoView.k(this.oRM).bHU();
        OnlineVideoView.k(this.oRM).clear();
        OnlineVideoView.a(this.oRM, new ae(this.oRM));
      }
      y.i("MicroMsg.OnlineVideoView", "%d delete video file[%b] [%s]", new Object[] { Integer.valueOf(this.oRM.hashCode()), Boolean.valueOf(bool), str });
      OnlineVideoView.z(this.oRM);
      OnlineVideoView.A(this.oRM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.9
 * JD-Core Version:    0.7.0.1
 */