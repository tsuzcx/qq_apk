package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.g.a.mj.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.l;

public final class c
  implements f
{
  private static long xgW = 0L;
  private Activity dsa;
  private a xgX;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(123141);
    g.ajB().gAO.a(138, this);
    this.dsa = paramActivity;
    AppMethodBeat.o(123141);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(123142);
    this.xgX = parama;
    parama = new mj();
    parama.dzR.dsa = this.dsa;
    parama.dzR.dzT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123139);
        if (parama.dzS.dno)
        {
          c.a(c.this);
          AppMethodBeat.o(123139);
          return;
        }
        if (c.b(c.this) != null) {
          c.b(c.this).dCo();
        }
        AppMethodBeat.o(123139);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.a(parama, Looper.myLooper());
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
      if (this.xgX != null)
      {
        this.xgX.dCn();
        this.xgX = null;
      }
    }
    for (;;)
    {
      xgW = System.currentTimeMillis();
      AppMethodBeat.o(123145);
      return;
      if (this.xgX != null)
      {
        this.xgX.dCo();
        this.xgX = null;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(123143);
    g.ajB().gAO.b(138, this);
    AppMethodBeat.o(123143);
  }
  
  public static abstract class a
  {
    public abstract void dCn();
    
    public abstract void dCo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.c
 * JD-Core Version:    0.7.0.1
 */