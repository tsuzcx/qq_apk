package com.tencent.mm.plugin.sns.j;

import com.tencent.mm.modelsns.e;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.Vector;

public abstract class i
{
  private Vector<e> zLK = new Vector();
  
  public final e b(e parame)
  {
    this.zLK.add(parame);
    return parame;
  }
  
  public final boolean c(e parame)
  {
    Iterator localIterator = this.zLK.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (locale.iqb == parame.iqb) {
        this.zLK.remove(locale);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.zLK.add(parame);
      return bool;
    }
  }
  
  public final e dI(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Iterator localIterator = this.zLK.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramObject.equals(locale.ipZ))
        {
          this.zLK.remove(locale);
          return locale;
        }
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.Ss_log_base_helper", "report by key " + localException.getMessage() + " " + paramObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.i
 * JD-Core Version:    0.7.0.1
 */