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
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;
import java.lang.ref.WeakReference;

public final class k
  implements com.tencent.mm.al.g, com.tencent.mm.al.h
{
  private static boolean HeD = false;
  private com.tencent.mm.compatible.util.f.a HeA;
  boolean HeB;
  private com.tencent.mm.modelmulti.f HeC;
  a HeE;
  a HeF;
  com.tencent.mm.sdk.b.c HeG;
  com.tencent.mm.sdk.b.c HeH;
  FLock HeI;
  private com.tencent.mm.ui.widget.a.d Hex;
  private com.tencent.mm.ui.widget.a.d Hey;
  private boolean Hez;
  Activity djj;
  ProgressDialog fpP;
  WeakReference<Activity> iRx;
  PowerManager.WakeLock wakeLock;
  
  public k()
  {
    AppMethodBeat.i(38610);
    this.Hex = null;
    this.Hey = null;
    this.Hez = false;
    this.HeA = new com.tencent.mm.compatible.util.f.a();
    this.wakeLock = null;
    this.HeB = false;
    this.HeC = null;
    this.fpP = null;
    this.HeG = new com.tencent.mm.sdk.b.c() {};
    this.HeH = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(38610);
  }
  
  private boolean aJ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38615);
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.w("MicroMsg.InitHelper", "account not ready");
      AppMethodBeat.o(38615);
      return false;
    }
    az.arV();
    long l1 = bt.a((Long)com.tencent.mm.model.c.afk().get(ae.a.FfL, null), 0L);
    az.arV();
    long l2 = bt.a((Long)com.tencent.mm.model.c.afk().get(ae.a.FfN, null), 0L);
    az.arV();
    long l3 = bt.a((Long)com.tencent.mm.model.c.afk().get(ae.a.FfM, null), 0L);
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfL, Long.valueOf(0L));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfM, Long.valueOf(0L));
    if ((l3 == com.tencent.mm.protocal.d.CpK) && (bt.lZ(l2) < 3600L)) {
      if (l1 == 1L)
      {
        if (x.c(this.djj, 4, -17))
        {
          AppMethodBeat.o(38615);
          return true;
        }
      }
      else if ((l1 == 2L) && (x.c(this.djj, 4, -16)))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
    {
      ad.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (com.tencent.mm.platformtools.ab.hVp) {
        aj.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aGK() - 86400L - 1L).commit();
      }
      if (x.c(this.djj, paramInt1, paramInt2))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    AppMethodBeat.o(38615);
    return false;
  }
  
  private void fcy()
  {
    AppMethodBeat.i(38612);
    if (this.Hez)
    {
      ad.i("MicroMsg.InitHelper", "summerinit doPreCreate but hasTryDoInitButFailed true ret");
      AppMethodBeat.o(38612);
      return;
    }
    if (!this.wakeLock.isHeld())
    {
      ad.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
      this.wakeLock.acquire();
    }
    this.HeF.fcB();
    if (this.HeC == null)
    {
      if (com.tencent.mm.plugin.sns.c.o.wzH != null) {
        com.tencent.mm.plugin.sns.c.o.wzH.drN();
      }
      this.HeC = new com.tencent.mm.modelmulti.f(this);
      ad.d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", new Object[] { Long.valueOf(this.HeA.XK()), Integer.valueOf(this.HeC.hashCode()) });
      this.HeA.fGp = SystemClock.elapsedRealtime();
      az.aeS().a(this.HeC, 0);
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38606);
        long l = k.f(k.this).XK();
        if (k.g(k.this) == null) {}
        for (int i = -2;; i = k.g(k.this).hashCode())
        {
          ad.d("MicroMsg.InitHelper", "dkinit showProgressDlg t:%d initScene:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          if ((k.h(k.this) != null) && (k.h(k.this).isShowing())) {
            k.h(k.this).dismiss();
          }
          k localk = k.this;
          Activity localActivity = k.a(k.this);
          k.a(k.this).getString(2131755906);
          k.a(localk, com.tencent.mm.ui.base.h.b(localActivity, k.a(k.this).getString(2131755805), false, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(38605);
              az.aeS().a(k.g(k.this));
              if (com.tencent.mm.plugin.sns.c.o.wzH != null) {
                com.tencent.mm.plugin.sns.c.o.wzH.drO();
              }
              AppMethodBeat.o(38605);
            }
          }));
          az.afE().KL();
          AppMethodBeat.o(38606);
          return;
        }
      }
    });
    AppMethodBeat.o(38612);
  }
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(38613);
    if ((paramn == null) || (paramn.getType() != 139))
    {
      AppMethodBeat.o(38613);
      return;
    }
    if (paramInt2 != 0) {}
    for (long l = paramInt1 * 100L / paramInt2;; l = 0L)
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38607);
          if (k.h(k.this) != null) {
            k.h(k.this).setMessage(k.a(k.this).getString(2131755805) + this.cnI + "%");
          }
          AppMethodBeat.o(38607);
        }
      });
      AppMethodBeat.o(38613);
      return;
    }
  }
  
  public final boolean fcA()
  {
    return this.HeC != null;
  }
  
  final boolean fcx()
  {
    AppMethodBeat.i(38611);
    if (!l.azs())
    {
      AppMethodBeat.o(38611);
      return false;
    }
    if ((this.Hey != null) && (this.Hey.isShowing()))
    {
      AppMethodBeat.o(38611);
      return false;
    }
    com.tencent.mm.kernel.g.afC();
    if (com.tencent.mm.kernel.g.afB().afd())
    {
      this.Hey = new d.a(this.djj).aau(2131758015).aMg(this.djj.getString(2131758014)).wX(false).aaB(2131758016).b(new k.9(this)).aaC(2131758013).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38603);
          com.tencent.mm.kernel.g.afE().ax(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(38601);
              com.tencent.mm.storage.ab localab = com.tencent.mm.kernel.g.afB().afk();
              localab.set(89, Integer.valueOf(2));
              localab.eKy();
              AppMethodBeat.o(38601);
            }
          });
          k.e(k.this).dismiss();
          com.tencent.mm.ui.base.h.a(k.a(k.this), 2131757994, 2131755906, false, new DialogInterface.OnClickListener()
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
      }).fft();
      this.Hey.show();
    }
    for (;;)
    {
      AppMethodBeat.o(38611);
      return true;
      fcy();
    }
  }
  
  final int fcz()
  {
    AppMethodBeat.i(38616);
    if (this.HeC == null)
    {
      AppMethodBeat.o(38616);
      return -2;
    }
    int i = this.HeC.hashCode();
    AppMethodBeat.o(38616);
    return i;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(38614);
    if ((paramn.getType() != 138) && (paramn.getType() != 139))
    {
      if ((paramn.getType() != 113) && (paramn.getType() != 0))
      {
        aJ(paramInt1, paramInt2, paramn.getType());
        AppMethodBeat.o(38614);
        return;
      }
      ad.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
      AppMethodBeat.o(38614);
      return;
    }
    int j = paramn.getType();
    int k = hashCode();
    int i;
    Object localObject;
    if (this.HeC == null)
    {
      i = -2;
      ad.i("MicroMsg.InitHelper", "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      if ((this.HeC != null) && (paramn.getType() == 139))
      {
        this.HeC = null;
        ad.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", new Object[] { Long.valueOf(this.HeA.XK()) });
        ar.a.gMW.a(null, null, null);
        if (com.tencent.mm.plugin.sns.c.o.wzH != null) {
          com.tencent.mm.plugin.sns.c.o.wzH.drO();
        }
        this.HeF.aal();
        if (this.wakeLock.isHeld())
        {
          ad.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
          this.wakeLock.release();
        }
        az.afE().eFR();
        if (this.fpP != null)
        {
          this.fpP.dismiss();
          this.fpP = null;
        }
        localObject = (Activity)this.iRx.get();
        if ((!com.tencent.mm.kernel.g.afw()) || (!com.tencent.mm.kernel.g.afz().gcn) || (localObject == null) || (this.djj.getSharedPreferences(aj.eFD() + "_fontScaleTip", 0).getBoolean("font_scale_tip_login", false))) {
          break label1264;
        }
        if (1.0F != com.tencent.mm.cd.a.dT(this.djj)) {
          break label686;
        }
        if (1.0F == this.djj.getResources().getConfiguration().fontScale) {
          break label1264;
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(15181, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a((Context)localObject);
        locala.au(((Activity)localObject).getResources().getString(2131759585)).aMo(((Activity)localObject).getResources().getString(2131759582)).aMs(((Activity)localObject).getResources().getString(2131759584)).aMt(((Activity)localObject).getResources().getString(2131759583));
        locala.c(new k.12(this, (Activity)localObject)).show();
        this.djj.getSharedPreferences(aj.eFD() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.djj.getSharedPreferences(aj.eFD() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", false).apply();
      }
      if (x.a(this.djj, paramInt1, paramInt2, new Intent().setClass(this.djj, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        ad.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
        AppMethodBeat.o(38614);
        return;
        i = this.HeC.hashCode();
        break;
        label686:
        this.djj.getSharedPreferences(aj.eFD() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
        i = 1;
        continue;
      }
      if (!az.afw())
      {
        ad.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
        AppMethodBeat.o(38614);
        return;
      }
      if (!this.HeB)
      {
        this.HeB = true;
        az.arV();
        localObject = (String)com.tencent.mm.model.c.afk().get(5, null);
        az.arV();
        if (((Integer)com.tencent.mm.model.c.afk().get(57, Integer.valueOf(0))).intValue() == 0) {
          break label961;
        }
      }
      label961:
      for (i = 1;; i = 0)
      {
        if ((i != 0) && (localObject != null)) {
          com.tencent.mm.ui.base.h.d(this.djj, this.djj.getString(2131762314, new Object[] { localObject }), this.djj.getString(2131755906), this.djj.getString(2131762316), this.djj.getString(2131762315), new k.3(this), new k.4(this));
        }
        if ((paramInt1 == 4) && (paramInt2 == -17) && (!HeD))
        {
          com.tencent.mm.modelmulti.o.azv().ov(7);
          HeD = true;
        }
        if (!aJ(paramInt1, paramInt2, paramn.getType())) {
          break;
        }
        ad.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
        AppMethodBeat.o(38614);
        return;
      }
      if (paramn.getType() == 139)
      {
        localObject = new ju();
        if ((paramInt1 != 3) || (paramInt2 != -1)) {
          break label1048;
        }
        this.Hez = true;
        ((ju)localObject).dnX.dms = false;
        com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
        this.HeE.fbU();
      }
      while (x.a.a(this.djj, paramInt1, paramInt2, paramString, 4))
      {
        AppMethodBeat.o(38614);
        return;
        label1048:
        ((ju)localObject).dnX.dms = true;
        com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
      }
      if (paramn.getType() == 139)
      {
        new ap().post(new k.13(this));
        if ((u.aqM() & 0x80) != 0)
        {
          az.arV();
          if (com.tencent.mm.model.c.apR().aIn("masssendapp") == null)
          {
            paramString = new am();
            paramString.setUsername("masssendapp");
            paramString.setContent(aj.getContext().getResources().getString(2131757722));
            paramString.kS(bt.eGO() + 2000L);
            paramString.jV(0);
            paramString.jT(0);
            az.arV();
            com.tencent.mm.model.c.apR().e(paramString);
            paramInt1 = u.aqM();
            az.arV();
            com.tencent.mm.model.c.afk().set(40, Integer.valueOf(paramInt1 & 0xFFFFFF7F));
          }
        }
      }
      if ((paramn.getType() == 138) || (paramn.getType() == 139))
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38591);
            hj localhj = new hj();
            localhj.dkZ.data = "MAIN_UI_EVENT_INIT_FINALLY";
            com.tencent.mm.sdk.b.a.ESL.l(localhj);
            AppMethodBeat.o(38591);
          }
        });
        this.HeE.fbU();
      }
      AppMethodBeat.o(38614);
      return;
      label1264:
      i = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aal();
    
    public abstract void fcB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k
 * JD-Core Version:    0.7.0.1
 */