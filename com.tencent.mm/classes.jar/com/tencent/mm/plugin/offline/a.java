package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T>
{
  protected List<WeakReference<T>> pjT = new ArrayList();
  
  public final void ce(T paramT)
  {
    if (this.pjT != null) {
      this.pjT = new ArrayList();
    }
    this.pjT.add(new WeakReference(paramT));
  }
  
  public final void cf(T paramT)
  {
    if (this.pjT == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.pjT.size())
      {
        WeakReference localWeakReference = (WeakReference)this.pjT.get(i);
        if (localWeakReference != null)
        {
          Object localObject = localWeakReference.get();
          if ((localObject != null) && (localObject.equals(paramT)))
          {
            localWeakReference.clear();
            this.pjT.remove(localWeakReference);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a
 * JD-Core Version:    0.7.0.1
 */