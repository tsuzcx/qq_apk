package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.g.a.yj.a;
import com.tencent.mm.g.a.yj.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class l
  extends c<yj>
{
  public l()
  {
    AppMethodBeat.i(160862);
    this.__eventId = yj.class.getName().hashCode();
    AppMethodBeat.o(160862);
  }
  
  private static void a(yj paramyj, f paramf)
  {
    AppMethodBeat.i(69186);
    ae.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
    g.ajS();
    g.ajQ().gDv.a(1767, paramf);
    paramyj = paramyj.dNJ;
    ae.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", new Object[] { paramyj.appId, paramyj.nonceStr, paramyj.cVJ, paramyj.dNL, paramyj.dNM, paramyj.signType, paramyj.url });
    paramyj = new a(paramyj.appId, paramyj.nonceStr, paramyj.cVJ, paramyj.dNL, paramyj.dNM, paramyj.signType, paramyj.url);
    g.ajS();
    g.ajQ().gDv.a(paramyj, 0);
    AppMethodBeat.o(69186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.l
 * JD-Core Version:    0.7.0.1
 */