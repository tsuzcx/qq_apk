package com.tencent.mm.plugin.scanner.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.plugin.scanner.d.e.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  Activity mActivity;
  String ymE;
  com.tencent.mm.plugin.scanner.util.c ymF;
  com.tencent.mm.plugin.scanner.util.a ymG;
  e.a ymH;
  public com.tencent.mm.sdk.b.c ymI;
  public com.tencent.mm.sdk.b.c ymJ;
  public com.tencent.mm.sdk.b.c ymK;
  
  public d()
  {
    AppMethodBeat.i(51615);
    this.ymH = new e.a()
    {
      public final void t(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51612);
        ad.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        mx localmx = new mx();
        localmx.dAR.dAP = paramAnonymousInt;
        localmx.dAR.activity = d.this.mActivity;
        localmx.dAR.dlG = d.this.ymE;
        localmx.dAR.dAS = paramAnonymousBundle;
        com.tencent.mm.sdk.b.a.IbL.l(localmx);
        AppMethodBeat.o(51612);
      }
    };
    this.ymI = new com.tencent.mm.sdk.b.c() {};
    this.ymJ = new com.tencent.mm.sdk.b.c() {};
    this.ymK = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(51615);
  }
  
  public final void dKQ()
  {
    AppMethodBeat.i(51616);
    if (this.ymF != null)
    {
      this.ymF.dML();
      this.ymF = null;
    }
    this.mActivity = null;
    this.ymE = null;
    AppMethodBeat.o(51616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.d
 * JD-Core Version:    0.7.0.1
 */