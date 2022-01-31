package com.tencent.mm.plugin.webview.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.sdk.platformtools.ab;

final class b$a$1
  implements com.tencent.mm.modelappbrand.h
{
  b$a$1(b.a parama, cyy paramcyy, long paramLong) {}
  
  public final void b(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(5766);
    ab.i("WidgetPkgPreDownloadMgr", "down succ %b", new Object[] { Boolean.valueOf(paramBoolean) });
    dl localdl;
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.qsU.cT(918, 2);
      b.a.a(this.uPP);
      localdl = new dl().iR(this.uPO.cwc);
      localdl.dfp = this.uPO.wAy;
      localdl = localdl.iT(this.uPO.yfX).iS(this.uPO.yfW);
      localdl.dfu = System.currentTimeMillis();
      if (!paramBoolean) {
        break label168;
      }
    }
    label168:
    for (long l = 1L;; l = 0L)
    {
      localdl.dfs = l;
      localdl.dft = (System.currentTimeMillis() - this.uLY);
      localdl.dfv = paramLong;
      localdl.ake();
      AppMethodBeat.o(5766);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.cT(918, 3);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b.a.1
 * JD-Core Version:    0.7.0.1
 */