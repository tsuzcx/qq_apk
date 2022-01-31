package com.tencent.mm.plugin.story.image2video;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class f$b
  implements Runnable
{
  f$b(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(155288);
    ab.i(f.a(this.stk), "decode end after " + f.Vd() + ", isFinishEncode:" + f.r(this.stk));
    if (!f.r(this.stk))
    {
      c localc = c.eZC;
      c.WH();
      f.s(this.stk);
    }
    AppMethodBeat.o(155288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.f.b
 * JD-Core Version:    0.7.0.1
 */