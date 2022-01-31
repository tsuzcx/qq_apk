package com.tencent.mm.plugin.sns.ui.d;

import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.a.b.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$33$1$1
  implements b.a
{
  b$33$1$1(b.33.1 param1) {}
  
  public final void onAnimationEnd()
  {
    y.i("MicroMsg.TimelineClickListener", "timeline back animation end");
    this.ppy.ppx.ppl.pow = null;
    ((SnsTimeLineUI)this.ppy.ppx.ppl.activity).jz(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.33.1.1
 * JD-Core Version:    0.7.0.1
 */