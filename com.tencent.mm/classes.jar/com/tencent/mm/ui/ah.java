package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.wl;
import com.tencent.mm.blink.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.extension.reddot.k.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;

public final class ah
  implements MStorageEx.IOnStorageChange
{
  MMFragmentActivity EzS;
  LauncherUI.c adHh;
  k adHi;
  d adHj;
  private boolean adHk;
  private boolean adHl;
  private Runnable adHm;
  ah.a adHn;
  a.a adHo;
  MStorageEx.IOnStorageChange adHp;
  IListener adHq;
  final k.b adHr;
  IListener<wl> adyp;
  IListener adyq;
  
  public ah()
  {
    AppMethodBeat.i(33506);
    this.adHk = false;
    this.adHm = new ah.1(this);
    this.adyq = new MainTabUnreadMgr.2(this, f.hfK);
    this.adyp = new MainTabUnreadMgr.3(this, f.hfK);
    this.adHo = new a.a()
    {
      public final void D(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(33502);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262156) || (paramAnonymousInt == 262152) || (paramAnonymousInt == 266260) || (paramAnonymousInt == 266267)) {
          ah.f(ah.this);
        }
        if ((paramAnonymousInt == 262147) || (paramAnonymousInt == 262149) || (paramAnonymousInt == 352279) || (paramAnonymousInt == 352280)) {
          ah.f(ah.this);
        }
        AppMethodBeat.o(33502);
      }
      
      public final void b(at.a paramAnonymousa)
      {
        AppMethodBeat.i(33503);
        if (paramAnonymousa == at.a.acUP) {
          ah.f(ah.this);
        }
        AppMethodBeat.o(33503);
      }
    };
    this.adHp = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(33504);
        int i = Util.nullAsInt(paramAnonymousObject, 0);
        Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), paramAnonymousMStorageEx });
        bh.bCz();
        if ((paramAnonymousMStorageEx != c.ban()) || (i <= 0))
        {
          Log.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramAnonymousMStorageEx });
          AppMethodBeat.o(33504);
          return;
        }
        ah.this.jki();
        if (i == 143618)
        {
          ah.e(ah.this);
          AppMethodBeat.o(33504);
          return;
        }
        if ((i == 204817) || (i == 204820)) {
          ah.f(ah.this);
        }
        AppMethodBeat.o(33504);
      }
    };
    this.adHq = new MainTabUnreadMgr.10(this, f.hfK);
    this.adHr = new k.b()
    {
      public final void avo(String paramAnonymousString)
      {
        AppMethodBeat.i(369613);
        if (ah.a(ah.this) != null) {
          ah.a(ah.this).aX(true, paramAnonymousString);
        }
        AppMethodBeat.o(369613);
      }
      
      public final boolean dZA()
      {
        AppMethodBeat.i(249090);
        if ((ah.a(ah.this) != null) && (ah.a(ah.this).getFriendTabUnread() <= 0) && (!ah.a(ah.this).getShowFriendPoint()))
        {
          AppMethodBeat.o(249090);
          return true;
        }
        AppMethodBeat.o(249090);
        return false;
      }
      
      public final void dZy()
      {
        AppMethodBeat.i(249096);
        ah.a(ah.this).KT(true);
        AppMethodBeat.o(249096);
      }
      
      public final void dZz()
      {
        AppMethodBeat.i(249099);
        if (ah.a(ah.this) != null) {
          ah.a(ah.this).aX(false, "");
        }
        ah.this.jkl();
        AppMethodBeat.o(249099);
      }
      
      public final boolean eFN()
      {
        AppMethodBeat.i(369612);
        if (ah.a(ah.this) != null)
        {
          AppMethodBeat.o(369612);
          return true;
        }
        AppMethodBeat.o(369612);
        return false;
      }
    };
    AppMethodBeat.o(33506);
  }
  
  public final void aAu(int paramInt)
  {
    AppMethodBeat.i(33513);
    if (this.adHj != null) {
      this.adHj.setTo(paramInt);
    }
    if (this.adHi != null) {
      this.adHi.bXr = paramInt;
    }
    AppMethodBeat.o(33513);
  }
  
  protected final void jkg()
  {
    AppMethodBeat.i(33509);
    b.aJY().arrange(new ah.8(this));
    AppMethodBeat.o(33509);
  }
  
  protected final void jkh()
  {
    AppMethodBeat.i(33510);
    if (this.adHl)
    {
      Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
      jkl();
    }
    AppMethodBeat.o(33510);
  }
  
  protected final void jki()
  {
    AppMethodBeat.i(33508);
    b.aJY().arrange(new ah.7(this));
    AppMethodBeat.o(33508);
  }
  
  protected final void jkl()
  {
    AppMethodBeat.i(33507);
    b.aJY().arrange(new ah.6(this));
    AppMethodBeat.o(33507);
  }
  
  public final int jkm()
  {
    AppMethodBeat.i(33514);
    int j = 0;
    int i = j;
    if (this.adHj != null)
    {
      i = j;
      if (this.adHj.getMainTabUnread() > 0) {
        i = this.adHj.getMainTabUnread();
      }
    }
    AppMethodBeat.o(33514);
    return i;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(33512);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(33512);
      return;
    }
    bh.bCz();
    if (paramMStorageEx == c.bzG())
    {
      Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (au.bwS((String)paramObject)) {
        jki();
      }
      AppMethodBeat.o(33512);
      return;
    }
    AppMethodBeat.o(33512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.ah
 * JD-Core Version:    0.7.0.1
 */