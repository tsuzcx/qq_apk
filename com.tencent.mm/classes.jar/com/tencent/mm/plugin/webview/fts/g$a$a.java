package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g$a$a
  implements Runnable
{
  s fpY;
  public volatile boolean jFQ;
  
  private g$a$a(g.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(5724);
    if (Thread.interrupted())
    {
      AppMethodBeat.o(5724);
      return;
    }
    if (bo.isNullOrNil(this.fpY.cnv))
    {
      ab.i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.fpY.businessType), Integer.valueOf(this.fpY.scene), Integer.valueOf(this.fpY.uIE), Integer.valueOf(this.fpY.cDa), this.fpY.low, Integer.valueOf(this.fpY.offset) });
      AppMethodBeat.o(5724);
      return;
    }
    ab.i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", new Object[] { this.fpY.cnv, Integer.valueOf(this.fpY.cCT) });
    if (g.a.a(this.uPu) != null) {
      com.tencent.mm.kernel.g.Rc().a(g.a.a(this.uPu));
    }
    if (this.jFQ)
    {
      ab.i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
      AppMethodBeat.o(5724);
      return;
    }
    com.tencent.mm.plugin.webview.modeltools.g.dcB().uOD.n(this.fpY.scene, this.fpY.cnv, this.fpY.businessType);
    g.a.a(this.uPu, g.a.a(this.fpY));
    com.tencent.mm.kernel.g.Rc().a(g.a.a(this.uPu).getType(), this.uPu.uPo);
    com.tencent.mm.kernel.g.Rc().a(g.a.a(this.uPu), 0);
    ab.i("MicroMsg.TopStory.RecommendLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(g.a.a(this.uPu).getType()) });
    AppMethodBeat.o(5724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g.a.a
 * JD-Core Version:    0.7.0.1
 */