package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ak;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(24417);
    if ((this.qMW.qMU != null) && (this.qMW.qMV != null)) {
      this.qMW.qMU.removeCallbacks(this.qMW.qMV);
    }
    if (this.qMW.qMS != null) {
      aw.Rc().a(this.qMW.qMS);
    }
    if ((this.qMW.qMR != null) && (this.qMW.qMR.cLl != null)) {
      this.qMW.qMS = new a(this.qMW.qMR.cLl);
    }
    if (this.qMW.qMS != null) {
      aw.Rc().a(this.qMW.qMS, 0);
    }
    AppMethodBeat.o(24417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.c.1
 * JD-Core Version:    0.7.0.1
 */