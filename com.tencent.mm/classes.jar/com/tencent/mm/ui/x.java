package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.blink.b;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.x.a.a;

public final class x
  implements n.b
{
  com.tencent.mm.sdk.b.c<qf> yWx;
  com.tencent.mm.sdk.b.c yWy;
  MMFragmentActivity yXg;
  LauncherUI.c zcK;
  c zcL;
  boolean zcM;
  Runnable zcN;
  x.a zcO;
  a.a zcP;
  n.b zcQ;
  com.tencent.mm.sdk.b.c zcR;
  
  public x()
  {
    AppMethodBeat.i(29672);
    this.zcN = new x.1(this);
    this.yWy = new x.4(this);
    this.yWx = new x.5(this);
    this.zcP = new a.a()
    {
      public final void b(ac.a paramAnonymousa)
      {
        AppMethodBeat.i(29669);
        if (paramAnonymousa == ac.a.yIY) {
          x.b(x.this);
        }
        AppMethodBeat.o(29669);
      }
      
      public final void s(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(29668);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262156) || (paramAnonymousInt == 262152) || (paramAnonymousInt == 266260) || (paramAnonymousInt == 266267)) {
          x.b(x.this);
        }
        if ((paramAnonymousInt == 262147) || (paramAnonymousInt == 262149) || (paramAnonymousInt == 352279)) {
          x.b(x.this);
        }
        AppMethodBeat.o(29668);
      }
    };
    this.zcQ = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(29670);
        int i = bo.f(paramAnonymousObject, 0);
        ab.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), paramAnonymousn });
        aw.aaz();
        if ((paramAnonymousn != com.tencent.mm.model.c.Ru()) || (i <= 0))
        {
          ab.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramAnonymousn });
          AppMethodBeat.o(29670);
          return;
        }
        x.this.dCI();
        if (i == 143618)
        {
          x.a(x.this);
          AppMethodBeat.o(29670);
          return;
        }
        if ((i == 204817) || (i == 204820)) {
          x.b(x.this);
        }
        AppMethodBeat.o(29670);
      }
    };
    this.zcR = new x.2(this);
    AppMethodBeat.o(29672);
  }
  
  public final void Oo(int paramInt)
  {
    AppMethodBeat.i(29677);
    if (this.zcL != null)
    {
      this.zcL.NU(paramInt);
      this.zcK.dBQ();
    }
    AppMethodBeat.o(29677);
  }
  
  public final void Op(int paramInt)
  {
    AppMethodBeat.i(29679);
    if (this.zcL != null) {
      this.zcL.setTo(paramInt);
    }
    AppMethodBeat.o(29679);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(29678);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(29678);
      return;
    }
    aw.aaz();
    if (paramn == com.tencent.mm.model.c.YF())
    {
      ab.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (ad.nM((String)paramObject)) {
        dCI();
      }
      AppMethodBeat.o(29678);
      return;
    }
    AppMethodBeat.o(29678);
  }
  
  protected final void dCG()
  {
    AppMethodBeat.i(29675);
    b.HP().o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29667);
        if (x.this.zcM)
        {
          ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
          al.ae(x.this.zcN);
        }
        AppMethodBeat.o(29667);
      }
    });
    AppMethodBeat.o(29675);
  }
  
  protected final void dCH()
  {
    AppMethodBeat.i(29676);
    if (this.zcM)
    {
      ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
      dCM();
    }
    AppMethodBeat.o(29676);
  }
  
  protected final void dCI()
  {
    AppMethodBeat.i(29674);
    b.HP().o(new x.8(this));
    AppMethodBeat.o(29674);
  }
  
  protected final void dCM()
  {
    AppMethodBeat.i(29673);
    b.HP().o(new x.7(this));
    AppMethodBeat.o(29673);
  }
  
  public final int dCN()
  {
    AppMethodBeat.i(29680);
    int j = 0;
    int i = j;
    if (this.zcL != null)
    {
      i = j;
      if (this.zcL.getMainTabUnread() > 0) {
        i = this.zcL.getMainTabUnread();
      }
    }
    AppMethodBeat.o(29680);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.x
 * JD-Core Version:    0.7.0.1
 */