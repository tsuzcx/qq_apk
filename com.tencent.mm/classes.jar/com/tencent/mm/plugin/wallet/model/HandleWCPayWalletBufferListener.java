package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.acs;
import com.tencent.mm.autogen.a.acs.a;
import com.tencent.mm.autogen.a.acs.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.wallet_core.c.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class HandleWCPayWalletBufferListener
  extends IListener<acs>
{
  public HandleWCPayWalletBufferListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160862);
    this.__eventId = acs.class.getName().hashCode();
    AppMethodBeat.o(160862);
  }
  
  private static void a(acs paramacs, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(69186);
    Log.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1767, paramh);
    paramacs = paramacs.igc;
    Log.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", new Object[] { paramacs.appId, paramacs.nonceStr, paramacs.hhx, paramacs.ige, paramacs.hPe, paramacs.signType, paramacs.url });
    paramacs = new a(paramacs.appId, paramacs.nonceStr, paramacs.hhx, paramacs.ige, paramacs.hPe, paramacs.signType, paramacs.url);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramacs, 0);
    AppMethodBeat.o(69186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.HandleWCPayWalletBufferListener
 * JD-Core Version:    0.7.0.1
 */