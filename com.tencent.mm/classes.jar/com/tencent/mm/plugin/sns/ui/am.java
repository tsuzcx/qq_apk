package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class am
{
  String pLA = "";
  int position = 0;
  long wIQ = 0L;
  long wIR = 0L;
  String xrA = "";
  String xrB = "";
  String xrC = "";
  String xrD = "";
  int xrE = 0;
  boolean xrF = false;
  long xrz = 0L;
  
  public final boolean dAc()
  {
    AppMethodBeat.i(98232);
    long l = bt.aS(this.xrz);
    ad.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[] { Long.valueOf(l) });
    ad.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(this.xrz), this.pLA, this.xrA, Long.valueOf(this.wIQ), Integer.valueOf(this.position), Integer.valueOf(this.xrE), this.xrB, this.xrC, Long.valueOf(this.wIR), this.xrD, Boolean.valueOf(this.xrF) });
    if (this.xrF)
    {
      if (l < 180000L)
      {
        ad.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.wIQ) });
        if ((this.wIR == 0L) || (this.wIQ == 0L))
        {
          AppMethodBeat.o(98232);
          return false;
        }
        af.dtk().N(this.wIQ, -1);
        af.dtk().sP(this.wIR);
        AppMethodBeat.o(98232);
        return true;
      }
    }
    else if (l < 180000L)
    {
      ad.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.wIQ) });
      if (this.wIQ == 0L)
      {
        AppMethodBeat.o(98232);
        return false;
      }
      if ((this.position == 0) && (!bt.isNullOrNil((String)g.afB().afk().get(68377, null))))
      {
        AppMethodBeat.o(98232);
        return false;
      }
      af.dtk().N(this.wIQ, -1);
      AppMethodBeat.o(98232);
      return true;
    }
    AppMethodBeat.o(98232);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.am
 * JD-Core Version:    0.7.0.1
 */