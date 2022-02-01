package com.tencent.mm.plugin.sns.statistics;

import com.tencent.mm.modelsns.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Vector;

public abstract class n
{
  private Vector<l> QGZ = new Vector();
  
  public final l b(l paraml)
  {
    this.QGZ.add(paraml);
    return paraml;
  }
  
  public final boolean c(l paraml)
  {
    Iterator localIterator = this.QGZ.iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (locall.oUj == paraml.oUj) {
        this.QGZ.remove(locall);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.QGZ.add(paraml);
      return bool;
    }
  }
  
  public final l gr(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Iterator localIterator = this.QGZ.iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        if (paramObject.equals(locall.oUh))
        {
          this.QGZ.remove(locall);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.n
 * JD-Core Version:    0.7.0.1
 */