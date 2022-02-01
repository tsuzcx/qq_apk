package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T>
{
  protected List<WeakReference<T>> wMw = new ArrayList();
  
  public final void dD(T paramT)
  {
    if (this.wMw != null) {
      this.wMw = new ArrayList();
    }
    this.wMw.add(new WeakReference(paramT));
  }
  
  public final void dE(T paramT)
  {
    if (this.wMw == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.wMw.size())
      {
        WeakReference localWeakReference = (WeakReference)this.wMw.get(i);
        if (localWeakReference != null)
        {
          Object localObject = localWeakReference.get();
          if ((localObject != null) && (localObject.equals(paramT)))
          {
            localWeakReference.clear();
            this.wMw.remove(localWeakReference);
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