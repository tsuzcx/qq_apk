package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.c.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Map;

public final class g
  extends l.b
  implements f
{
  private static int qNy = 0;
  private b.a dZA;
  private float dZu;
  private float dZv;
  private int ejF;
  private com.tencent.mm.modelgeo.d fwu;
  private String hyG;
  public int knS;
  private ak mHandler;
  private c qNT;
  private e qNU;
  private boolean qNV;
  private boolean qNW;
  private long qNz;
  
  public g(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(24531);
    this.qNU = new e();
    this.qNz = 0L;
    this.mHandler = new ak();
    this.ejF = 0;
    this.hyG = "";
    this.qNV = false;
    this.qNW = false;
    this.dZu = -85.0F;
    this.dZv = -1000.0F;
    this.dZA = new g.1(this);
    AppMethodBeat.o(24531);
  }
  
  private void baD()
  {
    AppMethodBeat.i(24542);
    if (this.fwu != null) {
      this.fwu.c(this.dZA);
    }
    AppMethodBeat.o(24542);
  }
  
  private void ckQ()
  {
    AppMethodBeat.i(24541);
    this.fwu = com.tencent.mm.modelgeo.d.agQ();
    this.fwu.a(this.dZA, true);
    AppMethodBeat.o(24541);
  }
  
  private void clx()
  {
    AppMethodBeat.i(24537);
    if (this.qNV)
    {
      ab.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
      AppMethodBeat.o(24537);
      return;
    }
    this.qNV = true;
    this.qNW = false;
    ab.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
    this.qNT = new c(this.dZv, this.dZu, this.ejF, this.hyG);
    aw.Rc().a(this.qNT, 0);
    AppMethodBeat.o(24537);
  }
  
  private void cly()
  {
    AppMethodBeat.i(24544);
    long l2 = System.currentTimeMillis() / 1000L;
    if (a.Dl(qNy)) {
      ab.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
    }
    for (long l1 = a.Dm(qNy);; l1 = a.Dn(a.clM()))
    {
      ab.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is ".concat(String.valueOf(l1)));
      this.qNz = (l1 + l2);
      AppMethodBeat.o(24544);
      return;
      ab.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
    }
  }
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(24533);
    if ((paramString != null) && (paramString.length() <= 256))
    {
      ab.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + this.hyG);
      this.hyG = paramString;
      AppMethodBeat.o(24533);
      return;
    }
    ab.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(24533);
  }
  
  public final void ckR()
  {
    AppMethodBeat.i(24540);
    aw.Rc().b(1250, this);
    baD();
    super.ckR();
    AppMethodBeat.o(24540);
  }
  
  public final void init()
  {
    AppMethodBeat.i(24534);
    qNy = com.tencent.mm.plugin.shake.b.m.clt().qNy;
    this.qNz = com.tencent.mm.plugin.shake.b.m.clt().qNz;
    this.dZu = com.tencent.mm.plugin.shake.b.m.clt().dZu;
    this.dZv = com.tencent.mm.plugin.shake.b.m.clt().dZv;
    aw.Rc().a(1250, this);
    ckQ();
    AppMethodBeat.o(24534);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(24543);
    if ((paramm instanceof c))
    {
      paramm = (c)paramm;
      paramString = this.qNU;
      paramm = paramm.qNx;
      paramString.knS = paramm.knS;
      paramString.kml = paramm.kml;
      paramString.cHo = paramm.cHo;
      paramString.title = paramm.title;
      paramString.kmn = paramm.kmn;
      paramString.kmo = paramm.kmo;
      paramString.knw = paramm.knw;
      paramString.kmm = paramm.kmm;
      paramString.color = paramm.color;
      paramString.qNy = paramm.qNy;
      paramString.qNB = paramm.qNB;
      paramString.qNC = paramm.qNC;
      paramString.qND = paramm.qND;
      paramString.qNE = paramm.qNE;
      paramString.qNF = paramm.qNF;
      paramString.kmq = paramm.kmq;
      paramString.qNG = paramm.qNG;
      paramString.qNH = paramm.qNH;
      this.knS = this.qNU.knS;
      ab.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.knS + "  frequency_level:" + qNy + " control_flag:" + this.qNU.qNB);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label344;
      }
      qNy = this.qNU.qNy;
      ab.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
      if (this.qNe != null) {
        this.qNe.a(1250, this.qNU, 1L);
      }
      cly();
    }
    for (;;)
    {
      com.tencent.mm.plugin.shake.b.m.clt().qNy = qNy;
      com.tencent.mm.plugin.shake.b.m.clt().qNz = this.qNz;
      this.qNV = false;
      AppMethodBeat.o(24543);
      return;
      label344:
      if (((paramInt1 == 5) && (paramInt2 == -1)) || ((paramInt1 == 4) && (paramInt2 != 0)))
      {
        ab.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.qNe != null) {
          this.qNe.a(1250, this.qNU, 2L);
        }
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = a.Dn(a.clM());
        ab.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is ".concat(String.valueOf(l2)));
        this.qNz = (l1 + l2);
      }
      else
      {
        ab.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.qNe != null) {
          this.qNe.a(1250, this.qNU, 2L);
        }
        cly();
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(24538);
    baD();
    AppMethodBeat.o(24538);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(24535);
    if (this.qNT != null) {
      aw.Rc().a(this.qNT);
    }
    AppMethodBeat.o(24535);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(24539);
    if (this.fwu != null) {
      this.fwu.a(this.dZA, true);
    }
    AppMethodBeat.o(24539);
  }
  
  public final void setFromScene(int paramInt)
  {
    AppMethodBeat.i(24532);
    this.ejF = paramInt;
    ab.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(24532);
  }
  
  public final void start()
  {
    AppMethodBeat.i(24536);
    init();
    reset();
    if (this.fwu == null) {
      ckQ();
    }
    this.fwu.b(this.dZA, true);
    Object localObject = com.tencent.mm.plugin.shake.b.m.clt();
    if ((!TextUtils.isEmpty("key_shake_card_item")) && (((d)localObject).kln.containsKey("key_shake_card_item"))) {}
    long l1;
    long l2;
    for (localObject = ((d)localObject).kln.get("key_shake_card_item");; localObject = null)
    {
      l1 = System.currentTimeMillis() / 1000L;
      l2 = this.qNz;
      if ((localObject == null) || (!(localObject instanceof e))) {
        break;
      }
      localObject = (e)localObject;
      this.qNe.a(1250, (e)localObject, 1L);
      com.tencent.mm.plugin.shake.b.m.clt().putValue("key_shake_card_item", null);
      ab.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
      AppMethodBeat.o(24536);
      return;
    }
    int i;
    if (this.qNz == 0L) {
      i = 1;
    }
    while (i != 0) {
      if (this.qNV)
      {
        ab.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
        AppMethodBeat.o(24536);
        return;
        if (l1 - l2 >= 0L)
        {
          i = 1;
        }
        else
        {
          h.qsU.e(11666, new Object[] { Integer.valueOf(this.ejF) });
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24529);
              g.e(g.this).knS = 3;
              g.a(g.this, g.e(g.this).knS);
              g.e(g.this).qNF = com.tencent.mm.plugin.shake.b.m.clt().qNA;
              if (g.f(g.this) != null) {
                g.g(g.this).a(1250, g.e(g.this), 2L);
              }
              AppMethodBeat.o(24529);
            }
          }, 3000L);
          ab.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
          i = 0;
        }
      }
      else
      {
        if ((this.dZu == -85.0F) || (this.dZv == -1000.0F))
        {
          this.qNW = true;
          ab.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24530);
              if (!g.h(g.this)) {
                g.d(g.this);
              }
              AppMethodBeat.o(24530);
            }
          }, 4000L);
          AppMethodBeat.o(24536);
          return;
        }
        clx();
      }
    }
    AppMethodBeat.o(24536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.g
 * JD-Core Version:    0.7.0.1
 */