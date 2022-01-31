package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$9
  implements Runnable
{
  h$9(WepkgCrossProcessTask paramWepkgCrossProcessTask, a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(63575);
    this.vGB.ata();
    if (this.vGw != null) {
      this.vGw.a(this.vGB);
    }
    AppMethodBeat.o(63575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.h.9
 * JD-Core Version:    0.7.0.1
 */