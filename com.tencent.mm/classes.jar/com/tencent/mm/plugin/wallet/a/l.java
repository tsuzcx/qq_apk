package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.g.a.uz.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class l
  extends c<uz>
{
  public l()
  {
    AppMethodBeat.i(45843);
    this.__eventId = uz.class.getName().hashCode();
    AppMethodBeat.o(45843);
  }
  
  private static void a(uz paramuz, f paramf)
  {
    AppMethodBeat.i(45844);
    ab.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
    g.RM();
    g.RK().eHt.a(1767, paramf);
    paramuz = paramuz.cLx;
    ab.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", new Object[] { paramuz.appId, paramuz.nonceStr, paramuz.cqf, paramuz.cLz, paramuz.cLA, paramuz.signType, paramuz.url });
    paramuz = new a(paramuz.appId, paramuz.nonceStr, paramuz.cqf, paramuz.cLz, paramuz.cLA, paramuz.signType, paramuz.url);
    g.RM();
    g.RK().eHt.a(paramuz, 0);
    AppMethodBeat.o(45844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.l
 * JD-Core Version:    0.7.0.1
 */