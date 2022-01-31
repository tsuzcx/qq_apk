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
  
  private void b(com.tencent.mm.vending.j.a parama)
  {
    Iterator localIterator = dQk().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null)
      {
        if (localb.AOk != null) {
          this.AOi.c(localb.AOk);
        }
        for (;;)
        {
          this.AOi.a(new c.1(this, localb, parama), com.tencent.mm.vending.c.a.AOo, true);
          break;
          this.AOi.c(d.dQu());
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
  
  public final b<_Callback> at(_Callback param_Callback)
  {
    return a(new b(param_Callback, this));
  }
  
  public final void ate()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.vending.b.c
 * JD-Core Version:    0.7.0.1
 */