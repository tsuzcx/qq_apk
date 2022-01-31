package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class ai
{
  String meP = "";
  int position = 0;
  long rKV = 0L;
  String rKW = "";
  int rKX = 0;
  long rig = 0L;
  
  public final boolean cur()
  {
    AppMethodBeat.i(38545);
    long l = bo.av(this.rKV);
    ab.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[] { Long.valueOf(l) });
    ab.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", new Object[] { Long.valueOf(this.rKV), this.meP, this.rKW, Long.valueOf(this.rig), Integer.valueOf(this.position), Integer.valueOf(this.rKX) });
    if ((l < 180000L) && (this.position > 0))
    {
      ab.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.rig) });
      if (this.rig == 0L)
      {
        AppMethodBeat.o(38545);
        return false;
      }
      ag.coV().E(this.rig, -1);
      AppMethodBeat.o(38545);
      return true;
    }
    AppMethodBeat.o(38545);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ai
 * JD-Core Version:    0.7.0.1
 */