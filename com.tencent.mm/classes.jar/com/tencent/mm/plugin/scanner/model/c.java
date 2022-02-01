package com.tencent.mm.plugin.scanner.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ay;
import com.tencent.mm.f.a.cv;
import com.tencent.mm.f.a.ol;
import com.tencent.mm.f.a.sk;
import com.tencent.mm.plugin.scanner.g.e.a;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  String IKE;
  com.tencent.mm.plugin.scanner.util.c IKF;
  a IKG;
  e.a IKH;
  public IListener IKI;
  public IListener IKJ;
  public IListener IKK;
  Activity mActivity;
  
  public c()
  {
    AppMethodBeat.i(51615);
    this.IKH = new e.a()
    {
      public final void t(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51612);
        Log.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        ol localol = new ol();
        localol.fNm.fNk = paramAnonymousInt;
        localol.fNm.activity = c.this.mActivity;
        localol.fNm.fwI = c.this.IKE;
        localol.fNm.fNn = paramAnonymousBundle;
        EventCenter.instance.publish(localol);
        AppMethodBeat.o(51612);
      }
    };
    this.IKI = new IListener() {};
    this.IKJ = new IListener() {};
    this.IKK = new IListener() {};
    AppMethodBeat.o(51615);
  }
  
  public final void fCI()
  {
    AppMethodBeat.i(51616);
    if (this.IKF != null)
    {
      this.IKF.fEQ();
      this.IKF = null;
    }
    this.mActivity = null;
    this.IKE = null;
    AppMethodBeat.o(51616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.c
 * JD-Core Version:    0.7.0.1
 */