package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.y;

final class OnlineVideoView$6
  implements f.e
{
  OnlineVideoView$6(OnlineVideoView paramOnlineVideoView) {}
  
  public final void bkk()
  {
    y.i("MicroMsg.OnlineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(this.oRM.hashCode()) });
    try
    {
      OnlineVideoView.m(this.oRM);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.OnlineVideoView", "texture view update. error " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.6
 * JD-Core Version:    0.7.0.1
 */