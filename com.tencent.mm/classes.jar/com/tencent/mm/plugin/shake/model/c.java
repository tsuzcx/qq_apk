package com.tencent.mm.plugin.shake.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.List;

public final class c
  extends l.b
  implements h
{
  private int Pzd;
  private int Pze;
  private boolean Pzf;
  private boolean Pzg;
  private b Pzh;
  private a Pzi;
  private MMHandler Pzj;
  private Runnable Pzk;
  private float lsA;
  private b.a lsF;
  private float lsz;
  private d owr;
  
  public c(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(273541);
    this.lsz = -85.0F;
    this.lsA = -1000.0F;
    this.Pzd = 1;
    this.Pze = -1000;
    this.Pzf = false;
    this.Pzg = true;
    this.Pzj = new MMHandler();
    this.Pzk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28092);
        if ((c.a(c.this) != null) && (c.b(c.this) != null)) {
          c.a(c.this).removeCallbacks(c.b(c.this));
        }
        if (c.c(c.this) != null) {
          bh.aZW().a(c.c(c.this));
        }
        if ((c.d(c.this) != null) && (c.d(c.this).ifP != null)) {
          c.a(c.this, new a(c.d(c.this).ifP));
        }
        if (c.c(c.this) != null) {
          bh.aZW().a(c.c(c.this), 0);
        }
        AppMethodBeat.o(28092);
      }
    };
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(273543);
        Log.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.e(c.this), new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(273543);
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
        AppMethodBeat.o(273543);
        return false;
      }
    };
    AppMethodBeat.o(273541);
  }
  
  private void djg()
  {
    AppMethodBeat.i(28097);
    this.owr = d.bJl();
    this.Pzg = true;
    this.owr.a(this.lsF, true, false);
    l.kK(22, 10);
    AppMethodBeat.o(28097);
  }
  
  public final void gWH()
  {
    AppMethodBeat.i(28101);
    super.gWH();
    bh.aZW().b(161, this);
    bh.aZW().b(162, this);
    bh.aZW().b(1251, this);
    if (this.owr != null) {
      this.owr.a(this.lsF);
    }
    AppMethodBeat.o(28101);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28095);
    bh.aZW().a(161, this);
    bh.aZW().a(162, this);
    bh.aZW().a(1251, this);
    djg();
    AppMethodBeat.o(28095);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(28102);
    if (this.Pzt == null)
    {
      AppMethodBeat.o(28102);
      return;
    }
    switch (paramp.getType())
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(28102);
        return;
        paramString = (b)paramp;
        if ((paramString.gWG() == 3) || (paramString.gWG() == 4))
        {
          Log.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
          AppMethodBeat.o(28102);
          return;
        }
        if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
        {
          Log.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
          this.Pzt.g(null, 3L);
          AppMethodBeat.o(28102);
          return;
        }
        this.Pzj.postDelayed(this.Pzk, 3000L);
        AppMethodBeat.o(28102);
        return;
        paramString = (a)paramp;
        if ((paramInt2 != 0) || (paramInt1 != 0) || (paramString.ret != 0))
        {
          this.Pzt.g(null, 3L);
          AppMethodBeat.o(28102);
          return;
        }
        paramString = paramString.Pzb;
        if (paramString.size() == 0)
        {
          Log.i("MicroMsg.ShakeFriendService", "empty shake get list");
          this.Pzt.g(null, 3L);
          AppMethodBeat.o(28102);
          return;
        }
        this.Pzt.g(paramString, 1L);
        AppMethodBeat.o(28102);
        return;
        if ((paramInt2 == 0) && (paramInt1 == 0)) {
          break;
        }
      } while (this.Pzt == null);
      this.Pzt.a(1251, null, 2L);
      AppMethodBeat.o(28102);
      return;
    } while (this.Pzt == null);
    AppMethodBeat.o(28102);
    throw null;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28099);
    if (this.owr != null) {
      this.owr.a(this.lsF);
    }
    AppMethodBeat.o(28099);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28098);
    if (this.Pzh != null) {
      bh.aZW().a(this.Pzh);
    }
    if (this.Pzi != null) {
      bh.aZW().a(this.Pzi);
    }
    if ((this.Pzj != null) && (this.Pzk != null)) {
      this.Pzj.removeCallbacks(this.Pzk);
    }
    AppMethodBeat.o(28098);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28100);
    if (this.owr != null)
    {
      this.owr.a(this.lsF, true, false);
      l.kK(22, 10);
    }
    AppMethodBeat.o(28100);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28096);
    reset();
    init();
    this.Pzh = new b(this.lsA, this.lsz, this.Pze, this.Pzd, "", "");
    bh.aZW().a(this.Pzh, 0);
    if (!this.Pzf)
    {
      if (this.owr == null) {
        djg();
      }
      this.owr.a(this.lsF, true);
      l.kK(22, 10);
    }
    AppMethodBeat.o(28096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.model.c
 * JD-Core Version:    0.7.0.1
 */