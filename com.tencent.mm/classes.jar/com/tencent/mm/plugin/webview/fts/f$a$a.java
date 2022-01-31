package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class f$a$a
  implements Runnable
{
  s dZR;
  public volatile boolean hMo;
  
  private f$a$a(f.a parama) {}
  
  public final void run()
  {
    if (Thread.interrupted()) {
      return;
    }
    if (bk.bl(this.dZR.bGm))
    {
      y.i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.dZR.businessType), Integer.valueOf(this.dZR.scene), Integer.valueOf(this.dZR.qTw), Integer.valueOf(this.dZR.bVt), this.dZR.jfE, Integer.valueOf(this.dZR.offset) });
      return;
    }
    y.i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", new Object[] { this.dZR.bGm, Integer.valueOf(this.dZR.bVm) });
    if (f.a.a(this.qZM) != null) {
      au.Dk().c(f.a.a(this.qZM));
    }
    if (this.hMo)
    {
      y.i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
      return;
    }
    g.ccI().qYX.j(this.dZR.scene, this.dZR.bGm, this.dZR.businessType);
    f.a.a(this.qZM, f.a.a(this.dZR));
    au.Dk().a(f.a.a(this.qZM).getType(), this.qZM.qZG);
    au.Dk().a(f.a.a(this.qZM), 0);
    y.i("MicroMsg.TopStory.RecommendLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(f.a.a(this.qZM).getType()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.f.a.a
 * JD-Core Version:    0.7.0.1
 */