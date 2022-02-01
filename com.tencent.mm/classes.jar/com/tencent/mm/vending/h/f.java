package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.a;

public final class f
{
  volatile a JqG;
  private volatile d Jqv;
  
  public f(d paramd, a parama)
  {
    AppMethodBeat.i(74921);
    c(paramd);
    this.JqG = parama;
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
        locald = this.Jqv;
        if (!(parama instanceof e)) {
          break label179;
        }
        e locale = (e)parama;
        if ("Vending.ANY".equals(locale.Ua())) {
          break label179;
        }
        locald = g.aSb(locale.Ua());
        if (locald == null)
        {
          if (this.JqG != null) {
            this.JqG.interrupt();
          }
          AppMethodBeat.o(177493);
          return;
        }
        parama = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74923);
            if (f.this.JqG != null) {
              f.this.JqG.fxq();
            }
            try
            {
              Object localObject = parama.call(paramObject);
              if (f.this.JqG != null) {
                f.this.JqG.ee(localObject);
              }
              AppMethodBeat.o(74923);
              return;
            }
            catch (ClassCastException localClassCastException)
            {
              this.JqR.initCause(localClassCastException);
              RuntimeException localRuntimeException = this.JqR;
              AppMethodBeat.o(74923);
              throw localRuntimeException;
            }
          }
        };
        if (-1L >= 0L) {
          break label162;
        }
        if ((paramBoolean) && (g.fxu() == locald))
        {
          parama.run();
          AppMethodBeat.o(177493);
          continue;
        }
        locald.w(parama);
      }
      finally {}
      AppMethodBeat.o(177493);
      continue;
      locald.f(parama, -1L);
      AppMethodBeat.o(177493);
    }
  }
  
  public final void c(d paramd)
  {
    try
    {
      this.Jqv = paramd;
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
    public abstract void ee(Object paramObject);
    
    public abstract void fxq();
    
    public abstract void interrupt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.f
 * JD-Core Version:    0.7.0.1
 */