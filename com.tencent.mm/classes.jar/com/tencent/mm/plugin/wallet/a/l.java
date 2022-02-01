package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.g.a.wy.a;
import com.tencent.mm.g.a.wy.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.c.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class l
  extends c<wy>
{
  public l()
  {
    AppMethodBeat.i(160862);
    this.__eventId = wy.class.getName().hashCode();
    AppMethodBeat.o(160862);
  }
  
  private static void a(wy paramwy, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(69186);
    ad.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1767, paramg);
    paramwy = paramwy.dCu;
    ad.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", new Object[] { paramwy.appId, paramwy.nonceStr, paramwy.cMo, paramwy.dCw, paramwy.dCx, paramwy.signType, paramwy.url });
    paramwy = new a(paramwy.appId, paramwy.nonceStr, paramwy.cMo, paramwy.dCw, paramwy.dCx, paramwy.signType, paramwy.url);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramwy, 0);
    AppMethodBeat.o(69186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.l
 * JD-Core Version:    0.7.0.1
 */