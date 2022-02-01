package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T>
{
  protected List<WeakReference<T>> Mxv = new ArrayList();
  
  public final void gj(T paramT)
  {
    if (this.Mxv != null) {
      this.Mxv = new ArrayList();
    }
    this.Mxv.add(new WeakReference(paramT));
  }
  
  public final void gk(T paramT)
  {
    if (this.Mxv == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.Mxv.size())
      {
        WeakReference localWeakReference = (WeakReference)this.Mxv.get(i);
        if (localWeakReference != null)
        {
          Object localObject = localWeakReference.get();
          if ((localObject != null) && (localObject.equals(paramT)))
          {
            localWeakReference.clear();
            this.Mxv.remove(localWeakReference);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a
 * JD-Core Version:    0.7.0.1
 */