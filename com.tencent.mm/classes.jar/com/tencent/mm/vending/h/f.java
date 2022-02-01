package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.a;

public final class f
{
  private volatile d Lia;
  volatile a Lil;
  
  public f(d paramd, a parama)
  {
    AppMethodBeat.i(74921);
    c(paramd);
    this.Lil = parama;
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
        locald = this.Lia;
        if (!(parama instanceof e)) {
          break label179;
        }
        e locale = (e)parama;
        if ("Vending.ANY".equals(locale.Wr())) {
          break label179;
        }
        locald = g.aYa(locale.Wr());
        if (locald == null)
        {
          if (this.Lil != null) {
            this.Lil.interrupt();
          }
          AppMethodBeat.o(177493);
          return;
        }
        parama = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74923);
            if (f.this.Lil != null) {
              f.this.Lil.fOd();
            }
            try
            {
              Object localObject = parama.call(paramObject);
              if (f.this.Lil != null) {
                f.this.Lil.eh(localObject);
              }
              AppMethodBeat.o(74923);
              return;
            }
            catch (ClassCastException localClassCastException)
            {
              this.Liw.initCause(localClassCastException);
              RuntimeException localRuntimeException = this.Liw;
              AppMethodBeat.o(74923);
              throw localRuntimeException;
            }
          }
        };
        if (-1L >= 0L) {
          break label162;
        }
        if ((paramBoolean) && (g.fOh() == locald))
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
      locald.g(parama, -1L);
      AppMethodBeat.o(177493);
    }
  }
  
  public final void c(d paramd)
  {
    try
    {
      this.Lia = paramd;
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
    public abstract void eh(Object paramObject);
    
    public abstract void fOd();
    
    public abstract void interrupt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.f
 * JD-Core Version:    0.7.0.1
 */