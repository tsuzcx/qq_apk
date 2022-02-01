package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.List;

public final class c
  extends l.b
  implements i
{
  private int Jmm;
  private int Jmn;
  private boolean Jmo;
  private boolean Jmp;
  private b Jmq;
  private a Jmr;
  private int Jms;
  private MMHandler Jmt;
  private Runnable Jmu;
  private Context context;
  private float iQD;
  private float iQE;
  private b.a iQJ;
  private d lEL;
  
  public c(Context paramContext, l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28094);
    this.iQD = -85.0F;
    this.iQE = -1000.0F;
    this.Jmm = 1;
    this.Jmn = -1000;
    this.Jmo = false;
    this.Jmp = true;
    this.Jms = 0;
    this.Jmt = new MMHandler();
    this.Jmu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28092);
        if ((c.a(c.this) != null) && (c.b(c.this) != null)) {
          c.a(c.this).removeCallbacks(c.b(c.this));
        }
        if (c.c(c.this) != null) {
          bh.aGY().a(c.c(c.this));
        }
        if ((c.d(c.this) != null) && (c.d(c.this).fZH != null)) {
          c.a(c.this, new a(c.d(c.this).fZH));
        }
        if (c.c(c.this) != null) {
          bh.aGY().a(c.c(c.this), 0);
        }
        AppMethodBeat.o(28092);
      }
    };
    this.iQJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(28093);
        Log.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.e(c.this), new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(28093);
          return true;
        }
        if ((c.f(c.this)) && (c.g(c.this) == -85.0F) && (c.h(c.this) == -1000.0F))
        {
          c.i(c.this);
          c.a(c.this, paramAnonymousFloat2);
          c.b(c.this, paramAnonymousFloat1);
          c.a(c.this, (int)paramAnonymousDouble2);
          c.b(c.this, paramAnonymousInt);
          c.j(c.this);
        }
        AppMethodBeat.o(28093);
        return false;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(28094);
  }
  
  private void cFO()
  {
    AppMethodBeat.i(28097);
    this.lEL = d.blq();
    this.Jmp = true;
    this.lEL.a(this.iQJ, true);
    AppMethodBeat.o(28097);
  }
  
  public final void fGS()
  {
    AppMethodBeat.i(28101);
    super.fGS();
    bh.aGY().b(161, this);
    bh.aGY().b(162, this);
    bh.aGY().b(1251, this);
    if (this.lEL != null) {
      this.lEL.b(this.iQJ);
    }
    AppMethodBeat.o(28101);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28095);
    bh.aGY().a(161, this);
    bh.aGY().a(162, this);
    bh.aGY().a(1251, this);
    cFO();
    AppMethodBeat.o(28095);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(28102);
    switch (paramq.getType())
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(28102);
        return;
        paramString = (b)paramq;
        if ((paramString.fGR() == 3) || (paramString.fGR() == 4))
        {
          Log.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
          AppMethodBeat.o(28102);
          return;
        }
        if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
        {
          Log.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
          this.JmD.e(null, 3L);
          AppMethodBeat.o(28102);
          return;
        }
        this.Jmt.postDelayed(this.Jmu, 3000L);
        AppMethodBeat.o(28102);
        return;
        paramString = (a)paramq;
        if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
        {
          this.JmD.e(null, 3L);
          AppMethodBeat.o(28102);
          return;
        }
        paramString = paramString.Jmk;
        if (paramString.size() == 0)
        {
          Log.i("MicroMsg.ShakeFriendService", "empty shake get list");
          this.JmD.e(null, 3L);
          AppMethodBeat.o(28102);
          return;
        }
        this.JmD.e(paramString, 1L);
        AppMethodBeat.o(28102);
        return;
        if ((paramInt2 == 0) && (paramInt1 == 0)) {
          break;
        }
      } while (this.JmD == null);
      this.JmD.a(1251, null, 2L);
      AppMethodBeat.o(28102);
      return;
    } while (this.JmD == null);
    AppMethodBeat.o(28102);
    throw null;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28099);
    if (this.lEL != null) {
      this.lEL.b(this.iQJ);
    }
    AppMethodBeat.o(28099);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28098);
    if (this.Jmq != null) {
      bh.aGY().a(this.Jmq);
    }
    if (this.Jmr != null) {
      bh.aGY().a(this.Jmr);
    }
    if ((this.Jmt != null) && (this.Jmu != null)) {
      this.Jmt.removeCallbacks(this.Jmu);
    }
    AppMethodBeat.o(28098);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28100);
    if (this.lEL != null) {
      this.lEL.a(this.iQJ, true);
    }
    AppMethodBeat.o(28100);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28096);
    reset();
    init();
    this.Jmq = new b(this.iQE, this.iQD, this.Jmn, this.Jmm, "", "");
    bh.aGY().a(this.Jmq, 0);
    if (!this.Jmo)
    {
      if (this.lEL == null) {
        cFO();
      }
      this.lEL.b(this.iQJ, true);
    }
    AppMethodBeat.o(28096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.c
 * JD-Core Version:    0.7.0.1
 */