package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.yd;
import com.tencent.mm.g.a.yd.a;
import com.tencent.mm.g.a.yd.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class l
  extends c<yd>
{
  public l()
  {
    AppMethodBeat.i(160862);
    this.__eventId = yd.class.getName().hashCode();
    AppMethodBeat.o(160862);
  }
  
  private static void a(yd paramyd, f paramf)
  {
    AppMethodBeat.i(69186);
    ad.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
    g.ajD();
    g.ajB().gAO.a(1767, paramf);
    paramyd = paramyd.dMt;
    ad.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", new Object[] { paramyd.appId, paramyd.nonceStr, paramyd.cUM, paramyd.dMv, paramyd.dMw, paramyd.signType, paramyd.url });
    paramyd = new a(paramyd.appId, paramyd.nonceStr, paramyd.cUM, paramyd.dMv, paramyd.dMw, paramyd.signType, paramyd.url);
    g.ajD();
    g.ajB().gAO.a(paramyd, 0);
    AppMethodBeat.o(69186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.l
 * JD-Core Version:    0.7.0.1
 */