package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.List;

public final class c
  extends l.b
  implements f
{
  private Context context;
  float fFf;
  float fFg;
  private b.a fFl;
  d hQo;
  int yLE;
  int yLF;
  boolean yLG;
  boolean yLH;
  b yLI;
  a yLJ;
  private int yLK;
  ap yLL;
  Runnable yLM;
  
  public c(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28094);
    this.fFf = -85.0F;
    this.fFg = -1000.0F;
    this.yLE = 1;
    this.yLF = -1000;
    this.yLG = false;
    this.yLH = true;
    this.yLK = 0;
    this.yLL = new ap();
    this.yLM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28092);
        if ((c.this.yLL != null) && (c.this.yLM != null)) {
          c.this.yLL.removeCallbacks(c.this.yLM);
        }
        if (c.this.yLJ != null) {
          ba.aiU().a(c.this.yLJ);
        }
        if ((c.this.yLI != null) && (c.this.yLI.dMj != null)) {
          c.this.yLJ = new a(c.this.yLI.dMj);
        }
        if (c.this.yLJ != null) {
          ba.aiU().a(c.this.yLJ, 0);
        }
        AppMethodBeat.o(28092);
      }
    };
    this.fFl = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28093);
        e locale = e.aLE();
        boolean bool1;
        if (paramAnonymousInt == 0)
        {
          bool1 = false;
          if (c.this.hQo != null) {
            break label112;
          }
        }
        label112:
        for (boolean bool2 = false;; bool2 = c.this.hQo.hXu)
        {
          locale.a(2002, bool1, bool2, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
          ad.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.this.yLG, new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
          if (paramAnonymousBoolean) {
            break label127;
          }
          AppMethodBeat.o(28093);
          return true;
          bool1 = true;
          break;
        }
        label127:
        if ((c.this.yLH) && (c.this.fFf == -85.0F) && (c.this.fFg == -1000.0F))
        {
          c.this.yLH = false;
          c.this.fFf = paramAnonymousFloat2;
          c.this.fFg = paramAnonymousFloat1;
          c.this.yLF = ((int)paramAnonymousDouble2);
          c.this.yLE = paramAnonymousInt;
          c.this.yLG = true;
        }
        AppMethodBeat.o(28093);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(28094);
  }
  
  private void dOr()
  {
    AppMethodBeat.i(28097);
    this.hQo = d.aHQ();
    this.yLH = true;
    this.hQo.a(this.fFl, true);
    AppMethodBeat.o(28097);
  }
  
  public final void dOs()
  {
    AppMethodBeat.i(28101);
    super.dOs();
    ba.aiU().b(161, this);
    ba.aiU().b(162, this);
    ba.aiU().b(1251, this);
    if (this.hQo != null) {
      this.hQo.c(this.fFl);
    }
    AppMethodBeat.o(28101);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28095);
    ba.aiU().a(161, this);
    ba.aiU().a(162, this);
    ba.aiU().a(1251, this);
    dOr();
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
      if ((paramString.dOq() == 3) || (paramString.dOq() == 4))
      {
        ad.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
        AppMethodBeat.o(28102);
        return;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
      {
        ad.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
        this.yLV.d(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      this.yLL.postDelayed(this.yLM, 3000L);
      AppMethodBeat.o(28102);
      return;
      paramString = (a)paramn;
      if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
      {
        this.yLV.d(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      paramString = paramString.yLC;
      if (paramString.size() == 0)
      {
        ad.i("MicroMsg.ShakeFriendService", "empty shake get list");
        this.yLV.d(null, 3L);
        AppMethodBeat.o(28102);
        return;
      }
      this.yLV.d(paramString, 1L);
      AppMethodBeat.o(28102);
      return;
      paramString = (com.tencent.mm.plugin.shake.c.a.b)paramn;
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if (this.yLV != null)
        {
          this.yLV.a(1251, null, 2L);
          AppMethodBeat.o(28102);
        }
      }
      else if (this.yLV != null) {
        this.yLV.a(1251, paramString.yMo, 1L);
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28099);
    if (this.hQo != null) {
      this.hQo.c(this.fFl);
    }
    AppMethodBeat.o(28099);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28098);
    if (this.yLI != null) {
      ba.aiU().a(this.yLI);
    }
    if (this.yLJ != null) {
      ba.aiU().a(this.yLJ);
    }
    if ((this.yLL != null) && (this.yLM != null)) {
      this.yLL.removeCallbacks(this.yLM);
    }
    AppMethodBeat.o(28098);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28100);
    if (this.hQo != null) {
      this.hQo.a(this.fFl, true);
    }
    AppMethodBeat.o(28100);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28096);
    reset();
    init();
    this.yLI = new b(this.fFg, this.fFf, this.yLF, this.yLE, "", "");
    ba.aiU().a(this.yLI, 0);
    if (!this.yLG)
    {
      if (this.hQo == null) {
        dOr();
      }
      this.hQo.b(this.fFl, true);
    }
    AppMethodBeat.o(28096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.c
 * JD-Core Version:    0.7.0.1
 */