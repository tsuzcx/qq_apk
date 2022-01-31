package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class b$10$1
  implements Runnable
{
  b$10$1(b.10 param10) {}
  
  public final void run()
  {
    AppMethodBeat.i(55155);
    if (b.v(this.oPc.oOV) != null) {
      b.v(this.oPc.oOV).dismiss();
    }
    if (b.a(this.oPc.oOV) != null) {
      b.a(this.oPc.oOV).onError();
    }
    AppMethodBeat.o(55155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.10.1
 * JD-Core Version:    0.7.0.1
 */