package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.a;

public final class f
{
  private volatile d AOZ;
  volatile a APa;
  
  public f(d paramd, a parama)
  {
    AppMethodBeat.i(126124);
    c(paramd);
    this.APa = parama;
    AppMethodBeat.o(126124);
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
        AppMethodBeat.i(126125);
        locald = this.AOZ;
        if (!(parama instanceof e)) {
          break label179;
        }
        e locale = (e)parama;
        if ("Vending.ANY".equals(locale.HY())) {
          break label179;
        }
        locald = g.avD(locale.HY());
        if (locald == null)
        {
          if (this.APa != null) {
            this.APa.interrupt();
          }
          AppMethodBeat.o(126125);
          return;
        }
        parama = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(126126);
            if (f.this.APa != null) {
              f.this.APa.dQp();
            }
            try
            {
              Object localObject = parama.call(paramObject);
              if (f.this.APa != null) {
                f.this.APa.cM(localObject);
              }
              AppMethodBeat.o(126126);
              return;
            }
            catch (ClassCastException localClassCastException)
            {
              this.AOK.initCause(localClassCastException);
              RuntimeException localRuntimeException = this.AOK;
              AppMethodBeat.o(126126);
              throw localRuntimeException;
            }
          }
        };
        if (-1L >= 0L) {
          break label162;
        }
        if ((paramBoolean) && (g.dQu() == locald))
        {
          parama.run();
          AppMethodBeat.o(126125);
          continue;
        }
        locald.o(parama);
      }
      finally {}
      AppMethodBeat.o(126125);
      continue;
      locald.n(parama, -1L);
      AppMethodBeat.o(126125);
    }
  }
  
  public final void c(d paramd)
  {
    try
    {
      this.AOZ = paramd;
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
    public abstract void cM(Object paramObject);
    
    public abstract void dQp();
    
    public abstract void interrupt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.f
 * JD-Core Version:    0.7.0.1
 */