package com.tencent.mm.plugin.sns.ui.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.sdk.platformtools.bo;

final class e$6
  implements b.f
{
  e$6(e parame, long paramLong, boolean paramBoolean, int paramInt) {}
  
  public final void b(b paramb, long paramLong)
  {
    AppMethodBeat.i(40108);
    if (paramLong >= 3L)
    {
      int i = (int)paramb.cmE();
      if (this.sgA.rOU != null)
      {
        this.sgA.rOU.c(this.sgG, bo.yB(), this.qZq);
        this.sgA.rOU.f(this.sgG, i, this.qZq);
        this.sgA.rOU.V(this.sgG, this.sgG + this.val$index);
      }
      this.sgA.sfG.qVe.setOnDecodeDurationListener(null);
    }
    AppMethodBeat.o(40108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.e.6
 * JD-Core Version:    0.7.0.1
 */