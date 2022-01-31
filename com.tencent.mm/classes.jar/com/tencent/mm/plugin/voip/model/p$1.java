package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class p$1
  implements am.a
{
  p$1(p paramp) {}
  
  public final boolean tC()
  {
    if (!this.pTk.pTe) {
      return false;
    }
    p localp = this.pTk;
    byte[] arrayOfByte = new byte[4];
    int i;
    if (localp.pTa.setAppCmd(10, arrayOfByte, 4) < 0)
    {
      y.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
      i = -1;
      if (i != -1)
      {
        this.pTk.pTd = i;
        this.pTk.pTg = (this.pTk.pTd + this.pTk.pTg);
        localp = this.pTk;
        localp.pTh += 1;
        localp = this.pTk;
        if (localp.pTd >= 5) {
          break label175;
        }
        localp.pTf = 0;
        if (!localp.pTb)
        {
          localp.pTb = true;
          y.d("MicroMsg.VoipNetStatusChecker", "go to bad net status");
          if (localp.pTc != null) {
            localp.pTc.bbG();
          }
        }
      }
    }
    for (;;)
    {
      return true;
      i = bk.aI(arrayOfByte);
      y.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d", new Object[] { Integer.valueOf(i) });
      break;
      label175:
      if (localp.pTb) {
        if (localp.pTf <= 0)
        {
          y.d("MicroMsg.VoipNetStatusChecker", "ignore this good net status");
          localp.pTf += 1;
        }
        else
        {
          localp.pTb = false;
          y.d("MicroMsg.VoipNetStatusChecker", "go to good net status");
          if (localp.pTc != null) {
            localp.pTc.bbH();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.p.1
 * JD-Core Version:    0.7.0.1
 */