package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.g.a.lr.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.k;

public final class c
  implements com.tencent.mm.al.g
{
  private static long uQt = 0L;
  private Activity djj;
  private a uQu;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(123141);
    com.tencent.mm.kernel.g.afA().gcy.a(138, this);
    this.djj = paramActivity;
    AppMethodBeat.o(123141);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(123142);
    this.uQu = parama;
    parama = new lr();
    parama.dqs.djj = this.djj;
    parama.dqs.dqu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123139);
        if (parama.dqt.dew)
        {
          c.a(c.this);
          AppMethodBeat.o(123139);
          return;
        }
        if (c.b(c.this) != null) {
          c.b(c.this).dei();
        }
        AppMethodBeat.o(123139);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.a(parama, Looper.myLooper());
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
      if (this.uQu != null)
      {
        this.uQu.deh();
        this.uQu = null;
      }
    }
    for (;;)
    {
      uQt = System.currentTimeMillis();
      AppMethodBeat.o(123145);
      return;
      if (this.uQu != null)
      {
        this.uQu.dei();
        this.uQu = null;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(123143);
    com.tencent.mm.kernel.g.afA().gcy.b(138, this);
    AppMethodBeat.o(123143);
  }
  
  public static abstract class a
  {
    public abstract void deh();
    
    public abstract void dei();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.c
 * JD-Core Version:    0.7.0.1
 */