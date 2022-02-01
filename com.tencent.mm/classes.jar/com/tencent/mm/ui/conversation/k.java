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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.a;
import java.lang.ref.WeakReference;

public final class k
  implements com.tencent.mm.ak.g, com.tencent.mm.ak.h
{
  private static boolean IEQ = false;
  private com.tencent.mm.ui.widget.a.d IEK;
  private com.tencent.mm.ui.widget.a.d IEL;
  private boolean IEM;
  private com.tencent.mm.compatible.util.f.a IEN;
  boolean IEO;
  private com.tencent.mm.modelmulti.f IEP;
  a IER;
  a IES;
  com.tencent.mm.sdk.b.c IET;
  com.tencent.mm.sdk.b.c IEU;
  FLock IEV;
  Activity dgE;
  ProgressDialog fts;
  WeakReference<Activity> jrI;
  PowerManager.WakeLock wakeLock;
  
  public k()
  {
    AppMethodBeat.i(38610);
    this.IEK = null;
    this.IEL = null;
    this.IEM = false;
    this.IEN = new com.tencent.mm.compatible.util.f.a();
    this.wakeLock = null;
    this.IEO = false;
    this.IEP = null;
    this.fts = null;
    this.IET = new com.tencent.mm.sdk.b.c() {};
    this.IEU = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(38610);
  }
  
  private boolean aL(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38615);
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.w("MicroMsg.InitHelper", "account not ready");
      AppMethodBeat.o(38615);
      return false;
    }
    az.ayM();
    long l1 = bs.a((Long)com.tencent.mm.model.c.agA().get(ah.a.GDz, null), 0L);
    az.ayM();
    long l2 = bs.a((Long)com.tencent.mm.model.c.agA().get(ah.a.GDB, null), 0L);
    az.ayM();
    long l3 = bs.a((Long)com.tencent.mm.model.c.agA().get(ah.a.GDA, null), 0L);
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDz, Long.valueOf(0L));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDA, Long.valueOf(0L));
    if ((l3 == com.tencent.mm.protocal.d.DIc) && (bs.pN(l2) < 3600L)) {
      if (l1 == 1L)
      {
        if (y.c(this.dgE, 4, -17))
        {
          AppMethodBeat.o(38615);
          return true;
        }
      }
      else if ((l1 == 2L) && (y.c(this.dgE, 4, -16)))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
    {
      ac.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (ab.ivt) {
        ai.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bs.aNx() - 86400L - 1L).commit();
      }
      if (y.c(this.dgE, paramInt1, paramInt2))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    AppMethodBeat.o(38615);
    return false;
  }
  
  private void fst()
  {
    AppMethodBeat.i(38612);
    if (this.IEM)
    {
      ac.i("MicroMsg.InitHelper", "summerinit doPreCreate but hasTryDoInitButFailed true ret");
      AppMethodBeat.o(38612);
      return;
    }
    if (!this.wakeLock.isHeld())
    {
      ac.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
      this.wakeLock.acquire();
    }
    this.IES.fsw();
    cu localcu = new cu();
    localcu.dcv.action = 1;
    com.tencent.mm.sdk.b.a.GpY.l(localcu);
    if (this.IEP == null)
    {
      if (com.tencent.mm.plugin.sns.b.o.xMb != null) {
        com.tencent.mm.plugin.sns.b.o.xMb.dGm();
      }
      this.IEP = new com.tencent.mm.modelmulti.f(this);
      ac.d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", new Object[] { Long.valueOf(this.IEN.YH()), Integer.valueOf(this.IEP.hashCode()) });
      this.IEN.fJW = SystemClock.elapsedRealtime();
      az.agi().a(this.IEP, 0);
    }
    com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38606);
        long l = k.f(k.this).YH();
        if (k.g(k.this) == null) {}
        for (int i = -2;; i = k.g(k.this).hashCode())
        {
          ac.d("MicroMsg.InitHelper", "dkinit showProgressDlg t:%d initScene:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
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
              az.agi().a(k.g(k.this));
              if (com.tencent.mm.plugin.sns.b.o.xMb != null) {
                com.tencent.mm.plugin.sns.b.o.xMb.dGn();
              }
              AppMethodBeat.o(38605);
            }
          }));
          az.agU().Kw();
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
      com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38607);
          if (k.h(k.this) != null) {
            k.h(k.this).setMessage(k.a(k.this).getString(2131755805) + this.ckK + "%");
          }
          AppMethodBeat.o(38607);
        }
      });
      AppMethodBeat.o(38613);
      return;
    }
  }
  
  final boolean fss()
  {
    AppMethodBeat.i(38611);
    if (!l.aGj())
    {
      AppMethodBeat.o(38611);
      return false;
    }
    if ((this.IEL != null) && (this.IEL.isShowing()))
    {
      AppMethodBeat.o(38611);
      return false;
    }
    com.tencent.mm.kernel.g.agS();
    if (com.tencent.mm.kernel.g.agR().agt())
    {
      this.IEL = new d.a(this.dgE).acF(2131758015).aRI(this.dgE.getString(2131758014)).yf(false).acM(2131758016).b(new k.9(this)).acN(2131758013).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38603);
          com.tencent.mm.kernel.g.agU().az(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(38601);
              ae localae = com.tencent.mm.kernel.g.agR().agA();
              localae.set(89, Integer.valueOf(2));
              localae.faa();
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
      }).fvp();
      this.IEL.show();
    }
    for (;;)
    {
      AppMethodBeat.o(38611);
      return true;
      fst();
    }
  }
  
  final int fsu()
  {
    AppMethodBeat.i(38616);
    if (this.IEP == null)
    {
      AppMethodBeat.o(38616);
      return -2;
    }
    int i = this.IEP.hashCode();
    AppMethodBeat.o(38616);
    return i;
  }
  
  public final boolean fsv()
  {
    return this.IEP != null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(38614);
    if ((paramn.getType() != 138) && (paramn.getType() != 139))
    {
      if ((paramn.getType() != 113) && (paramn.getType() != 0))
      {
        aL(paramInt1, paramInt2, paramn.getType());
        AppMethodBeat.o(38614);
        return;
      }
      ac.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
      AppMethodBeat.o(38614);
      return;
    }
    int j = paramn.getType();
    int k = hashCode();
    int i;
    Object localObject;
    if (this.IEP == null)
    {
      i = -2;
      ac.i("MicroMsg.InitHelper", "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      if ((this.IEP != null) && (paramn.getType() == 139))
      {
        this.IEP = null;
        ac.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", new Object[] { Long.valueOf(this.IEN.YH()) });
        ar.a.hnw.a(null, null, null);
        if (com.tencent.mm.plugin.sns.b.o.xMb != null) {
          com.tencent.mm.plugin.sns.b.o.xMb.dGn();
        }
        this.IES.abk();
        localObject = new cu();
        ((cu)localObject).dcv.action = 2;
        com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
        if (this.wakeLock.isHeld())
        {
          ac.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
          this.wakeLock.release();
        }
        az.agU().eVm();
        if (this.fts != null)
        {
          this.fts.dismiss();
          this.fts = null;
        }
        localObject = (Activity)this.jrI.get();
        if ((!com.tencent.mm.kernel.g.agM()) || (!com.tencent.mm.kernel.g.agP().ggT) || (localObject == null) || (this.dgE.getSharedPreferences(ai.eUX() + "_fontScaleTip", 0).getBoolean("font_scale_tip_login", false))) {
          break label1291;
        }
        if (1.0F != com.tencent.mm.cc.a.eb(this.dgE)) {
          break label713;
        }
        if (1.0F == this.dgE.getResources().getConfiguration().fontScale) {
          break label1291;
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(15181, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a((Context)localObject);
        locala.av(((Activity)localObject).getResources().getString(2131759585)).aRQ(((Activity)localObject).getResources().getString(2131759582)).aRU(((Activity)localObject).getResources().getString(2131759584)).aRV(((Activity)localObject).getResources().getString(2131759583));
        locala.c(new k.12(this, (Activity)localObject)).show();
        this.dgE.getSharedPreferences(ai.eUX() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.dgE.getSharedPreferences(ai.eUX() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", false).apply();
      }
      if (y.a(this.dgE, paramInt1, paramInt2, new Intent().setClass(this.dgE, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        ac.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
        AppMethodBeat.o(38614);
        return;
        i = this.IEP.hashCode();
        break;
        label713:
        this.dgE.getSharedPreferences(ai.eUX() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
        i = 1;
        continue;
      }
      if (!az.agM())
      {
        ac.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
        AppMethodBeat.o(38614);
        return;
      }
      if (!this.IEO)
      {
        this.IEO = true;
        az.ayM();
        localObject = (String)com.tencent.mm.model.c.agA().get(5, null);
        az.ayM();
        if (((Integer)com.tencent.mm.model.c.agA().get(57, Integer.valueOf(0))).intValue() == 0) {
          break label988;
        }
      }
      label988:
      for (i = 1;; i = 0)
      {
        if ((i != 0) && (localObject != null)) {
          com.tencent.mm.ui.base.h.d(this.dgE, this.dgE.getString(2131762314, new Object[] { localObject }), this.dgE.getString(2131755906), this.dgE.getString(2131762316), this.dgE.getString(2131762315), new k.3(this), new k.4(this));
        }
        if ((paramInt1 == 4) && (paramInt2 == -17) && (!IEQ))
        {
          com.tencent.mm.modelmulti.o.aGm().pj(7);
          IEQ = true;
        }
        if (!aL(paramInt1, paramInt2, paramn.getType())) {
          break;
        }
        ac.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
        AppMethodBeat.o(38614);
        return;
      }
      if (paramn.getType() == 139)
      {
        localObject = new kc();
        if ((paramInt1 != 3) || (paramInt2 != -1)) {
          break label1075;
        }
        this.IEM = true;
        ((kc)localObject).dlG.dka = false;
        com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
        this.IER.frL();
      }
      while (y.a.a(this.dgE, paramInt1, paramInt2, paramString, 4))
      {
        AppMethodBeat.o(38614);
        return;
        label1075:
        ((kc)localObject).dlG.dka = true;
        com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
      }
      if (paramn.getType() == 139)
      {
        new ao().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38609);
            com.tencent.mm.modelmulti.o.aGm().pj(5);
            AppMethodBeat.o(38609);
          }
        });
        if ((u.axC() & 0x80) != 0)
        {
          az.ayM();
          if (com.tencent.mm.model.c.awG().aNI("masssendapp") == null)
          {
            paramString = new com.tencent.mm.storage.ap();
            paramString.setUsername("masssendapp");
            paramString.setContent(ai.getContext().getResources().getString(2131757722));
            paramString.ou(bs.eWj() + 2000L);
            paramString.jT(0);
            paramString.jR(0);
            az.ayM();
            com.tencent.mm.model.c.awG().e(paramString);
            paramInt1 = u.axC();
            az.ayM();
            com.tencent.mm.model.c.agA().set(40, Integer.valueOf(paramInt1 & 0xFFFFFF7F));
          }
        }
      }
      if ((paramn.getType() == 138) || (paramn.getType() == 139))
      {
        com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38591);
            hq localhq = new hq();
            localhq.diI.data = "MAIN_UI_EVENT_INIT_FINALLY";
            com.tencent.mm.sdk.b.a.GpY.l(localhq);
            AppMethodBeat.o(38591);
          }
        });
        this.IER.frL();
      }
      AppMethodBeat.o(38614);
      return;
      label1291:
      i = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void abk();
    
    public abstract void fsw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k
 * JD-Core Version:    0.7.0.1
 */