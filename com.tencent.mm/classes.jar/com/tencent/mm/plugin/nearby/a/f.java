package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.a;
import java.util.HashMap;

public final class f
  implements at
{
  private com.tencent.mm.sdk.b.c edW;
  private com.tencent.mm.sdk.b.c pcr;
  private com.tencent.mm.sdk.b.c pcs;
  com.tencent.mm.pluginsdk.c.c<kr> pct;
  com.tencent.mm.pluginsdk.c.c<ks> pcu;
  d pcv;
  private bd.a pcw;
  private com.tencent.mm.sdk.b.c<mv> pcx;
  private com.tencent.mm.sdk.b.c<kj> pcy;
  
  public f()
  {
    AppMethodBeat.i(55396);
    this.pcr = new f.1(this);
    this.pcs = new f.2(this);
    this.pct = new f.3(this);
    this.pcu = new f.4(this);
    this.edW = new f.5(this);
    this.pcv = new f.6(this);
    this.pcw = new bd.a()
    {
      public final void a(bd paramAnonymousbd, ad paramAnonymousad)
      {
        AppMethodBeat.i(55389);
        if ((paramAnonymousbd != null) && (paramAnonymousad != null) && (paramAnonymousad.NW()))
        {
          g.RJ().QQ();
          ((j)g.E(j.class)).bPN().Tf(paramAnonymousad.field_username);
        }
        AppMethodBeat.o(55389);
      }
    };
    this.pcx = new f.8(this);
    this.pcy = new f.9(this);
    AppMethodBeat.o(55396);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(55398);
    ((j)g.E(j.class)).YA().a(this.pcw);
    this.pcy.alive();
    this.pcx.alive();
    com.tencent.mm.sdk.b.a.ymk.c(this.edW);
    com.tencent.mm.sdk.b.a.ymk.c(this.pcs);
    com.tencent.mm.sdk.b.a.ymk.c(this.pct);
    com.tencent.mm.sdk.b.a.ymk.c(this.pcu);
    this.pcr.alive();
    AppMethodBeat.o(55398);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(55397);
    ((j)g.E(j.class)).YA().b(this.pcw);
    this.pcy.alive();
    this.pcx.dead();
    com.tencent.mm.sdk.b.a.ymk.d(this.pcs);
    com.tencent.mm.sdk.b.a.ymk.d(this.edW);
    com.tencent.mm.sdk.b.a.ymk.d(this.pct);
    com.tencent.mm.sdk.b.a.ymk.d(this.pcu);
    this.pcr.dead();
    AppMethodBeat.o(55397);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.f
 * JD-Core Version:    0.7.0.1
 */