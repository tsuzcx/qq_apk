package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T>
{
  protected List<WeakReference<T>> AIc = new ArrayList();
  
  public final void dM(T paramT)
  {
    if (this.AIc != null) {
      this.AIc = new ArrayList();
    }
    this.AIc.add(new WeakReference(paramT));
  }
  
  public final void dN(T paramT)
  {
    if (this.AIc == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.AIc.size())
      {
        WeakReference localWeakReference = (WeakReference)this.AIc.get(i);
        if (localWeakReference != null)
        {
          Object localObject = localWeakReference.get();
          if ((localObject != null) && (localObject.equals(paramT)))
          {
            localWeakReference.clear();
            this.AIc.remove(localWeakReference);
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