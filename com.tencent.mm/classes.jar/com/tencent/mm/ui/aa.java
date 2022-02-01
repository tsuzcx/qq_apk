package com.tencent.mm.ui;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.newtips.a.i.a;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bs;
import com.tencent.mm.z.a.a;

public final class aa
  implements n.b
{
  com.tencent.mm.sdk.b.c<st> IWc;
  com.tencent.mm.sdk.b.c IWd;
  MMFragmentActivity IXa;
  LauncherUI.c Jdj;
  c Jdk;
  boolean Jdl;
  Runnable Jdm;
  a Jdn;
  a.a Jdo;
  n.b Jdp;
  com.tencent.mm.sdk.b.c Jdq;
  
  public aa()
  {
    AppMethodBeat.i(33506);
    this.Jdm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33490);
        if (!com.tencent.mm.kernel.g.ajA().aiK())
        {
          ad.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
          AppMethodBeat.o(33490);
          return;
        }
        if (aa.this.Jdk == null)
        {
          ad.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
          AppMethodBeat.o(33490);
          return;
        }
        com.tencent.mm.vending.g.g.fOf().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
        {
          private Void o(Integer paramAnonymous2Integer)
          {
            AppMethodBeat.i(33487);
            aa.this.Jdk.wX(false);
            aa.this.Jdk.abu(paramAnonymous2Integer.intValue());
            if ((paramAnonymous2Integer.intValue() <= 0) && ((u.aAy() & 0x200) == 0) && (com.tencent.mm.bq.a.eYD()) && (com.tencent.mm.bk.d.aMp().bUJ() > 0)) {
              aa.this.Jdk.wX(true);
            }
            if ((paramAnonymous2Integer.intValue() <= 0) && ((u.aAy() & 0x8000) == 0))
            {
              ba.aBQ();
              if (bt.a((Boolean)com.tencent.mm.model.c.ajl().get(68384, null), true))
              {
                ba.aBQ();
                if (!bt.isNullOrNil((String)com.tencent.mm.model.c.ajl().get(68377, null)))
                {
                  aa.this.Jdk.wX(true);
                  paramAnonymous2Integer = LhQ;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
                ba.aBQ();
                if (((Boolean)com.tencent.mm.model.c.ajl().get(589825, Boolean.FALSE)).booleanValue())
                {
                  aa.this.Jdk.wX(true);
                  paramAnonymous2Integer = LhQ;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
                Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(com.tencent.mm.storage.al.a.IDW, null);
                if (localObject == null) {}
                for (long l = 0L; (l != 0L) && (((com.tencent.mm.plugin.sns.b.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.n.class)).zk(l)); l = ((Long)localObject).longValue())
                {
                  aa.this.Jdk.wX(true);
                  paramAnonymous2Integer = LhQ;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
              }
            }
            boolean bool1;
            if (paramAnonymous2Integer.intValue() <= 0)
            {
              if ((u.aAr() & 0x400000) != 0L) {
                i = 1;
              }
              while ((i == 0) && (!com.tencent.mm.plugin.subapp.jdbiz.d.emI().emQ()) && (com.tencent.mm.pluginsdk.i.g.EPa != null))
              {
                com.tencent.mm.plugin.subapp.jdbiz.d.emI();
                bool1 = com.tencent.mm.plugin.subapp.jdbiz.d.emK();
                ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jdshowFriend ".concat(String.valueOf(bool1)));
                if (bool1)
                {
                  paramAnonymous2Integer = com.tencent.mm.plugin.subapp.jdbiz.d.emI().emN();
                  if ((paramAnonymous2Integer.isStart()) && (!paramAnonymous2Integer.cQB()))
                  {
                    aa.this.Jdk.wX(true);
                    paramAnonymous2Integer = LhQ;
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
              if (!com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null))) {
                break label975;
              }
              ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "checkLookVisibility EuropeanUnionCountry");
              if ((((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).aJS("labs_nearbylife")) && (((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.a.class)).KN("labs_nearbylife")) && (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(com.tencent.mm.storage.al.a.IEC, Boolean.TRUE)).booleanValue())) {
                aa.this.Jdk.wX(true);
              }
              if ((u.aAr() & 0x200000) == 0L) {
                break label1037;
              }
              i = 1;
              label572:
              if (i == 0)
              {
                paramAnonymous2Integer = al.eMo();
                if ((paramAnonymous2Integer.DCs == null) || (!paramAnonymous2Integer.DCs.isValid()) || (paramAnonymous2Integer.DCs.DCx != 1)) {
                  break label1042;
                }
                i = 1;
                label610:
                if (i != 0) {
                  aa.this.Jdk.wX(true);
                }
              }
              if ((u.aAr() & 0x2000000) == 0L) {
                break label1047;
              }
              i = 1;
              label644:
              if (!com.tencent.mm.plugin.ipcall.d.ddk()) {
                break label1052;
              }
              if ((i == 0) && (!aa.this.Jdk.getShowFriendPoint()))
              {
                ba.aBQ();
                if (((Integer)com.tencent.mm.model.c.ajl().get(com.tencent.mm.storage.al.a.IsT, Integer.valueOf(0))).intValue() >= com.tencent.mm.n.g.acA().getInt("WCOEntranceRedDot", 0))
                {
                  ba.aBQ();
                  if (((Boolean)com.tencent.mm.model.c.ajl().get(com.tencent.mm.storage.al.a.IsV, Boolean.FALSE)).booleanValue() != true) {}
                }
                else
                {
                  aa.this.Jdk.wX(true);
                }
              }
            }
            label750:
            label765:
            boolean bool2;
            if ((u.aAr() & 0x0) == 0L)
            {
              bool1 = true;
              paramAnonymous2Integer = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
              paramAnonymous2Integer = (g.a)com.tencent.mm.plugin.finder.extension.reddot.g.czT().getValue();
              if ((paramAnonymous2Integer == null) || (!paramAnonymous2Integer.dmo)) {
                break label1077;
              }
              bool2 = true;
              label793:
              ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "[FinderDiscoveryTab] open=%s result=%s isShow=%s", new Object[] { Boolean.valueOf(bool1), paramAnonymous2Integer, Boolean.valueOf(bool2) });
              if ((bool1) && (paramAnonymous2Integer != null) && (paramAnonymous2Integer.dmo)) {
                aa.this.Jdk.wX(true);
              }
              ba.aBQ();
              if ((com.tencent.mm.model.c.ajl().getInt(40, 0) & 0x20000) != 0) {
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
              if (bt.getInt(com.tencent.mm.n.g.acA().getValue("VoiceprintEntry"), 0) == 1) {
                ba.aBQ();
              }
              for (bool1 = ((Boolean)com.tencent.mm.model.c.ajl().get(com.tencent.mm.storage.al.a.IqS, Boolean.TRUE)).booleanValue();; bool1 = false)
              {
                if ((bool1) && (i != 0))
                {
                  ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
                  aa.this.Jdk.wY(true);
                }
                aa.this.Jdl = false;
                paramAnonymous2Integer = LhQ;
                AppMethodBeat.o(33487);
                return paramAnonymous2Integer;
                label975:
                if ((paramAnonymous2Integer == null) || (!paramAnonymous2Integer.eoF()) || (!paramAnonymous2Integer.eoG()) || (!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eoq())) {
                  break;
                }
                aa.this.Jdk.wX(true);
                break;
                i = 0;
                break label572;
                i = 0;
                break label610;
                i = 0;
                break label644;
                ba.aBQ();
                com.tencent.mm.model.c.ajl().set(com.tencent.mm.storage.al.a.IsS, Boolean.FALSE);
                break label750;
                bool1 = false;
                break label765;
                bool2 = false;
                break label793;
              }
            }
          }
        }).b(aa.this.IXa);
        if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).hasBottomTabRedDot()) {
          aa.this.Jdk.wY(true);
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
    this.IWd = new com.tencent.mm.sdk.b.c() {};
    this.IWc = new com.tencent.mm.sdk.b.c() {};
    this.Jdo = new a.a()
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
      
      public final void b(com.tencent.mm.storage.al.a paramAnonymousa)
      {
        AppMethodBeat.i(33503);
        if (paramAnonymousa == com.tencent.mm.storage.al.a.ICh) {
          aa.b(aa.this);
        }
        AppMethodBeat.o(33503);
      }
    };
    this.Jdp = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(33504);
        int i = bt.m(paramAnonymousObject, 0);
        ad.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), paramAnonymousn });
        ba.aBQ();
        if ((paramAnonymousn != com.tencent.mm.model.c.ajl()) || (i <= 0))
        {
          ad.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramAnonymousn });
          AppMethodBeat.o(33504);
          return;
        }
        aa.this.fxh();
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
    this.Jdq = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(33506);
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
    ba.aBQ();
    if (paramn == com.tencent.mm.model.c.azv())
    {
      ad.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (am.zs((String)paramObject)) {
        fxh();
      }
      AppMethodBeat.o(33512);
      return;
    }
    AppMethodBeat.o(33512);
  }
  
  public final void abQ(int paramInt)
  {
    AppMethodBeat.i(33513);
    if (this.Jdk != null) {
      this.Jdk.setTo(paramInt);
    }
    AppMethodBeat.o(33513);
  }
  
  protected final void fxf()
  {
    AppMethodBeat.i(33509);
    com.tencent.mm.blink.b.Wi().w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33501);
        if (aa.this.Jdl)
        {
          ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
          aq.aA(aa.this.Jdm);
        }
        AppMethodBeat.o(33501);
      }
    });
    AppMethodBeat.o(33509);
  }
  
  protected final void fxg()
  {
    AppMethodBeat.i(33510);
    if (this.Jdl)
    {
      ad.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
      fxl();
    }
    AppMethodBeat.o(33510);
  }
  
  protected final void fxh()
  {
    AppMethodBeat.i(33508);
    com.tencent.mm.blink.b.Wi().w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33500);
        aa.this.Jdl = true;
        aq.aA(aa.this.Jdm);
        aq.o(aa.this.Jdm, 300L);
        AppMethodBeat.o(33500);
      }
    });
    AppMethodBeat.o(33508);
  }
  
  protected final void fxl()
  {
    AppMethodBeat.i(33507);
    com.tencent.mm.blink.b.Wi().w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33499);
        aa.this.Jdl = true;
        aq.aA(aa.this.Jdm);
        aq.f(aa.this.Jdm);
        AppMethodBeat.o(33499);
      }
    });
    AppMethodBeat.o(33507);
  }
  
  public final int fxm()
  {
    AppMethodBeat.i(33514);
    int j = 0;
    int i = j;
    if (this.Jdk != null)
    {
      i = j;
      if (this.Jdk.getMainTabUnread() > 0) {
        i = this.Jdk.getMainTabUnread();
      }
    }
    AppMethodBeat.o(33514);
    return i;
  }
  
  static final class a
    implements i.a
  {
    c Jdk;
    
    public a(c paramc)
    {
      this.Jdk = paramc;
    }
    
    public final void e(com.tencent.mm.plugin.newtips.b.a parama)
    {
      AppMethodBeat.i(33505);
      if ((parama != null) && (parama.field_tipId == com.tencent.mm.plugin.newtips.a.d.wsi))
      {
        com.tencent.mm.plugin.newtips.a.duq();
        if (com.tencent.mm.plugin.newtips.a.e.LM(com.tencent.mm.plugin.newtips.a.d.wsi)) {
          this.Jdk.wY(true);
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