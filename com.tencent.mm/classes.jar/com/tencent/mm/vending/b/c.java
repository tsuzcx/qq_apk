package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class c<_Callback>
  extends a<_Callback>
{
  public c() {}
  
  public c(d paramd)
  {
    super(paramd);
  }
  
  private void b(final com.tencent.mm.vending.j.a parama)
  {
    Iterator localIterator = fSs().iterator();
    while (localIterator.hasNext())
    {
      final b localb = (b)localIterator.next();
      if (localb != null)
      {
        if (localb.cUP != null) {
          this.LEl.c(localb.cUP);
        }
        for (;;)
        {
          this.LEl.a(new com.tencent.mm.vending.c.a() {}, com.tencent.mm.vending.c.a.LEs, true);
          break;
          this.LEl.c(d.fSC());
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.vending.j.a parama)
  {
    try
    {
      b(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public abstract void a(_Callback param_Callback, com.tencent.mm.vending.j.a parama);
  
  public final b<_Callback> bu(_Callback param_Callback)
  {
    return a(new b(param_Callback, this));
  }
  
  public final void invoke()
  {
    try
    {
      b(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void remove(_Callback param_Callback)
  {
    b(new b(param_Callback, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.b.c
 * JD-Core Version:    0.7.0.1
 */