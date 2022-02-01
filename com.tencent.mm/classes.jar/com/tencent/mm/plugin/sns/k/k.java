package com.tencent.mm.plugin.sns.k;

import com.tencent.mm.modelsns.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Vector;

public abstract class k
{
  private Vector<l> Kjc = new Vector();
  
  public final l b(l paraml)
  {
    this.Kjc.add(paraml);
    return paraml;
  }
  
  public final boolean c(l paraml)
  {
    Iterator localIterator = this.Kjc.iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (locall.mbp == paraml.mbp) {
        this.Kjc.remove(locall);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.Kjc.add(paraml);
      return bool;
    }
  }
  
  public final l dU(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Iterator localIterator = this.Kjc.iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        if (paramObject.equals(locall.mbn))
        {
          this.Kjc.remove(locall);
          return locall;
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Ss_log_base_helper", "report by key " + localException.getMessage() + " " + paramObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.k
 * JD-Core Version:    0.7.0.1
 */