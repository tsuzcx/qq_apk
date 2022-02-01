package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.b.a;

public final class c
  implements com.tencent.mm.ak.g
{
  private static long vZj = 0L;
  private Activity dgE;
  private c.a vZk;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(123141);
    com.tencent.mm.kernel.g.agQ().ghe.a(138, this);
    this.dgE = paramActivity;
    AppMethodBeat.o(123141);
  }
  
  public final void a(final c.a parama)
  {
    AppMethodBeat.i(123142);
    this.vZk = parama;
    parama = new ma();
    parama.dod.dgE = this.dgE;
    parama.dod.dof = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123139);
        if (parama.doe.dbS)
        {
          c.a(c.this);
          AppMethodBeat.o(123139);
          return;
        }
        if (c.b(c.this) != null) {
          c.b(c.this).drQ();
        }
        AppMethodBeat.o(123139);
      }
    };
    a.GpY.a(parama, Looper.myLooper());
    AppMethodBeat.o(123142);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(123144);
    release();
    super.finalize();
    AppMethodBeat.o(123144);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(123145);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.vZk != null)
      {
        this.vZk.drP();
        this.vZk = null;
      }
    }
    for (;;)
    {
      vZj = System.currentTimeMillis();
      AppMethodBeat.o(123145);
      return;
      if (this.vZk != null)
      {
        this.vZk.drQ();
        this.vZk = null;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(123143);
    com.tencent.mm.kernel.g.agQ().ghe.b(138, this);
    AppMethodBeat.o(123143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.c
 * JD-Core Version:    0.7.0.1
 */