package com.tencent.mm.plugin.offline;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class k$4
  implements bx.a
{
  k$4(k paramk) {}
  
  public final void a(e.a parama)
  {
    String str = aa.a(parama.dBs.svH);
    y.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:" + str);
    k.a(this.mKD).post(new k.4.1(this, str, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k.4
 * JD-Core Version:    0.7.0.1
 */