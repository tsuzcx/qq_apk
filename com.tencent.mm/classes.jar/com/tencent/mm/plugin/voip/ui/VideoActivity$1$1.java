package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class VideoActivity$1$1
  implements Runnable
{
  VideoActivity$1$1(VideoActivity.1 param1) {}
  
  public final void run()
  {
    if ((VideoActivity.a(this.pWN.pWM) != null) && (VideoActivity.a(this.pWN.pWM).get() != null)) {
      y.i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent ret[%b, %b, %b]", new Object[] { Boolean.valueOf(((c)VideoActivity.a(this.pWN.pWM).get()).bQA()), Boolean.valueOf(((c)VideoActivity.a(this.pWN.pWM).get()).bQz()), Boolean.valueOf(((c)VideoActivity.a(this.pWN.pWM).get()).bQs()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity.1.1
 * JD-Core Version:    0.7.0.1
 */