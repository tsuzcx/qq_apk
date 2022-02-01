package com.tencent.mm.ui;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.newtips.a.i.a;
import com.tencent.mm.plugin.sns.b.n;
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
import com.tencent.mm.y.a.a;

public final class ab
  implements MStorageEx.IOnStorageChange
{
  IListener<ts> OAQ;
  IListener OAR;
  LauncherUI.c OIn;
  c OIo;
  private boolean OIp;
  private Runnable OIq;
  a OIr;
  a.a OIs;
  MStorageEx.IOnStorageChange OIt;
  IListener OIu;
  MMFragmentActivity uLr;
  
  public ab()
  {
    AppMethodBeat.i(33506);
    this.OIq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33490);
        if (!com.tencent.mm.kernel.g.aAf().azp())
        {
          Log.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
          AppMethodBeat.o(33490);
          return;
        }
        if (ab.a(ab.this) == null)
        {
          Log.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
          AppMethodBeat.o(33490);
          return;
        }
        com.tencent.mm.vending.g.g.hdG().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
        {
          private Void q(Integer paramAnonymous2Integer)
          {
            AppMethodBeat.i(33487);
            ab.a(ab.this).AT(false);
            ab.a(ab.this).akJ(paramAnonymous2Integer.intValue());
            if ((paramAnonymous2Integer.intValue() <= 0) && ((z.aUl() & 0x8000) == 0))
            {
              bg.aVF();
              if (Util.nullAs((Boolean)com.tencent.mm.model.c.azQ().get(68384, null), true))
              {
                bg.aVF();
                if (!Util.isNullOrNil((String)com.tencent.mm.model.c.azQ().get(68377, null)))
                {
                  ab.a(ab.this).AT(true);
                  paramAnonymous2Integer = QZL;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
                bg.aVF();
                if (((Boolean)com.tencent.mm.model.c.azQ().get(589825, Boolean.FALSE)).booleanValue())
                {
                  ab.a(ab.this).AT(true);
                  paramAnonymous2Integer = QZL;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
                Object localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OgT, null);
                if (localObject == null) {}
                for (long l = 0L; (l != 0L) && (((n)com.tencent.mm.kernel.g.af(n.class)).IM(l)); l = ((Long)localObject).longValue())
                {
                  ab.a(ab.this).AT(true);
                  paramAnonymous2Integer = QZL;
                  AppMethodBeat.o(33487);
                  return paramAnonymous2Integer;
                }
              }
            }
            boolean bool1;
            if (paramAnonymous2Integer.intValue() <= 0)
            {
              if ((z.aUd() & 0x400000) != 0L) {
                i = 1;
              }
              while ((i == 0) && (!com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().fsY()) && (com.tencent.mm.pluginsdk.i.d.JYo != null))
              {
                com.tencent.mm.plugin.subapp.jdbiz.d.fsQ();
                bool1 = com.tencent.mm.plugin.subapp.jdbiz.d.fsS();
                Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jdshowFriend ".concat(String.valueOf(bool1)));
                if (bool1)
                {
                  paramAnonymous2Integer = com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().fsV();
                  if ((paramAnonymous2Integer.isStart()) && (!paramAnonymous2Integer.dMp()))
                  {
                    ab.a(ab.this).AT(true);
                    paramAnonymous2Integer = QZL;
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
              paramAnonymous2Integer = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr();
              if (!com.tencent.mm.aw.b.Pi((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null))) {
                break label928;
              }
              Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "checkLookVisibility EuropeanUnionCountry");
              if ((((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.a.class)).bbE("labs_nearbylife")) && (((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.a.class)).Uw("labs_nearbylife")) && (((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ohy, Boolean.TRUE)).booleanValue())) {
                ab.a(ab.this).AT(true);
              }
              if ((z.aUd() & 0x200000) == 0L) {
                break label990;
              }
              i = 1;
              label524:
              if (i == 0)
              {
                paramAnonymous2Integer = aq.fYk();
                if ((paramAnonymous2Integer.IFk == null) || (!paramAnonymous2Integer.IFk.isValid()) || (paramAnonymous2Integer.IFk.IFp != 1)) {
                  break label995;
                }
                i = 1;
                label562:
                if (i != 0) {
                  ab.a(ab.this).AT(true);
                }
              }
              if ((z.aUd() & 0x2000000) == 0L) {
                break label1000;
              }
              i = 1;
              label596:
              if (!com.tencent.mm.plugin.ipcall.d.dZW()) {
                break label1005;
              }
              if ((i == 0) && (!ab.a(ab.this).getShowFriendPoint()))
              {
                bg.aVF();
                if (((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NVs, Integer.valueOf(0))).intValue() >= com.tencent.mm.n.h.aqJ().getInt("WCOEntranceRedDot", 0))
                {
                  bg.aVF();
                  if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NVu, Boolean.FALSE)).booleanValue() != true) {}
                }
                else
                {
                  ab.a(ab.this).AT(true);
                }
              }
            }
            label702:
            label717:
            boolean bool2;
            if ((z.aUd() & 0x0) == 0L)
            {
              bool1 = true;
              paramAnonymous2Integer = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
              paramAnonymous2Integer = (h.a)com.tencent.mm.plugin.finder.extension.reddot.h.daJ().getValue();
              if ((paramAnonymous2Integer == null) || (!paramAnonymous2Integer.dEF)) {
                break label1030;
              }
              bool2 = true;
              label745:
              Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "[FinderDiscoveryTab] open=%s result=%s isShow=%s", new Object[] { Boolean.valueOf(bool1), paramAnonymous2Integer, Boolean.valueOf(bool2) });
              if ((bool1) && (paramAnonymous2Integer != null) && (paramAnonymous2Integer.dEF)) {
                ab.a(ab.this).AT(true);
              }
              bg.aVF();
              if ((com.tencent.mm.model.c.azQ().getInt(40, 0) & 0x20000) != 0) {
                break label1042;
              }
            }
            label1030:
            label1042:
            for (int i = 1;; i = 0)
            {
              if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VoiceprintEntry"), 0) == 1) {
                bg.aVF();
              }
              for (bool1 = ((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NTp, Boolean.TRUE)).booleanValue();; bool1 = false)
              {
                if ((bool1) && (i != 0))
                {
                  Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
                  ab.a(ab.this).AU(true);
                }
                ab.a(ab.this, false);
                paramAnonymous2Integer = QZL;
                AppMethodBeat.o(33487);
                return paramAnonymous2Integer;
                label928:
                if ((paramAnonymous2Integer == null) || (!paramAnonymous2Integer.fxI()) || (!paramAnonymous2Integer.fxJ()) || (!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxt())) {
                  break;
                }
                ab.a(ab.this).AT(true);
                break;
                label990:
                i = 0;
                break label524;
                label995:
                i = 0;
                break label562;
                label1000:
                i = 0;
                break label596;
                label1005:
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.NVr, Boolean.FALSE);
                break label702;
                bool1 = false;
                break label717;
                bool2 = false;
                break label745;
              }
            }
          }
        }).b(ab.b(ab.this));
        if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.updater.a.a.class)).hasBottomTabRedDot()) {
          ab.a(ab.this).AU(true);
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
    this.OAR = new IListener() {};
    this.OAQ = new IListener() {};
    this.OIs = new a.a()
    {
      public final void D(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(33502);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262156) || (paramAnonymousInt == 262152) || (paramAnonymousInt == 266260) || (paramAnonymousInt == 266267)) {
          ab.e(ab.this);
        }
        if ((paramAnonymousInt == 262147) || (paramAnonymousInt == 262149) || (paramAnonymousInt == 352279) || (paramAnonymousInt == 352280)) {
          ab.e(ab.this);
        }
        AppMethodBeat.o(33502);
      }
      
      public final void b(ar.a paramAnonymousa)
      {
        AppMethodBeat.i(33503);
        if (paramAnonymousa == ar.a.OeY) {
          ab.e(ab.this);
        }
        AppMethodBeat.o(33503);
      }
    };
    this.OIt = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(33504);
        int i = Util.nullAsInt(paramAnonymousObject, 0);
        Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), paramAnonymousMStorageEx });
        bg.aVF();
        if ((paramAnonymousMStorageEx != com.tencent.mm.model.c.azQ()) || (i <= 0))
        {
          Log.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramAnonymousMStorageEx });
          AppMethodBeat.o(33504);
          return;
        }
        ab.this.gJd();
        if (i == 143618)
        {
          ab.d(ab.this);
          AppMethodBeat.o(33504);
          return;
        }
        if ((i == 204817) || (i == 204820)) {
          ab.e(ab.this);
        }
        AppMethodBeat.o(33504);
      }
    };
    this.OIu = new IListener() {};
    AppMethodBeat.o(33506);
  }
  
  public final void alg(int paramInt)
  {
    AppMethodBeat.i(33513);
    if (this.OIo != null) {
      this.OIo.setTo(paramInt);
    }
    AppMethodBeat.o(33513);
  }
  
  protected final void gJb()
  {
    AppMethodBeat.i(33509);
    com.tencent.mm.blink.b.ake().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33501);
        if (ab.f(ab.this))
        {
          Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
          MMHandlerThread.removeRunnable(ab.c(ab.this));
        }
        AppMethodBeat.o(33501);
      }
    });
    AppMethodBeat.o(33509);
  }
  
  protected final void gJc()
  {
    AppMethodBeat.i(33510);
    if (this.OIp)
    {
      Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
      gJg();
    }
    AppMethodBeat.o(33510);
  }
  
  protected final void gJd()
  {
    AppMethodBeat.i(33508);
    com.tencent.mm.blink.b.ake().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33500);
        ab.a(ab.this, true);
        MMHandlerThread.removeRunnable(ab.c(ab.this));
        MMHandlerThread.postToMainThreadDelayed(ab.c(ab.this), 300L);
        AppMethodBeat.o(33500);
      }
    });
    AppMethodBeat.o(33508);
  }
  
  protected final void gJg()
  {
    AppMethodBeat.i(33507);
    com.tencent.mm.blink.b.ake().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33499);
        ab.a(ab.this, true);
        MMHandlerThread.removeRunnable(ab.c(ab.this));
        MMHandlerThread.postToMainThread(ab.c(ab.this));
        AppMethodBeat.o(33499);
      }
    });
    AppMethodBeat.o(33507);
  }
  
  public final int gJh()
  {
    AppMethodBeat.i(33514);
    int j = 0;
    int i = j;
    if (this.OIo != null)
    {
      i = j;
      if (this.OIo.getMainTabUnread() > 0) {
        i = this.OIo.getMainTabUnread();
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
    bg.aVF();
    if (paramMStorageEx == com.tencent.mm.model.c.aST())
    {
      Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (as.IG((String)paramObject)) {
        gJd();
      }
      AppMethodBeat.o(33512);
      return;
    }
    AppMethodBeat.o(33512);
  }
  
  static final class a
    implements i.a
  {
    c OIo;
    
    public a(c paramc)
    {
      this.OIo = paramc;
    }
    
    public final void e(com.tencent.mm.plugin.newtips.b.a parama)
    {
      AppMethodBeat.i(33505);
      if ((parama != null) && (parama.field_tipId == com.tencent.mm.plugin.newtips.a.d.ADb))
      {
        com.tencent.mm.plugin.newtips.a.exo();
        if (com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADb)) {
          this.OIo.AU(true);
        }
      }
      AppMethodBeat.o(33505);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.ab
 * JD-Core Version:    0.7.0.1
 */