package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.d;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.messenger.foundation.a.ac;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class g
  implements be
{
  private f QDS;
  private a QDT;
  private bd QDU;
  private IListener QDV;
  private IListener QDW;
  private ac QDX;
  private ck.a rWY;
  
  public g()
  {
    AppMethodBeat.i(30189);
    this.QDS = new f();
    this.rWY = new g.1(this);
    this.QDU = new bd()
    {
      public final void bez()
      {
        AppMethodBeat.i(30184);
        bh.beI();
        if (c.aGK()) {
          g.hcP();
        }
        AppMethodBeat.o(30184);
      }
    };
    this.QDV = new g.3(this);
    this.QDW = new g.4(this);
    this.QDX = new ac() {};
    AppMethodBeat.o(30189);
  }
  
  public static g hcM()
  {
    AppMethodBeat.i(30190);
    bh.beC();
    g localg2 = (g)ch.RZ("plugin.webwx");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      bh.beC().a("plugin.webwx", localg1);
    }
    AppMethodBeat.o(30190);
    return localg1;
  }
  
  private static void hcN()
  {
    AppMethodBeat.i(30193);
    bh.getNotification().cancel(38);
    AppMethodBeat.o(30193);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final a hcO()
  {
    AppMethodBeat.i(30194);
    h.aHE().aGH();
    if (this.QDT == null) {
      this.QDT = new a();
    }
    a locala = this.QDT;
    AppMethodBeat.o(30194);
    return locala;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(30192);
    h.d.a(Integer.valueOf(51), this.QDS);
    bh.getSysCmdMsgExtension().a("pushloginurl", this.rWY, true);
    bh.beI();
    c.a(this.QDU);
    EventCenter.instance.addListener(this.QDV);
    EventCenter.instance.addListener(this.QDW);
    this.QDT = null;
    af.a(5, this.QDX);
    AppMethodBeat.o(30192);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30191);
    h.d.b(Integer.valueOf(51), this.QDS);
    bh.getSysCmdMsgExtension().b("pushloginurl", this.rWY, true);
    bh.beI();
    c.b(this.QDU);
    EventCenter.instance.removeListener(this.QDV);
    EventCenter.instance.removeListener(this.QDW);
    hcN();
    if (this.QDT != null)
    {
      a locala = this.QDT;
      s.bqB().a(locala);
      h.aGY().b(221, locala);
    }
    af.a(this.QDX);
    AppMethodBeat.o(30191);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g
 * JD-Core Version:    0.7.0.1
 */