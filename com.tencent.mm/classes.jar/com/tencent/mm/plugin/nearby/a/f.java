package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.ke;
import com.tencent.mm.h.a.kf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.a;
import java.util.HashMap;

public final class f
  implements ar
{
  private com.tencent.mm.sdk.b.c dmt = new f.5(this);
  private com.tencent.mm.sdk.b.c mCA = new f.1(this);
  private com.tencent.mm.sdk.b.c mCB = new f.2(this);
  com.tencent.mm.pluginsdk.c.c<ke> mCC = new f.3(this);
  com.tencent.mm.pluginsdk.c.c<kf> mCD = new f.4(this);
  d mCE = new f.6(this);
  private bd.a mCF = new f.7(this);
  
  public final void bh(boolean paramBoolean)
  {
    ((j)g.r(j.class)).Fw().a(this.mCF);
    a.udP.c(this.dmt);
    a.udP.c(this.mCB);
    a.udP.c(this.mCC);
    a.udP.c(this.mCD);
    this.mCA.cqo();
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    ((j)g.r(j.class)).Fw().b(this.mCF);
    a.udP.d(this.mCB);
    a.udP.d(this.dmt);
    a.udP.d(this.mCC);
    a.udP.d(this.mCD);
    this.mCA.dead();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.f
 * JD-Core Version:    0.7.0.1
 */