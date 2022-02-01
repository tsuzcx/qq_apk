package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.List;

public final class c
  extends l.b
  implements i
{
  int DgG;
  int DgH;
  boolean DgI;
  boolean DgJ;
  b DgK;
  a DgL;
  private int DgM;
  MMHandler DgN;
  Runnable DgO;
  private Context context;
  private b.a gmA;
  float gmu;
  float gmv;
  d iOv;
  
  public c(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28094);
    this.gmu = -85.0F;
    this.gmv = -1000.0F;
    this.DgG = 1;
    this.DgH = -1000;
    this.DgI = false;
    this.DgJ = true;
    this.DgM = 0;
    this.DgN = new MMHandler();
    this.DgO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28092);
        if ((c.this.DgN != null) && (c.this.DgO != null)) {
          c.this.DgN.removeCallbacks(c.this.DgO);
        }
        if (c.this.DgL != null) {
          bg.azz().a(c.this.DgL);
        }
        if ((c.this.DgK != null) && (c.this.DgK.efs != null)) {
          c.this.DgL = new a(c.this.DgK.efs);
        }
        if (c.this.DgL != null) {
          bg.azz().a(c.this.DgL, 0);
        }
        AppMethodBeat.o(28092);
      }
    };
    this.gmA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28093);
        e locale = e.bge();
        boolean bool1;
        if (paramAnonymousInt == 0)
        {
          bool1 = false;
          if (c.this.iOv != null) {
            break label112;
          }
        }
        label112:
        for (boolean bool2 = false;; bool2 = c.this.iOv.iVk)
        {
          locale.a(2002, bool1, bool2, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
          Log.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.this.DgI, new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
          if (paramAnonymousBoolean) {
            break label127;
          }
          AppMethodBeat.o(28093);
          return true;
          bool1 = true;
          break;
        }
        label127:
        if ((c.this.DgJ) && (c.this.gmu == -85.0F) && (c.this.gmv == -1000.0F))
        {
          c.this.DgJ = false;
          c.this.gmu = paramAnonymousFloat2;
          c.this.gmv = paramAnonymousFloat1;
          c.this.DgH = ((int)paramAnonymousDouble2);
          c.this.DgG = paramAnonymousInt;
          c.this.DgI = true;
        }
        AppMethodBeat.o(28093);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(28094);
  }
  
  private void eTP()
  {
    AppMethodBeat.i(28097);
    this.iOv = d.bca();
    this.DgJ = true;
    this.iOv.a(this.gmA, true);
    AppMethodBeat.o(28097);
  }
  
  public final void eTQ()
  {
    AppMethodBeat.i(28101);
    super.eTQ();
    bg.azz().b(161, this);
    bg.azz().b(162, this);
    bg.azz().b(1251, this);
    if (this.iOv != null) {
      this.iOv.c(this.gmA);
    }
    AppMethodBeat.o(28101);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28095);
    bg.azz().a(161, this);
    bg.azz().a(162, this);
    bg.azz().a(1251, this);
    eTP();
    AppMethodBeat.o(28095);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(28102);
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28102);
      return;
      paramString = (b)paramq;
      if ((paramString.eTO() == 3) || (paramString.eTO() == 4))
      {
        Log.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
        AppMethodBeat.o(28102);
        return;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
      {
        Log.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
        this.DgX.f(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      this.DgN.postDelayed(this.DgO, 3000L);
      AppMethodBeat.o(28102);
      return;
      paramString = (a)paramq;
      if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
      {
        this.DgX.f(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      paramString = paramString.DgE;
      if (paramString.size() == 0)
      {
        Log.i("MicroMsg.ShakeFriendService", "empty shake get list");
        this.DgX.f(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      this.DgX.f(paramString, 1L);
      AppMethodBeat.o(28102);
      return;
      paramString = (com.tencent.mm.plugin.shake.c.a.b)paramq;
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if (this.DgX != null)
        {
          this.DgX.a(1251, null, 2L);
          AppMethodBeat.o(28102);
        }
      }
      else if (this.DgX != null) {
        this.DgX.a(1251, paramString.Dhq, 1L);
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28099);
    if (this.iOv != null) {
      this.iOv.c(this.gmA);
    }
    AppMethodBeat.o(28099);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28098);
    if (this.DgK != null) {
      bg.azz().a(this.DgK);
    }
    if (this.DgL != null) {
      bg.azz().a(this.DgL);
    }
    if ((this.DgN != null) && (this.DgO != null)) {
      this.DgN.removeCallbacks(this.DgO);
    }
    AppMethodBeat.o(28098);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28100);
    if (this.iOv != null) {
      this.iOv.a(this.gmA, true);
    }
    AppMethodBeat.o(28100);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28096);
    reset();
    init();
    this.DgK = new b(this.gmv, this.gmu, this.DgH, this.DgG, "", "");
    bg.azz().a(this.DgK, 0);
    if (!this.DgI)
    {
      if (this.iOv == null) {
        eTP();
      }
      this.iOv.b(this.gmA, true);
    }
    AppMethodBeat.o(28096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.c
 * JD-Core Version:    0.7.0.1
 */