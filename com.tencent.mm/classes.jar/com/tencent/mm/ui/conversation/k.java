package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.t;
import com.tencent.mm.d.i.a;
import com.tencent.mm.g.a.db;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.yf;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.eht;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.z.a;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;

public final class k
  implements com.tencent.mm.ak.i, j
{
  private static boolean Qft = false;
  private com.tencent.mm.ui.widget.a.d Qfn;
  private com.tencent.mm.ui.widget.a.d Qfo;
  private boolean Qfp;
  private com.tencent.mm.compatible.util.f.a Qfq;
  boolean Qfr;
  private com.tencent.mm.modelmulti.f Qfs;
  a Qfu;
  a Qfv;
  IListener Qfw;
  IListener Qfx;
  FLock Qfy;
  Activity dKq;
  ProgressDialog gtM;
  WeakReference<Activity> kRw;
  PowerManager.WakeLock wakeLock;
  
  public k()
  {
    AppMethodBeat.i(38610);
    this.Qfn = null;
    this.Qfo = null;
    this.Qfp = false;
    this.Qfq = new com.tencent.mm.compatible.util.f.a();
    this.wakeLock = null;
    this.Qfr = false;
    this.Qfs = null;
    this.gtM = null;
    this.Qfw = new IListener() {};
    this.Qfx = new IListener() {};
    AppMethodBeat.o(38610);
  }
  
  private boolean aT(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38615);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.w("MicroMsg.InitHelper", "account not ready");
      AppMethodBeat.o(38615);
      return false;
    }
    bg.aVF();
    long l1 = Util.nullAs((Long)com.tencent.mm.model.c.azQ().get(ar.a.NSk, null), 0L);
    bg.aVF();
    long l2 = Util.nullAs((Long)com.tencent.mm.model.c.azQ().get(ar.a.NSm, null), 0L);
    bg.aVF();
    long l3 = Util.nullAs((Long)com.tencent.mm.model.c.azQ().get(ar.a.NSl, null), 0L);
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSk, Long.valueOf(0L));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSl, Long.valueOf(0L));
    if ((l3 == com.tencent.mm.protocal.d.KyO) && (Util.secondsToNow(l2) < 3600L)) {
      if (l1 == 1L)
      {
        if (com.tencent.mm.ui.z.c(this.dKq, 4, -17))
        {
          AppMethodBeat.o(38615);
          return true;
        }
      }
      else if ((l1 == 2L) && (com.tencent.mm.ui.z.c(this.dKq, 4, -16)))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
    {
      Log.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (ac.jOo) {
        MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond() - 86400L - 1L).commit();
      }
      if (com.tencent.mm.ui.z.c(this.dKq, paramInt1, paramInt2))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    AppMethodBeat.o(38615);
    return false;
  }
  
  private void gVS()
  {
    AppMethodBeat.i(38612);
    if (this.Qfp)
    {
      Log.i("MicroMsg.InitHelper", "summerinit doPreCreate but hasTryDoInitButFailed true ret");
      AppMethodBeat.o(38612);
      return;
    }
    if (!this.wakeLock.isHeld())
    {
      Log.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
      this.wakeLock.acquire();
    }
    this.Qfv.gVV();
    db localdb = new db();
    localdb.dGl.action = 1;
    EventCenter.instance.publish(localdb);
    if (this.Qfs == null)
    {
      if (o.DCN != null) {
        o.DCN.eZi();
      }
      this.Qfs = new com.tencent.mm.modelmulti.f(this);
      Log.d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", new Object[] { Long.valueOf(this.Qfq.apr()), Integer.valueOf(this.Qfs.hashCode()) });
      this.Qfq.gLm = SystemClock.elapsedRealtime();
      bg.azz().a(this.Qfs, 0);
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38606);
        long l = k.f(k.this).apr();
        if (k.g(k.this) == null) {}
        for (int i = -2;; i = k.g(k.this).hashCode())
        {
          Log.d("MicroMsg.InitHelper", "dkinit showProgressDlg t:%d initScene:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          if ((k.h(k.this) != null) && (k.h(k.this).isShowing())) {
            k.h(k.this).dismiss();
          }
          k localk = k.this;
          Activity localActivity = k.a(k.this);
          k.a(k.this).getString(2131755998);
          k.a(localk, com.tencent.mm.ui.base.h.a(localActivity, k.a(k.this).getString(2131755887), false, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(38605);
              bg.azz().a(k.g(k.this));
              if (o.DCN != null) {
                o.DCN.eZj();
              }
              AppMethodBeat.o(38605);
            }
          }));
          bg.aAk().setHighPriority();
          AppMethodBeat.o(38606);
          return;
        }
      }
    });
    AppMethodBeat.o(38612);
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(38613);
    if ((paramq == null) || (paramq.getType() != 139))
    {
      AppMethodBeat.o(38613);
      return;
    }
    if (paramInt2 != 0) {}
    for (long l = paramInt1 * 100L / paramInt2;; l = 0L)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38607);
          if (k.h(k.this) != null) {
            k.h(k.this).setMessage(k.a(k.this).getString(2131755887) + this.cJP + "%");
          }
          AppMethodBeat.o(38607);
        }
      });
      AppMethodBeat.o(38613);
      return;
    }
  }
  
  public final void gGx()
  {
    AppMethodBeat.i(234175);
    if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
    {
      Log.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
      this.wakeLock.release();
    }
    AppMethodBeat.o(234175);
  }
  
  final boolean gVR()
  {
    AppMethodBeat.i(38611);
    if (!l.bdN())
    {
      AppMethodBeat.o(38611);
      return false;
    }
    if ((this.Qfo != null) && (this.Qfo.isShowing()))
    {
      AppMethodBeat.o(38611);
      return false;
    }
    com.tencent.mm.kernel.g.aAi();
    if (com.tencent.mm.kernel.g.aAh().azK())
    {
      this.Qfo = new d.a(this.dKq).aoO(2131758264).boo(this.dKq.getString(2131758263)).Dk(false).aoV(2131758265).c(new k.9(this)).aoW(2131758262).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38603);
          com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(38601);
              ao localao = com.tencent.mm.kernel.g.aAh().azQ();
              localao.set(89, Integer.valueOf(2));
              localao.gBI();
              AppMethodBeat.o(38601);
            }
          });
          k.e(k.this).dismiss();
          com.tencent.mm.ui.base.h.a(k.a(k.this), 2131758243, 2131755998, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(38602);
              k.c(k.this);
              AppMethodBeat.o(38602);
            }
          });
          AppMethodBeat.o(38603);
        }
      }).hbn();
      this.Qfo.show();
    }
    for (;;)
    {
      AppMethodBeat.o(38611);
      return true;
      gVS();
    }
  }
  
  final int gVT()
  {
    AppMethodBeat.i(38616);
    if (this.Qfs == null)
    {
      AppMethodBeat.o(38616);
      return -2;
    }
    int i = this.Qfs.hashCode();
    AppMethodBeat.o(38616);
    return i;
  }
  
  public final boolean gVU()
  {
    return this.Qfs != null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(38614);
    if ((paramq.getType() != 138) && (paramq.getType() != 139))
    {
      if ((paramq.getType() != 113) && (paramq.getType() != 0))
      {
        aT(paramInt1, paramInt2, paramq.getType());
        AppMethodBeat.o(38614);
        return;
      }
      Log.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
      AppMethodBeat.o(38614);
      return;
    }
    int j = paramq.getType();
    int k = hashCode();
    int i;
    Object localObject;
    if (this.Qfs == null)
    {
      i = -2;
      Log.i("MicroMsg.InitHelper", "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      if ((this.Qfs != null) && (paramq.getType() == 139))
      {
        this.Qfs = null;
        Log.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", new Object[] { Long.valueOf(this.Qfq.apr()) });
        ay.a.iDq.aVg();
        if (o.DCN != null) {
          o.DCN.eZj();
        }
        this.Qfv.atH();
        localObject = new db();
        ((db)localObject).dGl.action = 2;
        EventCenter.instance.publish((IEvent)localObject);
        if (this.wakeLock.isHeld())
        {
          Log.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
          this.wakeLock.release();
        }
        bg.aAk().setLowPriority();
        if (this.gtM != null)
        {
          this.gtM.dismiss();
          this.gtM = null;
        }
        j = 0;
        localObject = (Activity)this.kRw.get();
        i = j;
        if (com.tencent.mm.kernel.g.aAc())
        {
          i = j;
          if (com.tencent.mm.kernel.g.aAf().hpY)
          {
            i = j;
            if (localObject != null)
            {
              i = j;
              if (!this.dKq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).getBoolean("font_scale_tip_login", false))
              {
                if (1.0F != com.tencent.mm.cb.a.ez(this.dKq)) {
                  break label850;
                }
                if (1.0F == this.dKq.getResources().getConfiguration().fontScale) {
                  break label1428;
                }
                com.tencent.mm.plugin.report.service.h.CyF.a(15181, new Object[] { Integer.valueOf(1) });
                com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a((Context)localObject);
                locala.aC(((Activity)localObject).getResources().getString(2131760902)).bow(((Activity)localObject).getResources().getString(2131760899)).boA(((Activity)localObject).getResources().getString(2131760901)).boB(((Activity)localObject).getResources().getString(2131760900));
                locala.c(new k.12(this, (Activity)localObject)).show();
                this.dKq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
                i = 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.dKq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", false).apply();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bg.aVF();
        localObject = com.tencent.mm.model.c.aSN().Kn(com.tencent.mm.model.z.aTY());
        if ((localObject != null) && ((!com.tencent.mm.contact.c.oR(((ax)localObject).field_type)) || (!Util.isNullOrNil(((ax)localObject).field_conRemark)) || (!Util.isNullOrNil(((ax)localObject).field_conRemarkPYFull)) || (!Util.isNullOrNil(((ax)localObject).field_conRemarkPYShort))))
        {
          ((as)localObject).aqQ();
          ((as)localObject).BD("");
          ((as)localObject).BI("");
          ((as)localObject).BJ("");
          bg.aVF();
          com.tencent.mm.model.c.aSN().c(com.tencent.mm.model.z.aTY(), (as)localObject);
        }
      }
      if (com.tencent.mm.plugin.account.ui.a.a(this.dKq, paramInt1, paramInt2, new Intent().setClass(this.dKq, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        Log.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
        AppMethodBeat.o(38614);
        return;
        i = this.Qfs.hashCode();
        break;
        label850:
        this.dKq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
        i = 1;
        continue;
      }
      if (!bg.aAc())
      {
        Log.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
        AppMethodBeat.o(38614);
        return;
      }
      if (!this.Qfr)
      {
        this.Qfr = true;
        bg.aVF();
        localObject = (String)com.tencent.mm.model.c.azQ().get(5, null);
        bg.aVF();
        if (((Integer)com.tencent.mm.model.c.azQ().get(57, Integer.valueOf(0))).intValue() == 0) {
          break label1125;
        }
      }
      label1125:
      for (i = 1;; i = 0)
      {
        if ((i != 0) && (localObject != null)) {
          com.tencent.mm.ui.base.h.c(this.dKq, this.dKq.getString(2131764380, new Object[] { localObject }), this.dKq.getString(2131755998), this.dKq.getString(2131764382), this.dKq.getString(2131764381), new k.3(this), new k.4(this));
        }
        if ((paramInt1 == 4) && (paramInt2 == -17) && (!Qft))
        {
          p.bdS().tE(7);
          Qft = true;
        }
        if (!aT(paramInt1, paramInt2, paramq.getType())) {
          break;
        }
        Log.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
        AppMethodBeat.o(38614);
        return;
      }
      if (paramq.getType() == 139)
      {
        localObject = new la();
        if ((paramInt1 != 3) || (paramInt2 != -1)) {
          break label1212;
        }
        this.Qfp = true;
        ((la)localObject).dQf.dOz = false;
        EventCenter.instance.publish((IEvent)localObject);
        this.Qfu.gVm();
      }
      while (z.a.a(this.dKq, paramInt1, paramInt2, paramString, 4))
      {
        AppMethodBeat.o(38614);
        return;
        label1212:
        ((la)localObject).dQf.dOz = true;
        EventCenter.instance.publish((IEvent)localObject);
      }
      if (paramq.getType() == 139)
      {
        new MMHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38609);
            p.bdS().tE(5);
            AppMethodBeat.o(38609);
          }
        });
        if ((com.tencent.mm.model.z.aUe() & 0x80) != 0)
        {
          bg.aVF();
          if (com.tencent.mm.model.c.aST().bjY("masssendapp") == null)
          {
            paramString = new az();
            paramString.setUsername("masssendapp");
            paramString.setContent(MMApplicationContext.getContext().getResources().getString(2131757953));
            paramString.yA(Util.nowMilliSecond() + 2000L);
            paramString.nv(0);
            paramString.nt(0);
            bg.aVF();
            com.tencent.mm.model.c.aST().e(paramString);
            paramInt1 = com.tencent.mm.model.z.aUe();
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(40, Integer.valueOf(paramInt1 & 0xFFFFFF7F));
          }
        }
      }
      if ((paramq.getType() == 138) || (paramq.getType() == 139))
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38591);
            in localin = new in();
            localin.dNg.data = "MAIN_UI_EVENT_INIT_FINALLY";
            EventCenter.instance.publish(localin);
            AppMethodBeat.o(38591);
          }
        });
        this.Qfu.gVm();
      }
      AppMethodBeat.o(38614);
      return;
      label1428:
      i = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void atH();
    
    public abstract void gVV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k
 * JD-Core Version:    0.7.0.1
 */