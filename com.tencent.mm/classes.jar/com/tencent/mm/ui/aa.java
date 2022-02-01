package com.tencent.mm.ui;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.newtips.a.i.a;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.al.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bt;
import com.tencent.mm.y.a.a;

public final class aa
  implements n.b
{
  com.tencent.mm.sdk.b.c<su> JqK;
  com.tencent.mm.sdk.b.c JqL;
  MMFragmentActivity JrI;
  LauncherUI.c JxT;
  c JxU;
  boolean JxV;
  Runnable JxW;
  a JxX;
  a.a JxY;
  n.b JxZ;
  com.tencent.mm.sdk.b.c Jya;
  
  public aa()
  {
    AppMethodBeat.i(33506);
    this.JxW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33490);
        if (!com.tencent.mm.kernel.g.ajP().aiZ())
        {
          ae.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
          AppMethodBeat.o(33490);
          return;
        }
        if (aa.this.JxU == null)
        {
          ae.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
          AppMethodBeat.o(33490);
          return;
        }
        com.tencent.mm.vending.g.g.fSA().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
        {
          private Void p(Integer paramAnonymous2Integer)
          {
            AppMethodBeat.i(33487);
            aa.this.JxU.xf(false);
            aa.this.JxU.acc(paramAnonymous2Integer.intValue());
            if ((paramAnonymous2Integer.intValue() <= 0) && ((v.aAO() & 0x200) == 0) && (com.tencent.mm.bp.a.fcr()) && (com.tencent.mm.bj.d.aMN().bVY() > 0)) {
              aa.this.JxU.xf(true);
            }
            if ((paramAnonymous2Integer.intValue() <= 0) && ((v.aAO() & 0x8000) == 0))
            {
              bc.aCg();
              if (bu.a((Boolean)com.tencent.mm.model.c.ajA().get(68384, null), true))
              {
                bc.aCg();
                if (!bu.isNullOrNil((String)com.tencent.mm.model.c.ajA().get(68377, null)))
                {
                  aa.this.JxU.xf(true);
                  paramAnonymous2Integer = LEs;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
                bc.aCg();
                if (((Boolean)com.tencent.mm.model.c.ajA().get(589825, Boolean.FALSE)).booleanValue())
                {
                  aa.this.JxU.xf(true);
                  paramAnonymous2Integer = LEs;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
                Object localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYw, null);
                if (localObject == null) {}
                for (long l = 0L; (l != 0L) && (((com.tencent.mm.plugin.sns.b.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.n.class)).zI(l)); l = ((Long)localObject).longValue())
                {
                  aa.this.JxU.xf(true);
                  paramAnonymous2Integer = LEs;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
              }
            }
            boolean bool1;
            if (paramAnonymous2Integer.intValue() <= 0)
            {
              if ((v.aAH() & 0x400000) != 0L) {
                i = 1;
              }
              while ((i == 0) && (!com.tencent.mm.plugin.subapp.jdbiz.d.eqr().eqz()) && (com.tencent.mm.pluginsdk.i.g.Fhv != null))
              {
                com.tencent.mm.plugin.subapp.jdbiz.d.eqr();
                bool1 = com.tencent.mm.plugin.subapp.jdbiz.d.eqt();
                ae.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jdshowFriend ".concat(String.valueOf(bool1)));
                if (bool1)
                {
                  paramAnonymous2Integer = com.tencent.mm.plugin.subapp.jdbiz.d.eqr().eqw();
                  if ((paramAnonymous2Integer.isStart()) && (!paramAnonymous2Integer.cTg()))
                  {
                    aa.this.JxU.xf(true);
                    paramAnonymous2Integer = LEs;
                    AppMethodBeat.o(33487);
                    return paramAnonymous2Integer;
                    i = 0;
                  }
                  else
                  {
                    ae.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd time is not start or jd time isExpire");
                  }
                }
              }
              paramAnonymous2Integer = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr();
              if (!com.tencent.mm.aw.b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null))) {
                break label975;
              }
              ae.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "checkLookVisibility EuropeanUnionCountry");
              if ((((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).aLo("labs_nearbylife")) && (((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).Ln("labs_nearbylife")) && (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IZc, Boolean.TRUE)).booleanValue())) {
                aa.this.JxU.xf(true);
              }
              if ((v.aAH() & 0x200000) == 0L) {
                break label1037;
              }
              i = 1;
              label572:
              if (i == 0)
              {
                paramAnonymous2Integer = al.ePX();
                if ((paramAnonymous2Integer.DUp == null) || (!paramAnonymous2Integer.DUp.isValid()) || (paramAnonymous2Integer.DUp.DUu != 1)) {
                  break label1042;
                }
                i = 1;
                label610:
                if (i != 0) {
                  aa.this.JxU.xf(true);
                }
              }
              if ((v.aAH() & 0x2000000) == 0L) {
                break label1047;
              }
              i = 1;
              label644:
              if (!com.tencent.mm.plugin.ipcall.d.dgc()) {
                break label1052;
              }
              if ((i == 0) && (!aa.this.JxU.getShowFriendPoint()))
              {
                bc.aCg();
                if (((Integer)com.tencent.mm.model.c.ajA().get(am.a.INp, Integer.valueOf(0))).intValue() >= com.tencent.mm.n.g.acL().getInt("WCOEntranceRedDot", 0))
                {
                  bc.aCg();
                  if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.INr, Boolean.FALSE)).booleanValue() != true) {}
                }
                else
                {
                  aa.this.JxU.xf(true);
                }
              }
            }
            label750:
            label765:
            boolean bool2;
            if ((v.aAH() & 0x0) == 0L)
            {
              bool1 = true;
              paramAnonymous2Integer = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
              paramAnonymous2Integer = (g.a)com.tencent.mm.plugin.finder.extension.reddot.g.cBx().getValue();
              if ((paramAnonymous2Integer == null) || (!paramAnonymous2Integer.dnq)) {
                break label1077;
              }
              bool2 = true;
              label793:
              ae.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "[FinderDiscoveryTab] open=%s result=%s isShow=%s", new Object[] { Boolean.valueOf(bool1), paramAnonymous2Integer, Boolean.valueOf(bool2) });
              if ((bool1) && (paramAnonymous2Integer != null) && (paramAnonymous2Integer.dnq)) {
                aa.this.JxU.xf(true);
              }
              bc.aCg();
              if ((com.tencent.mm.model.c.ajA().getInt(40, 0) & 0x20000) != 0) {
                break label1089;
              }
            }
            label1037:
            label1042:
            label1047:
            label1052:
            label1077:
            label1089:
            for (int i = 1;; i = 0)
            {
              if (bu.getInt(com.tencent.mm.n.g.acL().getValue("VoiceprintEntry"), 0) == 1) {
                bc.aCg();
              }
              for (bool1 = ((Boolean)com.tencent.mm.model.c.ajA().get(am.a.ILo, Boolean.TRUE)).booleanValue();; bool1 = false)
              {
                if ((bool1) && (i != 0))
                {
                  ae.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
                  aa.this.JxU.xg(true);
                }
                aa.this.JxV = false;
                paramAnonymous2Integer = LEs;
                AppMethodBeat.o(33487);
                return paramAnonymous2Integer;
                label975:
                if ((paramAnonymous2Integer == null) || (!paramAnonymous2Integer.esm()) || (!paramAnonymous2Integer.esn()) || (!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erX())) {
                  break;
                }
                aa.this.JxU.xf(true);
                break;
                i = 0;
                break label572;
                i = 0;
                break label610;
                i = 0;
                break label644;
                bc.aCg();
                com.tencent.mm.model.c.ajA().set(am.a.INo, Boolean.FALSE);
                break label750;
                bool1 = false;
                break label765;
                bool2 = false;
                break label793;
              }
            }
          }
        }).b(aa.this.JrI);
        if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).hasBottomTabRedDot()) {
          aa.this.JxU.xg(true);
        }
        AppMethodBeat.o(33490);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(33491);
        String str = super.toString() + "|setTagRunnable";
        AppMethodBeat.o(33491);
        return str;
      }
    };
    this.JqL = new com.tencent.mm.sdk.b.c() {};
    this.JqK = new com.tencent.mm.sdk.b.c() {};
    this.JxY = new a.a()
    {
      public final void B(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(33502);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262156) || (paramAnonymousInt == 262152) || (paramAnonymousInt == 266260) || (paramAnonymousInt == 266267)) {
          aa.b(aa.this);
        }
        if ((paramAnonymousInt == 262147) || (paramAnonymousInt == 262149) || (paramAnonymousInt == 352279)) {
          aa.b(aa.this);
        }
        AppMethodBeat.o(33502);
      }
      
      public final void b(am.a paramAnonymousa)
      {
        AppMethodBeat.i(33503);
        if (paramAnonymousa == am.a.IWG) {
          aa.b(aa.this);
        }
        AppMethodBeat.o(33503);
      }
    };
    this.JxZ = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(33504);
        int i = bu.m(paramAnonymousObject, 0);
        ae.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), paramAnonymousn });
        bc.aCg();
        if ((paramAnonymousn != com.tencent.mm.model.c.ajA()) || (i <= 0))
        {
          ae.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramAnonymousn });
          AppMethodBeat.o(33504);
          return;
        }
        aa.this.fBj();
        if (i == 143618)
        {
          aa.a(aa.this);
          AppMethodBeat.o(33504);
          return;
        }
        if ((i == 204817) || (i == 204820)) {
          aa.b(aa.this);
        }
        AppMethodBeat.o(33504);
      }
    };
    this.Jya = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(33506);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(33512);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ae.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(33512);
      return;
    }
    bc.aCg();
    if (paramn == com.tencent.mm.model.c.azL())
    {
      ae.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (an.Ac((String)paramObject)) {
        fBj();
      }
      AppMethodBeat.o(33512);
      return;
    }
    AppMethodBeat.o(33512);
  }
  
  public final void acy(int paramInt)
  {
    AppMethodBeat.i(33513);
    if (this.JxU != null) {
      this.JxU.setTo(paramInt);
    }
    AppMethodBeat.o(33513);
  }
  
  protected final void fBh()
  {
    AppMethodBeat.i(33509);
    com.tencent.mm.blink.b.Wq().u(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33501);
        if (aa.this.JxV)
        {
          ae.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
          ar.ay(aa.this.JxW);
        }
        AppMethodBeat.o(33501);
      }
    });
    AppMethodBeat.o(33509);
  }
  
  protected final void fBi()
  {
    AppMethodBeat.i(33510);
    if (this.JxV)
    {
      ae.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
      fBn();
    }
    AppMethodBeat.o(33510);
  }
  
  protected final void fBj()
  {
    AppMethodBeat.i(33508);
    com.tencent.mm.blink.b.Wq().u(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33500);
        aa.this.JxV = true;
        ar.ay(aa.this.JxW);
        ar.o(aa.this.JxW, 300L);
        AppMethodBeat.o(33500);
      }
    });
    AppMethodBeat.o(33508);
  }
  
  protected final void fBn()
  {
    AppMethodBeat.i(33507);
    com.tencent.mm.blink.b.Wq().u(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33499);
        aa.this.JxV = true;
        ar.ay(aa.this.JxW);
        ar.f(aa.this.JxW);
        AppMethodBeat.o(33499);
      }
    });
    AppMethodBeat.o(33507);
  }
  
  public final int fBo()
  {
    AppMethodBeat.i(33514);
    int j = 0;
    int i = j;
    if (this.JxU != null)
    {
      i = j;
      if (this.JxU.getMainTabUnread() > 0) {
        i = this.JxU.getMainTabUnread();
      }
    }
    AppMethodBeat.o(33514);
    return i;
  }
  
  static final class a
    implements i.a
  {
    c JxU;
    
    public a(c paramc)
    {
      this.JxU = paramc;
    }
    
    public final void e(com.tencent.mm.plugin.newtips.b.a parama)
    {
      AppMethodBeat.i(33505);
      if ((parama != null) && (parama.field_tipId == com.tencent.mm.plugin.newtips.a.d.wHR))
      {
        com.tencent.mm.plugin.newtips.a.dxG();
        if (com.tencent.mm.plugin.newtips.a.e.Mr(com.tencent.mm.plugin.newtips.a.d.wHR)) {
          this.JxU.xg(true);
        }
      }
      AppMethodBeat.o(33505);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.aa
 * JD-Core Version:    0.7.0.1
 */