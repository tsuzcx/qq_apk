package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.c.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Map;

public final class g
  extends l.b
  implements f
{
  private static int zcz = 0;
  private float fHj;
  private float fHk;
  private b.a fHp;
  private int fRv;
  private com.tencent.mm.modelgeo.d hTg;
  private String kwk;
  private aq mHandler;
  public int oGc;
  private long zcA;
  private c zcU;
  private e zcV;
  private boolean zcW;
  private boolean zcX;
  
  public g(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28202);
    this.zcV = new e();
    this.zcA = 0L;
    this.mHandler = new aq();
    this.fRv = 0;
    this.kwk = "";
    this.zcW = false;
    this.zcX = false;
    this.fHj = -85.0F;
    this.fHk = -1000.0F;
    this.fHp = new b.a()
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
          m.dSr().fHj = g.a(g.this);
          m.dSr().fHk = g.b(g.this);
          if (g.c(g.this))
          {
            ae.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
            g.d(g.this);
          }
        }
        AppMethodBeat.o(28199);
        return false;
      }
    };
    AppMethodBeat.o(28202);
  }
  
  private void bUB()
  {
    AppMethodBeat.i(28213);
    if (this.hTg != null) {
      this.hTg.c(this.fHp);
    }
    AppMethodBeat.o(28213);
  }
  
  private void dRO()
  {
    AppMethodBeat.i(28212);
    this.hTg = com.tencent.mm.modelgeo.d.aIh();
    this.hTg.a(this.fHp, true);
    AppMethodBeat.o(28212);
  }
  
  private void dSv()
  {
    AppMethodBeat.i(28208);
    if (this.zcW)
    {
      ae.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
      AppMethodBeat.o(28208);
      return;
    }
    this.zcW = true;
    this.zcX = false;
    ae.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
    this.zcU = new c(this.fHk, this.fHj, this.fRv, this.kwk);
    bc.ajj().a(this.zcU, 0);
    AppMethodBeat.o(28208);
  }
  
  private void dSw()
  {
    AppMethodBeat.i(28215);
    long l2 = System.currentTimeMillis() / 1000L;
    if (a.PU(zcz)) {
      ae.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
    }
    for (long l1 = a.PV(zcz);; l1 = a.PW(a.dSJ()))
    {
      ae.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is ".concat(String.valueOf(l1)));
      this.zcA = (l1 + l2);
      AppMethodBeat.o(28215);
      return;
      ae.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
    }
  }
  
  public final void abf(String paramString)
  {
    AppMethodBeat.i(28204);
    if ((paramString != null) && (paramString.length() <= 256))
    {
      ae.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + this.kwk);
      this.kwk = paramString;
      AppMethodBeat.o(28204);
      return;
    }
    ae.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(28204);
  }
  
  public final void dRP()
  {
    AppMethodBeat.i(28211);
    bc.ajj().b(1250, this);
    bUB();
    super.dRP();
    AppMethodBeat.o(28211);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28205);
    zcz = m.dSr().zcz;
    this.zcA = m.dSr().zcA;
    this.fHj = m.dSr().fHj;
    this.fHk = m.dSr().fHk;
    bc.ajj().a(1250, this);
    dRO();
    AppMethodBeat.o(28205);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28214);
    if ((paramn instanceof c))
    {
      paramn = (c)paramn;
      paramString = this.zcV;
      paramn = paramn.zcy;
      paramString.oGc = paramn.oGc;
      paramString.oEo = paramn.oEo;
      paramString.dJc = paramn.dJc;
      paramString.title = paramn.title;
      paramString.oEp = paramn.oEp;
      paramString.oEq = paramn.oEq;
      paramString.oFG = paramn.oFG;
      paramString.hCp = paramn.hCp;
      paramString.hDr = paramn.hDr;
      paramString.zcz = paramn.zcz;
      paramString.zcC = paramn.zcC;
      paramString.zcD = paramn.zcD;
      paramString.zcE = paramn.zcE;
      paramString.zcF = paramn.zcF;
      paramString.zcG = paramn.zcG;
      paramString.oEs = paramn.oEs;
      paramString.zcH = paramn.zcH;
      paramString.zcI = paramn.zcI;
      this.oGc = this.zcV.oGc;
      ae.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.oGc + "  frequency_level:" + zcz + " control_flag:" + this.zcV.zcC);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label344;
      }
      zcz = this.zcV.zcz;
      ae.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
      if (this.zcf != null) {
        this.zcf.a(1250, this.zcV, 1L);
      }
      dSw();
    }
    for (;;)
    {
      m.dSr().zcz = zcz;
      m.dSr().zcA = this.zcA;
      this.zcW = false;
      AppMethodBeat.o(28214);
      return;
      label344:
      if (((paramInt1 == 5) && (paramInt2 == -1)) || ((paramInt1 == 4) && (paramInt2 != 0)))
      {
        ae.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.zcf != null) {
          this.zcf.a(1250, this.zcV, 2L);
        }
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = a.PW(a.dSJ());
        ae.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is ".concat(String.valueOf(l2)));
        this.zcA = (l1 + l2);
      }
      else
      {
        ae.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.zcf != null) {
          this.zcf.a(1250, this.zcV, 2L);
        }
        dSw();
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28209);
    bUB();
    AppMethodBeat.o(28209);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28206);
    if (this.zcU != null) {
      bc.ajj().a(this.zcU);
    }
    AppMethodBeat.o(28206);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28210);
    if (this.hTg != null) {
      this.hTg.a(this.fHp, true);
    }
    AppMethodBeat.o(28210);
  }
  
  public final void setFromScene(int paramInt)
  {
    AppMethodBeat.i(28203);
    this.fRv = paramInt;
    ae.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(28203);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28207);
    init();
    reset();
    if (this.hTg == null) {
      dRO();
    }
    this.hTg.b(this.fHp, true);
    Object localObject = m.dSr();
    if ((!TextUtils.isEmpty("key_shake_card_item")) && (((d)localObject).oDp.containsKey("key_shake_card_item"))) {}
    long l1;
    long l2;
    for (localObject = ((d)localObject).oDp.get("key_shake_card_item");; localObject = null)
    {
      l1 = System.currentTimeMillis() / 1000L;
      l2 = this.zcA;
      if ((localObject == null) || (!(localObject instanceof e))) {
        break;
      }
      localObject = (e)localObject;
      this.zcf.a(1250, (e)localObject, 1L);
      m.dSr().putValue("key_shake_card_item", null);
      ae.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
      AppMethodBeat.o(28207);
      return;
    }
    int i;
    if (this.zcA == 0L) {
      i = 1;
    }
    while (i != 0) {
      if (this.zcW)
      {
        ae.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
        AppMethodBeat.o(28207);
        return;
        if (l1 - l2 >= 0L)
        {
          i = 1;
        }
        else
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(11666, new Object[] { Integer.valueOf(this.fRv) });
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(28200);
              g.e(g.this).oGc = 3;
              g.a(g.this, g.e(g.this).oGc);
              g.e(g.this).zcG = m.dSr().zcB;
              if (g.f(g.this) != null) {
                g.g(g.this).a(1250, g.e(g.this), 2L);
              }
              AppMethodBeat.o(28200);
            }
          }, 3000L);
          ae.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
          i = 0;
        }
      }
      else
      {
        if ((this.fHj == -85.0F) || (this.fHk == -1000.0F))
        {
          this.zcX = true;
          ae.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
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
        dSv();
      }
    }
    AppMethodBeat.o(28207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.g
 * JD-Core Version:    0.7.0.1
 */