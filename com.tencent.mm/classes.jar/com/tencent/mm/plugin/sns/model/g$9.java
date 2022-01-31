package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.Set;

final class g$9
  implements Runnable
{
  g$9(g paramg, int paramInt, bcs parambcs, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(36144);
    while (g.e(this.rdL).size() >= 60)
    {
      localb = (g.b)g.e(this.rdL).removeFirst();
      this.rdL.rdJ.remove(localb.key);
    }
    ab.i("MicroMsg.LazyerImageLoader2", "add loaderlist size:" + g.e(this.rdL).size());
    g.b localb = new g.b(this.rdL, i.bc(this.rdN, this.rdM.Id), this.rdY + this.rdZ, this.rdY, this.rdM, this.rdN);
    if (!g.f(this.rdL).Z(localb.key)) {
      g.e(this.rdL).add(localb);
    }
    for (;;)
    {
      g.g(this.rdL);
      AppMethodBeat.o(36144);
      return;
      this.rdL.rdJ.remove(localb.key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g.9
 * JD-Core Version:    0.7.0.1
 */