package com.tencent.mm.plugin.webview.fts.a.a;

import com.tencent.mm.h.b.a.bc;
import com.tencent.mm.protocal.c.cli;
import com.tencent.mm.sdk.platformtools.y;

final class b$a$1
  implements com.tencent.mm.modelappbrand.h
{
  b$a$1(b.a parama, cli paramcli, long paramLong) {}
  
  public final void a(boolean paramBoolean, long paramLong)
  {
    long l = 1L;
    y.i("WidgetPkgPreDownloadMgr", "down succ %b", new Object[] { Boolean.valueOf(paramBoolean) });
    bc localbc;
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.h(918L, 2L, 1L);
      b.a.a(this.rai);
      localbc = new bc();
      localbc.cjv = this.rah.bOL;
      localbc.cqR = this.rah.sEs;
      localbc.cqT = this.rah.tYE;
      localbc.cqS = this.rah.tYD;
      localbc.cqW = System.currentTimeMillis();
      if (!paramBoolean) {
        break label164;
      }
    }
    for (;;)
    {
      localbc.cqU = l;
      localbc.cqV = (System.currentTimeMillis() - this.qWL);
      localbc.cqX = paramLong;
      localbc.QX();
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.h(918L, 3L, 1L);
      break;
      label164:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b.a.1
 * JD-Core Version:    0.7.0.1
 */