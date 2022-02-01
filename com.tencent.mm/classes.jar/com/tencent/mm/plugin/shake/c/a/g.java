package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.c.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Map;

public final class g
  extends l.b
  implements com.tencent.mm.al.g
{
  private static int wmo = 0;
  private float fjD;
  private float fjE;
  private b.a fjJ;
  private int fsv;
  private com.tencent.mm.modelgeo.d gXu;
  private String jyd;
  private ap mHandler;
  public int ntg;
  private c wmJ;
  private e wmK;
  private boolean wmL;
  private boolean wmM;
  private long wmp;
  
  public g(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28202);
    this.wmK = new e();
    this.wmp = 0L;
    this.mHandler = new ap();
    this.fsv = 0;
    this.jyd = "";
    this.wmL = false;
    this.wmM = false;
    this.fjD = -85.0F;
    this.fjE = -1000.0F;
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28199);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(28199);
          return true;
        }
        if ((g.a(g.this) == -85.0F) && (g.b(g.this) == -1000.0F))
        {
          g.a(g.this, paramAnonymousFloat2);
          g.b(g.this, paramAnonymousFloat1);
          m.dph().fjD = g.a(g.this);
          m.dph().fjE = g.b(g.this);
          if (g.c(g.this))
          {
            ad.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
            g.d(g.this);
          }
        }
        AppMethodBeat.o(28199);
        return false;
      }
    };
    AppMethodBeat.o(28202);
  }
  
  private void bHu()
  {
    AppMethodBeat.i(28213);
    if (this.gXu != null) {
      this.gXu.c(this.fjJ);
    }
    AppMethodBeat.o(28213);
  }
  
  private void doE()
  {
    AppMethodBeat.i(28212);
    this.gXu = com.tencent.mm.modelgeo.d.axT();
    this.gXu.a(this.fjJ, true);
    AppMethodBeat.o(28212);
  }
  
  private void dpl()
  {
    AppMethodBeat.i(28208);
    if (this.wmL)
    {
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
      AppMethodBeat.o(28208);
      return;
    }
    this.wmL = true;
    this.wmM = false;
    ad.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
    this.wmJ = new c(this.fjE, this.fjD, this.fsv, this.jyd);
    az.aeS().a(this.wmJ, 0);
    AppMethodBeat.o(28208);
  }
  
  private void dpm()
  {
    AppMethodBeat.i(28215);
    long l2 = System.currentTimeMillis() / 1000L;
    if (a.LK(wmo)) {
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
    }
    for (long l1 = a.LL(wmo);; l1 = a.LM(a.dpz()))
    {
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is ".concat(String.valueOf(l1)));
      this.wmp = (l1 + l2);
      AppMethodBeat.o(28215);
      return;
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
    }
  }
  
  public final void Sv(String paramString)
  {
    AppMethodBeat.i(28204);
    if ((paramString != null) && (paramString.length() <= 256))
    {
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + this.jyd);
      this.jyd = paramString;
      AppMethodBeat.o(28204);
      return;
    }
    ad.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(28204);
  }
  
  public final void doF()
  {
    AppMethodBeat.i(28211);
    az.aeS().b(1250, this);
    bHu();
    super.doF();
    AppMethodBeat.o(28211);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28205);
    wmo = m.dph().wmo;
    this.wmp = m.dph().wmp;
    this.fjD = m.dph().fjD;
    this.fjE = m.dph().fjE;
    az.aeS().a(1250, this);
    doE();
    AppMethodBeat.o(28205);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28214);
    if ((paramn instanceof c))
    {
      paramn = (c)paramn;
      paramString = this.wmK;
      paramn = paramn.wmn;
      paramString.ntg = paramn.ntg;
      paramString.nrr = paramn.nrr;
      paramString.dyd = paramn.dyd;
      paramString.title = paramn.title;
      paramString.nrs = paramn.nrs;
      paramString.nrt = paramn.nrt;
      paramString.nsK = paramn.nsK;
      paramString.gGR = paramn.gGR;
      paramString.gHT = paramn.gHT;
      paramString.wmo = paramn.wmo;
      paramString.wmr = paramn.wmr;
      paramString.wms = paramn.wms;
      paramString.wmt = paramn.wmt;
      paramString.wmu = paramn.wmu;
      paramString.wmv = paramn.wmv;
      paramString.nrv = paramn.nrv;
      paramString.wmw = paramn.wmw;
      paramString.wmx = paramn.wmx;
      this.ntg = this.wmK.ntg;
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.ntg + "  frequency_level:" + wmo + " control_flag:" + this.wmK.wmr);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label344;
      }
      wmo = this.wmK.wmo;
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
      if (this.wlU != null) {
        this.wlU.a(1250, this.wmK, 1L);
      }
      dpm();
    }
    for (;;)
    {
      m.dph().wmo = wmo;
      m.dph().wmp = this.wmp;
      this.wmL = false;
      AppMethodBeat.o(28214);
      return;
      label344:
      if (((paramInt1 == 5) && (paramInt2 == -1)) || ((paramInt1 == 4) && (paramInt2 != 0)))
      {
        ad.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.wlU != null) {
          this.wlU.a(1250, this.wmK, 2L);
        }
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = a.LM(a.dpz());
        ad.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is ".concat(String.valueOf(l2)));
        this.wmp = (l1 + l2);
      }
      else
      {
        ad.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.wlU != null) {
          this.wlU.a(1250, this.wmK, 2L);
        }
        dpm();
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28209);
    bHu();
    AppMethodBeat.o(28209);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28206);
    if (this.wmJ != null) {
      az.aeS().a(this.wmJ);
    }
    AppMethodBeat.o(28206);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28210);
    if (this.gXu != null) {
      this.gXu.a(this.fjJ, true);
    }
    AppMethodBeat.o(28210);
  }
  
  public final void setFromScene(int paramInt)
  {
    AppMethodBeat.i(28203);
    this.fsv = paramInt;
    ad.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(28203);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28207);
    init();
    reset();
    if (this.gXu == null) {
      doE();
    }
    this.gXu.b(this.fjJ, true);
    Object localObject = m.dph();
    if ((!TextUtils.isEmpty("key_shake_card_item")) && (((d)localObject).nqs.containsKey("key_shake_card_item"))) {}
    long l1;
    long l2;
    for (localObject = ((d)localObject).nqs.get("key_shake_card_item");; localObject = null)
    {
      l1 = System.currentTimeMillis() / 1000L;
      l2 = this.wmp;
      if ((localObject == null) || (!(localObject instanceof e))) {
        break;
      }
      localObject = (e)localObject;
      this.wlU.a(1250, (e)localObject, 1L);
      m.dph().putValue("key_shake_card_item", null);
      ad.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
      AppMethodBeat.o(28207);
      return;
    }
    int i;
    if (this.wmp == 0L) {
      i = 1;
    }
    while (i != 0) {
      if (this.wmL)
      {
        ad.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
        AppMethodBeat.o(28207);
        return;
        if (l1 - l2 >= 0L)
        {
          i = 1;
        }
        else
        {
          h.vKh.f(11666, new Object[] { Integer.valueOf(this.fsv) });
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(28200);
              g.e(g.this).ntg = 3;
              g.a(g.this, g.e(g.this).ntg);
              g.e(g.this).wmv = m.dph().wmq;
              if (g.f(g.this) != null) {
                g.g(g.this).a(1250, g.e(g.this), 2L);
              }
              AppMethodBeat.o(28200);
            }
          }, 3000L);
          ad.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
          i = 0;
        }
      }
      else
      {
        if ((this.fjD == -85.0F) || (this.fjE == -1000.0F))
        {
          this.wmM = true;
          ad.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(28201);
              if (!g.h(g.this)) {
                g.d(g.this);
              }
              AppMethodBeat.o(28201);
            }
          }, 4000L);
          AppMethodBeat.o(28207);
          return;
        }
        dpl();
      }
    }
    AppMethodBeat.o(28207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.g
 * JD-Core Version:    0.7.0.1
 */