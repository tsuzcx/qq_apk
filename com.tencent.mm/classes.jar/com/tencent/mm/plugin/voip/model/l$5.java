package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$5
  implements Runnable
{
  l$5(l paraml, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(177019);
    if (this.zjx.zja != null) {
      this.zjx.zja.hP(this.val$width, this.val$height);
    }
    AppMethodBeat.o(177019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l.5
 * JD-Core Version:    0.7.0.1
 */