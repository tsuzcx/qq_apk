package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

final class f$3
  implements com.tencent.mm.ai.f
{
  f$3(f paramf, d paramd) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(22905);
    aw.Rc().b(222, this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.oSW.cancel();
      if (this.oSC.action.equals(b.oSm)) {
        h.qsU.idkeyStat(466L, 3L, 1L, false);
      }
      for (;;)
      {
        b.a(0L, 0L, 0L, 0L, 2, this.oSW.czO, this.oSC.action);
        AppMethodBeat.o(22905);
        return;
        if (this.oSC.action.equals(b.oSn)) {
          h.qsU.idkeyStat(466L, 18L, 1L, false);
        } else if (this.oSC.action.equals(b.oSo)) {
          h.qsU.idkeyStat(466L, 34L, 1L, false);
        }
      }
    }
    ab.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
    e.O(g.bSy(), true);
    e.O(g.bSz(), true);
    this.oSW.oSV = false;
    long l = bo.hl(this.oSW.oST);
    if (this.oSC.action.equals(b.oSm))
    {
      h.qsU.idkeyStat(466L, 1L, 1L, false);
      h.qsU.idkeyStat(466L, 5L, this.oSC.oSI, false);
      h.qsU.idkeyStat(466L, 7L, l, false);
      h.qsU.idkeyStat(466L, 11L, this.oSC.oSH, false);
      h.qsU.idkeyStat(466L, 12L, this.oSC.oSG, false);
    }
    for (;;)
    {
      b.a(this.oSC.oSI, l, this.oSC.oSH, this.oSC.oSG, 0, this.oSW.czO, this.oSC.action);
      AppMethodBeat.o(22905);
      return;
      if (this.oSC.action.equals(b.oSn))
      {
        h.qsU.idkeyStat(466L, 16L, 1L, false);
        h.qsU.idkeyStat(466L, 20L, this.oSC.oSI, false);
        h.qsU.idkeyStat(466L, 22L, l, false);
        h.qsU.idkeyStat(466L, 26L, this.oSC.oSH, false);
        h.qsU.idkeyStat(466L, 27L, this.oSC.oSG, false);
      }
      else if (this.oSC.action.equals(b.oSo))
      {
        h.qsU.idkeyStat(466L, 32L, 1L, false);
        h.qsU.idkeyStat(466L, 36L, this.oSC.oSI, false);
        h.qsU.idkeyStat(466L, 38L, l, false);
        h.qsU.idkeyStat(466L, 42L, this.oSC.oSH, false);
        h.qsU.idkeyStat(466L, 43L, this.oSC.oSG, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.q.f.3
 * JD-Core Version:    0.7.0.1
 */