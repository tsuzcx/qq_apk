package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.ui.widget.b.e.a;
import java.lang.ref.WeakReference;

public final class j
  implements f, com.tencent.mm.ai.g
{
  private static boolean AkZ = false;
  private com.tencent.mm.ui.widget.b.c AkT;
  private com.tencent.mm.ui.widget.b.c AkU;
  private boolean AkV;
  private g.a AkW;
  boolean AkX;
  private com.tencent.mm.modelmulti.e AkY;
  a Ala;
  a Alb;
  com.tencent.mm.sdk.b.c Alc;
  com.tencent.mm.sdk.b.c Ald;
  FLock Ale;
  Activity cup;
  ProgressDialog eeN;
  WeakReference<Activity> gYJ;
  PowerManager.WakeLock wakeLock;
  
  public j()
  {
    AppMethodBeat.i(34483);
    this.AkT = null;
    this.AkU = null;
    this.AkV = false;
    this.AkW = new g.a();
    this.wakeLock = null;
    this.AkX = false;
    this.AkY = null;
    this.eeN = null;
    this.Alc = new j.1(this);
    this.Ald = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(34483);
  }
  
  private boolean ax(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(34488);
    if (!com.tencent.mm.kernel.g.RG())
    {
      ab.w("MicroMsg.InitHelper", "account not ready");
      AppMethodBeat.o(34488);
      return false;
    }
    aw.aaz();
    long l1 = com.tencent.mm.platformtools.ah.d((Long)com.tencent.mm.model.c.Ru().get(ac.a.yxr, null));
    aw.aaz();
    long l2 = com.tencent.mm.platformtools.ah.d((Long)com.tencent.mm.model.c.Ru().get(ac.a.yxt, null));
    aw.aaz();
    long l3 = com.tencent.mm.platformtools.ah.d((Long)com.tencent.mm.model.c.Ru().get(ac.a.yxs, null));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxr, Long.valueOf(0L));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxs, Long.valueOf(0L));
    if ((l3 == d.whH) && (com.tencent.mm.platformtools.ah.gz(l2) < 3600L)) {
      if (l1 == 1L)
      {
        if (v.c(this.cup, 4, -17))
        {
          AppMethodBeat.o(34488);
          return true;
        }
      }
      else if ((l1 == 2L) && (v.c(this.cup, 4, -16)))
      {
        AppMethodBeat.o(34488);
        return true;
      }
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
    {
      ab.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (ae.gkx) {
        com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", com.tencent.mm.platformtools.ah.aox() - 86400L - 1L).commit();
      }
      if (v.c(this.cup, paramInt1, paramInt2))
      {
        AppMethodBeat.o(34488);
        return true;
      }
    }
    AppMethodBeat.o(34488);
    return false;
  }
  
  private void dMQ()
  {
    AppMethodBeat.i(34485);
    if (this.AkV)
    {
      ab.i("MicroMsg.InitHelper", "summerinit doPreCreate but hasTryDoInitButFailed true ret");
      AppMethodBeat.o(34485);
      return;
    }
    if (!this.wakeLock.isHeld())
    {
      ab.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
      this.wakeLock.acquire();
    }
    this.Alb.dMT();
    if (this.AkY == null)
    {
      if (com.tencent.mm.plugin.sns.b.n.raR != null) {
        com.tencent.mm.plugin.sns.b.n.raR.cnK();
      }
      this.AkY = new com.tencent.mm.modelmulti.e(this);
      ab.d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", new Object[] { Long.valueOf(this.AkW.Mm()), Integer.valueOf(this.AkY.hashCode()) });
      this.AkW.etf = SystemClock.elapsedRealtime();
      aw.Rc().a(this.AkY, 0);
    }
    al.d(new j.10(this));
    AppMethodBeat.o(34485);
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(34486);
    if ((paramm == null) || (paramm.getType() != 139))
    {
      AppMethodBeat.o(34486);
      return;
    }
    if (paramInt2 != 0) {}
    for (long l = paramInt1 * 100L / paramInt2;; l = 0L)
    {
      al.d(new j.11(this, (int)l));
      AppMethodBeat.o(34486);
      return;
    }
  }
  
  final boolean dMP()
  {
    AppMethodBeat.i(34484);
    if (!k.ail())
    {
      AppMethodBeat.o(34484);
      return false;
    }
    if ((this.AkU != null) && (this.AkU.isShowing()))
    {
      AppMethodBeat.o(34484);
      return false;
    }
    com.tencent.mm.kernel.g.RM();
    if (com.tencent.mm.kernel.g.RL().Rn())
    {
      this.AkU = new c.a(this.cup).Rb(2131298932).avn(this.cup.getString(2131298931)).rG(false).Ri(2131298933).a(new j.9(this)).Rj(2131298930).b(new j.8(this)).aLZ();
      this.AkU.show();
    }
    for (;;)
    {
      AppMethodBeat.o(34484);
      return true;
      dMQ();
    }
  }
  
  final int dMR()
  {
    AppMethodBeat.i(34489);
    if (this.AkY == null)
    {
      AppMethodBeat.o(34489);
      return -2;
    }
    int i = this.AkY.hashCode();
    AppMethodBeat.o(34489);
    return i;
  }
  
  public final boolean dMS()
  {
    return this.AkY != null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(34487);
    if ((paramm.getType() != 138) && (paramm.getType() != 139))
    {
      if ((paramm.getType() != 113) && (paramm.getType() != 0))
      {
        ax(paramInt1, paramInt2, paramm.getType());
        AppMethodBeat.o(34487);
        return;
      }
      ab.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
      AppMethodBeat.o(34487);
      return;
    }
    int j = paramm.getType();
    int k = hashCode();
    int i;
    Object localObject;
    if (this.AkY == null)
    {
      i = -2;
      ab.i("MicroMsg.InitHelper", "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      if ((this.AkY != null) && (paramm.getType() == 139))
      {
        this.AkY = null;
        ab.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", new Object[] { Long.valueOf(this.AkW.Mm()) });
        ao.a.flI.a(null, null, null);
        if (com.tencent.mm.plugin.sns.b.n.raR != null) {
          com.tencent.mm.plugin.sns.b.n.raR.cnL();
        }
        this.Alb.dMU();
        if (this.wakeLock.isHeld())
        {
          ab.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
          this.wakeLock.release();
        }
        aw.RO().dtd();
        if (this.eeN != null)
        {
          this.eeN.dismiss();
          this.eeN = null;
        }
        localObject = (Activity)this.gYJ.get();
        if ((!com.tencent.mm.kernel.g.RG()) || (!com.tencent.mm.kernel.g.RJ().eHg) || (localObject == null) || (this.cup.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP() + "_fontScaleTip", 0).getBoolean("font_scale_tip_login", false))) {
          break label1269;
        }
        if (1.0F != com.tencent.mm.cb.a.dr(this.cup)) {
          break label691;
        }
        if (1.0F == this.cup.getResources().getConfiguration().fontScale) {
          break label1269;
        }
        com.tencent.mm.plugin.report.service.h.qsU.e(15181, new Object[] { Integer.valueOf(1) });
        e.a locala1 = new e.a((Context)localObject);
        e.a locala2 = locala1.aj(((Activity)localObject).getResources().getString(2131300118)).avu(((Activity)localObject).getResources().getString(2131300115));
        locala2.AHs = ((Activity)localObject).getResources().getString(2131300117);
        locala2.AHt = ((Activity)localObject).getResources().getString(2131300116);
        locala1.c(new j.12(this, (Activity)localObject)).show();
        this.cup.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.cup.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", false).apply();
      }
      if (v.a(this.cup, paramInt1, paramInt2, new Intent().setClass(this.cup, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        ab.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
        AppMethodBeat.o(34487);
        return;
        i = this.AkY.hashCode();
        break;
        label691:
        this.cup.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
        i = 1;
        continue;
      }
      if (!aw.RG())
      {
        ab.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
        AppMethodBeat.o(34487);
        return;
      }
      if (!this.AkX)
      {
        this.AkX = true;
        aw.aaz();
        localObject = (String)com.tencent.mm.model.c.Ru().get(5, null);
        aw.aaz();
        if (((Integer)com.tencent.mm.model.c.Ru().get(57, Integer.valueOf(0))).intValue() == 0) {
          break label966;
        }
      }
      label966:
      for (i = 1;; i = 0)
      {
        if ((i != 0) && (localObject != null)) {
          com.tencent.mm.ui.base.h.d(this.cup, this.cup.getString(2131302417, new Object[] { localObject }), this.cup.getString(2131297087), this.cup.getString(2131302419), this.cup.getString(2131302418), new j.3(this), new j.4(this));
        }
        if ((paramInt1 == 4) && (paramInt2 == -17) && (!AkZ))
        {
          com.tencent.mm.modelmulti.n.aio().lL(7);
          AkZ = true;
        }
        if (!ax(paramInt1, paramInt2, paramm.getType())) {
          break;
        }
        ab.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
        AppMethodBeat.o(34487);
        return;
      }
      if (paramm.getType() == 139)
      {
        localObject = new iw();
        if ((paramInt1 != 3) || (paramInt2 != -1)) {
          break label1053;
        }
        this.AkV = true;
        ((iw)localObject).cyp.cwR = false;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
        this.Ala.dMn();
      }
      while (v.a.a(this.cup, paramInt1, paramInt2, paramString, 4))
      {
        AppMethodBeat.o(34487);
        return;
        label1053:
        ((iw)localObject).cyp.cwR = true;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      }
      if (paramm.getType() == 139)
      {
        new com.tencent.mm.sdk.platformtools.ak().post(new j.13(this));
        if ((r.Zt() & 0x80) != 0)
        {
          aw.aaz();
          if (com.tencent.mm.model.c.YF().arH("masssendapp") == null)
          {
            paramString = new com.tencent.mm.storage.ak();
            paramString.setUsername("masssendapp");
            paramString.setContent(com.tencent.mm.sdk.platformtools.ah.getContext().getResources().getString(2131298661));
            paramString.fK(com.tencent.mm.platformtools.ah.aoy() + 2000L);
            paramString.hL(0);
            paramString.hJ(0);
            aw.aaz();
            com.tencent.mm.model.c.YF().d(paramString);
            paramInt1 = r.Zt();
            aw.aaz();
            com.tencent.mm.model.c.Ru().set(40, Integer.valueOf(paramInt1 & 0xFFFFFF7F));
          }
        }
      }
      if ((paramm.getType() == 138) || (paramm.getType() == 139))
      {
        al.d(new j.2(this));
        this.Ala.dMn();
      }
      AppMethodBeat.o(34487);
      return;
      label1269:
      i = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void dMT();
    
    public abstract void dMU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j
 * JD-Core Version:    0.7.0.1
 */