package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T>
{
  protected List<WeakReference<T>> wwL = new ArrayList();
  
  public final void dC(T paramT)
  {
    if (this.wwL != null) {
      this.wwL = new ArrayList();
    }
    this.wwL.add(new WeakReference(paramT));
  }
  
  public final void dD(T paramT)
  {
    if (this.wwL == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.wwL.size())
      {
        WeakReference localWeakReference = (WeakReference)this.wwL.get(i);
        if (localWeakReference != null)
        {
          Object localObject = localWeakReference.get();
          if ((localObject != null) && (localObject.equals(paramT)))
          {
            localWeakReference.clear();
            this.wwL.remove(localWeakReference);
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