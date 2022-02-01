package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class ap
{
  int position = 0;
  String rdV = "";
  long zVK = 0L;
  String zVL = "";
  String zVM = "";
  String zVN = "";
  String zVO = "";
  int zVP = 0;
  boolean zVQ = false;
  long zlh = 0L;
  long zli = 0L;
  
  public final boolean eaN()
  {
    AppMethodBeat.i(98232);
    long l = bt.aO(this.zVK);
    ad.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[] { Long.valueOf(l) });
    ad.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(this.zVK), this.rdV, this.zVL, Long.valueOf(this.zlh), Integer.valueOf(this.position), Integer.valueOf(this.zVP), this.zVM, this.zVN, Long.valueOf(this.zli), this.zVO, Boolean.valueOf(this.zVQ) });
    if (this.zVQ)
    {
      if (l < 180000L)
      {
        ad.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.zlh) });
        if ((this.zli == 0L) || (this.zlh == 0L))
        {
          AppMethodBeat.o(98232);
          return false;
        }
        ag.dTU().V(this.zlh, -1);
        ag.dTU().zR(this.zli);
        AppMethodBeat.o(98232);
        return true;
      }
    }
    else if (l < 180000L)
    {
      ad.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.zlh) });
      if (this.zlh == 0L)
      {
        AppMethodBeat.o(98232);
        return false;
      }
      if ((this.position == 0) && (!bt.isNullOrNil((String)g.ajC().ajl().get(68377, null))))
      {
        AppMethodBeat.o(98232);
        return false;
      }
      ag.dTU().V(this.zlh, -1);
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