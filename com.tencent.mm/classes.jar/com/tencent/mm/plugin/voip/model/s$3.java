package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.a.f;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;

final class s$3
  implements am.a
{
  s$3(s params) {}
  
  public final boolean tC()
  {
    if (this.pTW.pNq.pQe.lpD == 0)
    {
      a.Loge("MicroMsg.Voip.VoipServiceEx", g.zI() + " roomId == 0 ");
      s.c(this.pTW).stopTimer();
    }
    for (;;)
    {
      return true;
      if (this.pTW.pNq.mStatus >= 5) {}
      for (int i = 1; i != 0; i = 0)
      {
        new f(this.pTW.pNq.pQe.lpD, this.pTW.pNq.pQe.lpE, this.pTW.pNq.pQr).bRB();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s.3
 * JD-Core Version:    0.7.0.1
 */