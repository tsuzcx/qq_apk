package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class av
{
  long QwG = 0L;
  long QwH = 0L;
  long RiX = 0L;
  String RiY = "";
  String RiZ = "";
  String Rja = "";
  String Rjb = "";
  int Rjc = 0;
  boolean Rjd = false;
  int position = 0;
  String zPH = "";
  
  public final boolean hnh()
  {
    AppMethodBeat.i(98232);
    long l = Util.ticksToNow(this.RiX);
    Log.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[] { Long.valueOf(l) });
    Log.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(this.RiX), this.zPH, this.RiY, Long.valueOf(this.QwG), Integer.valueOf(this.position), Integer.valueOf(this.Rjc), this.RiZ, this.Rja, Long.valueOf(this.QwH), this.Rjb, Boolean.valueOf(this.Rjd) });
    if (MultiProcessMMKV.getMMKV("SnsMMKV").getBoolean("SnsMMKVDeleteTable", false))
    {
      Log.i("MicroMsg.ResumeSnsControl", "already delete table, need refresh");
      AppMethodBeat.o(98232);
      return false;
    }
    if (this.Rjd)
    {
      if (l < 180000L)
      {
        Log.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.QwG) });
        if ((this.QwH == 0L) || (this.QwG == 0L))
        {
          AppMethodBeat.o(98232);
          return false;
        }
        al.hgr().ax(this.QwG, -1);
        al.hgr().uU(this.QwH);
        AppMethodBeat.o(98232);
        return true;
      }
    }
    else if (l < 180000L)
    {
      Log.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.QwG) });
      if (this.QwG == 0L)
      {
        AppMethodBeat.o(98232);
        return false;
      }
      if ((this.position == 0) && (!Util.isNullOrNil((String)h.baE().ban().d(68377, null))))
      {
        AppMethodBeat.o(98232);
        return false;
      }
      al.hgr().ax(this.QwG, -1);
      AppMethodBeat.o(98232);
      return true;
    }
    AppMethodBeat.o(98232);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av
 * JD-Core Version:    0.7.0.1
 */