package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.a;

public final class f
{
  private volatile d QZV;
  volatile a Rag;
  
  public f(d paramd, a parama)
  {
    AppMethodBeat.i(74921);
    c(paramd);
    this.Rag = parama;
    AppMethodBeat.o(74921);
  }
  
  public void a(final a parama, final Object paramObject, boolean paramBoolean)
  {
    label162:
    label179:
    for (;;)
    {
      d locald;
      try
      {
        AppMethodBeat.i(177493);
        locald = this.QZV;
        if (!(parama instanceof e)) {
          break label179;
        }
        e locale = (e)parama;
        if ("Vending.ANY".equals(locale.akn())) {
          break label179;
        }
        locald = g.boH(locale.akn());
        if (locald == null)
        {
          if (this.Rag != null) {
            this.Rag.interrupt();
          }
          AppMethodBeat.o(177493);
          return;
        }
        parama = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74923);
            if (f.this.Rag != null) {
              f.this.Rag.hdE();
            }
            try
            {
              Object localObject = parama.call(paramObject);
              if (f.this.Rag != null) {
                f.this.Rag.em(localObject);
              }
              AppMethodBeat.o(74923);
              return;
            }
            catch (ClassCastException localClassCastException)
            {
              this.Rar.initCause(localClassCastException);
              RuntimeException localRuntimeException = this.Rar;
              AppMethodBeat.o(74923);
              throw localRuntimeException;
            }
          }
        };
        if (-1L >= 0L) {
          break label162;
        }
        if ((paramBoolean) && (g.current() == locald))
        {
          parama.run();
          AppMethodBeat.o(177493);
          continue;
        }
        locald.arrange(parama);
      }
      finally {}
      AppMethodBeat.o(177493);
      continue;
      locald.arrangeInterval(parama, -1L);
      AppMethodBeat.o(177493);
    }
  }
  
  public final void c(d paramd)
  {
    try
    {
      this.QZV = paramd;
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
    public abstract void em(Object paramObject);
    
    public abstract void hdE();
    
    public abstract void interrupt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.f
 * JD-Core Version:    0.7.0.1
 */