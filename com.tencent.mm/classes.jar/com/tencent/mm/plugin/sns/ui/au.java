package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class au
{
  long JZy = 0L;
  long JZz = 0L;
  int KJA = 0;
  boolean KJB = false;
  long KJv = 0L;
  String KJw = "";
  String KJx = "";
  String KJy = "";
  String KJz = "";
  int position = 0;
  String wtB = "";
  
  public final boolean fUR()
  {
    AppMethodBeat.i(98232);
    long l = Util.ticksToNow(this.KJv);
    Log.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[] { Long.valueOf(l) });
    Log.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(this.KJv), this.wtB, this.KJw, Long.valueOf(this.JZy), Integer.valueOf(this.position), Integer.valueOf(this.KJA), this.KJx, this.KJy, Long.valueOf(this.JZz), this.KJz, Boolean.valueOf(this.KJB) });
    if (MultiProcessMMKV.getMMKV("SnsMMKV").getBoolean("SnsMMKVDeleteTable", false))
    {
      Log.i("MicroMsg.ResumeSnsControl", "already delete table, need refresh");
      AppMethodBeat.o(98232);
      return false;
    }
    if (this.KJB)
    {
      if (l < 180000L)
      {
        Log.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.JZy) });
        if ((this.JZz == 0L) || (this.JZy == 0L))
        {
          AppMethodBeat.o(98232);
          return false;
        }
        aj.fOy().af(this.JZy, -1);
        aj.fOy().QO(this.JZz);
        AppMethodBeat.o(98232);
        return true;
      }
    }
    else if (l < 180000L)
    {
      Log.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.JZy) });
      if (this.JZy == 0L)
      {
        AppMethodBeat.o(98232);
        return false;
      }
      if ((this.position == 0) && (!Util.isNullOrNil((String)h.aHG().aHp().b(68377, null))))
      {
        AppMethodBeat.o(98232);
        return false;
      }
      aj.fOy().af(this.JZy, -1);
      AppMethodBeat.o(98232);
      return true;
    }
    AppMethodBeat.o(98232);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au
 * JD-Core Version:    0.7.0.1
 */