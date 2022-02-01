package com.tencent.mm.ui;

import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.f.a.ls;
import com.tencent.mm.f.a.uv;
import com.tencent.mm.f.a.zp;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.newtips.a.i.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.websearch.api.aq;
import com.tencent.mm.plugin.websearch.api.aq.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.vending.g.g;

public final class ae
  implements MStorageEx.IOnStorageChange
{
  IListener<uv> VUe;
  IListener VUf;
  LauncherUI.c WbI;
  d WbJ;
  private boolean WbK;
  private Runnable WbL;
  a WbM;
  a.a WbN;
  MStorageEx.IOnStorageChange WbO;
  IListener WbP;
  MMFragmentActivity zwS;
  
  public ae()
  {
    AppMethodBeat.i(33506);
    this.WbL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33490);
        if (!com.tencent.mm.kernel.h.aHE().aGM())
        {
          Log.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
          AppMethodBeat.o(33490);
          return;
        }
        if (ae.a(ae.this) == null)
        {
          Log.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
          AppMethodBeat.o(33490);
          return;
        }
        g.ieN().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
        {
          private Void y(Integer paramAnonymous2Integer)
          {
            AppMethodBeat.i(33487);
            ae.a(ae.this).Fi(false);
            ae.a(ae.this).atD(paramAnonymous2Integer.intValue());
            if ((paramAnonymous2Integer.intValue() <= 0) && ((z.bdn() & 0x8000) == 0))
            {
              bh.beI();
              if (Util.nullAs((Boolean)com.tencent.mm.model.c.aHp().b(68384, null), true))
              {
                bh.beI();
                if (!Util.isNullOrNil((String)com.tencent.mm.model.c.aHp().b(68377, null)))
                {
                  ae.a(ae.this).Fi(true);
                  paramAnonymous2Integer = YAb;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
                bh.beI();
                if (((Boolean)com.tencent.mm.model.c.aHp().b(589825, Boolean.FALSE)).booleanValue())
                {
                  ae.a(ae.this).Fi(true);
                  paramAnonymous2Integer = YAb;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
                Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vvj, null);
                if (localObject == null) {}
                for (long l = 0L; (l != 0L) && (((o)com.tencent.mm.kernel.h.ae(o.class)).Qf(l)); l = ((Long)localObject).longValue())
                {
                  ae.a(ae.this).Fi(true);
                  paramAnonymous2Integer = YAb;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
              }
            }
            boolean bool1;
            if (paramAnonymous2Integer.intValue() <= 0)
            {
              if ((z.bde() & 0x400000) != 0L) {
                i = 1;
              }
              while ((i == 0) && (!com.tencent.mm.plugin.subapp.jdbiz.d.ghp().ghx()) && (com.tencent.mm.pluginsdk.j.d.QYQ != null))
              {
                com.tencent.mm.plugin.subapp.jdbiz.d.ghp();
                bool1 = com.tencent.mm.plugin.subapp.jdbiz.d.ghr();
                Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jdshowFriend ".concat(String.valueOf(bool1)));
                if (bool1)
                {
                  paramAnonymous2Integer = com.tencent.mm.plugin.subapp.jdbiz.d.ghp().ghu();
                  if ((paramAnonymous2Integer.isStart()) && (!paramAnonymous2Integer.eqj()))
                  {
                    ae.a(ae.this).Fi(true);
                    paramAnonymous2Integer = YAb;
                    AppMethodBeat.o(33487);
                    return paramAnonymous2Integer;
                    i = 0;
                  }
                  else
                  {
                    Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd time is not start or jd time isExpire");
                  }
                }
              }
              paramAnonymous2Integer = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr();
              if (!com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null))) {
                break label928;
              }
              Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "checkLookVisibility EuropeanUnionCountry");
              if ((((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.a.class)).bnE("labs_nearbylife")) && (((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.a.class)).acg("labs_nearbylife")) && (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvO, Boolean.TRUE)).booleanValue())) {
                ae.a(ae.this).Fi(true);
              }
              if ((z.bde() & 0x200000) == 0L) {
                break label981;
              }
              i = 1;
              label524:
              if (i == 0)
              {
                paramAnonymous2Integer = aq.gQV();
                if ((paramAnonymous2Integer.PzC == null) || (!paramAnonymous2Integer.PzC.isValid()) || (paramAnonymous2Integer.PzC.PzH != 1)) {
                  break label986;
                }
                i = 1;
                label562:
                if (i != 0) {
                  ae.a(ae.this).Fi(true);
                }
              }
              if ((z.bde() & 0x2000000) == 0L) {
                break label991;
              }
              i = 1;
              label596:
              if (!com.tencent.mm.plugin.ipcall.d.eIU()) {
                break label996;
              }
              if ((i == 0) && (!ae.a(ae.this).getShowFriendPoint()))
              {
                bh.beI();
                if (((Integer)com.tencent.mm.model.c.aHp().get(ar.a.Vjs, Integer.valueOf(0))).intValue() >= com.tencent.mm.n.h.axc().getInt("WCOEntranceRedDot", 0))
                {
                  bh.beI();
                  if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vju, Boolean.FALSE)).booleanValue() != true) {}
                }
                else
                {
                  ae.a(ae.this).Fi(true);
                }
              }
            }
            label702:
            label717:
            boolean bool2;
            if ((z.bde() & 0x0) == 0L)
            {
              bool1 = true;
              paramAnonymous2Integer = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
              paramAnonymous2Integer = (h.a)com.tencent.mm.plugin.finder.extension.reddot.h.dqN().getValue();
              if ((paramAnonymous2Integer == null) || (!paramAnonymous2Integer.fxt)) {
                break label1021;
              }
              bool2 = true;
              label745:
              Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "[FinderDiscoveryTab] open=%s result=%s isShow=%s", new Object[] { Boolean.valueOf(bool1), paramAnonymous2Integer, Boolean.valueOf(bool2) });
              if ((bool1) && (paramAnonymous2Integer != null) && (paramAnonymous2Integer.fxt)) {
                ae.a(ae.this).Fi(true);
              }
              bh.beI();
              if ((com.tencent.mm.model.c.aHp().getInt(40, 0) & 0x20000) != 0) {
                break label1033;
              }
            }
            label1033:
            for (int i = 1;; i = 0)
            {
              if (Util.getInt(com.tencent.mm.n.h.axc().getValue("VoiceprintEntry"), 0) == 1) {
                bh.beI();
              }
              for (bool1 = ((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vhp, Boolean.FALSE)).booleanValue();; bool1 = false)
              {
                if ((bool1) && (i != 0))
                {
                  Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
                  ae.a(ae.this).Fj(true);
                }
                ae.a(ae.this, false);
                paramAnonymous2Integer = YAb;
                AppMethodBeat.o(33487);
                return paramAnonymous2Integer;
                label928:
                if ((paramAnonymous2Integer == null) || (!paramAnonymous2Integer.gpE()) || (!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpo())) {
                  break;
                }
                ae.a(ae.this).Fi(true);
                break;
                label981:
                i = 0;
                break label524;
                label986:
                i = 0;
                break label562;
                label991:
                i = 0;
                break label596;
                label996:
                bh.beI();
                com.tencent.mm.model.c.aHp().set(ar.a.Vjr, Boolean.FALSE);
                break label702;
                bool1 = false;
                break label717;
                label1021:
                bool2 = false;
                break label745;
              }
            }
          }
        }).b(ae.b(ae.this));
        if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).hasBottomTabRedDot()) {
          ae.a(ae.this).Fj(true);
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
    this.VUf = new IListener() {};
    this.VUe = new IListener() {};
    this.WbN = new a.a()
    {
      public final void E(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(33502);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262156) || (paramAnonymousInt == 262152) || (paramAnonymousInt == 266260) || (paramAnonymousInt == 266267)) {
          ae.e(ae.this);
        }
        if ((paramAnonymousInt == 262147) || (paramAnonymousInt == 262149) || (paramAnonymousInt == 352279) || (paramAnonymousInt == 352280)) {
          ae.e(ae.this);
        }
        AppMethodBeat.o(33502);
      }
      
      public final void b(ar.a paramAnonymousa)
      {
        AppMethodBeat.i(33503);
        if (paramAnonymousa == ar.a.Vtk) {
          ae.e(ae.this);
        }
        AppMethodBeat.o(33503);
      }
    };
    this.WbO = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(33504);
        int i = Util.nullAsInt(paramAnonymousObject, 0);
        Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), paramAnonymousMStorageEx });
        bh.beI();
        if ((paramAnonymousMStorageEx != com.tencent.mm.model.c.aHp()) || (i <= 0))
        {
          Log.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramAnonymousMStorageEx });
          AppMethodBeat.o(33504);
          return;
        }
        ae.this.hIb();
        if (i == 143618)
        {
          ae.d(ae.this);
          AppMethodBeat.o(33504);
          return;
        }
        if ((i == 204817) || (i == 204820)) {
          ae.e(ae.this);
        }
        AppMethodBeat.o(33504);
      }
    };
    this.WbP = new IListener() {};
    AppMethodBeat.o(33506);
  }
  
  public final void aud(int paramInt)
  {
    AppMethodBeat.i(33513);
    if (this.WbJ != null) {
      this.WbJ.setTo(paramInt);
    }
    AppMethodBeat.o(33513);
  }
  
  protected final void hHZ()
  {
    AppMethodBeat.i(33509);
    com.tencent.mm.blink.b.aqa().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33501);
        if (ae.f(ae.this))
        {
          Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
          MMHandlerThread.removeRunnable(ae.c(ae.this));
        }
        AppMethodBeat.o(33501);
      }
    });
    AppMethodBeat.o(33509);
  }
  
  protected final void hIa()
  {
    AppMethodBeat.i(33510);
    if (this.WbK)
    {
      Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
      hIe();
    }
    AppMethodBeat.o(33510);
  }
  
  protected final void hIb()
  {
    AppMethodBeat.i(33508);
    com.tencent.mm.blink.b.aqa().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33500);
        ae.a(ae.this, true);
        MMHandlerThread.removeRunnable(ae.c(ae.this));
        MMHandlerThread.postToMainThreadDelayed(ae.c(ae.this), 300L);
        AppMethodBeat.o(33500);
      }
    });
    AppMethodBeat.o(33508);
  }
  
  protected final void hIe()
  {
    AppMethodBeat.i(33507);
    com.tencent.mm.blink.b.aqa().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33499);
        ae.a(ae.this, true);
        MMHandlerThread.removeRunnable(ae.c(ae.this));
        MMHandlerThread.postToMainThread(ae.c(ae.this));
        AppMethodBeat.o(33499);
      }
    });
    AppMethodBeat.o(33507);
  }
  
  public final int hIf()
  {
    AppMethodBeat.i(33514);
    int j = 0;
    int i = j;
    if (this.WbJ != null)
    {
      i = j;
      if (this.WbJ.getMainTabUnread() > 0) {
        i = this.WbJ.getMainTabUnread();
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
    bh.beI();
    if (paramMStorageEx == com.tencent.mm.model.c.bbR())
    {
      Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (as.PY((String)paramObject)) {
        hIb();
      }
      AppMethodBeat.o(33512);
      return;
    }
    AppMethodBeat.o(33512);
  }
  
  static final class a
    implements i.a
  {
    d WbJ;
    
    public a(d paramd)
    {
      this.WbJ = paramd;
    }
    
    public final void e(com.tencent.mm.plugin.newtips.b.a parama)
    {
      AppMethodBeat.i(33505);
      if ((parama != null) && (parama.field_tipId == com.tencent.mm.plugin.newtips.a.d.Gwf))
      {
        com.tencent.mm.plugin.newtips.a.fiR();
        if (com.tencent.mm.plugin.newtips.a.e.aal(com.tencent.mm.plugin.newtips.a.d.Gwf)) {
          this.WbJ.Fj(true);
        }
      }
      AppMethodBeat.o(33505);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.ae
 * JD-Core Version:    0.7.0.1
 */