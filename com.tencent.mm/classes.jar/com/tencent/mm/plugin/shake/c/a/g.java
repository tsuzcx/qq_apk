package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.c.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Map;

public final class g
  extends l.b
  implements f
{
  private static int yMp = 0;
  private float fFf;
  private float fFg;
  private b.a fFl;
  private int fPp;
  private com.tencent.mm.modelgeo.d hQo;
  private String ksU;
  private ap mHandler;
  public int ozA;
  private c yMK;
  private e yML;
  private boolean yMM;
  private boolean yMN;
  private long yMq;
  
  public g(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28202);
    this.yML = new e();
    this.yMq = 0L;
    this.mHandler = new ap();
    this.fPp = 0;
    this.ksU = "";
    this.yMM = false;
    this.yMN = false;
    this.fFf = -85.0F;
    this.fFg = -1000.0F;
    this.fFl = new b.a()
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
          m.dOU().fFf = g.a(g.this);
          m.dOU().fFg = g.b(g.this);
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
  
  private void bTm()
  {
    AppMethodBeat.i(28213);
    if (this.hQo != null) {
      this.hQo.c(this.fFl);
    }
    AppMethodBeat.o(28213);
  }
  
  private void dOY()
  {
    AppMethodBeat.i(28208);
    if (this.yMM)
    {
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
      AppMethodBeat.o(28208);
      return;
    }
    this.yMM = true;
    this.yMN = false;
    ad.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
    this.yMK = new c(this.fFg, this.fFf, this.fPp, this.ksU);
    ba.aiU().a(this.yMK, 0);
    AppMethodBeat.o(28208);
  }
  
  private void dOZ()
  {
    AppMethodBeat.i(28215);
    long l2 = System.currentTimeMillis() / 1000L;
    if (a.Pn(yMp)) {
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
    }
    for (long l1 = a.Po(yMp);; l1 = a.Pp(a.dPm()))
    {
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is ".concat(String.valueOf(l1)));
      this.yMq = (l1 + l2);
      AppMethodBeat.o(28215);
      return;
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
    }
  }
  
  private void dOr()
  {
    AppMethodBeat.i(28212);
    this.hQo = com.tencent.mm.modelgeo.d.aHQ();
    this.hQo.a(this.fFl, true);
    AppMethodBeat.o(28212);
  }
  
  public final void aao(String paramString)
  {
    AppMethodBeat.i(28204);
    if ((paramString != null) && (paramString.length() <= 256))
    {
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + this.ksU);
      this.ksU = paramString;
      AppMethodBeat.o(28204);
      return;
    }
    ad.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(28204);
  }
  
  public final void dOs()
  {
    AppMethodBeat.i(28211);
    ba.aiU().b(1250, this);
    bTm();
    super.dOs();
    AppMethodBeat.o(28211);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28205);
    yMp = m.dOU().yMp;
    this.yMq = m.dOU().yMq;
    this.fFf = m.dOU().fFf;
    this.fFg = m.dOU().fFg;
    ba.aiU().a(1250, this);
    dOr();
    AppMethodBeat.o(28205);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28214);
    if ((paramn instanceof c))
    {
      paramn = (c)paramn;
      paramString = this.yML;
      paramn = paramn.yMo;
      paramString.ozA = paramn.ozA;
      paramString.oxM = paramn.oxM;
      paramString.dHY = paramn.dHY;
      paramString.title = paramn.title;
      paramString.oxN = paramn.oxN;
      paramString.oxO = paramn.oxO;
      paramString.oze = paramn.oze;
      paramString.hzB = paramn.hzB;
      paramString.hAD = paramn.hAD;
      paramString.yMp = paramn.yMp;
      paramString.yMs = paramn.yMs;
      paramString.yMt = paramn.yMt;
      paramString.yMu = paramn.yMu;
      paramString.yMv = paramn.yMv;
      paramString.yMw = paramn.yMw;
      paramString.oxQ = paramn.oxQ;
      paramString.yMx = paramn.yMx;
      paramString.yMy = paramn.yMy;
      this.ozA = this.yML.ozA;
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.ozA + "  frequency_level:" + yMp + " control_flag:" + this.yML.yMs);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label344;
      }
      yMp = this.yML.yMp;
      ad.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
      if (this.yLV != null) {
        this.yLV.a(1250, this.yML, 1L);
      }
      dOZ();
    }
    for (;;)
    {
      m.dOU().yMp = yMp;
      m.dOU().yMq = this.yMq;
      this.yMM = false;
      AppMethodBeat.o(28214);
      return;
      label344:
      if (((paramInt1 == 5) && (paramInt2 == -1)) || ((paramInt1 == 4) && (paramInt2 != 0)))
      {
        ad.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.yLV != null) {
          this.yLV.a(1250, this.yML, 2L);
        }
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = a.Pp(a.dPm());
        ad.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is ".concat(String.valueOf(l2)));
        this.yMq = (l1 + l2);
      }
      else
      {
        ad.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.yLV != null) {
          this.yLV.a(1250, this.yML, 2L);
        }
        dOZ();
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28209);
    bTm();
    AppMethodBeat.o(28209);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28206);
    if (this.yMK != null) {
      ba.aiU().a(this.yMK);
    }
    AppMethodBeat.o(28206);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28210);
    if (this.hQo != null) {
      this.hQo.a(this.fFl, true);
    }
    AppMethodBeat.o(28210);
  }
  
  public final void setFromScene(int paramInt)
  {
    AppMethodBeat.i(28203);
    this.fPp = paramInt;
    ad.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(28203);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28207);
    init();
    reset();
    if (this.hQo == null) {
      dOr();
    }
    this.hQo.b(this.fFl, true);
    Object localObject = m.dOU();
    if ((!TextUtils.isEmpty("key_shake_card_item")) && (((d)localObject).owN.containsKey("key_shake_card_item"))) {}
    long l1;
    long l2;
    for (localObject = ((d)localObject).owN.get("key_shake_card_item");; localObject = null)
    {
      l1 = System.currentTimeMillis() / 1000L;
      l2 = this.yMq;
      if ((localObject == null) || (!(localObject instanceof e))) {
        break;
      }
      localObject = (e)localObject;
      this.yLV.a(1250, (e)localObject, 1L);
      m.dOU().putValue("key_shake_card_item", null);
      ad.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
      AppMethodBeat.o(28207);
      return;
    }
    int i;
    if (this.yMq == 0L) {
      i = 1;
    }
    while (i != 0) {
      if (this.yMM)
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
          com.tencent.mm.plugin.report.service.g.yhR.f(11666, new Object[] { Integer.valueOf(this.fPp) });
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(28200);
              g.e(g.this).ozA = 3;
              g.a(g.this, g.e(g.this).ozA);
              g.e(g.this).yMw = m.dOU().yMr;
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
        if ((this.fFf == -85.0F) || (this.fFg == -1000.0F))
        {
          this.yMN = true;
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
        dOY();
      }
    }
    AppMethodBeat.o(28207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.g
 * JD-Core Version:    0.7.0.1
 */