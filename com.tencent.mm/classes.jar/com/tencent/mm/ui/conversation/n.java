package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.dp;
import com.tencent.mm.autogen.a.ke;
import com.tencent.mm.autogen.a.mw;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelmulti.u;
import com.tencent.mm.modelmulti.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.g.a;
import java.lang.ref.WeakReference;

public final class n
  implements com.tencent.mm.am.h, com.tencent.mm.am.i
{
  private static boolean afpZ = false;
  private e Oxn;
  private e afpU;
  private boolean afpV;
  private f.a afpW;
  private boolean afpX;
  private com.tencent.mm.modelmulti.k afpY;
  private a afqa;
  private m afqb;
  private a afqc;
  IListener afqd;
  IListener afqe;
  FLock afqf;
  private Activity hHU;
  ProgressDialog lzP;
  private WeakReference<Activity> qLs;
  PowerManager.WakeLock wakeLock;
  
  public n()
  {
    AppMethodBeat.i(38610);
    this.Oxn = null;
    this.afpU = null;
    this.afpV = false;
    this.afpW = new f.a();
    this.wakeLock = null;
    this.afpX = false;
    this.afpY = null;
    this.lzP = null;
    this.afqd = new InitHelper.1(this, com.tencent.mm.app.f.hfK);
    this.afqe = new InitHelper.2(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(38610);
  }
  
  private boolean by(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38615);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.w("MicroMsg.InitHelper", "account not ready");
      AppMethodBeat.o(38615);
      return false;
    }
    bh.bCz();
    long l1 = Util.nullAs((Long)c.ban().get(at.a.acHx, null), 0L);
    bh.bCz();
    long l2 = Util.nullAs((Long)c.ban().get(at.a.acHz, null), 0L);
    bh.bCz();
    long l3 = Util.nullAs((Long)c.ban().get(at.a.acHy, null), 0L);
    bh.bCz();
    c.ban().set(at.a.acHx, Long.valueOf(0L));
    bh.bCz();
    c.ban().set(at.a.acHy, Long.valueOf(0L));
    if ((l3 == com.tencent.mm.protocal.d.Yxh) && (Util.secondsToNow(l2) < 3600L)) {
      if (l1 == 1L)
      {
        if (ae.d(this.hHU, 4, -17))
        {
          AppMethodBeat.o(38615);
          return true;
        }
      }
      else if ((l1 == 2L) && (ae.d(this.hHU, 4, -16)))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
    {
      Log.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (com.tencent.mm.platformtools.z.pBY) {
        MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond() - 86400L - 1L).commit();
      }
      if (ae.d(this.hHU, paramInt1, paramInt2))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    AppMethodBeat.o(38615);
    return false;
  }
  
  private void jAE()
  {
    AppMethodBeat.i(38612);
    if (this.afpV)
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
    this.afqc.jAI();
    Object localObject = new dp();
    ((dp)localObject).hDE.action = 1;
    ((dp)localObject).publish();
    if (this.afpY == null)
    {
      if (com.tencent.mm.plugin.sns.c.q.Qki != null) {
        com.tencent.mm.plugin.sns.c.q.Qki.hee();
      }
      this.afpY = new com.tencent.mm.modelmulti.k(this);
      Log.d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", new Object[] { Long.valueOf(this.afpW.aPY()), Integer.valueOf(this.afpY.hashCode()) });
      this.afpW.lYS = SystemClock.elapsedRealtime();
      bh.aZW().a(this.afpY, 0);
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38606);
        long l = n.f(n.this).aPY();
        if (n.g(n.this) == null) {}
        for (int i = -2;; i = n.g(n.this).hashCode())
        {
          Log.d("MicroMsg.InitHelper", "dkinit showProgressDlg t:%d initScene:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          if ((n.h(n.this) != null) && (n.h(n.this).isShowing())) {
            n.h(n.this).dismiss();
          }
          n localn = n.this;
          Activity localActivity = n.a(n.this);
          n.a(n.this).getString(R.l.app_tip);
          n.a(localn, com.tencent.mm.ui.base.k.a(localActivity, n.a(n.this).getString(R.l.app_loading_data), false, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(38605);
              bh.aZW().a(n.g(n.this));
              if (com.tencent.mm.plugin.sns.c.q.Qki != null) {
                com.tencent.mm.plugin.sns.c.q.Qki.hef();
              }
              AppMethodBeat.o(38605);
            }
          }));
          bh.baH().setHighPriority();
          AppMethodBeat.o(38606);
          return;
        }
      }
    });
    AppMethodBeat.o(38612);
  }
  
  public final void a(int paramInt1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(38613);
    if ((paramp == null) || (paramp.getType() != 139))
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
          if (n.h(n.this) != null) {
            n.h(n.this).setMessage(n.a(n.this).getString(R.l.app_loading_data) + this.eEd + "%");
          }
          AppMethodBeat.o(38607);
        }
      });
      AppMethodBeat.o(38613);
      return;
    }
  }
  
  public final void a(Activity paramActivity, a parama, m paramm, a parama1)
  {
    AppMethodBeat.i(256929);
    Log.i("MicroMsg.InitHelper", "onCreate %s", new Object[] { Integer.valueOf(paramActivity.hashCode()) });
    this.hHU = paramActivity;
    this.afqa = parama;
    this.afqb = paramm;
    this.afqc = parama1;
    this.qLs = new WeakReference(paramActivity);
    this.wakeLock = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
    bh.aZW().a(-1, this);
    this.afpX = false;
    this.afqd.alive();
    this.afqe.alive();
    com.tencent.threadpool.h.ahAA.g(new n..ExternalSyntheticLambda0(this), "InitHelper-Report");
    AppMethodBeat.o(256929);
  }
  
  final boolean jAD()
  {
    AppMethodBeat.i(38611);
    if (!com.tencent.mm.modelmulti.q.bKT())
    {
      AppMethodBeat.o(38611);
      return false;
    }
    if ((this.afpU != null) && (this.afpU.isShowing()))
    {
      AppMethodBeat.o(38611);
      return false;
    }
    com.tencent.mm.kernel.h.baF();
    if (com.tencent.mm.kernel.h.baE().bah())
    {
      this.afpU = new e.a(this.hHU).aEK(R.l.gDU).bDw(this.hHU.getString(R.l.gDT)).NC(false).aER(R.l.gDV).c(new n.7(this)).aES(R.l.gDS).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38603);
          com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(38601);
              aq localaq = com.tencent.mm.kernel.h.baE().ban();
              localaq.B(89, Integer.valueOf(2));
              localaq.iZy();
              AppMethodBeat.o(38601);
            }
          });
          n.e(n.this).dismiss();
          com.tencent.mm.ui.base.k.a(n.a(n.this), R.l.gDM, R.l.app_tip, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(38602);
              n.c(n.this);
              AppMethodBeat.o(38602);
            }
          });
          AppMethodBeat.o(38603);
        }
      }).jHH();
      this.afpU.show();
    }
    for (;;)
    {
      AppMethodBeat.o(38611);
      return true;
      jAE();
    }
  }
  
  final int jAF()
  {
    AppMethodBeat.i(38616);
    if (this.afpY == null)
    {
      AppMethodBeat.o(38616);
      return -2;
    }
    int i = this.afpY.hashCode();
    AppMethodBeat.o(38616);
    return i;
  }
  
  public final boolean jAG()
  {
    return this.afpY != null;
  }
  
  public final void jhq()
  {
    AppMethodBeat.i(256932);
    if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
    {
      Log.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
      PowerManager.WakeLock localWakeLock = this.wakeLock;
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/ui/conversation/InitHelper", "onTabPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      localWakeLock.release();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/ui/conversation/InitHelper", "onTabPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    }
    AppMethodBeat.o(256932);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(38614);
    if ((paramp.getType() != 138) && (paramp.getType() != 139))
    {
      if ((paramp.getType() != 113) && (paramp.getType() != 0))
      {
        by(paramInt1, paramInt2, paramp.getType());
        AppMethodBeat.o(38614);
        return;
      }
      Log.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
      AppMethodBeat.o(38614);
      return;
    }
    int j = paramp.getType();
    int k = hashCode();
    int i;
    Object localObject;
    if (this.afpY == null)
    {
      i = -2;
      Log.i("MicroMsg.InitHelper", "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      if ((this.afpY != null) && (paramp.getType() == 139))
      {
        this.afpY = null;
        Log.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", new Object[] { Long.valueOf(this.afpW.aPY()) });
        az.a.okP.bCc();
        if (com.tencent.mm.plugin.sns.c.q.Qki != null) {
          com.tencent.mm.plugin.sns.c.q.Qki.hef();
        }
        this.afqc.aTu();
        localObject = new dp();
        ((dp)localObject).hDE.action = 2;
        ((dp)localObject).publish();
        if (this.wakeLock.isHeld())
        {
          Log.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
          localObject = this.wakeLock;
          com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/ui/conversation/InitHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          ((PowerManager.WakeLock)localObject).release();
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/conversation/InitHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        }
        bh.baH().setLowPriority();
        if (this.lzP != null)
        {
          this.lzP.dismiss();
          this.lzP = null;
        }
        j = 0;
        localObject = (Activity)this.qLs.get();
        i = j;
        if (com.tencent.mm.kernel.h.baz())
        {
          i = j;
          if (com.tencent.mm.kernel.h.baC().mBZ)
          {
            i = j;
            if (localObject != null)
            {
              i = j;
              if (!this.hHU.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).getBoolean("font_scale_tip_login", false))
              {
                if (1.0F != com.tencent.mm.cd.a.getScaleSize(this.hHU)) {
                  break label897;
                }
                if (1.0F == this.hHU.getResources().getConfiguration().fontScale) {
                  break label1483;
                }
                com.tencent.mm.plugin.report.service.h.OAn.b(15181, new Object[] { Integer.valueOf(1) });
                g.a locala = new g.a((Context)localObject);
                locala.bf(((Activity)localObject).getResources().getString(R.l.font_scale_adjust_title)).bDE(((Activity)localObject).getResources().getString(R.l.font_scale_adjust_content)).bDI(((Activity)localObject).getResources().getString(R.l.font_scale_adjust_positive_text)).bDJ(((Activity)localObject).getResources().getString(R.l.font_scale_adjust_negative_text));
                locala.c(new n.10(this, (Activity)localObject)).show();
                this.hHU.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
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
        this.hHU.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", false).apply();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bh.bCz();
        localObject = c.bzA().JE(com.tencent.mm.model.z.bAM());
        if ((localObject != null) && ((!com.tencent.mm.contact.d.rs(((az)localObject).field_type)) || (!Util.isNullOrNil(((az)localObject).field_conRemark)) || (!Util.isNullOrNil(((az)localObject).field_conRemarkPYFull)) || (!Util.isNullOrNil(((az)localObject).field_conRemarkPYShort))))
        {
          ((au)localObject).aRK();
          ((au)localObject).AW("");
          ((au)localObject).Bb("");
          ((au)localObject).Bc("");
          bh.bCz();
          c.bzA().d(com.tencent.mm.model.z.bAM(), (au)localObject);
        }
      }
      if (com.tencent.mm.plugin.account.ui.a.a(this.hHU, paramInt1, paramInt2, new Intent().setClass(this.hHU, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        Log.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
        AppMethodBeat.o(38614);
        return;
        i = this.afpY.hashCode();
        break;
        label897:
        this.hHU.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
        i = 1;
        continue;
      }
      if (!bh.baz())
      {
        Log.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
        AppMethodBeat.o(38614);
        return;
      }
      if (!this.afpX)
      {
        this.afpX = true;
        bh.bCz();
        localObject = (String)c.ban().d(5, null);
        bh.bCz();
        if (((Integer)c.ban().d(57, Integer.valueOf(0))).intValue() == 0) {
          break label1172;
        }
      }
      label1172:
      for (i = 1;; i = 0)
      {
        if ((i != 0) && (localObject != null)) {
          com.tencent.mm.ui.base.k.b(this.hHU, this.hHU.getString(R.l.regbyfacebook_reg_setpwd_request, new Object[] { localObject }), this.hHU.getString(R.l.app_tip), this.hHU.getString(R.l.regbyfacebook_reg_setpwd_setnow), this.hHU.getString(R.l.regbyfacebook_reg_setpwd_setcancel), new n.2(this), new n.3(this));
        }
        if ((paramInt1 == 4) && (paramInt2 == -17) && (!afpZ))
        {
          u.bKY().wG(7);
          afpZ = true;
        }
        if (!by(paramInt1, paramInt2, paramp.getType())) {
          break;
        }
        Log.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
        AppMethodBeat.o(38614);
        return;
      }
      if (paramp.getType() == 139)
      {
        localObject = new mw();
        if ((paramInt1 != 3) || (paramInt2 != -1)) {
          break label1263;
        }
        this.afpV = true;
        ((mw)localObject).hOZ.hNk = false;
        ((mw)localObject).publish();
        this.afqa.ery();
        this.afqb.jAq();
      }
      while (ae.a.a(this.hHU, paramInt1, paramInt2, paramString, 4))
      {
        AppMethodBeat.o(38614);
        return;
        label1263:
        ((mw)localObject).hOZ.hNk = true;
        ((mw)localObject).publish();
      }
      if (paramp.getType() == 139)
      {
        new MMHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38609);
            u.bKY().wG(5);
            AppMethodBeat.o(38609);
          }
        });
        if ((com.tencent.mm.model.z.bAU() & 0x80) != 0)
        {
          bh.bCz();
          if (c.bzG().bxM("masssendapp") == null)
          {
            paramString = new bb();
            paramString.setUsername("masssendapp");
            paramString.setContent(MMApplicationContext.getContext().getResources().getString(R.l.gBw));
            paramString.gR(Util.nowMilliSecond() + 2000L);
            paramString.pI(0);
            paramString.pG(0);
            bh.bCz();
            c.bzG().h(paramString);
            paramInt1 = com.tencent.mm.model.z.bAU();
            bh.bCz();
            c.ban().B(40, Integer.valueOf(paramInt1 & 0xFFFFFF7F));
          }
        }
      }
      if ((paramp.getType() == 138) || (paramp.getType() == 139))
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38591);
            ke localke = new ke();
            localke.hLO.data = "MAIN_UI_EVENT_INIT_FINALLY";
            localke.publish();
            AppMethodBeat.o(38591);
          }
        });
        this.afqa.ery();
        this.afqb.jAq();
      }
      AppMethodBeat.o(38614);
      return;
      label1483:
      i = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aTu();
    
    public abstract void jAI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n
 * JD-Core Version:    0.7.0.1
 */