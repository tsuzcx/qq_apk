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
import com.tencent.mm.ak.n;
import com.tencent.mm.d.i.a;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.xe;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.i.j;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.a;
import java.lang.ref.WeakReference;

public final class k
  implements com.tencent.mm.ak.f, com.tencent.mm.ak.g
{
  private static boolean KSn = false;
  private com.tencent.mm.ui.widget.a.d KSh;
  private com.tencent.mm.ui.widget.a.d KSi;
  private boolean KSj;
  private com.tencent.mm.compatible.util.f.a KSk;
  boolean KSl;
  private com.tencent.mm.modelmulti.f KSm;
  a KSo;
  a KSp;
  com.tencent.mm.sdk.b.c KSq;
  com.tencent.mm.sdk.b.c KSr;
  FLock KSs;
  Activity dtg;
  ProgressDialog fOC;
  WeakReference<Activity> jOO;
  PowerManager.WakeLock wakeLock;
  
  public k()
  {
    AppMethodBeat.i(38610);
    this.KSh = null;
    this.KSi = null;
    this.KSj = false;
    this.KSk = new com.tencent.mm.compatible.util.f.a();
    this.wakeLock = null;
    this.KSl = false;
    this.KSm = null;
    this.fOC = null;
    this.KSq = new com.tencent.mm.sdk.b.c() {};
    this.KSr = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(38610);
  }
  
  private boolean aN(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38615);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.w("MicroMsg.InitHelper", "account not ready");
      AppMethodBeat.o(38615);
      return false;
    }
    bc.aCg();
    long l1 = bu.a((Long)com.tencent.mm.model.c.ajA().get(am.a.IKm, null), 0L);
    bc.aCg();
    long l2 = bu.a((Long)com.tencent.mm.model.c.ajA().get(am.a.IKo, null), 0L);
    bc.aCg();
    long l3 = bu.a((Long)com.tencent.mm.model.c.ajA().get(am.a.IKn, null), 0L);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKm, Long.valueOf(0L));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKn, Long.valueOf(0L));
    if ((l3 == com.tencent.mm.protocal.d.FFH) && (bu.rZ(l2) < 3600L)) {
      if (l1 == 1L)
      {
        if (y.c(this.dtg, 4, -17))
        {
          AppMethodBeat.o(38615);
          return true;
        }
      }
      else if ((l1 == 2L) && (y.c(this.dtg, 4, -16)))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
    {
      ae.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (ac.iRu) {
        ak.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bu.aRi() - 86400L - 1L).commit();
      }
      if (y.c(this.dtg, paramInt1, paramInt2))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    AppMethodBeat.o(38615);
    return false;
  }
  
  private void fNy()
  {
    AppMethodBeat.i(38612);
    if (this.KSj)
    {
      ae.i("MicroMsg.InitHelper", "summerinit doPreCreate but hasTryDoInitButFailed true ret");
      AppMethodBeat.o(38612);
      return;
    }
    if (!this.wakeLock.isHeld())
    {
      ae.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
      this.wakeLock.acquire();
    }
    this.KSp.fNB();
    cy localcy = new cy();
    localcy.doW.action = 1;
    com.tencent.mm.sdk.b.a.IvT.l(localcy);
    if (this.KSm == null)
    {
      if (com.tencent.mm.plugin.sns.b.o.zsw != null) {
        com.tencent.mm.plugin.sns.b.o.zsw.dVX();
      }
      this.KSm = new com.tencent.mm.modelmulti.f(this);
      ae.d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", new Object[] { Long.valueOf(this.KSk.abs()), Integer.valueOf(this.KSm.hashCode()) });
      this.KSk.gfF = SystemClock.elapsedRealtime();
      bc.ajj().a(this.KSm, 0);
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38606);
        long l = k.f(k.this).abs();
        if (k.g(k.this) == null) {}
        for (int i = -2;; i = k.g(k.this).hashCode())
        {
          ae.d("MicroMsg.InitHelper", "dkinit showProgressDlg t:%d initScene:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
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
              bc.ajj().a(k.g(k.this));
              if (com.tencent.mm.plugin.sns.b.o.zsw != null) {
                com.tencent.mm.plugin.sns.b.o.zsw.dVY();
              }
              AppMethodBeat.o(38605);
            }
          }));
          bc.ajU().Mh();
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
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38607);
          if (k.h(k.this) != null) {
            k.h(k.this).setMessage(k.a(k.this).getString(2131755805) + this.cvQ + "%");
          }
          AppMethodBeat.o(38607);
        }
      });
      AppMethodBeat.o(38613);
      return;
    }
  }
  
  public final boolean fNA()
  {
    return this.KSm != null;
  }
  
  final boolean fNx()
  {
    AppMethodBeat.i(38611);
    if (!l.aJL())
    {
      AppMethodBeat.o(38611);
      return false;
    }
    if ((this.KSi != null) && (this.KSi.isShowing()))
    {
      AppMethodBeat.o(38611);
      return false;
    }
    com.tencent.mm.kernel.g.ajS();
    if (com.tencent.mm.kernel.g.ajR().aju())
    {
      this.KSi = new d.a(this.dtg).afN(2131758015).aZi(this.dtg.getString(2131758014)).zf(false).afU(2131758016).c(new k.9(this)).afV(2131758013).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38603);
          com.tencent.mm.kernel.g.ajU().aw(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(38601);
              aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
              localaj.set(89, Integer.valueOf(2));
              localaj.fuc();
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
      }).fQv();
      this.KSi.show();
    }
    for (;;)
    {
      AppMethodBeat.o(38611);
      return true;
      fNy();
    }
  }
  
  final int fNz()
  {
    AppMethodBeat.i(38616);
    if (this.KSm == null)
    {
      AppMethodBeat.o(38616);
      return -2;
    }
    int i = this.KSm.hashCode();
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
        aN(paramInt1, paramInt2, paramn.getType());
        AppMethodBeat.o(38614);
        return;
      }
      ae.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
      AppMethodBeat.o(38614);
      return;
    }
    int j = paramn.getType();
    int k = hashCode();
    int i;
    Object localObject;
    if (this.KSm == null)
    {
      i = -2;
      ae.i("MicroMsg.InitHelper", "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      if ((this.KSm != null) && (paramn.getType() == 139))
      {
        this.KSm = null;
        ae.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", new Object[] { Long.valueOf(this.KSk.abs()) });
        au.a.hIG.aBI();
        if (com.tencent.mm.plugin.sns.b.o.zsw != null) {
          com.tencent.mm.plugin.sns.b.o.zsw.dVY();
        }
        this.KSp.aea();
        localObject = new cy();
        ((cy)localObject).doW.action = 2;
        com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
        if (this.wakeLock.isHeld())
        {
          ae.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
          this.wakeLock.release();
        }
        bc.ajU().foO();
        if (this.fOC != null)
        {
          this.fOC.dismiss();
          this.fOC = null;
        }
        j = 0;
        localObject = (Activity)this.jOO.get();
        i = j;
        if (com.tencent.mm.kernel.g.ajM())
        {
          i = j;
          if (com.tencent.mm.kernel.g.ajP().gDk)
          {
            i = j;
            if (localObject != null)
            {
              i = j;
              if (!this.dtg.getSharedPreferences(ak.fow() + "_fontScaleTip", 0).getBoolean("font_scale_tip_login", false))
              {
                if (1.0F != com.tencent.mm.cb.a.ef(this.dtg)) {
                  break label729;
                }
                if (1.0F == this.dtg.getResources().getConfiguration().fontScale) {
                  break label1307;
                }
                com.tencent.mm.plugin.report.service.g.yxI.f(15181, new Object[] { Integer.valueOf(1) });
                com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a((Context)localObject);
                locala.au(((Activity)localObject).getResources().getString(2131759585)).aZq(((Activity)localObject).getResources().getString(2131759582)).aZu(((Activity)localObject).getResources().getString(2131759584)).aZv(((Activity)localObject).getResources().getString(2131759583));
                locala.c(new k.12(this, (Activity)localObject)).show();
                this.dtg.getSharedPreferences(ak.fow() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
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
        this.dtg.getSharedPreferences(ak.fow() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", false).apply();
      }
      if (y.a(this.dtg, paramInt1, paramInt2, new Intent().setClass(this.dtg, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        ae.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
        AppMethodBeat.o(38614);
        return;
        i = this.KSm.hashCode();
        break;
        label729:
        this.dtg.getSharedPreferences(ak.fow() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
        i = 1;
        continue;
      }
      if (!bc.ajM())
      {
        ae.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
        AppMethodBeat.o(38614);
        return;
      }
      if (!this.KSl)
      {
        this.KSl = true;
        bc.aCg();
        localObject = (String)com.tencent.mm.model.c.ajA().get(5, null);
        bc.aCg();
        if (((Integer)com.tencent.mm.model.c.ajA().get(57, Integer.valueOf(0))).intValue() == 0) {
          break label1004;
        }
      }
      label1004:
      for (i = 1;; i = 0)
      {
        if ((i != 0) && (localObject != null)) {
          com.tencent.mm.ui.base.h.e(this.dtg, this.dtg.getString(2131762314, new Object[] { localObject }), this.dtg.getString(2131755906), this.dtg.getString(2131762316), this.dtg.getString(2131762315), new k.3(this), new k.4(this));
        }
        if ((paramInt1 == 4) && (paramInt2 == -17) && (!KSn))
        {
          p.aJQ().pP(7);
          KSn = true;
        }
        if (!aN(paramInt1, paramInt2, paramn.getType())) {
          break;
        }
        ae.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
        AppMethodBeat.o(38614);
        return;
      }
      if (paramn.getType() == 139)
      {
        localObject = new kl();
        if ((paramInt1 != 3) || (paramInt2 != -1)) {
          break label1091;
        }
        this.KSj = true;
        ((kl)localObject).dyy.dwS = false;
        com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
        this.KSo.fMS();
      }
      while (y.a.a(this.dtg, paramInt1, paramInt2, paramString, 4))
      {
        AppMethodBeat.o(38614);
        return;
        label1091:
        ((kl)localObject).dyy.dwS = true;
        com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
      }
      if (paramn.getType() == 139)
      {
        new aq().post(new k.13(this));
        if ((v.aAI() & 0x80) != 0)
        {
          bc.aCg();
          if (com.tencent.mm.model.c.azL().aVa("masssendapp") == null)
          {
            paramString = new au();
            paramString.setUsername("masssendapp");
            paramString.setContent(ak.getContext().getResources().getString(2131757722));
            paramString.qH(bu.fpO() + 2000L);
            paramString.kt(0);
            paramString.kr(0);
            bc.aCg();
            com.tencent.mm.model.c.azL().e(paramString);
            paramInt1 = v.aAI();
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(40, Integer.valueOf(paramInt1 & 0xFFFFFF7F));
          }
        }
      }
      if ((paramn.getType() == 138) || (paramn.getType() == 139))
      {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38591);
            hy localhy = new hy();
            localhy.dvz.data = "MAIN_UI_EVENT_INIT_FINALLY";
            com.tencent.mm.sdk.b.a.IvT.l(localhy);
            AppMethodBeat.o(38591);
          }
        });
        this.KSo.fMS();
      }
      AppMethodBeat.o(38614);
      return;
      label1307:
      i = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aea();
    
    public abstract void fNB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k
 * JD-Core Version:    0.7.0.1
 */