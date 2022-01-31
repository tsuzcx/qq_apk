package com.tencent.mm.vending.h;

import com.tencent.mm.vending.c.a;

public final class f
{
  private volatile d wub;
  volatile a wuc;
  
  public f(d paramd, a parama)
  {
    b(paramd);
    this.wuc = parama;
  }
  
  private void c(d paramd)
  {
    try
    {
      this.wub = paramd;
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public void a(final a parama, final Object paramObject, boolean paramBoolean)
  {
    label149:
    label161:
    for (;;)
    {
      d locald;
      try
      {
        locald = this.wub;
        if (!(parama instanceof e)) {
          break label161;
        }
        e locale = (e)parama;
        if ("Vending.ANY".equals(locale.vP())) {
          break label161;
        }
        locald = g.aeL(locale.vP());
        if (locald == null)
        {
          if (this.wuc != null) {
            this.wuc.interrupt();
          }
          return;
        }
        parama = new Runnable()
        {
          public final void run()
          {
            if (f.this.wuc != null) {
              f.this.wuc.cKZ();
            }
            try
            {
              Object localObject = parama.call(paramObject);
              if (f.this.wuc != null) {
                f.this.wuc.ch(localObject);
              }
              return;
            }
            catch (ClassCastException localClassCastException)
            {
              this.wtM.initCause(localClassCastException);
              throw this.wtM;
            }
          }
        };
        if (-1L >= 0L) {
          break label149;
        }
        if ((paramBoolean) && (g.cLe() == locald))
        {
          parama.run();
          continue;
        }
        locald.k(parama);
      }
      finally {}
      continue;
      locald.j(parama, -1L);
    }
  }
  
  public final void b(d paramd)
  {
    try
    {
      c(paramd);
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
    public abstract void cKZ();
    
    public abstract void ch(Object paramObject);
    
    public abstract void interrupt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.f
 * JD-Core Version:    0.7.0.1
 */