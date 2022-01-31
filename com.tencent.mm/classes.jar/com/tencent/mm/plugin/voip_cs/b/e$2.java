package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.b.c.b;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements am.a
{
  e$2(e parame) {}
  
  public final boolean tC()
  {
    y.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
    Object localObject = this.qeh;
    g.Dk().a(795, (f)localObject);
    localObject = new b(c.bSO().qeL.pUA, c.bSO().qeL.lpE);
    g.Dk().a((m)localObject, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.e.2
 * JD-Core Version:    0.7.0.1
 */