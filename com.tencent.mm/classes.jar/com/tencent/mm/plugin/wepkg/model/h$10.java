package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$10
  implements Runnable
{
  h$10(a parama, WepkgCrossProcessTask paramWepkgCrossProcessTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(63576);
    if (this.vGw != null) {
      this.vGw.a(this.vGB);
    }
    this.vGB.aBk();
    AppMethodBeat.o(63576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.h.10
 * JD-Core Version:    0.7.0.1
 */