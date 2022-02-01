package com.tencent.mm.plugin.scanner.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.pv;
import com.tencent.mm.plugin.scanner.g.f.a;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
{
  String ORr;
  c ORs;
  a ORt;
  f.a ORu;
  public IListener ORv;
  public IListener ORw;
  public IListener ORx;
  Activity mActivity;
  
  public g()
  {
    AppMethodBeat.i(51615);
    this.ORu = new f.a()
    {
      public final void w(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(51612);
        Log.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        pv localpv = new pv();
        localpv.hSZ.hSW = paramAnonymousInt;
        localpv.hSZ.activity = g.this.mActivity;
        localpv.hSZ.hBi = g.this.ORr;
        localpv.hSZ.hTa = paramAnonymousBundle;
        localpv.publish();
        AppMethodBeat.o(51612);
      }
    };
    this.ORv = new ExternRequestDealQBarStrHandler.2(this, f.hfK);
    this.ORw = new ExternRequestDealQBarStrHandler.3(this, f.hfK);
    this.ORx = new ExternRequestDealQBarStrHandler.4(this, f.hfK);
    AppMethodBeat.o(51615);
  }
  
  public final void gQJ()
  {
    AppMethodBeat.i(51616);
    if (this.ORs != null)
    {
      this.ORs.gTL();
      this.ORs = null;
    }
    this.mActivity = null;
    this.ORr = null;
    AppMethodBeat.o(51616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.g
 * JD-Core Version:    0.7.0.1
 */