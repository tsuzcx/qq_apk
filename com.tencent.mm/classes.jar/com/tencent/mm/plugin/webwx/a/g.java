package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ah.e.d;
import com.tencent.mm.ah.p;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.al;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import java.util.HashMap;

public final class g
  implements ar
{
  private bx.a hRv = new g.1(this);
  private f rDG = new f();
  private a rDH;
  private aq rDI = new g.2(this);
  private com.tencent.mm.sdk.b.c rDJ = new g.3(this);
  private s rDK = new g.4(this);
  
  public static g cgZ()
  {
    au.Hq();
    g localg2 = (g)bu.iR("plugin.webwx");
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      au.Hq().a("plugin.webwx", localg1);
    }
    return localg1;
  }
  
  static void cha()
  {
    au.getNotification().cancel(38);
  }
  
  public final void bh(boolean paramBoolean)
  {
    e.d.a(Integer.valueOf(51), this.rDG);
    au.getSysCmdMsgExtension().a("pushloginurl", this.hRv, true);
    au.Hx();
    com.tencent.mm.model.c.a(this.rDI);
    com.tencent.mm.sdk.b.a.udP.c(this.rDJ);
    this.rDH = null;
    u.a(5, this.rDK);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final a chb()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (this.rDH == null) {
      this.rDH = new a();
    }
    return this.rDH;
  }
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    e.d.b(Integer.valueOf(51), this.rDG);
    au.getSysCmdMsgExtension().b("pushloginurl", this.hRv, true);
    au.Hx();
    com.tencent.mm.model.c.b(this.rDI);
    com.tencent.mm.sdk.b.a.udP.d(this.rDJ);
    cha();
    if (this.rDH != null)
    {
      a locala = this.rDH;
      o.Sr().a(locala);
      com.tencent.mm.kernel.g.Dk().b(221, locala);
    }
    u.a(this.rDK);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g
 * JD-Core Version:    0.7.0.1
 */