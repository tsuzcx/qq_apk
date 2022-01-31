package com.tencent.mm.ui.voicesearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b$3
  implements Runnable
{
  b$3(b paramb, m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(35329);
    Object localObject1 = ((f)this.ckS).bPI();
    ab.d("MicroMsg.SearchResultAdapter", "count " + ((bxh)localObject1).xaS);
    if (((bxh)localObject1).xaS > 0)
    {
      localObject1 = ((bxh)localObject1).xaT.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bxf)((Iterator)localObject1).next();
        if (t.ku(((bxf)localObject2).xpe))
        {
          if (b.f(this.ABH) == null) {
            b.a(this.ABH, new LinkedList());
          }
          b.f(this.ABH).add(localObject2);
        }
      }
    }
    Object localObject2 = aa.a(((bxh)localObject1).wOT);
    ab.d("MicroMsg.SearchResultAdapter", "user ".concat(String.valueOf(localObject2)));
    if (bo.nullAsNil((String)localObject2).length() > 0)
    {
      bxf localbxf = new bxf();
      localbxf.wOT = ((bxh)localObject1).wOT;
      localbxf.xpe = ((bxh)localObject1).xpe;
      localbxf.gwS = ((bxh)localObject1).gwS;
      localbxf.xmi = ((bxh)localObject1).xmi;
      localbxf.gwU = ((bxh)localObject1).gwU;
      localbxf.gwY = ((bxh)localObject1).gwY;
      localbxf.gwR = ((bxh)localObject1).gwR;
      localbxf.gwQ = ((bxh)localObject1).gwQ;
      localbxf.gwP = ((bxh)localObject1).gwP;
      localbxf.xpf = ((bxh)localObject1).xpf;
      localbxf.xpi = ((bxh)localObject1).xpi;
      localbxf.xpg = ((bxh)localObject1).xpg;
      localbxf.xph = ((bxh)localObject1).xph;
      localbxf.xpk = ((bxh)localObject1).xpk;
      o.acQ().n((String)localObject2, aa.a(((bxh)localObject1).woT));
      if (b.f(this.ABH) == null) {
        b.a(this.ABH, new LinkedList());
      }
      b.f(this.ABH).clear();
      if (t.ku(localbxf.xpe)) {
        b.f(this.ABH).add(localbxf);
      }
      ab.d("MicroMsg.SearchResultAdapter", "count " + b.f(this.ABH).size());
    }
    b.b(this.ABH, false);
    AppMethodBeat.o(35329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b.3
 * JD-Core Version:    0.7.0.1
 */