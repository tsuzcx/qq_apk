package com.tencent.mm.plugin.sns.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.b.b.a;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class b$33$1
  implements Runnable
{
  b$33$1(b.33 param33, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(40291);
    if ((this.skp.skd.activity instanceof SnsTimeLineUI)) {
      ((SnsTimeLineUI)this.skp.skd.activity).lF(true);
    }
    this.skp.skd.sjo.mi(this.nKE);
    this.skp.skd.sjo.a(new b.a()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(40290);
        ab.i("MicroMsg.TimelineClickListener", "timeline back animation end");
        b.33.1.this.skp.skd.sjo = null;
        ((SnsTimeLineUI)b.33.1.this.skp.skd.activity).lF(false);
        AppMethodBeat.o(40290);
      }
    });
    AppMethodBeat.o(40291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.33.1
 * JD-Core Version:    0.7.0.1
 */