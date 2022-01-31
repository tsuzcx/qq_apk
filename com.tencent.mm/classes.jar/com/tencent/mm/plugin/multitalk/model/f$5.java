package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.voip.video.h;

final class f$5
  implements Runnable
{
  f$5(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(53947);
    f.n(this.oTN).stop();
    f.o(this.oTN);
    f.p(this.oTN).Mh();
    g.KC().setSpeakerphoneOn(f.q(this.oTN));
    AppMethodBeat.o(53947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f.5
 * JD-Core Version:    0.7.0.1
 */