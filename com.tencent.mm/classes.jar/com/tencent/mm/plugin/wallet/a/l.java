package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xj;
import com.tencent.mm.g.a.xj.a;
import com.tencent.mm.g.a.xj.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.c.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class l
  extends c<xj>
{
  public l()
  {
    AppMethodBeat.i(160862);
    this.__eventId = xj.class.getName().hashCode();
    AppMethodBeat.o(160862);
  }
  
  private static void a(xj paramxj, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(69186);
    ac.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1767, paramg);
    paramxj = paramxj.dAg;
    ac.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", new Object[] { paramxj.appId, paramxj.nonceStr, paramxj.cJz, paramxj.dAi, paramxj.dAj, paramxj.signType, paramxj.url });
    paramxj = new a(paramxj.appId, paramxj.nonceStr, paramxj.cJz, paramxj.dAi, paramxj.dAj, paramxj.signType, paramxj.url);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramxj, 0);
    AppMethodBeat.o(69186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.l
 * JD-Core Version:    0.7.0.1
 */