package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aav;
import com.tencent.mm.f.a.aav.a;
import com.tencent.mm.f.a.aav.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.c.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends IListener<aav>
{
  public l()
  {
    AppMethodBeat.i(160862);
    this.__eventId = aav.class.getName().hashCode();
    AppMethodBeat.o(160862);
  }
  
  private static void a(aav paramaav, i parami)
  {
    AppMethodBeat.i(69186);
    Log.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
    h.aHH();
    h.aHF().kcd.a(1767, parami);
    paramaav = paramaav.fZU;
    Log.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", new Object[] { paramaav.appId, paramaav.nonceStr, paramaav.fdH, paramaav.fZW, paramaav.fJB, paramaav.signType, paramaav.url });
    paramaav = new a(paramaav.appId, paramaav.nonceStr, paramaav.fdH, paramaav.fZW, paramaav.fJB, paramaav.signType, paramaav.url);
    h.aHH();
    h.aHF().kcd.a(paramaav, 0);
    AppMethodBeat.o(69186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.l
 * JD-Core Version:    0.7.0.1
 */