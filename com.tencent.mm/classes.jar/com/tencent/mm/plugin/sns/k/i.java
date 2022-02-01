package com.tencent.mm.plugin.sns.k;

import com.tencent.mm.modelsns.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Vector;

public abstract class i
{
  private Vector<k> DVS = new Vector();
  
  public final k b(k paramk)
  {
    this.DVS.add(paramk);
    return paramk;
  }
  
  public final boolean c(k paramk)
  {
    Iterator localIterator = this.DVS.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.jlm == paramk.jlm) {
        this.DVS.remove(localk);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.DVS.add(paramk);
      return bool;
    }
  }
  
  public final k dR(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Iterator localIterator = this.DVS.iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if (paramObject.equals(localk.jlk))
        {
          this.DVS.remove(localk);
          return localk;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.i
 * JD-Core Version:    0.7.0.1
 */