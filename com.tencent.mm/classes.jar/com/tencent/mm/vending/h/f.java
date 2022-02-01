package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.a;

public class f
{
  private volatile d aguJ;
  private volatile a aguU;
  
  public f(d paramd, a parama)
  {
    AppMethodBeat.i(74921);
    c(paramd);
    this.aguU = parama;
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
        locald = this.aguJ;
        if (!(parama instanceof e)) {
          break label179;
        }
        e locale = (e)parama;
        if ("Vending.ANY".equals(locale.aKh())) {
          break label179;
        }
        locald = g.bDR(locale.aKh());
        if (locald == null)
        {
          if (this.aguU != null) {
            this.aguU.interrupt();
          }
          AppMethodBeat.o(177493);
          return;
        }
        parama = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74923);
            if (f.a(f.this) != null) {
              f.a(f.this).jJS();
            }
            try
            {
              Object localObject = parama.call(paramObject);
              if (f.a(f.this) != null) {
                f.a(f.this).gQ(localObject);
              }
              AppMethodBeat.o(74923);
              return;
            }
            catch (ClassCastException localClassCastException)
            {
              this.agve.initCause(localClassCastException);
              RuntimeException localRuntimeException = this.agve;
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
      this.aguJ = paramd;
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
    public abstract void gQ(Object paramObject);
    
    public abstract void interrupt();
    
    public abstract void jJS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vending.h.f
 * JD-Core Version:    0.7.0.1
 */