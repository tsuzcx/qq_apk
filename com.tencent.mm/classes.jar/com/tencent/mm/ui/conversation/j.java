package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.h.a.ip;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.w.a;
import com.tencent.mm.ui.widget.a.c.a;

public final class j
  implements f, com.tencent.mm.ah.g
{
  private static boolean vTh = false;
  Activity bMV;
  ProgressDialog dnm = null;
  private com.tencent.mm.ui.widget.a.c vTb = null;
  private com.tencent.mm.ui.widget.a.c vTc = null;
  private boolean vTd = false;
  private g.a vTe = new g.a();
  boolean vTf = false;
  private com.tencent.mm.modelmulti.e vTg = null;
  a vTi;
  a vTj;
  com.tencent.mm.sdk.b.c vTk = new j.1(this);
  com.tencent.mm.sdk.b.c vTl = new j.5(this);
  FLock vTm;
  PowerManager.WakeLock wakeLock = null;
  
  private boolean al(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!com.tencent.mm.kernel.g.DK())
    {
      y.w("MicroMsg.InitHelper", "account not ready");
      return false;
    }
    au.Hx();
    long l1 = com.tencent.mm.platformtools.ah.d((Long)com.tencent.mm.model.c.Dz().get(ac.a.unA, null));
    au.Hx();
    long l2 = com.tencent.mm.platformtools.ah.d((Long)com.tencent.mm.model.c.Dz().get(ac.a.unC, null));
    au.Hx();
    long l3 = com.tencent.mm.platformtools.ah.d((Long)com.tencent.mm.model.c.Dz().get(ac.a.unB, null));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unA, Long.valueOf(0L));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unB, Long.valueOf(0L));
    if ((l3 == d.spa) && (com.tencent.mm.platformtools.ah.cn(l2) < 3600L)) {
      if (l1 == 1L)
      {
        if (w.c(this.bMV, 4, -17)) {
          return true;
        }
      }
      else if ((l1 == 2L) && (w.c(this.bMV, 4, -16))) {
        return true;
      }
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
    {
      y.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (com.tencent.mm.platformtools.ae.eSC) {
        com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", com.tencent.mm.platformtools.ah.UX() - 86400L - 1L).commit();
      }
      if (w.c(this.bMV, paramInt1, paramInt2)) {
        return true;
      }
    }
    return false;
  }
  
  private void cIl()
  {
    if (this.vTd)
    {
      y.i("MicroMsg.InitHelper", "summerinit doPreCreate but hasTryDoInitButFailed true ret");
      return;
    }
    if (!this.wakeLock.isHeld())
    {
      y.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
      this.wakeLock.acquire();
    }
    this.vTj.cIo();
    if (this.vTg == null)
    {
      if (com.tencent.mm.plugin.sns.b.n.omD != null) {
        com.tencent.mm.plugin.sns.b.n.omD.bCk();
      }
      this.vTg = new com.tencent.mm.modelmulti.e(this);
      y.d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", new Object[] { Long.valueOf(this.vTe.zJ()), Integer.valueOf(this.vTg.hashCode()) });
      this.vTe.dzS = SystemClock.elapsedRealtime();
      au.Dk().a(this.vTg, 0);
    }
    ai.d(new j.9(this));
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    if ((paramm == null) || (paramm.getType() != 139)) {
      return;
    }
    if (paramInt2 != 0) {}
    for (long l = paramInt1 * 100L / paramInt2;; l = 0L)
    {
      ai.d(new j.10(this, (int)l));
      return;
    }
  }
  
  final boolean cIk()
  {
    if (!k.Pj()) {
      return false;
    }
    if ((this.vTc != null) && (this.vTc.isShowing())) {
      return false;
    }
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.DP();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN().CX();
    int i = bk.g((Integer)locale.dKw.get(89, null));
    if (i != 0)
    {
      y.i("MMKernel.CoreStorage", "isDBCorrupted: false, recoveryState: " + i);
      i = 0;
      if (i == 0) {
        break label302;
      }
      this.vTc = new c.a(this.bMV).Ip(R.l.db_broken_title).aeA(this.bMV.getString(R.l.db_broken_message)).nW(false).Is(R.l.db_broken_try_recover_btn).a(new j.8(this)).It(R.l.db_broken_cancel_btn).b(new j.7(this)).aoP();
      this.vTc.show();
    }
    for (;;)
    {
      return true;
      if ((bk.pm((String)locale.dKw.get(8195, null)).length() <= 0) || (bk.g((Integer)locale.dKw.get(15, null)) == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        if ((bool) && (locale.Du() != null)) {
          break label288;
        }
        locale.dKw.o(89, Integer.valueOf(1));
        locale.dKw.mC(false);
        y.i("MMKernel.CoreStorage", "isDBCorrupted: false, needInit: " + bool);
        i = 0;
        break;
      }
      label288:
      y.i("MMKernel.CoreStorage", "isDBCorrupted: true");
      i = 1;
      break;
      label302:
      cIl();
    }
  }
  
  final int cIm()
  {
    if (this.vTg == null) {
      return -2;
    }
    return this.vTg.hashCode();
  }
  
  public final boolean cIn()
  {
    return this.vTg != null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm.getType() != 138) && (paramm.getType() != 139)) {
      if ((paramm.getType() != 113) && (paramm.getType() != 0)) {
        al(paramInt1, paramInt2, paramm.getType());
      }
    }
    label552:
    label821:
    label840:
    for (;;)
    {
      return;
      y.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
      return;
      int j = paramm.getType();
      int k = hashCode();
      if (this.vTg == null) {}
      for (int i = -2;; i = this.vTg.hashCode())
      {
        y.i("MicroMsg.InitHelper", "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
        if ((this.vTg != null) && (paramm.getType() == 139))
        {
          this.vTg = null;
          y.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", new Object[] { Long.valueOf(this.vTe.zJ()) });
          am.a.dVy.a(null, null, null);
          if (com.tencent.mm.plugin.sns.b.n.omD != null) {
            com.tencent.mm.plugin.sns.b.n.omD.bCl();
          }
          this.vTj.cIp();
          if (this.wakeLock.isHeld())
          {
            y.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
            this.wakeLock.release();
          }
          au.DS().cre();
          if (this.dnm != null)
          {
            this.dnm.dismiss();
            this.dnm = null;
          }
        }
        if (!w.a(this.bMV, paramInt1, paramInt2, new Intent().setClass(this.bMV, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
          break;
        }
        y.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
        return;
      }
      if (!au.DK())
      {
        y.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
        return;
      }
      Object localObject;
      if (!this.vTf)
      {
        this.vTf = true;
        au.Hx();
        localObject = (String)com.tencent.mm.model.c.Dz().get(5, null);
        au.Hx();
        if (((Integer)com.tencent.mm.model.c.Dz().get(57, Integer.valueOf(0))).intValue() == 0) {
          break label552;
        }
      }
      for (i = 1;; i = 0)
      {
        if ((i != 0) && (localObject != null)) {
          h.a(this.bMV, this.bMV.getString(R.l.regbyfacebook_reg_setpwd_request, new Object[] { localObject }), this.bMV.getString(R.l.app_tip), this.bMV.getString(R.l.regbyfacebook_reg_setpwd_setnow), this.bMV.getString(R.l.regbyfacebook_reg_setpwd_setcancel), new j.2(this), new j.3(this));
        }
        if ((paramInt1 == 4) && (paramInt2 == -17) && (!vTh))
        {
          com.tencent.mm.modelmulti.n.Pm().iT(7);
          vTh = true;
        }
        if (!al(paramInt1, paramInt2, paramm.getType())) {
          break;
        }
        y.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
        return;
      }
      if (paramm.getType() == 139)
      {
        localObject = new ip();
        if ((paramInt1 != 3) || (paramInt2 != -1)) {
          break label821;
        }
        this.vTd = true;
        ((ip)localObject).bQP.bPy = false;
        com.tencent.mm.sdk.b.a.udP.m((b)localObject);
        this.vTi.cHT();
      }
      for (;;)
      {
        if (w.a.a(this.bMV, paramInt1, paramInt2, paramString, 4)) {
          break label840;
        }
        if (paramm.getType() == 139)
        {
          new com.tencent.mm.sdk.platformtools.ah().post(new j.11(this));
          if ((q.Gp() & 0x80) != 0)
          {
            au.Hx();
            if (com.tencent.mm.model.c.FB().abv("masssendapp") == null)
            {
              paramString = new ak();
              paramString.setUsername("masssendapp");
              paramString.setContent(com.tencent.mm.sdk.platformtools.ae.getContext().getResources().getString(R.l.contact_info_masssend_tip));
              paramString.ba(com.tencent.mm.platformtools.ah.UY() + 2000L);
              paramString.fA(0);
              paramString.fy(0);
              au.Hx();
              com.tencent.mm.model.c.FB().d(paramString);
              paramInt1 = q.Gp();
              au.Hx();
              com.tencent.mm.model.c.Dz().o(40, Integer.valueOf(paramInt1 & 0xFFFFFF7F));
            }
          }
        }
        if ((paramm.getType() != 138) && (paramm.getType() != 139)) {
          break;
        }
        ai.d(new j.12(this));
        this.vTi.cHT();
        return;
        ((ip)localObject).bQP.bPy = true;
        com.tencent.mm.sdk.b.a.udP.m((b)localObject);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void cIo();
    
    public abstract void cIp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j
 * JD-Core Version:    0.7.0.1
 */