package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class s$4
  implements am.a
{
  s$4(s params) {}
  
  public final boolean tC()
  {
    y.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
    if ((3 == this.pTW.pNq.mStatus) && (s.d(this.pTW) != 0) && (s.d(this.pTW) == this.pTW.pNq.pQe.lpD))
    {
      s.e(this.pTW);
      this.pTW.pNq.s(5, -9000, "");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s.4
 * JD-Core Version:    0.7.0.1
 */