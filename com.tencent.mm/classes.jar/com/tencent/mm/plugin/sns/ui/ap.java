package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ao.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class ap
{
  long AmS = 0L;
  String AmT = "";
  String AmU = "";
  String AmV = "";
  String AmW = "";
  int AmX = 0;
  boolean AmY = false;
  int position = 0;
  String rmb = "";
  long zCw = 0L;
  long zCx = 0L;
  
  public final boolean eet()
  {
    AppMethodBeat.i(98232);
    long l = bu.aO(this.AmS);
    ae.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[] { Long.valueOf(l) });
    ae.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(this.AmS), this.rmb, this.AmT, Long.valueOf(this.zCw), Integer.valueOf(this.position), Integer.valueOf(this.AmX), this.AmU, this.AmV, Long.valueOf(this.zCx), this.AmW, Boolean.valueOf(this.AmY) });
    if (this.AmY)
    {
      if (l < 180000L)
      {
        ae.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.zCw) });
        if ((this.zCx == 0L) || (this.zCw == 0L))
        {
          AppMethodBeat.o(98232);
          return false;
        }
        ah.dXu().V(this.zCw, -1);
        ah.dXu().Ap(this.zCx);
        AppMethodBeat.o(98232);
        return true;
      }
    }
    else if (l < 180000L)
    {
      ae.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.zCw) });
      if (this.zCw == 0L)
      {
        AppMethodBeat.o(98232);
        return false;
      }
      if ((this.position == 0) && (!bu.isNullOrNil((String)g.ajR().ajA().get(68377, null))))
      {
        AppMethodBeat.o(98232);
        return false;
      }
      ah.dXu().V(this.zCw, -1);
      AppMethodBeat.o(98232);
      return true;
    }
    AppMethodBeat.o(98232);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ap
 * JD-Core Version:    0.7.0.1
 */