package com.tencent.mm.ui;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.extension.reddot.f.a;
import com.tencent.mm.plugin.newtips.a.i.a;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bm;
import com.tencent.mm.y.a.a;

public final class aa
  implements n.b
{
  com.tencent.mm.sdk.b.c<sg> HiJ;
  com.tencent.mm.sdk.b.c HiK;
  MMFragmentActivity Hjt;
  LauncherUI.c HpD;
  c HpE;
  boolean HpF;
  Runnable HpG;
  a HpH;
  a.a HpI;
  n.b HpJ;
  com.tencent.mm.sdk.b.c HpK;
  
  public aa()
  {
    AppMethodBeat.i(33506);
    this.HpG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33490);
        if (!com.tencent.mm.kernel.g.agP().afY())
        {
          ac.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
          AppMethodBeat.o(33490);
          return;
        }
        if (aa.this.HpE == null)
        {
          ac.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
          AppMethodBeat.o(33490);
          return;
        }
        com.tencent.mm.vending.g.g.fxs().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
        {
          private Void n(Integer paramAnonymous2Integer)
          {
            AppMethodBeat.i(33487);
            aa.this.HpE.wl(false);
            aa.this.HpE.Zl(paramAnonymous2Integer.intValue());
            if ((paramAnonymous2Integer.intValue() <= 0) && ((u.axI() & 0x200) == 0) && (com.tencent.mm.bp.a.eJP()) && (com.tencent.mm.bj.d.aJf().bQe() > 0)) {
              aa.this.HpE.wl(true);
            }
            if ((paramAnonymous2Integer.intValue() <= 0) && ((u.axI() & 0x8000) == 0))
            {
              az.ayM();
              if (bs.a((Boolean)com.tencent.mm.model.c.agA().get(68384, null), true))
              {
                az.ayM();
                if (!bs.isNullOrNil((String)com.tencent.mm.model.c.agA().get(68377, null)))
                {
                  aa.this.HpE.wl(true);
                  paramAnonymous2Integer = Jql;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
                az.ayM();
                if (((Boolean)com.tencent.mm.model.c.agA().get(589825, Boolean.FALSE)).booleanValue())
                {
                  aa.this.HpE.wl(true);
                  paramAnonymous2Integer = Jql;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
                Object localObject = com.tencent.mm.kernel.g.agR().agA().get(com.tencent.mm.storage.ah.a.GRs, null);
                if (localObject == null) {}
                for (long l = 0L; (l != 0L) && (((com.tencent.mm.plugin.sns.b.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.n.class)).wK(l)); l = ((Long)localObject).longValue())
                {
                  aa.this.HpE.wl(true);
                  paramAnonymous2Integer = Jql;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
              }
            }
            boolean bool1;
            if (paramAnonymous2Integer.intValue() <= 0)
            {
              if ((u.axB() & 0x400000) != 0L) {
                i = 1;
              }
              while ((i == 0) && (!com.tencent.mm.plugin.subapp.jdbiz.d.eat().eaB()) && (com.tencent.mm.pluginsdk.g.f.DjX != null))
              {
                com.tencent.mm.plugin.subapp.jdbiz.d.eat();
                bool1 = com.tencent.mm.plugin.subapp.jdbiz.d.eav();
                ac.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jdshowFriend ".concat(String.valueOf(bool1)));
                if (bool1)
                {
                  paramAnonymous2Integer = com.tencent.mm.plugin.subapp.jdbiz.d.eat().eay();
                  if ((paramAnonymous2Integer.isStart()) && (!paramAnonymous2Integer.cIm()))
                  {
                    aa.this.HpE.wl(true);
                    paramAnonymous2Integer = Jql;
                    AppMethodBeat.o(33487);
                    return paramAnonymous2Integer;
                    i = 0;
                  }
                  else
                  {
                    ac.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd time is not start or jd time isExpire");
                  }
                }
              }
              paramAnonymous2Integer = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr();
              if (!com.tencent.mm.aw.b.CQ((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null))) {
                break label975;
              }
              ac.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "checkLookVisibility EuropeanUnionCountry");
              if ((((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).aEs("labs_nearbylife")) && (((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).HA("labs_nearbylife")) && (((Boolean)com.tencent.mm.kernel.g.agR().agA().get(com.tencent.mm.storage.ah.a.GRY, Boolean.TRUE)).booleanValue())) {
                aa.this.HpE.wl(true);
              }
              if ((u.axB() & 0x200000) == 0L) {
                break label1037;
              }
              i = 1;
              label572:
              if (i == 0)
              {
                paramAnonymous2Integer = ah.exx();
                if ((paramAnonymous2Integer.BZw == null) || (!paramAnonymous2Integer.BZw.isValid()) || (paramAnonymous2Integer.BZw.BZB != 1)) {
                  break label1042;
                }
                i = 1;
                label610:
                if (i != 0) {
                  aa.this.HpE.wl(true);
                }
              }
              if ((u.axB() & 0x2000000) == 0L) {
                break label1047;
              }
              i = 1;
              label644:
              if (!com.tencent.mm.plugin.ipcall.d.cTZ()) {
                break label1052;
              }
              if ((i == 0) && (!aa.this.HpE.getShowFriendPoint()))
              {
                az.ayM();
                if (((Integer)com.tencent.mm.model.c.agA().get(com.tencent.mm.storage.ah.a.GGB, Integer.valueOf(0))).intValue() >= com.tencent.mm.m.g.ZY().getInt("WCOEntranceRedDot", 0))
                {
                  az.ayM();
                  if (((Boolean)com.tencent.mm.model.c.agA().get(com.tencent.mm.storage.ah.a.GGD, Boolean.FALSE)).booleanValue() != true) {}
                }
                else
                {
                  aa.this.HpE.wl(true);
                }
              }
            }
            label750:
            label765:
            boolean bool2;
            if ((u.axB() & 0x0) == 0L)
            {
              bool1 = true;
              paramAnonymous2Integer = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
              paramAnonymous2Integer = (f.a)com.tencent.mm.plugin.finder.extension.reddot.f.ctL().getValue();
              if ((paramAnonymous2Integer == null) || (!paramAnonymous2Integer.daU)) {
                break label1077;
              }
              bool2 = true;
              label793:
              ac.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "[FinderDiscoveryTab] open=%s result=%s isShow=%s", new Object[] { Boolean.valueOf(bool1), paramAnonymous2Integer, Boolean.valueOf(bool2) });
              if ((bool1) && (paramAnonymous2Integer != null) && (paramAnonymous2Integer.daU)) {
                aa.this.HpE.wl(true);
              }
              az.ayM();
              if ((com.tencent.mm.model.c.agA().getInt(40, 0) & 0x20000) != 0) {
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
              if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("VoiceprintEntry"), 0) == 1) {
                az.ayM();
              }
              for (bool1 = ((Boolean)com.tencent.mm.model.c.agA().get(com.tencent.mm.storage.ah.a.GEz, Boolean.TRUE)).booleanValue();; bool1 = false)
              {
                if ((bool1) && (i != 0))
                {
                  ac.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
                  aa.this.HpE.wm(true);
                }
                aa.this.HpF = false;
                paramAnonymous2Integer = Jql;
                AppMethodBeat.o(33487);
                return paramAnonymous2Integer;
                label975:
                if ((paramAnonymous2Integer == null) || (!paramAnonymous2Integer.eco()) || (!paramAnonymous2Integer.ecp()) || (!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ebZ())) {
                  break;
                }
                aa.this.HpE.wl(true);
                break;
                i = 0;
                break label572;
                i = 0;
                break label610;
                i = 0;
                break label644;
                az.ayM();
                com.tencent.mm.model.c.agA().set(com.tencent.mm.storage.ah.a.GGA, Boolean.FALSE);
                break label750;
                bool1 = false;
                break label765;
                bool2 = false;
                break label793;
              }
            }
          }
        }).b(aa.this.Hjt);
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
    this.HiK = new com.tencent.mm.sdk.b.c() {};
    this.HiJ = new com.tencent.mm.sdk.b.c() {};
    this.HpI = new a.a()
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
      
      public final void b(com.tencent.mm.storage.ah.a paramAnonymousa)
      {
        AppMethodBeat.i(33503);
        if (paramAnonymousa == com.tencent.mm.storage.ah.a.GPM) {
          aa.b(aa.this);
        }
        AppMethodBeat.o(33503);
      }
    };
    this.HpJ = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(33504);
        int i = bs.l(paramAnonymousObject, 0);
        ac.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), paramAnonymousn });
        az.ayM();
        if ((paramAnonymousn != com.tencent.mm.model.c.agA()) || (i <= 0))
        {
          ac.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramAnonymousn });
          AppMethodBeat.o(33504);
          return;
        }
        aa.this.fgV();
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
    this.HpK = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(33506);
  }
  
  public final void ZG(int paramInt)
  {
    AppMethodBeat.i(33513);
    if (this.HpE != null) {
      this.HpE.setTo(paramInt);
    }
    AppMethodBeat.o(33513);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(33512);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ac.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(33512);
      return;
    }
    az.ayM();
    if (paramn == com.tencent.mm.model.c.awG())
    {
      ac.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (ai.ww((String)paramObject)) {
        fgV();
      }
      AppMethodBeat.o(33512);
      return;
    }
    AppMethodBeat.o(33512);
  }
  
  protected final void fgT()
  {
    AppMethodBeat.i(33509);
    com.tencent.mm.blink.b.TR().w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33501);
        if (aa.this.HpF)
        {
          ac.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
          ap.aB(aa.this.HpG);
        }
        AppMethodBeat.o(33501);
      }
    });
    AppMethodBeat.o(33509);
  }
  
  protected final void fgU()
  {
    AppMethodBeat.i(33510);
    if (this.HpF)
    {
      ac.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
      fgZ();
    }
    AppMethodBeat.o(33510);
  }
  
  protected final void fgV()
  {
    AppMethodBeat.i(33508);
    com.tencent.mm.blink.b.TR().w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33500);
        aa.this.HpF = true;
        ap.aB(aa.this.HpG);
        ap.n(aa.this.HpG, 300L);
        AppMethodBeat.o(33500);
      }
    });
    AppMethodBeat.o(33508);
  }
  
  protected final void fgZ()
  {
    AppMethodBeat.i(33507);
    com.tencent.mm.blink.b.TR().w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33499);
        aa.this.HpF = true;
        ap.aB(aa.this.HpG);
        ap.f(aa.this.HpG);
        AppMethodBeat.o(33499);
      }
    });
    AppMethodBeat.o(33507);
  }
  
  public final int fha()
  {
    AppMethodBeat.i(33514);
    int j = 0;
    int i = j;
    if (this.HpE != null)
    {
      i = j;
      if (this.HpE.getMainTabUnread() > 0) {
        i = this.HpE.getMainTabUnread();
      }
    }
    AppMethodBeat.o(33514);
    return i;
  }
  
  static final class a
    implements i.a
  {
    c HpE;
    
    public a(c paramc)
    {
      this.HpE = paramc;
    }
    
    public final void e(com.tencent.mm.plugin.newtips.b.a parama)
    {
      AppMethodBeat.i(33505);
      if ((parama != null) && (parama.field_tipId == com.tencent.mm.plugin.newtips.a.d.vmQ))
      {
        com.tencent.mm.plugin.newtips.a.dke();
        if (com.tencent.mm.plugin.newtips.a.e.Kk(com.tencent.mm.plugin.newtips.a.d.vmQ)) {
          this.HpE.wm(true);
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