package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class b$4$3
  implements Runnable
{
  b$4$3(b.4 param4) {}
  
  public final void run()
  {
    AppMethodBeat.i(55142);
    if (b.v(this.oOZ.oOV) != null) {
      b.v(this.oOZ.oOV).dismiss();
    }
    if (b.a(this.oOZ.oOV) != null) {
      b.a(this.oOZ.oOV).onError();
    }
    AppMethodBeat.o(55142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.4.3
 * JD-Core Version:    0.7.0.1
 */