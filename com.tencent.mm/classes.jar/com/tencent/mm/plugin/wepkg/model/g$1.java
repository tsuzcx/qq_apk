package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.al;
import java.io.File;

final class g$1
  implements Runnable
{
  g$1(WepkgCrossProcessTask paramWepkgCrossProcessTask, String paramString, File paramFile, g.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(63552);
    if (this.vGn.cmX) {
      d.aNS().ac(new g.1.1(this));
    }
    this.vGn.aBk();
    AppMethodBeat.o(63552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.g.1
 * JD-Core Version:    0.7.0.1
 */