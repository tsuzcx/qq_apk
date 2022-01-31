package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.storage.az;

final class g$10
  implements Runnable
{
  g$10(g paramg, int paramInt, bcs parambcs, az paramaz) {}
  
  public final void run()
  {
    AppMethodBeat.i(36145);
    e locale;
    b localb;
    bcs localbcs;
    if (!g.a(this.rdL, this.rdN, this.rdM))
    {
      locale = new e(this.rdM);
      locale.rbj = this.rdN;
      locale.ohe = this.rdM.Id;
      localb = ag.cpa();
      localbcs = this.rdM;
      if (this.rdM.jKs != 6) {
        break label97;
      }
    }
    label97:
    for (int i = 5;; i = 1)
    {
      localb.a(localbcs, i, locale, this.rdT);
      AppMethodBeat.o(36145);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g.10
 * JD-Core Version:    0.7.0.1
 */