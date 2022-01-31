package com.tencent.mm.plugin.voip.widget;

import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    y.i("MicroMsg.Voip.TalkingSmallView", "on mShowLocalView");
    if (a.a(this.qcB).qbz) {
      a.b(this.qcB).kf(false);
    }
    a.a(this.qcB).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a.2
 * JD-Core Version:    0.7.0.1
 */