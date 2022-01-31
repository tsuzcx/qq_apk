package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class b$10
  implements c.a
{
  b$10(b paramb) {}
  
  public final void jp(boolean paramBoolean)
  {
    AppMethodBeat.i(55156);
    if (paramBoolean)
    {
      ab.e("MicroMsg.MMSightVideoEditor", "Not Supported init SegmentSeekBar failed.");
      al.d(new b.10.1(this));
      AppMethodBeat.o(55156);
      return;
    }
    if (b.w(this.oOV) != null)
    {
      b.c(this.oOV, b.w(this.oOV).getDurationMs());
      ab.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared success %d", new Object[] { Integer.valueOf(b.d(this.oOV)) });
      try
      {
        if (b.f(this.oOV) != null)
        {
          b.a(this.oOV, Math.round(b.d(this.oOV) * b.w(this.oOV).bRy()));
          b.b(this.oOV, Math.round(b.d(this.oOV) * b.w(this.oOV).bRz()));
          if (b.c(this.oOV) <= 0)
          {
            if (b.d(this.oOV) > b.l(this.oOV).duration * 1000 + 500) {
              break label271;
            }
            b.b(this.oOV, b.d(this.oOV));
          }
        }
        for (;;)
        {
          ab.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared, start: %s, end: %s, duration: %s", new Object[] { Integer.valueOf(b.s(this.oOV)), Integer.valueOf(b.c(this.oOV)), Integer.valueOf(b.d(this.oOV)) });
          b.x(this.oOV);
          AppMethodBeat.o(55156);
          return;
          label271:
          b.b(this.oOV, b.l(this.oOV).duration * 1000);
        }
        AppMethodBeat.o(55156);
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.10
 * JD-Core Version:    0.7.0.1
 */