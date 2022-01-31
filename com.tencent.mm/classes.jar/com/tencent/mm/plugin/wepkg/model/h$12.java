package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$12
  implements Runnable
{
  h$12(a parama, WepkgCrossProcessTask paramWepkgCrossProcessTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(63578);
    if (this.vGw != null) {
      this.vGw.a(this.vGB);
    }
    this.vGB.aBk();
    AppMethodBeat.o(63578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.h.12
 * JD-Core Version:    0.7.0.1
 */