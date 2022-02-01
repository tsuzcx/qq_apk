package com.tencent.mm.vending.h;

import com.tencent.mm.vending.c.a;

public final class f
{
  private volatile d adE;
  private volatile g adF;
  
  public f(d paramd)
  {
    a(paramd);
    this.adF = null;
  }
  
  private void a(final a parama, final Object paramObject, long paramLong, boolean paramBoolean)
  {
    label139:
    label151:
    for (;;)
    {
      d locald;
      try
      {
        locald = this.adE;
        if (!(parama instanceof e)) {
          break label151;
        }
        e locale = (e)parama;
        if ("Vending.ANY".equals(locale.mu())) {
          break label151;
        }
        locald = h.J(locale.mu());
        if (locald == null)
        {
          if (this.adF != null) {
            parama = this.adF;
          }
          return;
        }
        parama = new Runnable()
        {
          public final void run()
          {
            try
            {
              parama.X(paramObject);
              return;
            }
            catch (ClassCastException localClassCastException)
            {
              this.adH.initCause(localClassCastException);
              throw this.adH;
            }
          }
        };
        if (-1L >= 0L) {
          break label139;
        }
        if ((paramBoolean) && (h.mt() == locald))
        {
          parama.run();
          continue;
        }
        locald.d(parama);
      }
      finally {}
      continue;
      locald.a(parama, -1L);
    }
  }
  
  public final void a(a parama, Object paramObject)
  {
    a(parama, paramObject, -1L, true);
  }
  
  public final void a(d paramd)
  {
    try
    {
      this.adE = paramd;
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.f
 * JD-Core Version:    0.7.0.1
 */