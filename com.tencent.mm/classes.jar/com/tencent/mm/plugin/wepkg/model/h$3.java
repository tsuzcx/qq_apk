package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$3
  implements Runnable
{
  h$3(WepkgCrossProcessTask paramWepkgCrossProcessTask, a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(63569);
    this.vGB.ata();
    if (this.vGw != null) {
      this.vGw.a(this.vGB);
    }
    AppMethodBeat.o(63569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.h.3
 * JD-Core Version:    0.7.0.1
 */