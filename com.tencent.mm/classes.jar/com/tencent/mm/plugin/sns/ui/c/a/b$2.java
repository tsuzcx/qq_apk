package com.tencent.mm.plugin.sns.ui.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.sdk.platformtools.bo;

final class b$2
  implements b.f
{
  b$2(b paramb) {}
  
  public final void b(com.tencent.mm.plugin.sight.decode.a.b paramb, long paramLong)
  {
    AppMethodBeat.i(40089);
    int i = (int)paramb.cmE();
    if ((this.sfS.rOU != null) && (paramLong >= 3L))
    {
      this.sfS.rOU.c(this.sfS.rMD.field_snsId, bo.yB(), false);
      this.sfS.rOU.f(this.sfS.rMD.field_snsId, i, false);
      this.sfS.rOU.V(this.sfS.rMD.field_snsId, this.sfS.rMD.field_snsId);
    }
    this.sfS.sfG.qVe.setOnDecodeDurationListener(null);
    AppMethodBeat.o(40089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.b.2
 * JD-Core Version:    0.7.0.1
 */