package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.c.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.Map;

public final class g
  extends l.b
  implements com.tencent.mm.ak.g
{
  private static int xxE = 0;
  private float fmX;
  private float fmY;
  private b.a fnd;
  private int fwc;
  private com.tencent.mm.modelgeo.d hxT;
  private String jYy;
  private ao mHandler;
  public int nWg;
  private long xxF;
  private c xxZ;
  private e xya;
  private boolean xyb;
  private boolean xyc;
  
  public g(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28202);
    this.xya = new e();
    this.xxF = 0L;
    this.mHandler = new ao();
    this.fwc = 0;
    this.jYy = "";
    this.xyb = false;
    this.xyc = false;
    this.fmX = -85.0F;
    this.fmY = -1000.0F;
    this.fnd = new b.a()
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
          m.dDr().fmX = g.a(g.this);
          m.dDr().fmY = g.b(g.this);
          if (g.c(g.this))
          {
            ac.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
            g.d(g.this);
          }
        }
        AppMethodBeat.o(28199);
        return false;
      }
    };
    AppMethodBeat.o(28202);
  }
  
  private void bOH()
  {
    AppMethodBeat.i(28213);
    if (this.hxT != null) {
      this.hxT.c(this.fnd);
    }
    AppMethodBeat.o(28213);
  }
  
  private void dCO()
  {
    AppMethodBeat.i(28212);
    this.hxT = com.tencent.mm.modelgeo.d.aEL();
    this.hxT.a(this.fnd, true);
    AppMethodBeat.o(28212);
  }
  
  private void dDv()
  {
    AppMethodBeat.i(28208);
    if (this.xyb)
    {
      ac.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
      AppMethodBeat.o(28208);
      return;
    }
    this.xyb = true;
    this.xyc = false;
    ac.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
    this.xxZ = new c(this.fmY, this.fmX, this.fwc, this.jYy);
    az.agi().a(this.xxZ, 0);
    AppMethodBeat.o(28208);
  }
  
  private void dDw()
  {
    AppMethodBeat.i(28215);
    long l2 = System.currentTimeMillis() / 1000L;
    if (a.NK(xxE)) {
      ac.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
    }
    for (long l1 = a.NL(xxE);; l1 = a.NM(a.dDJ()))
    {
      ac.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is ".concat(String.valueOf(l1)));
      this.xxF = (l1 + l2);
      AppMethodBeat.o(28215);
      return;
      ac.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
    }
  }
  
  public final void WH(String paramString)
  {
    AppMethodBeat.i(28204);
    if ((paramString != null) && (paramString.length() <= 256))
    {
      ac.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + this.jYy);
      this.jYy = paramString;
      AppMethodBeat.o(28204);
      return;
    }
    ac.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(28204);
  }
  
  public final void dCP()
  {
    AppMethodBeat.i(28211);
    az.agi().b(1250, this);
    bOH();
    super.dCP();
    AppMethodBeat.o(28211);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28205);
    xxE = m.dDr().xxE;
    this.xxF = m.dDr().xxF;
    this.fmX = m.dDr().fmX;
    this.fmY = m.dDr().fmY;
    az.agi().a(1250, this);
    dCO();
    AppMethodBeat.o(28205);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28214);
    if ((paramn instanceof c))
    {
      paramn = (c)paramn;
      paramString = this.xya;
      paramn = paramn.xxD;
      paramString.nWg = paramn.nWg;
      paramString.nUr = paramn.nUr;
      paramString.dvP = paramn.dvP;
      paramString.title = paramn.title;
      paramString.nUs = paramn.nUs;
      paramString.nUt = paramn.nUt;
      paramString.nVK = paramn.nVK;
      paramString.hhs = paramn.hhs;
      paramString.hiu = paramn.hiu;
      paramString.xxE = paramn.xxE;
      paramString.xxH = paramn.xxH;
      paramString.xxI = paramn.xxI;
      paramString.xxJ = paramn.xxJ;
      paramString.xxK = paramn.xxK;
      paramString.xxL = paramn.xxL;
      paramString.nUv = paramn.nUv;
      paramString.xxM = paramn.xxM;
      paramString.xxN = paramn.xxN;
      this.nWg = this.xya.nWg;
      ac.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.nWg + "  frequency_level:" + xxE + " control_flag:" + this.xya.xxH);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label344;
      }
      xxE = this.xya.xxE;
      ac.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
      if (this.xxk != null) {
        this.xxk.a(1250, this.xya, 1L);
      }
      dDw();
    }
    for (;;)
    {
      m.dDr().xxE = xxE;
      m.dDr().xxF = this.xxF;
      this.xyb = false;
      AppMethodBeat.o(28214);
      return;
      label344:
      if (((paramInt1 == 5) && (paramInt2 == -1)) || ((paramInt1 == 4) && (paramInt2 != 0)))
      {
        ac.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.xxk != null) {
          this.xxk.a(1250, this.xya, 2L);
        }
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = a.NM(a.dDJ());
        ac.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is ".concat(String.valueOf(l2)));
        this.xxF = (l1 + l2);
      }
      else
      {
        ac.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.xxk != null) {
          this.xxk.a(1250, this.xya, 2L);
        }
        dDw();
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28209);
    bOH();
    AppMethodBeat.o(28209);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28206);
    if (this.xxZ != null) {
      az.agi().a(this.xxZ);
    }
    AppMethodBeat.o(28206);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28210);
    if (this.hxT != null) {
      this.hxT.a(this.fnd, true);
    }
    AppMethodBeat.o(28210);
  }
  
  public final void setFromScene(int paramInt)
  {
    AppMethodBeat.i(28203);
    this.fwc = paramInt;
    ac.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(28203);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28207);
    init();
    reset();
    if (this.hxT == null) {
      dCO();
    }
    this.hxT.b(this.fnd, true);
    Object localObject = m.dDr();
    if ((!TextUtils.isEmpty("key_shake_card_item")) && (((d)localObject).nTs.containsKey("key_shake_card_item"))) {}
    long l1;
    long l2;
    for (localObject = ((d)localObject).nTs.get("key_shake_card_item");; localObject = null)
    {
      l1 = System.currentTimeMillis() / 1000L;
      l2 = this.xxF;
      if ((localObject == null) || (!(localObject instanceof e))) {
        break;
      }
      localObject = (e)localObject;
      this.xxk.a(1250, (e)localObject, 1L);
      m.dDr().putValue("key_shake_card_item", null);
      ac.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
      AppMethodBeat.o(28207);
      return;
    }
    int i;
    if (this.xxF == 0L) {
      i = 1;
    }
    while (i != 0) {
      if (this.xyb)
      {
        ac.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
        AppMethodBeat.o(28207);
        return;
        if (l1 - l2 >= 0L)
        {
          i = 1;
        }
        else
        {
          h.wUl.f(11666, new Object[] { Integer.valueOf(this.fwc) });
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(28200);
              g.e(g.this).nWg = 3;
              g.a(g.this, g.e(g.this).nWg);
              g.e(g.this).xxL = m.dDr().xxG;
              if (g.f(g.this) != null) {
                g.g(g.this).a(1250, g.e(g.this), 2L);
              }
              AppMethodBeat.o(28200);
            }
          }, 3000L);
          ac.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
          i = 0;
        }
      }
      else
      {
        if ((this.fmX == -85.0F) || (this.fmY == -1000.0F))
        {
          this.xyc = true;
          ac.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
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
        dDv();
      }
    }
    AppMethodBeat.o(28207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.g
 * JD-Core Version:    0.7.0.1
 */