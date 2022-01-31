package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.km.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;

public final class c
  implements f
{
  private static long pOj = 0L;
  private Activity cup;
  private c.a pOk;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(68413);
    g.RK().eHt.a(138, this);
    this.cup = paramActivity;
    AppMethodBeat.o(68413);
  }
  
  public final void a(final c.a parama)
  {
    AppMethodBeat.i(68414);
    this.pOk = parama;
    parama = new km();
    parama.cAj.cup = this.cup;
    parama.cAj.cAl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68411);
        if (parama.cAk.cpz)
        {
          c.a(c.this);
          AppMethodBeat.o(68411);
          return;
        }
        if (c.b(c.this) != null) {
          c.b(c.this).cdU();
        }
        AppMethodBeat.o(68411);
      }
    };
    a.ymk.a(parama, Looper.myLooper());
    AppMethodBeat.o(68414);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(68416);
    release();
    super.finalize();
    AppMethodBeat.o(68416);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(68417);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.pOk != null)
      {
        this.pOk.cdT();
        this.pOk = null;
      }
    }
    for (;;)
    {
      pOj = System.currentTimeMillis();
      AppMethodBeat.o(68417);
      return;
      if (this.pOk != null)
      {
        this.pOk.cdU();
        this.pOk = null;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(68415);
    g.RK().eHt.b(138, this);
    AppMethodBeat.o(68415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.c
 * JD-Core Version:    0.7.0.1
 */