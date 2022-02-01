package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.a;

public final class f
{
  private volatile d LEC;
  volatile a LEN;
  
  public f(d paramd, a parama)
  {
    AppMethodBeat.i(74921);
    c(paramd);
    this.LEN = parama;
    AppMethodBeat.o(74921);
  }
  
  public final void a(final a parama, final Object paramObject, boolean paramBoolean)
  {
    label162:
    label179:
    for (;;)
    {
      d locald;
      try
      {
        AppMethodBeat.i(177493);
        locald = this.LEC;
        if (!(parama instanceof e)) {
          break label179;
        }
        e locale = (e)parama;
        if ("Vending.ANY".equals(locale.Wz())) {
          break label179;
        }
        locald = g.aZC(locale.Wz());
        if (locald == null)
        {
          if (this.LEN != null) {
            this.LEN.interrupt();
          }
          AppMethodBeat.o(177493);
          return;
        }
        parama = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74923);
            if (f.this.LEN != null) {
              f.this.LEN.fSy();
            }
            try
            {
              Object localObject = parama.call(paramObject);
              if (f.this.LEN != null) {
                f.this.LEN.ei(localObject);
              }
              AppMethodBeat.o(74923);
              return;
            }
            catch (ClassCastException localClassCastException)
            {
              this.LEY.initCause(localClassCastException);
              RuntimeException localRuntimeException = this.LEY;
              AppMethodBeat.o(74923);
              throw localRuntimeException;
            }
          }
        };
        if (-1L >= 0L) {
          break label162;
        }
        if ((paramBoolean) && (g.fSC() == locald))
        {
          parama.run();
          AppMethodBeat.o(177493);
          continue;
        }
        locald.u(parama);
      }
      finally {}
      AppMethodBeat.o(177493);
      continue;
      locald.g(parama, -1L);
      AppMethodBeat.o(177493);
    }
  }
  
  public final void c(d paramd)
  {
    try
    {
      this.LEC = paramd;
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public static abstract interface a
  {
    public abstract void ei(Object paramObject);
    
    public abstract void fSy();
    
    public abstract void interrupt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.f
 * JD-Core Version:    0.7.0.1
 */