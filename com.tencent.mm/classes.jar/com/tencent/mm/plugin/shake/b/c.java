package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.List;

public final class c
  extends l.b
  implements g
{
  private Context context;
  float fjD;
  float fjE;
  private b.a fjJ;
  d gXu;
  int wlD;
  int wlE;
  boolean wlF;
  boolean wlG;
  b wlH;
  a wlI;
  private int wlJ;
  ap wlK;
  Runnable wlL;
  
  public c(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28094);
    this.fjD = -85.0F;
    this.fjE = -1000.0F;
    this.wlD = 1;
    this.wlE = -1000;
    this.wlF = false;
    this.wlG = true;
    this.wlJ = 0;
    this.wlK = new ap();
    this.wlL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28092);
        if ((c.this.wlK != null) && (c.this.wlL != null)) {
          c.this.wlK.removeCallbacks(c.this.wlL);
        }
        if (c.this.wlI != null) {
          az.aeS().a(c.this.wlI);
        }
        if ((c.this.wlH != null) && (c.this.wlH.dCi != null)) {
          c.this.wlI = new a(c.this.wlH.dCi);
        }
        if (c.this.wlI != null) {
          az.aeS().a(c.this.wlI, 0);
        }
        AppMethodBeat.o(28092);
      }
    };
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28093);
        e locale = e.aBE();
        boolean bool1;
        if (paramAnonymousInt == 0)
        {
          bool1 = false;
          if (c.this.gXu != null) {
            break label112;
          }
        }
        label112:
        for (boolean bool2 = false;; bool2 = c.this.gXu.hem)
        {
          locale.a(2002, bool1, bool2, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
          ad.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.this.wlF, new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
          if (paramAnonymousBoolean) {
            break label127;
          }
          AppMethodBeat.o(28093);
          return true;
          bool1 = true;
          break;
        }
        label127:
        if ((c.this.wlG) && (c.this.fjD == -85.0F) && (c.this.fjE == -1000.0F))
        {
          c.this.wlG = false;
          c.this.fjD = paramAnonymousFloat2;
          c.this.fjE = paramAnonymousFloat1;
          c.this.wlE = ((int)paramAnonymousDouble2);
          c.this.wlD = paramAnonymousInt;
          c.this.wlF = true;
        }
        AppMethodBeat.o(28093);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(28094);
  }
  
  private void doE()
  {
    AppMethodBeat.i(28097);
    this.gXu = d.axT();
    this.wlG = true;
    this.gXu.a(this.fjJ, true);
    AppMethodBeat.o(28097);
  }
  
  public final void doF()
  {
    AppMethodBeat.i(28101);
    super.doF();
    az.aeS().b(161, this);
    az.aeS().b(162, this);
    az.aeS().b(1251, this);
    if (this.gXu != null) {
      this.gXu.c(this.fjJ);
    }
    AppMethodBeat.o(28101);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28095);
    az.aeS().a(161, this);
    az.aeS().a(162, this);
    az.aeS().a(1251, this);
    doE();
    AppMethodBeat.o(28095);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28102);
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28102);
      return;
      paramString = (b)paramn;
      if ((paramString.doD() == 3) || (paramString.doD() == 4))
      {
        ad.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
        AppMethodBeat.o(28102);
        return;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
      {
        ad.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
        this.wlU.c(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      this.wlK.postDelayed(this.wlL, 3000L);
      AppMethodBeat.o(28102);
      return;
      paramString = (a)paramn;
      if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
      {
        this.wlU.c(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      paramString = paramString.wlB;
      if (paramString.size() == 0)
      {
        ad.i("MicroMsg.ShakeFriendService", "empty shake get list");
        this.wlU.c(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      this.wlU.c(paramString, 1L);
      AppMethodBeat.o(28102);
      return;
      paramString = (com.tencent.mm.plugin.shake.c.a.b)paramn;
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if (this.wlU != null)
        {
          this.wlU.a(1251, null, 2L);
          AppMethodBeat.o(28102);
        }
      }
      else if (this.wlU != null) {
        this.wlU.a(1251, paramString.wmn, 1L);
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28099);
    if (this.gXu != null) {
      this.gXu.c(this.fjJ);
    }
    AppMethodBeat.o(28099);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28098);
    if (this.wlH != null) {
      az.aeS().a(this.wlH);
    }
    if (this.wlI != null) {
      az.aeS().a(this.wlI);
    }
    if ((this.wlK != null) && (this.wlL != null)) {
      this.wlK.removeCallbacks(this.wlL);
    }
    AppMethodBeat.o(28098);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28100);
    if (this.gXu != null) {
      this.gXu.a(this.fjJ, true);
    }
    AppMethodBeat.o(28100);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28096);
    reset();
    init();
    this.wlH = new b(this.fjE, this.fjD, this.wlE, this.wlD, "", "");
    az.aeS().a(this.wlH, 0);
    if (!this.wlF)
    {
      if (this.gXu == null) {
        doE();
      }
      this.gXu.b(this.fjJ, true);
    }
    AppMethodBeat.o(28096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.c
 * JD-Core Version:    0.7.0.1
 */