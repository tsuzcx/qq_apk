package com.tencent.mm.ui;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.plugin.newtips.a.i.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.aj.a;
import com.tencent.mm.pluginsdk.g.f;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bj;
import com.tencent.mm.z.a.a;

public final class z
  implements n.b
{
  com.tencent.mm.sdk.b.c<rx> FJC;
  com.tencent.mm.sdk.b.c FJD;
  MMFragmentActivity FKl;
  LauncherUI.c FPS;
  c FPT;
  boolean FPU;
  Runnable FPV;
  a FPW;
  a.a FPX;
  n.b FPY;
  com.tencent.mm.sdk.b.c FPZ;
  
  public z()
  {
    AppMethodBeat.i(33506);
    this.FPV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33490);
        if (!com.tencent.mm.kernel.g.afz().aeI())
        {
          ad.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
          AppMethodBeat.o(33490);
          return;
        }
        if (z.this.FPT == null)
        {
          ad.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
          AppMethodBeat.o(33490);
          return;
        }
        com.tencent.mm.vending.g.g.fhq().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
        {
          private Void m(Integer paramAnonymous2Integer)
          {
            AppMethodBeat.i(33487);
            z.this.FPT.vj(false);
            z.this.FPT.Xb(paramAnonymous2Integer.intValue());
            if ((paramAnonymous2Integer.intValue() <= 0) && ((u.aqS() & 0x200) == 0) && (com.tencent.mm.bq.a.euw()) && (com.tencent.mm.bk.d.aCp().bIR() > 0)) {
              z.this.FPT.vj(true);
            }
            if ((paramAnonymous2Integer.intValue() <= 0) && ((u.aqS() & 0x8000) == 0))
            {
              az.arV();
              if (bt.a((Boolean)com.tencent.mm.model.c.afk().get(68384, null), true))
              {
                az.arV();
                if (!bt.isNullOrNil((String)com.tencent.mm.model.c.afk().get(68377, null)))
                {
                  z.this.FPT.vj(true);
                  paramAnonymous2Integer = HPQ;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
                az.arV();
                if (((Boolean)com.tencent.mm.model.c.afk().get(589825, Boolean.FALSE)).booleanValue())
                {
                  z.this.FPT.vj(true);
                  paramAnonymous2Integer = HPQ;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
                Object localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fty, null);
                if (localObject == null) {}
                for (long l = 0L; (l != 0L) && (((com.tencent.mm.plugin.sns.c.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.c.n.class)).sh(l)); l = ((Long)localObject).longValue())
                {
                  z.this.FPT.vj(true);
                  paramAnonymous2Integer = HPQ;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
              }
            }
            boolean bool1;
            if (paramAnonymous2Integer.intValue() <= 0)
            {
              if ((u.aqL() & 0x400000) != 0L) {
                i = 1;
              }
              while ((i == 0) && (!com.tencent.mm.plugin.subapp.jdbiz.d.dLT().dMb()) && (f.BRH != null))
              {
                com.tencent.mm.plugin.subapp.jdbiz.d.dLT();
                bool1 = com.tencent.mm.plugin.subapp.jdbiz.d.dLV();
                ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jdshowFriend ".concat(String.valueOf(bool1)));
                if (bool1)
                {
                  paramAnonymous2Integer = com.tencent.mm.plugin.subapp.jdbiz.d.dLT().dLY();
                  if ((paramAnonymous2Integer.isStart()) && (!paramAnonymous2Integer.cva()))
                  {
                    z.this.FPT.vj(true);
                    paramAnonymous2Integer = HPQ;
                    AppMethodBeat.o(33487);
                    return paramAnonymous2Integer;
                    i = 0;
                  }
                  else
                  {
                    ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd time is not start or jd time isExpire");
                  }
                }
              }
              paramAnonymous2Integer = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr();
              if (!com.tencent.mm.ax.b.yL((String)com.tencent.mm.kernel.g.afB().afk().get(274436, null))) {
                break label975;
              }
              ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "checkLookVisibility EuropeanUnionCountry");
              if ((((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).azb("labs_nearbylife")) && (((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).Dx("labs_nearbylife")) && (((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fue, Boolean.TRUE)).booleanValue())) {
                z.this.FPT.vj(true);
              }
              if ((u.aqL() & 0x200000) == 0L) {
                break label1037;
              }
              i = 1;
              label572:
              if (i == 0)
              {
                paramAnonymous2Integer = aj.eid();
                if ((paramAnonymous2Integer.AHf == null) || (!paramAnonymous2Integer.AHf.isValid()) || (paramAnonymous2Integer.AHf.AHk != 1)) {
                  break label1042;
                }
                i = 1;
                label610:
                if (i != 0) {
                  z.this.FPT.vj(true);
                }
              }
              if ((u.aqL() & 0x2000000) == 0L) {
                break label1047;
              }
              i = 1;
              label644:
              if (!com.tencent.mm.plugin.ipcall.d.cGO()) {
                break label1052;
              }
              if ((i == 0) && (!z.this.FPT.getShowFriendPoint()))
              {
                az.arV();
                if (((Integer)com.tencent.mm.model.c.afk().get(ae.a.FiM, Integer.valueOf(0))).intValue() >= com.tencent.mm.m.g.Zd().getInt("WCOEntranceRedDot", 0))
                {
                  az.arV();
                  if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FiO, Boolean.FALSE)).booleanValue() != true) {}
                }
                else
                {
                  z.this.FPT.vj(true);
                }
              }
            }
            label750:
            label765:
            boolean bool2;
            if ((u.aqL() & 0x0) == 0L)
            {
              bool1 = true;
              paramAnonymous2Integer = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
              paramAnonymous2Integer = (d.a)com.tencent.mm.plugin.finder.extension.reddot.d.clp().getValue();
              if ((paramAnonymous2Integer == null) || (!paramAnonymous2Integer.ddw)) {
                break label1077;
              }
              bool2 = true;
              label793:
              ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "[FinderDiscoveryTab] open=%s result=%s isShow=%s", new Object[] { Boolean.valueOf(bool1), paramAnonymous2Integer, Boolean.valueOf(bool2) });
              if ((bool1) && (paramAnonymous2Integer != null) && (paramAnonymous2Integer.ddw)) {
                z.this.FPT.vj(true);
              }
              az.arV();
              if ((com.tencent.mm.model.c.afk().getInt(40, 0) & 0x20000) != 0) {
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
              if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("VoiceprintEntry"), 0) == 1) {
                az.arV();
              }
              for (bool1 = ((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FgL, Boolean.TRUE)).booleanValue();; bool1 = false)
              {
                if ((bool1) && (i != 0))
                {
                  ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
                  z.this.FPT.vk(true);
                }
                z.this.FPU = false;
                paramAnonymous2Integer = HPQ;
                AppMethodBeat.o(33487);
                return paramAnonymous2Integer;
                label975:
                if ((paramAnonymous2Integer == null) || (!paramAnonymous2Integer.dNO()) || (!paramAnonymous2Integer.dNP()) || (!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNz())) {
                  break;
                }
                z.this.FPT.vj(true);
                break;
                i = 0;
                break label572;
                i = 0;
                break label610;
                i = 0;
                break label644;
                az.arV();
                com.tencent.mm.model.c.afk().set(ae.a.FiL, Boolean.FALSE);
                break label750;
                bool1 = false;
                break label765;
                bool2 = false;
                break label793;
              }
            }
          }
        }).b(z.this.FKl);
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
    this.FJD = new com.tencent.mm.sdk.b.c() {};
    this.FJC = new com.tencent.mm.sdk.b.c() {};
    this.FPX = new a.a()
    {
      public final void B(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(33502);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262156) || (paramAnonymousInt == 262152) || (paramAnonymousInt == 266260) || (paramAnonymousInt == 266267)) {
          z.b(z.this);
        }
        if ((paramAnonymousInt == 262147) || (paramAnonymousInt == 262149) || (paramAnonymousInt == 352279)) {
          z.b(z.this);
        }
        AppMethodBeat.o(33502);
      }
      
      public final void b(ae.a paramAnonymousa)
      {
        AppMethodBeat.i(33503);
        if (paramAnonymousa == ae.a.FrW) {
          z.b(z.this);
        }
        AppMethodBeat.o(33503);
      }
    };
    this.FPY = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(33504);
        int i = bt.i(paramAnonymousObject, 0);
        ad.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), paramAnonymousn });
        az.arV();
        if ((paramAnonymousn != com.tencent.mm.model.c.afk()) || (i <= 0))
        {
          ad.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramAnonymousn });
          AppMethodBeat.o(33504);
          return;
        }
        z.this.eRm();
        if (i == 143618)
        {
          z.a(z.this);
          AppMethodBeat.o(33504);
          return;
        }
        if ((i == 204817) || (i == 204820)) {
          z.b(z.this);
        }
        AppMethodBeat.o(33504);
      }
    };
    this.FPZ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(33506);
  }
  
  public final void Xu(int paramInt)
  {
    AppMethodBeat.i(33511);
    if (this.FPT != null)
    {
      this.FPT.WZ(paramInt);
      this.FPS.eQo();
    }
    AppMethodBeat.o(33511);
  }
  
  public final void Xv(int paramInt)
  {
    AppMethodBeat.i(33513);
    if (this.FPT != null) {
      this.FPT.setTo(paramInt);
    }
    AppMethodBeat.o(33513);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(33512);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(33512);
      return;
    }
    az.arV();
    if (paramn == com.tencent.mm.model.c.apR())
    {
      ad.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (af.st((String)paramObject)) {
        eRm();
      }
      AppMethodBeat.o(33512);
      return;
    }
    AppMethodBeat.o(33512);
  }
  
  protected final void eRk()
  {
    AppMethodBeat.i(33509);
    com.tencent.mm.blink.b.SX().v(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33501);
        if (z.this.FPU)
        {
          ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
          aq.az(z.this.FPV);
        }
        AppMethodBeat.o(33501);
      }
    });
    AppMethodBeat.o(33509);
  }
  
  protected final void eRl()
  {
    AppMethodBeat.i(33510);
    if (this.FPU)
    {
      ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
      eRq();
    }
    AppMethodBeat.o(33510);
  }
  
  protected final void eRm()
  {
    AppMethodBeat.i(33508);
    com.tencent.mm.blink.b.SX().v(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33500);
        z.this.FPU = true;
        aq.az(z.this.FPV);
        aq.n(z.this.FPV, 300L);
        AppMethodBeat.o(33500);
      }
    });
    AppMethodBeat.o(33508);
  }
  
  protected final void eRq()
  {
    AppMethodBeat.i(33507);
    com.tencent.mm.blink.b.SX().v(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33499);
        z.this.FPU = true;
        aq.az(z.this.FPV);
        aq.f(z.this.FPV);
        AppMethodBeat.o(33499);
      }
    });
    AppMethodBeat.o(33507);
  }
  
  public final int eRr()
  {
    AppMethodBeat.i(33514);
    int j = 0;
    int i = j;
    if (this.FPT != null)
    {
      i = j;
      if (this.FPT.getMainTabUnread() > 0) {
        i = this.FPT.getMainTabUnread();
      }
    }
    AppMethodBeat.o(33514);
    return i;
  }
  
  static final class a
    implements i.a
  {
    c FPT;
    
    public a(c paramc)
    {
      this.FPT = paramc;
    }
    
    public final void e(com.tencent.mm.plugin.newtips.b.a parama)
    {
      AppMethodBeat.i(33505);
      if ((parama != null) && (parama.field_tipId == com.tencent.mm.plugin.newtips.a.d.udR))
      {
        com.tencent.mm.plugin.newtips.a.cWv();
        if (com.tencent.mm.plugin.newtips.a.e.Il(com.tencent.mm.plugin.newtips.a.d.udR)) {
          this.FPT.vk(true);
        }
      }
      AppMethodBeat.o(33505);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.z
 * JD-Core Version:    0.7.0.1
 */