package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.List;

public final class c
  extends l.b
  implements f
{
  private Context context;
  float fHj;
  float fHk;
  private b.a fHp;
  d hTg;
  int zbO;
  int zbP;
  boolean zbQ;
  boolean zbR;
  b zbS;
  a zbT;
  private int zbU;
  aq zbV;
  Runnable zbW;
  
  public c(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28094);
    this.fHj = -85.0F;
    this.fHk = -1000.0F;
    this.zbO = 1;
    this.zbP = -1000;
    this.zbQ = false;
    this.zbR = true;
    this.zbU = 0;
    this.zbV = new aq();
    this.zbW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28092);
        if ((c.this.zbV != null) && (c.this.zbW != null)) {
          c.this.zbV.removeCallbacks(c.this.zbW);
        }
        if (c.this.zbT != null) {
          bc.ajj().a(c.this.zbT);
        }
        if ((c.this.zbS != null) && (c.this.zbS.dNz != null)) {
          c.this.zbT = new a(c.this.zbS.dNz);
        }
        if (c.this.zbT != null) {
          bc.ajj().a(c.this.zbT, 0);
        }
        AppMethodBeat.o(28092);
      }
    };
    this.fHp = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28093);
        e locale = e.aMb();
        boolean bool1;
        if (paramAnonymousInt == 0)
        {
          bool1 = false;
          if (c.this.hTg != null) {
            break label112;
          }
        }
        label112:
        for (boolean bool2 = false;; bool2 = c.this.hTg.iam)
        {
          locale.a(2002, bool1, bool2, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
          ae.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.this.zbQ, new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
          if (paramAnonymousBoolean) {
            break label127;
          }
          AppMethodBeat.o(28093);
          return true;
          bool1 = true;
          break;
        }
        label127:
        if ((c.this.zbR) && (c.this.fHj == -85.0F) && (c.this.fHk == -1000.0F))
        {
          c.this.zbR = false;
          c.this.fHj = paramAnonymousFloat2;
          c.this.fHk = paramAnonymousFloat1;
          c.this.zbP = ((int)paramAnonymousDouble2);
          c.this.zbO = paramAnonymousInt;
          c.this.zbQ = true;
        }
        AppMethodBeat.o(28093);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(28094);
  }
  
  private void dRO()
  {
    AppMethodBeat.i(28097);
    this.hTg = d.aIh();
    this.zbR = true;
    this.hTg.a(this.fHp, true);
    AppMethodBeat.o(28097);
  }
  
  public final void dRP()
  {
    AppMethodBeat.i(28101);
    super.dRP();
    bc.ajj().b(161, this);
    bc.ajj().b(162, this);
    bc.ajj().b(1251, this);
    if (this.hTg != null) {
      this.hTg.c(this.fHp);
    }
    AppMethodBeat.o(28101);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28095);
    bc.ajj().a(161, this);
    bc.ajj().a(162, this);
    bc.ajj().a(1251, this);
    dRO();
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
      if ((paramString.dRN() == 3) || (paramString.dRN() == 4))
      {
        ae.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
        AppMethodBeat.o(28102);
        return;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
      {
        ae.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
        this.zcf.d(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      this.zbV.postDelayed(this.zbW, 3000L);
      AppMethodBeat.o(28102);
      return;
      paramString = (a)paramn;
      if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
      {
        this.zcf.d(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      paramString = paramString.zbM;
      if (paramString.size() == 0)
      {
        ae.i("MicroMsg.ShakeFriendService", "empty shake get list");
        this.zcf.d(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      this.zcf.d(paramString, 1L);
      AppMethodBeat.o(28102);
      return;
      paramString = (com.tencent.mm.plugin.shake.c.a.b)paramn;
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if (this.zcf != null)
        {
          this.zcf.a(1251, null, 2L);
          AppMethodBeat.o(28102);
        }
      }
      else if (this.zcf != null) {
        this.zcf.a(1251, paramString.zcy, 1L);
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28099);
    if (this.hTg != null) {
      this.hTg.c(this.fHp);
    }
    AppMethodBeat.o(28099);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28098);
    if (this.zbS != null) {
      bc.ajj().a(this.zbS);
    }
    if (this.zbT != null) {
      bc.ajj().a(this.zbT);
    }
    if ((this.zbV != null) && (this.zbW != null)) {
      this.zbV.removeCallbacks(this.zbW);
    }
    AppMethodBeat.o(28098);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28100);
    if (this.hTg != null) {
      this.hTg.a(this.fHp, true);
    }
    AppMethodBeat.o(28100);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28096);
    reset();
    init();
    this.zbS = new b(this.fHk, this.fHj, this.zbP, this.zbO, "", "");
    bc.ajj().a(this.zbS, 0);
    if (!this.zbQ)
    {
      if (this.hTg == null) {
        dRO();
      }
      this.hTg.b(this.fHp, true);
    }
    AppMethodBeat.o(28096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.c
 * JD-Core Version:    0.7.0.1
 */