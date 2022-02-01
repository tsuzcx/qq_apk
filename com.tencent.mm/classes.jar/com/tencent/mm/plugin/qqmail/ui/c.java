package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.mk.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.l;

public final class c
  implements f
{
  private static long xwO = 0L;
  private Activity dtg;
  private a xwP;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(123141);
    g.ajQ().gDv.a(138, this);
    this.dtg = paramActivity;
    AppMethodBeat.o(123141);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(123142);
    this.xwP = parama;
    parama = new mk();
    parama.dAW.dtg = this.dtg;
    parama.dAW.dAY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123139);
        if (parama.dAX.doq)
        {
          c.a(c.this);
          AppMethodBeat.o(123139);
          return;
        }
        if (c.b(c.this) != null) {
          c.b(c.this).dFF();
        }
        AppMethodBeat.o(123139);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.a(parama, Looper.myLooper());
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
      if (this.xwP != null)
      {
        this.xwP.dFE();
        this.xwP = null;
      }
    }
    for (;;)
    {
      xwO = System.currentTimeMillis();
      AppMethodBeat.o(123145);
      return;
      if (this.xwP != null)
      {
        this.xwP.dFF();
        this.xwP = null;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(123143);
    g.ajQ().gDv.b(138, this);
    AppMethodBeat.o(123143);
  }
  
  public static abstract class a
  {
    public abstract void dFE();
    
    public abstract void dFF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.c
 * JD-Core Version:    0.7.0.1
 */