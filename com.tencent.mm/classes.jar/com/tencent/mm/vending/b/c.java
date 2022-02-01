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
  
  private void a(final com.tencent.mm.vending.j.a parama)
  {
    Iterator localIterator = getQueueImpl().iterator();
    while (localIterator.hasNext())
    {
      final b localb = (b)localIterator.next();
      if (localb != null)
      {
        if (localb.mScheduler != null) {
          this.mSchedulerInvoker.c(localb.mScheduler);
        }
        for (;;)
        {
          this.mSchedulerInvoker.a(new com.tencent.mm.vending.c.a() {}, com.tencent.mm.vending.c.a.aguz, true);
          break;
          this.mSchedulerInvoker.c(d.current());
        }
      }
    }
  }
  
  public abstract void a(_Callback param_Callback, com.tencent.mm.vending.j.a parama);
  
  public final b<_Callback> add(_Callback param_Callback)
  {
    return add(new b(param_Callback, this));
  }
  
  public final void invoke()
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
  
  public final void invoke(com.tencent.mm.vending.j.a parama)
  {
    try
    {
      a(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void remove(_Callback param_Callback)
  {
    remove(new b(param_Callback, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vending.b.c
 * JD-Core Version:    0.7.0.1
 */