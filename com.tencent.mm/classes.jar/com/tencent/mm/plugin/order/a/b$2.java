package com.tencent.mm.plugin.order.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements bx.a
{
  b$2(b paramb) {}
  
  public final void a(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    y.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:" + parama);
    b.a(this.mOt).post(new b.2.1(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b.2
 * JD-Core Version:    0.7.0.1
 */