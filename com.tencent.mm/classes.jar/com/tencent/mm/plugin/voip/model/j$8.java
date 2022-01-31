package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.sdk.platformtools.am.a;

final class j$8
  implements am.a
{
  j$8(j paramj) {}
  
  public final boolean tC()
  {
    if (j.c(this.pQy) == 4)
    {
      a.Logi("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
      this.pQy.pQe.pWi.pQU = 105;
      this.pQy.s(1, -9000, "");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j.8
 * JD-Core Version:    0.7.0.1
 */