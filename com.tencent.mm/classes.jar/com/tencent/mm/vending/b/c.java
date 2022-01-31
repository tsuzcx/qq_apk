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
  
  public final void a(com.tencent.mm.vending.j.a parama)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = cKT().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        b localb = (b)localIterator.next();
        if (localb != null) {
          if (localb.wtp != null)
          {
            this.wtn.b(localb.wtp);
            this.wtn.a(new c.1(this, localb, parama), com.tencent.mm.vending.c.a.wtt, true);
          }
          else
          {
            this.wtn.b(d.cLe());
          }
        }
      }
      finally {}
    }
  }
  
  public abstract void a(_Callback param_Callback, com.tencent.mm.vending.j.a parama);
  
  public final b<_Callback> aj(_Callback param_Callback)
  {
    return a(new b(param_Callback, this));
  }
  
  public final void cKU()
  {
    try
    {
      a(null);
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