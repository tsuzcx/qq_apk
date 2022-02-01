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
    Iterator localIterator = ml().iterator();
    while (localIterator.hasNext())
    {
      final b localb = (b)localIterator.next();
      if (localb != null)
      {
        if (localb.mm() != null) {
          this.adm.a(localb.mm());
        }
        for (;;)
        {
          this.adm.a(new com.tencent.mm.vending.c.a() {}, com.tencent.mm.vending.c.a.adv);
          break;
          this.adm.a(d.mt());
        }
      }
    }
  }
  
  public final b<_Callback> W(_Callback param_Callback)
  {
    return a(new b(param_Callback, this));
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
  
  public final void mn()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.b.c
 * JD-Core Version:    0.7.0.1
 */