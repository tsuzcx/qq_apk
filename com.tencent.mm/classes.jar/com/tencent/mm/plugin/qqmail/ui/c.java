package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.a.nb.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.EventCenter;

public final class c
  implements i
{
  private static long BwQ = 0L;
  private a BwR;
  private Activity dKq;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(123141);
    g.aAg().hqi.a(138, this);
    this.dKq = paramActivity;
    AppMethodBeat.o(123141);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(123142);
    this.BwR = parama;
    parama = new nb();
    parama.dSL.dKq = this.dKq;
    parama.dSL.dSN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123139);
        if (parama.dSM.dFE)
        {
          c.a(c.this);
          AppMethodBeat.o(123139);
          return;
        }
        if (c.b(c.this) != null) {
          c.b(c.this).eGu();
        }
        AppMethodBeat.o(123139);
      }
    };
    EventCenter.instance.asyncPublish(parama, Looper.myLooper());
    AppMethodBeat.o(123142);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(123144);
    release();
    super.finalize();
    AppMethodBeat.o(123144);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(123145);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.BwR != null)
      {
        this.BwR.eGt();
        this.BwR = null;
      }
    }
    for (;;)
    {
      BwQ = System.currentTimeMillis();
      AppMethodBeat.o(123145);
      return;
      if (this.BwR != null)
      {
        this.BwR.eGu();
        this.BwR = null;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(123143);
    g.aAg().hqi.b(138, this);
    AppMethodBeat.o(123143);
  }
  
  public static abstract class a
  {
    public abstract void eGt();
    
    public abstract void eGu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.c
 * JD-Core Version:    0.7.0.1
 */