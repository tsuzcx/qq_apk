package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.c.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Map;

public final class g
  extends l.b
  implements i
{
  private static int Dhr = 0;
  private c DhM;
  private e DhN;
  private boolean DhO;
  private boolean DhP;
  private long Dhs;
  private b.a gmA;
  private float gmu;
  private float gmv;
  private int gwE;
  private com.tencent.mm.modelgeo.d iOv;
  private String lAo;
  private MMHandler mHandler;
  public int pTI;
  
  public g(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28202);
    this.DhN = new e();
    this.Dhs = 0L;
    this.mHandler = new MMHandler();
    this.gwE = 0;
    this.lAo = "";
    this.DhO = false;
    this.DhP = false;
    this.gmu = -85.0F;
    this.gmv = -1000.0F;
    this.gmA = new b.a()
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
          m.eUs().gmu = g.a(g.this);
          m.eUs().gmv = g.b(g.this);
          if (g.c(g.this))
          {
            Log.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
            g.d(g.this);
          }
        }
        AppMethodBeat.o(28199);
        return false;
      }
    };
    AppMethodBeat.o(28202);
  }
  
  private void csp()
  {
    AppMethodBeat.i(28213);
    if (this.iOv != null) {
      this.iOv.c(this.gmA);
    }
    AppMethodBeat.o(28213);
  }
  
  private void eTP()
  {
    AppMethodBeat.i(28212);
    this.iOv = com.tencent.mm.modelgeo.d.bca();
    this.iOv.a(this.gmA, true);
    AppMethodBeat.o(28212);
  }
  
  private void eUw()
  {
    AppMethodBeat.i(28208);
    if (this.DhO)
    {
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
      AppMethodBeat.o(28208);
      return;
    }
    this.DhO = true;
    this.DhP = false;
    Log.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
    this.DhM = new c(this.gmv, this.gmu, this.gwE, this.lAo);
    bg.azz().a(this.DhM, 0);
    AppMethodBeat.o(28208);
  }
  
  private void eUx()
  {
    AppMethodBeat.i(28215);
    long l2 = System.currentTimeMillis() / 1000L;
    if (a.Xx(Dhr)) {
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
    }
    for (long l1 = a.Xy(Dhr);; l1 = a.Xz(a.eUK()))
    {
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is ".concat(String.valueOf(l1)));
      this.Dhs = (l1 + l2);
      AppMethodBeat.o(28215);
      return;
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
    }
  }
  
  public final void Rv(String paramString)
  {
    AppMethodBeat.i(28204);
    if ((paramString != null) && (paramString.length() <= 256))
    {
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + this.lAo);
      this.lAo = paramString;
      AppMethodBeat.o(28204);
      return;
    }
    Log.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(28204);
  }
  
  public final void eTQ()
  {
    AppMethodBeat.i(28211);
    bg.azz().b(1250, this);
    csp();
    super.eTQ();
    AppMethodBeat.o(28211);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28205);
    Dhr = m.eUs().Dhr;
    this.Dhs = m.eUs().Dhs;
    this.gmu = m.eUs().gmu;
    this.gmv = m.eUs().gmv;
    bg.azz().a(1250, this);
    eTP();
    AppMethodBeat.o(28205);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(28214);
    if ((paramq instanceof c))
    {
      paramq = (c)paramq;
      paramString = this.DhN;
      paramq = paramq.Dhq;
      paramString.pTI = paramq.pTI;
      paramString.pRX = paramq.pRX;
      paramString.eaP = paramq.eaP;
      paramString.title = paramq.title;
      paramString.pRY = paramq.pRY;
      paramString.pRZ = paramq.pRZ;
      paramString.gTG = paramq.gTG;
      paramString.iwv = paramq.iwv;
      paramString.ixw = paramq.ixw;
      paramString.Dhr = paramq.Dhr;
      paramString.Dhu = paramq.Dhu;
      paramString.Dhv = paramq.Dhv;
      paramString.Dhw = paramq.Dhw;
      paramString.Dhx = paramq.Dhx;
      paramString.Dhy = paramq.Dhy;
      paramString.pSb = paramq.pSb;
      paramString.Dhz = paramq.Dhz;
      paramString.DhA = paramq.DhA;
      this.pTI = this.DhN.pTI;
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.pTI + "  frequency_level:" + Dhr + " control_flag:" + this.DhN.Dhu);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label344;
      }
      Dhr = this.DhN.Dhr;
      Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
      if (this.DgX != null) {
        this.DgX.a(1250, this.DhN, 1L);
      }
      eUx();
    }
    for (;;)
    {
      m.eUs().Dhr = Dhr;
      m.eUs().Dhs = this.Dhs;
      this.DhO = false;
      AppMethodBeat.o(28214);
      return;
      label344:
      if (((paramInt1 == 5) && (paramInt2 == -1)) || ((paramInt1 == 4) && (paramInt2 != 0)))
      {
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.DgX != null) {
          this.DgX.a(1250, this.DhN, 2L);
        }
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = a.Xz(a.eUK());
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is ".concat(String.valueOf(l2)));
        this.Dhs = (l1 + l2);
      }
      else
      {
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.DgX != null) {
          this.DgX.a(1250, this.DhN, 2L);
        }
        eUx();
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28209);
    csp();
    AppMethodBeat.o(28209);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28206);
    if (this.DhM != null) {
      bg.azz().a(this.DhM);
    }
    AppMethodBeat.o(28206);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28210);
    if (this.iOv != null) {
      this.iOv.a(this.gmA, true);
    }
    AppMethodBeat.o(28210);
  }
  
  public final void setFromScene(int paramInt)
  {
    AppMethodBeat.i(28203);
    this.gwE = paramInt;
    Log.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(28203);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28207);
    init();
    reset();
    if (this.iOv == null) {
      eTP();
    }
    this.iOv.b(this.gmA, true);
    Object localObject = m.eUs();
    if ((!TextUtils.isEmpty("key_shake_card_item")) && (((d)localObject).pQY.containsKey("key_shake_card_item"))) {}
    long l1;
    long l2;
    for (localObject = ((d)localObject).pQY.get("key_shake_card_item");; localObject = null)
    {
      l1 = System.currentTimeMillis() / 1000L;
      l2 = this.Dhs;
      if ((localObject == null) || (!(localObject instanceof e))) {
        break;
      }
      localObject = (e)localObject;
      this.DgX.a(1250, (e)localObject, 1L);
      m.eUs().putValue("key_shake_card_item", null);
      Log.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
      AppMethodBeat.o(28207);
      return;
    }
    int i;
    if (this.Dhs == 0L) {
      i = 1;
    }
    while (i != 0) {
      if (this.DhO)
      {
        Log.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
        AppMethodBeat.o(28207);
        return;
        if (l1 - l2 >= 0L)
        {
          i = 1;
        }
        else
        {
          h.CyF.a(11666, new Object[] { Integer.valueOf(this.gwE) });
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(28200);
              g.e(g.this).pTI = 3;
              g.a(g.this, g.e(g.this).pTI);
              g.e(g.this).Dhy = m.eUs().Dht;
              if (g.f(g.this) != null) {
                g.g(g.this).a(1250, g.e(g.this), 2L);
              }
              AppMethodBeat.o(28200);
            }
          }, 3000L);
          Log.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
          i = 0;
        }
      }
      else
      {
        if ((this.gmu == -85.0F) || (this.gmv == -1000.0F))
        {
          this.DhP = true;
          Log.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
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
        eUw();
      }
    }
    AppMethodBeat.o(28207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.g
 * JD-Core Version:    0.7.0.1
 */