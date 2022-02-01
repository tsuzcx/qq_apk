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
import com.tencent.mm.R.l;
import com.tencent.mm.an.j;
import com.tencent.mm.an.t;
import com.tencent.mm.d.i.a;
import com.tencent.mm.f.a.df;
import com.tencent.mm.f.a.jd;
import com.tencent.mm.f.a.lr;
import com.tencent.mm.f.a.rb;
import com.tencent.mm.f.a.zm;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.erv;
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
import com.tencent.mm.ui.ac.a;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;

public final class l
  implements com.tencent.mm.an.i, j
{
  private static boolean XCy = false;
  a XCA;
  IListener XCB;
  IListener XCC;
  FLock XCD;
  private com.tencent.mm.ui.widget.a.d XCs;
  private com.tencent.mm.ui.widget.a.d XCt;
  private boolean XCu;
  private com.tencent.mm.compatible.util.f.a XCv;
  boolean XCw;
  private com.tencent.mm.modelmulti.f XCx;
  a XCz;
  Activity fDf;
  ProgressDialog iXX;
  WeakReference<Activity> nLE;
  PowerManager.WakeLock wakeLock;
  
  public l()
  {
    AppMethodBeat.i(38610);
    this.XCs = null;
    this.XCt = null;
    this.XCu = false;
    this.XCv = new com.tencent.mm.compatible.util.f.a();
    this.wakeLock = null;
    this.XCw = false;
    this.XCx = null;
    this.iXX = null;
    this.XCB = new IListener() {};
    this.XCC = new IListener() {};
    AppMethodBeat.o(38610);
  }
  
  private boolean aX(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38615);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.w("MicroMsg.InitHelper", "account not ready");
      AppMethodBeat.o(38615);
      return false;
    }
    bh.beI();
    long l1 = Util.nullAs((Long)com.tencent.mm.model.c.aHp().get(ar.a.Vgi, null), 0L);
    bh.beI();
    long l2 = Util.nullAs((Long)com.tencent.mm.model.c.aHp().get(ar.a.Vgk, null), 0L);
    bh.beI();
    long l3 = Util.nullAs((Long)com.tencent.mm.model.c.aHp().get(ar.a.Vgj, null), 0L);
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgi, Long.valueOf(0L));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgj, Long.valueOf(0L));
    if ((l3 == com.tencent.mm.protocal.d.RAD) && (Util.secondsToNow(l2) < 3600L)) {
      if (l1 == 1L)
      {
        if (com.tencent.mm.ui.ac.c(this.fDf, 4, -17))
        {
          AppMethodBeat.o(38615);
          return true;
        }
      }
      else if ((l1 == 2L) && (com.tencent.mm.ui.ac.c(this.fDf, 4, -16)))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
    {
      Log.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (com.tencent.mm.platformtools.ac.mFx) {
        MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond() - 86400L - 1L).commit();
      }
      if (com.tencent.mm.ui.ac.c(this.fDf, paramInt1, paramInt2))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    AppMethodBeat.o(38615);
    return false;
  }
  
  private void hWq()
  {
    AppMethodBeat.i(38612);
    if (this.XCu)
    {
      Log.i("MicroMsg.InitHelper", "summerinit doPreCreate but hasTryDoInitButFailed true ret");
      AppMethodBeat.o(38612);
      return;
    }
    if (!this.wakeLock.isHeld())
    {
      Log.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
      localObject = this.wakeLock;
      com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/ui/conversation/InitHelper", "doInit", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      ((PowerManager.WakeLock)localObject).acquire();
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/conversation/InitHelper", "doInit", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    }
    this.XCA.hWt();
    Object localObject = new df();
    ((df)localObject).fyV.action = 1;
    EventCenter.instance.publish((IEvent)localObject);
    if (this.XCx == null)
    {
      if (com.tencent.mm.plugin.sns.b.p.JPd != null) {
        com.tencent.mm.plugin.sns.b.p.JPd.fMY();
      }
      this.XCx = new com.tencent.mm.modelmulti.f(this);
      Log.d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", new Object[] { Long.valueOf(this.XCv.avE()), Integer.valueOf(this.XCx.hashCode()) });
      this.XCv.jvB = SystemClock.elapsedRealtime();
      bh.aGY().a(this.XCx, 0);
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38606);
        long l = l.f(l.this).avE();
        if (l.g(l.this) == null) {}
        for (int i = -2;; i = l.g(l.this).hashCode())
        {
          Log.d("MicroMsg.InitHelper", "dkinit showProgressDlg t:%d initScene:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          if ((l.h(l.this) != null) && (l.h(l.this).isShowing())) {
            l.h(l.this).dismiss();
          }
          l locall = l.this;
          Activity localActivity = l.a(l.this);
          l.a(l.this).getString(R.l.app_tip);
          l.a(locall, com.tencent.mm.ui.base.h.a(localActivity, l.a(l.this).getString(R.l.app_loading_data), false, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(38605);
              bh.aGY().a(l.g(l.this));
              if (com.tencent.mm.plugin.sns.b.p.JPd != null) {
                com.tencent.mm.plugin.sns.b.p.JPd.fMZ();
              }
              AppMethodBeat.o(38605);
            }
          }));
          bh.aHJ().setHighPriority();
          AppMethodBeat.o(38606);
          return;
        }
      }
    });
    AppMethodBeat.o(38612);
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.an.q paramq)
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
          if (l.h(l.this) != null) {
            l.h(l.this).setMessage(l.a(l.this).getString(R.l.app_loading_data) + this.cKs + "%");
          }
          AppMethodBeat.o(38607);
        }
      });
      AppMethodBeat.o(38613);
      return;
    }
  }
  
  public final void hFe()
  {
    AppMethodBeat.i(290563);
    if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
    {
      Log.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
      PowerManager.WakeLock localWakeLock = this.wakeLock;
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/ui/conversation/InitHelper", "onTabPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      localWakeLock.release();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/ui/conversation/InitHelper", "onTabPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    }
    AppMethodBeat.o(290563);
  }
  
  final boolean hWp()
  {
    AppMethodBeat.i(38611);
    if (!com.tencent.mm.modelmulti.l.bni())
    {
      AppMethodBeat.o(38611);
      return false;
    }
    if ((this.XCt != null) && (this.XCt.isShowing()))
    {
      AppMethodBeat.o(38611);
      return false;
    }
    com.tencent.mm.kernel.h.aHH();
    if (com.tencent.mm.kernel.h.aHG().aHj())
    {
      this.XCt = new d.a(this.fDf).ayc(R.l.eAU).bBd(this.fDf.getString(R.l.eAT)).HG(false).ayj(R.l.eAV).c(new l.9(this)).ayk(R.l.eAS).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38603);
          com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(38601);
              ao localao = com.tencent.mm.kernel.h.aHG().aHp();
              localao.i(89, Integer.valueOf(2));
              localao.hxT();
              AppMethodBeat.o(38601);
            }
          });
          l.e(l.this).dismiss();
          com.tencent.mm.ui.base.h.a(l.a(l.this), R.l.eAM, R.l.app_tip, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(38602);
              l.c(l.this);
              AppMethodBeat.o(38602);
            }
          });
          AppMethodBeat.o(38603);
        }
      }).icu();
      this.XCt.show();
    }
    for (;;)
    {
      AppMethodBeat.o(38611);
      return true;
      hWq();
    }
  }
  
  final int hWr()
  {
    AppMethodBeat.i(38616);
    if (this.XCx == null)
    {
      AppMethodBeat.o(38616);
      return -2;
    }
    int i = this.XCx.hashCode();
    AppMethodBeat.o(38616);
    return i;
  }
  
  public final boolean hWs()
  {
    return this.XCx != null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(38614);
    if ((paramq.getType() != 138) && (paramq.getType() != 139))
    {
      if ((paramq.getType() != 113) && (paramq.getType() != 0))
      {
        aX(paramInt1, paramInt2, paramq.getType());
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
    if (this.XCx == null)
    {
      i = -2;
      Log.i("MicroMsg.InitHelper", "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      if ((this.XCx != null) && (paramq.getType() == 139))
      {
        this.XCx = null;
        Log.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", new Object[] { Long.valueOf(this.XCv.avE()) });
        az.a.ltq.bej();
        if (com.tencent.mm.plugin.sns.b.p.JPd != null) {
          com.tencent.mm.plugin.sns.b.p.JPd.fMZ();
        }
        this.XCA.aAz();
        localObject = new df();
        ((df)localObject).fyV.action = 2;
        EventCenter.instance.publish((IEvent)localObject);
        if (this.wakeLock.isHeld())
        {
          Log.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
          localObject = this.wakeLock;
          com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/ui/conversation/InitHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          ((PowerManager.WakeLock)localObject).release();
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/conversation/InitHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        }
        bh.aHJ().setLowPriority();
        if (this.iXX != null)
        {
          this.iXX.dismiss();
          this.iXX = null;
        }
        j = 0;
        localObject = (Activity)this.nLE.get();
        i = j;
        if (com.tencent.mm.kernel.h.aHB())
        {
          i = j;
          if (com.tencent.mm.kernel.h.aHE().kbT)
          {
            i = j;
            if (localObject != null)
            {
              i = j;
              if (!this.fDf.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).getBoolean("font_scale_tip_login", false))
              {
                if (1.0F != com.tencent.mm.ci.a.ez(this.fDf)) {
                  break label900;
                }
                if (1.0F == this.fDf.getResources().getConfiguration().fontScale) {
                  break label1478;
                }
                com.tencent.mm.plugin.report.service.h.IzE.a(15181, new Object[] { Integer.valueOf(1) });
                com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a((Context)localObject);
                locala.aR(((Activity)localObject).getResources().getString(R.l.font_scale_adjust_title)).bBl(((Activity)localObject).getResources().getString(R.l.font_scale_adjust_content)).bBp(((Activity)localObject).getResources().getString(R.l.font_scale_adjust_positive_text)).bBq(((Activity)localObject).getResources().getString(R.l.font_scale_adjust_negative_text));
                locala.c(new l.12(this, (Activity)localObject)).show();
                this.fDf.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
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
        this.fDf.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", false).apply();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bh.beI();
        localObject = com.tencent.mm.model.c.bbL().RG(z.bcZ());
        if ((localObject != null) && ((!com.tencent.mm.contact.d.rk(((ax)localObject).field_type)) || (!Util.isNullOrNil(((ax)localObject).field_conRemark)) || (!Util.isNullOrNil(((ax)localObject).field_conRemarkPYFull)) || (!Util.isNullOrNil(((ax)localObject).field_conRemarkPYShort))))
        {
          ((as)localObject).axk();
          ((as)localObject).Ir("");
          ((as)localObject).Iw("");
          ((as)localObject).Ix("");
          bh.beI();
          com.tencent.mm.model.c.bbL().c(z.bcZ(), (as)localObject);
        }
      }
      if (com.tencent.mm.plugin.account.ui.a.a(this.fDf, paramInt1, paramInt2, new Intent().setClass(this.fDf, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        Log.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
        AppMethodBeat.o(38614);
        return;
        i = this.XCx.hashCode();
        break;
        label900:
        this.fDf.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
        i = 1;
        continue;
      }
      if (!bh.aHB())
      {
        Log.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
        AppMethodBeat.o(38614);
        return;
      }
      if (!this.XCw)
      {
        this.XCw = true;
        bh.beI();
        localObject = (String)com.tencent.mm.model.c.aHp().b(5, null);
        bh.beI();
        if (((Integer)com.tencent.mm.model.c.aHp().b(57, Integer.valueOf(0))).intValue() == 0) {
          break label1175;
        }
      }
      label1175:
      for (i = 1;; i = 0)
      {
        if ((i != 0) && (localObject != null)) {
          com.tencent.mm.ui.base.h.c(this.fDf, this.fDf.getString(R.l.regbyfacebook_reg_setpwd_request, new Object[] { localObject }), this.fDf.getString(R.l.app_tip), this.fDf.getString(R.l.regbyfacebook_reg_setpwd_setnow), this.fDf.getString(R.l.regbyfacebook_reg_setpwd_setcancel), new l.3(this), new l.4(this));
        }
        if ((paramInt1 == 4) && (paramInt2 == -17) && (!XCy))
        {
          com.tencent.mm.modelmulti.p.bnn().wE(7);
          XCy = true;
        }
        if (!aX(paramInt1, paramInt2, paramq.getType())) {
          break;
        }
        Log.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
        AppMethodBeat.o(38614);
        return;
      }
      if (paramq.getType() == 139)
      {
        localObject = new lr();
        if ((paramInt1 != 3) || (paramInt2 != -1)) {
          break label1262;
        }
        this.XCu = true;
        ((lr)localObject).fJw.fHK = false;
        EventCenter.instance.publish((IEvent)localObject);
        this.XCz.hVT();
      }
      while (ac.a.a(this.fDf, paramInt1, paramInt2, paramString, 4))
      {
        AppMethodBeat.o(38614);
        return;
        label1262:
        ((lr)localObject).fJw.fHK = true;
        EventCenter.instance.publish((IEvent)localObject);
      }
      if (paramq.getType() == 139)
      {
        new MMHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38609);
            com.tencent.mm.modelmulti.p.bnn().wE(5);
            AppMethodBeat.o(38609);
          }
        });
        if ((z.bdf() & 0x80) != 0)
        {
          bh.beI();
          if (com.tencent.mm.model.c.bbR().bwx("masssendapp") == null)
          {
            paramString = new az();
            paramString.setUsername("masssendapp");
            paramString.setContent(MMApplicationContext.getContext().getResources().getString(R.l.eyE));
            paramString.EB(Util.nowMilliSecond() + 2000L);
            paramString.pJ(0);
            paramString.pH(0);
            bh.beI();
            com.tencent.mm.model.c.bbR().e(paramString);
            paramInt1 = z.bdf();
            bh.beI();
            com.tencent.mm.model.c.aHp().i(40, Integer.valueOf(paramInt1 & 0xFFFFFF7F));
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
            jd localjd = new jd();
            localjd.fGs.data = "MAIN_UI_EVENT_INIT_FINALLY";
            EventCenter.instance.publish(localjd);
            AppMethodBeat.o(38591);
          }
        });
        this.XCz.hVT();
      }
      AppMethodBeat.o(38614);
      return;
      label1478:
      i = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aAz();
    
    public abstract void hWt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l
 * JD-Core Version:    0.7.0.1
 */