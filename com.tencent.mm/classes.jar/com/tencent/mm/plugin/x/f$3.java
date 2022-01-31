package com.tencent.mm.plugin.x;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class f$3
  implements com.tencent.mm.ah.f
{
  f$3(f paramf, d paramd) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(222, this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.mtl.cancel();
      if (this.msR.action.equals(b.msB)) {
        h.nFQ.a(466L, 3L, 1L, false);
      }
      for (;;)
      {
        b.a(0L, 0L, 0L, 0L, 2, this.mtl.bSn, this.msR.action);
        return;
        if (this.msR.action.equals(b.msC)) {
          h.nFQ.a(466L, 18L, 1L, false);
        } else if (this.msR.action.equals(b.msD)) {
          h.nFQ.a(466L, 34L, 1L, false);
        }
      }
    }
    y.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
    e.K(g.bky(), true);
    e.K(g.bkz(), true);
    this.mtl.mtk = false;
    long l = bk.co(this.mtl.mti);
    if (this.msR.action.equals(b.msB))
    {
      h.nFQ.a(466L, 1L, 1L, false);
      h.nFQ.a(466L, 5L, this.msR.msX, false);
      h.nFQ.a(466L, 7L, l, false);
      h.nFQ.a(466L, 11L, this.msR.msW, false);
      h.nFQ.a(466L, 12L, this.msR.msV, false);
    }
    for (;;)
    {
      b.a(this.msR.msX, l, this.msR.msW, this.msR.msV, 0, this.mtl.bSn, this.msR.action);
      return;
      if (this.msR.action.equals(b.msC))
      {
        h.nFQ.a(466L, 16L, 1L, false);
        h.nFQ.a(466L, 20L, this.msR.msX, false);
        h.nFQ.a(466L, 22L, l, false);
        h.nFQ.a(466L, 26L, this.msR.msW, false);
        h.nFQ.a(466L, 27L, this.msR.msV, false);
      }
      else if (this.msR.action.equals(b.msD))
      {
        h.nFQ.a(466L, 32L, 1L, false);
        h.nFQ.a(466L, 36L, this.msR.msX, false);
        h.nFQ.a(466L, 38L, l, false);
        h.nFQ.a(466L, 42L, this.msR.msW, false);
        h.nFQ.a(466L, 43L, this.msR.msV, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.x.f.3
 * JD-Core Version:    0.7.0.1
 */