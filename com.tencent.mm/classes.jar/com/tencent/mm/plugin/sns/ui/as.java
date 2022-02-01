package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class as
{
  long DMw = 0L;
  long DMx = 0L;
  long EvE = 0L;
  String EvF = "";
  String EvG = "";
  String EvH = "";
  String EvI = "";
  int EvJ = 0;
  boolean EvK = false;
  int position = 0;
  String sNG = "";
  
  public final boolean fgK()
  {
    AppMethodBeat.i(98232);
    long l = Util.ticksToNow(this.EvE);
    Log.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[] { Long.valueOf(l) });
    Log.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(this.EvE), this.sNG, this.EvF, Long.valueOf(this.DMw), Integer.valueOf(this.position), Integer.valueOf(this.EvJ), this.EvG, this.EvH, Long.valueOf(this.DMx), this.EvI, Boolean.valueOf(this.EvK) });
    if (MultiProcessMMKV.getMMKV("SnsMMKV").getBoolean("SnsMMKVDeleteTable", false))
    {
      Log.i("MicroMsg.ResumeSnsControl", "already delete table, need refresh");
      AppMethodBeat.o(98232);
      return false;
    }
    if (this.EvK)
    {
      if (l < 180000L)
      {
        Log.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.DMw) });
        if ((this.DMx == 0L) || (this.DMw == 0L))
        {
          AppMethodBeat.o(98232);
          return false;
        }
        aj.faE().W(this.DMw, -1);
        aj.faE().Jv(this.DMx);
        AppMethodBeat.o(98232);
        return true;
      }
    }
    else if (l < 180000L)
    {
      Log.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.DMw) });
      if (this.DMw == 0L)
      {
        AppMethodBeat.o(98232);
        return false;
      }
      if ((this.position == 0) && (!Util.isNullOrNil((String)g.aAh().azQ().get(68377, null))))
      {
        AppMethodBeat.o(98232);
        return false;
      }
      aj.faE().W(this.DMw, -1);
      AppMethodBeat.o(98232);
      return true;
    }
    AppMethodBeat.o(98232);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as
 * JD-Core Version:    0.7.0.1
 */