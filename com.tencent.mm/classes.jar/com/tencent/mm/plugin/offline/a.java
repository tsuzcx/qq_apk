package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T>
{
  protected List<WeakReference<T>> uix = new ArrayList();
  
  public final void dy(T paramT)
  {
    if (this.uix != null) {
      this.uix = new ArrayList();
    }
    this.uix.add(new WeakReference(paramT));
  }
  
  public final void dz(T paramT)
  {
    if (this.uix == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.uix.size())
      {
        WeakReference localWeakReference = (WeakReference)this.uix.get(i);
        if (localWeakReference != null)
        {
          Object localObject = localWeakReference.get();
          if ((localObject != null) && (localObject.equals(paramT)))
          {
            localWeakReference.clear();
            this.uix.remove(localWeakReference);
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