package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h$7
  implements Runnable
{
  public h$7(WepkgCrossProcessTask paramWepkgCrossProcessTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(63573);
    if (this.vGw != null) {
      this.vGw.a(this.vGB);
    }
    this.vGB.aBk();
    AppMethodBeat.o(63573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.h.7
 * JD-Core Version:    0.7.0.1
 */