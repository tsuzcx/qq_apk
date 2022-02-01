package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.pb;
import com.tencent.mm.autogen.a.pb.b;

public final class c
  implements com.tencent.mm.am.h
{
  private static long NoY = 0L;
  private a NoZ;
  private Activity hHU;
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(123141);
    com.tencent.mm.kernel.h.baD().mCm.a(138, this);
    this.hHU = paramActivity;
    AppMethodBeat.o(123141);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(123142);
    this.NoZ = parama;
    parama = new pb();
    parama.hRT.hHU = this.hHU;
    parama.hRT.hRV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123139);
        if (parama.hRU.hCQ)
        {
          c.a(c.this);
          AppMethodBeat.o(123139);
          return;
        }
        if (c.b(c.this) != null) {
          c.b(c.this).gEg();
        }
        AppMethodBeat.o(123139);
      }
    };
    parama.asyncPublish(Looper.myLooper());
    AppMethodBeat.o(123142);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(123144);
    release();
    super.finalize();
    AppMethodBeat.o(123144);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(123145);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.NoZ != null)
      {
        this.NoZ.gEf();
        this.NoZ = null;
      }
    }
    for (;;)
    {
      NoY = System.currentTimeMillis();
      AppMethodBeat.o(123145);
      return;
      if (this.NoZ != null)
      {
        this.NoZ.gEg();
        this.NoZ = null;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(123143);
    com.tencent.mm.kernel.h.baD().mCm.b(138, this);
    AppMethodBeat.o(123143);
  }
  
  public static abstract class a
  {
    public abstract void gEf();
    
    public abstract void gEg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.c
 * JD-Core Version:    0.7.0.1
 */