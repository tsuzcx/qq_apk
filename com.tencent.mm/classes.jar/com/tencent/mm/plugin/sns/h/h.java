package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.modelsns.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Vector;

public abstract class h
{
  private Vector<b> ozQ = new Vector();
  
  public final b b(b paramb)
  {
    this.ozQ.add(paramb);
    return paramb;
  }
  
  public final b bD(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Iterator localIterator = this.ozQ.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (paramObject.equals(localb.eAI))
        {
          this.ozQ.remove(localb);
          return localb;
        }
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Ss_log_base_helper", "report by key " + localException.getMessage() + " " + paramObject);
    }
    return null;
  }
  
  public final boolean c(b paramb)
  {
    Iterator localIterator = this.ozQ.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.eAK == paramb.eAK) {
        this.ozQ.remove(localb);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.ozQ.add(paramb);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.h
 * JD-Core Version:    0.7.0.1
 */