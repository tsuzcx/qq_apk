package com.tencent.mm.vending.g;

import com.tencent.mm.vending.c.a;

public final class f
{
  private volatile d aad;
  private volatile g aae;
  
  public f(d paramd)
  {
    a(paramd);
    this.aae = null;
  }
  
  private void a(final a parama, final Object paramObject, long paramLong, boolean paramBoolean)
  {
    label146:
    label158:
    for (;;)
    {
      d locald;
      try
      {
        locald = this.aad;
        if (!(parama instanceof e)) {
          break label158;
        }
        e locale = (e)parama;
        if ("Vending.ANY".equals(locale.lH())) {
          break label158;
        }
        locald = h.F(locale.lH());
        if (locald == null)
        {
          if (this.aae != null) {
            parama = this.aae;
          }
          return;
        }
        parama = new Runnable()
        {
          public final void run()
          {
            if (f.a(f.this) != null) {
              f.a(f.this);
            }
            try
            {
              parama.O(paramObject);
              if (f.a(f.this) != null) {
                f.a(f.this);
              }
              return;
            }
            catch (ClassCastException localClassCastException)
            {
              this.aag.initCause(localClassCastException);
              throw this.aag;
            }
          }
        };
        if (-1L >= 0L) {
          break label146;
        }
        if ((paramBoolean) && (h.lG() == locald))
        {
          parama.run();
          continue;
        }
        locald.b(parama);
      }
      finally {}
      continue;
      locald.a(parama, -1L);
    }
  }
  
  private void b(d paramd)
  {
    try
    {
      this.aad = paramd;
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final void a(a parama, Object paramObject, boolean paramBoolean)
  {
    a(parama, paramObject, -1L, true);
  }
  
  public final void a(d paramd)
  {
    try
    {
      b(paramd);
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
 * Qualified Name:     com.tencent.mm.vending.g.f
 * JD-Core Version:    0.7.0.1
 */