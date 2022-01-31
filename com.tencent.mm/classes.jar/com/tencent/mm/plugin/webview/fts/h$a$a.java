package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.websearch.c.a.c;
import com.tencent.mm.plugin.websearch.c.a.e;
import com.tencent.mm.plugin.websearch.c.a.e.a;
import com.tencent.mm.protocal.protobuf.cpj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h$a$a
  implements Runnable
{
  s fpY;
  public volatile boolean jFQ;
  
  private h$a$a(h.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(5743);
    if (Thread.interrupted())
    {
      AppMethodBeat.o(5743);
      return;
    }
    if (bo.isNullOrNil(this.fpY.cnv))
    {
      ab.i("MicroMsg.WebSearch.WebSearchLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.fpY.businessType), Integer.valueOf(this.fpY.scene), Integer.valueOf(this.fpY.uIE), Integer.valueOf(this.fpY.cDa), this.fpY.low, Integer.valueOf(this.fpY.offset) });
      AppMethodBeat.o(5743);
      return;
    }
    switch (this.fpY.scene)
    {
    }
    LinkedList localLinkedList;
    Object localObject;
    for (;;)
    {
      ab.i("MicroMsg.WebSearch.WebSearchLogic", "start New NetScene %s ,  %d", new Object[] { this.fpY.cnv, Integer.valueOf(this.fpY.cCT) });
      if (h.a.a(this.uPH) != null) {
        com.tencent.mm.kernel.g.Rc().a(h.a.a(this.uPH));
      }
      localLinkedList = null;
      if (this.fpY.uIF != null)
      {
        localObject = localLinkedList;
        if (!this.fpY.uIF.isEmpty()) {}
      }
      else
      {
        localObject = localLinkedList;
        if (h.aw(this.fpY.cnv, this.fpY.scene, this.fpY.businessType))
        {
          long l = System.currentTimeMillis();
          localObject = (e)h.a(this.uPH.uPD).agB(this.fpY.cnv);
          l = System.currentTimeMillis() - l;
          ab.i("MicroMsg.WebSearch.WebSearchLogic", "match contact cost %d ms", new Object[] { Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.h.qsU.e(14717, new Object[] { this.fpY.cnv, Integer.valueOf(t.aad()), Integer.valueOf(((e)localObject).mTC.size()), Long.valueOf(l), Integer.valueOf(this.fpY.scene) });
        }
      }
      if (!this.jFQ) {
        break;
      }
      ab.i("MicroMsg.WebSearch.WebSearchLogic", "was cancelled");
      AppMethodBeat.o(5743);
      return;
      ((n)com.tencent.mm.kernel.g.G(n.class)).addSOSHistory(this.fpY.cnv);
    }
    com.tencent.mm.plugin.webview.modeltools.g.dcB().uOD.n(this.fpY.scene, this.fpY.cnv, this.fpY.businessType);
    h.a.a(this.uPH, h.a.c(this.fpY));
    if (localObject != null)
    {
      localLinkedList = new LinkedList();
      localObject = new ArrayList(((e)localObject).mTC).iterator();
      while (((Iterator)localObject).hasNext())
      {
        e.a locala = (e.a)((Iterator)localObject).next();
        cpj localcpj = new cpj();
        localcpj.jJA = locala.userName;
        localcpj.xYv = locala.uLr;
        localcpj.jKG = locala.blZ;
        localcpj.wNM = locala.hKa;
        localcpj.gwU = locala.dCJ;
        localcpj.woO = locala.desc;
        localLinkedList.add(localcpj);
      }
      h.a.a(this.uPH).aB(localLinkedList);
    }
    com.tencent.mm.kernel.g.Rc().a(h.a.a(this.uPH).getType(), this.uPH.uPD);
    com.tencent.mm.kernel.g.Rc().a(h.a.a(this.uPH), 0);
    ab.i("MicroMsg.WebSearch.WebSearchLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(h.a.a(this.uPH).getType()) });
    AppMethodBeat.o(5743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h.a.a
 * JD-Core Version:    0.7.0.1
 */