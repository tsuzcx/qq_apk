package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;

final class d$1
  implements Runnable
{
  d$1(WepkgCrossProcessTask paramWepkgCrossProcessTask, a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(63649);
    this.vGn.ata();
    if (this.vGw != null) {
      this.vGw.a(this.vGn);
    }
    AppMethodBeat.o(63649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.d.1
 * JD-Core Version:    0.7.0.1
 */