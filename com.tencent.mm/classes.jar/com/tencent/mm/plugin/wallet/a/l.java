package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.zo;
import com.tencent.mm.g.a.zo.a;
import com.tencent.mm.g.a.zo.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends IListener<zo>
{
  public l()
  {
    AppMethodBeat.i(160862);
    this.__eventId = zo.class.getName().hashCode();
    AppMethodBeat.o(160862);
  }
  
  private static void a(zo paramzo, i parami)
  {
    AppMethodBeat.i(69186);
    Log.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
    g.aAi();
    g.aAg().hqi.a(1767, parami);
    paramzo = paramzo.efF;
    Log.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", new Object[] { paramzo.appId, paramzo.nonceStr, paramzo.dmc, paramzo.efH, paramzo.dQk, paramzo.signType, paramzo.url });
    paramzo = new a(paramzo.appId, paramzo.nonceStr, paramzo.dmc, paramzo.efH, paramzo.dQk, paramzo.signType, paramzo.url);
    g.aAi();
    g.aAg().hqi.a(paramzo, 0);
    AppMethodBeat.o(69186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.l
 * JD-Core Version:    0.7.0.1
 */