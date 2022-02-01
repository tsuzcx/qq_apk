package com.tencent.mm.plugin.webwx.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.g.d;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.wd;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.ac;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class g
  implements be
{
  private f XwK;
  private a XwL;
  private bd XwM;
  private IListener XwN;
  private IListener XwO;
  private ac XwP;
  private cl.a vip;
  
  public g()
  {
    AppMethodBeat.i(30189);
    this.XwK = new f();
    this.vip = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(30183);
        String str = (String)XmlParser.parseXml(w.a(paramAnonymousa.mpN.YFG), "sysmsg", null).get(".sysmsg.pushloginurl.url");
        if (Util.isNullOrNil(str)) {
          Log.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
        }
        wd localwd = new wd();
        localwd.hZN.hZO = str;
        localwd.hZN.type = 1;
        localwd.publish();
        paramAnonymousa.mpN.YFK = null;
        AppMethodBeat.o(30183);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.XwM = new bd()
    {
      public final void onNotifyUserStatusChange()
      {
        AppMethodBeat.i(30184);
        bh.bCz();
        if (c.bzw()) {
          g.iDx();
        }
        AppMethodBeat.o(30184);
      }
    };
    this.XwN = new SubCoreWebWX.3(this, com.tencent.mm.app.f.hfK);
    this.XwO = new SubCoreWebWX.4(this, com.tencent.mm.app.f.hfK);
    this.XwP = new ac() {};
    AppMethodBeat.o(30189);
  }
  
  public static g iDu()
  {
    AppMethodBeat.i(30190);
    bh.bCt();
    g localg2 = (g)ci.Ka("plugin.webwx");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      bh.bCt().a("plugin.webwx", localg1);
    }
    AppMethodBeat.o(30190);
    return localg1;
  }
  
  private static void iDv()
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
  
  public final a iDw()
  {
    AppMethodBeat.i(30194);
    h.baC().aZJ();
    if (this.XwL == null) {
      this.XwL = new a();
    }
    a locala = this.XwL;
    AppMethodBeat.o(30194);
    return locala;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(30192);
    g.d.a(Integer.valueOf(51), this.XwK);
    bh.getSysCmdMsgExtension().a("pushloginurl", this.vip, true);
    bh.bCz();
    c.a(this.XwM);
    this.XwN.alive();
    this.XwO.alive();
    this.XwL = null;
    af.a(5, this.XwP);
    AppMethodBeat.o(30192);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(30191);
    g.d.b(Integer.valueOf(51), this.XwK);
    bh.getSysCmdMsgExtension().b("pushloginurl", this.vip, true);
    bh.bCz();
    c.b(this.XwM);
    this.XwN.dead();
    this.XwO.dead();
    iDv();
    if (this.XwL != null)
    {
      a locala = this.XwL;
      v.bOh().a(locala);
      h.aZW().b(221, locala);
    }
    af.a(this.XwP);
    AppMethodBeat.o(30191);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.model.g
 * JD-Core Version:    0.7.0.1
 */