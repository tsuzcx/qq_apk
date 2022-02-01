package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T>
{
  protected List<WeakReference<T>> vrt = new ArrayList();
  
  public final void dA(T paramT)
  {
    if (this.vrt == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.vrt.size())
      {
        WeakReference localWeakReference = (WeakReference)this.vrt.get(i);
        if (localWeakReference != null)
        {
          Object localObject = localWeakReference.get();
          if ((localObject != null) && (localObject.equals(paramT)))
          {
            localWeakReference.clear();
            this.vrt.remove(localWeakReference);
          }
        }
        i += 1;
      }
    }
  }
  
  public final void dz(T paramT)
  {
    if (this.vrt != null) {
      this.vrt = new ArrayList();
    }
    this.vrt.add(new WeakReference(paramT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a
 * JD-Core Version:    0.7.0.1
 */