package com.tencent.mm.plugin.sns.j;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.Vector;

public abstract class j
{
  private Vector<d> yet = new Vector();
  
  public final d b(d paramd)
  {
    this.yet.add(paramd);
    return paramd;
  }
  
  public final boolean c(d paramd)
  {
    Iterator localIterator = this.yet.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.hTM == paramd.hTM) {
        this.yet.remove(locald);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.yet.add(paramd);
      return bool;
    }
  }
  
  public final d dE(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Iterator localIterator = this.yet.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (paramObject.equals(locald.hTK))
        {
          this.yet.remove(locald);
          return locald;
        }
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.Ss_log_base_helper", "report by key " + localException.getMessage() + " " + paramObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.j
 * JD-Core Version:    0.7.0.1
 */