package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.List;

public final class c
  extends l.b
  implements f
{
  private Context context;
  private b.a dZA;
  float dZu;
  float dZv;
  d fwu;
  int qAk;
  int qAl;
  boolean qAo;
  boolean qMQ;
  b qMR;
  a qMS;
  private int qMT;
  ak qMU;
  Runnable qMV;
  
  public c(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(24419);
    this.dZu = -85.0F;
    this.dZv = -1000.0F;
    this.qAk = 1;
    this.qAl = -1000;
    this.qAo = false;
    this.qMQ = true;
    this.qMT = 0;
    this.qMU = new ak();
    this.qMV = new c.1(this);
    this.dZA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(24418);
        e locale = e.akz();
        boolean bool1;
        if (paramAnonymousInt == 0)
        {
          bool1 = false;
          if (c.this.fwu != null) {
            break label112;
          }
        }
        label112:
        for (boolean bool2 = false;; bool2 = c.this.fwu.fBM)
        {
          locale.a(2002, bool1, bool2, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
          ab.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.this.qAo, new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
          if (paramAnonymousBoolean) {
            break label127;
          }
          AppMethodBeat.o(24418);
          return true;
          bool1 = true;
          break;
        }
        label127:
        if ((c.this.qMQ) && (c.this.dZu == -85.0F) && (c.this.dZv == -1000.0F))
        {
          c.this.qMQ = false;
          c.this.dZu = paramAnonymousFloat2;
          c.this.dZv = paramAnonymousFloat1;
          c.this.qAl = ((int)paramAnonymousDouble2);
          c.this.qAk = paramAnonymousInt;
          c.this.qAo = true;
        }
        AppMethodBeat.o(24418);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(24419);
  }
  
  private void ckQ()
  {
    AppMethodBeat.i(24422);
    this.fwu = d.agQ();
    this.qMQ = true;
    this.fwu.a(this.dZA, true);
    AppMethodBeat.o(24422);
  }
  
  public final void ckR()
  {
    AppMethodBeat.i(24426);
    super.ckR();
    aw.Rc().b(161, this);
    aw.Rc().b(162, this);
    aw.Rc().b(1251, this);
    if (this.fwu != null) {
      this.fwu.c(this.dZA);
    }
    AppMethodBeat.o(24426);
  }
  
  public final void init()
  {
    AppMethodBeat.i(24420);
    aw.Rc().a(161, this);
    aw.Rc().a(162, this);
    aw.Rc().a(1251, this);
    ckQ();
    AppMethodBeat.o(24420);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(24427);
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24427);
      return;
      paramString = (b)paramm;
      if ((paramString.ckP() == 3) || (paramString.ckP() == 4))
      {
        ab.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
        AppMethodBeat.o(24427);
        return;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
      {
        ab.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
        this.qNe.b(null, 3L);
        AppMethodBeat.o(24427);
        return;
      }
      this.qMU.postDelayed(this.qMV, 3000L);
      AppMethodBeat.o(24427);
      return;
      paramString = (a)paramm;
      if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
      {
        this.qNe.b(null, 3L);
        AppMethodBeat.o(24427);
        return;
      }
      paramString = paramString.qMO;
      if (paramString.size() == 0)
      {
        ab.i("MicroMsg.ShakeFriendService", "empty shake get list");
        this.qNe.b(null, 3L);
        AppMethodBeat.o(24427);
        return;
      }
      this.qNe.b(paramString, 1L);
      AppMethodBeat.o(24427);
      return;
      paramString = (com.tencent.mm.plugin.shake.c.a.b)paramm;
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if (this.qNe != null)
        {
          this.qNe.a(1251, null, 2L);
          AppMethodBeat.o(24427);
        }
      }
      else if (this.qNe != null) {
        this.qNe.a(1251, paramString.qNx, 1L);
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(24424);
    if (this.fwu != null) {
      this.fwu.c(this.dZA);
    }
    AppMethodBeat.o(24424);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(24423);
    if (this.qMR != null) {
      aw.Rc().a(this.qMR);
    }
    if (this.qMS != null) {
      aw.Rc().a(this.qMS);
    }
    if ((this.qMU != null) && (this.qMV != null)) {
      this.qMU.removeCallbacks(this.qMV);
    }
    AppMethodBeat.o(24423);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(24425);
    if (this.fwu != null) {
      this.fwu.a(this.dZA, true);
    }
    AppMethodBeat.o(24425);
  }
  
  public final void start()
  {
    AppMethodBeat.i(24421);
    reset();
    init();
    this.qMR = new b(this.dZv, this.dZu, this.qAl, this.qAk, "", "");
    aw.Rc().a(this.qMR, 0);
    if (!this.qAo)
    {
      if (this.fwu == null) {
        ckQ();
      }
      this.fwu.b(this.dZA, true);
    }
    if (this.qMT <= 0) {}
    for (this.qMT += 1;; this.qMT = 0)
    {
      ab.i("MicroMsg.ShakeFriendService", "do doGetLbsCard");
      com.tencent.mm.plugin.shake.c.a.b localb = new com.tencent.mm.plugin.shake.c.a.b(this.dZv, this.dZu);
      aw.Rc().a(localb, 0);
      AppMethodBeat.o(24421);
      return;
      if ((this.qMT > 0) && (this.qMT <= 10))
      {
        this.qMT += 1;
        AppMethodBeat.o(24421);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.c
 * JD-Core Version:    0.7.0.1
 */