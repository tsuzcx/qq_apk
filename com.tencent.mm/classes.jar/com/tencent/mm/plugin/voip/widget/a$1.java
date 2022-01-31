package com.tencent.mm.plugin.voip.widget;

import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    y.i("MicroMsg.Voip.TalkingSmallView", "on mDismissLocalView");
    if (a.a(this.qcB).qbz)
    {
      a.b(this.qcB).kf(true);
      return;
    }
    a.a(this.qcB).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a.1
 * JD-Core Version:    0.7.0.1
 */