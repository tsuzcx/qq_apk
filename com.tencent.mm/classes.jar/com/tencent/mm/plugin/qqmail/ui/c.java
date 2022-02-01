package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.nt;
import com.tencent.mm.f.a.nt.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.qqmail.a.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.event.EventCenter;

public final class c
  implements i
{
  private static long Hrl = 0L;
  private a Hrm;
  private Activity fDf;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(123141);
    h.aHF().kcd.a(138, this);
    this.fDf = paramActivity;
    AppMethodBeat.o(123141);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(123142);
    this.Hrm = parama;
    parama = new nt();
    parama.fMj.fDf = this.fDf;
    parama.fMj.fMl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123139);
        if (parama.fMk.fyl)
        {
          c.a(c.this);
          AppMethodBeat.o(123139);
          return;
        }
        if (c.b(c.this) != null) {
          c.b(c.this).fsy();
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
      if (this.Hrm != null)
      {
        this.Hrm.fsx();
        this.Hrm = null;
      }
    }
    for (;;)
    {
      Hrl = System.currentTimeMillis();
      AppMethodBeat.o(123145);
      return;
      if (this.Hrm != null)
      {
        this.Hrm.fsy();
        this.Hrm = null;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(123143);
    h.aHF().kcd.b(138, this);
    AppMethodBeat.o(123143);
  }
  
  public static abstract class a
  {
    public abstract void fsx();
    
    public abstract void fsy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.c
 * JD-Core Version:    0.7.0.1
 */