package com.tencent.mm.plugin.sns.i;

import com.tencent.mm.modelsns.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Vector;

public abstract class i
{
  private Vector<b> rpa = new Vector();
  
  public final b b(b paramb)
  {
    this.rpa.add(paramb);
    return paramb;
  }
  
  public final boolean c(b paramb)
  {
    Iterator localIterator = this.rpa.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.fQD == paramb.fQD) {
        this.rpa.remove(localb);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.rpa.add(paramb);
      return bool;
    }
  }
  
  public final b ch(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Iterator localIterator = this.rpa.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (paramObject.equals(localb.fQB))
        {
          this.rpa.remove(localb);
          return localb;
        }
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Ss_log_base_helper", "report by key " + localException.getMessage() + " " + paramObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.i
 * JD-Core Version:    0.7.0.1
 */