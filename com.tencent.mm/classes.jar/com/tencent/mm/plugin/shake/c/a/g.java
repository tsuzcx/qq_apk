package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.c.c.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class g
  extends l.b
  implements f
{
  private static int nZo = 0;
  private float dia = -85.0F;
  private float dib = -1000.0F;
  private a.a dig = new g.1(this);
  public int drX = 0;
  private com.tencent.mm.modelgeo.c egs;
  public String ghS = "";
  public int imX;
  private ah mHandler = new ah();
  private c nZJ;
  private e nZK = new e();
  private boolean nZL = false;
  private boolean nZM = false;
  private long nZp = 0L;
  
  public g(l.a parama)
  {
    super(parama);
  }
  
  private void ayX()
  {
    if (this.egs != null) {
      this.egs.c(this.dig);
    }
  }
  
  private void bAe()
  {
    if (this.nZL)
    {
      y.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
      return;
    }
    this.nZL = true;
    this.nZM = false;
    y.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
    this.nZJ = new c(this.dib, this.dia, this.drX, this.ghS);
    au.Dk().a(this.nZJ, 0);
  }
  
  private void bAf()
  {
    long l2 = System.currentTimeMillis() / 1000L;
    if (a.xl(nZo)) {
      y.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
    }
    for (long l1 = a.xm(nZo);; l1 = a.xn(a.bAs()))
    {
      y.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is " + l1);
      this.nZp = (l1 + l2);
      return;
      y.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
    }
  }
  
  private void bzG()
  {
    this.egs = com.tencent.mm.modelgeo.c.Ob();
    this.egs.a(this.dig, true);
  }
  
  public final void bzH()
  {
    au.Dk().b(1250, this);
    ayX();
    super.bzH();
  }
  
  public final void init()
  {
    nZo = com.tencent.mm.plugin.shake.b.m.bAa().nZo;
    this.nZp = com.tencent.mm.plugin.shake.b.m.bAa().nZp;
    this.dia = com.tencent.mm.plugin.shake.b.m.bAa().dia;
    this.dib = com.tencent.mm.plugin.shake.b.m.bAa().dib;
    au.Dk().a(1250, this);
    bzG();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof c))
    {
      paramm = (c)paramm;
      paramString = this.nZK;
      paramm = paramm.nZn;
      paramString.imX = paramm.imX;
      paramString.iln = paramm.iln;
      paramString.bZd = paramm.bZd;
      paramString.title = paramm.title;
      paramString.ilq = paramm.ilq;
      paramString.ilr = paramm.ilr;
      paramString.imA = paramm.imA;
      paramString.ilp = paramm.ilp;
      paramString.color = paramm.color;
      paramString.nZo = paramm.nZo;
      paramString.nZr = paramm.nZr;
      paramString.nZs = paramm.nZs;
      paramString.nZt = paramm.nZt;
      paramString.nZu = paramm.nZu;
      paramString.nZv = paramm.nZv;
      paramString.end_time = paramm.end_time;
      paramString.nZw = paramm.nZw;
      paramString.nZx = paramm.nZx;
      this.imX = this.nZK.imX;
      y.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.imX + "  frequency_level:" + nZo + " control_flag:" + this.nZK.nZr);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label332;
      }
      nZo = this.nZK.nZo;
      y.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
      if (this.nYU != null) {
        this.nYU.a(1250, this.nZK, 1L);
      }
      bAf();
    }
    for (;;)
    {
      com.tencent.mm.plugin.shake.b.m.bAa().nZo = nZo;
      com.tencent.mm.plugin.shake.b.m.bAa().nZp = this.nZp;
      this.nZL = false;
      return;
      label332:
      if (((paramInt1 == 5) && (paramInt2 == -1)) || ((paramInt1 == 4) && (paramInt2 != 0)))
      {
        y.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.nYU != null) {
          this.nYU.a(1250, this.nZK, 2L);
        }
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = a.xn(a.bAs());
        y.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is " + l2);
        this.nZp = (l1 + l2);
      }
      else
      {
        y.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + paramInt1 + " errCode is " + paramInt2);
        if (this.nYU != null) {
          this.nYU.a(1250, this.nZK, 2L);
        }
        bAf();
      }
    }
  }
  
  public final void pause()
  {
    ayX();
  }
  
  public final void reset()
  {
    if (this.nZJ != null) {
      au.Dk().c(this.nZJ);
    }
  }
  
  public final void resume()
  {
    if (this.egs != null) {
      this.egs.a(this.dig, true);
    }
  }
  
  public final void start()
  {
    init();
    reset();
    if (this.egs == null) {
      bzG();
    }
    this.egs.b(this.dig, true);
    Object localObject = com.tencent.mm.plugin.shake.b.m.bAa();
    long l1;
    long l2;
    if ((!TextUtils.isEmpty("key_shake_card_item")) && (((d)localObject).ikn.containsKey("key_shake_card_item")))
    {
      localObject = ((d)localObject).ikn.get("key_shake_card_item");
      l1 = System.currentTimeMillis() / 1000L;
      l2 = this.nZp;
      if ((localObject == null) || (!(localObject instanceof e))) {
        break label150;
      }
      localObject = (e)localObject;
      this.nYU.a(1250, (e)localObject, 1L);
      com.tencent.mm.plugin.shake.b.m.bAa().putValue("key_shake_card_item", null);
      y.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
    }
    for (;;)
    {
      return;
      localObject = null;
      break;
      label150:
      int i;
      if (this.nZp == 0L) {
        i = 1;
      }
      while (i != 0)
      {
        if (!this.nZL) {
          break label250;
        }
        y.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
        return;
        if (l1 - l2 >= 0L)
        {
          i = 1;
        }
        else
        {
          h.nFQ.f(11666, new Object[] { Integer.valueOf(this.drX) });
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              g.e(g.this).imX = 3;
              g.a(g.this, g.e(g.this).imX);
              g.e(g.this).nZv = com.tencent.mm.plugin.shake.b.m.bAa().nZq;
              if (g.f(g.this) != null) {
                g.g(g.this).a(1250, g.e(g.this), 2L);
              }
            }
          }, 3000L);
          y.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
          i = 0;
        }
      }
    }
    label250:
    if ((this.dia == -85.0F) || (this.dib == -1000.0F))
    {
      this.nZM = true;
      y.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          if (!g.h(g.this)) {
            g.d(g.this);
          }
        }
      }, 4000L);
      return;
    }
    bAe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.g
 * JD-Core Version:    0.7.0.1
 */