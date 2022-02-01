package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T>
{
  protected List<WeakReference<T>> GBm = new ArrayList();
  
  public final void dP(T paramT)
  {
    if (this.GBm != null) {
      this.GBm = new ArrayList();
    }
    this.GBm.add(new WeakReference(paramT));
  }
  
  public final void dQ(T paramT)
  {
    if (this.GBm == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.GBm.size())
      {
        WeakReference localWeakReference = (WeakReference)this.GBm.get(i);
        if (localWeakReference != null)
        {
          Object localObject = localWeakReference.get();
          if ((localObject != null) && (localObject.equals(paramT)))
          {
            localWeakReference.clear();
            this.GBm.remove(localWeakReference);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a
 * JD-Core Version:    0.7.0.1
 */