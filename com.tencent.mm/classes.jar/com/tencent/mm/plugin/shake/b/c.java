package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.List;

public final class c
  extends l.b
  implements g
{
  private Context context;
  float fmX;
  float fmY;
  private b.a fnd;
  d hxT;
  int xwT;
  int xwU;
  boolean xwV;
  boolean xwW;
  b xwX;
  a xwY;
  private int xwZ;
  ao xxa;
  Runnable xxb;
  
  public c(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28094);
    this.fmX = -85.0F;
    this.fmY = -1000.0F;
    this.xwT = 1;
    this.xwU = -1000;
    this.xwV = false;
    this.xwW = true;
    this.xwZ = 0;
    this.xxa = new ao();
    this.xxb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28092);
        if ((c.this.xxa != null) && (c.this.xxb != null)) {
          c.this.xxa.removeCallbacks(c.this.xxb);
        }
        if (c.this.xwY != null) {
          az.agi().a(c.this.xwY);
        }
        if ((c.this.xwX != null) && (c.this.xwX.dzW != null)) {
          c.this.xwY = new a(c.this.xwX.dzW);
        }
        if (c.this.xwY != null) {
          az.agi().a(c.this.xwY, 0);
        }
        AppMethodBeat.o(28092);
      }
    };
    this.fnd = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28093);
        e locale = e.aIu();
        boolean bool1;
        if (paramAnonymousInt == 0)
        {
          bool1 = false;
          if (c.this.hxT != null) {
            break label112;
          }
        }
        label112:
        for (boolean bool2 = false;; bool2 = c.this.hxT.hEP)
        {
          locale.a(2002, bool1, bool2, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
          ac.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.this.xwV, new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
          if (paramAnonymousBoolean) {
            break label127;
          }
          AppMethodBeat.o(28093);
          return true;
          bool1 = true;
          break;
        }
        label127:
        if ((c.this.xwW) && (c.this.fmX == -85.0F) && (c.this.fmY == -1000.0F))
        {
          c.this.xwW = false;
          c.this.fmX = paramAnonymousFloat2;
          c.this.fmY = paramAnonymousFloat1;
          c.this.xwU = ((int)paramAnonymousDouble2);
          c.this.xwT = paramAnonymousInt;
          c.this.xwV = true;
        }
        AppMethodBeat.o(28093);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(28094);
  }
  
  private void dCO()
  {
    AppMethodBeat.i(28097);
    this.hxT = d.aEL();
    this.xwW = true;
    this.hxT.a(this.fnd, true);
    AppMethodBeat.o(28097);
  }
  
  public final void dCP()
  {
    AppMethodBeat.i(28101);
    super.dCP();
    az.agi().b(161, this);
    az.agi().b(162, this);
    az.agi().b(1251, this);
    if (this.hxT != null) {
      this.hxT.c(this.fnd);
    }
    AppMethodBeat.o(28101);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28095);
    az.agi().a(161, this);
    az.agi().a(162, this);
    az.agi().a(1251, this);
    dCO();
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
      if ((paramString.dCN() == 3) || (paramString.dCN() == 4))
      {
        ac.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
        AppMethodBeat.o(28102);
        return;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
      {
        ac.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
        this.xxk.d(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      this.xxa.postDelayed(this.xxb, 3000L);
      AppMethodBeat.o(28102);
      return;
      paramString = (a)paramn;
      if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
      {
        this.xxk.d(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      paramString = paramString.xwR;
      if (paramString.size() == 0)
      {
        ac.i("MicroMsg.ShakeFriendService", "empty shake get list");
        this.xxk.d(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      this.xxk.d(paramString, 1L);
      AppMethodBeat.o(28102);
      return;
      paramString = (com.tencent.mm.plugin.shake.c.a.b)paramn;
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if (this.xxk != null)
        {
          this.xxk.a(1251, null, 2L);
          AppMethodBeat.o(28102);
        }
      }
      else if (this.xxk != null) {
        this.xxk.a(1251, paramString.xxD, 1L);
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28099);
    if (this.hxT != null) {
      this.hxT.c(this.fnd);
    }
    AppMethodBeat.o(28099);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28098);
    if (this.xwX != null) {
      az.agi().a(this.xwX);
    }
    if (this.xwY != null) {
      az.agi().a(this.xwY);
    }
    if ((this.xxa != null) && (this.xxb != null)) {
      this.xxa.removeCallbacks(this.xxb);
    }
    AppMethodBeat.o(28098);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28100);
    if (this.hxT != null) {
      this.hxT.a(this.fnd, true);
    }
    AppMethodBeat.o(28100);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28096);
    reset();
    init();
    this.xwX = new b(this.fmY, this.fmX, this.xwU, this.xwT, "", "");
    az.agi().a(this.xwX, 0);
    if (!this.xwV)
    {
      if (this.hxT == null) {
        dCO();
      }
      this.hxT.b(this.fnd, true);
    }
    AppMethodBeat.o(28096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.c
 * JD-Core Version:    0.7.0.1
 */