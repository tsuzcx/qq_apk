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
import com.tencent.mm.g.a.cx;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.xa;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.a;
import java.lang.ref.WeakReference;

public final class k
  implements com.tencent.mm.al.f, com.tencent.mm.al.g
{
  private static boolean KvT = false;
  private com.tencent.mm.ui.widget.a.d KvN;
  private com.tencent.mm.ui.widget.a.d KvO;
  private boolean KvP;
  private com.tencent.mm.compatible.util.f.a KvQ;
  boolean KvR;
  private com.tencent.mm.modelmulti.f KvS;
  a KvU;
  a KvV;
  com.tencent.mm.sdk.b.c KvW;
  com.tencent.mm.sdk.b.c KvX;
  FLock KvY;
  Activity dsa;
  ProgressDialog fMu;
  WeakReference<Activity> jLC;
  PowerManager.WakeLock wakeLock;
  
  public k()
  {
    AppMethodBeat.i(38610);
    this.KvN = null;
    this.KvO = null;
    this.KvP = false;
    this.KvQ = new com.tencent.mm.compatible.util.f.a();
    this.wakeLock = null;
    this.KvR = false;
    this.KvS = null;
    this.fMu = null;
    this.KvW = new com.tencent.mm.sdk.b.c() {};
    this.KvX = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(38610);
  }
  
  private boolean aM(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38615);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.w("MicroMsg.InitHelper", "account not ready");
      AppMethodBeat.o(38615);
      return false;
    }
    ba.aBQ();
    long l1 = bt.a((Long)com.tencent.mm.model.c.ajl().get(al.a.IpS, null), 0L);
    ba.aBQ();
    long l2 = bt.a((Long)com.tencent.mm.model.c.ajl().get(al.a.IpU, null), 0L);
    ba.aBQ();
    long l3 = bt.a((Long)com.tencent.mm.model.c.ajl().get(al.a.IpT, null), 0L);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.IpS, Long.valueOf(0L));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.IpT, Long.valueOf(0L));
    if ((l3 == com.tencent.mm.protocal.d.Fnj) && (bt.rM(l2) < 3600L)) {
      if (l1 == 1L)
      {
        if (y.c(this.dsa, 4, -17))
        {
          AppMethodBeat.o(38615);
          return true;
        }
      }
      else if ((l1 == 2L) && (y.c(this.dsa, 4, -16)))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
    {
      ad.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (ac.iOA) {
        aj.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aQJ() - 86400L - 1L).commit();
      }
      if (y.c(this.dsa, paramInt1, paramInt2))
      {
        AppMethodBeat.o(38615);
        return true;
      }
    }
    AppMethodBeat.o(38615);
    return false;
  }
  
  private void fJh()
  {
    AppMethodBeat.i(38612);
    if (this.KvP)
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
    this.KvV.fJk();
    cx localcx = new cx();
    localcx.dnR.action = 1;
    com.tencent.mm.sdk.b.a.IbL.l(localcx);
    if (this.KvS == null)
    {
      if (o.zbT != null) {
        o.zbT.dSz();
      }
      this.KvS = new com.tencent.mm.modelmulti.f(this);
      ad.d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", new Object[] { Long.valueOf(this.KvQ.abj()), Integer.valueOf(this.KvS.hashCode()) });
      this.KvQ.gdx = SystemClock.elapsedRealtime();
      ba.aiU().a(this.KvS, 0);
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38606);
        long l = k.f(k.this).abj();
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
          k.a(localk, h.b(localActivity, k.a(k.this).getString(2131755805), false, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(38605);
              ba.aiU().a(k.g(k.this));
              if (o.zbT != null) {
                o.zbT.dSA();
              }
              AppMethodBeat.o(38605);
            }
          }));
          ba.ajF().LZ();
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
            k.h(k.this).setMessage(k.a(k.this).getString(2131755805) + this.cvm + "%");
          }
          AppMethodBeat.o(38607);
        }
      });
      AppMethodBeat.o(38613);
      return;
    }
  }
  
  final boolean fJg()
  {
    AppMethodBeat.i(38611);
    if (!l.aJs())
    {
      AppMethodBeat.o(38611);
      return false;
    }
    if ((this.KvO != null) && (this.KvO.isShowing()))
    {
      AppMethodBeat.o(38611);
      return false;
    }
    com.tencent.mm.kernel.g.ajD();
    if (com.tencent.mm.kernel.g.ajC().ajf())
    {
      this.KvO = new d.a(this.dsa).afe(2131758015).aXG(this.dsa.getString(2131758014)).yR(false).afl(2131758016).c(new k.9(this)).afm(2131758013).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38603);
          com.tencent.mm.kernel.g.ajF().ay(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(38601);
              ai localai = com.tencent.mm.kernel.g.ajC().ajl();
              localai.set(89, Integer.valueOf(2));
              localai.fqc();
              AppMethodBeat.o(38601);
            }
          });
          k.e(k.this).dismiss();
          h.a(k.a(k.this), 2131757994, 2131755906, false, new DialogInterface.OnClickListener()
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
      }).fMb();
      this.KvO.show();
    }
    for (;;)
    {
      AppMethodBeat.o(38611);
      return true;
      fJh();
    }
  }
  
  final int fJi()
  {
    AppMethodBeat.i(38616);
    if (this.KvS == null)
    {
      AppMethodBeat.o(38616);
      return -2;
    }
    int i = this.KvS.hashCode();
    AppMethodBeat.o(38616);
    return i;
  }
  
  public final boolean fJj()
  {
    return this.KvS != null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(38614);
    if ((paramn.getType() != 138) && (paramn.getType() != 139))
    {
      if ((paramn.getType() != 113) && (paramn.getType() != 0))
      {
        aM(paramInt1, paramInt2, paramn.getType());
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
    if (this.KvS == null)
    {
      i = -2;
      ad.i("MicroMsg.InitHelper", "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      if ((this.KvS != null) && (paramn.getType() == 139))
      {
        this.KvS = null;
        ad.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", new Object[] { Long.valueOf(this.KvQ.abj()) });
        as.a.hFO.aBs();
        if (o.zbT != null) {
          o.zbT.dSA();
        }
        this.KvV.adO();
        localObject = new cx();
        ((cx)localObject).dnR.action = 2;
        com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
        if (this.wakeLock.isHeld())
        {
          ad.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
          this.wakeLock.release();
        }
        ba.ajF().fkT();
        if (this.fMu != null)
        {
          this.fMu.dismiss();
          this.fMu = null;
        }
        j = 0;
        localObject = (Activity)this.jLC.get();
        i = j;
        if (com.tencent.mm.kernel.g.ajx())
        {
          i = j;
          if (com.tencent.mm.kernel.g.ajA().gAD)
          {
            i = j;
            if (localObject != null)
            {
              i = j;
              if (!this.dsa.getSharedPreferences(aj.fkC() + "_fontScaleTip", 0).getBoolean("font_scale_tip_login", false))
              {
                if (1.0F != com.tencent.mm.cc.a.eb(this.dsa)) {
                  break label729;
                }
                if (1.0F == this.dsa.getResources().getConfiguration().fontScale) {
                  break label1307;
                }
                com.tencent.mm.plugin.report.service.g.yhR.f(15181, new Object[] { Integer.valueOf(1) });
                com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a((Context)localObject);
                locala.av(((Activity)localObject).getResources().getString(2131759585)).aXO(((Activity)localObject).getResources().getString(2131759582)).aXS(((Activity)localObject).getResources().getString(2131759584)).aXT(((Activity)localObject).getResources().getString(2131759583));
                locala.c(new k.12(this, (Activity)localObject)).show();
                this.dsa.getSharedPreferences(aj.fkC() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
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
        this.dsa.getSharedPreferences(aj.fkC() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", false).apply();
      }
      if (y.a(this.dsa, paramInt1, paramInt2, new Intent().setClass(this.dsa, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        ad.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
        AppMethodBeat.o(38614);
        return;
        i = this.KvS.hashCode();
        break;
        label729:
        this.dsa.getSharedPreferences(aj.fkC() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
        i = 1;
        continue;
      }
      if (!ba.ajx())
      {
        ad.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
        AppMethodBeat.o(38614);
        return;
      }
      if (!this.KvR)
      {
        this.KvR = true;
        ba.aBQ();
        localObject = (String)com.tencent.mm.model.c.ajl().get(5, null);
        ba.aBQ();
        if (((Integer)com.tencent.mm.model.c.ajl().get(57, Integer.valueOf(0))).intValue() == 0) {
          break label1004;
        }
      }
      label1004:
      for (i = 1;; i = 0)
      {
        if ((i != 0) && (localObject != null)) {
          h.e(this.dsa, this.dsa.getString(2131762314, new Object[] { localObject }), this.dsa.getString(2131755906), this.dsa.getString(2131762316), this.dsa.getString(2131762315), new k.3(this), new k.4(this));
        }
        if ((paramInt1 == 4) && (paramInt2 == -17) && (!KvT))
        {
          p.aJx().pM(7);
          KvT = true;
        }
        if (!aM(paramInt1, paramInt2, paramn.getType())) {
          break;
        }
        ad.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
        AppMethodBeat.o(38614);
        return;
      }
      if (paramn.getType() == 139)
      {
        localObject = new kk();
        if ((paramInt1 != 3) || (paramInt2 != -1)) {
          break label1091;
        }
        this.KvP = true;
        ((kk)localObject).dxt.dvN = false;
        com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
        this.KvU.fIA();
      }
      while (y.a.a(this.dsa, paramInt1, paramInt2, paramString, 4))
      {
        AppMethodBeat.o(38614);
        return;
        label1091:
        ((kk)localObject).dxt.dvN = true;
        com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
      }
      if (paramn.getType() == 139)
      {
        new ap().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38609);
            p.aJx().pM(5);
            AppMethodBeat.o(38609);
          }
        });
        if ((u.aAs() & 0x80) != 0)
        {
          ba.aBQ();
          if (com.tencent.mm.model.c.azv().aTz("masssendapp") == null)
          {
            paramString = new at();
            paramString.setUsername("masssendapp");
            paramString.setContent(aj.getContext().getResources().getString(2131757722));
            paramString.qu(bt.flT() + 2000L);
            paramString.kr(0);
            paramString.kp(0);
            ba.aBQ();
            com.tencent.mm.model.c.azv().e(paramString);
            paramInt1 = u.aAs();
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(40, Integer.valueOf(paramInt1 & 0xFFFFFF7F));
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
            hx localhx = new hx();
            localhx.duu.data = "MAIN_UI_EVENT_INIT_FINALLY";
            com.tencent.mm.sdk.b.a.IbL.l(localhx);
            AppMethodBeat.o(38591);
          }
        });
        this.KvU.fIA();
      }
      AppMethodBeat.o(38614);
      return;
      label1307:
      i = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void adO();
    
    public abstract void fJk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k
 * JD-Core Version:    0.7.0.1
 */