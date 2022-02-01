package com.tencent.mm.plugin.sns.k;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Vector;

public abstract class j
{
  private Vector<d> wRN = new Vector();
  
  public final d b(d paramd)
  {
    this.wRN.add(paramd);
    return paramd;
  }
  
  public final boolean c(d paramd)
  {
    Iterator localIterator = this.wRN.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.htk == paramd.htk) {
        this.wRN.remove(locald);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.wRN.add(paramd);
      return bool;
    }
  }
  
  public final d dD(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Iterator localIterator = this.wRN.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (paramObject.equals(locald.hti))
        {
          this.wRN.remove(locald);
          return locald;
        }
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Ss_log_base_helper", "report by key " + localException.getMessage() + " " + paramObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.j
 * JD-Core Version:    0.7.0.1
 */