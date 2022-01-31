package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$4
  implements Runnable
{
  h$4(a parama, WepkgCrossProcessTask paramWepkgCrossProcessTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(63570);
    if (this.vGw != null) {
      this.vGw.a(this.vGB);
    }
    this.vGB.aBk();
    AppMethodBeat.o(63570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.h.4
 * JD-Core Version:    0.7.0.1
 */