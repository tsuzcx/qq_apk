package com.tencent.mm.plugin.scanner.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.plugin.scanner.d.e.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  Activity mActivity;
  String vOq;
  com.tencent.mm.plugin.scanner.util.c vOr;
  com.tencent.mm.plugin.scanner.util.a vOs;
  e.a vOt;
  public com.tencent.mm.sdk.b.c vOu;
  public com.tencent.mm.sdk.b.c vOv;
  public com.tencent.mm.sdk.b.c vOw;
  
  public c()
  {
    AppMethodBeat.i(51615);
    this.vOt = new e.a()
    {
      public final void r(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51612);
        ad.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        mf localmf = new mf();
        localmf.drs.drq = paramAnonymousInt;
        localmf.drs.activity = c.this.mActivity;
        localmf.drs.dcO = c.this.vOq;
        localmf.drs.drt = paramAnonymousBundle;
        com.tencent.mm.sdk.b.a.ESL.l(localmf);
        AppMethodBeat.o(51612);
      }
    };
    this.vOu = new com.tencent.mm.sdk.b.c() {};
    this.vOv = new com.tencent.mm.sdk.b.c() {};
    this.vOw = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(51615);
  }
  
  public final void dlq()
  {
    AppMethodBeat.i(51616);
    if (this.vOr != null)
    {
      this.vOr.dnf();
      this.vOr = null;
    }
    this.mActivity = null;
    this.vOq = null;
    AppMethodBeat.o(51616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.c
 * JD-Core Version:    0.7.0.1
 */