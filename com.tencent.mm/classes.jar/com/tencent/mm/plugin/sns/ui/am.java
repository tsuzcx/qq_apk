package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class am
{
  int position = 0;
  String qui = "";
  long xVl = 0L;
  long xVm = 0L;
  long yEp = 0L;
  String yEq = "";
  String yEr = "";
  String yEs = "";
  String yEt = "";
  int yEu = 0;
  boolean yEv = false;
  
  public final boolean dOz()
  {
    AppMethodBeat.i(98232);
    long l = bs.aO(this.yEp);
    ac.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[] { Long.valueOf(l) });
    ac.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(this.yEp), this.qui, this.yEq, Long.valueOf(this.xVl), Integer.valueOf(this.position), Integer.valueOf(this.yEu), this.yEr, this.yEs, Long.valueOf(this.xVm), this.yEt, Boolean.valueOf(this.yEv) });
    if (this.yEv)
    {
      if (l < 180000L)
      {
        ac.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.xVl) });
        if ((this.xVm == 0L) || (this.xVl == 0L))
        {
          AppMethodBeat.o(98232);
          return false;
        }
        af.dHH().Q(this.xVl, -1);
        af.dHH().xs(this.xVm);
        AppMethodBeat.o(98232);
        return true;
      }
    }
    else if (l < 180000L)
    {
      ac.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.xVl) });
      if (this.xVl == 0L)
      {
        AppMethodBeat.o(98232);
        return false;
      }
      if ((this.position == 0) && (!bs.isNullOrNil((String)g.agR().agA().get(68377, null))))
      {
        AppMethodBeat.o(98232);
        return false;
      }
      af.dHH().Q(this.xVl, -1);
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