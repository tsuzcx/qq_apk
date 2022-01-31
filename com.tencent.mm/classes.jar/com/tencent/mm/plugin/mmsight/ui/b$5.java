package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class b$5
  implements Runnable
{
  b$5(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(55146);
    if (b.v(this.oOV) != null) {
      b.v(this.oOV).dismiss();
    }
    if (b.a(this.oOV) != null) {
      b.a(this.oOV).bRC();
    }
    AppMethodBeat.o(55146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.5
 * JD-Core Version:    0.7.0.1
 */