package com.tencent.mm.vending.b;

import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.f;
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
  
  public final b<_Callback> N(_Callback param_Callback)
  {
    return a(new b(param_Callback, this));
  }
  
  public final void a(final com.tencent.mm.vending.i.a parama)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = lD().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        final b localb = (b)localIterator.next();
        if (localb != null) {
          if (localb.lE() != null)
          {
            this.ZM.a(localb.lE());
            this.ZM.a(new com.tencent.mm.vending.c.a() {}, com.tencent.mm.vending.c.a.ZV, true);
          }
          else
          {
            this.ZM.a(d.lG());
          }
        }
      }
      finally {}
    }
  }
  
  public abstract void a(_Callback param_Callback, com.tencent.mm.vending.i.a parama);
  
  public final void lF()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.b.c
 * JD-Core Version:    0.7.0.1
 */