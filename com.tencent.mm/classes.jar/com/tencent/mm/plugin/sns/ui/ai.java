package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ai
{
  String jKL = "";
  long oSY = 0L;
  String oSZ = "";
  int oTa = 0;
  long oto = 0L;
  int position = 0;
  
  public final boolean bHZ()
  {
    long l = bk.cp(this.oSY);
    y.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[] { Long.valueOf(l) });
    y.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", new Object[] { Long.valueOf(this.oSY), this.jKL, this.oSZ, Long.valueOf(this.oto), Integer.valueOf(this.position), Integer.valueOf(this.oTa) });
    if ((l < 180000L) && (this.position > 0))
    {
      y.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[] { Long.valueOf(this.oto) });
      if (this.oto != 0L) {}
    }
    else
    {
      return false;
    }
    af.bDv().x(this.oto, -1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ai
 * JD-Core Version:    0.7.0.1
 */