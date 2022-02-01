package com.tencent.mm.plugin.scanner.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.plugin.scanner.d.e.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
{
  Activity mActivity;
  String yCC;
  com.tencent.mm.plugin.scanner.util.c yCD;
  com.tencent.mm.plugin.scanner.util.a yCE;
  e.a yCF;
  public com.tencent.mm.sdk.b.c yCG;
  public com.tencent.mm.sdk.b.c yCH;
  public com.tencent.mm.sdk.b.c yCI;
  
  public d()
  {
    AppMethodBeat.i(51615);
    this.yCF = new e.a()
    {
      public final void t(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51612);
        ae.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        my localmy = new my();
        localmy.dBW.dBU = paramAnonymousInt;
        localmy.dBW.activity = d.this.mActivity;
        localmy.dBW.dmI = d.this.yCC;
        localmy.dBW.dBX = paramAnonymousBundle;
        com.tencent.mm.sdk.b.a.IvT.l(localmy);
        AppMethodBeat.o(51612);
      }
    };
    this.yCG = new com.tencent.mm.sdk.b.c() {};
    this.yCH = new com.tencent.mm.sdk.b.c() {};
    this.yCI = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(51615);
  }
  
  public final void dOi()
  {
    AppMethodBeat.i(51616);
    if (this.yCD != null)
    {
      this.yCD.dQe();
      this.yCD = null;
    }
    this.mActivity = null;
    this.yCC = null;
    AppMethodBeat.o(51616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.d
 * JD-Core Version:    0.7.0.1
 */