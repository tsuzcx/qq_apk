package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class OnlineVideoView$16
  implements am.a
{
  OnlineVideoView$16(OnlineVideoView paramOnlineVideoView) {}
  
  public final boolean tC()
  {
    if ((OnlineVideoView.k(this.oRM) == null) || (OnlineVideoView.d(this.oRM) == null)) {
      return false;
    }
    if (((View)OnlineVideoView.d(this.oRM)).getAlpha() < 1.0F) {
      OnlineVideoView.m(this.oRM);
    }
    if (OnlineVideoView.d(this.oRM).isPlaying()) {
      OnlineVideoView.n(this.oRM);
    }
    for (;;)
    {
      try
      {
        if (bk.bl(OnlineVideoView.k(this.oRM).eFo)) {
          break label154;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        boolean bool;
        y.e("MicroMsg.OnlineVideoView", "online video timer check error : " + localException.toString());
        return false;
      }
      int i = OnlineVideoView.d(this.oRM).getCurrentPosition() / 1000;
      bool = OnlineVideoView.k(this.oRM).jr(i);
      return bool;
      while (i == 0)
      {
        return false;
        label154:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.16
 * JD-Core Version:    0.7.0.1
 */