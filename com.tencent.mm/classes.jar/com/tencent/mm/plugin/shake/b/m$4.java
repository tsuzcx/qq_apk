package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class m$4
  implements bx.a
{
  m$4(m paramm) {}
  
  public final void a(e.a parama)
  {
    String str = aa.a(parama.dBs.svH);
    if ((str == null) || (str.length() == 0))
    {
      y.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
      return;
    }
    m.a(this.nZk).post(new m.4.1(this, str, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m.4
 * JD-Core Version:    0.7.0.1
 */