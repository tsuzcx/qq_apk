package com.tencent.mm.plugin.sns.j;

import com.tencent.mm.modelsns.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Vector;

public abstract class i
{
  private Vector<e> zut = new Vector();
  
  public final e b(e parame)
  {
    this.zut.add(parame);
    return parame;
  }
  
  public final boolean c(e parame)
  {
    Iterator localIterator = this.zut.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (locale.inh == parame.inh) {
        this.zut.remove(locale);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.zut.add(parame);
      return bool;
    }
  }
  
  public final e dH(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Iterator localIterator = this.zut.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramObject.equals(locale.inf))
        {
          this.zut.remove(locale);
          return locale;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.j.i
 * JD-Core Version:    0.7.0.1
 */