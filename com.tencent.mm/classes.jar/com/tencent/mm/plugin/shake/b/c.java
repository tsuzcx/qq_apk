package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class c
  extends l.b
  implements f
{
  private Context context;
  float dia = -85.0F;
  float dib = -1000.0F;
  private a.a dig = new a.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
    {
      e locale = e.Rq();
      boolean bool1;
      if (paramAnonymousInt == 0)
      {
        bool1 = false;
        if (c.this.egs != null) {
          break label100;
        }
      }
      label100:
      for (boolean bool2 = false;; bool2 = c.this.egs.elu)
      {
        locale.a(2002, bool1, bool2, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        y.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.this.nMG, new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        if (paramAnonymousBoolean) {
          break label115;
        }
        return true;
        bool1 = true;
        break;
      }
      label115:
      if ((c.this.nYG) && (c.this.dia == -85.0F) && (c.this.dib == -1000.0F))
      {
        c.this.nYG = false;
        c.this.dia = paramAnonymousFloat2;
        c.this.dib = paramAnonymousFloat1;
        c.this.nMD = ((int)paramAnonymousDouble2);
        c.this.nMC = paramAnonymousInt;
        c.this.nMG = true;
      }
      return false;
    }
  };
  com.tencent.mm.modelgeo.c egs;
  int nMC = 1;
  int nMD = -1000;
  boolean nMG = false;
  boolean nYG = true;
  b nYH;
  a nYI;
  private int nYJ = 0;
  ah nYK = new ah();
  Runnable nYL = new c.1(this);
  
  public c(Context paramContext, l.a parama)
  {
    super(parama);
    this.context = paramContext;
  }
  
  private void bzG()
  {
    this.egs = com.tencent.mm.modelgeo.c.Ob();
    this.nYG = true;
    this.egs.a(this.dig, true);
  }
  
  public final void bzH()
  {
    super.bzH();
    au.Dk().b(161, this);
    au.Dk().b(162, this);
    au.Dk().b(1251, this);
    if (this.egs != null) {
      this.egs.c(this.dig);
    }
  }
  
  public final void init()
  {
    au.Dk().a(161, this);
    au.Dk().a(162, this);
    au.Dk().a(1251, this);
    bzG();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    switch (paramm.getType())
    {
    }
    do
    {
      do
      {
        return;
        paramString = (b)paramm;
        if ((paramString.bzF() == 3) || (paramString.bzF() == 4))
        {
          y.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
          return;
        }
        if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
        {
          y.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
          this.nYU.a(null, 3L);
          return;
        }
        this.nYK.postDelayed(this.nYL, 3000L);
        return;
        paramString = (a)paramm;
        if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
        {
          this.nYU.a(null, 3L);
          return;
        }
        paramString = paramString.nYE;
        if (paramString.size() == 0)
        {
          y.i("MicroMsg.ShakeFriendService", "empty shake get list");
          this.nYU.a(null, 3L);
          return;
        }
        this.nYU.a(paramString, 1L);
        return;
        paramString = (com.tencent.mm.plugin.shake.c.a.b)paramm;
        if ((paramInt2 == 0) && (paramInt1 == 0)) {
          break;
        }
      } while (this.nYU == null);
      this.nYU.a(1251, null, 2L);
      return;
    } while (this.nYU == null);
    this.nYU.a(1251, paramString.nZn, 1L);
  }
  
  public final void pause()
  {
    if (this.egs != null) {
      this.egs.c(this.dig);
    }
  }
  
  public final void reset()
  {
    if (this.nYH != null) {
      au.Dk().c(this.nYH);
    }
    if (this.nYI != null) {
      au.Dk().c(this.nYI);
    }
    if ((this.nYK != null) && (this.nYL != null)) {
      this.nYK.removeCallbacks(this.nYL);
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
    reset();
    init();
    this.nYH = new b(this.dib, this.dia, this.nMD, this.nMC, "", "");
    au.Dk().a(this.nYH, 0);
    if (!this.nMG)
    {
      if (this.egs == null) {
        bzG();
      }
      this.egs.b(this.dig, true);
    }
    if (this.nYJ <= 0) {}
    for (this.nYJ += 1;; this.nYJ = 0)
    {
      y.i("MicroMsg.ShakeFriendService", "do doGetLbsCard");
      com.tencent.mm.plugin.shake.c.a.b localb = new com.tencent.mm.plugin.shake.c.a.b(this.dib, this.dia);
      au.Dk().a(localb, 0);
      return;
      if ((this.nYJ > 0) && (this.nYJ <= 10))
      {
        this.nYJ += 1;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.c
 * JD-Core Version:    0.7.0.1
 */