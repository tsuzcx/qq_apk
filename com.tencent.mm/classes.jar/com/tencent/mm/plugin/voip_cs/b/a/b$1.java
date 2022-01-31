package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements am.a
{
  b$1(b paramb) {}
  
  public final boolean tC()
  {
    y.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
    c.bSQ().aYU = 1;
    this.qeI.AE(6);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.1
 * JD-Core Version:    0.7.0.1
 */