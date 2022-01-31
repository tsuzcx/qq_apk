package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.ai.p;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.an;
import com.tencent.mm.model.as;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import java.util.HashMap;

public final class g
  implements at
{
  private bz.a jKW;
  private f vui;
  private a vuj;
  private as vuk;
  private com.tencent.mm.sdk.b.c vul;
  private s vum;
  
  public g()
  {
    AppMethodBeat.i(26515);
    this.vui = new f();
    this.jKW = new g.1(this);
    this.vuk = new g.2(this);
    this.vul = new g.3(this);
    this.vum = new g.4(this);
    AppMethodBeat.o(26515);
  }
  
  public static g dhh()
  {
    AppMethodBeat.i(26516);
    aw.aat();
    g localg2 = (g)bw.pF("plugin.webwx");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      aw.aat().a("plugin.webwx", localg1);
    }
    AppMethodBeat.o(26516);
    return localg1;
  }
  
  static void dhi()
  {
    AppMethodBeat.i(26519);
    aw.getNotification().cancel(38);
    AppMethodBeat.o(26519);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final a dhj()
  {
    AppMethodBeat.i(26520);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (this.vuj == null) {
      this.vuj = new a();
    }
    a locala = this.vuj;
    AppMethodBeat.o(26520);
    return locala;
  }
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(26518);
    e.d.a(Integer.valueOf(51), this.vui);
    aw.getSysCmdMsgExtension().a("pushloginurl", this.jKW, true);
    aw.aaz();
    com.tencent.mm.model.c.a(this.vuk);
    com.tencent.mm.sdk.b.a.ymk.c(this.vul);
    this.vuj = null;
    v.a(5, this.vum);
    AppMethodBeat.o(26518);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26517);
    e.d.b(Integer.valueOf(51), this.vui);
    aw.getSysCmdMsgExtension().b("pushloginurl", this.jKW, true);
    aw.aaz();
    com.tencent.mm.model.c.b(this.vuk);
    com.tencent.mm.sdk.b.a.ymk.d(this.vul);
    dhi();
    if (this.vuj != null)
    {
      a locala = this.vuj;
      o.alE().a(locala);
      com.tencent.mm.kernel.g.Rc().b(221, locala);
    }
    v.a(this.vum);
    AppMethodBeat.o(26517);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g
 * JD-Core Version:    0.7.0.1
 */