package com.tencent.mm.plugin.wepkg;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$3
  implements am.a
{
  c$3(c paramc) {}
  
  public final boolean tC()
  {
    if (!c.c(this.rNZ))
    {
      y.i("MicroMsg.WePkgPlugin", "white screen");
      ai.d(new c.3.1(this));
      return false;
    }
    c.Dw(0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.3
 * JD-Core Version:    0.7.0.1
 */