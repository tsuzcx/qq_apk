package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.a;

public class f
{
  private volatile d YAl;
  private volatile a YAw;
  
  public f(d paramd, a parama)
  {
    AppMethodBeat.i(74921);
    c(paramd);
    this.YAw = parama;
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
        locald = this.YAl;
        if (!(parama instanceof e)) {
          break label179;
        }
        e locale = (e)parama;
        if ("Vending.ANY".equals(locale.aqj())) {
          break label179;
        }
        locald = g.bBx(locale.aqj());
        if (locald == null)
        {
          if (this.YAw != null) {
            this.YAw.interrupt();
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
              f.a(f.this).ieL();
            }
            try
            {
              Object localObject = parama.call(paramObject);
              if (f.a(f.this) != null) {
                f.a(f.this).es(localObject);
              }
              AppMethodBeat.o(74923);
              return;
            }
            catch (ClassCastException localClassCastException)
            {
              this.YAH.initCause(localClassCastException);
              RuntimeException localRuntimeException = this.YAH;
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
      this.YAl = paramd;
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
    public abstract void es(Object paramObject);
    
    public abstract void ieL();
    
    public abstract void interrupt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.h.f
 * JD-Core Version:    0.7.0.1
 */